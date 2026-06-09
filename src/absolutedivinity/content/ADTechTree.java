package absolutedivinity.content;

import arc.struct.ObjectMap;
import mindustry.content.Blocks;
import mindustry.content.TechTree;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives.Research;
import mindustry.type.ItemStack;

public class ADTechTree {

    private static final ObjectMap<UnlockableContent, TechTree.TechNode> nodes = new ObjectMap<>();

    public static void load() {
        TechTree.TechNode root = TechTree.nodeRoot("canguris", Blocks.coreShard, true, () -> {});
        ADPlanets.elysium.techTree = root;
        
        nodes.put(Blocks.coreShard, root);

        
        addItem(Blocks.coreShard, ADItems.ferriteCompound);
        addItem(ADItems.ferriteCompound, ADItems.reinforcedComposite);
        addItem(ADItems.reinforcedComposite, ADItems.matrix);
        
        addItem(Blocks.coreShard, ADItems.ferroamalgam);
    }

    private static void addBlock(UnlockableContent parent, UnlockableContent child, UnlockableContent... requirements) {
        TechTree.TechNode parentNode = nodes.get(parent);
        if (parentNode == null) return;

        TechTree.TechNode node = new TechTree.TechNode(parentNode, child, child.researchRequirements());
        nodes.put(child, node); 

        node.objectives.add(new Research(parent));
        for (UnlockableContent req : requirements) {
            node.objectives.add(new Research(req));
        }
    }

    private static void addItem(UnlockableContent parent, UnlockableContent child) {
        TechTree.TechNode parentNode = nodes.get(parent);
        if (parentNode == null) return;

        TechTree.TechNode node = new TechTree.TechNode(parentNode, child, ItemStack.empty);
        nodes.put(child, node);

        node.objectives.add(new Research(parent));
    }
}
