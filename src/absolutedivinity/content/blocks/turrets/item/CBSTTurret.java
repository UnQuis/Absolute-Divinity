package absolutedivinity.content.blocks.turrets.item;

import arc.graphics.Color;
import arc.struct.ObjectMap;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootPattern;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.draw.DrawTurret;

public class CBSTTurret {

    public static ItemTurret cbst;

    public static void load() {
        cbst = new ItemTurret("cbst") {{
            localizedName = "CBST";
            description = "Cluster bomb strike turret. Fires fragging shells that cover a wide area.";
            targetAir = true;
            targetGround = true;
            reload = 240f;
            recoil = 6f;
            inaccuracy = 0f;
            size = 4;
            health = 1000;
            rotateSpeed = 10f;
            range = 293f;
            category = Category.turret;
            //shootSound = Sounds.crush;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 200,
                Items.lead, 100,
                Items.graphite, 200,
                Items.titanium, 200,
                Items.phaseFabric, 100
            ));
            shoot = new ShootPattern() {{
                shots = 21;
            }};
            ammoTypes = ObjectMap.of(
                Items.copper, new MissileBulletType() {{
                    height = 24f;
                    width = 24f;
                    lightRadius = 40f;
                    lightOpacity = 0.7f;
                    lightColor = Color.valueOf("d99d73");
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("d99d73");
                    trailColor = Color.valueOf("d99d73");
                    trailChance = -1f;
                    trailWidth = 6f;
                    trailLength = 60;
                    speed = 2f;
                    lifetime = 140f;
                    collides = true;
                    damage = 40f;
                    fragBullets = 10;
                    fragBullet = new BasicBulletType() {{
                        frontColor = Color.valueOf("ffffff");
                        backColor = Color.valueOf("d99d73");
                        speed = 3f;
                        damage = 15f;
                        lifetime = 45f;
                        collides = true;
                    }};
                }},
                Items.graphite, new MissileBulletType() {{
                    height = 24f;
                    width = 24f;
                    lightRadius = 40f;
                    lightOpacity = 0.7f;
                    lightColor = Color.valueOf("7575c8");
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("7575c8");
                    trailColor = Color.valueOf("7575c8");
                    trailChance = -1f;
                    trailWidth = 6f;
                    trailLength = 60;
                    speed = 2f;
                    lifetime = 140f;
                    collides = true;
                    damage = 60f;
                    fragBullets = 10;
                    pierce = true;
                    pierceCap = 4;
                    fragBullet = new BasicBulletType() {{
                        frontColor = Color.valueOf("ffffff");
                        backColor = Color.valueOf("7575c8");
                        speed = 3f;
                        damage = 20f;
                        lifetime = 45f;
                        pierce = true;
                        pierceCap = 4;
                        collides = true;
                    }};
                }},
                Items.titanium, new MissileBulletType() {{
                    height = 24f;
                    width = 24f;
                    lightRadius = 40f;
                    lightOpacity = 0.7f;
                    lightColor = Color.valueOf("c85c51");
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("c85c51");
                    trailColor = Color.valueOf("c85c51");
                    trailChance = -1f;
                    trailWidth = 6f;
                    trailLength = 60;
                    speed = 2f;
                    lifetime = 140f;
                    collides = true;
                    damage = 90f;
                    status = StatusEffects.blasted;
                    statusDuration = 60f;
                    fragBullets = 10;
                    fragBullet = new BasicBulletType() {{
                        frontColor = Color.valueOf("ffffff");
                        backColor = Color.valueOf("c85c51");
                        speed = 3f;
                        status = StatusEffects.blasted;
                        statusDuration = 60f;
                        damage = 25f;
                        lifetime = 45f;
                        collides = true;
                    }};
                }},
                Items.silicon, new MissileBulletType() {{
                    height = 24f;
                    width = 24f;
                    lightRadius = 40f;
                    lightOpacity = 0.7f;
                    lightColor = Color.valueOf("570047");
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("570047");
                    trailColor = Color.valueOf("570047");
                    trailChance = -1f;
                    trailWidth = 6f;
                    trailLength = 60;
                    speed = 2f;
                    lifetime = 140f;
                    collides = true;
                    damage = 5f;
                    fragBullets = 10;
                    fragBullet = new BasicBulletType() {{
                        frontColor = Color.valueOf("ffffff");
                        backColor = Color.valueOf("570047");
                        speed = 3f;
                        status = StatusEffects.melting;
                        statusDuration = 8000000f;
                        damage = 2f;
                        lifetime = 45f;
                        collides = true;
                    }};
                }},
                Items.plastanium, new MissileBulletType() {{
                    height = 24f;
                    width = 24f;
                    lightRadius = 40f;
                    lightOpacity = 0.7f;
                    lightColor = Color.valueOf("8c0291");
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("8c0291");
                    trailColor = Color.valueOf("8c0291");
                    trailChance = -1f;
                    trailWidth = 6f;
                    trailLength = 60;
                    speed = 2f;
                    lifetime = 140f;
                    collides = true;
                    damage = 30f;
                    fragBullets = 10;
                    status = StatusEffects.sapped;
                    statusDuration = 60f;
                    fragBullet = new BasicBulletType() {{
                        frontColor = Color.valueOf("ffffff");
                        backColor = Color.valueOf("8c0291");
                        speed = 3f;
                        damage = 10f;
                        status = StatusEffects.slow;
                        statusDuration = 100f;
                        lifetime = 45f;
                        status = StatusEffects.sapped;
                        statusDuration = 60f;
                        collides = true;
                    }};
                }},
                Items.surgeAlloy, new MissileBulletType() {{
                    height = 24f;
                    width = 24f;
                    lightRadius = 40f;
                    lightOpacity = 0.7f;
                    lightColor = Color.valueOf("ba6a83");
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("ba6a83");
                    trailColor = Color.valueOf("ba6a83");
                    trailChance = -1f;
                    trailWidth = 6f;
                    trailLength = 60;
                    speed = 2f;
                    lifetime = 140f;
                    collides = true;
                    damage = 40f;
                    fragBullets = 10;
                    lightning = 3;
                    lightningLength = 8;
                    lightningDamage = 12f;
                    status = StatusEffects.shocked;
                    statusDuration = 60f;
                    fragBullet = new BasicBulletType() {{
                        frontColor = Color.valueOf("ffffff");
                        backColor = Color.valueOf("ba6a83");
                        speed = 3f;
                        damage = 14f;
                        lifetime = 45f;
                        status = StatusEffects.shocked;
                        statusDuration = 60f;
                        collides = true;
                    }};
                }}
            );
            drawer = new DrawTurret() {{
                parts.add(new RegionPart() {{
                    suffix = "-horn";
                    mirror = true;
                    under = true;
                    progress = PartProgress.recoil;
                    moveY = -2.5f;
                    moveRot = -16f;
                }});
            }};
        }};
    }
}
