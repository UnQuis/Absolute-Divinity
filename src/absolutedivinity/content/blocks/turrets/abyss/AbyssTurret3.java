package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret3 {
    public static ItemTurret abyssTurret3;

    public static void load() {{
        abyssTurret3 = new ItemTurret("abyss-3") {{
            localizedName = "Abyss Fang";
            description = "Rapidly spits acidic globs that slow targets on hit.";
            size = 2;
            health = 720;
            range = 190f;
            reload = 18f;
            rotateSpeed = 9f;
            targetAir = false;
            targetGround = true;
            shootEffect = ADTurretEffects.shootSmall(ADColor.abyssMain);
            smokeEffect = ADTurretEffects.shootSmall(ADColor.abyssDark);
            heatColor = ADColor.abyssMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 80,
                Items.lead, 50,
                Items.graphite, 20
            ));
            category = Category.turret;
            ammo(Items.graphite, new BasicBulletType(6f, 18f) {{
                width = 6f;
                height = 8f;
                lifetime = 32f;
                hitEffect = ADTurretEffects.hitSmall(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.abyssLight);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.abyssDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.abyssMain);
                trailChance = 0.3f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                knockback = 0.5f;
                status = StatusEffects.slow;
                statusDuration = 60f;
            }});
            ammo(Items.silicon, new BasicBulletType(7f, 25f) {{
                width = 6f;
                height = 8f;
                lifetime = 30f;
                hitEffect = ADTurretEffects.hitSmall(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.abyssLight);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.abyssDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.abyssMain);
                trailChance = 0.3f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                knockback = 0.5f;
                pierce = true;
                pierceCap = 2;
                status = StatusEffects.slow;
                statusDuration = 60f;
            }});
        }};
    }}
}
