package absolutedivinity.content.blocks.effects;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import absolutedivinity.content.ADItems;

public class ADEffectBlocks {
    public static EarthBorer earthBorerMk1, earthBorerMk2;

    public static void load() {
        earthBorerMk1 = new EarthBorer("earth-borer-mk1") {{
            localizedName = "Earth Borer Mk1";
            description = "Bores through solid unbreakable terrain in front of it using high-frequency drills. The unit is consumed in the process.";
            size = 2;
            timerBreak = 480f;
            maxWallSize = 3;
            health = 800;
            requirements(Category.effect, ItemStack.with(
                ADItems.ferriteCompound, 200,
                ADItems.reinforcedComposite, 150,
                ADItems.matrix, 100
            ));
        }};

        earthBorerMk2 = new EarthBorer("earth-borer-mk2") {{
            localizedName = "Earth Borer Mk2";
            description = "An advanced boring machine capable of drilling through the toughest unbreakable formations. Larger drills with extended reach.";
            size = 3;
            timerBreak = 720f;
            maxWallSize = 5;
            health = 1600;
            requirements(Category.effect, ItemStack.with(
                ADItems.ferriteCompound, 500,
                ADItems.reinforcedComposite, 400,
                ADItems.matrix, 300,
                ADItems.cryoSteel, 200,
                ADItems.blackMythril, 100
            ));
        }};
    }
}
