// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package com.arndew.badrespawn.entity.ghost_hand;

import com.arndew.badrespawn.entity.GhostHandEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;

public class GhostHandEntityModel<T extends GhostHandEntity> extends SinglePartEntityModel<T> {
	private final ModelPart ghost_hand;

	public GhostHandEntityModel(ModelPart root) {
		this.ghost_hand = root.getChild("ghost_hand");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData left_ghost_hand = modelPartData.addChild("ghost_hand", ModelPartBuilder.create(), ModelTransform.of(-1.0F, 21.0F, 4.0F, -1.0472F, -0.3491F, 0.5236F));

		ModelPartData palm = left_ghost_hand.addChild("palm", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -1.0F, -4.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.316F, 0.6276F, 0.0603F));

		ModelPartData fingers = left_ghost_hand.addChild("fingers", ModelPartBuilder.create(), ModelTransform.pivot(-1.684F, 2.0276F, -0.7397F));

		ModelPartData thumb = fingers.addChild("thumb", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData thumb_r1 = thumb.addChild("thumb_r1", ModelPartBuilder.create().uv(0, 5).cuboid(0.0F, -2.0F, -2.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 0.0F, 0.2165F, 0.8381F, -0.2422F));

		ModelPartData index = fingers.addChild("index", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, -3.0F));

		ModelPartData index_r1 = index.addChild("index_r1", ModelPartBuilder.create().uv(10, 5).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.4F, 2.4F, -1.4F, 0.7257F, 0.4437F, -0.1019F));

		ModelPartData middle = fingers.addChild("middle", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, -2.0F, -3.0F));

		ModelPartData middle_r1 = middle.addChild("middle_r1", ModelPartBuilder.create().uv(5, 10).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.1F, 1.08F, -0.3F, 0.7835F, 0.185F, 0.0618F));

		ModelPartData ring = fingers.addChild("ring", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, -2.0F, -3.0F));

		ModelPartData ring_r1 = ring.addChild("ring_r1", ModelPartBuilder.create().uv(0, 9).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.04F, -0.2F, 0.7782F, -0.0923F, 0.0311F));

		ModelPartData pinky = fingers.addChild("pinky", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, -2.0F, -3.0F));

		ModelPartData pinky_r1 = pinky.addChild("pinky_r1", ModelPartBuilder.create().uv(5, 6).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.15F, 0.2F, 0.7937F, -0.3818F, 0.0607F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
	}

	@Override
	public ModelPart getPart() {
		return ghost_hand;
	}
}