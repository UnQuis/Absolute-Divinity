# Absolute Divinity — Полный список ресурсов (0.0.2 / 160.1)

> **17 предметов** + 4 жидкости + 16 статусов + 8 планет + 17 юнитов + ~60 турелей + блоки. Всё раскидано по фракциям, чтобы заставить летать между мирами.

## 1) Предметы — 17 (ADItems.java)

| # | ID (`Item.name`) | Локализация | Цвет | Фракция | Харднесс | Cost | Применение (куда идёт) |
|---|-------------------|-------------|------|---------|----------|------|------------------------|
| 1 | `ferrite-compound` | Ferrite Compound | `#9d7600` | Стартер / Void | 4 | 2.5 | T1 патрон (boring ammo), требует `copper` → `reinforcedComposite` |
| 2 | `reinforced-composite` | Reinforced Composite | `#002b92` | Стартер | 6 | 2.5 | Пирс-патрон, `Velocity Conduit` требует 2 шт |
| 3 | `matrix` | Matrix | `#df0505` | Chaos | 3 | 2.5 | Фраг-патрон, Abyss/ Chaos T2-3 |
| 4 | `restoration-gel` | Restoration Gel | `#77df05` | **Time** | 1 | 2.5 | **Хил-патрон + 2× хил Chrono Wall** (проверяет `team.items.has(гель)`). Используется в `Temporal Mender` как буст |
| 5 | `guidance-core` | Guidance Core | `#df21fa` | Info | 1 | 2.5 | Хоминг-патрон (`thorium` база), `radioactivity 0.3` |
| 6 | `nanite-cluster` | Nanite Cluster | `#6e0268` | Info | 1 | 2.5 | Нано-заражение (burn), `flammability 0.6` |
| 7 | `bio-alloy` | Bio Alloy | `#88299f` | **Chaos/Info** | 3 | 2.5 | Живой металл, 24 кадра анимация, `steelSedimentation` дроп, `bioAlloy → hardenedBioAlloy` |
| 8 | `hardened-bio-alloy` | Hardened Bio Alloy | `#6d59c6` | Chaos | 4 | 2.5 | `bioAlloy + thorium`, для `Chrono Wall Large` 12 шт |
| 9 | `cryo-steel` | Cryo Steel | `#2cbcc9` | **Time** | 5 | 1.4 | `charge 0.45`, главный сплав Time; `orderFusionReactor` 1/тик, `mythrilForge` 1/крафт |
|10 | `ferro-amalgam` | Ferro Amalgam | `#ba6a83` | Abyss | — | — | `Cu + LivingSteel + Surge`, для `Velocity Conduit`/`Quantum Bridge` |
|11 | `funny-metal` | Funny Metal | `#7c00e6` | Мем | 5 | 3 | `MAX_VALUE` всех св-в, `alwaysUnlocked false`, не для кампании |
|12 | `mythril` | Mythril | `#59b4c0` | **Void/Info** | 3 | 1.5 | Лёгкий, для `Chaos Reconstructor` 40/крафт, `mythrilForge` выход 2 |
|13 | `black-mythril` | Black Mythril | `#333a41` | Void | 4 | 4 | Улучш. mythril, `charge 1.0` |
|14 | `celestite` | Celestite | `#c2fffa` | Info (Thanatos) | 1 | 0.8 | Дешёвый, общий в EON-3, `mythrilForge` 2/крафт |
|15 | `divinite` | Divinite | `#2f5b87` | **END-GAME** | 6 | 6 | Редчайший, `charge 10, explosiveness 5, radioactivity 3`, патрон для всех Annihilator'ов второй слот |
|16 | `astralite` | Astralite | `#f2f0ff` | **Spatial** | 7 | 7.5 | Пространственный класс, `charge 20`, `mythril 2 + phaseFabric 1 + neutronFluid 0.25 → 1`, для телепортов/`quantumConveyor`/T7 турелей |
|17 | `singularity-alloy` | Singularity Alloy | `#191c2b` | **T6+ Универсал** | 9 | 9 | `divinite/blackMythril 1 + mythril 2 + cryoSteel 2 → 1`, `charge 6`, дорогой но штабелируемый, для T6+ пушек/стен |

### Ваниль, которая активно используется в рецептах мода
`copper, lead, graphite, silicon, titanium, thorium, surgeAlloy, tungsten, phaseFabric` — в `requirements` топ-пушек (до `15000 copper`) и `ADDistribution`, `ADReactors`, `ADFactionSpecialization`. Новые `astralite`/`singularity-alloy` требуют `phaseFabric`/`divinite` — топ-валюта.

---

## 2) Жидкости — 4 (ADLiquids.java)

