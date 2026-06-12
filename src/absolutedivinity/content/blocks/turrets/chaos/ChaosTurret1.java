package absolutedivinity.content.blocks.turrets.chaos;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret1 {
    public static ItemTurret chaosTurret1;

    public static void load() {{
        chaosTurret1 = new ItemTurret("chaos-1") {{
            localizedName = "Chaos Spark";
            description = "Unleashes erratic energy bursts that deal random damage.";
            size = 1;
            health = 300;
            range = 140f;
            reload = 35f;
            rotateSpeed = 10f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.shootSmallSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 30,
                Items.lead, 25
            ));
            category = Category.turret;
            ammo(Items.lead, new BasicBulletType(4.5f, 11f) {{
                width = 5f;
                height = 5f;
                lifetime = 32f;
                hitEffect = Fx.hitBulletSmall;
                despawnEffect = Fx.titanExplosionSmall;
                smokeEffect = Fx.shootSmallSmoke;
                frontColor = Color.valueOf("ff6b6b");
                backColor = Color.valueOf("cc4444");
                knockback = 0.4f;
            }});
        }};
    }}
}
