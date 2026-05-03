package absolutedivinity.content;

import arc.graphics.Color;
import arc.util.Time;
import mindustry.content.Items;
import mindustry.content.Planets;
import mindustry.game.Rules;
import mindustry.game.Team;
import mindustry.graphics.Pal;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.type.ItemStack;
import mindustry.type.Planet;
import absolutedivinity.core.map.DysonRingMesh;

public class ADPlanets {
    public static Planet elysium;

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

            meshLoader = () -> new HexMesh(this, 6);

            //meshLoader = () -> new NHModMesh(
            //        this, 6, 5, 0.3, 1.7, 1.2, 1.4, 1.1f,
            //        NHColor.darkEnrColor.cpy().lerp(ammonia, 0.75f).mul(1.05f).lerp(Color.black, 0.2f),
            //        NHColor.darkEnrColor.cpy().lerp(ammonia, 0.75f).mul(1.05f).lerp(Color.black, 0.2f),
            //        NHColor.darkEnrColor.cpy().lerp(ammonia, 0.75f).mul(1.05f).lerp(Color.black, 0.2f),
            //        NHColor.darkEnrColor.cpy().lerp(ammonia, 0.75f),
            //        NHColor.darkEnrFront.cpy().lerp(ammonia, 0.75f).lerp(Color.white, 0.2f),

            //        erode.cpy().lerp(Color.black, 0.3f),
            //        erode.cpy().lerp(Color.black, 0.2f),
            //        erode.cpy().lerp(Color.black, 0.1f),
            //        erode.cpy().lerp(Color.white, 0.1f),
            //        erode.cpy().lerp(Color.white, 0.2f),

            //        snow.cpy().lerp(Color.black, 0.4f),
            //        snow.cpy().lerp(Color.black, 0.3f),
            //        snow.cpy().lerp(Color.black, 0.2f)
            //);

            ruleSetter = r -> {
                r.waves = true;
                r.waveTeam = Team.blue;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.waveSpacing = 60 * Time.toSeconds;
                r.initialWaveSpacing = 5f * Time.toMinutes;
                r.hideBannedBlocks = true;
                // r.spawns = NHPostProcess.generate(0.8f, false);
                r.loadout = ItemStack.list(Items.titanium, 1000, Items.tungsten, 1000, Items.silicon, 1000, ADItems.mythril, 1000);

                Rules.TeamRule teamRule = r.teams.get(r.defaultTeam);
                teamRule.rtsAi = false;
                teamRule.unitBuildSpeedMultiplier = 5f;
                teamRule.buildSpeedMultiplier = 3f;
            };

            generator = new ADPlanetGenerator();

            cloudMeshLoader = () -> new MultiMesh(
                //new DysonSphereMesh(this, 0.35f),
                new DysonRingMesh(this, 2.300f, 0.28f, 729, Pal.darkMetal, Pal.darkerMetal),
                new DysonRingMesh(this, 2.500f, 0.28f, 2941, Pal.darkMetal, Pal.darkerMetal),
                new DysonRingMesh(this, 2.700f, 0.28f, 3834, Pal.darkMetal, Pal.darkerMetal),
                new DysonRingMesh(this, 2.305f, 0.19f, 729, ADColor.crimsonRed, ADColor.crimsonRed),
                new DysonRingMesh(this, 2.505f, 0.19f, 2941, ADColor.crimsonRed, ADColor.crimsonRed),
                new DysonRingMesh(this, 2.705f, 0.19f, 3834, ADColor.crimsonRed, ADColor.crimsonRed)
            );

            iconColor = ADColor.crimsonRed;
            landCloudColor = atmosphereColor = Color.valueOf("5992af");
            atmosphereRadIn = 0.12f;
            atmosphereRadOut = 0.45f;
        }};
    }
}
