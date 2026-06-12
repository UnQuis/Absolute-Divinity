package absolutedivinity.content.blocks.turrets.time;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
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
            description = "Rapid-fire temporal projector.";
            size = 2;
            health = 880;
            range = 190f;
            reload = 12f;
            rotateSpeed = 8f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootSmall(ADColor.timeMain);
            smokeEffect = ADTurretEffects.shootSmall(ADColor.timeDark);
            heatColor = ADColor.timeMain;
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
                hitEffect = ADTurretEffects.hitSmall(ADColor.timeMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.timeLight);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.timeDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.timeMain);
                trailChance = 0.3f;
                frontColor = ADColor.timeLight;
                backColor = ADColor.timeMain;
                knockback = 0.3f;
                status = StatusEffects.slow;
                statusDuration = 45f;
            }});
        }};
    }}
}
