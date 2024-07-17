package com.arndew.badrespawn.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.world.World;

public class GhostEntity extends HostileEntity {
    public GhostEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 2048.0f));
        this.targetSelector.add(1, new CustomTargetGoal(this));
    }

    public static DefaultAttributeContainer.Builder createGhostAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 0.7)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 2048.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 5.0)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 80.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5)
                .add(EntityAttributes.GENERIC_GRAVITY, 0.07);
    }

    @Override
    public boolean canWalkOnFluid(FluidState state) {
        return state.isIn(FluidTags.WATER) || state.isIn(FluidTags.LAVA);
    }

    static class CustomTargetGoal extends Goal {
        private final GhostEntity ghost;
        private final TargetPredicate PLAYERS_IN_RANGE_PREDICATE = TargetPredicate.createAttackable().setBaseMaxDistance(2048.0f).ignoreVisibility();

        CustomTargetGoal(GhostEntity ghost) {
            this.ghost = ghost;
        }

        @Override
        public boolean canStart() {
            PlayerEntity targetPlayer = this.ghost.getWorld().getClosestPlayer(this.PLAYERS_IN_RANGE_PREDICATE, this.ghost);
            this.ghost.setTarget(targetPlayer);
            return targetPlayer != null;
        }
    }
}
