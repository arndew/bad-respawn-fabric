package com.arndew.badrespawn.sound;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.sound.MusicTracker;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class SoundHandler {
    static SoundManager soundManager = MinecraftClient.getInstance().getSoundManager();
    static MusicTracker musicTracker = MinecraftClient.getInstance().getMusicTracker();

    private static final SoundEvent[] mobSounds = {SoundEvents.ENTITY_CREEPER_PRIMED, SoundEvents.ENTITY_WOLF_HOWL, SoundEvents.ENTITY_GHAST_SCREAM, ModSounds.GHOST_SCARE};

    private static final Random random = new Random();

    public static void reduceSound() {
        soundManager.stopSounds(null, SoundCategory.AMBIENT);
        soundManager.stopSounds(null, SoundCategory.MUSIC);
        musicTracker.stop();
    }

    public static void resumeSounds() {
        soundManager.resumeAll();
    }

    private static BlockPos getSoundBlockPos(ClientPlayerEntity player) {
        int randomDistance = random.nextInt(1, 3);
        BlockPos playerBlockPos = player.getBlockPos();
        float playerHeadYaw = player.getHeadYaw();

        int offsetX = (int) Math.round(-randomDistance * Math.sin(playerHeadYaw));
        int offsetY = (int) Math.round(randomDistance * Math.cos(playerHeadYaw));

        return playerBlockPos.add(offsetX, offsetY, 0);
    }

    public static void playSound(ClientPlayerEntity player, ClientWorld world) {
        int randomSound = random.nextInt(0, mobSounds.length);

        BlockPos soundBlockPos = getSoundBlockPos(player);

        world.playSound(
                player,
                soundBlockPos,
                mobSounds[randomSound],
                SoundCategory.MASTER
        );
    }
}