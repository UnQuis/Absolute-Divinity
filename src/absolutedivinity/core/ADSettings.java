package absolutedivinity.core;

import arc.Core;
import mindustry.Vars;

public class ADSettings {

    public static int enemyHpMult(){
        return Core.settings.getInt("ad-enemy-hp-mult", 1);
    }

    public static void load(){
        Vars.ui.settings.addCategory("Absolute Divinity", t ->{
            t.checkPref("ad-enable-something", true);
            t.checkPref("ad-power-multiplier", true);
            t.sliderPref("ad-enemy-hp-mult", 1, 1, 50, i -> i + "x");
        });
    }
}
