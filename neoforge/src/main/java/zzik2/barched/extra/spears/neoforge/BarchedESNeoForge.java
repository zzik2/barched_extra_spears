package zzik2.barched.extra.spears.neoforge;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import zzik2.barched.extra.spears.BarchedES;
import net.neoforged.fml.common.Mod;
import zzik2.barched.extra.spears.BarchedESClient;
import zzik2.barched.extra.spears.registry.RegisterFactory;

@Mod(BarchedES.MOD_ID)
public final class BarchedESNeoForge {
    public BarchedESNeoForge(IEventBus eventBus) {
        // Run our common setup.
        BarchedES.init();

        if (FMLEnvironment.dist.isClient()) {
            eventBus.addListener(FMLClientSetupEvent.class, event -> {
                BarchedESClient.init();
            });
        }

        eventBus.addListener(BuildCreativeModeTabContentsEvent.class, event -> {
            ResourceLocation resourceLocation = BuiltInRegistries.CREATIVE_MODE_TAB.getKey(event.getTab());
            String nameSpace = resourceLocation.getNamespace();
            if (nameSpace != null && RegisterFactory.REGISTERED_SPEARS.containsKey(nameSpace)) {
                RegisterFactory.registerItemsToInvTab(event, nameSpace);
            }
        });
    }
}
