package absolutedivinity.content.blocks.turrets;

import absolutedivinity.content.ADItems;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.BuildTurret;

public class StationaryPolyTurret {

    public static BuildTurret constructionPylon;

    public static void load() {
        constructionPylon = new BuildTurret("stationary-poly") {{
            localizedName = "Stationary Poly";
            description = "Thys is how Poly would look like without flying ability.";
            requirements(Category.effect, ItemStack.with(
                Items.copper, 90,
                Items.silicon, 60,
                Items.titanium, 150,
                ADItems.livingSteel, 150
            ));
            category = Category.effect;
            size = 3;
            range = 170f;
            buildSpeed = 1.2f;
            consumePower(9f);
            consumeLiquid(Liquids.cryofluid, 0.25f);
        }};
    }
}
