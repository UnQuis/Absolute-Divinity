package  fadingrevelations.content.units.t1;

import fadingrevelations.content.FRWeapons;
import mindustry.gen.PayloadUnit;
import mindustry.type.UnitType;

public class AedesUnit{
    public static UnitType aedes;

    public static void load(){
        aedes = new UnitType("aedes"){{
            constructor = PayloadUnit::create;
            localizedName = "[orange]Aedes";
            description = "Shoots swerving bullets at nearby targets. Rotors deal damage.";
            flying = true;
            lowAltitude = true;
            payloadCapacity = 8;
            health = 55;
            hitSize = 9;
            range = 135;
            speed = 1;
            strafePenalty = 1;
            weapons.add(FRWeapons.culisetaRotor);
        }};
    }
}
