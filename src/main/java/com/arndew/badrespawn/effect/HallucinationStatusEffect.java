package com.arndew.badrespawn.effect;

import com.arndew.badrespawn.event.HallucinationEffectEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class HallucinationStatusEffect extends StatusEffect {
    protected HallucinationStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0xFCFA86);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        super.onApplied(entity, amplifier);
        HallucinationEffectEvents.APPLIED.invoker().hallucinationApplied();
    }

    @Override
    public void onRemoved(AttributeContainer attributeContainer) {
        super.onRemoved(attributeContainer);
        HallucinationEffectEvents.REMOVED.invoker().hallucinationRemoved();
    }
}
