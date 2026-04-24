package absolutedivinity.content.blocks.turrets.item;

import arc.struct.ObjectMap;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootBarrel;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.draw.DrawTurret;

public class MissileBatteryTurret {

    public static ItemTurret missileBattery;

    private static class SpawnUnitMissileBulletType extends MissileBulletType {
        public String spawnUnit;

        public SpawnUnitMissileBulletType(float speed, float damage) {
            super(speed, damage);
        }
    }

    public static void load() {
        missileBattery = new ItemTurret("missile-battery") {{
            localizedName = "Missile Battery";
            description = "Deploys ballistic drones that fire a large barrage of homing rockets. Cannot rotate while charging.";
            details = "Using Plastanium as ammo increases the fire rate by 20% and the range slightly.\n\n" +
                      "Using Pyratite as ammo decreases the fire rate by 20% and the range slightly.\n\n" +
                      "Using plastanium ammo consumes less ammo per shot.";
            targetAir = false;
            category = Category.turret;
            moveWhileCharging = false;
            recoil = 7f;
            accurateDelay = false;
            reload = 570f;
            size = 3;
            range = 304f;
            health = 110 * 3 * 3; // scaledHealth = 110
            //shootSound = Sounds.missileLaunch;
            //chargeSound = Sounds.lasercharge;
            requirements(Category.turret, ItemStack.with(
                Items.lead, 260,
                Items.metaglass, 200,
                Items.titanium, 110
            ));
            shoot = new ShootBarrel() {{
                barrels = new float[]{
                    0f, 8f, 0f,
                    20f, 0f, 20f,
                    30f, 7f, 25f,
                    -20f, 0f, -20f,
                    -30f, 7f, -25f
                };
                shots = 15;
                shotDelay = 6f;
                firstShotDelay = 120f;
            }};

            ammoTypes = ObjectMap.of(
                Items.pyratite, new SpawnUnitMissileBulletType(0f, 0f) {{
                    ammoMultiplier = 7f;
                    instantDisappear = true;
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootSmokeMissile;
                    damage = 0f;
                    rangeChange = -16f;
                    spawnUnit = "fadingrevelations-tiny-missile";
                }},
                Items.blastCompound, new SpawnUnitMissileBulletType(0f, 0f) {{
                    ammoMultiplier = 10f;
                    instantDisappear = true;
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootSmokeMissile;
                    damage = 0f;
                    spawnUnit = "fadingrevelations-tiny-missile-3";
                }},
                Items.plastanium, new SpawnUnitMissileBulletType(0f, 0f) {{
                    ammoMultiplier = 15f;
                    instantDisappear = true;
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootSmokeMissile;
                    damage = 0f;
                    rangeChange = 16f;
                    spawnUnit = "fadingrevelations-tiny-missile-2";
                }}
            );

            drawer = new DrawTurret() {{
                parts.add(new RegionPart() {{
                    progress = PartProgress.warmup;
                    moveY = 0f;
                    moveX = 20f;
                    suffix = "-drone-1";
                    under = true;
                    moveRot = 20f;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -4f, 0f));
                }});
                parts.add(new RegionPart() {{
                    progress = PartProgress.warmup;
                    moveY = 7f;
                    moveX = 30f;
                    suffix = "-drone-2";
                    under = true;
                    moveRot = 25f;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -4f, 0f));
                }});
                parts.add(new RegionPart() {{
                    progress = PartProgress.warmup;
                    moveY = 0f;
                    moveX = -20f;
                    suffix = "-drone-3";
                    under = true;
                    moveRot = -20f;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -4f, 0f));
                }});
                parts.add(new RegionPart() {{
                    progress = PartProgress.warmup;
                    moveY = 7f;
                    moveX = -30f;
                    suffix = "-drone-4";
                    under = true;
                    moveRot = -25f;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -4f, 0f));
                }});
            }};
        }};
    }
}
