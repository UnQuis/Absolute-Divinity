package absolutedivinity.content.blocks.turrets.order;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class OrderCataclysm {
    public static PowerTurret orderCataclysm;

    public static void load() {{
        orderCataclysm = new PowerTurret("order-8") {{
            localizedName = "Order Cataclysm";
            description = "Launches cluster shells that split into dozens of white fragments.";
            size = 6;
            health = 7200;
            range = 400f;
            reload = 100f;
            rotateSpeed = 2f;
            shootCone = 8f;
            targetAir = false;
            targetGround = true;
            shootEffect = ADEffects.orderShootBig;
            heatColor = Color.white;
            consumePower(20f);
            consumeCoolant(0.4f);
            shootType = new ArtilleryBulletType(3f, 200f) {{
                width = 16f;
                height = 22f;
                lifetime = 125f;
                splashDamage = 90f;
                splashDamageRadius = 40f;
                knockback = 10f;
                collidesAir = false;
                collidesGround = true;
                hitEffect = ADEffects.orderBlast;
                despawnEffect = ADEffects.orderBlast;
                shootEffect = Fx.none;
                smokeEffect = Fx.shootBigSmoke2;
                trailEffect = ADEffects.orderTrail;
                trailChance = 1f;
                trailLength = 22;
                trailWidth = 4f;
                shrinkX = 0f;
                shrinkY = 0f;
                backColor = Color.white;
                frontColor = Color.white;
                fragBullets = 12;
                fragBullet = new BasicBulletType(2.5f, 35f) {{
                    width = 6f;
                    height = 8f;
                    lifetime = 40f;
                    splashDamage = 20f;
                    splashDamageRadius = 20f;
                    hitEffect = ADEffects.orderFragment;
                    despawnEffect = ADEffects.orderFragment;
                    trailEffect = ADEffects.orderTrail;
                    trailChance = 0.5f;
                    trailLength = 6;
                    trailWidth = 1.5f;
                    backColor = Color.white;
                    frontColor = Color.white;
                }};
            }};
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
