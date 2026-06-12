package absolutedivinity.content.blocks.turrets.time;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret6 {
    public static ItemTurret timeTurret6;

    public static void load() {{
        timeTurret6 = new ItemTurret("time-6") {{
            localizedName = "Chrono Arc";
            description = "Temporal lightning that stuns and slows.";
            size = 3;
            health = 1700;
            range = 230f;
            reload = 22f;
            rotateSpeed = 7f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootMedium(ADColor.timeMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.timeDark);
            heatColor = ADColor.timeMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 280,
                Items.lead, 220,
                Items.graphite, 80,
                Items.silicon, 60
            ));
            category = Category.turret;
            ammo(Items.silicon, new LightningBulletType() {{
                damage = 20f;
                lightningLength = 15;
                lightningColor = ADColor.timeGlow;
                hitEffect = ADTurretEffects.hitMedium(ADColor.timeMain);
                shootEffect = ADTurretEffects.shootMedium(ADColor.timeMain);
                smokeEffect = ADTurretEffects.shootBig(ADColor.timeDark);
                lightColor = ADColor.timeGlow;
                lightOpacity = 0.6f;
                status = StatusEffects.slow;
                statusDuration = 90f;
            }});
        }};
    }}
}
