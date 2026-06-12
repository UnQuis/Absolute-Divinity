package absolutedivinity.content.blocks.turrets.chaos;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret2 {
    public static ItemTurret chaosTurret2;

    public static void load() {{
        chaosTurret2 = new ItemTurret("chaos-2") {{
            localizedName = "Chaos Flare";
            description = "Fires incendiary bolts that ignite targets.";
            size = 1;
            health = 370;
            range = 160f;
            reload = 30f;
            rotateSpeed = 9f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootSmall(ADColor.chaosMain);
            smokeEffect = ADTurretEffects.shootSmall(ADColor.chaosDark);
            heatColor = ADColor.chaosMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 40,
                Items.lead, 35
            ));
            category = Category.turret;
            ammo(Items.pyratite, new BasicBulletType(5f, 12f) {{
                width = 6f;
                height = 6f;
                lifetime = 33f;
                hitEffect = ADTurretEffects.hitSmall(ADColor.chaosMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.chaosLight);
                trailEffect = ADTurretEffects.trailEffect(ADColor.chaosMain);
                trailChance = 0.3f;
                frontColor = ADColor.chaosLight;
                backColor = ADColor.chaosMain;
                knockback = 0.4f;
                status = StatusEffects.burning;
                statusDuration = 90f;
            }});
        }};
    }}
}
