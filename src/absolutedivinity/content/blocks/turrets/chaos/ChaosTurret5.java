package absolutedivinity.content.blocks.turrets.chaos;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret5 {
    public static ItemTurret chaosTurret5;

    public static void load() {{
        chaosTurret5 = new ItemTurret("chaos-5") {{
            localizedName = "Chaos Barrage";
            description = "Rapid-fires incendiary shells that carpet-bomb an area.";
            size = 3;
            health = 1300;
            range = 230f;
            reload = 40f;
            rotateSpeed = 5f;
            targetAir = false;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 180,
                Items.lead, 140,
                Items.graphite, 50,
                Items.pyratite, 30
            ));
            category = Category.turret;
            ammo(Items.pyratite, new ArtilleryBulletType(4f, 45f, "shell") {{
                hitEffect = Fx.blastExplosion;
                despawnEffect = Fx.blastExplosion;
                width = 10f;
                height = 10f;
                lifetime = 60f;
                hitShake = 5f;
                splashDamageRadius = 40f;
                splashDamage = 35f;
                knockback = 3f;
                frontColor = Items.pyratite.color;
                backColor = Items.pyratite.color;
                status = mindustry.content.StatusEffects.burning;
                statusDuration = 150f;
            }});
        }};
    }}
}
