package com.arndew.badrespawn.mixin;

import com.arndew.badrespawn.event.BedAnchorRespawnCallback;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(ServerPlayerEntity.class)
public class PlayerRespawnMixin {
    @Inject(method = "findRespawnPosition", at = @At(value = "RETURN", ordinal = 0))
    private static void onPlayerRespawnAnchor(ServerWorld world, BlockPos pos, float spawnAngle, boolean spawnForced, boolean alive, CallbackInfoReturnable<Optional<ServerPlayerEntity.RespawnPos>> cir) {
        BedAnchorRespawnCallback.EVENT.invoker().onBlockAnchorRespawn();
    }

    @Inject(method = "findRespawnPosition", at = @At(value = "RETURN", ordinal = 1))
    private static void onPlayerRespawnBed(ServerWorld world, BlockPos pos, float spawnAngle, boolean spawnForced, boolean alive, CallbackInfoReturnable<Optional<ServerPlayerEntity.RespawnPos>> cir) {
        BedAnchorRespawnCallback.EVENT.invoker().onBlockAnchorRespawn();
    }
}