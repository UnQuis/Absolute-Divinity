package absolutedivinity.content.blocks.turrets.time;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret1 {
    public static ItemTurret timeTurret1;

    public static void load() {{
        timeTurret1 = new ItemTurret("time-1") {{
            localizedName = "Chrono Dart";
            description = "Fires temporal darts that slow their targets.";
            size = 1;
            health = 320;
            range = 155f;
            reload = 38f;
            rotateSpeed = 9f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootSmall(ADColor.timeMain);
            smokeEffect = ADTurretEffects.shootSmall(ADColor.timeDark);
            heatColor = ADColor.timeMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 38,
                Items.lead, 25
            ));
            category = Category.turret;
            ammo(Items.lead, new BasicBulletType(4f, 9f) {{
                width = 5f;
                height = 7f;
                lifetime = 40f;
                hitEffect = ADTurretEffects.hitSmall(ADColor.timeMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.timeLight);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.timeDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.timeMain);
                trailChance = 0.3f;
                frontColor = ADColor.timeLight;
                backColor = ADColor.timeMain;
                knockback = 0.3f;
                status = StatusEffects.slow;
                statusDuration = 60f;
            }});
        }};
    }}
}
