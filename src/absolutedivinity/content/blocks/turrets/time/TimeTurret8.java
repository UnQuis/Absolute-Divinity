package absolutedivinity.content.blocks.turrets.time;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret8 {
    public static ItemTurret timeTurret8;

    public static void load() {{
        timeTurret8 = new ItemTurret("time-8") {{
            localizedName = "Chrono Cannon";
            description = "Fires devastating temporal blasts that freeze everything in their path.";
            size = 4;
            health = 3800;
            range = 280f;
            reload = 70f;
            rotateSpeed = 3f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 700,
                Items.lead, 550,
                Items.graphite, 200,
                Items.silicon, 150,
                Items.titanium, 120,
                Items.thorium, 80
            ));
            category = Category.turret;
            ammo(Items.thorium, new BasicBulletType(8f, 200f) {{
                width = 10f;
                height = 16f;
                lifetime = 35f;
                hitEffect = Fx.massiveExplosion;
                despawnEffect = Fx.massiveExplosion;
                smokeEffect = Fx.shootBigSmoke;
                frontColor = Color.valueOf("88ccff");
                backColor = Color.valueOf("4488aa");
                pierce = true;
                pierceArmor = true;
                pierceCap = 5;
                knockback = 4f;
                hitShake = 8f;
                status = StatusEffects.freezing;
                statusDuration = 240f;
            }});
        }};
    }}
}
