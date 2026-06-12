package absolutedivinity.content.blocks.turrets.time;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
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
            description = "Fires bolts that freeze enemies momentarily.";
            size = 1;
            health = 390;
            range = 165f;
            reload = 30f;
            rotateSpeed = 10f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootSmall(ADColor.timeMain);
            smokeEffect = ADTurretEffects.shootSmall(ADColor.timeDark);
            heatColor = ADColor.timeMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 48,
                Items.lead, 35
            ));
            category = Category.turret;
            ammo(Items.graphite, new BasicBulletType(5f, 15f) {{
                width = 5f;
                height = 8f;
                lifetime = 34f;
                hitEffect = ADTurretEffects.hitSmall(ADColor.timeMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.timeLight);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.timeDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.timeMain);
                trailChance = 0.3f;
                frontColor = ADColor.timeLight;
                backColor = ADColor.timeMain;
                knockback = 0.4f;
                status = StatusEffects.freezing;
                statusDuration = 45f;
            }});
        }};
    }}
}
