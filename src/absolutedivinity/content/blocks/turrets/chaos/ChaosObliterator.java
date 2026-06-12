package absolutedivinity.content.blocks.turrets.chaos;

import absolutedivinity.content.ADItems;
import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ArtilleryBulletType;
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
            description = "Unleashes a devastating barrage of fire, lightning, and explosive shells simultaneously.";
            size = 11;
            health = 100000;
            armor = 20;
            range = 420f;
            reload = 180f;
            rotateSpeed = 0.7f;
            shootCone = 5f;
            targetAir = true;
            targetGround = true;
            minWarmup = 0.9f;
            shootWarmupSpeed = 0.013f;
            inaccuracy = 8f;
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
            ammo(Items.surgeAlloy, new BasicBulletType(6f, 300f) {{
                width = 16f;
                height = 18f;
                lifetime = 70f;
                hitEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.chaosMain, 80f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 180f;
                        colorFrom = ADColor.chaosMain;
                        colorTo = ADColor.chaosLight;
                        strokeFrom = 10f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }}
                );
                despawnEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.chaosMain, 100f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 250f;
                        colorFrom = ADColor.chaosMain;
                        colorTo = ADColor.chaosLight;
                        strokeFrom = 14f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }}
                );
                trailEffect = ADTurretEffects.trailEffect(ADColor.chaosMain);
                trailChance = 0.8f;
                frontColor = Color.white;
                backColor = ADColor.chaosMain;
                knockback = 6f;
                hitShake = 12f;
                splashDamageRadius = 60f;
                splashDamage = 200f;
                lightning = 8;
                lightningDamage = 40f;
                lightningLength = 18;
                lightningColor = ADColor.chaosGlow;
                status = StatusEffects.burning;
                statusDuration = 200f;
                fragBullets = 8;
                fragBullet = new ArtilleryBulletType(4f, 80f, "shell") {{
                    hitEffect = ADTurretEffects.hitBig(ADColor.chaosMain);
                    despawnEffect = ADTurretEffects.hitBig(ADColor.chaosMain);
                    width = 10f;
                    height = 10f;
                    lifetime = 60f;
                    hitShake = 6f;
                    splashDamageRadius = 35f;
                    splashDamage = 60f;
                    frontColor = ADColor.chaosLight;
                    backColor = ADColor.chaosMain;
                    status = StatusEffects.burning;
                    statusDuration = 120f;
                }};
            }});
            ammo(ADItems.divinite, new BasicBulletType(7f, 500f) {{
                width = 22f;
                height = 26f;
                lifetime = 60f;
                hitEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.chaosMain, 120f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 300f;
                        colorFrom = ADColor.chaosMain;
                        colorTo = ADColor.chaosLight;
                        strokeFrom = 14f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }}
                );
                despawnEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.chaosMain, 140f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 350f;
                        colorFrom = ADColor.chaosMain;
                        colorTo = ADColor.chaosLight;
                        strokeFrom = 18f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }}
                );
                trailEffect = ADTurretEffects.trailEffect(ADColor.chaosMain);
                trailChance = 1f;
                frontColor = Color.white;
                backColor = ADColor.chaosMain;
                knockback = 10f;
                hitShake = 16f;
                splashDamageRadius = 80f;
                splashDamage = 400f;
                lightning = 12;
                lightningDamage = 60f;
                lightningLength = 25;
                lightningColor = ADColor.chaosGlow;
                status = StatusEffects.melting;
                statusDuration = 300f;
                fragBullets = 12;
                fragBullet = new ArtilleryBulletType(5f, 120f, "shell") {{
                    hitEffect = ADTurretEffects.hitBig(ADColor.chaosMain);
                    despawnEffect = ADTurretEffects.blastEffect(ADColor.chaosMain, 40f);
                    width = 12f;
                    height = 12f;
                    lifetime = 70f;
                    hitShake = 8f;
                    splashDamageRadius = 45f;
                    splashDamage = 80f;
                    frontColor = ADColor.chaosLight;
                    backColor = ADColor.chaosMain;
                    status = StatusEffects.burning;
                    statusDuration = 180f;
                }};
            }});
        }};
    }}
}
