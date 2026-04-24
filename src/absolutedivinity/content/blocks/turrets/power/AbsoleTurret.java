package absolutedivinity.content.blocks.turrets.power;

import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ContinuousFlameBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootBarrel;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.LaserTurret;
import mindustry.world.draw.DrawTurret;

public class AbsoleTurret {

    public static LaserTurret absole;

    public static void load() {
        absole = new LaserTurret("absole") {{
            localizedName = "Absole";
            description = "Inflicts a high energy burn upon enemies via a highly concentrated laser.";
            size = 4;
            reload = 120f;
            shootWarmupSpeed = 0.025f;
            minWarmup = 0.99f;
            warmupMaintainTime = 300f;
            shootDuration = 240f;
            category = Category.turret;
            shootEffect = Fx.shootBigSmoke2;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 800,
                Items.metaglass, 500,
                Items.silicon, 500,
                Items.titanium, 700,
                Items.plastanium, 110,
                Items.surgeAlloy, 150
            ));
            //shootSound = Sounds.laserbig;
            //loopSound = Sounds.gasTorchBurn;
            loopSoundVolume = 1.6f;
            coolantMultiplier = 0.5f;
            consumePower(8f);
            consumeCoolant(0.4f);
            shoot = new ShootBarrel() {{
                barrels = new float[]{
                    0f, 2f, 0f,
                    -12f, -5f, 5f,
                    12f, -5f, -5f
                };
                barrelOffset = 1;
                shotDelay = 20f;
                shots = 3;
                firstShotDelay = 110f;
            }};
            drawer = new DrawTurret() {{
                parts.add(new RegionPart() {{
                    mirror = false;
                    suffix = "-laser-unit-l";
                    progress = PartProgress.warmup;
                    under = true;
                    moveX = -6f;
                    moveY = -2f;
                    moveRot = 4.5f;
                }});
                parts.add(new RegionPart() {{
                    mirror = false;
                    suffix = "-laser-unit-r";
                    under = true;
                    moveX = 6f;
                    moveY = -2f;
                    moveRot = -4.5f;
                }});
            }};
            shake = 1f;
            heatColor = Color.valueOf("ff0000");
            cooldownTime = 50f;
            range = 350f;
            shootCone = 20f;
            scaledHealth = 210;
            rotateSpeed = 1.7f;
            targetAir = true;
            targetGround = true;
            //chargeSound = Sounds.energyCharge;
            shootType = new ContinuousFlameBulletType() {{
                chargeEffect = new MultiEffect(
                    new ParticleEffect() {{
                        particles = 8;
                        colorFrom = Color.valueOf("d99f6b");
                        colorTo = Color.valueOf("e8d174");
                        sizeFrom = 4f;
                        sizeTo = 1f;
                        length = 40f;
                        baseLength = 10f;
                        sizeInterp = Interp.pow2In;
                        interp = Interp.pow2Out;
                    }},
                    new ParticleEffect() {{
                        particles = 8;
                        colorFrom = Color.valueOf("e8d174");
                        colorTo = Color.valueOf("d99f6b");
                        sizeFrom = 4f;
                        sizeTo = 1f;
                        length = 10f;
                        baseLength = 40f;
                        sizeInterp = Interp.pow2In;
                        interp = Interp.pow2Out;
                    }}
                );
                colors = new Color[]{
                    Color.valueOf("d99f6b"),
                    Color.valueOf("e8d174"),
                    Color.valueOf("fcf387"),
                    Color.valueOf("fffab8"),
                    Color.valueOf("ffffff")
                };
                flareColor = Color.valueOf("e8d174");
                flareLength = 15f;
                flareWidth = 5f;
                flareRotSpeed = 0.6f;
                width = 3f;
                length = 310f;
                damage = 160f;
                damageInterval = 20f;
                largeHit = true;
                shake = 3f;
                pierceCap = 10;
                despawnShake = 2f;
                hitColor = Color.valueOf("e8d174");
                status = StatusEffects.burning; // placeholder for "fadingrevelations-high-energy-burn"
                statusDuration = 180f;
            }};
        }};
    }
}
