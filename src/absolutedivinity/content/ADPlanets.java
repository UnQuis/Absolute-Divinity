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
import absolutedivinity.core.map.OrbitalRingMesh;
import absolutedivinity.core.map.AsteroidBeltMesh;
import absolutedivinity.core.map.ADPlanetGenerator;

/**
 * Absolute Divinity planetary system — 8 worlds (6 planets + 2 moons)
 * Faction specialization: 1 planet = 1 faction's power base, moons are bonuses.
 *
 * Order:  Verdict (inner, lawful) + Nyx (moon) — ENERGY specialists (reactors)
 * Time:   Boreas IV (outer ice giant) + Argon (moon) — DEFENSE / REPAIR specialists (walls, shields, cores)
 * Void:   Elysium (artificial Dyson rings) — TURRET specialists (annihilators)
 * Chaos:  Dionysus (unstable geology) — UNIT specialists (factories, swarms)
 * Abyss:  Ares (war-scarred) — LOGISTICS specialists (conveyors, mass drivers, conduits)
 * Info:   Thanatos (death archive) — CHEMISTRY / CRAFTING specialists (liquids, alloys)
 *
 * Astrophysics notes (in-lore):
 * - Elysium rings = artificial Dyson debris from extinct Type-II civ (within Roche limit, metallic)
 * - Boreas IV rings = natural icy rings beyond frost line (~72 AU, like Saturn) — water ice stable
 * - Dionysus asteroid belt = Main-Belt analog at 36 AU, between inner rocky (Verdict/Elysium) and outer (Ares/Boreas),
 *   debris of failed 5th planet "Phaethon" — does NOT break physics, belt orbits SUN, not planet, rendered as planet's cloudMesh for performance.
 * - Thanatos thin halo = captured comet dust, not full ring.
 * - Moons Nyx & Argon tidally locked, no atmosphere.
 */
public class ADPlanets {
    public static Planet
        verdict,
        nyx,
        elysium,
        dionysus,
        ares,
        thanatos,
        boreas,
        argon;

    public static void load() {

        // ─────────────────────────────────────────────────────────────────
        // 1. VERDICT — Order faction (Energy) — inner rocky, calm orbit 18
        // ─────────────────────────────────────────────────────────────────
        verdict = new Planet("verdict", Planets.sun, 1.35f, 3){{
            localizedName = "Вердикт";
            description = "[white]Order[] — планета-суд. Ровные плато, геотермальные разломы. Здесь добывают [white]чистую энергию[]. Лучшие реакторы Галактики собираются только на Вердикте.";
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
            clearSectorOnLose = false;
            allowWaves = true;
            prebuildBase = false;
            allowLaunchToNumbered = true;

            meshLoader = () -> new HexMesh(this, 7);

            solarSystem = Planets.sun;
            defaultCore = Blocks.coreNucleus;

            startSector = 1;
            orbitSpacing = 2;
            minZoom = 1.1f;
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.45f;
            orbitRadius = 18;
            sectorSeed = 33456;
            atmosphereColor = Color.valueOf("baddf7");
            iconColor = Color.valueOf("e8f4ff");

            ruleSetter = r -> {
                r.waves = true;
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.waveSpacing = 55 * Time.toSeconds;
                r.initialWaveSpacing = 4f * Time.toMinutes;
                r.hideBannedBlocks = true;
                r.loadout = ItemStack.list(Items.copper, 800, Items.lead, 600, Items.silicon, 500, ADItems.ferroamalgam, 150);
                Rules.TeamRule tr = r.teams.get(r.defaultTeam);
                tr.rtsAi = true;
                tr.unitBuildSpeedMultiplier = 4f;
            };

            generator = new ADPlanetGenerator(){{
                octaves = 4;
                persistence = 0.65f;
                scale = 26f;
                mag = 1.1f;
                thresh = 1.0f;
                waterOffset = 0.55f;
            }};
            // no rings — inner planet, Roche limit would destroy them; Verdict is kept clean by Order
        }};

        // ─────────────────────────────────────────────────────────────────
        // 1b. NYX — Moon of Verdict (Order bonus) — tiny, dark
        // ─────────────────────────────────────────────────────────────────
        nyx = new Planet("nyx", verdict, 0.28f, 3) {{
            localizedName = "Никс";
            description = "Луна Вердикта. Вечная ночь. Order использует её как орбитальный аккумулятор — здесь тестируют перегрузку реакторов без риска для основной планеты.";
            accessible = true;
            alwaysUnlocked = false;
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
                this, 6, 8, 0.26f, 1, 1f, 1f, 1f,
                Color.valueOf("2a2f3a"), Color.valueOf("4a5263"),
                3, 0.45f, 0.9f, 0.38f
            );

            startSector = 0;
            orbitSpacing = 4;
            radius = 0.28f;
            minZoom = 2.8f;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.15f;
            sectorSeed = 42;
            atmosphereColor = Color.valueOf("000000");
            iconColor = Color.valueOf("1a1f2a");

            ruleSetter = r -> {
                r.waves = true;
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.waveSpacing = 60 * Time.toSeconds;
                r.initialWaveSpacing = 7f * Time.toMinutes;
                r.hideBannedBlocks = true;
                r.loadout = ItemStack.list(Items.titanium, 800, Items.silicon, 600, ADItems.mythril, 300);
                Rules.TeamRule tr = r.teams.get(r.defaultTeam);
                tr.rtsAi = true;
                tr.unitBuildSpeedMultiplier = 3f;
            };

            generator = new ADPlanetGenerator(){{
                octaves = 3; persistence = 0.8f; scale = 22f; mag = 0.72f; thresh = 1.15f;
                radMin = 380f; radMax = 420f; seed = 69420;
            }};
        }};

