# Absolute Divinity — Insanity

Content extension mod for [Mindustry](https://github.com/Anuken/Mindustry). **6 factions × 10 turrets, 8 worlds, полная специализация.**

## Фракции — каждая имба в своём (как Omaloon / New Horizons)

| Фракция | Планета | Монополия |
|---------|---------|-----------|
| **Void** `[#a8b8ff]■[]` | **Элизиум** (Dyson-кольца) | **Турели** — MassiveLaser 25к, лучшие пушки |
| **Order** `[white]■[]` | **Вердикт** + луна **Никс** | **Энергия** — Fusion Core 85f, Capacitor 80к |
| **Abyss** `[#9000a4]■[]` | **Арес** | **Логистика** — Velocity Conduit 45/sec, Quantum Bridge 24 |
| **Chaos** `[#ff6b6b]■[]` | **Дионис** (пояс астероидов) | **Юниты** — Reconstructor 2×, орды |
| **Time** `[#f0e060]■[]` | **Бореас IV** + луна **Аргон** (ледяные кольца) | **Оборона** — Chrono Wall реген, Mender 120 HP/s |
| **Info** `[#77df00]■[]` | **Танатос** (пылевое гало) | **Химия** — Neutron Synthesizer, Mythril Forge |

Без импорта с других планет топ-контент не построить — вся система связана (см. `FACTIONS.md`).

## Content (0.0.2 / 160.1)

- **60+ турелей** (каждая фракция теперь с уникальной механикой: Void — лазеры, Abyss — чёрные дыры, Order — молнии+орбы, Chaos — спред+фраги, Time — заморозка времени, Info — самонаведение)
- **8 планет** (6 + 2 луны): Вердикт, Элизиум, Дионис, Арес, Танатос, Бореас IV, Никс [Луна Вердикта], Аргон [Луна Бореаса] — с Dyson-кольцами, ледяными кольцами и поясом астероидов (астрофизически корректно)
- **Специализация блоков**: Order Fusion Reactor / Abyss Velocity Conduit / Chrono Walls / Chaos Reconstructor / Neutron Synthesizer (`ADFactionSpecialization.java`)
- Предметы 15, жидкости 4, эффекты 16, юниты 17, погода 5
- Кастомные пули `ChainBulletType`, `MassiveLaserBulletType`, кастомные меши `DysonRingMesh`, `OrbitalRingMesh`, `AsteroidBeltMesh`
- Программные плейсхолдеры спрайтов (`ADPlaceholderSprites.java`) — мод стартует без PNG

## Building

```bash
./gradlew build
```

Output: `build/libs/AbsoluteDivinity.jar`

Requires **Mindustry v160.1** (Java 17+ recommended).

Подробнее: `FACTIONS.md` — дизайн специализации и астрофизика колец.
