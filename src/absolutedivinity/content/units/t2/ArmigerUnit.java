package fadingrevelations.content.units.t2;

import fadingrevelations.content.FRWeapons;
import mindustry.gen.PayloadUnit;
import mindustry.type.UnitType;

public class ArmigerUnit {
    public static UnitType armiger;

    public static void load(){{
        armiger = new UnitType("armiger"){{
            constructor = PayloadUnit::create;
            localizedName = "[orange]Armiger";
            description = "Equipped with rocket launchers and a minigun. Rotor deals decent damage to nearby targets.";
            flying = true;
            lowAltitude = true;
            engineSize = 0;
            payloadCapacity = 16;
            health = 525;
            armor = 6;
            hitSize = 12;
            range = 180;
            speed = 1;
            strafePenalty = 1;
            weapons.add(FRWeapons.culisetaRotor);
        }};
    }}
}
