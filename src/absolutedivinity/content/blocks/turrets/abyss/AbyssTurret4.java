package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret4 {
    public static ItemTurret abyssTurret4;

    public static void load() {{
        abyssTurret4 = new ItemTurret("abyss-4") {{
            localizedName = "Abyss Scatter";
            description = "Fires a shotgun-like burst of corrosive pellets.";
            size = 2;
            health = 850;
            range = 190f;
            reload = 60f;
            rotateSpeed = 6f;
            inaccuracy = 12f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootMedium(ADColor.abyssMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.abyssDark);
            heatColor = ADColor.abyssMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 100,
                Items.lead, 80,
                Items.graphite, 30
            ));
            category = Category.turret;
            shoot = new mindustry.entities.pattern.ShootSpread() {{
                shots = 6;
                spread = 15f;
            }};
            ammo(Items.graphite, new ArtilleryBulletType(3f, 20f, "shell") {{
                hitEffect = ADTurretEffects.hitSmall(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.abyssLight);
                width = 6f;
                height = 6f;
                lifetime = 40f;
                hitShake = 2f;
                splashDamageRadius = 16f;
                splashDamage = 12f;
                knockback = 1f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
            }});
            ammo(Items.pyratite, new ArtilleryBulletType(3.5f, 28f, "shell") {{
                hitEffect = ADTurretEffects.hitSmall(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.abyssLight);
                width = 7f;
                height = 7f;
                lifetime = 40f;
                hitShake = 2f;
                splashDamageRadius = 20f;
                splashDamage = 16f;
                knockback = 1.2f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                status = StatusEffects.burning;
                statusDuration = 60f;
            }});
        }};
    }}
}
