package com.arndew.badrespawn.event;

import com.arndew.badrespawn.effect.ModStatusEffects;
import com.arndew.badrespawn.sound.SoundHandler;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.server.MinecraftServer;
import java.util.Random;

public class EndTickHandler implements ServerTickEvents.EndTick {
    static ClientPlayerEntity player = MinecraftClient.getInstance().player;
    private static final Random random = new Random();
    private static int soundTick = random.nextInt(1000, 10000);

    @Override
    public void onEndTick(MinecraftServer server) {
        if (!(player != null && player.hasStatusEffect(ModStatusEffects.HALLUCINATION))) {
            return;
        }
        int currentTick = server.getTicks();

        if (currentTick > soundTick) {
            SoundHandler.playSound();
            soundTick += random.nextInt();
        }
    }
}
