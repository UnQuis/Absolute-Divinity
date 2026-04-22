package fadingrevelations.content;

import fadingrevelations.content.blocks.turrets.item.AccelTurret;
import fadingrevelations.content.blocks.turrets.item.CaatsTurret;
import fadingrevelations.content.blocks.turrets.item.GattlingTurret;
import fadingrevelations.content.blocks.turrets.item.HurricaneTurret;
import fadingrevelations.content.blocks.turrets.item.IgnitorTurret;

public class ADTurrets {
    
    public static void load(){
        AccelTurret.load();
        CaatsTurret.load();
        HurricaneTurret.load();
        GattlingTurret.load();
        IgnitorTurret.load();
    }
}
