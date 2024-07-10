package com.arndew.badrespawn.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class GhostEntityModel<T extends GhostEntity> extends SinglePartEntityModel<T> {
	private final ModelPart ghost;

	public GhostEntityModel(ModelPart root) {
		this.ghost = root.getChild("ghost");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData ghost = modelPartData.addChild("ghost", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = ghost.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -25.0F, -6.0F, 12.0F, 0.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rear_r1 = body.addChild("rear_r1", ModelPartBuilder.create().uv(0, 12).cuboid(-6.0F, -20.0F, 1.0F, 12.0F, 20.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.0F, 5.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData side2_r1 = body.addChild("side2_r1", ModelPartBuilder.create().uv(24, 12).cuboid(-6.0F, -20.0F, 1.0F, 12.0F, 20.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(7.0F, -5.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData side1_r1 = body.addChild("side1_r1", ModelPartBuilder.create().uv(0, 32).cuboid(-6.0F, -20.0F, 1.0F, 12.0F, 20.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, -5.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face_r1 = body.addChild("face_r1", ModelPartBuilder.create().uv(24, 32).cuboid(-6.0F, -20.0F, 1.0F, 12.0F, 20.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.0F, -5.0F, 0.0F, 3.1416F, 0.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(GhostEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		ghost.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return ghost;
	}
}