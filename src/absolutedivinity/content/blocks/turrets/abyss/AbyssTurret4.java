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
            localizedName = "Abyss Mortar";
            description = "Hurls arcing explosive shells that rain down on groups of enemies.";
            size = 2;
            health = 850;
            range = 260f;
            reload = 90f;
            rotateSpeed = 4f;
            shootCone = 20f;
            targetAir = false;
            targetGround = true;
            shootEffect = ADTurretEffects.shootMedium(ADColor.abyssMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.abyssDark);
            heatColor = ADColor.abyssMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 100,
                Items.lead, 80,
                Items.graphite, 40,
                Items.silicon, 25
            ));
            category = Category.turret;
            ammo(Items.graphite, new ArtilleryBulletType(3f, 40f, "shell") {{
                hitEffect = ADTurretEffects.hitMedium(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.hitBig(ADColor.abyssMain);
                width = 10f;
                height = 10f;
                lifetime = 80f;
                hitShake = 4f;
                splashDamageRadius = 30f;
                splashDamage = 20f;
                knockback = 1.5f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
            }});
            ammo(Items.pyratite, new ArtilleryBulletType(3f, 55f, "shell") {{
                hitEffect = ADTurretEffects.hitBig(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.abyssMain, 40f);
                width = 10f;
                height = 10f;
                lifetime = 80f;
                hitShake = 5f;
                splashDamageRadius = 40f;
                splashDamage = 30f;
                knockback = 2f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                status = StatusEffects.burning;
                statusDuration = 120f;
            }});
        }};
    }}
}
