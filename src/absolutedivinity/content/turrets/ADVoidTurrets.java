package absolutedivinity.content.turrets;

import absolutedivinity.content.blocks.turrets.void_.VoidAnnihilator;
import absolutedivinity.content.blocks.turrets.void_.VoidArc;
import absolutedivinity.content.blocks.turrets.void_.VoidDart;
import absolutedivinity.content.blocks.turrets.void_.VoidFrag;
import absolutedivinity.content.blocks.turrets.void_.VoidHowitzer;
import absolutedivinity.content.blocks.turrets.void_.VoidLance;
import absolutedivinity.content.blocks.turrets.void_.VoidLanceBattery;
import absolutedivinity.content.blocks.turrets.void_.VoidReaper;
import absolutedivinity.content.blocks.turrets.void_.VoidSingularity;
import absolutedivinity.content.blocks.turrets.void_.VoidStorm;

public class ADVoidTurrets {
    public static void load(){
        VoidDart.load();
        VoidArc.load();
        VoidReaper.load();
        VoidFrag.load();
        VoidLance.load();
        VoidHowitzer.load();
        VoidStorm.load();
        VoidLanceBattery.load();
        VoidSingularity.load();
        VoidAnnihilator.load();
    }
}
