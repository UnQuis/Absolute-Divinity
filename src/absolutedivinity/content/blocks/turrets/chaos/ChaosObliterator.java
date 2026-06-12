package absolutedivinity.content.blocks.turrets.chaos;

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

public class ChaosObliterator {
    public static ItemTurret chaosObliterator;

    public static void load() {{
        chaosObliterator = new ItemTurret("chaos-oblivion") {{
            localizedName = "Chaos Obliterator";
            description = "The ultimate expression of chaos. Fires a world-ending projectile that tears reality apart.";
            size = 11;
            health = 100000;
            armor = 20;
            range = 420f;
            reload = 280f;
            rotateSpeed = 0.7f;
            shootCone = 5f;
            targetAir = true;
            targetGround = true;
            minWarmup = 0.9f;
            shootWarmupSpeed = 0.013f;
            shootEffect = new MultiEffect(
                ADTurretEffects.shootBig(ADColor.chaosMain),
                new WaveEffect() {{
                    sizeFrom = 0f;
                    sizeTo = 160f;
                    colorFrom = ADColor.chaosMain;
                    colorTo = ADColor.chaosDark;
                    strokeFrom = 10f;
                    strokeTo = 0f;
                    interp = Interp.pow5Out;
                }}
            );
            smokeEffect = ADTurretEffects.shootBig(ADColor.chaosDark);
            heatColor = ADColor.chaosMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 8000,
                Items.silicon, 6500,
                Items.titanium, 4500,
                Items.thorium, 2800,
                Items.surgeAlloy, 1600
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new BasicBulletType(8f, 1000f) {{
                width = 24f;
                height = 28f;
                lifetime = 60f;
                hitEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.chaosMain, 140f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 250f;
                        colorFrom = ADColor.chaosMain;
                        colorTo = ADColor.chaosLight;
                        strokeFrom = 12f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }},
                    new ParticleEffect() {{
                        sizeFrom = 12f;
                        sizeTo = 3f;
                        colorFrom = ADColor.chaosMain;
                        colorTo = ADColor.chaosLight;
                        length = 0f;
                        baseLength = 0f;
                        lifetime = 80f;
                        particles = 70;
                        interp = Interp.exp5;
                        sizeInterp = Interp.pow5Out;
                    }}
                );
                despawnEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.chaosMain, 160f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 320f;
                        colorFrom = ADColor.chaosMain;
                        colorTo = ADColor.chaosLight;
                        strokeFrom = 16f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }},
                    new ParticleEffect() {{
                        sizeFrom = 16f;
                        sizeTo = 4f;
                        colorFrom = ADColor.chaosMain;
                        colorTo = ADColor.chaosLight;
                        length = 0f;
                        baseLength = 0f;
                        lifetime = 100f;
                        particles = 90;
                        interp = Interp.exp5;
                        sizeInterp = Interp.pow5Out;
                    }}
                );
                smokeEffect = ADTurretEffects.shootBig(ADColor.chaosDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.chaosMain);
                trailChance = 1f;
                frontColor = Color.white;
                backColor = ADColor.chaosMain;
                knockback = 12f;
                hitShake = 18f;
                splashDamageRadius = 90f;
                splashDamage = 450f;
                pierce = true;
                pierceArmor = true;
                pierceCap = -1;
                lightning = 12;
                lightningDamage = 80f;
                lightningLength = 30;
                lightningColor = ADColor.chaosGlow;
                status = StatusEffects.burning;
                statusDuration = 400f;
            }});
            ammo(ADItems.divinite, new BasicBulletType(10f, 1800f) {{
                width = 30f;
                height = 34f;
                lifetime = 52f;
                hitEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.chaosMain, 200f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 400f;
                        colorFrom = ADColor.chaosMain;
                        colorTo = ADColor.chaosLight;
                        strokeFrom = 20f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }},
                    new ParticleEffect() {{
                        sizeFrom = 20f;
                        sizeTo = 5f;
                        colorFrom = ADColor.chaosMain;
                        colorTo = ADColor.chaosLight;
                        length = 0f;
                        baseLength = 0f;
                        lifetime = 120f;
                        particles = 120;
                        interp = Interp.exp5;
                        sizeInterp = Interp.pow5Out;
                    }}
                );
                despawnEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.chaosMain, 220f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 500f;
                        colorFrom = ADColor.chaosMain;
                        colorTo = ADColor.chaosLight;
                        strokeFrom = 24f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }}
                );
                smokeEffect = ADTurretEffects.shootBig(ADColor.chaosDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.chaosMain);
                trailChance = 1f;
                frontColor = Color.white;
                backColor = ADColor.chaosMain;
                knockback = 16f;
                hitShake = 22f;
                splashDamageRadius = 120f;
                splashDamage = 800f;
                pierce = true;
                pierceArmor = true;
                pierceCap = -1;
                lightning = 18;
                lightningDamage = 120f;
                lightningLength = 40;
                lightningColor = ADColor.chaosGlow;
                status = StatusEffects.melting;
                statusDuration = 600f;
            }});
        }};
    }}
}
