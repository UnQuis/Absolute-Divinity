package absolutedivinity.content.blocks.turrets.time;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret4 {
    public static ItemTurret timeTurret4;

    public static void load() {{
        timeTurret4 = new ItemTurret("time-4") {{
            localizedName = "Chrono Repeater";
            description = "Rapid-fire temporal projector that slows multiple targets.";
            size = 2;
            health = 880;
            range = 190f;
            reload = 12f;
            rotateSpeed = 8f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.shootSmallSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 110,
                Items.lead, 90,
                Items.graphite, 35
            ));
            category = Category.turret;
            ammo(Items.graphite, new BasicBulletType(7f, 14f) {{
                width = 5f;
                height = 6f;
                lifetime = 28f;
                hitEffect = Fx.hitBulletSmall;
                despawnEffect = Fx.titanExplosionSmall;
                smokeEffect = Fx.shootSmallSmoke;
                frontColor = Items.graphite.color;
                backColor = Items.graphite.color;
                knockback = 0.3f;
                status = StatusEffects.slow;
                statusDuration = 45f;
            }});
        }};
    }}
}
