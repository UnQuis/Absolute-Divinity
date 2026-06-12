package absolutedivinity.content.blocks.turrets.chaos;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.pattern.ShootSpread;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret1 {
    public static ItemTurret chaosTurret1;

    public static void load() {{
        chaosTurret1 = new ItemTurret("chaos-1") {{
            localizedName = "Chaos Spark";
            description = "Rapid-fire energy bursts with random spread.";
            size = 1;
            health = 300;
            range = 140f;
            reload = 28f;
            rotateSpeed = 10f;
            inaccuracy = 8f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootSmall(ADColor.chaosMain);
            smokeEffect = ADTurretEffects.shootSmall(ADColor.chaosDark);
            heatColor = ADColor.chaosMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 30,
                Items.lead, 25
            ));
            category = Category.turret;
            shoot = new ShootSpread() {{
                shots = 3;
                spread = 10f;
            }};
            ammo(Items.lead, new BasicBulletType(4.5f, 9f) {{
                width = 5f;
                height = 5f;
                lifetime = 32f;
                hitEffect = ADTurretEffects.hitSmall(ADColor.chaosMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.chaosLight);
                trailEffect = ADTurretEffects.trailEffect(ADColor.chaosMain);
                trailChance = 0.3f;
                frontColor = ADColor.chaosLight;
                backColor = ADColor.chaosMain;
                knockback = 0.3f;
            }});
        }};
    }}
}
