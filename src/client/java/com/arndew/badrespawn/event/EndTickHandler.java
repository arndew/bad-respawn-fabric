package com.arndew.badrespawn.event;

import com.arndew.badrespawn.effect.ModStatusEffects;
import com.arndew.badrespawn.sound.SoundHandler;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;

import java.util.Random;

public class EndTickHandler implements ClientTickEvents.EndTick {
    private static final Random random = new Random();
    private static int soundTick = 0;

    @Override
    public void onEndTick(MinecraftClient client) {
        ClientPlayerEntity player = client.player;
        ClientWorld world = client.world;

        if ((player != null && player.hasStatusEffect(ModStatusEffects.HALLUCINATION) && world != null)) {
            long currentTick = world.getTime();

            if (soundTick == 0) {
                soundTick = (int) (currentTick + random.nextInt(4000, 8000));
            }

            if (currentTick > soundTick) {
                SoundHandler.playSound(player, world);
                soundTick += random.nextInt(4000, 8000);
            }
        }
    }
}
