package absolutedivinity.content;

import arc.graphics.Color;
import mindustry.content.Blocks;
import mindustry.content.Planets;
import mindustry.type.Planet;

public class ADPlanets {

    public static Planet
        canguris;

    public static void load() {
        canguris = new Planet("canguris", Planets.sun, 1.2f, 3) {{
            localizedName = "Canguris";
            description = "A lush planet that has land and water.";
            accessible = false;
            alwaysUnlocked = true;
            visible = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
            drawOrbit = true;
            updateLighting = false;
            bloom = false;
            hasAtmosphere = true;
            clearSectorOnLose = true;
            allowWaves = true;
            prebuildBase = false;
            allowLaunchToNumbered = false;

            defaultCore = Blocks.coreShard;
            parent = Planets.sun;
            solarSystem = Planets.sun.solarSystem;

            startSector = 0;
            orbitSpacing = 4;
            radius = 1.2f;
            minZoom = 1.5f;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.3f;
            orbitRadius = 24;
            sectorSeed = 69420;
            atmosphereColor = Color.valueOf("5992af");
            iconColor = Color.valueOf("4b64a9");

            generator = new ADPlanetGenerator(){{
            }};
        }};
    }
}
