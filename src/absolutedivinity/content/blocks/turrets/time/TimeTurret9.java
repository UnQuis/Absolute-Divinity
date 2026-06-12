package absolutedivinity.content.blocks.turrets.time;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret9 {
    public static ItemTurret timeTurret9;

    public static void load() {{
        timeTurret9 = new ItemTurret("time-9") {{
            localizedName = "Chrono Beam";
            description = "Fires a continuous temporal beam.";
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
            ammo(Items.surgeAlloy, new BasicBulletType(0f, 40f) {{
                speed = 0f;
                lifetime = 8f;
                hitEffect = ADTurretEffects.hitMedium(ADColor.timeMain);
                despawnEffect = ADTurretEffects.trailEffect(ADColor.timeDark);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.timeDark);
                shootEffect = ADTurretEffects.trailEffect(ADColor.timeMain);
                frontColor = ADColor.timeLight;
                backColor = ADColor.timeMain;
                pierce = true;
                pierceCap = -1;
                hittable = false;
                collides = false;
                keepVelocity = false;
                damage = 40f;
                status = StatusEffects.freezing;
                statusDuration = 60f;
            }});
        }};
    }}
}
