package absolutedivinity.content.blocks.effects;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;

public class ADEffectBlocks {
    public static Disruptor disruptor2, disruptor3;

    public static void load() {
        disruptor2 = new Disruptor("disruptor-2") {{
            localizedName = "Disruptor";
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

        disruptor3 = new Disruptor("disruptor-3") {{
            localizedName = "Disruptor III";
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
