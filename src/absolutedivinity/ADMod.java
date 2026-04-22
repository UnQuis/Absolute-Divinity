package absolutedivinity;

import absolutedivinity.content.ADItems;
import mindustry.mod.Mod;

public class ADMod extends Mod {
    public void loadContent(){
        ADItems.load();
    }
}
