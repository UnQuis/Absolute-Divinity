package absolutedivinity.content.blocks.turrets.info;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret7 {
    public static ItemTurret infoTurret7;

    public static void load() {{
        infoTurret7 = new ItemTurret("info-7") {{
            localizedName = "Info Howitzer";
            description = "Long-range precision bombardment.";
            size = 3;
            health = 2500;
            range = 330f;
            reload = 95f;
            rotateSpeed = 2.8f;
            shootCone = 10f;
            targetAir = false;
            targetGround = true;
            shootEffect = ADTurretEffects.shootBig(ADColor.infoMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.infoDark);
            heatColor = ADColor.infoMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 440,
                Items.lead, 340,
                Items.graphite, 140,
                Items.silicon, 100,
                Items.titanium, 80
            ));
            category = Category.turret;
            ammo(Items.titanium, new ArtilleryBulletType(4.5f, 100f, "shell") {{
                hitEffect = ADTurretEffects.hitBig(ADColor.infoMain);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.infoMain, 60f);
                width = 12f;
                height = 12f;
                lifetime = 75f;
                hitShake = 7f;
                splashDamageRadius = 48f;
                splashDamage = 55f;
                knockback = 3f;
                frontColor = ADColor.infoLight;
                backColor = ADColor.infoMain;
            }});
        }};
    }}
}
