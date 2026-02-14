package zzik2.barched.extra.spears.compat.impl;

import net.legacy.progression_reborn.registry.PRTiers;
import net.minecraft.world.item.Tier;
import zzik2.barched.extra.spears.compat.ICompatMod;
import zzik2.barched.extra.spears.objects.MaterialData;
import zzik2.barched.extra.spears.objects.items.SpearData;

import java.util.List;

public class ProgressionRebornCompat implements ICompatMod {

    @Override
    public String getModID() {
        return "progression_reborn";
    }

    @Override
    public List<MaterialData<Tier, String, SpearData>> getDefaultMaterials() {
        return List.of(
                //1.2x stronger than iron
                new MaterialData<>(PRTiers.ROSE, "rose", new SpearData(
                        0.7917F,
                        1.14F,
                        0.5F,
                        3.0F,
                        6.6667F,
                        8.1F,
                        4.25F,
                        13.5F,
                        3.8333F
                ))
        );
    }
}
