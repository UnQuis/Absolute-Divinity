package absolutedivinity.content.blocks.turrets.time;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
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
            description = "Charged temporal beam that freezes targets.";
            size = 3;
            health = 1500;
            range = 220f;
            reload = 50f;
            rotateSpeed = 6f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootMedium(ADColor.timeMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.timeDark);
            heatColor = ADColor.timeMain;
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
                hitEffect = ADTurretEffects.hitMedium(ADColor.timeMain);
                despawnEffect = ADTurretEffects.hitBig(ADColor.timeMain);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.timeDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.timeMain);
                trailChance = 0.5f;
                frontColor = ADColor.timeLight;
                backColor = ADColor.timeMain;
                pierce = true;
                pierceCap = 3;
                knockback = 1.5f;
                status = StatusEffects.freezing;
                statusDuration = 90f;
            }});
        }};
    }}
}
