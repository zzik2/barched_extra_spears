package zzik2.barched.extra.spears.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import zzik2.barched.extra.spears.BarchedESClient;

public final class BarchedESFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        BarchedESClient.init();
    }
}
