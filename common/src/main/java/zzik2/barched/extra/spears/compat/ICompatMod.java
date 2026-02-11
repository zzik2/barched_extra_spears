package zzik2.barched.extra.spears.compat;

import dev.architectury.platform.Platform;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Tier;
import zzik2.barched.extra.spears.config.SpearDataConfigManager;
import zzik2.barched.extra.spears.objects.MaterialData;
import zzik2.barched.extra.spears.objects.items.SpearData;

import java.util.ArrayList;
import java.util.List;

public interface ICompatMod {

    String getModID();

    /**
     * Returns a list of materials containing the underlying SpearData.
     * This value is used as the default when the config file is not present.
     */
    List<MaterialData<Tier, String, SpearData>> getDefaultMaterials();

    /**
     * Returns a list of materials that have SpearData loaded from config applied.
     */
    default List<MaterialData<Tier, String, SpearData>> getMaterials() {
        List<MaterialData<Tier, String, SpearData>> defaults = getDefaultMaterials();
        List<MaterialData<Tier, String, SpearData>> result = new ArrayList<>();
        for (MaterialData<Tier, String, SpearData> data : defaults) {
            SpearData configuredData = SpearDataConfigManager.loadOrCreate(data.materialName(), data.spearData());
            result.add(new MaterialData<>(data.material(), data.materialName(), configuredData));
        }
        return result;
    }

    default boolean isModLoaded() {
        return Platform.isModLoaded(getModID());
    }
}
