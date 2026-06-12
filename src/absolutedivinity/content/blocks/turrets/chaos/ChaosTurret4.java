package absolutedivinity.content.blocks.turrets.chaos;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret4 {
    public static ItemTurret chaosTurret4;

    public static void load() {{
        chaosTurret4 = new ItemTurret("chaos-4") {{
            localizedName = "Chaos Volley";
            description = "Fires a burst of randomized projectiles at different speeds.";
            size = 2;
            health = 850;
            range = 200f;
            reload = 15f;
            rotateSpeed = 7f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.shootSmallSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 100,
                Items.lead, 80,
                Items.graphite, 30
            ));
            category = Category.turret;
            ammo(Items.graphite, new BasicBulletType(6f, 18f) {{
                width = 5f;
                height = 5f;
                lifetime = 34f;
                hitEffect = Fx.hitBulletSmall;
                despawnEffect = Fx.titanExplosionSmall;
                smokeEffect = Fx.shootSmallSmoke;
                frontColor = Color.valueOf("ff6b6b");
                backColor = Color.valueOf("cc4444");
                knockback = 0.6f;
            }});
        }};
    }}
}
