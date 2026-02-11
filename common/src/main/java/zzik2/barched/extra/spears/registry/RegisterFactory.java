package zzik2.barched.extra.spears.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import it.unimi.dsi.fastutil.Pair;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import zzik2.barched.bridge.item.Item$PropertiesBridge;
import zzik2.barched.extra.spears.BarchedES;
import zzik2.barched.extra.spears.compat.CompatMods;
import zzik2.barched.extra.spears.compat.ICompatMod;
import zzik2.barched.extra.spears.objects.MaterialData;
import zzik2.barched.extra.spears.objects.items.SpearData;
import zzik2.barched.minecraft.world.item.SpearItem;
import zzik2.zreflex.enumeration.ZEnumTool;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class RegisterFactory {

    public static final Map<String, Item> REGISTERED_SPEARS = new HashMap<>();

    private RegisterFactory() {}

    public static void init() {
        for (CompatMods mods : CompatMods.values()) {
            ICompatMod compatMod = mods.getCompatMod();
            BarchedES.LOGGER.info("Trying hook mod: " + compatMod.getModID());
            boolean isModLoaded = compatMod.isModLoaded();
            if (!isModLoaded) {
                BarchedES.LOGGER.warn("Mod not found. Ignored: " + compatMod.getModID());
            } else {
                BarchedES.LOGGER.info("Mod found. Trying register Spears for: " + compatMod.getModID());
                DeferredRegister<Item> ITEMS = DeferredRegister.create(compatMod.getModID(), Registries.ITEM);

                int materialCount = 0;
                for (MaterialData<Tier, String, SpearData> materialData : compatMod.getMaterials()) {
                    materialCount++;
                    Tier material = materialData.first();
                    String materialName = materialData.second();
                    SpearData spearData = materialData.third();
                    Tiers TIER = ZEnumTool.addConstant(
                            Tiers.class,
                            compatMod.getModID().toUpperCase() + "$" + materialName.toUpperCase(),
                            new Class<?>[] {TagKey.class, int.class, float.class, float.class, int.class, Supplier.class},
                            material.getIncorrectBlocksForDrops(), material.getUses(), material.getSpeed(), material.getAttackDamageBonus(), material.getEnchantmentValue(), (Supplier<Ingredient>) material::getRepairIngredient
                    );

                    RegistrySupplier<Item> item = ITEMS.register(materialName + "_spear", () -> new SpearItem(material, ((Item$PropertiesBridge) new Item.Properties()).spear(TIER, spearData.swingSeconds(), spearData.kineticDamageMultiplier(), spearData.delaySeconds(), spearData.damageCondDurationSeconds(), spearData.damageCondMinSpeed(), spearData.knockbackCondDurationSeconds(), spearData.knockbackCondMinSpeed(), spearData.dismountCondDurationSeconds(), spearData.dismountCondMinRelativeSpeed())));

                    REGISTERED_SPEARS.put(compatMod.getModID(), item.get());
                }

                ITEMS.register();
                BarchedES.LOGGER.info("Successfully registered Spears. Found material count: " + materialCount);
            }
        }
    }
}
