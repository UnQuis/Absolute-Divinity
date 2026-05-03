package absolutedivinity.content.turrets;

import absolutedivinity.content.blocks.turrets.StationaryPolyTurret;
import absolutedivinity.content.blocks.turrets.power.*;

public class ADPowerTurrets {

    public static void load(){

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
    }
}
