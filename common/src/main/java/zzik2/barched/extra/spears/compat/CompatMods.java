package zzik2.barched.extra.spears.compat;

import zzik2.barched.extra.spears.compat.impl.BronzeCompat;
import zzik2.barched.extra.spears.compat.impl.ParadiseLostCompat;
import zzik2.barched.extra.spears.compat.impl.ProgressionRebornCompat;

public enum CompatMods {

    BRONZE(new BronzeCompat()),
    PARADISE_LOST(new ParadiseLostCompat()),
    PROGRESSION_REBORN(new ProgressionRebornCompat())
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
