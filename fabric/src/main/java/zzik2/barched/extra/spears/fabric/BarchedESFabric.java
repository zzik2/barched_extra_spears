package zzik2.barched.extra.spears.fabric;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import zzik2.barched.extra.spears.BarchedES;
import net.fabricmc.api.ModInitializer;
import zzik2.barched.extra.spears.registry.RegisterFactory;

public final class BarchedESFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        BarchedES.init();

        ItemGroupEvents.MODIFY_ENTRIES_ALL.register(((group, entries) -> {
            ResourceLocation resourceLocation = BuiltInRegistries.CREATIVE_MODE_TAB.getKey(group);
            String nameSpace = resourceLocation.getNamespace();
            if (nameSpace != null && RegisterFactory.REGISTERED_SPEARS.containsKey(nameSpace)) {
                RegisterFactory.registerItemsToInvTab(entries, nameSpace);
            }
        }));
    }
}
