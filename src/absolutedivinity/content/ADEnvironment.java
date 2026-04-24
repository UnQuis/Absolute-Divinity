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
            localizedName = "Charred Tree";
            description = "A tree that has endured high heat and lots of fire. The wood is charred.";
        }};

        gnarledTree = new TreeBlock("gnarled-tree") {{
            localizedName = "Gnarled Tree";
            description = "A gnarly tree that has lost all of its leafs but the wood is still standing.";
        }};

        livingSteelWall = new StaticWall("living-steel-wall") {{
            localizedName = "Living Steel Wall";
            attributes.set(Attribute.spores, 0.3f);
        }};

        petrifiedSteelWall = new StaticWall("petrified-steel-wall") {{
            localizedName = "Petrified Steel Wall";
            attributes.set(Attribute.spores, 0.3f);
        }};

        steelSedimentation = new OreBlock("steel-sedimentation") {{
            localizedName = "Steel Sedimentation";
            description = "A sedimentation of living steel. Can be mined but beware as it damages units walking over it and slows them.";
            itemDrop = ADItems.livingSteel;
            mapColor = Color.valueOf("8c0291");
            variants = 6;
        }};

        acid = new Floor("acid") {{
            localizedName = "Acid";
            description = "A puddle of acid liquid. Beware!";
            status = ADEffects.acidicBurn;
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
            localizedName = "Deep Acid";
            description = "A puddle of acid liquid. Beware!";
            status = ADEffects.acidicBurn;
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
