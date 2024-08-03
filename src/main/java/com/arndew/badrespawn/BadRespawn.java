package com.arndew.badrespawn;

import com.arndew.badrespawn.effect.ModStatusEffects;
import com.arndew.badrespawn.entity.GhostHandEntity;
import com.arndew.badrespawn.entity.ModEntities;
import com.arndew.badrespawn.entity.GhostEntity;
import com.arndew.badrespawn.event.AfterKilledEntityHandler;
import com.arndew.badrespawn.event.BedAnchorRespawnCallback;
import com.arndew.badrespawn.event.AfterRespawnHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BadRespawn implements ModInitializer {
	public static final String MOD_ID = "badrespawn";
	public static final Logger LOGGER = LoggerFactory.getLogger("badrespawn");

	@Override
	public void onInitialize() {
		ModStatusEffects.registerModStatusEffects();

		AfterRespawnHandler afterRespawnHandler = new AfterRespawnHandler();

		BedAnchorRespawnCallback.EVENT.register(afterRespawnHandler);
		ServerPlayerEvents.AFTER_RESPAWN.register(afterRespawnHandler);
		ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register(new AfterKilledEntityHandler());

		FabricDefaultAttributeRegistry.register(ModEntities.GHOST, GhostEntity.createGhostAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.GHOST_HAND, GhostHandEntity.createGhostHandAttributes());
	}
}