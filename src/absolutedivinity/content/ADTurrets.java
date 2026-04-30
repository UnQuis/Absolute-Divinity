package absolutedivinity.content;

import absolutedivinity.content.blocks.turrets.StationaryPolyTurret;
import absolutedivinity.content.blocks.turrets.item.*;
import absolutedivinity.content.blocks.turrets.power.AbsoleTurret;
import absolutedivinity.content.blocks.turrets.power.AirArcTurret;
import absolutedivinity.content.blocks.turrets.power.CavalryTurret;
import absolutedivinity.content.blocks.turrets.power.DeracinationTurret;
import absolutedivinity.content.blocks.turrets.power.DiffractTurret;
import absolutedivinity.content.blocks.turrets.power.ForkTurret;
import absolutedivinity.content.blocks.turrets.power.FragmentTurret;
import absolutedivinity.content.blocks.turrets.power.KugelblitzTurret;
import absolutedivinity.content.blocks.turrets.power.LightningChaingunTurret;
import absolutedivinity.content.blocks.turrets.power.OblivionTurret;
import absolutedivinity.content.blocks.turrets.power.StasisFieldTurret;
import absolutedivinity.content.blocks.turrets.item.UniversalTurret;

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
        BigScorchTurret.load();
        InfernoTurret.load();

        //Power turrets
        AirArcTurret.load();
        AbsoleTurret.load();
        CavalryTurret.load();
        DeracinationTurret.load();
        DiffractTurret.load();
        FragmentTurret.load();
        KugelblitzTurret.load();
        LightningChaingunTurret.load();
        ForkTurret.load();
        OblivionTurret.load();
        StasisFieldTurret.load();

        //IDK
        StationaryPolyTurret.load();
        UniversalTurret.load();
    }
}
