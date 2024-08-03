package com.arndew.badrespawn.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import java.util.*;

public class GhostEntity extends HostileEntity {
    private final List<UUID> handUuids = new ArrayList<>();
    public ArrayList<GhostHandEntity> ownedHands = new ArrayList<>();
    private static final TrackedData<Boolean> CHASING = DataTracker.registerData(GhostEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Long> LAST_STATE_TICK = DataTracker.registerData(GhostEntity.class, TrackedDataHandlerRegistry.LONG);

    public boolean handsLoaded = false;

    public final AnimationState idlingAnimationState =  new AnimationState();
    public final AnimationState chasingAnimationState =  new AnimationState();
    public final AnimationState chasingTransitionAnimationState = new AnimationState();

    public GhostEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f;
        if (this.getPose() == EntityPose.STANDING) {
            f = Math.min(posDelta * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.updateAnimations();
        } else {
            if (!handsLoaded) {
                Objects.requireNonNull(this.getServer()).execute(this::loadHands);
                handsLoaded = true;
            }
        }
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(CHASING, false);
        builder.add(LAST_STATE_TICK, 0L);
    }

    public void setLastStateTick(long lastStateTick) {
        this.dataTracker.set(LAST_STATE_TICK, lastStateTick);
    }

    public void setChasing(boolean chasing) {
        this.dataTracker.set(CHASING, chasing);
        this.setLastStateTick(this.getWorld().getTime());
    }

    public boolean isChasing() {
        return this.dataTracker.get(CHASING);
    }

    public boolean shouldTransitionToChase() {
        return getLastTickDelta() < 50L && isChasing();
    }

    private void updateAnimations() {
        if (!this.isChasing()) {
            chasingAnimationState.stop();
            this.idlingAnimationState.startIfNotRunning(this.age);
        } else {
            this.idlingAnimationState.stop();
        }

        if (shouldTransitionToChase()) {
            chasingTransitionAnimationState.startIfNotRunning(this.age);
        } else {
            chasingTransitionAnimationState.stop();
            chasingAnimationState.startIfNotRunning(this.age);
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);

        handsLoaded = false;

        NbtList ghostHandsList = new NbtList();

        for (GhostHandEntity ghostHand : ownedHands) {
            NbtCompound ghostHandNbt = new NbtCompound();
            ghostHandNbt.putUuid("UUID", ghostHand.getUuid());
            ghostHandsList.add(ghostHandNbt);
        }
        nbt.put("OwnedHands", ghostHandsList);
    }


    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);

        handUuids.clear();
        ownedHands.clear();

        NbtList handsNbtList = nbt.getList("OwnedHands", NbtElement.COMPOUND_TYPE);
        for (int i = 0; i < handsNbtList.size(); i++) {
            NbtCompound handNbt = handsNbtList.getCompound(i);
            UUID handUuid = handNbt.getUuid("UUID");
            handUuids.add(handUuid);
        }
    }

    public void loadHands() {
        Iterable<ServerWorld> serverWorld = Objects.requireNonNull(this.getServer()).getWorlds();
        for (ServerWorld world : serverWorld) {
            for (UUID handUUid : handUuids) {
                GhostHandEntity ghostHand = (GhostHandEntity) world.getEntity(handUUid);
                if (ghostHand != null) {
                    ownedHands.add(ghostHand);
                    ghostHand.setOwner(this);
                }
            }
        }
    }

    private long getLastTickDelta() {
        return this.getWorld().getTime() - Math.abs(this.dataTracker.get(LAST_STATE_TICK));
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.add(3, new SummonHandsGoal(this));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 2048.0f));
        this.targetSelector.add(1, new CustomTargetGoal(this));
    }

    public static DefaultAttributeContainer.Builder createGhostAttributes() {
        return FlyingEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 0.7)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 2048.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 5.0)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 80.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4)
                .add(EntityAttributes.GENERIC_GRAVITY, 0.07);
    }

    @Override
    public boolean canWalkOnFluid(FluidState state) {
        return state.isIn(FluidTags.WATER) || state.isIn(FluidTags.LAVA);
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
        for (GhostHandEntity ghostHand : ownedHands) {
            ghostHand.discard();
        }
    }

    static class SummonHandsGoal extends Goal {
        private final int timeDelay = 500;
        private static int summonTick = 0;
        private final GhostEntity ghost;

        SummonHandsGoal(GhostEntity ghost) {
            this.ghost = ghost;
        }

        @Override
        public boolean canStart() {
            if (summonTick == 0) {
                summonTick = this.ghost.age + timeDelay;
            }
            if (ghost.getTarget() == null || ghost.age < summonTick) {
                return false;
            }
            int i = ghost.ownedHands.size();
            return i < 2;
        }

        @Override
        public void start() {
            summonTick += timeDelay;
            summonHand();
        }

        private void summonHand() {
            World world = this.ghost.getWorld();
            GhostHandEntity ghostHand = new GhostHandEntity(ModEntities.GHOST_HAND, world);
            ghostHand.setOwner(this.ghost);
            ghost.ownedHands.add(ghostHand);
            ghostHand.setPosition(this.ghost.getPos());
            world.spawnEntity(ghostHand);
        }
    }

    static class CustomTargetGoal extends Goal {
        private PlayerEntity targetPlayer;
        private final GhostEntity ghost;
        private final TargetPredicate PLAYERS_IN_RANGE_PREDICATE = TargetPredicate.createAttackable().setBaseMaxDistance(2048.0f).ignoreVisibility();

        CustomTargetGoal(GhostEntity ghost) {
            this.ghost = ghost;
        }

        @Override
        public boolean canStart() {
            targetPlayer = this.ghost.getWorld().getClosestPlayer(this.PLAYERS_IN_RANGE_PREDICATE, this.ghost);
            if (targetPlayer == null) {
                ghost.setChasing(false);
                return false;
            } else if (targetPlayer.isInCreativeMode() && targetPlayer.isSpectator()) {
                ghost.setChasing(false);
                return false;
            }
            ghost.setChasing(true);
            return true;
        }

        @Override
        public void start() {
            this.ghost.setTarget(targetPlayer);
        }

        @Override
        public void stop() {
            ghost.setTarget(null);
            ghost.setChasing(false);
            this.targetPlayer = null;
        }
    }
}