package absolutedivinity.content.blocks.turrets.chaos;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret7 {
    public static ItemTurret chaosTurret7;

    public static void load() {{
        chaosTurret7 = new ItemTurret("chaos-7") {{
            localizedName = "Chaos Howitzer";
            description = "Massive cannon that fires devastating explosive rounds with extreme knockback.";
            size = 3;
            health = 2200;
            range = 320f;
            reload = 100f;
            rotateSpeed = 2.5f;
            shootCone = 10f;
            targetAir = false;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 400,
                Items.lead, 300,
                Items.graphite, 120,
                Items.silicon, 80,
                Items.titanium, 60
            ));
            category = Category.turret;
            ammo(Items.titanium, new BasicBulletType(5f, 120f) {{
                width = 12f;
                height = 14f;
                lifetime = 65f;
                hitEffect = Fx.massiveExplosion;
                despawnEffect = Fx.massiveExplosion;
                smokeEffect = Fx.shootBigSmoke;
                frontColor = Color.valueOf("ff6b6b");
                backColor = Color.valueOf("cc4444");
                knockback = 6f;
                hitShake = 8f;
                splashDamageRadius = 50f;
                splashDamage = 80f;
                lightning = 4;
                lightningDamage = 25f;
                lightningLength = 12;
            }});
        }};
    }}
}
