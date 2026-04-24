package absolutedivinity.content.units.t4;

import absolutedivinity.content.ADWeapons;
import mindustry.content.UnitTypes;
import mindustry.entities.abilities.SpawnDeathAbility;
import mindustry.gen.PayloadUnit;
import mindustry.type.UnitType;

public class CulisetaUnit {
    public static UnitType culiseta;

    public static void load(){
        
        culiseta = new UnitType("culiseta"){{
            constructor = PayloadUnit::create;
            localizedName = "[orange]Culiseta";
            description = "Equipped with fragging bombs, targetable missiles, railguns, and more. Manufactures assault and siege units on board to deploy upon destruction. Rotor deals damage to nearby targets.";
            flying = true;
            payloadCapacity = 256;
            engineSize = 0;
            lowAltitude = true;
            health = 16500;
            armor = 3;
            range = 270;
            speed = 1;
            hitSize = 64;
            strafePenalty = 1;
            weapons.add(ADWeapons.culisetaRotor);

            abilities.add(new SpawnDeathAbility(UnitTypes.dagger, 8, 45f));

        }};
    }
}
