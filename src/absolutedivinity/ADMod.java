package absolutedivinity;

import absolutedivinity.content.ADEffects;
import absolutedivinity.content.ADItems;
import absolutedivinity.content.ADLiquids;
import absolutedivinity.content.ADPlanets;
import absolutedivinity.content.ADTechTree;
import absolutedivinity.content.ADTurrets;
import absolutedivinity.content.ADUnits;
import absolutedivinity.content.ADWeapons;
import absolutedivinity.content.ADWeathers;
import mindustry.mod.Mod;

public class ADMod extends Mod {
    public void loadContent(){
        ADItems.load();
        ADEffects.load();
        ADLiquids.load();
        ADWeapons.load();
        ADTurrets.load();
        ADUnits.load();
        ADWeathers.load();
        ADPlanets.load();
        ADTechTree.load();
    }
}
