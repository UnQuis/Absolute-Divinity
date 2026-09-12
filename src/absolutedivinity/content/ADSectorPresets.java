package absolutedivinity.content;

import mindustry.content.Blocks;
import mindustry.type.SectorPreset;

/**
 * Sector presets — crazy wave tunings per planet (Omaloon / NH style).
 * Each planet now feels different not just by terrain but by attack rhythm.
 *
 * - Verdict (Order): calm 65s waves, 10 capture, tech waves
 * - Elysium (Void): 60s, but burst 5s initial, RTS AI 5x
 * - Dionysus (Chaos): 50s SWARM — horde focus, 6x unit build speed, block health 0.9x (you die fast)
 * - Ares (Abyss): 65s, logistics test, massDriver required
 * - Thanatos (Info): 70s, expensive chemistry, slow but tanky
 * - Boreas IV (Time): 75s TANK — slow waves, 1.5x block health, 2.5x unit build (defense hold)
 * - Nyx (moon): 60s battery test
 * - Argon (moon): 80s cryo hold
 *
 * Presets are attached to planets in ADPlanets ruleSetter, but also provide explicit capture targets.
 */
public class ADSectorPresets {
    public static SectorPreset
        verdictShore,      // 1 - Verdict starter
        elysiumGate,       // 2 - Elysium
        dionysusSwarm,     // 3 - Dionysus crazy 50s
        aresForge,         // 4 - Ares logistics
        thanatosArchive,   // 5 - Thanatos chem
        boreasHold,        // 6 - Boreas 75s tank
        nyxBattery,        // 7 - Nyx moon
        argonCryo;         // 8 - Argon moon

    public static void load(){
        verdictShore = new SectorPreset("verdict-shore", ADPlanets.verdict, 12){{
            localizedName = "Берег Вердикта";
            description = "Order: учись питать. Волны 65с, первые 6 мин спокойны. Без энергии с Вердикта Элизиум не выстрелит.";
            captureWave = 12;
            difficulty = 1;
            alwaysUnlocked = true;
        }};

        elysiumGate = new SectorPreset("elysium-gate", ADPlanets.elysium, 115){{
            localizedName = "Врата Элизиума";
            description = "Void: полигон аннигиляторов. Нужен Order Fusion + Mythril Forge, иначе пушки молчат.";
            captureWave = 15;
            difficulty = 3;
            alwaysUnlocked = true;
        }};

        dionysusSwarm = new SectorPreset("dionysus-swarm", ADPlanets.dionysus, 44){{
            localizedName = "Рой Диониса";
            description = "[red]50с волны, орды Chaos[] — тест мутаций Reconstructor. 6× скорость юнитов, стены 0.9×. Зальют или ты их.";
            captureWave = 20;
            difficulty = 5;
            alwaysUnlocked = false;
        }};

        aresForge = new SectorPreset("ares-forge", ADPlanets.ares, 88){{
            localizedName = "Кузня Ареса";
            description = "Abyss: логистика. Velocity Conduit 45/sec + Quantum Bridge 24 — доставь ресурсы, пока волны 65с дают передышку.";
            captureWave = 18;
            difficulty = 4;
            alwaysUnlocked = false;
        }};

        thanatosArchive = new SectorPreset("thanatos-archive", ADPlanets.thanatos, 33){{
            localizedName = "Архив Танатоса";
            description = "Info: химия. 70с волны, Neutron Synthesizer + Mythril Forge — сердце всей системы. Без Танатоса ни один Annihilator не построится.";
            captureWave = 22;
            difficulty = 6;
            alwaysUnlocked = false;
        }};

        boreasHold = new SectorPreset("boreas-hold", ADPlanets.boreas, 19){{
            localizedName = "Рубеж Бореаса";
            description = "[yellow]75с волны, танки[] — Time hold. Стены 1.5×, Chrono Wall реген 12 HP/s, 30% абсорб. Держись, пока Chaos шлёт рои.";
            captureWave = 25;
            difficulty = 7;
            alwaysUnlocked = false;
        }};

        nyxBattery = new SectorPreset("nyx-battery", ADPlanets.nyx, 7){{
            localizedName = "Батарея Никс";
            description = "Луна Вердикта: испытай Order Capacitor 80к. Волны 60с, перегрузка без риска для планеты.";
            captureWave = 10;
            difficulty = 2;
            alwaysUnlocked = false;
        }};

        argonCryo = new SectorPreset("argon-cryo", ADPlanets.argon, 9){{
            localizedName = "Крио Аргона";
            description = "Луна Бореаса: добыча CryoSteel. 80с волны, стены реген 48 HP/s на большой. Лёд держит.";
            captureWave = 14;
            difficulty = 4;
            alwaysUnlocked = false;
        }};
    }
}
