package fadingrevelations.content.units.t3;

import fadingrevelations.content.FRWeapons;
import mindustry.gen.PayloadUnit;
import mindustry.type.UnitType;

public class OnirionUnit {
    public static UnitType onirion;

    public static void load(){
        onirion = new UnitType("onirion"){{
            constructor = PayloadUnit::create;
            localizedName = "Onirion";
            description = "Equipped with a torpedo cannon, dual missile launchers, and swerving machine guns. Additionally, drops bombs on targets underneath it. Rotors deal large damage to nearby targets.";
            payloadCapacity = 64;
            flying = true;
            engineSize = 0;
            lowAltitude = true;
            health = 5400;
            armor = 6;
            hitSize = 23;
            range = 240;
            speed = 1;
            strafePenalty = 1;
            weapons.add(FRWeapons.largeOrb);
        }};
    }

}
