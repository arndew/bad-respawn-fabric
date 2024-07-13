package com.arndew.badrespawn;

import com.arndew.badrespawn.entity.ModEntities;
import com.arndew.badrespawn.entity.GhostEntityModel;
import com.arndew.badrespawn.entity.GhostEntityRenderer;
import com.arndew.badrespawn.entity.ModModelLayers;
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

		ClientTickEvents.END_CLIENT_TICK.register(new EndTickHandler());
		HallucinationEffectEvents.APPLIED.register(SoundHandler::reduceSound);
		HallucinationEffectEvents.REMOVED.register(SoundHandler::resumeSounds);
	}
}