        // ─────────────────────────────────────────────────────────────────
        // 2. ELYSIUM — Void faction (Turrets) — 26 AU, Dyson rings (artificial)
        // ─────────────────────────────────────────────────────────────────
        elysium = new Planet("elysium", Planets.sun, 1.2f, 3){{
            localizedName = "Элизиум";
            description = "[#a8b8ff]Void[] — рай, превращённый в полигон. Искусственные кольца Дайсона — обломки мегаструктуры Предтеч. Здесь куют [white]самые страшные турели[]. Энергию и логистику приходится везти с других миров.";
            visible = true;
            accessible = true;
            alwaysUnlocked = true;
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

            ruleSetter = r -> {
                r.waves = true;
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.waveSpacing = 60 * Time.toSeconds;
                r.initialWaveSpacing = 5f * Time.toMinutes;
                r.hideBannedBlocks = true;
                r.loadout = ItemStack.list(Items.titanium, 1000, Items.tungsten, 1000, Items.silicon, 1000, ADItems.mythril, 1000);
                Rules.TeamRule tr = r.teams.get(r.defaultTeam);
                tr.rtsAi = true;
                tr.unitBuildSpeedMultiplier = 5f;
                tr.buildSpeedMultiplier = 1.5f;
            };

            generator = new ADPlanetGenerator(){{
                radMin = 0.9f; radMax = 1.1f; mag = 2f; waterOffset = 0.4f;
            }};

            // Artificial Dyson debris — 4 metallic + 4 glowing crimson sub-rings
            // Astrophysics: within Roche limit, but artificial, so stable (like New Horizons' Sievert)
            cloudMeshLoader = () -> new MultiMesh(
                new DysonRingMesh(this, 2.300f, 0.28f, 729, Pal.darkMetal, Pal.darkerMetal),
                new DysonRingMesh(this, 2.500f, 0.28f, 2941, Pal.darkMetal, Pal.darkerMetal),
                new DysonRingMesh(this, 2.700f, 0.28f, 3834, Pal.darkMetal, Pal.darkerMetal),
                new DysonRingMesh(this, 2.900f, 0.37f, 4543, Pal.darkMetal, Pal.darkerMetal),
                new DysonRingMesh(this, 2.305f, 0.19f, 729, ADColor.crimsonRed, ADColor.crimsonRed),
                new DysonRingMesh(this, 2.505f, 0.19f, 2941, ADColor.crimsonRed, ADColor.crimsonRed),
                new DysonRingMesh(this, 2.705f, 0.19f, 3834, ADColor.crimsonRed, ADColor.crimsonRed),
                new DysonRingMesh(this, 2.905f, 0.19f, 4543, ADColor.crimsonRed, ADColor.crimsonRed)
            );

            orbitRadius = 26;
            sectorSeed = 913;
            iconColor = ADColor.crimsonRed;
            landCloudColor = atmosphereColor = Color.valueOf("5992af");
            atmosphereRadIn = 0.12f;
            atmosphereRadOut = 0.45f;
        }};

