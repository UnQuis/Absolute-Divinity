package absolutedivinity.content.blocks.turrets.item;

import absolutedivinity.content.blocks.turrets.UniversalTurret;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;

public class UniversalTurrets {

    public static UniversalTurret universal;

    public static void load(){
        universal = new UniversalTurret("universal"){{
            localizedName = "Universal";
            requirements(Category.turret, ItemStack.with(
                Items.copper, 200,
                Items.lead, 150,
                Items.silicon, 100,
                Items.titanium, 50
                //too cheap bruh
            ));
        }};
    }
}
