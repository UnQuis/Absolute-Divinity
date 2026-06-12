package absolutedivinity.content.blocks.turrets.info;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret8 {
    public static ItemTurret infoTurret8;

    public static void load() {{
        infoTurret8 = new ItemTurret("info-8") {{
            localizedName = "Info Cannon";
            description = "Heavy precision cannon with devastating accuracy.";
            size = 4;
            health = 3600;
            range = 290f;
            reload = 65f;
            rotateSpeed = 3.2f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 680,
                Items.lead, 530,
                Items.graphite, 190,
                Items.silicon, 140,
                Items.titanium, 110,
                Items.thorium, 75
            ));
            category = Category.turret;
            ammo(Items.thorium, new BasicBulletType(9f, 180f) {{
                width = 10f;
                height = 16f;
                lifetime = 33f;
                hitEffect = Fx.massiveExplosion;
                despawnEffect = Fx.massiveExplosion;
                smokeEffect = Fx.shootBigSmoke;
                frontColor = Color.white;
                backColor = Items.thorium.color;
                pierce = true;
                pierceArmor = true;
                pierceCap = 4;
                knockback = 5f;
                hitShake = 8f;
            }});
        }};
    }}
}
