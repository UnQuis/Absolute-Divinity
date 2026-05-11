package absolutedivinity.content;

import arc.graphics.Color;
import arc.util.Time;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Planets;
import mindustry.game.Rules;
import mindustry.game.Team;
import mindustry.graphics.Pal;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.graphics.g3d.NoiseMesh;
import mindustry.maps.planet.SerpuloPlanetGenerator;
import mindustry.type.ItemStack;
import mindustry.type.Planet;
import absolutedivinity.core.map.DysonRingMesh;
import absolutedivinity.core.map.ADPlanetGenerator;

public class ADPlanets {
    public static Planet
        elysium,
        nyx,
        thanatos,
        verdict;

    public static void load() {
        elysium = new Planet("elysium", Planets.sun, 1.2f, 3){{
            localizedName = "Elysium";
            visible = true;
            accessible = true;
            alwaysUnlocked = true;
            iconColor = Color.valueOf("4b64a9");
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

            //landColor = ADColor.deepRed.cpy().lerp(ADColor.ichor, 0.75f).mul(1.05f);
            //waterColor = Color.valueOf("2a1e1e");

            landCloudColor = atmosphereColor = Color.valueOf("3a1e1e");

            meshLoader = () -> new HexMesh(this, 6);

            /*meshLoader = () -> new ADModMesh(
                    this, 6, 5,
                ADColor.deepRed.cpy().lerp(ADColor.ichor, 0.75f).mul(1.05f).lerp(Color.black, 0.2f),
                ADColor.deepRed.cpy().lerp(ADColor.ichor, 0.75f).mul(1.05f).lerp(Color.black, 0.2f),
                ADColor.deepRed.cpy().lerp(ADColor.ichor, 0.75f).mul(1.05f).lerp(Color.black, 0.2f),
                ADColor.deepRed.cpy().lerp(ADColor.ichor, 0.75f),
                ADColor.deepRed.cpy().lerp(ADColor.ichor, 0.75f).lerp(Color.white, 0.2f),

                ADModMesh.shade(Color.black, 0.3f),
                ADModMesh.shade(Color.black, 0.2f),
                ADModMesh.shade(Color.black, 0.1f),
                ADModMesh.shade(Color.black, 0.1f),
                ADModMesh.shade(Color.black, 0.2f),

                ADModMesh.shade(Color.white, 0.4f),
                ADModMesh.shade(Color.white, 0.3f),
                ADModMesh.shade(Color.white, 0.2f)
            );*/

            ruleSetter = r -> {
                r.waves = true;
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.waveSpacing = 60 * Time.toSeconds;
                r.initialWaveSpacing = 5f * Time.toMinutes;
                r.hideBannedBlocks = true;
                // r.spawns = NHPostProcess.generate(0.8f, false);
                r.loadout = ItemStack.list(Items.titanium, 1000, Items.tungsten, 1000, Items.silicon, 1000, ADItems.mythril, 1000);

                Rules.TeamRule teamRule = r.teams.get(r.defaultTeam);
                teamRule.rtsAi = true;
                teamRule.unitBuildSpeedMultiplier = 5f;
                teamRule.buildSpeedMultiplier = 1.5f;
            };

            generator = new ADPlanetGenerator(){{
                //waterColor = Color.valueOf("5992af");
                //landColor = Color.valueOf("4b64a9");
            }};

            cloudMeshLoader = () -> new MultiMesh(
                //new DysonSphereMesh(this, 0.35f),
                new DysonRingMesh(this, 2.300f, 0.28f, 729, Pal.darkMetal, Pal.darkerMetal),
                new DysonRingMesh(this, 2.500f, 0.28f, 2941, Pal.darkMetal, Pal.darkerMetal),
                new DysonRingMesh(this, 2.700f, 0.28f, 3834, Pal.darkMetal, Pal.darkerMetal),
                new DysonRingMesh(this, 2.900f, 0.37f, 4543, Pal.darkMetal, Pal.darkerMetal),
                new DysonRingMesh(this, 2.305f, 0.19f, 729, ADColor.crimsonRed, ADColor.crimsonRed),
                new DysonRingMesh(this, 2.505f, 0.19f, 2941, ADColor.crimsonRed, ADColor.crimsonRed),
                new DysonRingMesh(this, 2.705f, 0.19f, 3834, ADColor.crimsonRed, ADColor.crimsonRed),
                new DysonRingMesh(this, 2.905f, 0.19f, 4543, ADColor.crimsonRed, ADColor.crimsonRed)
            );

            iconColor = ADColor.crimsonRed;
            landCloudColor = atmosphereColor = Color.valueOf("5992af");
            atmosphereRadIn = 0.12f;
            atmosphereRadOut = 0.45f;
        }};

        verdict = new Planet("verdict", Planets.sun, 1.8f, 3){{
            accessible = true;
            alwaysUnlocked = true;
            visible = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
            drawOrbit = true;
            updateLighting = true;
            bloom = false;
            hasAtmosphere = true;
            clearSectorOnLose = false;
            allowWaves = true;
            prebuildBase = false;
            allowLaunchToNumbered = true;

            meshLoader = () -> new HexMesh(this, 7);

            solarSystem = Planets.sun;
            defaultCore = Blocks.coreNucleus;

            startSector = 0;
            orbitSpacing = 3;
            minZoom = 1.3f;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.6f;
            orbitRadius = 26;
            sectorSeed = 33456;
            atmosphereColor = Color.valueOf("baddf7");
            iconColor = Color.valueOf("798994");

            generator = new ADPlanetGenerator();

        }};

        thanatos = new Planet("thanatos", Planets.sun, 1.56f, 3) {{
            localizedName = "Thanatos";
            description = "A desolate graveyard of a planet, scarred by an ancient catastrophe. Its surface is frozen ash and blackened rock.";
            accessible = true;
            alwaysUnlocked = true;
            visible = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
            drawOrbit = true;
            updateLighting = true;
            bloom = false;
            hasAtmosphere = true;
            clearSectorOnLose = true;
            allowWaves = true;
            prebuildBase = false;
            allowLaunchToNumbered = false;

            meshLoader = () -> new MultiMesh(
                new NoiseMesh(
                    this,
                    6,
                    8,
                    1.5f,
                    5,
                    0.9f,
                    1f,
                    1f,
                    Color.valueOf("3a3c40"),
                    Color.valueOf("5a5d63"),
                    5,
                    0.6f,
                    0.9f,
                    0.38f
                ),

                new NoiseMesh(
                    this,
                    6,
                    3,
                    0.4f,
                    10,
                    2.8f,
                    0.25f,
                    0.7f,
                    Color.valueOf("6a7078"),
                    Color.valueOf("8b929c"),
                    2,
                    0.3f,
                    3f,
                    0.82f
                )
            );

            defaultCore = Blocks.coreShard;
            parent = Planets.sun;
            solarSystem = Planets.sun.solarSystem;

            startSector = 0;
            orbitSpacing = 4;
            radius = 1.5f;
            minZoom = 1.8f;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.3f;
            sectorSeed = 6;
            atmosphereColor = Color.valueOf("1a1a1a");
            iconColor = Color.valueOf("3a3c40");

            generator = new ADPlanetGenerator(){{
                octaves = 3;
                persistence = 0.8f;
                scale = 22f;
                mag = 1.2f;
                thresh = 1.5f;
                min = 100f;
                max = 100f;
                radMin = 300f;
                radMax = 700f;
                //waterColor = Color.valueOf("3a3c40");
                //landColor = Color.valueOf("3a3c40");
            }};
        }};

        nyx = new Planet("nyx", verdict, 0.3f, 3) {{
            localizedName = "Nyx";
            description = "A shard of darkness that orbits Verdict, born from the cataclysm that shattered Thanatos. Its surface is an eternal night.";
            accessible = false;
            alwaysUnlocked = true;
            visible = true;
            drawOrbit = true;
            updateLighting = true;
            bloom = false;
            hasAtmosphere = false;
            clearSectorOnLose = true;
            allowWaves = true;
            prebuildBase = false;
            allowLaunchToNumbered = false;

            defaultCore = Blocks.coreShard;
            solarSystem = Planets.sun.solarSystem;

            meshLoader = () -> new NoiseMesh(
                this,
                6,
                8,
                0.26f,
                1,
                1f,
                1f,
                1f,
                Color.valueOf("3a3c40"),
                Color.valueOf("5a5d63"),
                3,
                0.45f,
                0.9f,
                0.38f
            );

            startSector = 0;
            orbitSpacing = 12;
            radius = 0.3f;
            minZoom = 3f;
            maxZoom = 3f;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.3f;
            sectorSeed = 0;
            atmosphereColor = Color.valueOf("000000");
            iconColor = Color.valueOf("202025");

            ruleSetter = r -> {
                r.waves = true;
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.waveSpacing = 60 * Time.toSeconds;
                r.initialWaveSpacing = 8f * Time.toMinutes;
                r.hideBannedBlocks = true;
                r.loadout = ItemStack.list(Items.titanium, 1000, Items.tungsten, 1000, Items.silicon, 1000, ADItems.mythril, 1000, ADItems.blackMythril, 200);

                Rules.TeamRule teamRule = r.teams.get(r.defaultTeam);
                teamRule.rtsAi = true;
                teamRule.unitBuildSpeedMultiplier = 5f;
                teamRule.buildSpeedMultiplier = 1.5f;
            };

            generator = new ADPlanetGenerator(){{
                octaves = 3;
                persistence = 0.8f;
                scale = 22f;
                mag = 0.721f;
                thresh = 1.152f;
                min = 100f;
                max = 100f;
                radMin = 420f;
                radMax = 420f;
                seed = 69420;
                //waterColor = Color.valueOf("202025");
                //landColor = Color.valueOf("202025");
            }};
        }};
    }
}
