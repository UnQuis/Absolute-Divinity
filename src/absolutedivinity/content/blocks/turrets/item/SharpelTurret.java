package absolutedivinity.content.blocks.turrets.item;

import absolutedivinity.content.ADItems;
import arc.graphics.Color;
import arc.math.Interp;
import arc.struct.ObjectMap;
import arc.struct.Seq;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.UnitSorts;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootPattern;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.draw.DrawTurret;

public class SharpelTurret {
    public static ItemTurret sharpel;

    public static void load(){
        sharpel = new ItemTurret("sharpel"){{
            localizedName = "Sharpel";
            description = "Marks a path with a damaging high-precision laser before firing an expanding electric round that explodes on impact.";
            size = 4;
            reload = 360f;
            range = 420f;
            //shootSound = Sounds.railgun;
            unitSort = UnitSorts.strongest;
            shake = 5;
            recoil = 5;
            rotateSpeed = 2f;
            targetAir = true;
            coolantMultiplier = 0.5f;
            consumePower(6.1f);
            consumeCoolant(1f);
            shoot = new ShootPattern(){{
                firstShotDelay = 35;
            }};
            cooldownTime = 300;
            targetGround = true;
            ammoPerShot = 2;
            maxAmmo = 20;
            scaledHealth = 140;
            category = Category.turret;
            requirements(Category.turret, ItemStack.with(
              Items.copper, 850,
              Items.metaglass, 500,
              Items.silicon, 500,
              Items.plastanium, 120,
              Items.surgeAlloy, 100  
            ));
            ammoTypes = ObjectMap.of(
                Items.surgeAlloy, new MissileBulletType(6f, 900f){{
                    //hitSound = Sounds.largeCannon;
                    //despawnSound = Sounds.largeCannon;
                    shrinkX = -1;
                    shrinkY = -0.5f;
                    sprite = "shell";
                    height = 32;
                    width = 22;
                    status = StatusEffects.shocked;
                    lifetime = 72;
                    optimalLifeFract = 72;
                    pierce = true;
                    homingPower = 0;
                    homingRange = 0;
                    splashDamage = 250;
                    splashDamageRadius = 24;
                    lightRadius = 40;
                    lightOpacity = 0.7f;
                    trailWidth = 8;
                    trailLength = 50;
                    trailChance = -1;
                    shootEffect = Fx.shootBig2;
                    frontColor = Color.valueOf("ffffff");
                    lightColor = Color.valueOf("f3e979");
                    trailColor = Color.valueOf("f3e979");
                    backColor = Color.valueOf("f3e979");
                    hitEffect = new MultiEffect(
                        new WaveEffect(){{
                            followParent = true;
                            colorFrom = Color.valueOf("f3e979");
                            colorTo = Color.valueOf("ffffff");
                            sizeFrom = 2;
                            sizeTo = 60;
                        }},
                        new ParticleEffect(){{
                            followParent = true;
                            particles = 22;
                            length = 60;
                            baseLength = 50;
                            interp = Interp.pow2Out;
                            sizeInterp = Interp.pow2Out;
                            sizeFrom = 12;
                            sizeTo = 2;
                        }}
                    );
                    smokeEffect = new MultiEffect(
                        new ParticleEffect(){{
                            particles = 8;
                            length = 40;
                            baseLength = 50;
                            cone = 20;
                            sizeFrom = 6;
                            sizeTo = 2;
                            colorFrom = Color.valueOf("f3e979");
                            colorTo = Color.valueOf("ffffff");
                            lifetime = 30;
                        }},
                        new ParticleEffect(){{
                            particles = 8;
                            length = 40;
                            baseLength = 50;
                            cone = 20;
                            sizeFrom = 6;
                            sizeTo = 2;
                            colorFrom = Color.valueOf("ffffff");
                            colorTo = Color.valueOf("f3e979");
                            lifetime = 30;
                        }}
                    );
                    spawnBullets = Seq.with(
                        new LaserBulletType(){{
                            sideWidth = 1.5f;
                            sideAngle = 20;
                            sideLength = 80;
                            damage = 100;
                            pierce = true;
                            pierceBuilding = true;
                            status = StatusEffects.none;
                            statusDuration = 0;
                            length = 432;
                            lifetime = 120;
                            width = 28;
                            colors = new Color[]{
                                Color.valueOf("f3e979"), 
                                Color.valueOf("d99f6b"), 
                                Color.valueOf("ffffff")
                            };
                        }}
                    );
                }},

                ADItems.steelAmalgam, new MissileBulletType(6f, 1100f){{
                    //hitSound = Sounds.largeCannon;
                    //despawnSound = Sounds.largeCannon;
                    shrinkX = -1;
                    shrinkY = -0.5f;
                    sprite = "shell";
                    height = 34;
                    width = 22;
                    status = StatusEffects.shocked;
                    lifetime = 72;
                    optimalLifeFract = 72;
                    pierce = true;
                    homingPower = 0;
                    homingRange = 0;
                    splashDamage = 350;
                    splashDamageRadius = 24;
                    lightRadius = 40;
                    lightOpacity = 0.7f;
                    trailWidth = 8;
                    trailLength = 50;
                    trailChance = -1;
                    shootEffect = Fx.shootBig2;
                    frontColor = Color.valueOf("ffffff");
                    lightColor = Color.valueOf("dbaf85");
                    trailColor = Color.valueOf("dbaf85");
                    backColor = Color.valueOf("dbaf85");
                    hitEffect = new MultiEffect(
                        new WaveEffect(){{
                            followParent = true;
                            colorFrom = Color.valueOf("f3e979");
                            colorTo = Color.valueOf("ffffff");
                            sizeFrom = 2;
                            sizeTo = 60;
                        }},
                        new ParticleEffect(){{
                            followParent = true;
                            particles = 22;
                            length = 60;
                            baseLength = 50;
                            interp = Interp.pow2Out;
                            sizeInterp = Interp.pow2Out;
                            sizeFrom = 12;
                            sizeTo = 2;
                        }}
                    );
                    smokeEffect = new MultiEffect(
                        new ParticleEffect(){{
                            particles = 8;
                            length = 40;
                            baseLength = 50;
                            cone = 20;
                            sizeFrom = 6;
                            sizeTo = 2;
                            colorFrom = Color.valueOf("dbaf85");
                            colorTo = Color.valueOf("ffffff");
                            lifetime = 30;
                        }},
                        new ParticleEffect(){{
                            particles = 8;
                            length = 40;
                            baseLength = 50;
                            cone = 20;
                            sizeFrom = 6;
                            sizeTo = 2;
                            colorFrom = Color.valueOf("ffffff");
                            colorTo = Color.valueOf("dbaf85");
                            lifetime = 30;
                        }}
                    );
                    spawnBullets = Seq.with(
                        new LaserBulletType(){{
                            sideWidth = 1.5f;
                            sideAngle = 20;
                            sideLength = 80;
                            damage = 150f;
                            pierce = true;
                            pierceBuilding = false;
                            status = StatusEffects.none;
                            statusDuration = 0;
                            length = 432;
                            lifetime = 120;
                            width = 28;
                            colors = new Color[]{
                                Color.valueOf("a3506e"), 
                                Color.valueOf("dbaf85"), 
                                Color.valueOf("ffffff")
                            };
                        }}
                    );
                }}
            );

            drawer = new DrawTurret(){{
                parts.add(new RegionPart("-front"){{
                    progress = PartProgress.recoil;
                    mirror = true;
                    under = true;
                    moveX = 2;
                    moveY = -1;
                    moveRot = -14;
                }});
                parts.add(new RegionPart("-back"){{
                    progress = PartProgress.warmup;
                    mirror = true;
                    moveX = 2.66667f;
                    moveY = -0.5f;
                    moveRot = -4;
                    under = true;
                    moves.add(new PartMove(PartProgress.warmup, 0f, -2f, 3f));
                    moves.add(new PartMove(PartProgress.recoil, 2f, -1f, -25f));
                }});
            }};
        }};
    }
}