        // ─────────────────────────────────────────────────────────────────
        // 3. DIONYSUS — Chaos faction (Units) — 36 AU, with MAIN ASTEROID BELT
        // ─────────────────────────────────────────────────────────────────
        dionysus = new Planet("dionysus", Planets.sun, 1.45f, 3){{
            localizedName = "Дионис";
            description = "[#ff6b6b]Chaos[] — буйный мир вечных извержений и кислотных морей. Гравитационные аномалии рождают орды. Здесь делают [scarlet]лучших юнитов[] — от роя дронов до колоссов. Зависит от Abyss-логистики и Info-химии.";
            visible = true;
            accessible = true;
            alwaysUnlocked = false;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
            drawOrbit = true;
            updateLighting = true;
            bloom = true;
            hasAtmosphere = true;
            clearSectorOnLose = true;
            allowWaves = true;
            prebuildBase = false;
            allowLaunchToNumbered = true;

            meshLoader = () -> new MultiMesh(
                new NoiseMesh(this, 6, 5, 1.35f, 4, 1.1f, 0.9f, 1f,
                    Color.valueOf("5a1a1a"), Color.valueOf("8a2a1a"),
                    5, 0.55f, 0.85f, 0.42f),
                new NoiseMesh(this, 6, 3, 0.35f, 8, 2.2f, 0.3f, 0.65f,
                    Color.valueOf("7a3a1a"), Color.valueOf("c45a2a"),
                    2, 0.25f, 2.5f, 0.78f)
            );

            defaultCore = Blocks.coreShard;
            solarSystem = Planets.sun.solarSystem;
            startSector = 3;
            orbitSpacing = 3;
            minZoom = 1.2f;
            orbitRadius = 36;
            sectorSeed = 777;
            atmosphereRadIn = 0.04f;
            atmosphereRadOut = 0.55f;
            atmosphereColor = Color.valueOf("ff7a3a");
            iconColor = Color.valueOf("8a1a1a");

            // Main asteroid belt — orbits SUN at ~32-38 AU, rendered as Dionysus cloudMesh
            // This is the Solar System Main Belt analog: debris of failed planet Phaethon.
            // Does not break physics: belt orbits sun, not planet.
            cloudMeshLoader = () -> new MultiMesh(
                new AsteroidBeltMesh(this, 2.15f, 0.55f, 1337, Color.valueOf("7a6e5a"), Color.valueOf("4a453a")),
                new AsteroidBeltMesh(this, 2.45f, 0.35f, 7331, Color.valueOf("8a7e6d"), Color.valueOf("5a5550"))
            );

            ruleSetter = r -> {
                r.waves = true; r.waveTeam = Team.crux;
                r.placeRangeCheck = false; r.showSpawns = true;
                r.waveSpacing = 50 * Time.toSeconds;
                r.initialWaveSpacing = 3f * Time.toMinutes;
                r.hideBannedBlocks = true;
                r.loadout = ItemStack.list(Items.copper, 1500, Items.lead, 1200, Items.titanium, 800, ADItems.bioAlloy, 400);
                Rules.TeamRule tr = r.teams.get(r.defaultTeam);
                tr.rtsAi = true; tr.unitBuildSpeedMultiplier = 6f; tr.blockHealthMultiplier = 0.9f;
            };

            generator = new ADPlanetGenerator(){{
                octaves = 4; persistence = 0.72f; scale = 20f; mag = 1.6f; thresh = 1.05f;
                radMin = 480f; radMax = 620f; waterOffset = 0.35f;
            }};
        }};

