package absolutedivinity.content;

import absolutedivinity.content.blocks.turrets.item.CBSTTurret;
import absolutedivinity.content.blocks.turrets.item.CylonTurret;
import absolutedivinity.content.blocks.turrets.item.HeavyTurret;
import absolutedivinity.content.blocks.turrets.item.ItemSlingerTurret;
import absolutedivinity.content.blocks.turrets.item.MissileBatteryTurret;
import absolutedivinity.content.blocks.turrets.item.MortarTurret;
import absolutedivinity.content.blocks.turrets.item.RagnitoTurret;
import absolutedivinity.content.blocks.turrets.item.RipperTurret;
import absolutedivinity.content.blocks.turrets.item.SharpelTurret;
import absolutedivinity.content.blocks.turrets.power.AbsoleTurret;
import absolutedivinity.content.blocks.turrets.power.AirArcTurret;
import absolutedivinity.content.blocks.turrets.power.CavalryTurret;
import absolutedivinity.content.blocks.turrets.power.DeracinationTurret;
import absolutedivinity.content.blocks.turrets.power.DiffractTurret;
import absolutedivinity.content.blocks.turrets.power.FragmentTurret;
import absolutedivinity.content.blocks.turrets.power.KugelblitzTurret;
import absolutedivinity.content.blocks.turrets.power.LightningChaingunTurret;

public class ADTurrets {
    
    public static void load(){
        //Item turrets
        SharpelTurret.load();
        RagnitoTurret.load();
        CylonTurret.load();
        HeavyTurret.load();
        RipperTurret.load();
        CBSTTurret.load();
        ItemSlingerTurret.load();
        MissileBatteryTurret.load();
        MortarTurret.load();

        //Power turrets
        AirArcTurret.load();
        AbsoleTurret.load();
        CavalryTurret.load();
        DeracinationTurret.load();
        DiffractTurret.load();
        FragmentTurret.load();
        KugelblitzTurret.load();
        LightningChaingunTurret.load();
    }
}
