package absolutedivinity.content.blocks.turrets.order;

import absolutedivinity.content.ADEffects;
import absolutedivinity.content.ADNHEffects;
import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class OrderAnnihilator {
    public static PowerTurret orderAnnihilator;

    public static void load() {{
        orderAnnihilator = new PowerTurret("order-annihilator") {{
            localizedName = "Order Annihilator";
            description = "Fires a divine orb that explodes into a storm of white lightning chains, annihilating everything.";
            size = 12;
            health = 160000;
            armor = 22;
            range = 680f;
            reload = 540f;
            rotateSpeed = 0.4f;
            shootCone = 5f;
            targetAir = true;
            targetGround = true;
            minWarmup = 0.92f;
            shootWarmupSpeed = 0.012f;
            shootEffect = new MultiEffect(
                ADNHEffects.instShoot,
                ADNHEffects.crossBlast,
                ADNHEffects.chargeEffect
            );
            heatColor = Color.white;
            consumePower(180f);
            consumeCoolant(3f);
            requirements(Category.turret, ItemStack.with(
                Items.copper, 14000,
                Items.silicon, 11000,
                Items.titanium, 7500,
                Items.thorium, 4500,
                Items.surgeAlloy, 2800
            ));
            category = Category.turret;
            shootType = new BasicBulletType(5f, 1200f) {{
                width = 40f;
                height = 40f;
                sprite = "large-orb";
                lifetime = 180f;
                splashDamage = 5000f;
                splashDamageRadius = 320f;
                knockback = 60f;
                pierce = true;
                pierceArmor = true;
                pierceCap = -1;
                collidesAir = true;
                collidesGround = true;
                buildingDamageMultiplier = 2.5f;
                hitShake = 80f;
                despawnShake = 120f;
                lightning = 16;
                lightningDamage = 700f;
                lightningLength = 50;
                lightningLengthRand = 50;
                lightningCone = 360f;
                lightningColor = Color.white;
                hitEffect = new MultiEffect(
                    ADNHEffects.instHit,
                    ADNHEffects.crossBlast45,
                    ADNHEffects.hitSparkHuge
                );
                despawnEffect = new MultiEffect(
                    ADNHEffects.instBomb,
                    ADNHEffects.circleOut
                );
                shootEffect = Fx.none;
                smokeEffect = Fx.shootSmokeTitan;
                trailEffect = ADEffects.orderTrail;
                trailChance = 1f;
                trailLength = 50;
                trailWidth = 10f;
                shrinkX = 0f;
                shrinkY = 0f;
                backColor = Color.white;
                frontColor = Color.white;
                mixColorFrom = Color.white;
                mixColorTo = Color.valueOf("e0e0e0");
                fragBullets = 24;
                fragBullet = new BasicBulletType(4f, 600f) {{
                    width = 18f;
                    height = 22f;
                    sprite = "large-orb";
                    lifetime = 90f;
                    splashDamage = 500f;
                    splashDamageRadius = 90f;
                    hitShake = 20f;
                    hitEffect = new MultiEffect(
                        ADNHEffects.hitSparkLarge,
                        ADNHEffects.circleOut
                    );
                    despawnEffect = new MultiEffect(
                        ADNHEffects.hitSparkLarge,
                        ADNHEffects.circleOut
                    );
                    trailEffect = ADEffects.orderTrail;
                    trailChance = 1f;
                    trailLength = 16;
                    trailWidth = 4.5f;
                    backColor = Color.white;
                    frontColor = Color.white;
                    lightning = 4;
                    lightningDamage = 120f;
                    lightningLength = 25;
                    lightningColor = Color.white;
                }};
            }};
        }};
    }}
}
