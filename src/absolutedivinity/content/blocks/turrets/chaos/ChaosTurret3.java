package absolutedivinity.content.blocks.turrets.chaos;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret3 {
    public static ItemTurret chaosTurret3;

    public static void load() {{
        chaosTurret3 = new ItemTurret("chaos-3") {{
            localizedName = "Chaos Mortar";
            description = "Launches volatile shells that explode in unpredictable patterns.";
            size = 2;
            health = 700;
            range = 250f;
            reload = 85f;
            rotateSpeed = 4f;
            shootCone = 15f;
            targetAir = false;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 80,
                Items.lead, 60,
                Items.pyratite, 20
            ));
            category = Category.turret;
            ammo(Items.pyratite, new ArtilleryBulletType(3.5f, 35f, "shell") {{
                hitEffect = Fx.blastExplosion;
                despawnEffect = Fx.blastExplosion;
                width = 10f;
                height = 10f;
                lifetime = 75f;
                hitShake = 4f;
                splashDamageRadius = 35f;
                splashDamage = 25f;
                knockback = 2f;
                frontColor = Items.pyratite.color;
                backColor = Items.pyratite.color;
                status = mindustry.content.StatusEffects.burning;
                statusDuration = 120f;
            }});
        }};
    }}
}
