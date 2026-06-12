package absolutedivinity.content.blocks.turrets.time;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret3 {
    public static ItemTurret timeTurret3;

    public static void load() {{
        timeTurret3 = new ItemTurret("time-3") {{
            localizedName = "Chrono Mortar";
            description = "Launches freezing shells.";
            size = 2;
            health = 740;
            range = 260f;
            reload = 88f;
            rotateSpeed = 4f;
            shootCone = 18f;
            targetAir = false;
            targetGround = true;
            shootEffect = ADTurretEffects.shootMedium(ADColor.timeMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.timeDark);
            heatColor = ADColor.timeMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 85,
                Items.lead, 65,
                Items.graphite, 25
            ));
            category = Category.turret;
            ammo(Items.graphite, new ArtilleryBulletType(3f, 30f, "shell") {{
                hitEffect = ADTurretEffects.hitMedium(ADColor.timeMain);
                despawnEffect = ADTurretEffects.hitBig(ADColor.timeMain);
                width = 10f;
                height = 10f;
                lifetime = 88f;
                hitShake = 3f;
                splashDamageRadius = 30f;
                splashDamage = 18f;
                knockback = 1f;
                frontColor = ADColor.timeLight;
                backColor = ADColor.timeMain;
                status = StatusEffects.slow;
                statusDuration = 120f;
            }});
        }};
    }}
}
