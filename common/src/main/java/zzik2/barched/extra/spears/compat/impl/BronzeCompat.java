package zzik2.barched.extra.spears.compat.impl;

import com.khazoda.bronze.material.BronzeToolMaterial;
import net.minecraft.world.item.Tier;
import zzik2.barched.extra.spears.compat.ICompatMod;
import zzik2.barched.extra.spears.objects.MaterialData;
import zzik2.barched.extra.spears.objects.items.SpearData;

import java.util.List;

public class BronzeCompat implements ICompatMod {

    @Override
    public String getModID() {
        return "bronze";
    }

    @Override
    public List<MaterialData<Tier, String, SpearData>> getDefaultMaterials() {
        return List.of(
                new MaterialData<>(BronzeToolMaterial.INSTANCE, "bronze", new SpearData(
                        1.00F,
                        1.0125F,
                        0.55F,
                        2.75F,
                        7.75F,
                        6.625F,
                        5.1F,
                        10.625F,
                        4.6F
                ))
        );
    }
}
