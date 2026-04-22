package absolutedivinity.content;

import arc.struct.ObjectMap;
import absolutedivinity.content.blocks.turrets.item.AccelTurret;
import absolutedivinity.content.blocks.turrets.item.CaatsTurret;
import absolutedivinity.content.blocks.turrets.item.GattlingTurret;
import absolutedivinity.content.blocks.turrets.item.HurricaneTurret;
import absolutedivinity.content.blocks.turrets.item.IgnitorTurret;
import mindustry.content.Blocks;
import mindustry.content.TechTree;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives.Research;
import mindustry.type.ItemStack;

public class ADTechTree {

    private static final ObjectMap<UnlockableContent, TechTree.TechNode> nodes = new ObjectMap<>();

    public static void load() {
        TechTree.TechNode root = TechTree.nodeRoot("canguris", Blocks.coreShard, true, () -> {});
        FRPlanets.canguris.techTree = root;
        
        nodes.put(Blocks.coreShard, root);

        
        addItem(Blocks.coreShard, FRItems.ammoLevel1);
        addItem(FRItems.ammoLevel1, FRItems.ammoLevel2);
        addItem(FRItems.ammoLevel2, FRItems.ammoLevel3);
        
        addItem(Blocks.coreShard, FRItems.steelAmalgam);

        addBlock(Blocks.coreShard, AccelTurret.accel, Blocks.salvo); 
        
        addBlock(AccelTurret.accel, CaatsTurret.caats);
        addBlock(AccelTurret.accel, HurricaneTurret.hurricane);
        addBlock(AccelTurret.accel, GattlingTurret.gattling);
        addBlock(CaatsTurret.caats, IgnitorTurret.ignitor);
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
