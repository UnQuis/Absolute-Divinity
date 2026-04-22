package absolutedivinity.content;

import absolutedivinity.content.blocks.turrets.item.AccelTurret;
import absolutedivinity.content.blocks.turrets.item.CaatsTurret;
import absolutedivinity.content.blocks.turrets.item.GattlingTurret;
import absolutedivinity.content.blocks.turrets.item.HurricaneTurret;
import absolutedivinity.content.blocks.turrets.item.IgnitorTurret;

public class ADTurrets {
    
    public static void load(){
        AccelTurret.load();
        CaatsTurret.load();
        HurricaneTurret.load();
        GattlingTurret.load();
        IgnitorTurret.load();
    }
}
