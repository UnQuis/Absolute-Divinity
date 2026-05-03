package absolutedivinity;

import absolutedivinity.content.ADEffects;
import absolutedivinity.content.ADEnvironment;
import absolutedivinity.content.ADItems;
import absolutedivinity.content.ADLiquids;
import absolutedivinity.content.ADPlanets;
import absolutedivinity.content.ADTechTree;
import absolutedivinity.content.turrets.ADItemTurrets;
import absolutedivinity.content.turrets.ADPowerTurrets;
import absolutedivinity.content.turrets.ADSpecialTurrets;
import absolutedivinity.content.ADUnits;
import absolutedivinity.content.ADWeapons;
import absolutedivinity.content.ADWeathers;
import absolutedivinity.content.blocks.ADCores;
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
        ADLiquids.load();
        ADWeapons.load();
        ADItemTurrets.load();
        ADPowerTurrets.load();
        ADSpecialTurrets.load();
        ADUnits.load();
        ADCores.load();
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
