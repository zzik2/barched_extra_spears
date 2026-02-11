package zzik2.barched.extra.spears.compat;

import zzik2.barched.extra.spears.compat.impl.BronzeCompat;

public enum CompatMods {

    BRONZE(new BronzeCompat());

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