| # | ID | Цвет | Вязкость | Темп | `heatCapacity` | Фракция | Куда идёт |
|---|----|------|----------|------|----------------|---------|-----------|
| 1 | `acid` | `#cde03a` | 0.2 | 0.2 | 0.9 | Info/Thanatos | `Tile Acid` пол, `status corrosiveMeltdown`, дроп с пола `acid`/`deepAcid` |
| 2 | `living-steel-liquid` | `#9000a4` | 0.6 | 0.125 | 0.9 | Chaos/Info | `flammability 1, capPuddles, moveThroughBlocks, incinerable` — саморепликация по нефти, для `neutronSynthesizer` 0.1/т + `chaosReconstructor` 0.6/т |
| 3 | `neutron-fluid` | `#e9e9e9` | 0.5 | 0.1 | **1.5** | **Order/Info** | Топ-кулант, `explosiveness 2.5`, для `orderFusionReactor` 0.12/т и `temporalMender` 0.08/т, производится в `neutronSynthesizer` |
| 4 | `steam` | `#ececec` | 0 | 0.1 | 0.1 | Универсальная | `gas true`, побочка, пока не используется |

Ваниль: `oil, cryofluid, water, slag` — в `neutronSynthesizer` (`oil 0.15 + cryo 0.15`).

---

## 3) Статус-эффекты — 16 (ADStatusEffects.java)

| ID | Цвет | Свойства | Кто накладывает |
|----|------|----------|----------------|
| `power-leak` | — | `build 0.8, speed 0.8` | Void? |
| `corrosive-meltdown` | — | `speed 0.8, dmg 0.8` | `acid` пол / `acidRain` |
| `circuit-null` | — | `speed 0.4, dmg 0.6, health 0.8, reload 0.7` | Abyss грави-ловушки |
| `plasma-scorch` | `#e8d174` | `damage 0.4, reload 0.85, ParticleEffect 8` | **Chaos mutation** |
| `fractured-core` | — | `speed/reload/build/dmg 0.8` | Abyss |
| `gravity-shear` / `gravity-disturbance` / `gravity-ripple` | — | `speed 0.7/0.9/0.8` | Abyss Annihilator притяжение |
| `zero-kelvin-lock` | — | `speed 0.4, reload 0.7, damage 0.1` | Time freeze |
| `adaptive-reconstruction` | — | `build 1.2` | **Chaos mutation** |
| `gravitational-collapse` | — | `speed 0.6` | Abyss |
| `irradiated-core` | `#30af1f` | `permanent, damage 0.125, speed/reload/health 0.9, ParticleEffect` | Time/Chaos |
| `neuro-shock` | — | `speed 0.3` | Chaos |
| `overclocked` | — | `reload 2.2` | **Void/Order, Chaos mutation** |
| `hyper-overclock` | — | `rate?` | Order |
| `funny-effect` | — | мем | — |

Для мутаций Chaos Reconstructor: `overclocked (30%), plasmaScorch (30%), overclock vanilla (30%), adaptiveReconstruction (10%)` + `+15% maxHealth`.

---

## 4) Блоки-ресурсы (производство / логистика / энергия / оборона)

### Энергия (Order — Verdict)
* `order-fusion-reactor` 5×5 9000 HP 85f, ест `cryoSteel 1 + neutronFluid 0.12/т` — монополия Order
* `order-capacitor` 3×3 80к буфер
* Legacy `basic/advanced/power/void/divinity-reactor` 2→6 размер, 800→25000 HP, HyperBlast взрывы

### Логистика (Abyss — Ares)
* `entropy-conduit` 22/sec, `rift-stacker` Stack 20, `grid-router`, `null-node`, `order-hub`, `aeon-bridge`/`nexus-bridge` 6 клеток, `void-caster` 88, `chrono-cannon` 600, `abyss-hold` 4000
* **Новые:** `abyss-velocity-conduit` 0.18 скорость 45/sec 30 кап, `abyss-quantum-bridge` 24 клетки `consumePower 1.2f` — топ-логистика, больше не трогаем (как просил)

### Оборона (Time — Boreas)
* **Новые:** `chrono-wall` 1800 HP 6 armor, `chrono-wall-large` 7200 HP 10 armor — **обе с `buildType` regen 12 HP/s (large 48 HP/s) + `damage*0.7` + `heal*2` если есть `restorationGel`**, `temporal-mender` 3×3 `range 100 heal 12% phase 24%, neutronFluid 0.08/т`

### Юниты (Chaos — Dionysus)
* `chaos-reconstructor` 5×5 `constructTime 15с (2×)`, `silicon 200 + bioAlloy 80 + mythril 40 + livingSteel 0.6/т` — мутации

