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
import mindustry.type.ItemStack;
import mindustry.type.Planet;
import absolutedivinity.core.map.DysonRingMesh;
import absolutedivinity.core.map.ADPlanetGenerator;

public class ADPlanets {
    public static Planet
        elysium,
        nyx,
        thanatos,
        verdict,
        boreasIV,
        dionysus,
        ares,
        argon;

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
                radMin = 0.9f;
                radMax = 1.1f;
                mag = 2f;
                waterOffset = 0.4f;

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

        boreasIV = new Planet("boreas-iv", Planets.sun, 0.8f, 3){{
            localizedName = "Boreas IV";
            description = "A frozen ice world at the edge of the system. Its surface is locked in eternal winter, with cryogenic storms that never cease.";
            visible = true;
            accessible = true;
            alwaysUnlocked = true;
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

            defaultCore = Blocks.coreNucleus;
            solarSystem = Planets.sun.solarSystem;
            startSector = 0;
            orbitSpacing = 4;
            minZoom = 1.8f;
            orbitRadius = 44;
            sectorSeed = 78901;
            atmosphereRadIn = 0.1f;
            atmosphereRadOut = 0.5f;
            atmosphereColor = Color.valueOf("a8d8ea");
            iconColor = Color.valueOf("8fc5e8");
            landCloudColor = atmosphereColor;

            meshLoader = () -> new MultiMesh(
                new NoiseMesh(this, 6, 6, 0.9f, 4, 0.8f, 0.8f, 0.8f, Color.valueOf("e8f4f8"), Color.valueOf("b0d0e0"), 4, 0.5f, 0.7f, 0.35f),
                new NoiseMesh(this, 6, 4, 0.4f, 8, 1.5f, 0.2f, 0.6f, Color.valueOf("d0e8f0"), Color.valueOf("90b8d0"), 2, 0.3f, 2f, 0.75f)
            );

            ruleSetter = r -> {
                r.waves = true;
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.waveSpacing = 60 * Time.toSeconds;
                r.initialWaveSpacing = 5f * Time.toMinutes;
                r.hideBannedBlocks = true;
                r.loadout = ItemStack.list(ADItems.blackMythril, 500, ADItems.cryoSteel, 500, Items.titanium, 1000, Items.silicon, 1000);

                Rules.TeamRule teamRule = r.teams.get(r.defaultTeam);
                teamRule.rtsAi = true;
                teamRule.unitBuildSpeedMultiplier = 3f;
                teamRule.buildSpeedMultiplier = 1.5f;
            };

            generator = new ADPlanetGenerator(){{
                octaves = 5;
                persistence = 0.6f;
                scale = 28f;
                mag = 1.8f;
                thresh = 1.2f;
                min = 80f;
                max = 120f;
                radMin = 350f;
                radMax = 650f;
                waterOffset = 0.7f;
            }};
        }};

        dionysus = new Planet("dionysus", Planets.sun, 0.9f, 3){{
            localizedName = "Dionysus";
            description = "A volcanic forge-world, its surface churned by tectonic fury. Rivers of molten metal scar the landscape.";
            visible = true;
            accessible = true;
            alwaysUnlocked = true;
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

            defaultCore = Blocks.coreNucleus;
            solarSystem = Planets.sun.solarSystem;
            startSector = 0;
            orbitSpacing = 3;
            minZoom = 1.5f;
            orbitRadius = 16;
            sectorSeed = 23456;
            atmosphereRadIn = 0.15f;
            atmosphereRadOut = 0.5f;
            atmosphereColor = Color.valueOf("e06030");
            iconColor = Color.valueOf("d07040");
            landCloudColor = atmosphereColor;

            meshLoader = () -> new HexMesh(this, 6);

            ruleSetter = r -> {
                r.waves = true;
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.waveSpacing = 60 * Time.toSeconds;
                r.initialWaveSpacing = 5f * Time.toMinutes;
                r.hideBannedBlocks = true;
                r.loadout = ItemStack.list(Items.titanium, 1000, Items.tungsten, 1000, Items.silicon, 1000);

                Rules.TeamRule teamRule = r.teams.get(r.defaultTeam);
                teamRule.rtsAi = true;
                teamRule.unitBuildSpeedMultiplier = 5f;
                teamRule.buildSpeedMultiplier = 1.5f;
            };

            generator = new ADPlanetGenerator(){{
                octaves = 4;
                persistence = 0.7f;
                scale = 22f;
                mag = 2f;
                thresh = 0.9f;
                min = 80f;
                max = 120f;
                radMin = 300f;
                radMax = 600f;
                waterOffset = 0.5f;
            }};
        }};

        ares = new Planet("ares", Planets.sun, 1.3f, 3){{
            localizedName = "Ares";
            description = "A barren war-torn world, scarred by countless battles. Its red plains stretch endlessly under a heavy, dust-choked sky.";
            visible = true;
            accessible = true;
            alwaysUnlocked = true;
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

            defaultCore = Blocks.coreNucleus;
            solarSystem = Planets.sun.solarSystem;
            startSector = 0;
            orbitSpacing = 4;
            minZoom = 1.5f;
            orbitRadius = 36;
            sectorSeed = 56789;
            atmosphereRadIn = 0.1f;
            atmosphereRadOut = 0.4f;
            atmosphereColor = Color.valueOf("c04030");
            iconColor = Color.valueOf("b05040");
            landCloudColor = atmosphereColor;

            meshLoader = () -> new HexMesh(this, 6);

            ruleSetter = r -> {
                r.waves = true;
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.waveSpacing = 60 * Time.toSeconds;
                r.initialWaveSpacing = 5f * Time.toMinutes;
                r.hideBannedBlocks = true;
                r.loadout = ItemStack.list(Items.titanium, 1000, Items.tungsten, 1000, Items.silicon, 1000);

                Rules.TeamRule teamRule = r.teams.get(r.defaultTeam);
                teamRule.rtsAi = true;
                teamRule.unitBuildSpeedMultiplier = 5f;
                teamRule.buildSpeedMultiplier = 1.5f;
            };

            generator = new ADPlanetGenerator(){{
                octaves = 4;
                persistence = 0.7f;
                scale = 26f;
                mag = 1.6f;
                thresh = 1.1f;
                min = 90f;
                max = 110f;
                radMin = 320f;
                radMax = 680f;
                waterOffset = 0.6f;
            }};
        }};

        argon = new Planet("argon", boreasIV, 0.25f, 2){{
            localizedName = "Argon";
            description = "A tiny icy moon locked in Boreas IV's orbit. Its surface is a featureless expanse of frozen volatiles.";
            visible = true;
            accessible = false;
            alwaysUnlocked = true;
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
            startSector = 0;
            orbitSpacing = 2;
            minZoom = 3f;
            maxZoom = 3f;
            orbitRadius = 6;
            sectorSeed = 89012;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.2f;
            atmosphereColor = Color.valueOf("c0d8e8");
            iconColor = Color.valueOf("a0b8c8");

            meshLoader = () -> new NoiseMesh(this, 6, 6, 0.2f, 1, 1f, 1f, 1f, Color.valueOf("e0e8f0"), Color.valueOf("b0c8d8"), 3, 0.4f, 0.8f, 0.35f);
        }};
    }
}
