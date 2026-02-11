package zzik2.barched.extra.spears.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zzik2.barched.extra.spears.BarchedESClient;

@Mixin(value = ItemRenderer.class, priority = 900)
public class ItemRendererMixin {

    @Shadow @Final private ItemModelShaper itemModelShaper;
    @Unique private ItemStack barchedES$itemStack;

    @Inject(method = "render", at = @At("HEAD"))
    private void barchedES$captureSignature(ItemStack itemStack, ItemDisplayContext itemDisplayContext, boolean bl, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, BakedModel bakedModel, CallbackInfo ci) {
        this.barchedES$itemStack = itemStack;
    }

    @ModifyVariable(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/BakedModel;getTransforms()Lnet/minecraft/client/renderer/block/model/ItemTransforms;", shift = At.Shift.BEFORE, ordinal = 0), argsOnly = true, index = 8)
    private BakedModel barchedES$render(BakedModel value, @Local(ordinal = 0) boolean bl2) {
        if (bl2) {
            if (BarchedESClient.SPEAR_MODEL_MAP.containsKey(barchedES$itemStack.getItem())) {
                ModelResourceLocation model = BarchedESClient.SPEAR_MODEL_MAP.get(barchedES$itemStack.getItem());
                return this.itemModelShaper.getModelManager().getModel(model);
            }
        }
        return value;
    }

    @Redirect(method = "getModel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/ItemModelShaper;getItemModel(Lnet/minecraft/world/item/ItemStack;)Lnet/minecraft/client/resources/model/BakedModel;"))
    private BakedModel barchedES$getModel(ItemModelShaper instance, ItemStack bakedModel) {
        if (BarchedESClient.SPEAR_IN_HAND_MODEL_MAP.containsKey(bakedModel.getItem())) {
            ModelResourceLocation model = BarchedESClient.SPEAR_IN_HAND_MODEL_MAP.get(bakedModel.getItem());
            return this.itemModelShaper.getModelManager().getModel(model);
        }
        return instance.getItemModel(bakedModel);
    }
}
