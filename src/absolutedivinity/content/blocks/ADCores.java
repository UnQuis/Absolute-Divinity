package absolutedivinity.content.blocks;

import absolutedivinity.content.ADUnits;
import absolutedivinity.content.units.idk.UmbralReaperUnit;
import absolutedivinity.content.units.t1.BulwarkUnit;
import arc.util.Time;
import mindustry.content.Items;
import mindustry.entities.Units;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.storage.CoreBlock;

public class ADCores {
    public static CoreBlock
        energyCore,
        ascensionCore;

    public static void load(){
        energyCore = new CoreBlock("energy-core"){{
            localizedName = "Energy Core";
            description = "Upgraded core with more storage, health and energy source.";
            unitType = UmbralReaperUnit.umbralReaper;
            health = 70000;
            size = 6;
            armor = 8f;
            category = Category.effect;
            itemCapacity = 25000;
            thrusterLength = 28;
            hasPower = true;
            outputsPower = true;
            consumesPower = false;
            incinerateNonBuildable = true;
            requiresCoreZone = true;
            alwaysUnlocked = false;
            isFirstTier = false;
            squareSprite = false;
            unitCapModifier = 92;
            requirements(Category.effect, ItemStack.with(
                Items.copper, 9000,
                Items.silicon, 8000,
                Items.titanium, 5000,
                Items.thorium, 3000
            ));
            buildType = () -> new CoreBuild(){
                @Override
                public float getPowerProduction(){
                    return 16.67f;
                }
            };
        }};
    }
}
