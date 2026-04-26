package  absolutedivinity.content;

import absolutedivinity.content.units.idk.EradicatorPrimeUnit;
import absolutedivinity.content.units.idk.LifedrinkerUnit;
import absolutedivinity.content.units.idk.MagmaStalkerUnit;
import absolutedivinity.content.units.idk.SerpentineColossusUnit;
import absolutedivinity.content.units.idk.SlagspitterUnit;
import absolutedivinity.content.units.idk.UmbralReaperUnit;
import absolutedivinity.content.units.t1.AedesUnit;
import absolutedivinity.content.units.t1.BeamWaspUnit;
import absolutedivinity.content.units.t1.BuilderSpriteUnit;
import absolutedivinity.content.units.t1.BulwarkUnit;
import absolutedivinity.content.units.t1.NereidUnit;
import absolutedivinity.content.units.t1.PyroclasmUnit;
import absolutedivinity.content.units.t1.ScuttleboatUnit;
import absolutedivinity.content.units.t1.StingerUnit;
import absolutedivinity.content.units.t2.ArmigerUnit;
import absolutedivinity.content.units.t3.OnirionUnit;
import absolutedivinity.content.units.t4.CulisetaUnit;

public class ADUnits {

    public static void load(){

        //t1
        AedesUnit.load();
        BeamWaspUnit.load();
        BuilderSpriteUnit.load();
        BulwarkUnit.load();
        NereidUnit.load();
        PyroclasmUnit.load();
        ScuttleboatUnit.load();
        StingerUnit.load();

        //t2
        ArmigerUnit.load();

        //t3
        OnirionUnit.load();

        //t4
        CulisetaUnit.load();

        //idk
        EradicatorPrimeUnit.load();
        LifedrinkerUnit.load();
        MagmaStalkerUnit.load();
        SerpentineColossusUnit.load();
        SlagspitterUnit.load();
        UmbralReaperUnit.load();
    }
}
