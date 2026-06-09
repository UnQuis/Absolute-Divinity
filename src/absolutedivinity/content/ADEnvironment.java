package absolutedivinity.content;

import arc.graphics.Color;
import mindustry.graphics.CacheLayer;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.blocks.environment.TreeBlock;
import mindustry.world.meta.Attribute;

public class ADEnvironment {

    public static TreeBlock 
    charredTree,
    gnarledTree;

    public static StaticWall 
    livingSteelWall,
    petrifiedSteelWall;

    public static OreBlock steelSedimentation;

    public static Floor 
    acid,
    deepAcid;

    public static void load() {
        charredTree = new TreeBlock("charred-tree") {{
            localizedName = "Scorched Remnant";
            description = "A husk of what was once alive, petrified by heat and time.";
        }};

        gnarledTree = new TreeBlock("gnarled-tree") {{
            localizedName = "Twisted Relic";
            description = "Ancient wood contorted by centuries of exposure. Bare but unyielding.";
        }};

        livingSteelWall = new StaticWall("living-steel-wall") {{
            localizedName = "Living Alloy Wall";
            attributes.set(Attribute.spores, 0.3f);
        }};

        petrifiedSteelWall = new StaticWall("petrified-steel-wall") {{
            localizedName = "Fossilized Alloy Wall";
            attributes.set(Attribute.spores, 0.3f);
        }};

        steelSedimentation = new OreBlock("steel-sedimentation") {{
            localizedName = "Alloy Sediment";
            description = "Crystallized metallic residue. Dangerous to traverse but rich in rare compounds.";
            itemDrop = ADItems.bioAlloy;
            mapColor = Color.valueOf("8c0291");
            variants = 6;
        }};

        acid = new Floor("acid") {{
            localizedName = "Caustic Pool";
            description = "A pool of corrosive liquid. Exposure is lethal.";
            status = ADStatusEffects.corrosiveMeltdown;
            statusDuration = 300f;
            speedMultiplier = 0.7f;
            variants = 0;
            liquidDrop = ADLiquids.acid;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            attributes.set(Attribute.water, -1f);
            emitLight = true;
            lightRadius = 5f;
            lightColor = Color.valueOf("9ed17161");
            albedo = 0.9f;
            supportsOverlay = true;
        }};

        deepAcid = new Floor("deep-acid") {{
            localizedName = "Deep Caustic Pool";
            description = "A deep reservoir of acid. Impassable to ground units.";
            status = ADStatusEffects.corrosiveMeltdown;
            statusDuration = 300f;
            speedMultiplier = 0.4f;
            variants = 0;
            liquidDrop = ADLiquids.acid;
            liquidMultiplier = 1.3f;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            attributes.set(Attribute.water, -1f);
            emitLight = true;
            lightRadius = 5f;
            lightColor = Color.valueOf("9ed17161");
            albedo = 0.9f;
            shallow = false;
            supportsOverlay = true;
            placeableOn = false;
        }};
    }
}
