package absolutedivinity.content.blocks.turrets.chaos;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret6 {
    public static ItemTurret chaosTurret6;

    public static void load() {{
        chaosTurret6 = new ItemTurret("chaos-6") {{
            localizedName = "Chaos Storm";
            description = "Unleashes electrical chaos with chain lightning bolts.";
            size = 3;
            health = 1600;
            range = 220f;
            reload = 25f;
            rotateSpeed = 6f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 250,
                Items.lead, 200,
                Items.graphite, 70,
                Items.silicon, 50
            ));
            category = Category.turret;
            ammo(Items.silicon, new LightningBulletType() {{
                damage = 22f;
                lightningLength = 14;
                lightningColor = Color.valueOf("ff6b6b");
                hitEffect = Fx.hitLancer;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                lightColor = Color.valueOf("ff6b6b");
                lightOpacity = 0.6f;
            }});
        }};
    }}
}
