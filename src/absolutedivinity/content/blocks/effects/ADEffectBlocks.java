package absolutedivinity.content.blocks.effects;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;

public class ADEffectBlocks {
    public static WallBreaker wallBreaker2, wallBreaker3;

    public static void load() {
        wallBreaker2 = new WallBreaker("wall-breaker-2") {{
            localizedName = "Wall Breaker II";
            description = "Destroys solid unbreakable walls in front of it. Afterwards it is destroyed as well.";
            size = 2;
            timerBreak = 480f;
            maxWallSize = 3;
            health = 800;
            requirements(Category.effect, ItemStack.with(
                Items.copper, 200,
                Items.lead, 150,
                Items.silicon, 100,
                Items.titanium, 80
            ));
        }};

        wallBreaker3 = new WallBreaker("wall-breaker-3") {{
            localizedName = "Wall Breaker III";
            description = "Destroys solid unbreakable walls in front of it. Larger version with extended range.";
            size = 3;
            timerBreak = 720f;
            maxWallSize = 5;
            health = 1600;
            requirements(Category.effect, ItemStack.with(
                Items.copper, 500,
                Items.lead, 400,
                Items.silicon, 300,
                Items.titanium, 200,
                Items.thorium, 100
            ));
        }};
    }
}
