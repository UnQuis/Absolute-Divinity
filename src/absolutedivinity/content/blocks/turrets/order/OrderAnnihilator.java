package absolutedivinity.content.blocks.turrets.order;

import absolutedivinity.content.ADEffects;
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
            description = "The ultimate weapon of Order. Fires a colossal white energy orb that annihilates everything in its path with divine precision.";
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
                ADEffects.orderShootBig,
                new ParticleEffect() {{
                    sizeFrom = 12f;
                    sizeTo = 2f;
                    colorFrom = Color.white;
                    colorTo = Color.valueOf("e0e0e0");
                    length = -200f;
                    baseLength = 200f;
                    lifetime = 90f;
                    particles = 60;
                    interp = Interp.exp5;
                    sizeInterp = Interp.pow5Out;
                }},
                new ParticleEffect() {{
                    sizeFrom = 12f;
                    sizeTo = 2f;
                    colorFrom = Color.white;
                    colorTo = Color.valueOf("e0e0e0");
                    length = 200f;
                    baseLength = -200f;
                    lifetime = 90f;
                    particles = 60;
                    interp = Interp.exp5;
                    sizeInterp = Interp.pow5Out;
                }},
                new WaveEffect() {{
                    sizeFrom = 0f;
                    sizeTo = 180f;
                    colorFrom = Color.white;
                    colorTo = Color.valueOf("e0e0e0");
                    strokeFrom = 8f;
                    strokeTo = 0f;
                    interp = Interp.pow5Out;
                }}
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
                    ADEffects.orderAnnihilateHit,
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 240f;
                        colorFrom = Color.white;
                        colorTo = Color.valueOf("e0e0e0");
                        strokeFrom = 8f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }},
                    new ParticleEffect() {{
                        sizeFrom = 12f;
                        sizeTo = 2f;
                        colorFrom = Color.white;
                        colorTo = Color.valueOf("e0e0e0");
                        length = 0f;
                        baseLength = 0f;
                        lifetime = 80f;
                        particles = 60;
                        interp = Interp.exp5;
                        sizeInterp = Interp.pow5Out;
                    }}
                );
                despawnEffect = new MultiEffect(
                    ADEffects.orderAnnihilateBlast,
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 450f;
                        colorFrom = Color.white;
                        colorTo = Color.valueOf("e0e0e0");
                        strokeFrom = 16f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }},
                    new ParticleEffect() {{
                        sizeFrom = 16f;
                        sizeTo = 3f;
                        colorFrom = Color.white;
                        colorTo = Color.valueOf("e0e0e0");
                        length = 0f;
                        baseLength = 0f;
                        lifetime = 100f;
                        particles = 100;
                        interp = Interp.exp5;
                        sizeInterp = Interp.pow5Out;
                    }}
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
                fragBullets = 20;
                fragBullet = new BasicBulletType(4f, 600f) {{
                    width = 18f;
                    height = 22f;
                    sprite = "large-orb";
                    lifetime = 90f;
                    splashDamage = 500f;
                    splashDamageRadius = 90f;
                    hitShake = 20f;
                    hitEffect = ADEffects.orderHit;
                    despawnEffect = ADEffects.orderHit;
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
