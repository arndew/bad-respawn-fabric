package com.arndew.badrespawn.event;

import com.arndew.badrespawn.effect.ModStatusEffects;
import com.arndew.badrespawn.entity.GhostEntity;
import com.arndew.badrespawn.entity.ModEntities;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class AfterKilledEntityHandler implements ServerEntityCombatEvents.AfterKilledOtherEntity {
    @Override
    public void afterKilledOtherEntity(ServerWorld world, Entity entity, LivingEntity killedEntity) {
        if (!entity.isPlayer()) {
            return;
        }
        ServerPlayerEntity player = (ServerPlayerEntity) entity;

        if (player.isPlayer() && player.hasStatusEffect(ModStatusEffects.HALLUCINATION)) {
            Vec3d spawnPos = killedEntity.getPos();
            GhostEntity ghost = new GhostEntity(ModEntities.GHOST, world);
            ghost.setPosition(spawnPos);
            world.spawnEntity(ghost);
        }
    }
}
