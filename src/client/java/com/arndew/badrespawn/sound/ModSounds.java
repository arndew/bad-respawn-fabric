package com.arndew.badrespawn.sound;

import com.arndew.badrespawn.BadRespawn;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    private static final Identifier GHOST_SCARE_ID = new Identifier(BadRespawn.MOD_ID, "ghost_scare");

    public static final SoundEvent GHOST_SCARE = SoundEvent.of(GHOST_SCARE_ID);

    public static void registerModSounds() {
        Registry.register(Registries.SOUND_EVENT, GHOST_SCARE_ID, GHOST_SCARE);
    }
}
