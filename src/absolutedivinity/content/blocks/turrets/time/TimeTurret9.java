package absolutedivinity.content.blocks.turrets.time;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ContinuousFlameBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret9 {
    public static ItemTurret timeTurret9;

    public static void load() {{
        timeTurret9 = new ItemTurret("time-9") {{
            localizedName = "Chrono Freeze Ray";
            description = "Continuous temporal beam that freezes everything.";
            size = 4;
            health = 4800;
            range = 260f;
            reload = 6f;
            rotateSpeed = 4f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootBig(ADColor.timeMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.timeDark);
            heatColor = ADColor.timeMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 1000,
                Items.lead, 800,
                Items.graphite, 280,
                Items.silicon, 200,
                Items.titanium, 160,
                Items.thorium, 110,
                Items.surgeAlloy, 60
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new ContinuousFlameBulletType() {{
                damage = 38f;
                length = 240f;
                hitEffect = ADTurretEffects.hitMedium(ADColor.timeMain);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.timeDark);
                shootEffect = ADTurretEffects.trailEffect(ADColor.timeMain);
                pierce = true;
                pierceCap = -1;
                hittable = false;
                collides = false;
                keepVelocity = false;
                status = StatusEffects.freezing;
                statusDuration = 90f;
            }});
        }};
    }}
}
