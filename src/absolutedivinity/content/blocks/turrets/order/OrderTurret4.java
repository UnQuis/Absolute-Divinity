package absolutedivinity.content.blocks.turrets.order;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class OrderTurret4 {
    public static PowerTurret orderTurret4;

    public static void load() {{
        orderTurret4 = new PowerTurret("order-4") {{
            localizedName = "Order Mortar";
            description = "Lobs white energy spheres over obstacles. Cleanses fortified positions.";
            size = 3;
            health = 1280;
            range = 380f;
            reload = 65f;
            rotateSpeed = 4f;
            shootCone = 10f;
            targetAir = false;
            targetGround = true;
            shootEffect = ADEffects.orderShootBig;
            heatColor = Color.white;
            consumePower(8f);
            consumeCoolant(0.2f);
            shootType = new ArtilleryBulletType(3.5f, 180f) {{
                width = 10f;
                height = 14f;
                lifetime = 105f;
                splashDamage = 150f;
                splashDamageRadius = 48f;
                knockback = 6f;
                collidesAir = false;
                collidesGround = true;
                hitEffect = ADEffects.orderBlast;
                despawnEffect = ADEffects.orderBlast;
                shootEffect = Fx.none;
                smokeEffect = Fx.shootBigSmoke2;
                trailEffect = ADEffects.orderTrail;
                trailChance = 1f;
                trailLength = 18;
                trailWidth = 2.5f;
                shrinkX = 0f;
                shrinkY = 0f;
                backColor = Color.white;
                frontColor = Color.white;
                mixColorFrom = Color.white;
                mixColorTo = Color.valueOf("e0e0e0");
            }};
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
