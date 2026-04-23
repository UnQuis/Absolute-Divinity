package absolutedivinity.content.blocks.turrets.item;

import absolutedivinity.content.ADItems;
import arc.graphics.Color;
import arc.struct.ObjectMap;
import mindustry.content.Items;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.entities.part.ShapePart;
import mindustry.entities.pattern.ShootBarrel;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.draw.DrawTurret;


public class RagnitoTurret {
    
    public static ItemTurret ragnito;

    public static void load(){
        ragnito = new ItemTurret("ragnito"){{
            localizedName = "Ragnito";
            description = "Even if the name might sound cute, this is Cerbero's proudest anti-air invention: The Cerberian Anti Air Turret System.";
            size = 5;
            category = Category.turret;
            targetGround = false;
            maxAmmo = 1000;
            health = 11375;
            reload = 90f;
            range = 480f;
            minWarmup = 0.99f;
            moveWhileCharging = false;
            accurateDelay = false;
            consumePower(10f);
            //shootSound = 
            shootWarmupSpeed = 0.05f;
            warmupMaintainTime = 600;
            //chargeSound =
            //soundPitchMin = 0.7f;
            //soundPitchMax = 0.9f;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 1500,
                Items.metaglass, 1000,
                Items.silicon, 1000,
                Items.plastanium, 300,
                Items.surgeAlloy, 200
            ));
            shoot = new ShootBarrel(){{
                barrels = new float[]{
                    0f, -7f, 0f,
                    -22f, 0f, 0f,
                    22f, 0f, 0f
                };
                shots = 3;
                shotDelay = 10f;
                barrelOffset = 1;
                firstShotDelay = 120;
            }};

            ammoTypes = ObjectMap.of(
                ADItems.livingSteel, new MissileBulletType(6f, 1500f){{
                    sprite = "fadingrevelations-aa-missle";
                    height = 40f;
                    width = 20f;
                    pierce = false;
                    lifetime = 90;
                    splashDamage = 800f;
                    splashDamageRadius = 80f;
                    frontColor = Color.valueOf("9e78dc");
                    backColor = Color.valueOf("6d0071");
                    trailColor = Color.valueOf("9e78dc");
                    lightColor = Color.valueOf("8c0291");
                    hitColor = Color.valueOf("8c0291");
                    lightOpacity = 0.7f;
                    lightRadius = 12f;
                    trailChance = -1;
                    homingPower = 0.9f;
                    trailLength = 10;
                    trailWidth = 3f;
                    fragBullets = 3;
                    fragLifeMin = 0.4f;
                    fragLifeMax = 0.9f;
                    fragSpread = 120f;
                    fragBullet = new LaserBulletType(){{
                        collidesGround = false;
                        collidesTiles = false;
                        length = 120f;
                        damage = 600f;
                        lifetime = 90;
                        width = 20;
                        colors = new Color[]{
                            Color.valueOf("8c0291"), 
                            Color.valueOf("9e78dc"),
                            Color.valueOf("ffffff")
                        };
                    }};
                }}
            );

            drawer = new DrawTurret(){{
                parts.add(new ShapePart(){{
                    progress = PartProgress.warmup;
                    hollow = true;
                    x = 0; y = 0;
                    moveY = -24f;
                    sides = 3;
                    layer = 49;
                    color = Color.valueOf("6d7dff");
                    colorTo = Color.valueOf("5461c5");
                    radius = 6f;
                    radiusTo = 7f;
                    rotateSpeed = 1.5f;
                }});

                parts.add(new ShapePart(){{
                    progress = PartProgress.warmup;
                    hollow = true;
                    x = 0; y = 0;
                    moveY = -24f;
                    sides = 3;
                    layer = 49;
                    color = Color.valueOf("6d7dff");
                    colorTo = Color.valueOf("5461c5");
                    radius = 6f;
                    radiusTo = 7f;
                    rotateSpeed = -1.5f;
                }});

                parts.add(new RegionPart("-body"){{
                    mirror = true;
                    under = false;
                    progress = PartProgress.warmup;
                    moveX = 5;
                    moveY = -1;
                    moveRot = -5;
                }});

                parts.add(new RegionPart("-blade"){{
                    mirror = true;
                    under = true;
                    progress = PartProgress.warmup;
                    moveX = 10;
                    moveY = 5;
                    moveRot = 0;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -2f, -10f));
                }});
            }};
        }};
    }
}
