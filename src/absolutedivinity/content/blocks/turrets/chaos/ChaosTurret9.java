package absolutedivinity.content.blocks.turrets.chaos;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret9 {
    public static ItemTurret chaosTurret9;

    public static void load() {{
        chaosTurret9 = new ItemTurret("chaos-9") {{
            localizedName = "Chaos Lance";
            description = "Fires a devastating beam of chaotic energy that pierces through everything.";
            size = 4;
            health = 4500;
            range = 280f;
            reload = 60f;
            rotateSpeed = 3f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 900,
                Items.lead, 700,
                Items.graphite, 250,
                Items.silicon, 180,
                Items.titanium, 150,
                Items.thorium, 100,
                Items.surgeAlloy, 50
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new BasicBulletType(16f, 150f) {{
                width = 8f;
                height = 18f;
                lifetime = 18f;
                hitEffect = Fx.hitLancer;
                despawnEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                frontColor = Color.white;
                backColor = Color.valueOf("ff6b6b");
                pierce = true;
                pierceCap = -1;
                pierceArmor = true;
                knockback = 4f;
                hitShake = 6f;
            }});
        }};
    }}
}
