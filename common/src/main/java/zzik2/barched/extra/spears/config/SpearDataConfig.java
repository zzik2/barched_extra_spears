package zzik2.barched.extra.spears.config;

import zzik2.barched.extra.spears.objects.items.SpearData;

public class SpearDataConfig {

    private float swingSeconds;
    private float kineticDamageMultiplier;
    private float delaySeconds;
    private float damageCondDurationSeconds;
    private float damageCondMinSpeed;
    private float knockbackCondDurationSeconds;
    private float knockbackCondMinSpeed;
    private float dismountCondDurationSeconds;
    private float dismountCondMinRelativeSpeed;

    public SpearDataConfig() {
    }

    public static SpearDataConfig fromSpearData(SpearData spearData) {
        SpearDataConfig config = new SpearDataConfig();
        config.swingSeconds = spearData.swingSeconds();
        config.kineticDamageMultiplier = spearData.kineticDamageMultiplier();
        config.delaySeconds = spearData.delaySeconds();
        config.damageCondDurationSeconds = spearData.damageCondDurationSeconds();
        config.damageCondMinSpeed = spearData.damageCondMinSpeed();
        config.knockbackCondDurationSeconds = spearData.knockbackCondDurationSeconds();
        config.knockbackCondMinSpeed = spearData.knockbackCondMinSpeed();
        config.dismountCondDurationSeconds = spearData.dismountCondDurationSeconds();
        config.dismountCondMinRelativeSpeed = spearData.dismountCondMinRelativeSpeed();
        return config;
    }

    public SpearData toSpearData() {
        return new SpearData(
                swingSeconds,
                kineticDamageMultiplier,
                delaySeconds,
                damageCondDurationSeconds,
                damageCondMinSpeed,
                knockbackCondDurationSeconds,
                knockbackCondMinSpeed,
                dismountCondDurationSeconds,
                dismountCondMinRelativeSpeed);
    }
}
