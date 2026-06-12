package absolutedivinity.content.blocks;

import absolutedivinity.content.ADItems;
import absolutedivinity.content.units.idk.EradicatorPrimeUnit;
import absolutedivinity.content.units.idk.UmbralReaperUnit;
import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.storage.CoreBlock;

public class ADCores {
    public static CoreBlock
        primordialCore,
        ascensionCore;

    public static void load(){
        primordialCore = new CoreBlock("primordial-core"){{
            localizedName = "Primordial Core";
            description = "An ancient core of untold power. Generates energy from the fabric of reality itself.";
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

        ascensionCore = new CoreBlock("ascension-core"){{
            localizedName = "Ascension Core";
            description = "The pinnacle of core engineering. A convergence point where all matter transmutes into pure energy.";
            unitType = EradicatorPrimeUnit.eradicatorPrime;
            health = 120000;
            size = 8;
            armor = 15f;
            category = Category.effect;
            itemCapacity = 50000;
            thrusterLength = 36;
            hasPower = true;
            outputsPower = true;
            consumesPower = false;
            incinerateNonBuildable = true;
            requiresCoreZone = true;
            alwaysUnlocked = false;
            isFirstTier = false;
            squareSprite = false;
            unitCapModifier = 200;
            requirements(Category.effect, ItemStack.with(
                Items.copper, 20000,
                Items.silicon, 18000,
                Items.titanium, 12000,
                Items.thorium, 8000,
                ADItems.divinite, 500
            ));
            buildType = () -> new CoreBuild(){
                @Override
                public float getPowerProduction(){
                    return 50f;
                }
            };
        }};
    }
}
