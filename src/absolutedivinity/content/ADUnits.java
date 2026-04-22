package  fadingrevelations.content;

import fadingrevelations.content.units.mothership.CulisetaUnit;
import fadingrevelations.content.units.t1.AedesUnit;
import fadingrevelations.content.units.t2.ArmigerUnit;
import fadingrevelations.content.units.t3.OnirionUnit;

public class ADUnits {

    public static void load(){
        CulisetaUnit.load();
        OnirionUnit.load();
        AedesUnit.load();
        ArmigerUnit.load();
    }
}
