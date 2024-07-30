package com.arndew.badrespawn.entity.ghost_hand;

import com.arndew.badrespawn.BadRespawn;
import com.arndew.badrespawn.entity.GhostHandEntity;
import com.arndew.badrespawn.entity.ModModelLayers;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class GhostHandEntityRenderer extends MobEntityRenderer<GhostHandEntity, GhostHandEntityModel<GhostHandEntity>> {
    private static final Identifier TEXTURE = Identifier.of(BadRespawn.MOD_ID, "textures/entity/ghost_hand.png");

    public GhostHandEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new GhostHandEntityModel<>(context.getPart(ModModelLayers.GHOST_HAND)), 0f);
    }

    @Override
    public Identifier getTexture(GhostHandEntity entity) {
        return TEXTURE;
    }
}
