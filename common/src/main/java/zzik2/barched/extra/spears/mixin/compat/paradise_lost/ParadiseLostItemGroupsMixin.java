package zzik2.barched.extra.spears.mixin.compat.paradise_lost;

import net.id.paradiselost.items.ParadiseLostItemGroups;
import net.minecraft.world.item.CreativeModeTab;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zzik2.barched.extra.spears.compat.CompatMods;
import zzik2.barched.extra.spears.registry.RegisterFactory;

@Mixin(ParadiseLostItemGroups.class)
public class ParadiseLostItemGroupsMixin {

    @Dynamic
    @Inject(method = "lambda$static$7", at = @At(value = "FIELD", target = "Lnet/id/paradiselost/items/ParadiseLostItems;OLVITE_SWORD:Lnet/minecraft/world/item/SwordItem;", opcode = Opcodes.GETSTATIC, shift = At.Shift.AFTER), require = 0)
    private static void barchedES$accept(CreativeModeTab.ItemDisplayParameters context, CreativeModeTab.Output entries, CallbackInfo ci) {
        RegisterFactory.registerItemsToInvTab(entries, CompatMods.PARADISE_LOST);
    }
}
