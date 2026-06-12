package absolutedivinity.content.blocks.turrets.chaos;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret8 {
    public static ItemTurret chaosTurret8;

    public static void load() {{
        chaosTurret8 = new ItemTurret("chaos-8") {{
            localizedName = "Chaos Repeater";
            description = "Rapid-fire siege platform that rains down incendiary chaos.";
            size = 4;
            health = 3500;
            range = 300f;
            reload = 30f;
            rotateSpeed = 3.5f;
            targetAir = false;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 650,
                Items.lead, 500,
                Items.graphite, 180,
                Items.silicon, 120,
                Items.titanium, 100,
                Items.pyratite, 60
            ));
            category = Category.turret;
            ammo(Items.pyratite, new ArtilleryBulletType(5f, 60f, "shell") {{
                hitEffect = Fx.massiveExplosion;
                despawnEffect = Fx.massiveExplosion;
                width = 12f;
                height = 12f;
                lifetime = 65f;
                hitShake = 6f;
                splashDamageRadius = 45f;
                splashDamage = 50f;
                knockback = 3.5f;
                frontColor = Items.pyratite.color;
                backColor = Items.pyratite.color;
                status = mindustry.content.StatusEffects.burning;
                statusDuration = 180f;
            }});
        }};
    }}
}
