package absolutedivinity.content.blocks.turrets.order;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class OrderStorm {
    public static PowerTurret orderStorm;

    public static void load() {{
        orderStorm = new PowerTurret("order-5") {{
            localizedName = "Order Storm";
            description = "Conjures white lightning storms. Chains between targets with precision.";
            size = 3;
            health = 1400;
            range = 280f;
            reload = 40f;
            rotateSpeed = 6f;
            shootCone = 8f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADEffects.orderShoot;
            heatColor = Color.white;
            consumePower(9f);
            shootType = new BasicBulletType(3f, 45f) {{
                width = 6f;
                height = 10f;
                lifetime = 28f;
                splashDamage = 25f;
                splashDamageRadius = 18f;
                knockback = 2f;
                hitEffect = ADEffects.orderLightningHit;
                despawnEffect = ADEffects.orderLightningHit;
                shootEffect = Fx.none;
                smokeEffect = Fx.shootSmokeSquare;
                trailEffect = ADEffects.orderTrail;
                trailChance = 0.8f;
                trailLength = 10;
                trailWidth = 2f;
                backColor = Color.white;
                frontColor = Color.white;
                lightning = 3;
                lightningLength = 8;
                lightningLengthRand = 6;
                lightningDamage = 12f;
                lightningCone = 360f;
                lightningColor = Color.white;
            }};
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
