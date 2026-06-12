package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret3 {
    public static ItemTurret abyssTurret3;

    public static void load() {{
        abyssTurret3 = new ItemTurret("abyss-3") {{
            localizedName = "Abyss Mortar";
            description = "Launches arcing shells that rain down on enemies.";
            size = 2;
            health = 720;
            range = 220f;
            reload = 80f;
            rotateSpeed = 4f;
            shootCone = 20f;
            targetAir = false;
            targetGround = true;
            shootEffect = ADTurretEffects.shootMedium(ADColor.abyssMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.abyssDark);
            heatColor = ADColor.abyssMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 80,
                Items.lead, 50,
                Items.graphite, 20
            ));
            category = Category.turret;
            ammo(Items.graphite, new ArtilleryBulletType(3f, 35f, "shell") {{
                hitEffect = ADTurretEffects.hitMedium(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.hitBig(ADColor.abyssMain);
                width = 10f;
                height = 10f;
                lifetime = 80f;
                hitShake = 4f;
                splashDamageRadius = 30f;
                splashDamage = 25f;
                knockback = 1.5f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
            }});
            ammo(Items.pyratite, new ArtilleryBulletType(3f, 45f, "shell") {{
                hitEffect = ADTurretEffects.hitBig(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.abyssMain, 40f);
                width = 10f;
                height = 10f;
                lifetime = 80f;
                hitShake = 5f;
                splashDamageRadius = 35f;
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
