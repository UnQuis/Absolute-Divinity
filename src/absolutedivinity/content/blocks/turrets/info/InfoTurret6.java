package absolutedivinity.content.blocks.turrets.info;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret6 {
    public static ItemTurret infoTurret6;

    public static void load() {{
        infoTurret6 = new ItemTurret("info-6") {{
            localizedName = "Info Tracker";
            description = "Launches homing missiles that lock onto and pursue targets.";
            size = 3;
            health = 1750;
            range = 260f;
            reload = 55f;
            rotateSpeed = 5f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 260,
                Items.lead, 210,
                Items.graphite, 75,
                Items.silicon, 55,
                Items.titanium, 35
            ));
            category = Category.turret;
            ammo(Items.titanium, new MissileBulletType(4.5f, 30f) {{
                width = 8f;
                height = 8f;
                lifetime = 58f;
                hitEffect = Fx.blastExplosion;
                despawnEffect = Fx.blastExplosion;
                smokeEffect = Fx.shootBigSmoke;
                frontColor = Items.titanium.color;
                backColor = Items.titanium.color;
                homingPower = 0.1f;
                homingRange = 140f;
                knockback = 1.2f;
                splashDamageRadius = 18f;
                splashDamage = 12f;
            }});
        }};
    }}
}
