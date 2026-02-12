package zzik2.barched.extra.spears.compat;

import zzik2.barched.extra.spears.compat.impl.BronzeCompat;
import zzik2.barched.extra.spears.compat.impl.ParadiseLostCompat;

public enum CompatMods {

    BRONZE(new BronzeCompat()),
    PARADISE_LOST(new ParadiseLostCompat())
    ;

    private final ICompatMod compatMod;

    CompatMods(ICompatMod compatMod) {
        this.compatMod = compatMod;
    }

    public ICompatMod getCompatMod() {
        return compatMod;
    }

    public boolean isModLoaded() {
        return compatMod.isModLoaded();
    }
}
