package  absolutedivinity.content;

import absolutedivinity.content.units.t1.AedesUnit;
import absolutedivinity.content.units.t2.ArmigerUnit;
import absolutedivinity.content.units.t3.OnirionUnit;
import absolutedivinity.content.units.t4.CulisetaUnit;

public class ADUnits {

    public static void load(){
        CulisetaUnit.load();
        OnirionUnit.load();
        AedesUnit.load();
        ArmigerUnit.load();
    }
}
