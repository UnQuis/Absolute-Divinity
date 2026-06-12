package absolutedivinity.content.blocks.turrets.time;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret5 {
    public static ItemTurret timeTurret5;

    public static void load() {{
        timeTurret5 = new ItemTurret("time-5") {{
            localizedName = "Chrono Lance";
            description = "Charged temporal beam that freezes targets solid.";
            size = 3;
            health = 1500;
            range = 220f;
            reload = 50f;
            rotateSpeed = 6f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 200,
                Items.lead, 160,
                Items.graphite, 60,
                Items.silicon, 40
            ));
            category = Category.turret;
            ammo(Items.silicon, new BasicBulletType(10f, 35f) {{
                width = 6f;
                height = 12f;
                lifetime = 23f;
                hitEffect = Fx.hitLancer;
                despawnEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                frontColor = Items.silicon.color;
                backColor = Items.silicon.color;
                pierce = true;
                pierceCap = 3;
                knockback = 1.5f;
                status = StatusEffects.freezing;
                statusDuration = 90f;
            }});
        }};
    }}
}
