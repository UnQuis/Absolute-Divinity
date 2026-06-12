package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.pattern.ShootSpread;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret1 {
    public static ItemTurret abyssTurret1;

    public static void load() {{
        abyssTurret1 = new ItemTurret("abyss-1") {{
            localizedName = "Abyss Spitter";
            description = "Rapid-fire corrosive spitter. Small but relentless.";
            size = 1;
            health = 310;
            range = 150f;
            reload = 25f;
            rotateSpeed = 8f;
            inaccuracy = 5f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootSmall(ADColor.abyssMain);
            smokeEffect = ADTurretEffects.shootSmall(ADColor.abyssDark);
            heatColor = ADColor.abyssMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 35,
                Items.lead, 20
            ));
            category = Category.turret;
            shoot = new ShootSpread() {{
                shots = 2;
                spread = 8f;
            }};
            ammo(Items.lead, new BasicBulletType(4f, 7f) {{
                width = 4f;
                height = 6f;
                lifetime = 38f;
                hitEffect = ADTurretEffects.hitSmall(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.abyssLight);
                trailEffect = ADTurretEffects.trailEffect(ADColor.abyssMain);
                trailChance = 0.3f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                knockback = 0.2f;
            }});
        }};
    }}
}
