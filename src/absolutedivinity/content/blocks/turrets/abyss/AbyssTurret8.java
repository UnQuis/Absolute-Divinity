package absolutedivinity.content.blocks.turrets.abyss;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret8 {
    public static ItemTurret abyssTurret8;

    public static void load() {{
        abyssTurret8 = new ItemTurret("abyss-8") {{
            localizedName = "Abyss Cannon";
            description = "Heavy siege cannon that fires devastating shells with massive splash damage.";
            size = 4;
            health = 3200;
            range = 340f;
            reload = 120f;
            rotateSpeed = 3f;
            targetAir = false;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 600,
                Items.lead, 450,
                Items.graphite, 150,
                Items.silicon, 120,
                Items.titanium, 100,
                Items.thorium, 50
            ));
            category = Category.turret;
            ammo(Items.thorium, new ArtilleryBulletType(4f, 120f, "shell") {{
                hitEffect = Fx.massiveExplosion;
                despawnEffect = Fx.massiveExplosion;
                width = 14f;
                height = 14f;
                lifetime = 85f;
                hitShake = 8f;
                splashDamageRadius = 50f;
                splashDamage = 60f;
                knockback = 4f;
                frontColor = Items.thorium.color;
                backColor = Items.thorium.color;
                lightning = 3;
                lightningDamage = 20f;
                lightningLength = 12;
            }});
            ammo(Items.surgeAlloy, new ArtilleryBulletType(4.5f, 180f, "shell") {{
                hitEffect = Fx.massiveExplosion;
                despawnEffect = Fx.massiveExplosion;
                width = 16f;
                height = 16f;
                lifetime = 80f;
                hitShake = 10f;
                splashDamageRadius = 60f;
                splashDamage = 90f;
                knockback = 5f;
                frontColor = Items.surgeAlloy.color;
                backColor = Items.surgeAlloy.color;
                lightning = 6;
                lightningDamage = 30f;
                lightningLength = 16;
                status = mindustry.content.StatusEffects.shocked;
                statusDuration = 90f;
            }});
        }};
    }}
}
