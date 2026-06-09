package absolutedivinity.content.blocks.turrets.order;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class OrderTurret6 {
    public static PowerTurret orderTurret6;

    public static void load() {{
        orderTurret6 = new PowerTurret("order-6") {{
            localizedName = "Order Cannon";
            description = "Heavy cannon firing dense white energy orbs. Devastates groups.";
            size = 4;
            health = 2400;
            range = 330f;
            reload = 55f;
            rotateSpeed = 3.5f;
            shootCone = 6f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADEffects.orderShootBig;
            heatColor = Color.white;
            consumePower(14f);
            consumeCoolant(0.3f);
            shootType = new BasicBulletType(4.5f, 160f) {{
                width = 14f;
                height = 18f;
                lifetime = 70f;
                splashDamage = 130f;
                splashDamageRadius = 50f;
                knockback = 8f;
                hitEffect = ADEffects.orderBlast;
                despawnEffect = ADEffects.orderBlast;
                shootEffect = Fx.none;
                smokeEffect = Fx.shootBigSmoke2;
                trailEffect = ADEffects.orderTrail;
                trailChance = 1f;
                trailLength = 16;
                trailWidth = 4f;
                backColor = Color.white;
                frontColor = Color.white;
            }};
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
