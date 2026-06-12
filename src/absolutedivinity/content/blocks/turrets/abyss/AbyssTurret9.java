package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ContinuousFlameBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret9 {
    public static ItemTurret abyssTurret9;

    public static void load() {{
        abyssTurret9 = new ItemTurret("abyss-9") {{
            localizedName = "Abyss Beam";
            description = "Fires a continuous corrosive beam that melts through everything.";
            size = 4;
            health = 4000;
            range = 280f;
            reload = 8f;
            rotateSpeed = 4f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootBig(ADColor.abyssMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.abyssDark);
            heatColor = ADColor.abyssMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 800,
                Items.lead, 600,
                Items.graphite, 200,
                Items.silicon, 150,
                Items.titanium, 120,
                Items.thorium, 80,
                Items.surgeAlloy, 40
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new ContinuousFlameBulletType() {{
                damage = 45f;
                length = 250f;
                hitEffect = ADTurretEffects.hitMedium(ADColor.abyssMain);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.abyssDark);
                shootEffect = ADTurretEffects.trailEffect(ADColor.abyssMain);
                pierce = true;
                pierceCap = -1;
                hittable = false;
                collides = false;
                keepVelocity = false;
                status = StatusEffects.melting;
                statusDuration = 60f;
            }});
        }};
    }}
}
