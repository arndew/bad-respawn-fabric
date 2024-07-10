package com.arndew.badrespawn.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class FragilityStatusEffect extends StatusEffect {
    protected FragilityStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x2C283D);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {

        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
