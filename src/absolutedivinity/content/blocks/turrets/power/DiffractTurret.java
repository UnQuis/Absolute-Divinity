package absolutedivinity.content.blocks.turrets.power;

import absolutedivinity.content.ADItems;
import arc.graphics.Color;
import arc.struct.ObjectMap;
import arc.struct.Seq;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.draw.DrawTurret;

public class DiffractTurret {

    public static ItemTurret diffract;

    public static void load() {
        diffract = new ItemTurret("diffract") {{
            localizedName = "Diffract";
            description = "Fires high-grade piercing shells that split into more shells.";
            size = 4;
            scaledHealth = 210;
            coolantMultiplier = 0.25f;
            range = 300f;
            reload = 240f;
            shake = 5f;
            targetAir = false;
            //shootSound = Sounds.largeCannon;
            consumePower(8f);
            consumeCoolant(1f);
            shootWarmupSpeed = 0.07f;
            shootEffect = Fx.shootTitan;
            smokeEffect = Fx.shootSmokeMissile;
            minWarmup = 0.76f;
            warmupMaintainTime = 90f;
            category = Category.turret;
            requirements(Category.turret, ItemStack.with(
                Items.lead, 700,
                Items.graphite, 560,
                Items.titanium, 320,
                ADItems.cryogenicAlloy, 105
            ));
            drawer = new DrawTurret() {{
                parts.add(new RegionPart() {{
                    suffix = "-side";
                    mirror = true;
                    under = true;
                    heatProgress = PartProgress.recoil;
                    progress = PartProgress.warmup;
                    moveX = 1.9f;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -1f, -11f));
                }});
                parts.add(new RegionPart() {{
                    suffix = "-top";
                    mirror = false;
                    under = false;
                    progress = PartProgress.warmup;
                    heatProgress = PartProgress.recoil;
                }});
            }};
            ammoTypes = ObjectMap.of(
                Items.titanium, new BasicBulletType(3f, 50f) {{
                    despawnShake = 1f;
                    lightColor = Color.valueOf("7575c8");
                    lightRadius = 50f;
                    lightOpacity = 0.7f;
                    reloadMultiplier = 0.6f;
                    rangeChange = -80f;
                    lifetime = 25f;
                    pierce = true;
                    pierceBuilding = true;
                    //hitSound = Sounds.mediumCannon;
                    width = 22f;
                    height = 28f;
                    pierceCap = 3;
                    trailLength = 22;
                    trailWidth = 6f;
                    trailChance = -1f;
                    trailColor = Color.valueOf("7575c8");
                    frontColor = Color.valueOf("ffffff");
                    homingPower = 0.03f;
                    backColor = Color.valueOf("7575c8");
                    fragBullets = 3;
                    fragRandomSpread = 0f;
                    fragSpread = 22.5f;
                    fragLifeMin = 1f;
                    fragVelocityMin = 1f;
                    fragVelocityMax = 1f;
                    fragLifeMax = 1f;
                    hitEffect = Fx.massiveExplosion;
                    lightning = 3;
                    lightningLength = 12;
                    lightningColor = Color.valueOf("7575c8");
                    lightningDamage = 5f;
                    fragBullet = new BasicBulletType(3f, 30f) {{
                        lightColor = Color.valueOf("7575c8");
                        lightRadius = 50f;
                        lightOpacity = 0.7f;
                        lifetime = 25f;
                        //hitSound = Sounds.dullExplosion;
                        pierce = true;
                        pierceBuilding = true;
                        pierceCap = 3;
                        trailLength = 22;
                        trailWidth = 6f;
                        trailChance = -1f;
                        width = 20f;
                        height = 26f;
                        frontColor = Color.valueOf("ffffff");
                        backColor = Color.valueOf("7575c8");
                        homingPower = 0.03f;
                        trailColor = Color.valueOf("7575c8");
                        fragBullets = 3;
                        fragRandomSpread = 0f;
                        fragLifeMin = 1f;
                        fragVelocityMin = 1f;
                        fragVelocityMax = 1f;
                        fragLifeMax = 1f;
                        fragSpread = 22.5f;
                        hitEffect = Fx.blastExplosion;
                        lightning = 2;
                        lightningLength = 9;
                        lightningColor = Color.valueOf("7575c8");
                        lightningDamage = 3f;
                        fragBullet = new BasicBulletType(3f, 20f) {{
                            lightColor = Color.valueOf("7575c8");
                            lightRadius = 50f;
                            lightOpacity = 0.7f;
                            //hitSound = Sounds.dullExplosion;
                            lifetime = 25f;
                            homingPower = 0.03f;
                            pierce = true;
                            pierceBuilding = true;
                            pierceCap = 3;
                            trailLength = 22;
                            trailWidth = 6f;
                            trailChance = -1f;
                            width = 18f;
                            height = 24f;
                            frontColor = Color.valueOf("ffffff");
                            backColor = Color.valueOf("7575c8");
                            trailColor = Color.valueOf("7575c8");
                            hitEffect = Fx.hitBulletColor;
                            lightning = 1;
                            lightningLength = 6;
                            lightningColor = Color.valueOf("7575c8");
                            lightningDamage = 2f;
                        }};
                    }};
                }},
                Items.surgeAlloy, new BasicBulletType(3f, 70f) {{
                    ammoMultiplier = 3;
                    despawnShake = 2f;
                    lightColor = Color.valueOf("d99f6b");
                    lightRadius = 50f;
                    lightOpacity = 0.7f;
                    lifetime = 20f;
                    pierce = true;
                    pierceBuilding = true;
                    width = 22f;
                    height = 28f;
                    pierceCap = 3;
                    trailLength = 22;
                    trailWidth = 6f;
                    trailChance = -1f;
                    trailColor = Color.valueOf("d99f6b");
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("d99f6b");
                    //hitSound = Sounds.mediumCannon;
                    homingPower = 0.03f;
                    fragBullets = 3;
                    fragRandomSpread = 0f;
                    fragLifeMin = 1f;
                    fragVelocityMin = 1f;
                    fragVelocityMax = 1f;
                    fragLifeMax = 1f;
                    fragSpread = 22.5f;
                    hitEffect = Fx.massiveExplosion;
                    lightning = 3;
                    lightningLength = 15;
                    lightningColor = Color.valueOf("d99f6b");
                    lightningDamage = 7f;
                    fragBullet = new BasicBulletType(3f, 50f) {{
                        spawnBullets = new Seq<BulletType>().add(
                            new LaserBulletType() {{
                                length = 100f;
                                width = 16f;
                                damage = 30f;
                                sideAngle = 60f;
                                lifetime = 50f;
                                sideWidth = 2f;
                                sideLength = 32f;
                                colors = new Color[]{
                                    Color.valueOf("d99f6b80"),
                                    Color.valueOf("fcf38799"),
                                    Color.valueOf("ffffff")
                                };
                            }}
                        );
                        lightColor = Color.valueOf("d99f6b");
                        despawnShake = 1f;
                        lightRadius = 50f;
                        lightOpacity = 0.7f;
                        speed = 3f;
                        lifetime = 30f;
                        damage = 50f;
                        pierce = true;
                        pierceBuilding = true;
                        pierceCap = 3;
                        trailLength = 22;
                        trailWidth = 6f;
                        trailChance = -1f;
                        width = 20f;
                        height = 26f;
                        frontColor = Color.valueOf("ffffff");
                        backColor = Color.valueOf("d99f6b");
                        homingPower = 0.03f;
                        trailColor = Color.valueOf("d99f6b");
                        fragBullets = 3;
                        fragRandomSpread = 0f;
                        fragSpread = 22.5f;
                        fragLifeMin = 1f;
                        fragVelocityMin = 1f;
                        //hitSound = Sounds.dullExplosion;
                        fragVelocityMax = 1f;
                        fragLifeMax = 1f;
                        hitEffect = Fx.blastExplosion;
                        lightning = 2;
                        lightningLength = 12;
                        lightningColor = Color.valueOf("d99f6b");
                        lightningDamage = 5f;
                        fragBullet = new BasicBulletType(3f, 40f) {{
                            weaveMag = 4f;
                            weaveScale = 4f;
                            lightColor = Color.valueOf("d99f6b");
                            lightRadius = 50f;
                            lightOpacity = 0.7f;
                            lifetime = 30f;
                            //hitSound = Sounds.dullExplosion;
                            pierce = true;
                            pierceBuilding = true;
                            pierceCap = 3;
                            trailLength = 22;
                            trailWidth = 6f;
                            trailChance = -1f;
                            width = 18f;
                            height = 24f;
                            frontColor = Color.valueOf("ffffff");
                            backColor = Color.valueOf("d99f6b");
                            trailColor = Color.valueOf("d99f6b");
                            homingPower = 0.03f;
                            hitEffect = Fx.flakExplosion;
                            lightning = 1;
                            lightningLength = 9;
                            lightningColor = Color.valueOf("d99f6b");
                            lightningDamage = 4f;
                            fragBullets = 3;
                            fragRandomSpread = 0f;
                            fragSpread = 22.5f;
                            fragLifeMin = 1f;
                            fragVelocityMin = 1f;
                            fragVelocityMax = 1f;
                            fragLifeMax = 1f;
                            fragBullet = new BasicBulletType(3f, 30f) {{
                                weaveMag = 4f;
                                weaveScale = 4f;
                                lightColor = Color.valueOf("d99f6b");
                                lightRadius = 50f;
                                lightOpacity = 0.7f;
                                lifetime = 30f;
                                pierce = true;
                                //hitSound = Sounds.dullExplosion;
                                pierceBuilding = true;
                                pierceCap = 3;
                                trailLength = 22;
                                trailWidth = 6f;
                                trailChance = -1f;
                                width = 16f;
                                homingPower = 0.03f;
                                height = 22f;
                                frontColor = Color.valueOf("ffffff");
                                backColor = Color.valueOf("d99f6b");
                                trailColor = Color.valueOf("d99f6b");
                                hitEffect = Fx.hitBulletColor;
                                lightning = 1;
                                lightningLength = 6;
                                lightningColor = Color.valueOf("d99f6b");
                                lightningDamage = 3f;
                            }};
                        }};
                    }};
                }},
                ADItems.cryogenicAlloy, new BasicBulletType(3f, 90f) {{
                    ammoMultiplier = 4;
                    despawnShake = 3f;
                    rangeChange = 80f;
                    lightColor = Color.valueOf("218b8f");
                    lightRadius = 50f;
                    lightOpacity = 0.7f;
                    lifetime = 25f;
                    pierce = true;
                    pierceBuilding = true;
                    width = 22f;
                    height = 28f;
                    pierceCap = 3;
                    trailLength = 22;
                    //hitSound = Sounds.mediumCannon;
                    trailWidth = 6f;
                    trailChance = -1f;
                    trailColor = Color.valueOf("218b8f");
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("218b8f");
                    fragLifeMin = 1f;
                    fragVelocityMin = 1f;
                    fragVelocityMax = 1f;
                    homingPower = 0.03f;
                    fragLifeMax = 1f;
                    fragBullets = 3;
                    fragRandomSpread = 0f;
                    fragSpread = 22.5f;
                    hitEffect = Fx.massiveExplosion;
                    lightning = 3;
                    lightningLength = 15;
                    lightningColor = Color.valueOf("218b8f");
                    lightningDamage = 9f;
                    fragBullet = new BasicBulletType(3f, 70f) {{
                        spawnBullets = new Seq<BulletType>().add(
                            new LaserBulletType() {{
                                length = 120f;
                                width = 16f;
                                damage = 50f;
                                sideAngle = 60f;
                                lifetime = 50f;
                                sideWidth = 2f;
                                sideLength = 40f;
                                colors = new Color[]{
                                    Color.valueOf("218b8f80"),
                                    Color.valueOf("24c8cf99"),
                                    Color.valueOf("ffffff")
                                };
                            }}
                        );
                        despawnShake = 2f;
                        lightColor = Color.valueOf("218b8f");
                        lightRadius = 50f;
                        lightOpacity = 0.7f;
                        speed = 3f;
                        lifetime = 35f;
                        damage = 70f;
                        pierce = true;
                        pierceBuilding = true;
                        pierceCap = 3;
                        trailLength = 22;
                        trailWidth = 6f;
                        trailChance = -1f;
                        width = 20f;
                        //hitSound = Sounds.dullExplosion;
                        height = 26f;
                        frontColor = Color.valueOf("ffffff");
                        backColor = Color.valueOf("218b8f");
                        trailColor = Color.valueOf("218b8f");
                        fragBullets = 3;
                        fragRandomSpread = 0f;
                        fragSpread = 22.5f;
                        fragLifeMin = 1f;
                        fragVelocityMin = 1f;
                        fragVelocityMax = 1f;
                        homingPower = 0.03f;
                        fragLifeMax = 1f;
                        hitEffect = Fx.blastExplosion;
                        lightning = 2;
                        lightningLength = 12;
                        lightningColor = Color.valueOf("218b8f");
                        lightningDamage = 7f;
                        fragBullet = new BasicBulletType(3f, 60f) {{
                            weaveMag = 4f;
                            weaveScale = 4f;
                            despawnShake = 1f;
                            lightColor = Color.valueOf("218b8f");
                            lightRadius = 50f;
                            lightOpacity = 0.7f;
                            lifetime = 35f;
                            pierce = true;
                            pierceBuilding = true;
                            pierceCap = 3;
                            trailLength = 22;
                            trailWidth = 6f;
                            trailChance = -1f;
                            width = 18f;
                            //hitSound = Sounds.dullExplosion;
                            height = 24f;
                            frontColor = Color.valueOf("ffffff");
                            backColor = Color.valueOf("218b8f");
                            trailColor = Color.valueOf("218b8f");
                            hitEffect = Fx.flakExplosion;
                            lightning = 1;
                            homingPower = 0.03f;
                            lightningLength = 9;
                            lightningColor = Color.valueOf("218b8f");
                            lightningDamage = 6f;
                            fragBullets = 3;
                            fragRandomSpread = 0f;
                            fragSpread = 22.5f;
                            fragLifeMin = 1f;
                            fragVelocityMin = 1f;
                            fragVelocityMax = 1f;
                            fragLifeMax = 1f;
                            fragBullet = new BasicBulletType(3f, 50f) {{
                                weaveMag = 4f;
                                weaveScale = 4f;
                                lightColor = Color.valueOf("218b8f");
                                lightRadius = 50f;
                                lightOpacity = 0.7f;
                                lifetime = 35f;
                                width = 16f;
                                height = 22f;
                                pierce = true;
                                //hitSound = Sounds.dullExplosion;
                                homingPower = 0.03f;
                                pierceBuilding = true;
                                pierceCap = 3;
                                trailWidth = 6f;
                                trailLength = 22;
                                frontColor = Color.valueOf("ffffff");
                                backColor = Color.valueOf("218b8f");
                                trailColor = Color.valueOf("218b8f");
                                hitEffect = Fx.hitBulletColor;
                                lightning = 1;
                                lightningLength = 6;
                                lightningColor = Color.valueOf("218b8f");
                                lightningDamage = 5f;
                            }};
                        }};
                    }};
                }}
            );
        }};
    }
}
