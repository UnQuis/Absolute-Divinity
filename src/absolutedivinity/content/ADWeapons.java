package absolutedivinity.content;

import absolutedivinity.content.units.ADMissiles;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.type.Weapon;

public class ADWeapons {
    public static Weapon
        culisetaMainRailgun,
        pointDefenceMount,
        largeOrb,
        tinyStarter,
        culisetaRotor;

        public static void load(){
            culisetaRotor = new Weapon() {{
                x = 0; y = 0;
                shootX = 0;
                shootY = 0;
                mirror = false;
                //shootSound =
                rotate = false;
                alwaysShooting = true;
                ignoreRotation = true;
                shootCone = 360;
                reload = 15;
                recoil = 0;
                bullet = new BulletType() {{
                    status = ADStatusEffects.gravitationalCollapse;
                    statusDuration = 20;
                    instantDisappear = true;
                    splashDamage = 15;
                    splashDamageRadius = 88;
                    pierceBuilding = true;
                    knockback = 0.4f;
                    shootEffect = new ParticleEffect(){{
                       region = "fadingrevelations-culiseta-rotor";
                       particles = 1;
                       followParent = true;
                       rotWithParent = true;
                       lifetime = 20;
                       length = 0;
                       sizeFrom = 120;
                       sizeTo = 120;
                       spin = 16;
                       layer = 95.1f; 
                    }};
                }};
            }};

            culisetaMainRailgun = new Weapon(){{
                x = 28;
                y = -8;
                shootY = 4;
                rotate = true;
                rotateSpeed = 2f;
                mirror = true;
                reload = 180f;
                recoil = 8f;
                shake = 4f;
                shootCone = 15f;
                shootSound = Sounds.shoot;
                bullet = new BasicBulletType(20f, 350f){{
                    sprite = "missile-large";
                    width = 8f;
                    height = 18f;
                    lifetime = 30f;
                    pierce = true;
                    pierceArmor = true;
                    pierceCap = 5;
                    hitEffect = Fx.hitBulletColor;
                    despawnEffect = Fx.shootBig;
                    smokeEffect = Fx.shootSmokeTitan;
                    trailEffect = Fx.artilleryTrail;
                    trailChance = 1f;
                    trailLength = 12;
                    trailWidth = 2f;
                    knockback = 3f;
                    hitShake = 6f;
                    backColor = Color.valueOf("a93e3e");
                    frontColor = Color.white;
                    mixColorFrom = Color.valueOf("ff6b6b");
                    mixColorTo = Color.white;
                }};
            }};

            pointDefenceMount = new Weapon(){{
                x = 0;
                y = 0;
                mirror = false;
                rotate = false;
                alwaysShooting = true;
                ignoreRotation = true;
                shootCone = 360;
                reload = 8f;
                shootSound = Sounds.none;
                bullet = new BasicBulletType(12f, 12f){{
                    speed = 16f;
                    width = 4f;
                    height = 4f;
                    lifetime = 12f;
                    collidesAir = true;
                    collidesGround = false;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.none;
                    hitEffect = Fx.hitBulletSmall;
                    despawnEffect = Fx.none;
                    backColor = Color.valueOf("ffec80");
                    frontColor = Color.white;
                    pierce = false;
                    knockback = 0.5f;
                }};
            }};

            largeOrb = new Weapon(){{
                x = 0; y = 0;
                reload = 1;
                mirror = false;
                rotate = false;
                alwaysShooting = true;
                ignoreRotation = true;
                shootSound = Sounds.none;
                shootCone = 60;
                bullet = new BasicBulletType(3f, 425f){{
                    status = StatusEffects.none;
                    statusDuration = 0f;
                    speed = 0;
                    instantDisappear = true;
                    smokeEffect = Fx.none;
                    shootEffect = Fx.none;
                    lifetime = 90;
                    pierce = true;
                    pierceBuilding = true;
                    hitSize = 32;
                    knockback = 0.3f;
                    damage = 0;
                    splashDamage = 11;
                    splashDamageRadius = 40;
                    width = 32f; height = 32f;
                    sprite = "large-orb";
                    lightning = 4;
                    lightningLength = 9;
                    lightningDamage = 20f;
                    hitEffect = Fx.none;
                    despawnEffect = Fx.none;
                }};
            }};

            tinyStarter = new Weapon(){{
                x = 0; y = 0;
                rotate = false;
                mirror = false;
                reload = 153;
                //shootSound = missileLaunch;
                shoot = new ShootSpread(){{
                    shots = 4;
                    spread = 20;
                    shotDelay = 6;
                }};

                bullet = new MissileBulletType(){{
                    spawnUnit = ADMissiles.tinyMissile4;
                    instantDisappear = true;
                    damage = 0;
                }};
            }};
        }
}
