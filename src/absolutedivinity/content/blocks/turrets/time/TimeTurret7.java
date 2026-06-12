package absolutedivinity.content.blocks.turrets.time;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret7 {
    public static ItemTurret timeTurret7;

    public static void load() {{
        timeTurret7 = new ItemTurret("time-7") {{
            localizedName = "Chrono Howitzer";
            description = "Heavy temporal cannon that creates zones of absolute zero.";
            size = 3;
            health = 2400;
            range = 310f;
            reload = 110f;
            rotateSpeed = 2.5f;
            shootCone = 12f;
            targetAir = false;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 420,
                Items.lead, 320,
                Items.graphite, 130,
                Items.silicon, 90,
                Items.titanium, 70
            ));
            category = Category.turret;
            ammo(Items.titanium, new BasicBulletType(5f, 90f) {{
                width = 12f;
                height = 14f;
                lifetime = 62f;
                hitEffect = Fx.massiveExplosion;
                despawnEffect = Fx.massiveExplosion;
                smokeEffect = Fx.shootBigSmoke;
                frontColor = Color.valueOf("88ccff");
                backColor = Color.valueOf("6699cc");
                knockback = 5f;
                hitShake = 7f;
                splashDamageRadius = 45f;
                splashDamage = 50f;
                status = StatusEffects.freezing;
                statusDuration = 180f;
            }});
        }};
    }}
}
