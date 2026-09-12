# Absolute Divinity — Специализация фракций (0.0.2 / 160.1)

> Как Omaloon и New Horizons, но безумия больше.

Мод больше **не копипаста 6x10**. Оставлены все 6 фракций, но каждая — монополист в своей нише. Без импорта с других планет топ-контент не построить. Баланс? Не главное. Хаос — главное.

## Сводка

| Фракция | Цвет | Планета(ы) | Монополия | Слабые стороны | Фишка |
|---------|------|------------|-----------|----------------|-------|
| **Void** | серебро `#a8b8ff` | **Элизиум** (26 AU, Dyson-кольца) | **ТУРЕЛИ** — самые мощные энергопушки, Annihilator `MassiveLaser` 25к, 3.5к длина | Почти нет генераторов (1.5f → 200f только с Order), медленные конвейеры | Тратишь всю энергию системы на один выстрел |
| **Order** | белый `#ffffff` | **Вердикт** (18 AU) + **Никс** (луна) | **ЭНЕРГЕТИКА** — `Order Fusion Core` 85f (≈3× Divinity), `Capacitor Bank` 80к буфер | Турели слабые (Spark/Cannon — прецизионные, не DPS) | Только Order делает энергию для Void |
| **Abyss** | фиолет `#9000a4` | **Арес** (46 AU) | **ЛОГИСТИКА** — `Velocity Conduit` 45/sec, `Quantum Bridge` 24 клетки, `VoidConduit` скользит сквозь стены | Нет тяжёлых стен, нет химии | Снабжает всю систему, как Outpost в Omaloon |
| **Chaos** | красный `#ff6b6b` | **Дионис** (36 AU, пояс астероидов) | **ЮНИТЫ** — `Chaos Reconstructor` 2× быстрее, орды дронов, колоссы | Энергия только с Вердикта, химия с Танатоса | Заливает волнами, пока Void стреляет |
| **Time** | золото `#f0e060` | **Бореас IV** (72 AU, ледяные кольца) + **Аргон** (луна) | **ОБОРОНА** — `Chrono Wall` 1800 HP + реген, `Temporal Mender` 120 HP/s, ядра 50f пассивно | Самый медленный транспорт (лед) | Держит удар Annihilator'а |
| **Info** | зелёный `#77df00` | **Танатос** (58 AU, пылевое гало) | **ХИМИЯ** — `Neutron Synthesizer` (Oil+Cryo+LivingSteel→NeutronFluid), `Mythril Forge` (Celestite→Mythril) | Нет армий, нет энергии | Без Info не будет ни mythril, ни neutronFluid |

## Межпланетарная зависимость (NH-стиль)

```
Info (Thanatos) --mythril/neutronFluid--> Order (Verdict) --85f power--> Void (Elysium) --annihilates--> все
      ^                                        |
      |                                        v
   Chaos (Dionysus) <--bioAlloy-- Abyss (Ares) --VelocityConduit 45/sec--> Boreas (Time) --cryoSteel walls
```

* Хочешь `Void Annihilator`? Нужно: `Order Fusion Core` (Verdict) + `Mythril Forge` (Thanatos) + `Quantum Bridge` (Ares).
* Хочешь `Abyss Annihilator` (чёрная дыра)? Нужно: `Chrono Wall Large` (Boreas) + `Capacitor` (Verdict).
* Все топ-турели `T9→Annihilator` в `ADTechTree.java` теперь требуют `Research` из чужой фракции.

Как в New Horizons — сидишь на Элизиуме с пушками, но без Танатоса и Ареса ты никто.

## Планетарная система — 8 миров

Солнце → Verdict (18) → Elysium (26) → Dionysus (36, Main Belt 32-38 AU) → Ares (46) → Thanatos (58, пылевое гало) → Boreas IV (72, ледяные кольца) + луны Nyx (Verdict) и Argon (Boreas).

Орбитальные кольца:
* **Элизиум** — 8 Dyson-колец `DysonRingMesh` (4 металл + 4 свечение crimson). Лор: искусственные, в Roche limit, но удерживаются полем Предтеч — как `Sievert` в NH. Физика не ломается: они не естественные.
* **Бореас IV** — 6 ледяных колец `OrbitalRingMesh` (`#d0e8ff`, `#ffffff` с альфой). Лор: за frost line (~70 AU) водяной лёд стабилен — как Сатурн. 6 узких колец, наклон 0-18°.

Пояса астероидов:
* **Dionysus Main Belt** — 2 тора `AsteroidBeltMesh` radius 2.15/2.45, thickness 0.55/0.35, цвета камня `#7a6e5a`. Лор: обломки пятой планеты "Фаэтон" между Elysium и Dionysus (аналог 2.2-3.2 AU в Солнечной). Орбита вокруг Солнца, отрендерен как `cloudMesh` Диониса — перформанс-оптимизация из Omaloon.
* **Thanatos halo** — 1 тонкий тор + пыль, `OrbitalRingMesh` 0.08.

Луны: **Никс** (Verduct, 0.28 радиус, без атмосферы, аккумулятор Order) и **Аргон** (Boreas, 0.35, лед, добыча `cryoSteel`). Тидально заблокированы, `drawOrbit=true`, `orbitSpacing` разные.

## 160.1 миграция

* `mod.hjson` → `minGameVersion: 160`, `version: "0.0.2"`
* `gradle.properties` → `mindustryVersion=v160.1`, удалён хардкод `JAVA_HOME`
* Новый `ADPlaceholderSprites.java` — в `ClientLoadEvent` генерит `Pixmap` 32×32→256×256 с фракционным цветом + крестом, кладёт в `Core.atlas` через `Texture`. Если PNG нет — не краш, а цветной плейсхолдер (как в Erekir-Turrets).
* `ADFactionSpecialization.java` — 9 новых блоков (2 Power, 2 Logistics, 3 Defense, 1 Units, 2 Chemistry) с `Category` и `requirements` под 160.1 API (`GenericCrafter`, `Reconstructor`, `Battery`, `StackConveyor`).
* `ADPlanets.java` полностью переписан — 8 планет с `ruleSetter` + `generator` + `cloudMeshLoader = MultiMesh(...)`.
* `ADTechTree.java` — cross-faction `Research` узлы, каждая Annihilator требует 2 блока чужой фракции.

## Что дальше (для баланс-хаоса)

* Добавить `SectorPreset` атаки: Verdict — волны Crux 55сек, Dionysus — 50сек (орды), Boreas — 75сек (танки).
* Логистика Abyss: добавить жидкостные `Abyss Conduit` 20% быстрее ванили, но с утечкой 5%.
* Time: кастомный `Chrono Wall` build с `regen 12 HP/s` и `absorb 30%` (нужен `WallBuild` override).
* Chaos юниты: мутации при реконструкции (случайный `StatusEffect`).
* Info: `Regeneration Gel` → лечит стены Time в 2×.

> Баланс не главное, но чтобы каждая фракция чувствовалась имбовой в своей нише — главная цель достигнута.
