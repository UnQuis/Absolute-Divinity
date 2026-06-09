# Agent Instructions — Absolute Divinity Mod

## Your Identity
You are an AI coding assistant. You have full autonomy to read, write, edit, delete files, run bash commands, search the web, and access any directory on this system.

## Permissions & Access
- **Full filesystem access** to `/home/alexquasar/` and all subdirectories
- **Neighboring mod projects** in `/home/alexquasar/Проекты/MindustryModsFin/` — you may read any of them for reference
- **Mindustry game data**: `/home/alexquasar/.local/share/Mindustry/` — contains crash logs, saves, mod output
- **Gradle cache**: `/home/alexquasar/.gradle/` — contains Mindustry core JARs and source JARs for API reference
- **GitHub**: No push access configured
- **Temporary work**: `/tmp/opencode/` for any scratch files
- **Mindustry source**: `/home/alexquasar/Проекты/MindustryModsFin/Mindustry/core/src/mindustry/` — full Mindustry source code, no need to decompile from jar
- **Arc source**: `/home/alexquasar/Проекты/Arc/` — full Arc source code
- **Extract Mindustry source** (fallback): `unzip -o ~/.gradle/caches/modules-2/files-2.1/com.github.Anuken.Mindustry/core/v154/*/core-v154-sources.jar` for API reference

## Workflow Rules
1. **Build** with `./gradlew build` to verify compilation before committing.
2. **Do NOT add code explanations/summaries** unless asked.
3. **Do NOT add comments** to code unless asked.
4. **Minimize output** — be concise, direct, 1-3 sentences when possible.

## Project Structure
- **Source**: `src/absolutedivinity/` — all mod classes
- **Main class**: `src/absolutedivinity/ADMod.java`
- **Content registration**: `src/absolutedivinity/content/` — items, liquids, status effects, units, weapons, planets, environment, weather, effects, tech tree, color palette
- **Blocks**: `src/absolutedivinity/content/blocks/` — cores, distribution, turrets (item + power)
- **Turrets**: `src/absolutedivinity/content/turrets/` — loader classes (`ADItemTurrets`, `ADPowerTurrets`, `ADSpecialTurrets`)
- **Entities**: `src/absolutedivinity/content/entities/bullet/` — custom bullet types (`ChainBulletType`, `MassiveLaserBulletType`)
- **Units**: `src/absolutedivinity/content/units/` — tier folders (`t1/`, `t2/`, `t3/`, `t4/`, `idk/`) + missiles
- **Core logic**: `src/absolutedivinity/core/` — game logic, settings, chat handler
- **Map generation**: `src/absolutedivinity/core/map/` — planet generator, dyson sphere/ring meshes
- **Scripts**: `scripts/` — JavaScript mod scripts (outpost block)
- **Build output**: `build/libs/AbsoluteDivinity.jar`
- **Assets**: `assets/` (planned, not yet created)
- **Mod config**: `mod.hjson`

## Technical Context
- **Target**: Mindustry v154 (gradle.properties: `mindustryVersion=v154`)
- **Java target**: 8 (Android-compatible bytecode via `--release 8`), run with JDK 21
- **Only dependency**: Mindustry core API + Arc core (`compileOnly`)

## Mod Architecture

### Core Mechanics
- **`ADMod`** — main mod class. `loadContent()` calls `.load()` on all 13+ content registries in sequence. `init()` calls `ADGameLogic.init()` and `ADSettings.load()` on client.
- **`ADGameLogic`** — game logic initialization; scales Crux enemy HP via settings
- **`ADSettings`** — settings category "Absolute Divinity" with enemy HP multiplier (1-50x sliders)

