package zzik2.barched.extra.spears.compat.impl;

import net.id.paradiselost.items.tools.ParadiseLostToolMaterials;
import net.minecraft.world.item.Tier;
import zzik2.barched.extra.spears.compat.ICompatMod;
import zzik2.barched.extra.spears.objects.MaterialData;
import zzik2.barched.extra.spears.objects.items.SpearData;
import zzik2.zreflex.reflection.ZReflectionTool;

import java.util.List;

public class ParadiseLostCompat implements ICompatMod {

    @Override
    public String getModID() {
        return "paradise_lost";
    }

    @Override
    public List<MaterialData<Tier, String, SpearData>> getDefaultMaterials() {
        Tier OLVITE = ZReflectionTool.getStaticFieldValue(ParadiseLostToolMaterials.class, "OLVITE");
        Tier SURTRUM = ZReflectionTool.getStaticFieldValue(ParadiseLostToolMaterials.class, "SURTRUM");
        Tier GLAZED_GOLD = ZReflectionTool.getStaticFieldValue(ParadiseLostToolMaterials.class, "GLAZED_GOLD");
        return List.of(
                //same with iron
                new MaterialData<>(OLVITE, "olvite", new SpearData(
                        0.95F,
                        0.95F,
                        0.60F,
                        2.5F,
                        8.0F,
                        6.75F,
                        5.1F,
                        11.25F,
                        4.6F
                )),
                //1.2x weaker than netherite
                new MaterialData<>(SURTRUM, "surtrum", new SpearData(
                        1.38F,
                        1.0F,
                        0.48F,
                        2.0833F,
                        8.4F,
                        4.5833F,
                        6.12F,
                        7.2917F,
                        5.52F
                )),
                //same with iron
                new MaterialData<>(GLAZED_GOLD, "glazed_gold", new SpearData(
                        0.95F,
                        0.95F,
                        0.60F,
                        2.5F,
                        8.0F,
                        6.75F,
                        5.1F,
                        11.25F,
                        4.6F
                ))
        );
    }
}
