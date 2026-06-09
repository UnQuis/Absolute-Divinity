package absolutedivinity.content.blocks.distribution;

import arc.graphics.Color;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.distribution.Conveyor;
import mindustry.world.blocks.distribution.ItemBridge;
import mindustry.world.blocks.distribution.Junction;
import mindustry.world.blocks.distribution.MassDriver;
import mindustry.world.blocks.distribution.Router;
import mindustry.world.blocks.distribution.StackConveyor;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.content.Items;
import absolutedivinity.content.ADItems;
import mindustry.entities.effect.WaveEffect;

public class ADDistribution {
    public static Conveyor entropyConduit;

    public static Junction nullNode;

    public static Router orderHub,
        gridRouter;

    public static ItemBridge nexusBridge,
        aeonBridge;

    public static MassDriver voidCaster,
        chronoCannon;

    public static StorageBlock abyssHold;

    public static StackConveyor riftStacker;

    public static void load(){{
        entropyConduit = new Conveyor("entropy-conduit"){{
            localizedName = "Entropy Conduit";
            description = "Transports items forward. Unstable yet swift.";
            details = "The fabric of order weakens with every item that passes through.";
            speed = 0.2f;
            health = 350;
            displayedSpeed = 22;
        }};

        abyssHold = new StorageBlock("abyss-hold"){{
            localizedName = "Abyss Hold";
            description = "A deep storage reservoir that warps space to contain vast quantities of supplies.";
            size = 4;
            hasItems = true;
            itemCapacity = 4000;
            health = 760;
            coreMerge = true;
            category = Category.effect;
            requirements = ItemStack.with(
              Items.titanium, 300,
              Items.thorium, 180,
              Items.plastanium, 20
            );
        }};

        riftStacker = new StackConveyor("rift-stacker"){{
            localizedName = "Rift Stacker";
            description = "Teleports items forward in compressed batches through localized rifts.";
            details = "The air around it hums with displaced potential.";
            category = Category.distribution;
            health = 110;
            speed = 0.09f;
            itemCapacity = 20;
            outputRouter = true;
            glowColor = Color.valueOf("dbaf85");
            requirements = ItemStack.with(
                Items.graphite, 1,
                Items.silicon, 1,
                ADItems.ferroamalgam, 1
            );
            loadEffect = new WaveEffect(){{
                sizeFrom = 5;
                sizeTo = 0;
                colorFrom = Color.valueOf("bf3683");
                colorTo = Color.valueOf("a3506e");
            }};
            unloadEffect = new WaveEffect(){{
                sizeFrom = 0;
                sizeTo = 5;
                colorFrom = Color.valueOf("a3506e");
                colorTo = Color.valueOf("bf3683");
            }};
        }};

        chronoCannon = new MassDriver("chrono-cannon"){{
            localizedName = "Chrono Cannon";
            description = "Long-range item transport. Warps time to accelerate payloads across vast distances.";
            range = 600f;
            reload = 120f;
            itemCapacity = 300;
            size = 4;
            health = 720;
            consumesPower = true;
            consumePower(3.333f);
            category = Category.distribution;
            requirements = ItemStack.with(
                Items.lead, 200,
                Items.silicon, 110,
                Items.titanium, 200,
                Items.phaseFabric, 50
            );
        }};

        nexusBridge = new ItemBridge("nexus-bridge"){{
            localizedName = "Nexus Bridge";
            description = "Projects a stable transfer conduit over any obstacle.";
            health = 250;
            range = 6;
            transportTime = 2f;
            hasPower = false;
            category = Category.distribution;
            requirements = ItemStack.with(
                Items.copper, 6,
                Items.lead, 6,
                Items.surgeAlloy, 4
            );
        }};

        voidCaster = new MassDriver("void-caster"){{
            localizedName = "Void Caster";
            description = "Short-range matter displacement engine. Folds space to deliver small payloads.";
            health = 60;
            itemCapacity = 20;
            reload = 10f;
            range = 88;
            size = 1;
            consumePower(0.333f);
            category = Category.distribution;
            requirements = ItemStack.with(
                Items.copper, 75,
                Items.lead, 50,
                Items.titanium, 25
            );
        }};

        aeonBridge = new ItemBridge("aeon-bridge"){{
            localizedName = "Aeon Bridge";
            description = "An enduring transfer bridge that spans gaps with reinforced phase matter.";
            health = 250;
            range = 6;
            transportTime = 4;
            hasPower = false;
            category = Category.distribution;
            requirements = ItemStack.with(
                Items.copper, 8,
                Items.lead, 8,
                Items.titanium, 8
            );
        }};

        orderHub = new Router("order-hub"){{
            localizedName = "Order Hub";
            description = "Distributes input to seven outputs with calculated precision.";
            speed = 0.1f;
            health = 220;
            itemCapacity = 20;
            size = 2;
            category = Category.distribution;
            requirements = ItemStack.with(
                Items.copper, 8,
                Items.lead, 6,
                Items.titanium, 4
            );
        }};

        nullNode = new Junction("null-node"){{
            localizedName = "Null Node";
            description = "A crossing point where two conduits intersect without interference.";
            speed = 18;
            health = 45;
            size = 1;
            category = Category.distribution;
            requirements = ItemStack.with(
                Items.copper, 6,
                Items.titanium, 4
            );
        }};

        gridRouter = new Router("grid-router"){{
            localizedName = "Grid Router";
            description = "Routes items evenly to three adjacent paths. Encoded with predictive logic.";
            speed = 0.1f;
            health = 75;
            itemCapacity = 20;
            size = 1;
            category = Category.distribution;
            requirements = ItemStack.with(
                Items.copper, 5,
                Items.titanium, 2
            );
        }};
    }};
}
