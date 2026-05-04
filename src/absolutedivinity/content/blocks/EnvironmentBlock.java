package absolutedivinity.content.blocks;

import absolutedivinity.content.ADItems;
import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;

public class EnvironmentBlock {

    public static Block
            oreDivinite, oreCelestite, oreMythril, oreBlackMythril;

    public static void load(){
        oreDivinite = new OreBlock("ore-divinite", ADItems.divinite);
        oreCelestite = new OreBlock("ore-celestite", ADItems.celestite);
        oreMythril = new OreBlock("ore-mythril", ADItems.mythril);
        oreBlackMythril = new OreBlock("ore-black-mythril", ADItems.blackMythril);
    }
}
