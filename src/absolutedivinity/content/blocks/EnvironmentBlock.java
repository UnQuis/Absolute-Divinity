package absolutedivinity.content.blocks;

import absolutedivinity.content.ADItems;
import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.environment.Prop;

public class EnvironmentBlock {

    public static Prop energyNode;

    public static Floor
            dustFloor, metalDebris, ashGround, gravel, crackedStone,
            brokenPanel, oldPipe, cableCluster, scrapPile, rustedPlate,
            unstableGround, heatVent, chargedStone;

    public static Block
            dryBush, fiberPlant, spikeGrass, glowMoss, twistedRoot, crystalShard,
            tallBoulder, splitRock, rockCluster, hollowStone,
            thickRoot, ichorTree, collapsedFrame, antennaFragment, storageWreck, crystalGrowth;

    public static Block
            oreDivinite, oreCelestite, oreMythril, oreBlackMythril;

    public static void load(){
        oreDivinite = new OreBlock("ore-divinite", ADItems.divinite);
        oreCelestite = new OreBlock("ore-celestite", ADItems.celestite);
        oreMythril = new OreBlock("ore-mythril", ADItems.mythril);
        oreBlackMythril = new OreBlock("ore-black-mythril", ADItems.blackMythril);
    }
}
