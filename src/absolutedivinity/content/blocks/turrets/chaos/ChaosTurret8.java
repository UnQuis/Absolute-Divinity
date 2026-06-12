package absolutedivinity.content.blocks.turrets.chaos;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret8 {
    public static ItemTurret chaosTurret8;

    public static void load() {{
        chaosTurret8 = new ItemTurret("chaos-8") {{
            localizedName = "Chaos Repeater";
            description = "Rapid-fire siege platform with fire shells.";
            size = 4;
            health = 3500;
            range = 300f;
            reload = 30f;
            rotateSpeed = 3.5f;
            targetAir = false;
            targetGround = true;
            shootEffect = ADTurretEffects.shootBig(ADColor.chaosMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.chaosDark);
            heatColor = ADColor.chaosMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 650,
                Items.lead, 500,
                Items.graphite, 180,
                Items.silicon, 120,
                Items.titanium, 100,
                Items.pyratite, 60
            ));
            category = Category.turret;
            ammo(Items.pyratite, new ArtilleryBulletType(5f, 55f, "shell") {{
                hitEffect = ADTurretEffects.blastEffect(ADColor.chaosMain, 50f);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.chaosLight, 50f);
                width = 12f;
                height = 12f;
                lifetime = 65f;
                hitShake = 6f;
                splashDamageRadius = 45f;
                splashDamage = 45f;
                knockback = 3f;
                frontColor = ADColor.chaosLight;
                backColor = ADColor.chaosMain;
                status = StatusEffects.burning;
                statusDuration = 180f;
            }});
        }};
    }}
}
