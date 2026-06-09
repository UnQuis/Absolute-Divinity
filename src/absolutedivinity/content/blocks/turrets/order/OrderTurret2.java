package absolutedivinity.content.blocks.turrets.order;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.entities.pattern.ShootSpread;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class OrderTurret2 {
    public static PowerTurret orderTurret2;

    public static void load() {{
        orderTurret2 = new PowerTurret("order-2") {{
            localizedName = "Order Flak";
            description = "Burst-fires white shrapnel shells. Fills the air with splinters.";
            size = 2;
            health = 800;
            range = 240f;
            reload = 30f;
            rotateSpeed = 8f;
            shootCone = 12f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADEffects.orderShoot;
            heatColor = Color.white;
            consumePower(4f);
            shoot = new ShootSpread() {{
                shots = 4;
                spread = 6f;
            }};
            shootType = new FlakBulletType(4f, 22f) {{
                width = 7f;
                height = 9f;
                lifetime = 55f;
                splashDamage = 12f;
                splashDamageRadius = 28f;
                knockback = 2f;
                hitEffect = ADEffects.orderHit;
                despawnEffect = ADEffects.orderHitSmall;
                shootEffect = Fx.none;
                smokeEffect = Fx.shootSmokeSquare;
                trailEffect = ADEffects.orderTrail;
                trailChance = 0.6f;
                trailLength = 8;
                trailWidth = 1.5f;
                backColor = Color.white;
                frontColor = Color.white;
                hitColor = Color.white;
            }};
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
