package com.arndew.badrespawn.mixin;

import com.arndew.badrespawn.effect.ModStatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class EntityDamageMixin{
    @Inject(method = "modifyAppliedDamage", at = @At("TAIL"), cancellable = true)
    public void onDamage(DamageSource source, float amount, CallbackInfoReturnable<Float> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (entity.hasStatusEffect(ModStatusEffects.FRAGILITY) && !entity.getWorld().isClient) {
            amount = amount * 1.5f;
        }
        cir.setReturnValue(amount);
    }
}