        // ─────────────────────────────────────────────────────────────────
        // 4. ARES — Abyss faction (Logistics) — 46 AU, war-scarred, no rings
        // ─────────────────────────────────────────────────────────────────
        ares = new Planet("ares", Planets.sun, 1.55f, 3){{
            localizedName = "Арес";
            description = "[#9000a4]Abyss[] — планета-окоп. Бесконечные каньоны, фиолетовые шторма. Здесь строят [purple]лучшую логистику[]: сверхзвуковые конвейеры, VoidConduit, масс-драйверы дальностью 600. Снабжает всю систему.";
            visible = true;
            accessible = true;
            alwaysUnlocked = false;
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
            allowLaunchToNumbered = true;

            meshLoader = () -> new MultiMesh(
                new NoiseMesh(this, 6, 7, 1.25f, 4, 1f, 0.85f, 1f,
                    Color.valueOf("3a1450"), Color.valueOf("5a2080"),
                    4, 0.5f, 0.9f, 0.40f),
                new NoiseMesh(this, 6, 4, 0.5f, 9, 2.5f, 0.3f, 0.7f,
                    Color.valueOf("6a3090"), Color.valueOf("9a4ac0"),
                    3, 0.3f, 2.8f, 0.75f)
            );

            defaultCore = Blocks.coreShard;
            solarSystem = Planets.sun.solarSystem;
            startSector = 2;
            orbitSpacing = 3;
            minZoom = 1.2f;
            orbitRadius = 46;
            sectorSeed = 31415;
            atmosphereRadIn = 0.03f;
            atmosphereRadOut = 0.5f;
            atmosphereColor = Color.valueOf("7a2a9a");
            iconColor = ADColor.abyssMain;

            ruleSetter = r -> {
                r.waves = true; r.waveTeam = Team.crux;
                r.placeRangeCheck = false; r.showSpawns = true;
                r.waveSpacing = 65 * Time.toSeconds;
                r.initialWaveSpacing = 6f * Time.toMinutes;
                r.hideBannedBlocks = true;
                r.loadout = ItemStack.list(Items.copper, 2000, Items.titanium, 1200, Items.silicon, 800, ADItems.ferroamalgam, 500);
                Rules.TeamRule tr = r.teams.get(r.defaultTeam);
                tr.rtsAi = true; tr.unitBuildSpeedMultiplier = 3f; tr.buildSpeedMultiplier = 1.3f;
            };

            generator = new ADPlanetGenerator(){{
                octaves = 5; persistence = 0.68f; scale = 24f; mag = 1.3f; thresh = 1.0f;
                radMin = 500f; radMax = 700f; waterOffset = 0.6f;
            }};
        }};

