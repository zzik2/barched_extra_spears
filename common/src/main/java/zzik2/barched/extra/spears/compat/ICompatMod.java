package zzik2.barched.extra.spears.compat;

import dev.architectury.platform.Platform;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Tier;
import zzik2.barched.extra.spears.objects.MaterialData;
import zzik2.barched.extra.spears.objects.items.SpearData;

import java.util.List;

public interface ICompatMod {

    String getModID();

    /**
     * Decide which Material to register as a Spear
     */
    List<MaterialData<Tier, String, SpearData>> getMaterials();

    /**
     * Decide which creative tab the item will be registered in
     */
    CreativeModeTab getCreativeTab();

    default boolean isModLoaded() {
        return Platform.isModLoaded(getModID());
    }
}
