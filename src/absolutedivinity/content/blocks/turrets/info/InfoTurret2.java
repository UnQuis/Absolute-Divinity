package absolutedivinity.content.blocks.turrets.info;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret2 {
    public static ItemTurret infoTurret2;

    public static void load() {{
        infoTurret2 = new ItemTurret("info-2") {{
            localizedName = "Info Dart";
            description = "Fires homing data darts that track their targets.";
            size = 1;
            health = 400;
            range = 175f;
            reload = 30f;
            rotateSpeed = 10f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.shootSmallSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 46,
                Items.lead, 32
            ));
            category = Category.turret;
            ammo(Items.graphite, new BasicBulletType(5f, 16f) {{
                width = 5f;
                height = 7f;
                lifetime = 36f;
                hitEffect = Fx.hitBulletSmall;
                despawnEffect = Fx.titanExplosionSmall;
                smokeEffect = Fx.shootSmallSmoke;
                frontColor = Items.graphite.color;
                backColor = Items.graphite.color;
                knockback = 0.3f;
                homingPower = 0.04f;
                homingRange = 80f;
            }});
        }};
    }}
}
