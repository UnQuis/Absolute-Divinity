package absolutedivinity.content.blocks.distribution;

import absolutedivinity.content.ADItems;
import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.entities.effect.WaveEffect;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.distribution.Conveyor;
import mindustry.world.blocks.distribution.ItemBridge;
import mindustry.world.blocks.distribution.Junction;
import mindustry.world.blocks.distribution.MassDriver;
import mindustry.world.blocks.distribution.Router;
import mindustry.world.blocks.distribution.StackConveyor;
import mindustry.world.blocks.storage.StorageBlock;

public class ADDistribution {
    public static Conveyor 
        sAConveyor;

    public static Junction
        tJunction;

    public static Router
        tDistributor,
        tRouter;

    public static ItemBridge
        tBridge,
        sABridge;

    public static MassDriver
        tinyMD,
        mAccelerator;

    public static StorageBlock
        depository;

    public static StackConveyor
        aMConveyor;

    public static void load(){{
        sAConveyor = new Conveyor("surge-alloy-conveyor"){{
            description = "Transports items forward. Faster than a titanium conveyor.";
            details = "You hear a faint Speeeeeeedwagggoooooooon in the distance.";
            localizedName = "Surge Alloy Conveyor";
            speed = 0.2f;
            health = 350;
            displayedSpeed = 22;
        }};

        depository = new StorageBlock("depository"){{
            localizedName = "Depository";
            description = "Stores a gigantic amount of items of each type, akin to a vault. Expands storage when placed next to a core. Contents can be retrieved with an unloader.";
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

        aMConveyor = new StackConveyor("amalgam-conveyor"){{
            localizedName = "Amalgam Conveyor";
            description = "Quickly transports items forward in larger batches, akin to the plastanium conveyor. Identical functionality.";
            details = "Something's wrong with my copy of Factorio...";
            category = Category.distribution;
            health = 110;
            speed = 0.09f;
            itemCapacity = 20;
            outputRouter = true;
            glowColor = Color.valueOf("dbaf85");
            requirements = ItemStack.with(
                Items.graphite, 1,
                Items.silicon, 1,
                ADItems.steelAmalgam, 1  
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

        mAccelerator = new MassDriver("mass-accelerator"){{
            localizedName = "Mass Accelerator";
            description = "Long-range item transport structure. Collects large batches of items and shoots them to other mass accelerators.";
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

        sABridge = new ItemBridge("surge-bridge-conveyor"){{
            localizedName = "Alloy Bridge Conveyor";
            description = "Transports items over terrain or buildings. Faster than the titanium bridge conveyor.";
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

        tinyMD = new MassDriver("tiny-md"){{
            localizedName = "Tiny Mass Driver";
            description = "Short range item transport structure. Collects small batches of items and shoots them to other tiny mass drivers.";
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

        tBridge = new ItemBridge("titanium-bridge-conveyor"){{
            localizedName = "Titanium Bridge Conveyor";
            description = "Transports items over terrain or buildings. Faster than the regular bridge conveyor.";
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

        tDistributor = new Router("titanium-distributor"){{
            localizedName = "Titanium Distributor";
            description = "Distributes input items to 7 output directions equally. Faster than the regular distributor.";
            speed = 0.1f;
            //dumpTime = 1;
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

        tJunction = new Junction("titanium-junction"){{
            localizedName = "Titanium Junction";
            description = "Acts as a bridge for two crossing titanium conveyor belts.";
            speed = 18;
            health = 45;
            size = 1;
            category = Category.distribution;
            requirements = ItemStack.with(
                Items.copper, 6,
                Items.titanium, 4  
            );
        }};

        tRouter = new Router("titanium-router"){{
            localizedName = "Titanium Router";
            description = "Distributes items to 3 output directions equally. Faster than the regular router.";
            //dumpTime = 1;
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
