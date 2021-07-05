package net.mcreator.spiderman.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.spiderman.entity.CarnageVenomSymbioteEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class CarnageVenomSymbioteRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(CarnageVenomSymbioteEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelsymbiote(), 0.3f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("spiderman:textures/symbiotecarnage.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.8.2
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelsymbiote extends EntityModel<Entity> {
		private final ModelRenderer body1;
		private final ModelRenderer body2;
		private final ModelRenderer body3;
		private final ModelRenderer body4;
		public Modelsymbiote() {
			textureWidth = 32;
			textureHeight = 32;
			body1 = new ModelRenderer(this);
			body1.setRotationPoint(0.0F, 21.0F, -3.5F);
			body1.setTextureOffset(0, 9).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);
			body2 = new ModelRenderer(this);
			body2.setRotationPoint(0.0F, 20.0F, 0.0F);
			body2.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, -2.5F, 6.0F, 4.0F, 5.0F, 0.0F, false);
			body3 = new ModelRenderer(this);
			body3.setRotationPoint(0.0F, 21.0F, 3.0F);
			body3.setTextureOffset(12, 12).addBox(-1.5F, 0.0F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);
			body4 = new ModelRenderer(this);
			body4.setRotationPoint(0.0F, 22.0F, 4.0F);
			body4.setTextureOffset(0, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body1.render(matrixStack, buffer, packedLight, packedOverlay);
			body2.render(matrixStack, buffer, packedLight, packedOverlay);
			body3.render(matrixStack, buffer, packedLight, packedOverlay);
			body4.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
