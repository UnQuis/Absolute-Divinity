package absolutedivinity.content.blocks.turrets.time;

import absolutedivinity.content.ADItems;
import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChronoObliterator {
    public static ItemTurret chronoObliterator;

    public static void load() {{
        chronoObliterator = new ItemTurret("chrono-oblivion") {{
            localizedName = "Chrono Obliterator";
            description = "The ultimate temporal weapon. Fires a projectile that freezes time itself around the impact zone.";
            size = 9;
            health = 70000;
            armor = 16;
            range = 380f;
            reload = 260f;
            rotateSpeed = 0.9f;
            shootCone = 5f;
            targetAir = true;
            targetGround = true;
            minWarmup = 0.88f;
            shootWarmupSpeed = 0.014f;
            shootEffect = new MultiEffect(
                ADTurretEffects.shootBig(ADColor.timeMain),
                new WaveEffect() {{
                    sizeFrom = 0f;
                    sizeTo = 140f;
                    colorFrom = ADColor.timeMain;
                    colorTo = ADColor.timeDark;
                    strokeFrom = 8f;
                    strokeTo = 0f;
                    interp = Interp.pow5Out;
                }}
            );
            smokeEffect = ADTurretEffects.shootBig(ADColor.timeDark);
            heatColor = ADColor.timeMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 5000,
                Items.silicon, 4000,
                Items.titanium, 2800,
                Items.thorium, 1800,
                Items.surgeAlloy, 1000
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new BasicBulletType(8f, 900f) {{
                width = 20f;
                height = 24f;
                lifetime = 58f;
                hitEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.timeMain, 120f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 220f;
                        colorFrom = ADColor.timeMain;
                        colorTo = ADColor.timeLight;
                        strokeFrom = 10f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }},
                    new ParticleEffect() {{
                        sizeFrom = 10f;
                        sizeTo = 2f;
                        colorFrom = ADColor.timeMain;
                        colorTo = ADColor.timeLight;
                        length = 0f;
                        baseLength = 0f;
                        lifetime = 70f;
                        particles = 60;
                        interp = Interp.exp5;
                        sizeInterp = Interp.pow5Out;
                    }}
                );
                despawnEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.timeMain, 150f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 300f;
                        colorFrom = ADColor.timeMain;
                        colorTo = ADColor.timeLight;
                        strokeFrom = 14f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }}
                );
                smokeEffect = ADTurretEffects.shootBig(ADColor.timeDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.timeMain);
                trailChance = 0.9f;
                frontColor = Color.white;
                backColor = ADColor.timeMain;
                knockback = 10f;
                hitShake = 16f;
                splashDamageRadius = 85f;
                splashDamage = 400f;
                pierce = true;
                pierceArmor = true;
                pierceCap = -1;
                lightning = 10;
                lightningDamage = 50f;
                lightningLength = 22;
                lightningColor = ADColor.timeGlow;
                status = StatusEffects.freezing;
                statusDuration = 600f;
            }});
            ammo(ADItems.divinite, new BasicBulletType(10f, 1600f) {{
                width = 26f;
                height = 30f;
                lifetime = 50f;
                hitEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.timeMain, 180f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 380f;
                        colorFrom = ADColor.timeMain;
                        colorTo = ADColor.timeLight;
                        strokeFrom = 18f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }},
                    new ParticleEffect() {{
                        sizeFrom = 14f;
                        sizeTo = 3f;
                        colorFrom = ADColor.timeMain;
                        colorTo = ADColor.timeLight;
                        length = 0f;
                        baseLength = 0f;
                        lifetime = 90f;
                        particles = 90;
                        interp = Interp.exp5;
                        sizeInterp = Interp.pow5Out;
                    }}
                );
                despawnEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.timeMain, 200f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 450f;
                        colorFrom = ADColor.timeMain;
                        colorTo = ADColor.timeLight;
                        strokeFrom = 20f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }}
                );
                smokeEffect = ADTurretEffects.shootBig(ADColor.timeDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.timeMain);
                trailChance = 1f;
                frontColor = Color.white;
                backColor = ADColor.timeMain;
                knockback = 14f;
                hitShake = 20f;
                splashDamageRadius = 110f;
                splashDamage = 700f;
                pierce = true;
                pierceArmor = true;
                pierceCap = -1;
                lightning = 16;
                lightningDamage = 90f;
                lightningLength = 32;
                lightningColor = ADColor.timeGlow;
                status = StatusEffects.freezing;
                statusDuration = 900f;
            }});
        }};
    }}
}
