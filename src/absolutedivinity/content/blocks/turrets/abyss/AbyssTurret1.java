package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADItems;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret1 {
    public static ItemTurret abyssTurret1;

    public static void load() {{
        abyssTurret1 = new ItemTurret("abyss-1") {{
            localizedName = "Abyss Spitter";
            description = "A small turret that spits corrosive projectiles. The first line of abyssal defense.";
            size = 1;
            health = 310;
            range = 150f;
            reload = 40f;
            rotateSpeed = 8f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.shootSmallSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 35,
                Items.lead, 20
            ));
            category = Category.turret;
            ammo(Items.lead, new mindustry.entities.bullet.BasicBulletType(4f, 8f) {{
                width = 5f;
                height = 7f;
                lifetime = 38f;
                hitEffect = Fx.hitBulletSmall;
                despawnEffect = Fx.titanExplosionSmall;
                smokeEffect = Fx.shootSmallSmoke;
                frontColor = Items.lead.color;
                backColor = Items.lead.color;
                knockback = 0.3f;
            }});
        }};
    }}
}
