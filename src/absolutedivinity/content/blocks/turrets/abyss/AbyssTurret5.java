package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret5 {
    public static ItemTurret abyssTurret5;

    public static void load() {{
        abyssTurret5 = new ItemTurret("abyss-5") {{
            localizedName = "Abyss Fangs";
            description = "Twin-linked rapid cannons that shred light targets.";
            size = 2;
            health = 950;
            range = 200f;
            reload = 10f;
            rotateSpeed = 8f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootSmall(ADColor.abyssMain);
            smokeEffect = ADTurretEffects.shootSmall(ADColor.abyssDark);
            heatColor = ADColor.abyssMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 120,
                Items.lead, 90,
                Items.graphite, 45,
                Items.silicon, 30
            ));
            category = Category.turret;
            ammo(Items.graphite, new BasicBulletType(7f, 16f) {{
                width = 5f;
                height = 7f;
                lifetime = 30f;
                hitEffect = ADTurretEffects.hitSmall(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.abyssLight);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.abyssDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.abyssMain);
                trailChance = 0.3f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                knockback = 0.4f;
            }});
            ammo(Items.silicon, new BasicBulletType(8f, 22f) {{
                width = 5f;
                height = 7f;
                lifetime = 28f;
                hitEffect = ADTurretEffects.hitSmall(ADColor.abyssMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.abyssLight);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.abyssDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.abyssMain);
                trailChance = 0.3f;
                frontColor = ADColor.abyssLight;
                backColor = ADColor.abyssMain;
                knockback = 0.4f;
                homingPower = 0.05f;
                homingRange = 80f;
            }});
        }};
    }}
}
