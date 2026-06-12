package absolutedivinity.content.blocks.turrets.time;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret2 {
    public static ItemTurret timeTurret2;

    public static void load() {{
        timeTurret2 = new ItemTurret("time-2") {{
            localizedName = "Chrono Bolt";
            description = "Fires bolts that freeze enemies momentarily on hit.";
            size = 1;
            health = 390;
            range = 165f;
            reload = 30f;
            rotateSpeed = 10f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.shootSmallSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 48,
                Items.lead, 35
            ));
            category = Category.turret;
            ammo(Items.graphite, new BasicBulletType(5f, 15f) {{
                width = 5f;
                height = 8f;
                lifetime = 34f;
                hitEffect = Fx.hitBulletSmall;
                despawnEffect = Fx.titanExplosionSmall;
                smokeEffect = Fx.shootSmallSmoke;
                frontColor = Items.graphite.color;
                backColor = Items.graphite.color;
                knockback = 0.4f;
                status = StatusEffects.freezing;
                statusDuration = 45f;
            }});
        }};
    }}
}
