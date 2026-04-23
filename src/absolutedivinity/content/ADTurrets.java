package absolutedivinity.content;

import absolutedivinity.content.blocks.turrets.item.CylonTurret;
import absolutedivinity.content.blocks.turrets.item.HeavyTurret;
import absolutedivinity.content.blocks.turrets.item.RagnitoTurret;
import absolutedivinity.content.blocks.turrets.item.RipperTurret;
import absolutedivinity.content.blocks.turrets.item.SharpelTurret;

public class ADTurrets {
    
    public static void load(){
        SharpelTurret.load();
        RagnitoTurret.load();
        CylonTurret.load();
        HeavyTurret.load();
        RipperTurret.load();
    }
}