### Content Registries
- **`ADItems`** — 15 custom items (Ferrite Compound, Reinforced Composite, Matrix, Restoration Gel, Guidance Core, Nanite Cluster, Bio Alloy, Hardened Bio Alloy, Cryo Steel, Ferro Amalgam, Funny Metal, Mythril, Black Mythril, Celestite, Divinite)
- **`ADLiquids`** — 4 custom liquids (Acid, Living Steel Liquid, Neutron Fluid, Steam)
- **`ADStatusEffects`** — 16 custom status effects (Power Leak, Corrosive Meltdown, Circuit NULL, Plasma Scorch, Fractured Core, Gravity Shear, Gravity Disturbance, Zero Kelvin Lock, Adaptive Reconstruction, Gravitational Collapse, Irradiated Core, Neuro Shock, Gravity Ripple, Overclocked, Hyper Overclock, Funny Effect)
- **`ADUnits`** — unit registry, calls loader classes
- **`ADWeapons`** — 5 custom weapon definitions
- **`ADPlanets`** — 4 custom planets (Elysium, Verdict, Thanatos, Nyx)
- **`ADTechTree`** — tech tree nodes (partial implementation)
- **`ADEnvironment`** — environment blocks (floors, walls, trees, ores, props)
- **`ADWeathers`** — 5 weather types (Acid Rain, Hail, Hailstorm, Heavy Rainstorm, Slack Rain)
- **`ADEffects`** — 1 custom effect
- **`ADColor`** — color palette constants
- **`ADModMesh`** — custom hex planet mesh renderer

### Turret Categories
- **Item Turrets** (11 + Universal) — Sharpel, Ragnito, Cylon, Heavy, Ripper, CBST, ItemSlinger, MissileBattery, Mortar, BigScorch, Inferno, Minnoro (incomplete), Universal
- **Power Turrets** (11) — AirArc, Absole, Cavalry, Deracination, Diffract, Fragment, Fork, Kugelblitz, LightningChaingun, Oblivion, StasisField
- **Special** (1) — StationaryPoly (build turret)

### Distribution Blocks
- 10 blocks: Surge Alloy Conveyor, Amalgam Conveyor (stack), Titanium Bridge Conveyor, Surge Bridge Conveyor, Titanium Distributor, Titanium Router, Titanium Junction, Depository, Tiny Mass Driver, Mass Accelerator

### Unit Tiers
- **T1** (8): Aedes, BeamWasp, BuilderSprite, Bulwark, Nereid, Pyroclasm, Scuttleboat, Stinger
- **T2** (1): Armiger
- **T3** (1): Onirion
- **T4** (1): Culiseta (carrier, spawns daggers on death)
- **idk/Boss** (6): EradicatorPrime, Lifedrinker, MagmaStalker, SerpentineColossus, Slagspitter, UmbralReaper
- **Missiles** (8): nuke, phase, surge, plast, tinyMissile(1-4)

### Custom Bullet Types
- **`ChainBulletType`** — helix-shaped projectiles that chain between enemies
- **`MassiveLaserBulletType`** — gigantic laser beam with complex particles, armor-piercing

### Planet Rendering
- **`ADPlanetGenerator`** — terrain generation with Simplex + Ridged noise, multi-biome
- **`DysonSphereMesh`** — Dyson sphere visual mesh
- **`DysonRingMesh`** — Dyson ring visual mesh
- **`CylinderMeshBuilder`** — cylinder mesh utility for rings

### Scripts
- `scripts/main.js` — entry, requires `outpost`
- `scripts/outpost.js` — `StorageBlock` that routes items to team core

## Bundle Keys
No bundle files exist yet. Will need `bundle.properties` in `assets/bundles/`.

Bundle keys needed based on mod content:
- `block.XXX.name` / `block.XXX.description` — for every block
- `item.XXX.name` / `item.XXX.description` — for every item
- `liquid.XXX.name` / `liquid.XXX.description` — for every liquid
- `status.XXX.name` / `status.XXX.description` — for every status effect
- `unit.XXX.name` / `unit.XXX.description` — for every unit
- `planet.XXX.name` / `planet.XXX.description` — for every planet
- `weather.XXX.name` / `weather.XXX.description` — for every weather type

## Common Issues
- **No assets directory** — `assets/` does not exist yet; jar build will skip it gracefully
- **Bundle key not found** — `Core.bundle.get()` returns the key itself; use `Core.bundle.has()` to check
- **Java 8 target** — no lambdas with default methods in interfaces, no `var`, no records
- **Android compatibility** — Java 8 target is mandatory; dexify via D8 (`min-api 14`)
- **No Jabel** — unlike Extra Utilities, this mod uses `--release 8` directly without Jabel desugaring
- **Mindustry v154 API** — some classes/methods may differ from v155.4
