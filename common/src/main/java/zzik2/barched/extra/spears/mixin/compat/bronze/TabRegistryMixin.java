package zzik2.barched.extra.spears.mixin.compat.bronze;

import com.khazoda.bronze.registry.TabRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zzik2.barched.extra.spears.compat.CompatMods;
import zzik2.barched.extra.spears.registry.RegisterFactory;

@Mixin(TabRegistry.class)
public class TabRegistryMixin {

    @Dynamic
    @Inject(method = "lambda$static$1", at = @At(value = "FIELD", target = "Lcom/khazoda/bronze/registry/MainRegistry;BRONZE_SWORD:Ljava/util/function/Supplier;", opcode = Opcodes.GETSTATIC, shift = At.Shift.AFTER), require = 0)
    private static void barchedES$accept(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output, CallbackInfo ci) {
        RegisterFactory.registerItemsToInvTab(output, CompatMods.BRONZE);
    }
}
