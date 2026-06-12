package absolutedivinity.content.blocks.turrets.abyss;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret4 {
    public static ItemTurret abyssTurret4;

    public static void load() {{
        abyssTurret4 = new ItemTurret("abyss-4") {{
            localizedName = "Abyss Mortar";
            description = "Hurls arcing explosive shells that rain down on groups of enemies.";
            size = 2;
            health = 850;
            range = 260f;
            reload = 90f;
            rotateSpeed = 4f;
            shootCone = 20f;
            targetAir = false;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 100,
                Items.lead, 80,
                Items.graphite, 40,
                Items.silicon, 25
            ));
            category = Category.turret;
            ammo(Items.graphite, new ArtilleryBulletType(3f, 40f, "shell") {{
                hitEffect = Fx.blastExplosion;
                despawnEffect = Fx.blastExplosion;
                width = 10f;
                height = 10f;
                lifetime = 80f;
                hitShake = 4f;
                splashDamageRadius = 30f;
                splashDamage = 20f;
                knockback = 1.5f;
                frontColor = Items.graphite.color;
                backColor = Items.graphite.color;
            }});
            ammo(Items.pyratite, new ArtilleryBulletType(3f, 55f, "shell") {{
                hitEffect = Fx.blastExplosion;
                despawnEffect = Fx.blastExplosion;
                width = 10f;
                height = 10f;
                lifetime = 80f;
                hitShake = 5f;
                splashDamageRadius = 40f;
                splashDamage = 30f;
                knockback = 2f;
                frontColor = Items.pyratite.color;
                backColor = Items.pyratite.color;
                status = mindustry.content.StatusEffects.burning;
                statusDuration = 120f;
            }});
        }};
    }}
}
