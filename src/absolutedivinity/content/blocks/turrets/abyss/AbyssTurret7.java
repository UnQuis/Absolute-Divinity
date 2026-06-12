package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret7 {
    public static ItemTurret abyssTurret7;

    public static void load() {{
        abyssTurret7 = new ItemTurret("abyss-7") {{
            localizedName = "Abyss Railgun";
            description = "Fires a super-fast piercing bolt that penetrates multiple targets.";
            size = 3;
            health = 1800;
            range = 300f;
            reload = 50f;
            rotateSpeed = 5f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootMedium(ADColor.abyssMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.abyssDark);
            heatColor = ADColor.abyssMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 350,
                Items.lead, 250,
                Items.graphite, 100,
                Items.silicon, 80,
                Items.titanium, 60
            ));
            category = Category.turret;
            ammo(Items.titanium, new BasicBulletType(14f, 50f) {{
                width = 5f;
                height = 12f;
                lifetime = 22f;
                hitEffect = ADTurretEffects.hitMedium(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.hitBig(ADColor.abyssMain);
                trailEffect = ADTurretEffects.trailEffect(ADColor.abyssMain);
                trailChance = 0.6f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                pierce = true;
                pierceCap = 4;
                pierceArmor = true;
                knockback = 2f;
                hitShake = 3f;
            }});
            ammo(Items.thorium, new BasicBulletType(16f, 90f) {{
                width = 6f;
                height = 14f;
                lifetime = 20f;
                hitEffect = ADTurretEffects.hitBig(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.abyssMain, 30f);
                trailEffect = ADTurretEffects.trailEffect(ADColor.abyssMain);
                trailChance = 0.6f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                pierce = true;
                pierceCap = 6;
                pierceArmor = true;
                knockback = 3f;
                hitShake = 5f;
                lightning = 2;
                lightningDamage = 15f;
                lightningLength = 10;
                lightningColor = ADColor.abyssGlow;
            }});
        }};
    }}
}
