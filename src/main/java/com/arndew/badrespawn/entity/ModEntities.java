package com.arndew.badrespawn.entity;

import com.arndew.badrespawn.BadRespawn;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<GhostEntity> GHOST = Registry.register(Registries.ENTITY_TYPE, Identifier.of(BadRespawn.MOD_ID, "ghost"),
            EntityType.Builder.create(GhostEntity::new, SpawnGroup.MONSTER).dimensions(0.8f, 1.8f).eyeHeight(1.2f).build());
}
