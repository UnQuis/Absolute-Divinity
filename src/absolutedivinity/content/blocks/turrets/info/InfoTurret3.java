package absolutedivinity.content.blocks.turrets.info;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret3 {
    public static ItemTurret infoTurret3;

    public static void load() {{
        infoTurret3 = new ItemTurret("info-3") {{
            localizedName = "Info Mortar";
            description = "Precision artillery with targeted strikes.";
            size = 2;
            health = 760;
            range = 270f;
            reload = 82f;
            rotateSpeed = 4.5f;
            shootCone = 16f;
            targetAir = false;
            targetGround = true;
            shootEffect = ADTurretEffects.shootMedium(ADColor.infoMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.infoDark);
            heatColor = ADColor.infoMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 90,
                Items.lead, 70,
                Items.graphite, 28
            ));
            category = Category.turret;
            ammo(Items.graphite, new ArtilleryBulletType(3.5f, 38f, "shell") {{
                hitEffect = ADTurretEffects.hitMedium(ADColor.infoMain);
                despawnEffect = ADTurretEffects.hitBig(ADColor.infoMain);
                width = 10f;
                height = 10f;
                lifetime = 80f;
                hitShake = 4f;
                splashDamageRadius = 28f;
                splashDamage = 22f;
                knockback = 1.5f;
                frontColor = ADColor.infoLight;
                backColor = ADColor.infoMain;
            }});
        }};
    }}
}
