package absolutedivinity.content.blocks.turrets.power;

import mindustry.content.Items;
import mindustry.entities.bullet.ContinuousLaserBulletType;
import mindustry.entities.pattern.ShootSpread;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.LaserTurret;

public class OblivionTurret {

    public static LaserTurret oblivion;

    public static void load() {
        oblivion = new LaserTurret("oblivion") {{
            localizedName = "Oblivion";
            description = "Unleashes three concentrated beams of searing energy, overwhelming even the sturdiest foes. Demands colossal coolant flow.";
            size = 5;
            liquidCapacity = 200f;
            shootDuration = 240f;
            health = 2150;
            range = 240f;
            consumePower(28f);
            consumeCoolant(0.6f);
            rotateSpeed = 6f;
            reload = 300f;
            recoil = 8f;
            //shootSound = Sounds.laserbig;
            shoot = new ShootSpread() {{
                shots = 3;
                spread = 10f;
            }};
            shootType = new ContinuousLaserBulletType() {{
                damage = 50f;
                lifetime = 150f;
                fadeTime = 10f;
                length = 350f;
                width = 12f;
            }};
            category = Category.turret;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 1600,
                Items.lead, 600,
                Items.graphite, 460,
                Items.silicon, 500,
                Items.surgeAlloy, 420
            ));
        }};
    }
}
