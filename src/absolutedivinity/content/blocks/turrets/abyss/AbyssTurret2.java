package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret2 {
    public static ItemTurret abyssTurret2;

    public static void load() {{
        abyssTurret2 = new ItemTurret("abyss-2") {{
            localizedName = "Abyss Dart";
            description = "Fires piercing darts that cut through light armor.";
            size = 1;
            health = 380;
            range = 170f;
            reload = 32f;
            rotateSpeed = 10f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootSmall(ADColor.abyssMain);
            smokeEffect = ADTurretEffects.shootSmall(ADColor.abyssDark);
            heatColor = ADColor.abyssMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 45,
                Items.lead, 30
            ));
            category = Category.turret;
            ammo(Items.lead, new BasicBulletType(5f, 12f) {{
                width = 4f;
                height = 9f;
                lifetime = 35f;
                hitEffect = ADTurretEffects.hitSmall(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.abyssLight);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.abyssDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.abyssMain);
                trailChance = 0.3f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                pierce = true;
                pierceCap = 2;
                knockback = 0.2f;
            }});
            ammo(Items.graphite, new BasicBulletType(5.5f, 20f) {{
                width = 5f;
                height = 10f;
                lifetime = 35f;
                hitEffect = ADTurretEffects.hitSmall(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.abyssLight);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.abyssDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.abyssMain);
                trailChance = 0.3f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                pierce = true;
                pierceCap = 3;
                knockback = 0.3f;
            }});
        }};
    }}
}
