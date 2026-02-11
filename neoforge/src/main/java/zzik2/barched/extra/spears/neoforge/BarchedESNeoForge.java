package zzik2.barched.extra.spears.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import zzik2.barched.extra.spears.BarchedES;
import net.neoforged.fml.common.Mod;
import zzik2.barched.extra.spears.BarchedESClient;

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
    }
}
