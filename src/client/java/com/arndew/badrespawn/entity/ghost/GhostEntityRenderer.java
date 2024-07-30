package com.arndew.badrespawn.entity.ghost;

import com.arndew.badrespawn.BadRespawn;
import com.arndew.badrespawn.entity.GhostEntity;
import com.arndew.badrespawn.entity.ModModelLayers;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class GhostEntityRenderer extends MobEntityRenderer<GhostEntity, GhostEntityModel<GhostEntity>> {
    private static final Identifier TEXTURE = Identifier.of(BadRespawn.MOD_ID, "textures/entity/ghost.png");

    public GhostEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new GhostEntityModel<>(context.getPart(ModModelLayers.GHOST)), 0f);
    }

    @Override
    public Identifier getTexture(GhostEntity entity) {
        return TEXTURE;
    }
}
