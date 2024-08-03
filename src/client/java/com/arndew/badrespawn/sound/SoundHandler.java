package com.arndew.badrespawn.sound;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.sound.MusicTracker;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.sound.*;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class SoundHandler {
    private static final MinecraftClient client = MinecraftClient.getInstance();
    private static final SoundManager soundManager = client.getSoundManager();
    private static final MusicTracker musicTracker = client.getMusicTracker();
    private static MusicSound gameMusic;

    private static final SoundEvent[] mobSounds = {SoundEvents.ENTITY_CREEPER_PRIMED, SoundEvents.ENTITY_WOLF_HOWL, SoundEvents.ENTITY_WOLF_GROWL, ModSounds.GHOST_SCARE};

    private static final Random random = new Random();

    public static void reduceSound() {
        gameMusic = client.getMusicType();
        soundManager.stopSounds(null, SoundCategory.AMBIENT);
        soundManager.stopSounds(null, SoundCategory.MUSIC);
        musicTracker.stop(gameMusic);
    }

    public static void resumeSounds() {
        gameMusic = client.getMusicType();
        soundManager.resumeAll();
        musicTracker.play(gameMusic);
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