        // ─────────────────────────────────────────────────────────────────
        // 5. THANATOS — Info faction (Chemistry) — 58 AU, dark archive
        // ─────────────────────────────────────────────────────────────────
        thanatos = new Planet("thanatos", Planets.sun, 1.56f, 3) {{
            localizedName = "Танатос";
            description = "[#77df00]Info[] — архив смерти. Замёрзший пепел, чёрные скалы, озёра кислоты. Здесь варят [green]химию[]: Acid, LivingSteelLiquid, NeutronFluid, сплавы Mythril/Divinite. Без Танатоса не построить ни одну топ-турель.";
            accessible = true;
            alwaysUnlocked = false;
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
                new NoiseMesh(this, 6, 8, 1.5f, 5, 0.9f, 1f, 1f,
                    Color.valueOf("3a3c40"), Color.valueOf("5a5d63"),
                    5, 0.6f, 0.9f, 0.38f),
                new NoiseMesh(this, 6, 3, 0.4f, 10, 2.8f, 0.25f, 0.7f,
                    Color.valueOf("6a7078"), Color.valueOf("8b929c"),
                    2, 0.3f, 3f, 0.82f)
            );

            defaultCore = Blocks.coreShard;
            parent = Planets.sun;
            solarSystem = Planets.sun.solarSystem;

            startSector = 5;
            orbitSpacing = 4;
            radius = 1.56f;
            minZoom = 1.4f;
            orbitRadius = 58;
            sectorSeed = 6;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.3f;
            atmosphereColor = Color.valueOf("1a1a1a");
            iconColor = Color.valueOf("3a3c40");

            // Thin captured dust halo — not a full ring, just 2 faint tori (like Omaloon's dust)
            cloudMeshLoader = () -> new MultiMesh(
                new OrbitalRingMesh(this, 1.85f, 0.08f, 9001, Color.valueOf("3a3c40").a(0.6f), Color.valueOf("2a2f35").a(0.0f)),
                new AsteroidBeltMesh(this, 2.2f, 0.18f, 4242, Color.valueOf("4a4f55").a(0.7f), Color.valueOf("2a2f35").a(0.0f))
            );

            ruleSetter = r -> {
                r.waves = true; r.waveTeam = Team.crux;
                r.placeRangeCheck = false; r.showSpawns = true;
                r.waveSpacing = 70 * Time.toSeconds;
                r.initialWaveSpacing = 6f * Time.toMinutes;
                r.hideBannedBlocks = true;
                r.loadout = ItemStack.list(Items.copper, 1500, Items.lead, 1000, Items.silicon, 800, ADItems.bioAlloy, 600, ADItems.celestite, 200);
                Rules.TeamRule tr = r.teams.get(r.defaultTeam);
                tr.rtsAi = true; tr.unitBuildSpeedMultiplier = 3f;
            };

            generator = new ADPlanetGenerator(){{
                octaves = 3; persistence = 0.8f; scale = 22f; mag = 1.2f; thresh = 1.5f;
                min = 100f; max = 100f; radMin = 300f; radMax = 700f;
            }};
        }};

        // ─────────────────────────────────────────────────────────────────
        // 6. BOREAS IV — Time faction (Defense) — 72 AU, outer ice giant with ICY RINGS
        // ─────────────────────────────────────────────────────────────────
        boreas = new Planet("boreas", Planets.sun, 1.85f, 3){{
            localizedName = "Бореас IV";
            description = "[#f0e060]Time[] — ледяной гигант за снеговой линией. Крио-шторма замораживают время. Здесь делают [yellow]лучшую оборону[]: стены с регенерацией, купола, ядра-криогенераторы. Ледяные кольца — естественные, из водяного льда, стабильные за frost line.";
            visible = true;
            accessible = true;
            alwaysUnlocked = false;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            allowLaunchLoadout = true;
            drawOrbit = true;
            updateLighting = true;
            bloom = true;
            hasAtmosphere = true;
            clearSectorOnLose = true;
            allowWaves = true;
            prebuildBase = false;
            allowLaunchToNumbered = true;

            meshLoader = () -> new MultiMesh(
                new NoiseMesh(this, 6, 6, 1.1f, 5, 0.85f, 1f, 1f,
                    Color.valueOf("2a3a5a"), Color.valueOf("4a6a9a"),
                    5, 0.5f, 0.9f, 0.42f),
                new NoiseMesh(this, 6, 4, 0.45f, 8, 2.0f, 0.35f, 0.75f,
                    Color.valueOf("6a9ac0"), Color.valueOf("a0d0f0"),
                    3, 0.3f, 2.2f, 0.80f)
            );

            // Natural icy rings — 6 concentric, water-ice (beyond frost line physics-correct, like Saturn)
            // Colors: ice blue/white, thin, high albedo
            cloudMeshLoader = () -> new MultiMesh(
                new OrbitalRingMesh(this, 1.95f, 0.14f, 111, Color.valueOf("d0e8ff").a(0.9f), Color.valueOf("a0c8f0").a(0.0f)),
                new OrbitalRingMesh(this, 2.15f, 0.10f, 222, Color.valueOf("e0f0ff").a(0.8f), Color.valueOf("b0d0f0").a(0.0f)),
                new OrbitalRingMesh(this, 2.32f, 0.18f, 333, Color.valueOf("c8e4ff").a(0.7f), Color.valueOf("90b8e0").a(0.0f)),
                new OrbitalRingMesh(this, 2.52f, 0.12f, 444, Color.valueOf("d8ecff").a(0.75f), Color.valueOf("a8d0f0").a(0.0f)),
                new OrbitalRingMesh(this, 2.70f, 0.08f, 555, Color.valueOf("e8f4ff").a(0.6f), Color.valueOf("b8e0ff").a(0.0f)),
                new OrbitalRingMesh(this, 1.88f, 0.04f, 666, Color.valueOf("ffffff").a(0.5f), Color.valueOf("ffffff").a(0.0f))
            );

            defaultCore = Blocks.coreShard;
            solarSystem = Planets.sun.solarSystem;
            startSector = 4;
            orbitSpacing = 5;
            minZoom = 1.0f;
            orbitRadius = 72;
            sectorSeed = 1984;
            atmosphereRadIn = 0.06f;
            atmosphereRadOut = 0.65f;
            atmosphereColor = Color.valueOf("b0d8ff");
            iconColor = Color.valueOf("4a6a9a");

            ruleSetter = r -> {
                r.waves = true; r.waveTeam = Team.crux;
                r.placeRangeCheck = false; r.showSpawns = true;
                r.waveSpacing = 75 * Time.toSeconds;
                r.initialWaveSpacing = 8f * Time.toMinutes;
                r.hideBannedBlocks = true;
                r.loadout = ItemStack.list(Items.copper, 2000, Items.titanium, 1500, Items.silicon, 1000, ADItems.cryoSteel, 400, ADItems.mythril, 300);
                Rules.TeamRule tr = r.teams.get(r.defaultTeam);
                tr.rtsAi = true; tr.unitBuildSpeedMultiplier = 2.5f; tr.blockHealthMultiplier = 1.4f;
            };

            generator = new ADPlanetGenerator(){{
                octaves = 4; persistence = 0.7f; scale = 28f; mag = 1.0f; thresh = 1.1f;
                radMin = 550f; radMax = 750f; waterOffset = 0.75f;
            }};
        }};

        // ─────────────────────────────────────────────────────────────────
        // 6b. ARGON — Moon of Boreas IV (Time bonus) — ice moon
        // ─────────────────────────────────────────────────────────────────
        argon = new Planet("argon", boreas, 0.35f, 3){{
            localizedName = "Аргон";
            description = "Луна Бореаса. Ледяной щит Time. Здесь добывают CryoSteel и испытывают стены, которые регенерируют даже под огнём Annihilator'а.";
            accessible = true;
            alwaysUnlocked = false;
            visible = true;
            drawOrbit = true;
            updateLighting = true;
            bloom = false;
            hasAtmosphere = true;
            clearSectorOnLose = true;
            allowWaves = true;
            prebuildBase = false;
            allowLaunchToNumbered = false;

            defaultCore = Blocks.coreShard;
            solarSystem = Planets.sun.solarSystem;

            meshLoader = () -> new NoiseMesh(
                this, 6, 5, 0.9f, 4, 0.9f, 1f, 1f,
                Color.valueOf("3a4a6a"), Color.valueOf("5a7aa0"),
                4, 0.5f, 0.9f, 0.40f
            );

            startSector = 0;
            orbitSpacing = 6;
            radius = 0.35f;
            minZoom = 2.5f;
            orbitRadius = 1; // relative to parent Boreas
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.35f;
            sectorSeed = 8008;
            atmosphereColor = Color.valueOf("d0e8ff");
            iconColor = Color.valueOf("4a6a9a");

            ruleSetter = r -> {
                r.waves = true; r.waveTeam = Team.crux;
                r.placeRangeCheck = false; r.showSpawns = true;
                r.waveSpacing = 80 * Time.toSeconds;
                r.initialWaveSpacing = 9f * Time.toMinutes;
                r.hideBannedBlocks = true;
                r.loadout = ItemStack.list(Items.copper, 1200, Items.titanium, 1000, ADItems.cryoSteel, 600, ADItems.mythril, 200);
                Rules.TeamRule tr = r.teams.get(r.defaultTeam);
                tr.rtsAi = true; tr.blockHealthMultiplier = 1.5f;
            };

            generator = new ADPlanetGenerator(){{
                octaves = 3; persistence = 0.75f; scale = 20f; mag = 0.85f; thresh = 1.2f;
                radMin = 380f; radMax = 420f;
            }};
        }};
    }
}
