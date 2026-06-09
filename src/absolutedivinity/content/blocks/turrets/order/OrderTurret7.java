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

public class OrderTurret7 {
    public static PowerTurret orderTurret7;

    public static void load() {{
        orderTurret7 = new PowerTurret("order-7") {{
            localizedName = "Order Beam";
            description = "Generates a searing beam of pure white light. Melts through anything.";
            size = 5;
            health = 4800;
            range = 500f;
            reload = 100f;
            rotateSpeed = 2.5f;
            shootCone = 3f;
            targetAir = true;
            targetGround = true;
            shoot = new ShootPattern() {{
                firstShotDelay = 80f;
            }};
            shootEffect = Fx.none;
            heatColor = Color.white;
            consumePower(30f);
            consumeCoolant(0.5f);
            shootType = new LaserBulletType(180f) {{
                length = 510f;
                width = 22f;
                lifetime = 30f;
                pierceCap = 8;
                chargeEffect = ADEffects.orderChargeBig;
                hitEffect = ADEffects.orderLaserHit;
                shootEffect = Fx.none;
                smokeEffect = Fx.none;
                hitColor = Color.white;
                colors = new Color[]{
                    Color.valueOf("e0e0e0"),
                    Color.white,
                    Color.white
                };
                lightningSpacing = 25f;
                lightningLength = 6;
                lightningDelay = 1f;
                lightningDamage = 25f;
                lightningAngleRand = 25f;
                lightningColor = Color.white;
            }};
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
