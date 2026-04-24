package absolutedivinity.content.blocks.turrets.power;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PointDefenseTurret;

public class FragmentTurret {

    public static PointDefenseTurret fragment;

    public static void load() {
        fragment = new PointDefenseTurret("big-segment") {{
            localizedName = "Fragment";
            description = "Damages and destroys incoming projectiles, akin to the segment. Laser projectiles are still not targeted.";
            size = 3;
            health = 410;
            range = 236f;
            reload = 4f;
            hasPower = true;
            shootLength = 14f;
            bulletDamage = 45f;
            consumePower(10f);
            category = Category.turret;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 200,
                Items.lead, 180,
                Items.silicon, 180,
                Items.thorium, 200,
                Items.phaseFabric, 100
            ));
        }};
    }
}
