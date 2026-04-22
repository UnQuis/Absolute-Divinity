package absolutedivinity.content.units;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import arc.math.Interp;
import mindustry.entities.bullet.ExplosionBulletType;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.gen.Sounds;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.MissileUnitType;

public class ADMissiles {
    public static UnitType
        nukeMissile,
        phaseMissile,
        plastMissile,
        surgeMissile,
        tinyMissile,
        tinyMissile2,
        tinyMissile3,
        tinyMissile4;

        public static void load(){
            nukeMissile = new MissileUnitType("nuke-missile"){{
                flying = true;
                speed = 7;
                lifetime = 320;
                trailColor = Color.valueOf("9cb664");
                trailLength = 25;
                deathSound = Sounds.none;
                weapons.add(new Weapon(){{
                    shootCone = 360f;
                    mirror = false;
                    reload = 1;
                    shootOnDeath = true;
                    shake = 20;
                    bullet = new ExplosionBulletType(5000f, 240f){{
                        buildingDamageMultiplier = 0.05f;
                        suppressionRange = 240;
                        suppressionDuration = 360;
                        hitShake = 12;
                        reflectable = false;
                        //hitSound = tree.getSound();
                        hitSoundVolume = 6f;

                        status = ADEffects.radiated;

                        hitEffect = new MultiEffect(
                            new WaveEffect(){{
                                sizeFrom = 0;
                                sizeTo = 250;
                                lifetime = 120;
                                colorFrom = Color.valueOf("edf3a9");
                                colorTo = Color.valueOf("9cb664");
                                startDelay = 20;
                            }},

                            new ParticleEffect(){{
                                baseLength = 120;
                                lifetime = 120;
                                colorFrom = Color.valueOf("edf3a9");
                                colorTo = Color.valueOf("fefefe");
                                interp = Interp.circleOut;
                                cone = 360;
                                particles = 32;
                                sizeFrom = 12;
                                sizeTo = 0;
                                spin = 0.2f;
                            }}
                        );
                    }};
                }});
            }};

            phaseMissile = new MissileUnitType("phase-missile"){{
                flying = true;
                speed = 6.8f;
                lifetime = 240;
                //deathExplosionEffect = 
                trailColor = Color.valueOf("f19583");
                trailLength = 22;
                weapons.add(new Weapon(){{
                    shootCone = 360;
                    mirror = false;
                    reload = 1;
                    shootOnDeath = true;
                    shake = 9;
                    bullet = new ExplosionBulletType(2200f, 70f){{
                        hitColor = Color.valueOf("f19583");
                        collidesAir = true;
                        collidesGround = false;
                        buildingDamageMultiplier = 0;
                        fragLifeMin = 0.1f;
                        fragBullets = 7;
                        fragBullet = new FlakBulletType(){{
                            speed = 3.4f;
                            damage = 100f;
                            collidesAir = true;
                            collidesGround = false;
                            collidesTiles = false;
                            buildingDamageMultiplier = 0;
                            drag = 0.02f;
                            //hitEffect = 
                            //despawnEffect = 
                            knockback = 0.8f;
                            lifetime = 23;
                            height = 18;
                            width = 9;
                            splashDamageRadius = 40;
                            splashDamage = 80;
                            backColor = Color.valueOf("f19583");
                            trailColor = Color.valueOf("f19583");
                            hitColor = Color.valueOf("f19583");
                            frontColor = Color.valueOf("ffffff");
                            //smokeEffect = 
                            despawnShake = 6;
                            lightRadius = 30;
                            lightOpacity = 0.5f;
                            lightColor = Color.valueOf("f19583");
                            trailLength = 20;
                            trailWidth = 3.5f;
                            //trailEffect = 
                        }};
                    }};
                }});
            }};

            surgeMissile = new MissileUnitType("surge-missile"){{
                flying = true;
                speed = 8;
                lifetime = 240;
                //deathExplosionEffect =
                trailColor = Color.valueOf("f3e979");
                trailLength = 22;
                weapons.add(new Weapon(){{
                    shootCone = 360;
                    mirror = false;
                    reload = 1;
                    shootOnDeath = true;
                    shake = 10;
                    bullet = new ExplosionBulletType(2600f, 80f){{
                        hitColor = Color.valueOf("f3e979");
                        collidesAir = true;
                        collidesGround = false;
                        buildingDamageMultiplier = 0;
                        fragLifeMin = 0.1f;
                        fragBullets = 7;
                        fragBullet = new FlakBulletType(3.4f, 140f){{
                            collidesAir = true;
                            collidesGround = false;
                            collidesTiles = false;
                            buildingDamageMultiplier = 0;
                            drag = 0.02f;
                            //hitEffect =
                            //despawnEffect =
                            knockback = 0.8f;
                            lifetime = 23;
                            height = 18;
                            width = 9;
                            splashDamageRadius = 40;
                            splashDamage = 80;
                            backColor = Color.valueOf("f3e979");
                            trailColor = Color.valueOf("f3e979");
                            hitColor = Color.valueOf("f3e979");
                            frontColor = Color.valueOf("ffffff");
                            //smokeEffect =
                            despawnShake = 7;
                            lightRadius = 30;
                            lightColor = Color.valueOf("f3e979");
                            lightOpacity = 0.5f;
                            trailLength = 20;
                            trailWidth = 3.5f;
                            //trailEffect = 
                        }};
                    }};
                }});
            }};

            plastMissile = new MissileUnitType("plast-missile"){{
                flying = true;
                speed = 6.8f;
                lifetime = 240;
                //deathExplosionEffect =
                trailColor = Color.valueOf("9cb664");
                trailLength = 22;
                weapons.add(new Weapon(){{
                    shootCone = 360;
                    mirror = false;
                    reload = 1;
                    shootOnDeath = true;
                    shake = 8;
                    bullet = new ExplosionBulletType(1800f, 60f){{
                        hitColor = Color.valueOf("9cb664");
                        collidesAir = true;
                        collidesGround = false;
                        buildingDamageMultiplier = 0;
                        fragLifeMin = 0.1f;
                        fragBullets = 7;
                        fragBullet = new FlakBulletType(3.4f, 80f){{
                            collidesAir = true;
                            collidesGround = false;
                            collidesTiles = false;
                            buildingDamageMultiplier = 0;
                            drag = 0.02f;
                            //hitEffect =
                            //despawnEffect =
                            knockback = 0.8f;
                            lifetime = 23;
                            height = 18;
                            width = 9;
                            splashDamageRadius = 40;
                            splashDamage = 80;
                            backColor = Color.valueOf("9cb664");
                            trailColor = Color.valueOf("9cb664");
                            hitColor = Color.valueOf("9cb664");
                            frontColor = Color.valueOf("ffffff");
                            //smokeEffect =
                            despawnShake = 5;
                            lightRadius = 30;
                            lightColor = Color.valueOf("9cb664");
                            lightOpacity = 0.5f;
                            trailLength = 20;
                            trailWidth = 3.5f;
                            //trailEffect = 
                        }};
                    }};
                }});
            }};

            tinyMissile = new MissileUnitType("tiny-missile"){{
                flying = true;
                speed = 6;
                lifetime = 60;
                trailColor = Color.valueOf("ffaa5f");
                trailLength = 10;
                drawCell = false;
                weapons.add(new Weapon(){{
                    shootCone = 360;
                    mirror = false;
                    reload = 1;
                    shootOnDeath = true;
                    shake = 1;
                    bullet = new ExplosionBulletType(180f, 32f){{
                        ammoMultiplier = 7;
                    }};
                }});
            }};

            tinyMissile2 = new MissileUnitType("tiny-missile-2"){{
                flying = true;
                speed = 7;
                lifetime = 60;
                trailColor = Color.valueOf("cbd97f");
                trailLength = 12;
                drawCell = false;
                weapons.add(new Weapon(){{
                    shootCone = 360;
                    mirror = false;
                    reload = 1;
                    shootOnDeath = true;
                    shake = 2;
                    bullet = new ExplosionBulletType(180f, 32f){{
                        ammoMultiplier = 12;
                    }};
                }});
            }};

            tinyMissile3 = new MissileUnitType("tiny-missile-3"){{
                flying = true;
                speed = 6;
                lifetime = 60;
                trailColor = Color.valueOf("cbd97f");
                trailLength = 11;
                drawCell = false;
                weapons.add(new Weapon(){{
                    shootCone = 360;
                    mirror = false;
                    reload = 1;
                    shootOnDeath = true;
                    shake = 1;
                    bullet = new ExplosionBulletType(220f, 32f){{
                        ammoMultiplier = 10;
                    }};
                }});
            }};

            tinyMissile4 = new MissileUnitType("tini-missile-4"){{
                flying = true;
                speed = 6f;
                lifetime = 120;
                trailColor = Color.valueOf("ffaa5f");
                rotateSpeed = 10;
                trailLength = 10;
                drawCell = false;
                weapons.add(new Weapon(){{
                    shootCone = 360;
                    mirror = false;
                    reload = 1;
                    shootOnDeath = true;
                    shake = 1;
                    bullet = new ExplosionBulletType(80f, 24f){{
                    }};
                }});
            }};
        }
}
