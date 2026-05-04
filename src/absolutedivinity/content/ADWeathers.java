package absolutedivinity.content;

import arc.graphics.Color;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.type.weather.ParticleWeather;
import mindustry.type.weather.RainWeather;
import mindustry.world.meta.Attribute;

public class ADWeathers {
    public static ParticleWeather 
    hail,
    hailstorm;
    public static RainWeather 
    heavyRainstorm,
    slackRain,
    acidRain;

    public static void load() {
        acidRain = new RainWeather("acid-rain"){{
            localizedName = "Acid Rain";
            status = ADStatusEffects.acidicBurn;
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

        hail = new ParticleWeather("hail") {{
            localizedName = "Hail";
            particleRegion = "particle";
            sizeMin = 2f;
            sizeMax = 8f;
            density = 600;
            status = StatusEffects.freezing;
            //sound = Sounds.wind;
            soundVol = 0f;
            soundVolOscMag = 1.6f;
            soundVolOscScl = 1100f;
            soundVolMin = 0.08f;
            attrs.set(Attribute.light, -0.15f);
            attrs.set(Attribute.heat, -0.3f);
        }};

        hailstorm = new ParticleWeather("hailstorm") {{
            localizedName = "Hailstorm";
            particleRegion = "particle";
            sizeMin = 3f;
            sizeMax = 15f;
            density = 1200;
            status = StatusEffects.freezing;
            //sound = Sounds.wind;
            soundVol = 0f;
            soundVolOscMag = 1.6f;
            soundVolOscScl = 1100f;
            soundVolMin = 0.08f;
            attrs.set(Attribute.light, -0.25f);
            attrs.set(Attribute.heat, -0.4f);
        }};

        heavyRainstorm = new RainWeather("heavy-rainstorm") {{
            localizedName = "Heavy Rainstorm";
            status = StatusEffects.wet;
            //sound = Sounds.rain;
            soundVol = 0.7f;
            density = 400;
            stroke = 1.2f;
            liquid = Liquids.water;
            color = Color.valueOf("7a95eaff");
            attrs.set(Attribute.water, 0.4f);
            attrs.set(Attribute.light, -0.35f);
        }};

        slackRain = new RainWeather("slack-rain") {{
            localizedName = "Slack Rain";
            status = StatusEffects.burning;
            //sound = Sounds.rain;
            soundVol = 0.5f;
            density = 1200;
            stroke = 0.62f;
            liquid = Liquids.slag;
            color = Color.valueOf("ffcd66ff");
            statusGround = true;
            statusAir = false;
            attrs.set(Attribute.water, -0.5f);
            attrs.set(Attribute.light, -0.2f);
            attrs.set(Attribute.heat, 0.5f);
        }};
    }
}
