package absolutedivinity.content;

import absolutedivinity.content.blocks.turrets.item.CylonTurret;
import absolutedivinity.content.blocks.turrets.item.HeavyTurret;
import absolutedivinity.content.blocks.turrets.item.RagnitoTurret;
import absolutedivinity.content.blocks.turrets.item.RipperTurret;
import absolutedivinity.content.blocks.turrets.item.SharpelTurret;
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

        
        addItem(Blocks.coreShard, ADItems.ammoLevel1);
        addItem(ADItems.ammoLevel1, ADItems.ammoLevel2);
        addItem(ADItems.ammoLevel2, ADItems.ammoLevel3);
        
        addItem(Blocks.coreShard, ADItems.steelAmalgam);

        addBlock(Blocks.coreShard, SharpelTurret.sharpel, Blocks.salvo); 
        
        addBlock(SharpelTurret.sharpel, RagnitoTurret.ragnito);
        addBlock(SharpelTurret.sharpel, CylonTurret.cylon);
        addBlock(SharpelTurret.sharpel, HeavyTurret.HEAVY);
        addBlock(RagnitoTurret.ragnito, RipperTurret.ripper);
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
