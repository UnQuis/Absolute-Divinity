package absolutedivinity.content.blocks.turrets.chaos;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret5 {
    public static ItemTurret chaosTurret5;

    public static void load() {{
        chaosTurret5 = new ItemTurret("chaos-5") {{
            localizedName = "Chaos Firestorm";
            description = "Carpet-bombs area with incendiary shells.";
            size = 3;
            health = 1300;
            range = 230f;
            reload = 40f;
            rotateSpeed = 5f;
            targetAir = false;
            targetGround = true;
            shootEffect = ADTurretEffects.shootMedium(ADColor.chaosMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.chaosDark);
            heatColor = ADColor.chaosMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 180,
                Items.lead, 140,
                Items.graphite, 50,
                Items.pyratite, 30
            ));
            category = Category.turret;
            ammo(Items.pyratite, new ArtilleryBulletType(4f, 45f, "shell") {{
                hitEffect = ADTurretEffects.hitBig(ADColor.chaosMain);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.chaosMain, 50f);
                width = 10f;
                height = 10f;
                lifetime = 60f;
                hitShake = 5f;
                splashDamageRadius = 40f;
                splashDamage = 35f;
                knockback = 3f;
                frontColor = ADColor.chaosLight;
                backColor = ADColor.chaosMain;
                status = StatusEffects.burning;
                statusDuration = 150f;
            }});
        }};
    }}
}
