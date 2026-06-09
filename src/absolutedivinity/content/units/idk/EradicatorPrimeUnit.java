package absolutedivinity.content.units.idk;

import absolutedivinity.content.ADColor;
import absolutedivinity.content.entities.bullet.MassiveLaserBulletType;
import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.ShieldArcAbility;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BombBulletType;
import mindustry.entities.bullet.ContinuousLaserBulletType;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.pattern.ShootPattern;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.LegsUnit;
import mindustry.gen.Sounds;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class EradicatorPrimeUnit {
    public static UnitType eradicatorPrime;

    public static void load() {
        eradicatorPrime = new UnitType("eradicator-prime") {{
            constructor = LegsUnit::create;
            localizedName = "Eradicator Prime";
            description = "A supreme walking fortress of absolute devastation. Leaves nothing but scorched earth in its wake with its array of plasma artillery, sweeping beams, and a world-cracking central laser.";

            legMoveSpace = 0.8f;
            legPairOffset = 3f;
            legLength = 160f;
            legExtension = -20f;
            legBaseOffset = 26f;
            stepShake = 14f;
            legLengthScl = 0.93f;
            rippleScale = 8f;
            rotateSpeed = 0.31f;
            legSpeed = 0.2f;
            legSplashDamage = 120f;
            legSplashRange = 72f;
            legCount = 8;
            speed = 0.4f;
            health = 38000;
            armor = 26;
            groundLayer = 75f;

            weapons.add(new Weapon("cerberian-flak-mount") {{
                x = 3f;
                y = 46f;
                rotate = true;
                rotateSpeed = 4f;
                shake = 1f;
                reload = 50f;
                mirror = true;
                //shootSound = Sounds.shootBig;
                bullet = new FlakBulletType(4f, 10f) {{
                    sprite = "circle-bullet";
                    height = 12f;
                    width = 12f;
                    frontColor = Color.white;
                    backColor = Color.valueOf("a93e3e");
                    trailColor = Color.valueOf("a93e3e");
                    trailLength = 12;
                    trailWidth = 3f;
                    shootEffect = Fx.shootBigColor;
                    smokeEffect = Fx.shootSmokeSquareSparse;
                    hitEffect = Fx.flakExplosion;
                    despawnEffect = Fx.flakExplosion;
                    hitColor = Color.valueOf("a93e3e");
                    damage = 10f;
                    pierce = true;
                    pierceCap = 3;
                    homingPower = 0.09f;
                    speed = 4f;
                    lifetime = 90f;
                    splashDamage = 10f;
                    splashDamageRadius = 12f;
                    collidesAir = true;
                    collidesGround = false;
                    collidesTiles = false;
                }};
            }});

            weapons.add(new Weapon("cerberian-flak-mount") {{
                x = 11f;
                y = 40f;
                rotate = true;
                shake = 1f;
                rotateSpeed = 4f;
                reload = 30f;
                mirror = true;
                //shootSound = Sounds.shootBig;
                bullet = new FlakBulletType(4f, 8f) {{
                    sprite = "circle-bullet";
                    damage = 8f;
                    pierce = true;
                    width = 10f;
                    height = 10f;
                    frontColor = Color.white;
                    backColor = Color.valueOf("a93e3e");
                    trailColor = Color.valueOf("a93e3e");
                    trailLength = 10;
                    trailWidth = 2.5f;
                    shootEffect = Fx.shootBigColor;
                    hitEffect = Fx.flakExplosion;
                    hitColor = Color.valueOf("a93e3e");
                    pierceCap = 3;
                    homingPower = 0.09f;
                    speed = 4f;
                    lifetime = 90f;
                    splashDamage = 8f;
                    splashDamageRadius = 12f;
                    collidesAir = true;
                    collidesGround = false;
                    collidesTiles = false;
                }};
            }});

            weapons.add(new Weapon("cerberian-laser-annihilator") {{
                x = 0f;
                y = -40f;
                shake = 11f;
                reload = 720f;
                shoot = new ShootPattern() {{
                    firstShotDelay = 420f;
                }};
                rotate = false;
                mirror = false;
                continuous = true;
                //chargeSound = Sounds.hugeLaserCharge;
                //shootSound = Sounds.laserbig;
                bullet = new MassiveLaserBulletType() {{
                    rangeOverride = 2500f;
                    damage = 12000f;
                    width = 100;
                    shake = 7f;
                    lifetime = 400f;
                    hittable = false;
                    absorbable = false;
                    laserAbsorb = false;
                    collidesAir = true;
                    collidesGround = true;
                    hitEffect = new MultiEffect(
                        new ParticleEffect() {{
                            sizeFrom = 8f;
                            sizeTo = 4f;
                            colorFrom = Color.valueOf("a93e3e");
                            colorTo = Color.valueOf("6f2626");
                            length = -95f;
                            baseLength = 95f;
                            lifetime = 120f;
                            particles = 50;
                            interp = Interp.exp5;
                            sizeInterp = Interp.pow5Out;
                        }},
                        new ParticleEffect() {{
                            sizeFrom = 8f;
                            sizeTo = 4f;
                            colorFrom = Color.valueOf("a93e3e");
                            colorTo = Color.valueOf("6f2626");
                            length = 95f;
                            baseLength = -95f;
                            lifetime = 120f;
                            particles = 50;
                            interp = Interp.exp5;
                            sizeInterp = Interp.pow5Out;
                        }}
                    );
                }};
            }});

            weapons.add(new Weapon("cerberian-behemoth-weapon") {{
                x = 36f;
                y = 0f;
                shake = 5f;
                recoil = 6f;
                reload = 180f;
                alternate = true;
                //shootSound = Sounds.largeCannon;
                mirror = true;
                rotate = false;
                top = false;
                bullet = new BasicBulletType(1.2f, 60f) {{
                    sprite = "large-orb";
                    frontColor = Color.white;
                    backColor = Color.valueOf("6f2626");
                    trailColor = Color.valueOf("a93e3e");
                    trailLength = 25;
                    trailWidth = 8f;
                    trailEffect = Fx.missileTrail;
                    trailInterval = 3f;
                    shootEffect = Fx.shootTitan;
                    smokeEffect = Fx.shootSmokeTitan;
                    hitEffect = Fx.massiveExplosion;
                    despawnEffect = Fx.massiveExplosion;
                    //hitSound = Sounds.plasmaboom;
                    hitShake = 9f;
                    width = 24f;
                    height = 24f;
                    speed = 1.2f;
                    lifetime = 360f;
                    scaleLife = true;
                    spin = 2f;
                    pierce = true;
                    pierceBuilding = true;
                    buildingDamageMultiplier = 0.75f;
                    lightning = 6;
                    lightningColor = Color.valueOf("a93e3e");
                    lightningLength = 12;
                    lightningDamage = 15f;
                    fragBullets = 6;
                    fragBullet = new ArtilleryBulletType() {{
                        sprite = "circle-bullet";
                        trailColor = Color.valueOf("a93e3e");
                        trailLength = 15;
                        trailWidth = 4f;
                        trailEffect = Fx.artilleryTrail;
                        trailInterval = 4f;
                        hitShake = 6f;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;
                        hitSound = Sounds.explosion;
                        frontColor = Color.white;
                        backColor = Color.valueOf("a93e3e");
                        width = 16f;
                        height = 16f;
                        speed = 1f;
                        lifetime = 60f;
                        damage = 35f;
                        lightning = 3;
                        lightningLength = 9;
                        lightningDamage = 12f;
                        fragBullets = 12;
                        fragBullet = new BombBulletType() {{
                            sprite = "circle";
                            trailColor = Color.valueOf("a93e3e");
                            trailLength = 6;
                            trailWidth = 2f;
                            hitShake = 3f;
                            splashDamageRadius = 70f;
                            hitSound = Sounds.explosion;
                            width = 10f;
                            height = 10f;
                            frontColor = Color.white;
                            backColor = Color.valueOf("a93e3e");
                            hitEffect = new WaveEffect() {{
                                sizeFrom = 0f;
                                sizeTo = 30f;
                                colorFrom = Color.valueOf("a93e3e");
                                colorTo = Color.valueOf("6f2626");
                                strokeFrom = 4f;
                                strokeTo = 0f;
                            }};
                            splashDamage = 30f;
                            speed = 0.5f;
                            lifetime = 60f;
                            fragBullets = 1;
                            fragBullet = new MissileBulletType(1.5f, 25f) {{
                                sprite = "missile";
                                trailColor = Color.valueOf("a93e3e");
                                trailLength = 10;
                                trailWidth = 2f;
                                frontColor = Color.white;
                                backColor = Color.valueOf("a93e3e");
                                hitShake = 1f;
                                lifetime = 40f;
                                height = 16f;
                                width = 10f;
                                homingPower = 0.09f;
                                homingRange = 160f;
                                homingDelay = 10f;
                                weaveMag = 3f;
                                weaveScale = 4f;
                                hitEffect = Fx.blastExplosion;
                                despawnEffect = Fx.blastExplosion;
                                lightning = 2;
                                lightningLength = 6;
                                lightningDamage = 4f;
                            }};
                        }};
                    }};
                }};
            }});

            weapons.add(new Weapon("cerberian-laser-sweeper") {{
                x = 18f;
                y = 26f;
                reload = 240f;
                rotate = false;
                shake = 1f;
                shootCone = 180f;
                alternate = true;
                //shootSound = Sounds.laserblast;
                ignoreRotation = true;
                //chargeSound = Sounds.lasercharge2;
                shoot = new ShootSpread() {{
                    shots = 12;
                    spread = 4f;
                    shotDelay = 3f;
                    firstShotDelay = 60f;
                }};
                bullet = new LaserBulletType(240f) {{
                    length = 360f;
                    width = 28f;
                    lifetime = 45f;
                    hitEffect = Fx.hitLancer;
                    hitColor = Color.valueOf("a93e3e");
                    collidesAir = true;
                    collidesGround = true;
                    lightningSpacing = 30f;
                    lightningLength = 5;
                    lightningDelay = 1f;
                    lightningDamage = 30f;
                    lightningAngleRand = 40f;
                    lightningColor = Color.valueOf("a93e3e");
                }};
            }});

            abilities.add(new ShieldArcAbility() {{
                angle = 83f;
                x = 0f;
                y = -35f;
                max = 10000f;
                regen = 7f;
                region = "tecta-shield";
                cooldown = 1200f;
                width = 6f;
                whenShooting = false;
                radius = 100f;
            }});
        }};
    }
}
