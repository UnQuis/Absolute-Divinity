package absolutedivinity.content.blocks.distribution;

import arc.graphics.Color;
import arc.math.Mathf;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.gen.Building;
import mindustry.type.Category;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock.CoreBuild;
import absolutedivinity.content.ADItems;

public class VoidConduit extends Block {
    public Color effectColor = Color.valueOf("a8b8ff");

    public VoidConduit(String name) {
        super(name);
        update = true;
        solid = true;
        hasItems = true;
        itemCapacity = 5;
    }

    public static VoidConduit voidConduit;

    public static void registerBlock() {
        voidConduit = new VoidConduit("void-conduit") {{
            localizedName = "Void Conduit";
            description = "Instantly transfers all incoming items directly to the core.";
            health = 1200;
            size = 3;
            requirements(Category.effect, ItemStack.with(
                Items.copper, 3000,
                Items.lead, 2500,
                Items.silicon, 2200,
                Items.titanium, 2000,
                ADItems.matrix, 1000,
                ADItems.celestite, 600,
                ADItems.ferroamalgam, 500
            ));
        }};
    }

    public class VoidConduitBuild extends Building {

        @Override
        public boolean acceptItem(Building source, Item item) {
            CoreBuild core = team.core();
            return core != null && core.items.get(item) < core.storageCapacity;
        }

        @Override
        public void handleItem(Building source, Item item) {
            CoreBuild core = team.core();
            if (core != null) {
                if (core.items.get(item) >= core.storageCapacity) {
                    Fx.none.at(x, y, 0, item.color);
                    return;
                }
                core.handleItem(this, item);
                if (Mathf.chanceDelta(0.15f)) {
                    Fx.absorb.at(x, y, 0f, item.color);
                    Fx.pointBeam.at(x, y, 0f, item.color, core);
                }
            } else {
                super.handleItem(source, item);
            }
        }

        @Override
        public int removeStack(Item item, int amount) {
            CoreBuild core = team.core();
            if (core != null) {
                int result = core.removeStack(item, amount);
                if (result > 0 && Vars.state.isCampaign() && team == Vars.state.rules.defaultTeam) {
                    Vars.state.rules.sector.info.handleCoreItem(item, -result);
                }
                return result;
            }
            return 0;
        }

        @Override
        public void itemTaken(Item item) {
            CoreBuild core = team.core();
            if (core != null) core.itemTaken(item);
        }

        @Override
        public int getMaximumAccepted(Item item) {
            CoreBuild core = team.core();
            return core != null ? core.storageCapacity : 0;
        }
    }
}
