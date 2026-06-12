package absolutedivinity.content.blocks.turrets.time;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret8 {
    public static ItemTurret timeTurret8;

    public static void load() {{
        timeTurret8 = new ItemTurret("time-8") {{
            localizedName = "Chrono Cannon";
            description = "Fires devastating temporal blasts.";
            size = 4;
            health = 3800;
            range = 280f;
            reload = 70f;
            rotateSpeed = 3f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootBig(ADColor.timeMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.timeDark);
            heatColor = ADColor.timeMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 700,
                Items.lead, 550,
                Items.graphite, 200,
                Items.silicon, 150,
                Items.titanium, 120,
                Items.thorium, 80
            ));
            category = Category.turret;
            ammo(Items.thorium, new ArtilleryBulletType(8f, 180f, "shell") {{
                hitEffect = ADTurretEffects.blastEffect(ADColor.timeMain, 60f);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.timeLight, 60f);
                width = 14f;
                height = 14f;
                lifetime = 35f;
                hitShake = 10f;
                splashDamageRadius = 60f;
                splashDamage = 80f;
                knockback = 5f;
                frontColor = ADColor.timeLight;
                backColor = ADColor.timeMain;
                status = StatusEffects.freezing;
                statusDuration = 240f;
            }});
        }};
    }}
}
