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
            localizedName = "Abyss Fang";
            description = "Fires piercing bolts that cut through armor.";
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
            ammo(Items.graphite, new BasicBulletType(5.5f, 14f) {{
                width = 4f;
                height = 8f;
                lifetime = 32f;
                hitEffect = ADTurretEffects.hitSmall(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.abyssLight);
                trailEffect = ADTurretEffects.trailEffect(ADColor.abyssMain);
                trailChance = 0.4f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                pierce = true;
                pierceCap = 2;
                pierceArmor = true;
                knockback = 0.2f;
            }});
            ammo(Items.titanium, new BasicBulletType(6f, 22f) {{
                width = 5f;
                height = 10f;
                lifetime = 30f;
                hitEffect = ADTurretEffects.hitSmall(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.abyssLight);
                trailEffect = ADTurretEffects.trailEffect(ADColor.abyssMain);
                trailChance = 0.4f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                pierce = true;
                pierceCap = 3;
                pierceArmor = true;
                knockback = 0.3f;
            }});
        }};
    }}
}