### Химия (Info — Thanatos)
* `neutron-synthesizer` 3×3 `oil 0.15 + cryo 0.15 + livingSteel 0.1 → neutronFluid 0.2/т`
* `mythril-forge` 4×4 `celestite 2 + cryoSteel 1 + thorium 1 → mythril 2`
* `astralite-forge` 4×4 `mythril 2 + phaseFabric 1 + neutronFluid 0.25 → astralite 1` `6 power 120с` — пространственный
* `singularity-alloy-forge` 5×5 `divinite 1 + mythril 2 + cryoSteel 2 → singularity-alloy 1` `8 power 150с` — T6+
* `quantum-conveyor` Stack `0.22 52/sec` `astralite 2 + singularityAlloy 1 + Si 4 + cryoSteel 2` `0.8 power` — быстрее Velocity (45/sec), телепортирует стаки

### Ядра / Стены / Окружение
* `primordial-core` 6×6 70к HP 25к кап `power 16.6`, `ascension-core` 8×8 120к 50к `50f` (требует `divinite 500`)
* `living-steel-wall`/`petrified-steel-wall` `Attribute.spores 0.3`, `steel-sedimentation` 6 вариантов → `bioAlloy`, `acid`/`deepAcid` пол, `charred-tree`/`gnarled-tree`
* `disruptor2/3` `DisruptorBuild` — ломает стены

---

## 5) Планеты — 8 (ADPlanets.java)

| Планета | Фракция | Кольца/пояс | Волны | Loadout |
|---------|---------|-------------|-------|---------|
| `verdict` 18 AU | Order | — | 65с | Cu 800 Pb600 Si500 ferroamalgam150 |
| `nyx` (луна Verdict) | Order | — | 60с | Ti800 Si600 mythril300 |
| `elysium` 26 AU | Void | 8 DysonRingMesh | 60с | Ti1k Tung1k Si1k mythril1k |
| `dionysus` 36 AU | Chaos | 2 AsteroidBeltMesh | **50с SWARM** | Cu1500 Pb1200 Ti800 bioAlloy400 |
| `ares` 46 AU | Abyss | — | 65с | Cu2k Ti1200 Si800 ferro500 |
| `thanatos` 58 AU | Info | пылевое гало | 70с | Cu1500 Pb1k Si800 bioAlloy600 celestite200 |
| `boreas` 72 AU | Time | 6 OrbitalRingMesh icy | **75с TANK** | Cu2k Ti1500 Si1k cryoSteel400 mythril300 |
| `argon` (луна Boreas) | Time | — | 80с | Cu1200 Ti1k cryo600 mythril200 |

Сектора пресеты: `verdictShore(12), elysiumGate(115), dionysusSwarm(44), aresForge(88), thanatosArchive(33), boreasHold(19), nyxBattery(7), argonCryo(9)` — `ADSectorPresets.java`.

---

## 6) Юниты — 17 (ADUnits.java)

T1: `aedes`(Payload, 55 HP ротор), `beamWasp`, `builderSprite`, `bulwark`, `nereid`, `pyroclasm`, `scuttleboat`, `stinger`
T2: `armiger`
T3: `onirion`
T4: `culiseta`
Boss: `eradicatorPrime`, `lifedrinker`, `magmaStalker`, `serpentineColossus`, `slagspitter`, `umbralReaper` — для `primordial/ascension` ядер

Оружие: `ADWeapons.culisetaRotor` и кастом `MissileBulletType` в `AbyssTurret6`, `InfoAnnihilator`

---

## 7) Прочее

* Погода: `acidRain(status corrosiveMeltdown)`, `hail`/`hailstorm` (`freezing`), `heavyRainstorm`, `slackRain`
* Турели: 60 (Void/Order/Abyss/Chaos/Time/Info ×10), каждый `Annihilator/Obliterator` с NH-эффектами `instShoot/crossBlast/hyperBlast`
* Меши: `DysonRingMesh`, `OrbitalRingMesh`, `AsteroidBeltMesh`, `ADPlanetGenerator`, `CylinderMeshBuilder`
* Плейсхолдеры: `ADPlaceholderSprites` генерит цветные `Pixmap` если нет PNG

---

## Ветка Spatial (новое — astralite/singularity)

* `astralite` после `divinite` в техдереве → даёт `quantumConveyor` (Abyss логистика топ) и будущие пространственные турели T7+
* `singularity-alloy` после `astralite` → для T6+ стен/пушек, требует void-matter (`divinite`/`blackMythril`) — не уникален, но дорог

## Идеи для ещё новых ресурсов (что можно добавить сверх astralite/singularity)

* **Предметы:** `temporalShard` (Time, выпадает на Boreas), `abyssMatter` (Ares, из `VoidConduit` дропа), `voidCrystal` (Elysium, для топ-турелей), `quantumChip` (Info, из `mythrilForge` + `silicon`)
* **Жидкости:** `cryoSlurry` (Boreas, густой кулант лучше `neutronFluid` но вязкий), `voidPlasma` (Elysium, розжиг для Void лазеров)
* **Эффект:** `chronoStasis` (полная заморозка, как `unmoving` но с `Time` визуалом)
