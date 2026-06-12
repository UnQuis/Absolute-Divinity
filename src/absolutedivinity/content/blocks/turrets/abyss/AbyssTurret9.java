package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret9 {
    public static ItemTurret abyssTurret9;

    public static void load() {{
        abyssTurret9 = new ItemTurret("abyss-9") {{
            localizedName = "Abyss Beam";
            description = "Fires a devastating continuous beam.";
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
            ammo(Items.surgeAlloy, new BasicBulletType(0f, 55f) {{
                speed = 0f;
                lifetime = 8f;
                hitEffect = ADTurretEffects.hitMedium(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.trailEffect(ADColor.abyssDark);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.abyssDark);
                shootEffect = ADTurretEffects.trailEffect(ADColor.abyssMain);
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                pierce = true;
                pierceCap = -1;
                hittable = false;
                collides = false;
                keepVelocity = false;
                damage = 55f;
            }});
        }};
    }}
}
