package absolutedivinity.content;

import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.effect.ParticleEffect;
import mindustry.type.StatusEffect;

public class ADStatusEffects {

    public static StatusEffect
        powerLeak,
        corrosiveMeltdown,
        circuitNull,
        overclocked,
        plasmaScorch,
        fracturedCore,
        gravityShear,
        gravityDisturbance,
        zeroKelvinLock,
        adaptiveReconstruction,
        gravitationalCollapse,
        irradiatedCore,
        neuroShock,
        gravityRipple,
        hyperOverclock,
        funnyEffect;

        public static void load() {

            powerLeak = new StatusEffect("power-leak"){{
                localizedName = "Power Leak";
                buildSpeedMultiplier = 0.8f;
                speedMultiplier = 0.8f;
            }};

            corrosiveMeltdown = new StatusEffect("corrosive-meltdown"){{
                localizedName = "Corrosive Meltdown";
                speedMultiplier = 0.8f;
                damageMultiplier = 0.8f;
                effect = Fx.none;
            }};

            circuitNull = new StatusEffect("circuit-null"){{
                localizedName = "Circuit NULL";
                speedMultiplier = 0.4f;
                damageMultiplier = 0.6f;
                healthMultiplier = 0.8f;
                reloadMultiplier = 0.7f;
            }};

            plasmaScorch = new StatusEffect("plasma-scorch"){{
                localizedName = "Plasma Scorch";
                alwaysUnlocked = true;
                damage = 0.4f;
                reloadMultiplier = 0.85f;
                color = Color.valueOf("e8d174");
                applyColor = Color.valueOf("e8d174");
                affinities.add(StatusEffects.wet);
                opposites.add(StatusEffects.tarred);
                effect = new ParticleEffect() {{
                    particles = 8;
                    sizeFrom = 1;
                    sizeTo = 2.7f;
                    colorFrom = Color.valueOf("e8d174");
                    colorTo = Color.valueOf("fffab8");
                    line = true;
                    strokeFrom = 0.6f;
                    strokeTo = 1;
                    interp = Interp.pow10Out;
                    sizeInterp = Interp.pow10Out;
                }};
            }};

            fracturedCore = new StatusEffect("fractured-core"){{
                localizedName = "Fractured Core";
                buildSpeedMultiplier = 0.8f;
                damageMultiplier = 0.8f;
                reloadMultiplier = 0.8f;
                alwaysUnlocked = true;
                speedMultiplier = 0.8f;
            }};

            gravityShear = new StatusEffect("gravity-shear"){{
                localizedName = "Gravity Shear";
                speedMultiplier = 0.7f;
                alwaysUnlocked = true;
                effect = Fx.none;
            }};

            gravityDisturbance = new StatusEffect("gravity-disturbance"){{
                localizedName = "Gravity Disturbance";
                speedMultiplier = 0.9f;
                alwaysUnlocked = true;
                effect = Fx.none;
            }};

            zeroKelvinLock = new StatusEffect("zero-kelvin-lock"){{
                localizedName = "Zero Kelvin Lock";
                alwaysUnlocked = true;
                speedMultiplier = 0.4f;
                reloadMultiplier = 0.7f;
                damage = 0.1f;
            }};

            adaptiveReconstruction = new StatusEffect("adaptive-reconstruction"){{
                localizedName = "Adaptive Reconstruction";
                buildSpeedMultiplier = 1.2f;
            }};

            gravitationalCollapse = new StatusEffect("gravitational-collapse"){{
                localizedName = "Gravitational Collapse";
                speedMultiplier = 0.6f;
                alwaysUnlocked = true;
                effect = Fx.none;
            }};

            irradiatedCore = new StatusEffect("irradiated-core"){{
                localizedName = "Irradiated Core";
                damage = 0.125f;
                permanent = true;
                alwaysUnlocked = true;
                speedMultiplier = 0.9f;
                reloadMultiplier = 0.9f;
                healthMultiplier = 0.9f;
                effect = new ParticleEffect(){{
                    particles = 8;
                    colorFrom = Color.valueOf("30af1f");
                    colorTo = Color.valueOf("328926");
                    interp = Interp.circleOut;
                }};
            }};

            neuroShock = new StatusEffect("neuro-shock"){{
                localizedName = "Neuro Shock";
                speedMultiplier = 0.3f;
                alwaysUnlocked = true;
            }};

            gravityRipple = new StatusEffect("gravity-ripple"){{
                localizedName = "Gravity Ripple";
                speedMultiplier = 0.8f;
                alwaysUnlocked = true;
                effect = Fx.none;
            }};

            overclocked = new StatusEffect("overclocked"){{
                localizedName = "Overclocked";
                reloadMultiplier = 2.2f;
                speedMultiplier = 1.8f;
                alwaysUnlocked = true;
            }};

            hyperOverclock = new StatusEffect("hyper-overclock"){{
                localizedName = "Hyper Overclock";
                reloadMultiplier = 4.3f;
                speedMultiplier = 2.1f;
                alwaysUnlocked = true;
            }};

            funnyEffect = new StatusEffect("funny-effect"){{
                localizedName = "Funny Effect";
                reloadMultiplier = Float.MAX_VALUE;
                speedMultiplier = 10f;
                healthMultiplier = Float.MAX_VALUE;
                buildSpeedMultiplier = Float.MAX_VALUE;
                permanent = true;
            }};
        }
}
