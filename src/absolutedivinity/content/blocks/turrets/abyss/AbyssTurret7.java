package absolutedivinity.content.blocks.turrets.abyss;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret7 {
    public static ItemTurret abyssTurret7;

    public static void load() {{
        abyssTurret7 = new ItemTurret("abyss-7") {{
            localizedName = "Abyss Lance";
            description = "Charged laser bolt that pierces through armor and multiple targets.";
            size = 3;
            health = 1800;
            range = 300f;
            reload = 45f;
            rotateSpeed = 5f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 350,
                Items.lead, 250,
                Items.graphite, 100,
                Items.silicon, 80,
                Items.titanium, 60
            ));
            category = Category.turret;
            ammo(Items.titanium, new BasicBulletType(12f, 45f) {{
                width = 6f;
                height = 14f;
                lifetime = 25f;
                hitEffect = Fx.hitLancer;
                despawnEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                frontColor = Items.titanium.color;
                backColor = Items.titanium.color;
                pierce = true;
                pierceCap = 4;
                pierceArmor = true;
                knockback = 2f;
                hitShake = 3f;
            }});
            ammo(Items.thorium, new BasicBulletType(14f, 80f) {{
                width = 7f;
                height = 16f;
                lifetime = 25f;
                hitEffect = Fx.hitLancer;
                despawnEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                frontColor = Items.thorium.color;
                backColor = Items.thorium.color;
                pierce = true;
                pierceCap = 6;
                pierceArmor = true;
                knockback = 3f;
                hitShake = 5f;
                lightning = 2;
                lightningDamage = 15f;
                lightningLength = 10;
            }});
        }};
    }}
}
