package absolutedivinity.content.blocks.turrets.power;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class AirArcTurret {

    public static PowerTurret airArc;

    public static void load() {
        airArc = new PowerTurret("air-arc") {{
            localizedName = "Air Arc";
            description = "Fires arcs of electricity at airborne targets.";
            size = 1;
            range = 130f;
            reload = 20f;
            //shootSound = Sounds.spark;
            shootCone = 30f;
            shootType = new LightningBulletType() {{
                lightningLength = 16;
                damage = 10f;
            }};
            rotateSpeed = 100f;
            consumePower(3.5f);
            consumeCoolant(0.1f);
            targetAir = true;
            targetGround = false;
            heatColor = Color.valueOf("ff0000");
            shootEffect = Fx.lightningShoot;
            recoil = 1f;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 150,
                Items.lead, 150,
                Items.graphite, 20
            ));
            category = Category.turret;
            health = 320;
        }};
    }
}
