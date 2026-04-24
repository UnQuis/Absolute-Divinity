package absolutedivinity.content.weathers;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import mindustry.content.Liquids;
import mindustry.type.weather.RainWeather;
import mindustry.world.meta.Attribute;

public class AcidRain {
    public static RainWeather acidRain;

    public static void load(){
        acidRain = new RainWeather("acid-rain"){{
            localizedName = "Acid Rain";
            status = ADEffects.acidicBurn;
            //sound = Sounds.rain;
            soundVol = 0.5f;
            density = 1200;
            stroke = 0.62f;
            liquid = Liquids.slag;
            color = Color.valueOf("cd03ff");
            statusGround = true;
            statusAir = false;
            attrs.set(Attribute.light, -0.2f);
        }};
    }
}
