package com.arndew.badrespawn.entity;

import com.arndew.badrespawn.BadRespawn;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer GHOST = new EntityModelLayer(Identifier.of(BadRespawn.MOD_ID, "ghost"), "main");
}
