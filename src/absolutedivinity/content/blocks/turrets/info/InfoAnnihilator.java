package absolutedivinity.content.blocks.turrets.info;

import absolutedivinity.content.ADItems;
import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoAnnihilator {
    public static ItemTurret infoAnnihilator;

    public static void load() {{
        infoAnnihilator = new ItemTurret("info-annihilator") {{
            localizedName = "Info Annihilator";
            description = "Launches a devastating swarm of precision-guided missiles that track and destroy all targets.";
            size = 10;
            health = 85000;
            armor = 19;
            range = 400f;
            reload = 180f;
            rotateSpeed = 0.85f;
            shootCone = 5f;
            targetAir = true;
            targetGround = true;
            minWarmup = 0.9f;
            shootWarmupSpeed = 0.012f;
            shootEffect = new MultiEffect(
                ADTurretEffects.shootBig(ADColor.infoMain),
                new WaveEffect() {{
                    sizeFrom = 0f;
                    sizeTo = 150f;
                    colorFrom = ADColor.infoMain;
                    colorTo = ADColor.infoDark;
                    strokeFrom = 8f;
                    strokeTo = 0f;
                    interp = Interp.pow5Out;
                }}
            );
            smokeEffect = ADTurretEffects.shootBig(ADColor.infoDark);
            heatColor = ADColor.infoMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 6500,
                Items.silicon, 5200,
                Items.titanium, 3600,
                Items.thorium, 2200,
                Items.surgeAlloy, 1300
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new MissileBulletType(6f, 150f) {{
                width = 12f;
                height = 12f;
                lifetime = 80f;
                hitEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.infoMain, 80f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 150f;
                        colorFrom = ADColor.infoMain;
                        colorTo = ADColor.infoLight;
                        strokeFrom = 8f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }}
                );
                despawnEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.infoMain, 100f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 200f;
                        colorFrom = ADColor.infoMain;
                        colorTo = ADColor.infoLight;
                        strokeFrom = 10f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }}
                );
                trailEffect = ADTurretEffects.trailEffect(ADColor.infoMain);
                trailChance = 0.8f;
                frontColor = Color.white;
                backColor = ADColor.infoMain;
                homingPower = 0.15f;
                homingRange = 200f;
                homingDelay = 5f;
                knockback = 6f;
                hitShake = 10f;
                splashDamageRadius = 50f;
                splashDamage = 180f;
                lightning = 4;
                lightningDamage = 30f;
                lightningLength = 15;
                lightningColor = ADColor.infoGlow;
                fragBullets = 8;
                fragBullet = new MissileBulletType(5f, 80f) {{
                    width = 8f;
                    height = 8f;
                    lifetime = 60f;
                    hitEffect = ADTurretEffects.hitBig(ADColor.infoMain);
                    despawnEffect = ADTurretEffects.hitBig(ADColor.infoMain);
                    trailEffect = ADTurretEffects.trailEffect(ADColor.infoMain);
                    trailChance = 0.6f;
                    frontColor = ADColor.infoLight;
                    backColor = ADColor.infoMain;
                    homingPower = 0.12f;
                    homingRange = 150f;
                    knockback = 3f;
                    splashDamageRadius = 30f;
                    splashDamage = 60f;
                    lightning = 2;
                    lightningDamage = 15f;
                    lightningLength = 8;
                    lightningColor = ADColor.infoGlow;
                }};
            }});
            ammo(ADItems.divinite, new MissileBulletType(7f, 250f) {{
                width = 16f;
                height = 16f;
                lifetime = 70f;
                hitEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.infoMain, 120f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 250f;
                        colorFrom = ADColor.infoMain;
                        colorTo = ADColor.infoLight;
                        strokeFrom = 12f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }}
                );
                despawnEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.infoMain, 140f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 300f;
                        colorFrom = ADColor.infoMain;
                        colorTo = ADColor.infoLight;
                        strokeFrom = 14f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }}
                );
                trailEffect = ADTurretEffects.trailEffect(ADColor.infoMain);
                trailChance = 1f;
                frontColor = Color.white;
                backColor = ADColor.infoMain;
                homingPower = 0.18f;
                homingRange = 250f;
                homingDelay = 3f;
                knockback = 10f;
                hitShake = 14f;
                splashDamageRadius = 70f;
                splashDamage = 350f;
                lightning = 6;
                lightningDamage = 50f;
                lightningLength = 20;
                lightningColor = ADColor.infoGlow;
                fragBullets = 12;
                fragBullet = new MissileBulletType(6f, 120f) {{
                    width = 10f;
                    height = 10f;
                    lifetime = 65f;
                    hitEffect = ADTurretEffects.hitBig(ADColor.infoMain);
                    despawnEffect = ADTurretEffects.blastEffect(ADColor.infoMain, 30f);
                    trailEffect = ADTurretEffects.trailEffect(ADColor.infoMain);
                    trailChance = 0.8f;
                    frontColor = ADColor.infoLight;
                    backColor = ADColor.infoMain;
                    homingPower = 0.14f;
                    homingRange = 180f;
                    knockback = 5f;
                    splashDamageRadius = 40f;
                    splashDamage = 100f;
                    lightning = 3;
                    lightningDamage = 25f;
                    lightningLength = 12;
                    lightningColor = ADColor.infoGlow;
                }};
            }});
        }};
    }}
}
