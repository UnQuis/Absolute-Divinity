package absolutedivinity.content.blocks.turrets.chaos;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret6 {
    public static ItemTurret chaosTurret6;

    public static void load() {{
        chaosTurret6 = new ItemTurret("chaos-6") {{
            localizedName = "Chaos Storm";
            description = "Unleashes electrical chaos with chain lightning.";
            size = 3;
            health = 1600;
            range = 220f;
            reload = 25f;
            rotateSpeed = 6f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootMedium(ADColor.chaosMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.chaosDark);
            heatColor = ADColor.chaosMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 250,
                Items.lead, 200,
                Items.graphite, 70,
                Items.silicon, 50
            ));
            category = Category.turret;
            ammo(Items.silicon, new LightningBulletType() {{
                damage = 22f;
                lightningLength = 14;
                lightningColor = ADColor.chaosGlow;
                hitEffect = ADTurretEffects.hitMedium(ADColor.chaosMain);
                shootEffect = ADTurretEffects.shootMedium(ADColor.chaosMain);
                smokeEffect = ADTurretEffects.shootBig(ADColor.chaosDark);
                lightColor = ADColor.chaosGlow;
                lightOpacity = 0.6f;
                status = StatusEffects.shocked;
                statusDuration = 60f;
            }});
        }};
    }}
}
