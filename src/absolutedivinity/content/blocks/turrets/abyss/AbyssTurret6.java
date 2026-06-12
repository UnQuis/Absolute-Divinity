package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret6 {
    public static ItemTurret abyssTurret6;

    public static void load() {{
        abyssTurret6 = new ItemTurret("abyss-6") {{
            localizedName = "Abyss Tracker";
            description = "Launches homing missiles that seek targets.";
            size = 3;
            health = 1600;
            range = 250f;
            reload = 55f;
            rotateSpeed = 5f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootMedium(ADColor.abyssMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.abyssDark);
            heatColor = ADColor.abyssMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 280,
                Items.lead, 200,
                Items.graphite, 80,
                Items.silicon, 60,
                Items.titanium, 40
            ));
            category = Category.turret;
            ammo(Items.titanium, new MissileBulletType(4f, 30f) {{
                width = 8f;
                height = 8f;
                lifetime = 60f;
                hitEffect = ADTurretEffects.hitMedium(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.hitBig(ADColor.abyssMain);
                trailEffect = ADTurretEffects.trailEffect(ADColor.abyssMain);
                trailChance = 0.5f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                homingPower = 0.08f;
                homingRange = 120f;
                knockback = 1f;
                splashDamageRadius = 18f;
                splashDamage = 12f;
            }});
            ammo(Items.phaseFabric, new MissileBulletType(5f, 50f) {{
                width = 9f;
                height = 9f;
                lifetime = 65f;
                hitEffect = ADTurretEffects.hitBig(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.abyssMain, 30f);
                trailEffect = ADTurretEffects.trailEffect(ADColor.abyssMain);
                trailChance = 0.5f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                homingPower = 0.1f;
                homingRange = 160f;
                knockback = 1.5f;
                splashDamageRadius = 24f;
                splashDamage = 20f;
                lightning = 2;
                lightningDamage = 10f;
                lightningLength = 8;
                lightningColor = ADColor.abyssGlow;
            }});
        }};
    }}
}
