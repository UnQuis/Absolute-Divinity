package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADEffects;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret2 {
    public static ItemTurret abyssTurret2;

    public static void load() {{
        abyssTurret2 = new ItemTurret("abyss-2") {{
            localizedName = "Abyss Dart";
            description = "Fires piercing darts that cut through light armor. Useful against clustered enemies.";
            size = 1;
            health = 380;
            range = 170f;
            reload = 32f;
            rotateSpeed = 10f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.shootSmallSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 45,
                Items.lead, 30
            ));
            category = Category.turret;
            ammo(Items.lead, new BasicBulletType(5f, 12f) {{
                width = 4f;
                height = 9f;
                lifetime = 35f;
                hitEffect = Fx.hitBulletSmall;
                despawnEffect = Fx.titanExplosionSmall;
                smokeEffect = Fx.shootSmallSmoke;
                frontColor = Items.lead.color;
                backColor = Items.lead.color;
                pierce = true;
                pierceCap = 2;
                knockback = 0.2f;
            }});
            ammo(Items.graphite, new BasicBulletType(5.5f, 20f) {{
                width = 5f;
                height = 10f;
                lifetime = 35f;
                hitEffect = Fx.hitBulletSmall;
                despawnEffect = Fx.titanExplosionSmall;
                smokeEffect = Fx.shootSmallSmoke;
                frontColor = Items.graphite.color;
                backColor = Items.graphite.color;
                pierce = true;
                pierceCap = 3;
                knockback = 0.3f;
            }});
        }};
    }}
}
