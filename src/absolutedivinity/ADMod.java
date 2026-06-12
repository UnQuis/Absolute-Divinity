package absolutedivinity;

import absolutedivinity.content.ADStatusEffects;
import absolutedivinity.content.ADEffects;
import absolutedivinity.content.ADEnvironment;
import absolutedivinity.content.ADItems;
import absolutedivinity.content.ADLiquids;
import absolutedivinity.content.ADPlanets;
import absolutedivinity.content.ADTechTree;
import absolutedivinity.content.blocks.distribution.ADDistribution;
import absolutedivinity.content.blocks.effects.ADEffectBlocks;
import absolutedivinity.content.turrets.ADVoidTurrets;
import absolutedivinity.content.turrets.ADAbyssTurrets;
import absolutedivinity.content.turrets.ADChaosTurrets;
import absolutedivinity.content.turrets.ADTimeTurrets;
import absolutedivinity.content.turrets.ADInfoTurrets;
import absolutedivinity.content.turrets.ADOrderTurrets;
import absolutedivinity.content.ADUnits;
import absolutedivinity.content.ADWeapons;
import absolutedivinity.content.ADWeathers;
import absolutedivinity.content.blocks.ADCores;
import absolutedivinity.content.blocks.power.ADReactors;
import absolutedivinity.core.ADGameLogic;
import absolutedivinity.core.ADSettings;
import arc.Events;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.mod.Mod;

public class ADMod extends Mod {
    public void loadContent(){
        ADItems.load();
        ADEffects.load();
        ADStatusEffects.load();
        ADLiquids.load();
        ADWeapons.load();
        ADVoidTurrets.load();
        ADAbyssTurrets.load();
        ADChaosTurrets.load();
        ADTimeTurrets.load();
        ADInfoTurrets.load();
        ADOrderTurrets.load();
        ADDistribution.load();
        ADEffectBlocks.load();
        ADUnits.load();
        ADCores.load();
        ADReactors.load();
        ADEnvironment.load();
        ADWeathers.load();
        ADPlanets.load();
        ADTechTree.load();
    }

    @Override
    public void init(){
        ADGameLogic.init();

        if(!Vars.headless){
            Events.on(EventType.ClientLoadEvent.class, e -> {
                ADSettings.load();
            });
        }
    }
}
