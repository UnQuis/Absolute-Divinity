package absolutedivinity.content.units.idk;

import arc.graphics.Color;
import arc.math.Interp;
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
            description = "A colossal war machine of Cerberos, armed with a giant continuous laser, fragging shells, sweeping lasers, and defensive shield.";
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
                //shootSound = Sounds.artillery;
                bullet = new FlakBulletType(4f, 10f) {{
                    height = 12f;
                    width = 8f;
                    frontColor = Color.valueOf("a93e3e");
                    backColor = Color.valueOf("6f2626");
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
                //shootSound = Sounds.artillery;
                bullet = new FlakBulletType(4f, 8f) {{
                    damage = 8f;
                    pierce = true;
                    width = 12f;
                    height = 8f;
                    frontColor = Color.valueOf("a93e3e");
                    backColor = Color.valueOf("6f2626");
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
                shootStatus = StatusEffects.unmoving;
                shootStatusDuration = 700f;
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
                bullet = new ContinuousLaserBulletType() {{
                    width = 24f;
                    length = 460f;
                    damage = 800f;
                    shake = 7f;
                    damageInterval = 20f;
                    lifetime = 280f;
                    fadeTime = 110f;
                    hittable = false;
                    absorbable = false;
                    laserAbsorb = false;
                    colors = new Color[]{
                        Color.valueOf("a93e3e"),
                        Color.valueOf("6f2626"),
                        Color.valueOf("b34343"),
                        Color.valueOf("932a2a"),
                        Color.valueOf("ffffff")
                    };
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
                    chargeEffect = new MultiEffect(
                        new ParticleEffect() {{
                            particles = 60;
                            lightOpacity = 0f;
                            length = 100f;
                            baseLength = -100f;
                            lifetime = 200f;
                            layer = 106f;
                            interp = Interp.exp5;
                            sizeFrom = 8f;
                            sizeTo = 3f;
                            colorFrom = Color.valueOf("a93e3e");
                            colorTo = Color.valueOf("6f2626");
                        }},
                        new ParticleEffect() {{
                            particles = 60;
                            offset = 15f;
                            baseLength = 18f;
                            sizeFrom = 0f;
                            sizeTo = 4f;
                            length = 80f;
                            lifetime = 340f;
                            colorFrom = Color.valueOf("a93e3e");
                            colorTo = Color.valueOf("6f2626");
                            cone = 360f;
                        }},
                        new WaveEffect() {{
                            lifetime = 340f;
                            sizeFrom = 55f;
                            sizeTo = 0f;
                            interp = Interp.pow5Out;
                            strokeFrom = 0f;
                            strokeTo = 8f;
                            colorFrom = Color.valueOf("a93e3e");
                            colorTo = Color.valueOf("6f2626");
                        }},
                        new WaveEffect() {{
                            lifetime = 340f;
                            sizeFrom = 65f;
                            sizeTo = 0f;
                            interp = Interp.pow10Out;
                            strokeFrom = 0f;
                            strokeTo = 8f;
                            colorFrom = Color.valueOf("a93e3e");
                            colorTo = Color.valueOf("6f2626");
                        }},
                        new ParticleEffect() {{
                            particles = 60;
                            offset = 100f;
                            sizeFrom = 1f;
                            sizeTo = 6f;
                            length = 120f;
                            baseLength = -120f;
                            interp = Interp.pow3In;
                            sizeInterp = Interp.pow5Out;
                            lifetime = 220f;
                            colorFrom = Color.valueOf("a93e3e");
                            colorTo = Color.valueOf("6f2626");
                        }},
                        new ParticleEffect() {{
                            particles = 60;
                            offset = 100f;
                            sizeFrom = 1f;
                            sizeTo = 6f;
                            length = 120f;
                            baseLength = -120f;
                            interp = Interp.pow3In;
                            sizeInterp = Interp.pow5Out;
                            lifetime = 260f;
                            colorFrom = Color.valueOf("a93e3e");
                            colorTo = Color.valueOf("6f2626");
                        }},
                        new WaveEffect() {{
                            lifetime = 340f;
                            sizeFrom = 55f;
                            sizeTo = 0f;
                            interp = Interp.pow5Out;
                            strokeFrom = 0f;
                            strokeTo = 8f;
                            colorFrom = Color.valueOf("a93e3e");
                            colorTo = Color.valueOf("6f2626");
                        }},
                        new WaveEffect() {{
                            lifetime = 340f;
                            sizeFrom = 65f;
                            sizeTo = 0f;
                            interp = Interp.pow10Out;
                            strokeFrom = 0f;
                            strokeTo = 8f;
                            colorFrom = Color.valueOf("a93e3e");
                            colorTo = Color.valueOf("6f2626");
                        }},
                        new ParticleEffect() {{
                            particles = 70;
                            offset = 100f;
                            sizeFrom = 1f;
                            sizeTo = 6f;
                            length = 200f;
                            baseLength = -200f;
                            interp = Interp.pow3In;
                            sizeInterp = Interp.pow5Out;
                            lifetime = 300f;
                            colorFrom = Color.valueOf("a93e3e");
                            colorTo = Color.valueOf("6f2626");
                        }},
                        new ParticleEffect() {{
                            particles = 120;
                            offset = 100f;
                            sizeFrom = 1f;
                            sizeTo = 6f;
                            length = 250f;
                            baseLength = -250f;
                            interp = Interp.pow3In;
                            sizeInterp = Interp.pow5Out;
                            lifetime = 240f;
                            colorFrom = Color.valueOf("a93e3e");
                            colorTo = Color.valueOf("6f2626");
                        }},
                        new ParticleEffect() {{
                            particles = 130;
                            offset = 100f;
                            sizeFrom = 1f;
                            sizeTo = 6f;
                            length = 300f;
                            baseLength = -400f;
                            interp = Interp.pow3In;
                            sizeInterp = Interp.pow5Out;
                            lifetime = 400f;
                            colorFrom = Color.valueOf("a93e3e");
                            colorTo = Color.valueOf("6f2626");
                        }},
                        new ParticleEffect() {{
                            particles = 145;
                            offset = 100f;
                            sizeFrom = 1f;
                            sizeTo = 6f;
                            length = 350f;
                            baseLength = -350f;
                            interp = Interp.pow3In;
                            sizeInterp = Interp.pow5Out;
                            lifetime = 420f;
                            colorFrom = Color.valueOf("a93e3e");
                            colorTo = Color.valueOf("6f2626");
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
                    sprite = "me-lycosid-bullet";
                    frontColor = Color.valueOf("a93e3e");
                    //hitSound = Sounds.bang;
                    hitShake = 9f;
                    //hitEffect = Fx.instHit;
                    backColor = Color.valueOf("6f2626");
                    width = 42f;
                    height = 42f;
                    speed = 1.2f;
                    lifetime = 360f;
                    scaleLife = true;
                    spin = 1.6f;
                    pierce = true;
                    pierceBuilding = true;
                    buildingDamageMultiplier = 0.75f;
                    lightning = 6;
                    lightningColor = Color.valueOf("a93e3e");
                    lightningLength = 12;
                    lightningDamage = 15f;
                    fragBullets = 6;
                    fragBullet = new ArtilleryBulletType() {{
                        hitShake = 6f;
                        //hitEffect = Fx.hitMeltdown;
                        hitSound = Sounds.explosion;
                        sprite = "me-lycosid-bullet";
                        frontColor = Color.valueOf("a93e3e");
                        backColor = Color.valueOf("6f2626");
                        width = 38f;
                        height = 38f;
                        speed = 1f;
                        lifetime = 60f;
                        damage = 35f;
                        lightning = 3;
                        lightningLength = 9;
                        lightningDamage = 12f;
                        fragBullets = 12;
                        fragBullet = new BombBulletType() {{
                            hitShake = 3f;
                            splashDamageRadius = 70f;
                            sprite = "me-lml-mine";
                            hitSound = Sounds.explosion;
                            width = 12f;
                            height = 12f;
                            hitEffect = new WaveEffect() {{
                                sizeFrom = 0f;
                                sizeTo = 18f;
                                colorFrom = Color.valueOf("a93e3e");
                                colorTo = Color.valueOf("6f2626");
                            }};
                            splashDamage = 30f;
                            speed = 0.5f;
                            lifetime = 60f;
                            fragBullets = 1;
                            fragBullet = new MissileBulletType(1.5f, 25f) {{
                                hitShake = 1f;
                                lifetime = 40f;
                                height = 16f;
                                width = 10f;
                                homingPower = 0.09f;
                                homingRange = 160f;
                                homingDelay = 60f;
                                //hitEffect = Fx.blastExplosion;
                                lightning = 2;
                                lightningLength = 6;
                                lightningDamage = 4f;
                            }};
                        }};
                    }};
                }};
            }});

            // Laser sweepers
            weapons.add(new Weapon("cerberian-laser-sweeper") {{
                x = 18f;
                y = 26f;
                reload = 240f;
                rotate = false;
                shake = 1f;
                shootCone = 180f;
                alternate = true;
                //shootSound = Sounds.spark;
                ignoreRotation = true;
                //chargeSound = Sounds.lasercharge2;
                shoot = new ShootSpread() {{
                    shots = 12;
                    spread = 2f;
                    shotDelay = 3f;
                    firstShotDelay = 60f;
                }};
                bullet = new LaserBulletType() {{
                    damage = 240f;
                    length = 360f;
                    width = 26f;
                    collidesAir = true;
                    collidesGround = true;
                    //hitSound = Sounds.spark;
                    //hitEffect = Fx.instHit;
                    colors = new Color[]{
                        Color.valueOf("a93e3e"),
                        Color.valueOf("6f2626"),
                        Color.valueOf("ffffff")
                    };
                }};
            }});

            // Shield ability
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
