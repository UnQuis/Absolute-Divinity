package absolutedivinity.content.blocks.turrets.time;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ContinuousFlameBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret5 {
    public static ItemTurret timeTurret5;

    public static void load() {{
        timeTurret5 = new ItemTurret("time-5") {{
            localizedName = "Chrono Beam";
            description = "Continuous temporal beam that freezes targets.";
            size = 3;
            health = 1500;
            range = 200f;
            reload = 8f;
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
            ammo(Items.silicon, new ContinuousFlameBulletType() {{
                damage = 30f;
                length = 180f;
                hitEffect = ADTurretEffects.hitMedium(ADColor.timeMain);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.timeDark);
                shootEffect = ADTurretEffects.trailEffect(ADColor.timeMain);
                pierce = true;
                pierceCap = -1;
                hittable = false;
                collides = false;
                keepVelocity = false;
                status = StatusEffects.freezing;
                statusDuration = 60f;
            }});
        }};
    }}
}
