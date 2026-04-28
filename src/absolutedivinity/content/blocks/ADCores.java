package absolutedivinity.content.blocks;

import mindustry.type.Category;
import mindustry.world.blocks.storage.CoreBlock;

import java.sql.Time;

public class ADCores {
    public static CoreBlock
        energyCore,
        ascensionCore;

    public static void load(){
        energyCore = new CoreBlock("energy-core"){{
            localizedName = "Energy Core";
            description = "Upgraded core with more storage, health and energy source.";
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
            buildType = () -> new CoreBuild(){
                @Override
                public void updateTile() {
                    super.updateTile();
                    power.graph.addPower(16.67f * Time.delta);
                }
            };
        }};
    }
}
