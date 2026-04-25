package absolutedivinity.content.blocks.turrets.power;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootBarrel;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.draw.DrawTurret;

public class ForkTurret {

    public static PowerTurret fork;

    public static void load() {
        fork = new PowerTurret("fork") {{
            localizedName = "Fork";
            description = "Charges and fires three enhanced beams of piercing energy, optimized for ground assault.";
            targetAir = false;
            health = 1500;
            reload = 70f;
            range = 230f;
            moveWhileCharging = false;
            size = 3;
            //shootSound = Sounds.laser;
            heatColor = Color.valueOf("5782c2");
            inaccuracy = 3f;
            drawer = new DrawTurret() {{
                parts.add(new RegionPart() {{
                    suffix = "-side";
                    mirror = true;
                    progress = PartProgress.warmup;
                    moveX = 1.5f;
                    under = true;
                    moveY = 2f;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -1f, 0f));
                }});
            }};
            consumePower(7f);
            shoot = new ShootBarrel() {{
                firstShotDelay = 30f;
                barrels = new float[]{
                    0f, -3f, 0f,
                    8f, -4f, 0f,
                    -8f, -4f, 0f
                };
                barrelOffset = 1;
                shots = 3;
                shotDelay = 4f;
            }};
            shootType = new LaserBulletType() {{
                length = 220f;
                width = 24f;
                damage = 65f;
                chargeEffect = Fx.lightningCharge;
                colors = new Color[]{
                    Color.valueOf("7382f040"),
                    Color.valueOf("7382f0"),
                    Color.valueOf("ffffff")
                };
            }};
            category = Category.turret;
            //chargeSound = Sounds.lasercharge2;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 90,
                Items.lead, 100,
                Items.silicon, 75,
                Items.titanium, 50
            ));
        }};
    }
}
