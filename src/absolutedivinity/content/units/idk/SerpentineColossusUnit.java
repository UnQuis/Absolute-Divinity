package absolutedivinity.content.units.idk;

import mindustry.gen.CrawlUnit;
import mindustry.type.UnitType;

public class SerpentineColossusUnit {
    public static UnitType serpentineColossus;

    public static void load() {
        serpentineColossus = new UnitType("serpentine-colossus") {{
            constructor = CrawlUnit::create;
            localizedName = "Serpentine Colossus";
            description = "A massive, segmented construct that rolls over enemy structures, crushing them with relentless force.";
            health = 12000;
            armor = 12;
            drawCell = false;
            hitSize = 120;
            squareShape = false;
            segments = 8;
            omniMovement = false;
            rotateSpeed = 0.78f;
            drownTimeMultiplier = 8f;
            drawBody = false;
            hidden = false;
            crushDamage = 2f;
            targetAir = false;
            segmentScl = 4f;
            segmentPhase = 5f;
            speed = 1f;
            weapons.clear();
        }};
    }
}
