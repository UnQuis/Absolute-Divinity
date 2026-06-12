package absolutedivinity.content.blocks.turrets.abyss;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret6 {
    public static ItemTurret abyssTurret6;

    public static void load() {{
        abyssTurret6 = new ItemTurret("abyss-6") {{
            localizedName = "Abyss Repeater";
            description = "Fires homing missiles that track and pursue their targets relentlessly.";
            size = 3;
            health = 1400;
            range = 250f;
            reload = 60f;
            rotateSpeed = 6f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 200,
                Items.lead, 150,
                Items.graphite, 70,
                Items.silicon, 50,
                Items.titanium, 30
            ));
            category = Category.turret;
            ammo(Items.titanium, new MissileBulletType(4f, 28f) {{
                width = 8f;
                height = 8f;
                lifetime = 60f;
                hitEffect = Fx.blastExplosion;
                despawnEffect = Fx.blastExplosion;
                smokeEffect = Fx.shootBigSmoke;
                frontColor = Items.titanium.color;
                backColor = Items.titanium.color;
                homingPower = 0.08f;
                homingRange = 120f;
                knockback = 1f;
                splashDamageRadius = 16f;
                splashDamage = 10f;
            }});
            ammo(Items.phaseFabric, new MissileBulletType(5f, 45f) {{
                width = 9f;
                height = 9f;
                lifetime = 65f;
                hitEffect = Fx.blastExplosion;
                despawnEffect = Fx.blastExplosion;
                smokeEffect = Fx.shootBigSmoke;
                frontColor = Items.phaseFabric.color;
                backColor = Items.phaseFabric.color;
                homingPower = 0.1f;
                homingRange = 160f;
                knockback = 1.5f;
                splashDamageRadius = 24f;
                splashDamage = 20f;
                lightning = 2;
                lightningDamage = 8f;
                lightningLength = 8;
            }});
        }};
    }}
}
