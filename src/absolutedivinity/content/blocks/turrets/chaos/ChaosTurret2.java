package absolutedivinity.content.blocks.turrets.chaos;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret2 {
    public static ItemTurret chaosTurret2;

    public static void load() {{
        chaosTurret2 = new ItemTurret("chaos-2") {{
            localizedName = "Chaos Flare";
            description = "Fires unstable projectiles that ignite on impact.";
            size = 1;
            health = 370;
            range = 160f;
            reload = 28f;
            rotateSpeed = 9f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.shootSmallSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 40,
                Items.lead, 35
            ));
            category = Category.turret;
            ammo(Items.pyratite, new BasicBulletType(5f, 14f) {{
                width = 6f;
                height = 6f;
                lifetime = 33f;
                hitEffect = Fx.hitBulletSmall;
                despawnEffect = Fx.titanExplosionSmall;
                smokeEffect = Fx.shootSmallSmoke;
                frontColor = Items.pyratite.color;
                backColor = Items.pyratite.color;
                knockback = 0.5f;
                status = mindustry.content.StatusEffects.burning;
                statusDuration = 90f;
            }});
        }};
    }}
}
