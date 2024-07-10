package com.arndew.badrespawn.effect;

import com.arndew.badrespawn.BadRespawn;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {
    public static RegistryEntry<StatusEffect> FRAGILITY;
    public static RegistryEntry<StatusEffect> HALLUCINATION;

    private static RegistryEntry<StatusEffect> registerStatusEffect(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, new Identifier(BadRespawn.MOD_ID, id), statusEffect);
    }

    public static void registerModStatusEffects() {
        FRAGILITY = registerStatusEffect("fragility", new FragilityStatusEffect());
        HALLUCINATION = registerStatusEffect("hallucination", new HallucinationStatusEffect());
    }
}

