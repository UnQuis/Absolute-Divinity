package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret8 {
    public static ItemTurret abyssTurret8;

    public static void load() {{
        abyssTurret8 = new ItemTurret("abyss-8") {{
            localizedName = "Abyss Howitzer";
            description = "Heavy siege cannon with massive splash damage.";
            size = 4;
            health = 3200;
            range = 340f;
            reload = 120f;
            rotateSpeed = 3f;
            targetAir = false;
            targetGround = true;
            shootEffect = ADTurretEffects.shootBig(ADColor.abyssMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.abyssDark);
            heatColor = ADColor.abyssMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 600,
                Items.lead, 450,
                Items.graphite, 150,
                Items.silicon, 120,
                Items.titanium, 100,
                Items.thorium, 50
            ));
            category = Category.turret;
            ammo(Items.thorium, new ArtilleryBulletType(4f, 120f, "shell") {{
                hitEffect = ADTurretEffects.hitBig(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.abyssMain, 60f);
                width = 14f;
                height = 14f;
                lifetime = 85f;
                hitShake = 8f;
                splashDamageRadius = 50f;
                splashDamage = 60f;
                knockback = 4f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                lightning = 3;
                lightningDamage = 20f;
                lightningLength = 12;
                lightningColor = ADColor.abyssGlow;
            }});
            ammo(Items.surgeAlloy, new ArtilleryBulletType(4.5f, 180f, "shell") {{
                hitEffect = ADTurretEffects.blastEffect(ADColor.abyssMain, 80f);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.abyssLight, 80f);
                width = 16f;
                height = 16f;
                lifetime = 80f;
                hitShake = 10f;
                splashDamageRadius = 60f;
                splashDamage = 90f;
                knockback = 5f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                lightning = 6;
                lightningDamage = 30f;
                lightningLength = 16;
                lightningColor = ADColor.abyssGlow;
                status = StatusEffects.shocked;
                statusDuration = 90f;
            }});
        }};
    }}
}
