package absolutedivinity.content;

import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.effect.ParticleEffect;
import mindustry.type.StatusEffect;

public class ADStatusEffects {

    public static StatusEffect
        efficiencyDrop,
        acidicBurn,
        emp,
        hastened,
        highEnergyBurn,
        japonicaWeakened,
        mediumDownraft,
        minimalDownraft,
        neutronFrozen,
        polymorphousBuilding,
        powerfulDownraft,
        radiated,
        shockslowed,
        slightDownraft,
        superHastened,
        funnyEffect;

        public static void load() {

            efficiencyDrop = new StatusEffect("efficiency-drop"){{
                localizedName = "Efficiency Drop";
                buildSpeedMultiplier = 0.8f;
                speedMultiplier = 0.8f;
            }};

            acidicBurn = new StatusEffect("acidic-burn"){{
                localizedName = "Acidic Burn";
                speedMultiplier = 0.8f;
                damageMultiplier = 0.8f;
                effect = Fx.none;
            }};

            emp = new StatusEffect("emp"){{
                localizedName = "Emp";
                speedMultiplier = 0.4f;
                damageMultiplier = 0.6f;
                healthMultiplier = 0.8f;
                reloadMultiplier = 0.7f;
            }};

            hastened = new StatusEffect("hastened"){{
                localizedName = "Hastened";
                reloadMultiplier = 1.6f;
                alwaysUnlocked = true;
            }};

            highEnergyBurn = new StatusEffect("high-energy-burn"){{
                localizedName = "High Energy Burn";
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

            japonicaWeakened = new StatusEffect("japonica-weakened"){{
                localizedName = "Japonica Weakened";
                buildSpeedMultiplier = 0.8f;
                damageMultiplier = 0.8f;
                reloadMultiplier = 0.8f;
                alwaysUnlocked = true;
                speedMultiplier = 0.8f;
            }};

            mediumDownraft = new StatusEffect("medium-downraft"){{
                localizedName = "Medium Downraft";
                speedMultiplier = 0.7f;
                alwaysUnlocked = true;
                effect = Fx.none;
            }};

            minimalDownraft = new StatusEffect("minimal-downraft"){{
                localizedName = "Minimal Downraft";
                speedMultiplier = 0.9f;
                alwaysUnlocked = true;
                effect = Fx.none;
            }};

            neutronFrozen = new StatusEffect("neutron-frozen"){{
                localizedName = "Neutron Frozen";
                alwaysUnlocked = true;
                speedMultiplier = 0.4f;
                reloadMultiplier = 0.7f;
                damage = 0.1f;
            }};

            polymorphousBuilding = new StatusEffect("polymorphous-building"){{
                localizedName = "Polymorphous Building";
                buildSpeedMultiplier = 1.2f;
            }};

            powerfulDownraft = new StatusEffect("powerful-downraft"){{
                localizedName = "Powerful Downraft";
                speedMultiplier = 0.6f;
                alwaysUnlocked = true;
                effect = Fx.none;
            }};

            radiated = new StatusEffect("radiated"){{
                localizedName = "Radiated";
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

            shockslowed = new StatusEffect("shockslowed"){{
                localizedName = "Shock-Slowed";
                speedMultiplier = 0.3f;
                alwaysUnlocked = true;
            }};

            slightDownraft = new StatusEffect("slight-downraft"){{
                localizedName = "Slight Downraft";
                speedMultiplier = 0.8f;
                alwaysUnlocked = true;
                effect = Fx.none;
            }};

            superHastened = new StatusEffect("super-hastened"){{
                localizedName = "Super Hastened";
                reloadMultiplier = 2.2f;
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
