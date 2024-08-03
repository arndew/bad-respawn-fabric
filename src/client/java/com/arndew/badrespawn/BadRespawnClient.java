package com.arndew.badrespawn;

import com.arndew.badrespawn.entity.ghost.GhostEntityModel;
import com.arndew.badrespawn.entity.ModEntities;
import com.arndew.badrespawn.entity.ghost.GhostEntityRenderer;
import com.arndew.badrespawn.entity.ModModelLayers;
import com.arndew.badrespawn.entity.ghost_hand.GhostHandEntityModel;
import com.arndew.badrespawn.entity.ghost_hand.GhostHandEntityRenderer;
import com.arndew.badrespawn.event.EndTickHandler;
import com.arndew.badrespawn.event.HallucinationEffectEvents;
import com.arndew.badrespawn.sound.ModSounds;
import com.arndew.badrespawn.sound.SoundHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class BadRespawnClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModSounds.registerModSounds();
		EntityRendererRegistry.register(ModEntities.GHOST, GhostEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GHOST, GhostEntityModel::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.GHOST_HAND, GhostHandEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GHOST_HAND, GhostHandEntityModel::getTexturedModelData);

		ClientTickEvents.END_CLIENT_TICK.register(new EndTickHandler());
		HallucinationEffectEvents.APPLIED.register(SoundHandler::reduceSound);
		HallucinationEffectEvents.REMOVED.register(SoundHandler::resumeSounds);
	}
}