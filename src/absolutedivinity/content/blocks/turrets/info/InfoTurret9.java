package absolutedivinity.content.blocks.turrets.info;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret9 {
    public static ItemTurret infoTurret9;

    public static void load() {{
        infoTurret9 = new ItemTurret("info-9") {{
            localizedName = "Info Beam";
            description = "Fires a devastating precision beam that melts through everything.";
            size = 4;
            health = 5000;
            range = 270f;
            reload = 5f;
            rotateSpeed = 4.5f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 1100,
                Items.lead, 850,
                Items.graphite, 300,
                Items.silicon, 220,
                Items.titanium, 180,
                Items.thorium, 120,
                Items.surgeAlloy, 70
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new BasicBulletType(0f, 50f) {{
                speed = 0f;
                lifetime = 7f;
                hitEffect = Fx.hitMeltdown;
                despawnEffect = Fx.none;
                smokeEffect = Fx.none;
                shootEffect = Fx.none;
                frontColor = Color.white;
                backColor = Items.surgeAlloy.color;
                pierce = true;
                pierceCap = -1;
                hittable = false;
                collides = false;
                keepVelocity = false;
                damage = 50f;
            }});
        }};
    }}
}
