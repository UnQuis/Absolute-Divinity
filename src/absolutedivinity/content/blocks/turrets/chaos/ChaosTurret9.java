package absolutedivinity.content.blocks.turrets.chaos;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ContinuousFlameBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret9 {
    public static ItemTurret chaosTurret9;

    public static void load() {{
        chaosTurret9 = new ItemTurret("chaos-9") {{
            localizedName = "Chaos Flamethrower";
            description = "Continuous stream of chaotic fire.";
            size = 4;
            health = 4500;
            range = 240f;
            reload = 6f;
            rotateSpeed = 5f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootBig(ADColor.chaosMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.chaosDark);
            heatColor = ADColor.chaosMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 900,
                Items.lead, 700,
                Items.graphite, 250,
                Items.silicon, 180,
                Items.titanium, 150,
                Items.thorium, 100,
                Items.surgeAlloy, 50
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new ContinuousFlameBulletType() {{
                damage = 40f;
                length = 220f;
                hitEffect = ADTurretEffects.hitMedium(ADColor.chaosMain);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.chaosDark);
                shootEffect = ADTurretEffects.trailEffect(ADColor.chaosMain);
                pierce = true;
                pierceCap = -1;
                hittable = false;
                collides = false;
                keepVelocity = false;
                status = StatusEffects.burning;
                statusDuration = 90f;
            }});
        }};
    }}
}
