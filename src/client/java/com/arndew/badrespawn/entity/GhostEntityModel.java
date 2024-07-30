package com.arndew.badrespawn.entity;

import com.arndew.badrespawn.animation.GhostAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;

public class GhostEntityModel<T extends GhostEntity> extends SinglePartEntityModel<T> {
	private final ModelPart ghost;

	public GhostEntityModel(ModelPart root) {
		this.ghost = root.getChild("ghost");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData ghost = modelPartData.addChild("ghost", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = ghost.addChild("body", ModelPartBuilder.create().uv(1, 1).cuboid(-6.0F, -25.0F, -6.0F, 12.0F, 0.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rear_r1 = body.addChild("rear_r1", ModelPartBuilder.create().uv(1, 13).cuboid(-6.0F, -20.0F, 1.0F, 12.0F, 20.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.0F, 5.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData side2_r1 = body.addChild("side2_r1", ModelPartBuilder.create().uv(25, 13).cuboid(-6.0F, -20.0F, 1.0F, 12.0F, 20.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(7.0F, -5.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData side1_r1 = body.addChild("side1_r1", ModelPartBuilder.create().uv(1, 33).cuboid(-6.0F, -20.0F, 1.0F, 12.0F, 20.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, -5.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face_r1 = body.addChild("face_r1", ModelPartBuilder.create().uv(25, 33).cuboid(-6.0F, -20.0F, 1.0F, 12.0F, 20.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.0F, -5.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData hands = ghost.addChild("hands", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -5.0F, 0.0F));

		ModelPartData left_ghost_hand1 = hands.addChild("left_ghost_hand1", ModelPartBuilder.create(), ModelTransform.of(11.0F, -10.0F, -2.0F, -1.0472F, -0.3491F, 0.5236F));

		ModelPartData left_fingers = left_ghost_hand1.addChild("left_fingers", ModelPartBuilder.create(), ModelTransform.pivot(-1.684F, 2.0276F, -0.7397F));

		ModelPartData left_pinky1 = left_fingers.addChild("left_pinky1", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, -1.85F, -2.8F));

		ModelPartData pinky_r1 = left_pinky1.addChild("pinky_r1", ModelPartBuilder.create().uv(6, 72).cuboid(-0.9437F, -0.3162F, -2.7275F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7937F, -0.3818F, 0.0607F));

		ModelPartData left_ring1 = left_fingers.addChild("left_ring1", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, -1.96F, -3.2F));

		ModelPartData ring_r1 = left_ring1.addChild("ring_r1", ModelPartBuilder.create().uv(1, 75).cuboid(-0.969F, -0.2902F, -2.7037F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7782F, -0.0923F, 0.0311F));

		ModelPartData left_middle1 = left_fingers.addChild("left_middle1", ModelPartBuilder.create(), ModelTransform.pivot(1.9F, -1.92F, -3.3F));

		ModelPartData middle_r1 = left_middle1.addChild("middle_r1", ModelPartBuilder.create().uv(6, 76).cuboid(-0.9393F, -0.2849F, -2.6964F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7835F, 0.185F, 0.0618F));

		ModelPartData left_index1 = left_fingers.addChild("left_index1", ModelPartBuilder.create(), ModelTransform.pivot(0.4F, -1.6F, -2.4F));

		ModelPartData index_r1 = left_index1.addChild("index_r1", ModelPartBuilder.create().uv(11, 71).cuboid(-0.3252F, -0.7686F, -2.737F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7257F, 0.4437F, -0.1019F));

		ModelPartData left_thumb1 = left_fingers.addChild("left_thumb1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData thumb_r1 = left_thumb1.addChild("thumb_r1", ModelPartBuilder.create().uv(1, 71).cuboid(-0.3209F, -0.1803F, -2.7654F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2165F, 0.8381F, -0.2422F));

		ModelPartData left_palm1 = left_ghost_hand1.addChild("left_palm1", ModelPartBuilder.create().uv(1, 66).cuboid(-1.684F, -0.3724F, -3.9397F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData right_ghost_hand1 = hands.addChild("right_ghost_hand1", ModelPartBuilder.create(), ModelTransform.of(-11.0F, -10.0F, -2.0F, -1.0472F, 0.3491F, -0.5236F));

		ModelPartData right_fingers = right_ghost_hand1.addChild("right_fingers", ModelPartBuilder.create(), ModelTransform.pivot(1.684F, 2.0276F, -0.7397F));

		ModelPartData right_pinky1 = right_fingers.addChild("right_pinky1", ModelPartBuilder.create(), ModelTransform.pivot(-4.0F, -1.85F, -2.8F));

		ModelPartData pinky_r2 = right_pinky1.addChild("pinky_r2", ModelPartBuilder.create().uv(6, 72).mirrored().cuboid(-0.0563F, -0.3162F, -2.7275F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7937F, 0.3818F, -0.0607F));

		ModelPartData right_ring1 = right_fingers.addChild("right_ring1", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, -1.96F, -3.2F));

		ModelPartData ring_r2 = right_ring1.addChild("ring_r2", ModelPartBuilder.create().uv(1, 75).mirrored().cuboid(-0.031F, -0.2902F, -2.7037F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7782F, 0.0923F, -0.0311F));

		ModelPartData right_middle1 = right_fingers.addChild("right_middle1", ModelPartBuilder.create(), ModelTransform.pivot(-1.9F, -1.92F, -3.3F));

		ModelPartData middle_r2 = right_middle1.addChild("middle_r2", ModelPartBuilder.create().uv(6, 76).mirrored().cuboid(-0.0607F, -0.2849F, -2.6964F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7835F, -0.185F, -0.0618F));

		ModelPartData right_index1 = right_fingers.addChild("right_index1", ModelPartBuilder.create(), ModelTransform.pivot(-0.4F, -1.6F, -2.4F));

		ModelPartData index_r2 = right_index1.addChild("index_r2", ModelPartBuilder.create().uv(11, 71).mirrored().cuboid(-0.6748F, -0.7686F, -2.737F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7257F, -0.4437F, 0.1019F));

		ModelPartData right_thumb1 = right_fingers.addChild("right_thumb1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData thumb_r2 = right_thumb1.addChild("thumb_r2", ModelPartBuilder.create().uv(1, 71).mirrored().cuboid(-0.6791F, -0.1803F, -2.7654F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2165F, -0.8381F, 0.2422F));

		ModelPartData right_palm = right_ghost_hand1.addChild("right_palm", ModelPartBuilder.create().uv(1, 66).mirrored().cuboid(-2.316F, -0.3724F, -3.9397F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData left_ghost_hand2 = hands.addChild("left_ghost_hand2", ModelPartBuilder.create(), ModelTransform.of(10.0F, -17.0F, 0.0F, -1.0472F, -0.3491F, 0.5236F));

		ModelPartData left_fingers2 = left_ghost_hand2.addChild("left_fingers2", ModelPartBuilder.create(), ModelTransform.pivot(-1.684F, 2.0276F, -0.7397F));

		ModelPartData left_pinky2 = left_fingers2.addChild("left_pinky2", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, -1.85F, -2.8F));

		ModelPartData pinky_r3 = left_pinky2.addChild("pinky_r3", ModelPartBuilder.create().uv(6, 72).cuboid(-0.9437F, -0.3162F, -2.7275F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7937F, -0.3818F, 0.0607F));

		ModelPartData left_ring2 = left_fingers2.addChild("left_ring2", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, -1.96F, -3.2F));

		ModelPartData ring_r3 = left_ring2.addChild("ring_r3", ModelPartBuilder.create().uv(1, 75).cuboid(-0.969F, -0.2902F, -2.7037F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7782F, -0.0923F, 0.0311F));

		ModelPartData left_middle2 = left_fingers2.addChild("left_middle2", ModelPartBuilder.create(), ModelTransform.pivot(1.9F, -1.92F, -3.3F));

		ModelPartData middle_r3 = left_middle2.addChild("middle_r3", ModelPartBuilder.create().uv(6, 76).cuboid(-0.9393F, -0.2849F, -2.6964F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7835F, 0.185F, 0.0618F));

		ModelPartData left_index2 = left_fingers2.addChild("left_index2", ModelPartBuilder.create(), ModelTransform.pivot(0.4F, -1.6F, -2.4F));

		ModelPartData index_r3 = left_index2.addChild("index_r3", ModelPartBuilder.create().uv(11, 71).cuboid(-0.3252F, -0.7686F, -2.737F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7257F, 0.4437F, -0.1019F));

		ModelPartData left_thumb2 = left_fingers2.addChild("left_thumb2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData thumb_r3 = left_thumb2.addChild("thumb_r3", ModelPartBuilder.create().uv(1, 71).cuboid(-0.3209F, -0.1803F, -2.7654F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2165F, 0.8381F, -0.2422F));

		ModelPartData left_palm2 = left_ghost_hand2.addChild("left_palm2", ModelPartBuilder.create().uv(1, 66).cuboid(-1.684F, -0.3724F, -3.9397F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData right_ghost_hand2 = hands.addChild("right_ghost_hand2", ModelPartBuilder.create(), ModelTransform.of(-10.0F, -17.0F, 0.0F, -1.0472F, 0.3491F, -0.5236F));

		ModelPartData right_fingers2 = right_ghost_hand2.addChild("right_fingers2", ModelPartBuilder.create(), ModelTransform.pivot(1.684F, 2.0276F, -0.7397F));

		ModelPartData right_pinky2 = right_fingers2.addChild("right_pinky2", ModelPartBuilder.create(), ModelTransform.pivot(-4.0F, -1.85F, -2.8F));

		ModelPartData pinky_r4 = right_pinky2.addChild("pinky_r4", ModelPartBuilder.create().uv(6, 72).mirrored().cuboid(-0.0563F, -0.3162F, -2.7275F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7937F, 0.3818F, -0.0607F));

		ModelPartData right_ring2 = right_fingers2.addChild("right_ring2", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, -1.96F, -3.2F));

		ModelPartData ring_r4 = right_ring2.addChild("ring_r4", ModelPartBuilder.create().uv(1, 75).mirrored().cuboid(-0.031F, -0.2902F, -2.7037F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7782F, 0.0923F, -0.0311F));

		ModelPartData right_middle2 = right_fingers2.addChild("right_middle2", ModelPartBuilder.create(), ModelTransform.pivot(-1.9F, -1.92F, -3.3F));

		ModelPartData middle_r4 = right_middle2.addChild("middle_r4", ModelPartBuilder.create().uv(6, 76).mirrored().cuboid(-0.0607F, -0.2849F, -2.6964F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7835F, -0.185F, -0.0618F));

		ModelPartData right_index2 = right_fingers2.addChild("right_index2", ModelPartBuilder.create(), ModelTransform.pivot(-0.4F, -1.6F, -2.4F));

		ModelPartData index_r4 = right_index2.addChild("index_r4", ModelPartBuilder.create().uv(11, 71).mirrored().cuboid(-0.6748F, -0.7686F, -2.737F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7257F, -0.4437F, 0.1019F));

		ModelPartData right_thumb2 = right_fingers2.addChild("right_thumb2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData thumb_r4 = right_thumb2.addChild("thumb_r4", ModelPartBuilder.create().uv(1, 71).mirrored().cuboid(-0.6791F, -0.1803F, -2.7654F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2165F, -0.8381F, 0.2422F));

		ModelPartData right_palm2 = right_ghost_hand2.addChild("right_palm2", ModelPartBuilder.create().uv(1, 66).mirrored().cuboid(-2.316F, -0.3724F, -3.9397F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData left_ghost_hand3 = hands.addChild("left_ghost_hand3", ModelPartBuilder.create(), ModelTransform.of(10.0F, -3.0F, 1.0F, -1.0472F, -0.3491F, 0.5236F));

		ModelPartData left_fingers3 = left_ghost_hand3.addChild("left_fingers3", ModelPartBuilder.create(), ModelTransform.pivot(-1.684F, 2.0276F, -0.7397F));

		ModelPartData left_pinky3 = left_fingers3.addChild("left_pinky3", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, -1.85F, -2.8F));

		ModelPartData pinky_r5 = left_pinky3.addChild("pinky_r5", ModelPartBuilder.create().uv(6, 72).cuboid(-0.9437F, -0.3162F, -2.7275F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7937F, -0.3818F, 0.0607F));

		ModelPartData left_ring3 = left_fingers3.addChild("left_ring3", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, -1.96F, -3.2F));

		ModelPartData ring_r5 = left_ring3.addChild("ring_r5", ModelPartBuilder.create().uv(1, 75).cuboid(-0.969F, -0.2902F, -2.7037F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7782F, -0.0923F, 0.0311F));

		ModelPartData left_middle3 = left_fingers3.addChild("left_middle3", ModelPartBuilder.create(), ModelTransform.pivot(1.9F, -1.92F, -3.3F));

		ModelPartData middle_r5 = left_middle3.addChild("middle_r5", ModelPartBuilder.create().uv(6, 76).cuboid(-0.9393F, -0.2849F, -2.6964F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7835F, 0.185F, 0.0618F));

		ModelPartData left_index3 = left_fingers3.addChild("left_index3", ModelPartBuilder.create(), ModelTransform.pivot(0.4F, -1.6F, -2.4F));

		ModelPartData index_r5 = left_index3.addChild("index_r5", ModelPartBuilder.create().uv(11, 71).cuboid(-0.3252F, -0.7686F, -2.737F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7257F, 0.4437F, -0.1019F));

		ModelPartData left_thumb3 = left_fingers3.addChild("left_thumb3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData thumb_r5 = left_thumb3.addChild("thumb_r5", ModelPartBuilder.create().uv(1, 71).cuboid(-0.3209F, -0.1803F, -2.7654F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2165F, 0.8381F, -0.2422F));

		ModelPartData left_palm3 = left_ghost_hand3.addChild("left_palm3", ModelPartBuilder.create().uv(1, 66).cuboid(-1.684F, -0.3724F, -3.9397F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData right_ghost_hand3 = hands.addChild("right_ghost_hand3", ModelPartBuilder.create(), ModelTransform.of(-10.0F, -3.0F, 1.0F, -1.0472F, 0.3491F, -0.5236F));

		ModelPartData right_fingers3 = right_ghost_hand3.addChild("right_fingers3", ModelPartBuilder.create(), ModelTransform.pivot(1.684F, 2.0276F, -0.7397F));

		ModelPartData right_pinky3 = right_fingers3.addChild("right_pinky3", ModelPartBuilder.create(), ModelTransform.pivot(-4.0F, -1.85F, -2.8F));

		ModelPartData pinky_r6 = right_pinky3.addChild("pinky_r6", ModelPartBuilder.create().uv(6, 72).mirrored().cuboid(-0.0563F, -0.3162F, -2.7275F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7937F, 0.3818F, -0.0607F));

		ModelPartData right_ring3 = right_fingers3.addChild("right_ring3", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, -1.96F, -3.2F));

		ModelPartData ring_r6 = right_ring3.addChild("ring_r6", ModelPartBuilder.create().uv(1, 75).mirrored().cuboid(-0.031F, -0.2902F, -2.7037F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7782F, 0.0923F, -0.0311F));

		ModelPartData right_middle3 = right_fingers3.addChild("right_middle3", ModelPartBuilder.create(), ModelTransform.pivot(-1.9F, -1.92F, -3.3F));

		ModelPartData middle_r6 = right_middle3.addChild("middle_r6", ModelPartBuilder.create().uv(6, 76).mirrored().cuboid(-0.0607F, -0.2849F, -2.6964F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7835F, -0.185F, -0.0618F));

		ModelPartData right_index3 = right_fingers3.addChild("right_index3", ModelPartBuilder.create(), ModelTransform.pivot(-0.4F, -1.6F, -2.4F));

		ModelPartData index_r6 = right_index3.addChild("index_r6", ModelPartBuilder.create().uv(11, 71).mirrored().cuboid(-0.6748F, -0.7686F, -2.737F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7257F, -0.4437F, 0.1019F));

		ModelPartData right_thumb3 = right_fingers3.addChild("right_thumb3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData thumb_r6 = right_thumb3.addChild("thumb_r6", ModelPartBuilder.create().uv(1, 71).mirrored().cuboid(-0.6791F, -0.1803F, -2.7654F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2165F, -0.8381F, 0.2422F));

		ModelPartData right_palm3 = right_ghost_hand3.addChild("right_palm3", ModelPartBuilder.create().uv(1, 66).mirrored().cuboid(-2.316F, -0.3724F, -3.9397F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 67, 99);
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.updateAnimation(entity.chasingAnimationState, GhostAnimations.CHASE, animationProgress);
		this.updateAnimation(entity.chasingTransitionAnimationState, GhostAnimations.START_CHASE, animationProgress);
		this.updateAnimation(entity.idlingAnimationState, GhostAnimations.IDLE, animationProgress);
	}

	@Override
	public ModelPart getPart() {
		return ghost;
	}
}