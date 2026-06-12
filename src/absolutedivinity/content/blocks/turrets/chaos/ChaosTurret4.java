package absolutedivinity.content.blocks.turrets.chaos;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.pattern.ShootSpread;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret4 {
    public static ItemTurret chaosTurret4;

    public static void load() {{
        chaosTurret4 = new ItemTurret("chaos-4") {{
            localizedName = "Chaos Barrage";
            description = "Rapid-fire incendiary shotgun.";
            size = 2;
            health = 850;
            range = 200f;
            reload = 50f;
            rotateSpeed = 6f;
            inaccuracy = 15f;
            targetAir = false;
            targetGround = true;
            shootEffect = ADTurretEffects.shootMedium(ADColor.chaosMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.chaosDark);
            heatColor = ADColor.chaosMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 100,
                Items.lead, 80,
                Items.pyratite, 30
            ));
            category = Category.turret;
            shoot = new ShootSpread() {{
                shots = 5;
                spread = 18f;
            }};
            ammo(Items.pyratite, new ArtilleryBulletType(3f, 22f, "shell") {{
                hitEffect = ADTurretEffects.hitSmall(ADColor.chaosMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.chaosLight);
                width = 6f;
                height = 6f;
                lifetime = 35f;
                hitShake = 2f;
                splashDamageRadius = 16f;
                splashDamage = 14f;
                knockback = 1f;
                frontColor = ADColor.chaosLight;
                backColor = ADColor.chaosMain;
                status = StatusEffects.burning;
                statusDuration = 60f;
            }});
        }};
    }}
}
