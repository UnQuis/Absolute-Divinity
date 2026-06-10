package absolutedivinity.content.blocks.turrets.order;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.pattern.ShootPattern;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class OrderLance {
    public static PowerTurret orderLance;

    public static void load() {{
        orderLance = new PowerTurret("order-3") {{
            localizedName = "Order Lance";
            description = "Fires a piercing beam of pure white light. Cuts clean through targets.";
            size = 2;
            health = 960;
            range = 250f;
            reload = 60f;
            rotateSpeed = 7f;
            shootCone = 4f;
            targetAir = true;
            targetGround = true;
            shoot = new ShootPattern() {{
                firstShotDelay = 45f;
            }};
            shootEffect = Fx.none;
            heatColor = Color.white;
            consumePower(6f);
            shootType = new LaserBulletType(50f) {{
                length = 260f;
                width = 12f;
                lifetime = 25f;
                pierceCap = 4;
                chargeEffect = ADEffects.orderCharge;
                hitEffect = ADEffects.orderLaserHit;
                shootEffect = Fx.none;
                smokeEffect = Fx.none;
                hitColor = Color.white;
                colors = new Color[]{
                    Color.valueOf("e0e0e0"),
                    Color.white,
                    Color.white
                };
                lightningSpacing = 35f;
                lightningLength = 4;
                lightningDelay = 1.5f;
                lightningDamage = 10f;
                lightningAngleRand = 30f;
                lightningColor = Color.white;
            }};
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
