package absolutedivinity.content.blocks.turrets.time;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret7 {
    public static ItemTurret timeTurret7;

    public static void load() {{
        timeTurret7 = new ItemTurret("time-7") {{
            localizedName = "Chrono Howitzer";
            description = "Heavy temporal cannon with freeze shells.";
            size = 3;
            health = 2400;
            range = 310f;
            reload = 110f;
            rotateSpeed = 2.5f;
            shootCone = 12f;
            targetAir = false;
            targetGround = true;
            shootEffect = ADTurretEffects.shootBig(ADColor.timeMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.timeDark);
            heatColor = ADColor.timeMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 420,
                Items.lead, 320,
                Items.graphite, 130,
                Items.silicon, 90,
                Items.titanium, 70
            ));
            category = Category.turret;
            ammo(Items.titanium, new ArtilleryBulletType(5f, 80f, "shell") {{
                hitEffect = ADTurretEffects.hitBig(ADColor.timeMain);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.timeMain, 50f);
                width = 12f;
                height = 12f;
                lifetime = 62f;
                hitShake = 7f;
                splashDamageRadius = 45f;
                splashDamage = 45f;
                knockback = 4f;
                frontColor = ADColor.timeLight;
                backColor = ADColor.timeMain;
                status = StatusEffects.freezing;
                statusDuration = 180f;
            }});
        }};
    }}
}
