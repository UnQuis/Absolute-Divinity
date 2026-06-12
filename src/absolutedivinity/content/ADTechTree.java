package absolutedivinity.content;

import absolutedivinity.content.blocks.ADCores;
import absolutedivinity.content.blocks.distribution.ADDistribution;
import absolutedivinity.content.blocks.distribution.VoidConduit;
import absolutedivinity.content.blocks.effects.ADEffectBlocks;
import absolutedivinity.content.blocks.turrets.abyss.*;
import absolutedivinity.content.blocks.turrets.chaos.*;
import absolutedivinity.content.blocks.turrets.info.*;
import absolutedivinity.content.blocks.turrets.order.*;
import absolutedivinity.content.blocks.turrets.time.*;
import absolutedivinity.content.blocks.turrets.void_.*;
import arc.struct.ObjectMap;
import mindustry.content.Blocks;
import mindustry.content.TechTree;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives.Research;
import mindustry.type.ItemStack;

public class ADTechTree {

    private static final ObjectMap<UnlockableContent, TechTree.TechNode> nodes = new ObjectMap<>();

    public static void load() {
        TechTree.TechNode root = TechTree.nodeRoot("absolute-divinity", Blocks.coreShard, true, () -> {});
        ADPlanets.elysium.techTree = root;

        nodes.put(Blocks.coreShard, root);

        // Items progression
        addItem(Blocks.coreShard, ADItems.ferriteCompound);
        addItem(ADItems.ferriteCompound, ADItems.reinforcedComposite);
        addItem(ADItems.reinforcedComposite, ADItems.matrix);
        addItem(ADItems.matrix, ADItems.restorationGel);
        addItem(ADItems.restorationGel, ADItems.guidanceCore);
        addItem(ADItems.guidanceCore, ADItems.naniteCluster);

        addItem(Blocks.coreShard, ADItems.bioAlloy);
        addItem(ADItems.bioAlloy, ADItems.hardenedBioAlloy);

        addItem(Blocks.coreShard, ADItems.ferroamalgam);
        addItem(ADItems.ferroamalgam, ADItems.cryoSteel);

        addItem(Blocks.coreShard, ADItems.celestite);
        addItem(ADItems.celestite, ADItems.mythril);
        addItem(ADItems.mythril, ADItems.blackMythril);
        addItem(ADItems.blackMythril, ADItems.divinite);

        // Liquids
        addBlock(ADItems.bioAlloy, ADLiquids.acid);
        addBlock(ADLiquids.acid, ADLiquids.livingSteelLiquid);
        addBlock(ADLiquids.livingSteelLiquid, ADLiquids.neutronFluid);
        addBlock(ADLiquids.neutronFluid, ADLiquids.steam);

        // Distribution blocks
        addItem(Blocks.coreShard, ADDistribution.gridRouter);
        addItem(ADDistribution.gridRouter, ADDistribution.nullNode);
        addItem(ADDistribution.nullNode, ADDistribution.orderHub);
        addItem(ADDistribution.orderHub, ADDistribution.entropyConduit);
        addItem(ADDistribution.entropyConduit, ADDistribution.riftStacker);
        addItem(ADDistribution.riftStacker, VoidConduit.voidConduit);

        addItem(ADDistribution.gridRouter, ADDistribution.aeonBridge);
        addItem(ADDistribution.aeonBridge, ADDistribution.nexusBridge);

        // Effect blocks
        addItem(Blocks.coreShard, ADEffectBlocks.disruptor2);
        addItem(ADEffectBlocks.disruptor2, ADEffectBlocks.disruptor3);

        // Cores
        addItem(Blocks.coreShard, ADCores.primordialCore);
        addItem(ADCores.primordialCore, ADCores.ascensionCore);

        // Void turrets
        addItem(Blocks.coreShard, VoidDart.voidDart);
        addItem(VoidDart.voidDart, VoidArc.voidArc);
        addItem(VoidArc.voidArc, VoidReaper.voidReaper);
        addItem(VoidReaper.voidReaper, VoidFrag.voidFrag);
        addItem(VoidFrag.voidFrag, VoidLance.voidLance);
        addItem(VoidLance.voidLance, VoidHowitzer.voidHowitzer);
        addItem(VoidHowitzer.voidHowitzer, VoidStorm.voidStorm);
        addItem(VoidStorm.voidStorm, VoidLanceBattery.voidLanceBattery);
        addItem(VoidLanceBattery.voidLanceBattery, VoidSingularity.voidSingularity);
        addItem(VoidSingularity.voidSingularity, VoidAnnihilator.voidAnnihilator);

        // Order turrets
        addItem(Blocks.coreShard, OrderSpark.orderSpark);
        addItem(OrderSpark.orderSpark, OrderFlak.orderFlak);
        addItem(OrderFlak.orderFlak, OrderLance.orderLance);
        addItem(OrderLance.orderLance, OrderMortar.orderMortar);
        addItem(OrderMortar.orderMortar, OrderStorm.orderStorm);
        addItem(OrderStorm.orderStorm, OrderCannon.orderCannon);
        addItem(OrderCannon.orderCannon, OrderBeam.orderBeam);
        addItem(OrderBeam.orderBeam, OrderCataclysm.orderCataclysm);
        addItem(OrderCataclysm.orderCataclysm, OrderSingularity.orderSingularity);
        addItem(OrderSingularity.orderSingularity, OrderAnnihilator.orderAnnihilator);

        // Abyss turrets
        addItem(Blocks.coreShard, AbyssTurret1.abyssTurret1);
        addItem(AbyssTurret1.abyssTurret1, AbyssTurret2.abyssTurret2);
        addItem(AbyssTurret2.abyssTurret2, AbyssTurret3.abyssTurret3);
        addItem(AbyssTurret3.abyssTurret3, AbyssTurret4.abyssTurret4);
        addItem(AbyssTurret4.abyssTurret4, AbyssTurret5.abyssTurret5);
        addItem(AbyssTurret5.abyssTurret5, AbyssTurret6.abyssTurret6);
        addItem(AbyssTurret6.abyssTurret6, AbyssTurret7.abyssTurret7);
        addItem(AbyssTurret7.abyssTurret7, AbyssTurret8.abyssTurret8);
        addItem(AbyssTurret8.abyssTurret8, AbyssTurret9.abyssTurret9);
        addItem(AbyssTurret9.abyssTurret9, AbyssAnnihilator.abyssAnnihilator);

        // Chaos turrets
        addItem(Blocks.coreShard, ChaosTurret1.chaosTurret1);
        addItem(ChaosTurret1.chaosTurret1, ChaosTurret2.chaosTurret2);
        addItem(ChaosTurret2.chaosTurret2, ChaosTurret3.chaosTurret3);
        addItem(ChaosTurret3.chaosTurret3, ChaosTurret4.chaosTurret4);
        addItem(ChaosTurret4.chaosTurret4, ChaosTurret5.chaosTurret5);
        addItem(ChaosTurret5.chaosTurret5, ChaosTurret6.chaosTurret6);
        addItem(ChaosTurret6.chaosTurret6, ChaosTurret7.chaosTurret7);
        addItem(ChaosTurret7.chaosTurret7, ChaosTurret8.chaosTurret8);
        addItem(ChaosTurret8.chaosTurret8, ChaosTurret9.chaosTurret9);
        addItem(ChaosTurret9.chaosTurret9, ChaosObliterator.chaosObliterator);

        // Time turrets
        addItem(Blocks.coreShard, TimeTurret1.timeTurret1);
        addItem(TimeTurret1.timeTurret1, TimeTurret2.timeTurret2);
        addItem(TimeTurret2.timeTurret2, TimeTurret3.timeTurret3);
        addItem(TimeTurret3.timeTurret3, TimeTurret4.timeTurret4);
        addItem(TimeTurret4.timeTurret4, TimeTurret5.timeTurret5);
        addItem(TimeTurret5.timeTurret5, TimeTurret6.timeTurret6);
        addItem(TimeTurret6.timeTurret6, TimeTurret7.timeTurret7);
        addItem(TimeTurret7.timeTurret7, TimeTurret8.timeTurret8);
        addItem(TimeTurret8.timeTurret8, TimeTurret9.timeTurret9);
        addItem(TimeTurret9.timeTurret9, ChronoObliterator.chronoObliterator);

        // Info turrets
        addItem(Blocks.coreShard, InfoTurret1.infoTurret1);
        addItem(InfoTurret1.infoTurret1, InfoTurret2.infoTurret2);
        addItem(InfoTurret2.infoTurret2, InfoTurret3.infoTurret3);
        addItem(InfoTurret3.infoTurret3, InfoTurret4.infoTurret4);
        addItem(InfoTurret4.infoTurret4, InfoTurret5.infoTurret5);
        addItem(InfoTurret5.infoTurret5, InfoTurret6.infoTurret6);
        addItem(InfoTurret6.infoTurret6, InfoTurret7.infoTurret7);
        addItem(InfoTurret7.infoTurret7, InfoTurret8.infoTurret8);
        addItem(InfoTurret8.infoTurret8, InfoTurret9.infoTurret9);
        addItem(InfoTurret9.infoTurret9, InfoAnnihilator.infoAnnihilator);
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
