package zzik2.barched.extra.spears.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class RegisterFactory {

    // MOD_ID | List<RegistrySupplier<Item>>
    public static final Map<String, List<RegistrySupplier<Item>>> REGISTERED_SPEARS = new HashMap<>();

    // RegistrySupplier<Item> | materialName
    public static final Map<RegistrySupplier<Item>, String> REGISTRY_SUPPLIER_TO_MATERIAL = new HashMap<>();

    private RegisterFactory() {}

    public static void init() {
        for (CompatMods mods : CompatMods.values()) {
            ICompatMod compatMod = mods.getCompatMod();
            boolean isModLoaded = compatMod.isModLoaded();
            if (!isModLoaded) {
                BarchedES.LOGGER.warn("Mod not found. Ignored: " + compatMod.getModID());
            } else {
                BarchedES.LOGGER.info("Mod found. Trying register Spears for: " + compatMod.getModID());
                DeferredRegister<Item> ITEMS = DeferredRegister.create(compatMod.getModID(), Registries.ITEM);

                int materialCount = 0;
                for (MaterialData<Tier, String, SpearData> materialData : compatMod.getMaterials()) {
                    materialCount++;
                    Tier material = materialData.material();
                    String materialName = materialData.materialName();
                    SpearData spearData = materialData.spearData();
                    Tiers TIER = ZEnumTool.addConstant(
                            Tiers.class,
                            compatMod.getModID().toUpperCase() + "$" + materialName.toUpperCase(),
                            new Class<?>[] {TagKey.class, int.class, float.class, float.class, int.class, Supplier.class},
                            material.getIncorrectBlocksForDrops(), material.getUses(), material.getSpeed(), material.getAttackDamageBonus(), material.getEnchantmentValue(), (Supplier<Ingredient>) material::getRepairIngredient
                    );

                    RegistrySupplier<Item> item = ITEMS.register(materialName + "_spear", () -> new SpearItem(material, ((Item$PropertiesBridge) new Item.Properties()).spear(TIER, spearData.swingSeconds(), spearData.kineticDamageMultiplier(), spearData.delaySeconds(), spearData.damageCondDurationSeconds(), spearData.damageCondMinSpeed(), spearData.knockbackCondDurationSeconds(), spearData.knockbackCondMinSpeed(), spearData.dismountCondDurationSeconds(), spearData.dismountCondMinRelativeSpeed())));

                    REGISTERED_SPEARS.computeIfAbsent(compatMod.getModID(), k -> new ArrayList<>()).add(item);
                    REGISTRY_SUPPLIER_TO_MATERIAL.put(item, materialName);
                }

                ITEMS.register();
                BarchedES.LOGGER.info("Successfully registered Spears to "+ compatMod.getModID() + ". Found material count: " + materialCount);
            }
        }
    }

    public static void registerItemsToInvTab(CreativeModeTab.Output output, String nameSpace) {
        BarchedES.LOGGER.info("Register Spears to CreativeMode Tab: " + nameSpace);
        for (RegistrySupplier<Item> item : RegisterFactory.REGISTERED_SPEARS.get(nameSpace)) {
            output.accept(item.get());
        }
    }
}
