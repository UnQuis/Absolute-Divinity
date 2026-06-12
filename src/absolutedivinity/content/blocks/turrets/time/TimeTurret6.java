package absolutedivinity.content.blocks.turrets.time;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret6 {
    public static ItemTurret timeTurret6;

    public static void load() {{
        timeTurret6 = new ItemTurret("time-6") {{
            localizedName = "Chrono Arc";
            description = "Fires temporal lightning that stuns and slows targets.";
            size = 3;
            health = 1700;
            range = 230f;
            reload = 22f;
            rotateSpeed = 7f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 280,
                Items.lead, 220,
                Items.graphite, 80,
                Items.silicon, 60
            ));
            category = Category.turret;
            ammo(Items.silicon, new LightningBulletType() {{
                damage = 20f;
                lightningLength = 15;
                lightningColor = Color.valueOf("88ccff");
                hitEffect = Fx.hitLancer;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                lightColor = Color.valueOf("88ccff");
                lightOpacity = 0.6f;
                status = StatusEffects.slow;
                statusDuration = 90f;
            }});
        }};
    }}
}
