package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret5 {
    public static ItemTurret abyssTurret5;

    public static void load() {{
        abyssTurret5 = new ItemTurret("abyss-5") {{
            localizedName = "Abyss Arc";
            description = "Fires lightning bolts that chain between enemies.";
            size = 3;
            health = 1400;
            range = 200f;
            reload = 35f;
            rotateSpeed = 7f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootMedium(ADColor.abyssMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.abyssDark);
            heatColor = ADColor.abyssMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 200,
                Items.lead, 150,
                Items.graphite, 60,
                Items.silicon, 40
            ));
            category = Category.turret;
            ammo(Items.silicon, new LightningBulletType() {{
                damage = 25f;
                lightningLength = 12;
                lightningColor = ADColor.abyssGlow;
                hitEffect = ADTurretEffects.hitMedium(ADColor.abyssMain);
                shootEffect = ADTurretEffects.shootMedium(ADColor.abyssMain);
                smokeEffect = ADTurretEffects.shootBig(ADColor.abyssDark);
                lightColor = ADColor.abyssGlow;
                lightOpacity = 0.6f;
                status = StatusEffects.shocked;
                statusDuration = 60f;
            }});
        }};
    }}
}
