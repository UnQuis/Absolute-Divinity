package absolutedivinity.content.blocks.turrets.power;

import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.ContinuousLaserBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.pattern.ShootPattern;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class CavalryTurret {

    public static PowerTurret cavalry;

    public static void load() {
        cavalry = new PowerTurret("cavalry") {{
            localizedName = "Cavalry";
            description = "Launches a rapidly pulsating, cascading plasma orb.";
            size = 5;
            health = 2850;
            reload = 200f;
            heatColor = Color.valueOf("ff795e");
            range = 240f;
            shootCone = 7f;
            moveWhileCharging = false;
            recoil = 3f;
            recoilTime = 180f;
            shake = 1.1f;
            shoot = new ShootPattern() {{
                firstShotDelay = 120f;
            }};
            //chargeSound = Sounds.energyCharge;
            rotateSpeed = 1f;
            targetAir = false;
            //shootSound = Sounds.cavalryShoot;
            consumePower(32f);
            shootEffect = new MultiEffect(
                new WaveEffect() {{
                    colorFrom = Color.valueOf("66B1FF");
                    colorTo = Color.valueOf("E4FDFF");
                    sizeFrom = 10f;
                    sizeTo = 0f;
                    lifetime = 199f;
                }}
            );
            shootType = new BasicBulletType(3f, 880f) {{
                chargeEffect = new MultiEffect(
                    new ParticleEffect() {{
                        followParent = true;
                        particles = 20;
                        offset = 100f;
                        sizeFrom = 1f;
                        sizeTo = 6f;
                        length = 40f;
                        baseLength = -40f;
                        interp = Interp.pow3In;
                        sizeInterp = Interp.pow5Out;
                        lifetime = 90f;
                        colorFrom = Color.valueOf("a4b8fa");
                        colorTo = Color.valueOf("7575c8");
                    }},
                    new WaveEffect() {{
                        lifetime = 110f;
                        sizeFrom = 50f;
                        sizeTo = 0f;
                        interp = Interp.pow5Out;
                        strokeFrom = 0f;
                        strokeTo = 4f;
                        colorFrom = Color.valueOf("a4b8fa");
                        colorTo = Color.valueOf("7575c8");
                    }},
                    new WaveEffect() {{
                        lifetime = 120f;
                        sizeFrom = 60f;
                        sizeTo = 0f;
                        interp = Interp.pow10Out;
                        strokeFrom = 0f;
                        strokeTo = 4f;
                        colorFrom = Color.valueOf("a4b8fa");
                        colorTo = Color.valueOf("7575c8");
                    }},
                    new ParticleEffect() {{
                        followParent = true;
                        particles = 20;
                        offset = 130f;
                        sizeFrom = 1f;
                        sizeTo = 6f;
                        length = 50f;
                        baseLength = -40f;
                        interp = Interp.pow3In;
                        sizeInterp = Interp.pow5Out;
                        lifetime = 90f;
                        colorFrom = Color.valueOf("a4b8fa");
                        colorTo = Color.valueOf("7575c8");
                    }},
                    new ParticleEffect() {{
                        followParent = true;
                        particles = 20;
                        offset = 140f;
                        sizeFrom = 1f;
                        sizeTo = 6f;
                        length = 60f;
                        baseLength = -40f;
                        interp = Interp.pow3In;
                        sizeInterp = Interp.pow5Out;
                        lifetime = 90f;
                        colorFrom = Color.valueOf("a4b8fa");
                        colorTo = Color.valueOf("7575c8");
                    }},
                    new WaveEffect() {{
                        lifetime = 150f;
                        sizeFrom = 60f;
                        sizeTo = 0f;
                        interp = Interp.pow10Out;
                        strokeFrom = 0f;
                        strokeTo = 4f;
                        colorFrom = Color.valueOf("a4b8fa");
                        colorTo = Color.valueOf("7575c8");
                    }}
                );
                sprite = "large-orb";
                width = 0.001f;
                hitSize = 32f;
                //hitSound = Sounds.mediumCannon;
                //despawnSound = Sounds.mediumCannon;
                height = 0.001f;
                speed = 3f;
                lifetime = 80f;
                spin = 9f;
                pierce = true;
                despawnEffect = new ExplosionEffect() {{
                    waveColor = Color.valueOf("7575c8");
                    smokeColor = Color.valueOf("7575c8");
                    sparkColor = Color.valueOf("a4b8fa");
                    waveStroke = 3f;
                    waveRad = 30f;
                }};
                hitEffect = new ExplosionEffect() {{
                    waveColor = Color.valueOf("7575c8");
                    smokeColor = Color.valueOf("7575c8");
                    sparkColor = Color.valueOf("a4b8fa");
                    waveStroke = 4f;
                    waveRad = 40f;
                }};
                despawnHit = true;
                fragBullets = 5;
                fragSpread = 72f;
                trailColor = Color.valueOf("66B1FF");
                backColor = Color.valueOf("66B1FF");
                frontColor = Color.valueOf("E4FDFF");
                trailLength = 50;
                trailWidth = 18f;
                trailChance = -1f;
                fragRandomSpread = 0f;
                fragLifeMin = 1f;
                fragLifeMax = 1f;
                fragVelocityMin = 1f;
                fragVelocityMax = 1f;
                fragBullet = new LaserBulletType() {{
                    //despawnSound = Sounds.laser;
                    //hitSound = Sounds.laser;
                    length = 80f;
                    width = 16f;
                    lifetime = 90f;
                    damage = 60f;
                    colors = new Color[]{
                        Color.valueOf("66B1FF"),
                        Color.valueOf("E4FDFF"),
                        Color.valueOf("FFFFFF")
                    };
                }};
                intervalBullets = 8;
                intervalRandomSpread = 0f;
                intervalSpread = 45f;
                bulletInterval = 10f;
                intervalBullet = new ContinuousLaserBulletType() {{
                    //despawnSound = Sounds.spark;
                    //hitSound = Sounds.spark;
                    length = 100f;
                    width = 4f;
                    lifetime = 19.5f;
                    damage = 75f;
                    damageInterval = 8f;
                    colors = new Color[]{
                        Color.valueOf("66B1FF"),
                        Color.valueOf("E4FDFF"),
                        Color.valueOf("56b1d7"),
                        Color.valueOf("91f7ff"),
                        Color.valueOf("FFFFFF")
                    };
                }};
                lightning = 6;
                lightningCone = 360f;
                lightningLength = 6;
                lightningDamage = 145f;
            }};
            requirements(Category.turret, ItemStack.with(
                Items.copper, 1500,
                Items.lead, 500,
                Items.graphite, 600,
                Items.silicon, 550,
                Items.surgeAlloy, 575
            ));
            category = Category.turret;
        }};
    }
}
