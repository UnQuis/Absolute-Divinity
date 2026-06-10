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
        orderAnnihilator = new PowerTurret("order-10") {{
            localizedName = "Order Annihilator";
            description = "The ultimate weapon of Order. Fires a colossal white energy orb that annihilates everything.";
            size = 8;
            health = 24000;
            armor = 15;
            range = 650f;
            reload = 480f;
            rotateSpeed = 0.6f;
            shootCone = 5f;
            targetAir = true;
            targetGround = true;
            shootEffect = new MultiEffect(
                ADEffects.orderShootBig,
                new ParticleEffect() {{
                    sizeFrom = 8f;
                    sizeTo = 2f;
                    colorFrom = Color.white;
                    colorTo = Color.valueOf("e0e0e0");
                    length = -150f;
                    baseLength = 150f;
                    lifetime = 70f;
                    particles = 40;
                    interp = Interp.exp5;
                    sizeInterp = Interp.pow5Out;
                }},
                new ParticleEffect() {{
                    sizeFrom = 8f;
                    sizeTo = 2f;
                    colorFrom = Color.white;
                    colorTo = Color.valueOf("e0e0e0");
                    length = 150f;
                    baseLength = -150f;
                    lifetime = 70f;
                    particles = 40;
                    interp = Interp.exp5;
                    sizeInterp = Interp.pow5Out;
                }},
                new WaveEffect() {{
                    sizeFrom = 0f;
                    sizeTo = 120f;
                    colorFrom = Color.white;
                    colorTo = Color.valueOf("e0e0e0");
                    strokeFrom = 6f;
                    strokeTo = 0f;
                    interp = Interp.pow5Out;
                }}
            );
            heatColor = Color.white;
            consumePower(80f);
            consumeCoolant(1f);
            shootType = new BasicBulletType(4f, 800f) {{
                width = 32f;
                height = 32f;
                sprite = "large-orb";
                lifetime = 160f;
                splashDamage = 3000f;
                splashDamageRadius = 250f;
                knockback = 40f;
                pierce = true;
                pierceArmor = true;
                pierceCap = -1;
                collidesAir = true;
                collidesGround = true;
                buildingDamageMultiplier = 2f;
                hitShake = 60f;
                despawnShake = 100f;
                lightning = 12;
                lightningDamage = 500f;
                lightningLength = 40;
                lightningLengthRand = 40;
                lightningCone = 360f;
                lightningColor = Color.white;
                hitEffect = new MultiEffect(
                    ADEffects.orderBlast,
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 300f;
                        colorFrom = Color.white;
                        colorTo = Color.valueOf("e0e0e0");
                        strokeFrom = 10f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }},
                    new ParticleEffect() {{
                        sizeFrom = 15f;
                        sizeTo = 3f;
                        colorFrom = Color.white;
                        colorTo = Color.valueOf("e0e0e0");
                        length = -300f;
                        baseLength = 300f;
                        lifetime = 120f;
                        particles = 60;
                        interp = Interp.exp5;
                        sizeInterp = Interp.pow5Out;
                    }},
                    new ParticleEffect() {{
                        sizeFrom = 15f;
                        sizeTo = 3f;
                        colorFrom = Color.white;
                        colorTo = Color.valueOf("e0e0e0");
                        length = 300f;
                        baseLength = -300f;
                        lifetime = 120f;
                        particles = 60;
                        interp = Interp.exp5;
                        sizeInterp = Interp.pow5Out;
                    }}
                );
                despawnEffect = new MultiEffect(
                    ADEffects.orderBlast,
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 300f;
                        colorFrom = Color.white;
                        colorTo = Color.valueOf("e0e0e0");
                        strokeFrom = 10f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }},
                    new ParticleEffect() {{
                        sizeFrom = 15f;
                        sizeTo = 3f;
                        colorFrom = Color.white;
                        colorTo = Color.valueOf("e0e0e0");
                        length = -300f;
                        baseLength = 300f;
                        lifetime = 120f;
                        particles = 60;
                        interp = Interp.exp5;
                        sizeInterp = Interp.pow5Out;
                    }},
                    new ParticleEffect() {{
                        sizeFrom = 15f;
                        sizeTo = 3f;
                        colorFrom = Color.white;
                        colorTo = Color.valueOf("e0e0e0");
                        length = 300f;
                        baseLength = -300f;
                        lifetime = 120f;
                        particles = 60;
                        interp = Interp.exp5;
                        sizeInterp = Interp.pow5Out;
                    }}
                );
                shootEffect = Fx.none;
                smokeEffect = Fx.shootSmokeTitan;
                trailEffect = ADEffects.orderTrail;
                trailChance = 1f;
                trailLength = 40;
                trailWidth = 8f;
                shrinkX = 0f;
                shrinkY = 0f;
                backColor = Color.white;
                frontColor = Color.white;
                mixColorFrom = Color.white;
                mixColorTo = Color.valueOf("e0e0e0");
                fragBullets = 16;
                fragBullet = new BasicBulletType(3f, 400f) {{
                    width = 14f;
                    height = 18f;
                    sprite = "large-orb";
                    lifetime = 70f;
                    splashDamage = 300f;
                    splashDamageRadius = 70f;
                    hitShake = 15f;
                    hitEffect = ADEffects.orderBlast;
                    despawnEffect = ADEffects.orderBlast;
                    trailEffect = ADEffects.orderTrail;
                    trailChance = 0.9f;
                    trailLength = 12;
                    trailWidth = 3.5f;
                    backColor = Color.white;
                    frontColor = Color.white;
                    lightning = 3;
                    lightningDamage = 80f;
                    lightningLength = 20;
                    lightningColor = Color.white;
                }};
            }};
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
