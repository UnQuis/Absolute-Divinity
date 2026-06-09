package absolutedivinity.content.blocks.turrets.order;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class OrderTurret1 {
    public static PowerTurret orderTurret1;

    public static void load() {{
        orderTurret1 = new PowerTurret("order-1") {{
            localizedName = "Order Spark";
            description = "Rapid-fires pure white energy bolts. Clean point defense.";
            size = 1;
            health = 550;
            range = 180f;
            reload = 5f;
            rotateSpeed = 12f;
            shootCone = 6f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADEffects.orderShootSmall;
            heatColor = Color.white;
            consumePower(2f);
            shootType = new BasicBulletType(5f, 20f) {{
                width = 5f;
                height = 7f;
                lifetime = 40f;
                knockback = 0.8f;
                hitEffect = ADEffects.orderHitSmall;
                despawnEffect = ADEffects.orderHitSmall;
                shootEffect = Fx.none;
                smokeEffect = Fx.shootSmallSmoke;
                trailEffect = ADEffects.orderTrail;
                trailChance = 1f;
                trailLength = 5;
                trailWidth = 1f;
                backColor = Color.white;
                frontColor = Color.white;
            }};
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
