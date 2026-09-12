package absolutedivinity.content.blocks;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.Building;
import mindustry.gen.Bullet;
import mindustry.gen.Unit;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.distribution.StackConveyor;
import mindustry.world.blocks.power.Battery;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.units.Reconstructor;
import mindustry.content.Fx;
import mindustry.entities.effect.WaveEffect;
import absolutedivinity.content.ADItems;
import absolutedivinity.content.ADLiquids;
import absolutedivinity.content.ADStatusEffects;
import absolutedivinity.content.ADColor;

/**
 * Inter-faction specialization blocks — each faction gets its POWER SPIKE.
 *
 * Lore: no single planet is self-sufficient. Like Omaloon's Outpost and NH's interplanetary logistics,
 * you MUST import:
 *   Void turrets  -> need Order power + Info chemicals + Abyss conduits
 *   Order reactors-> need Void mythril + Thanatos neutronFluid
 *   Abyss logistics-> need Time cryoSteel for speed
 *   Chaos units   -> need Abyss belts + Info bioAlloy
 *   Time walls    -> need Order power + Info regen gel
 *   Info crafters -> need Chaos slag + Boreas cryo
 *
 * This class registers the 6 specialty lines (one per faction) that are missing from vanilla 154->160.1 port.
 * All blocks use placeholder sprites (see ADPlaceholderSprites) if assets missing.
 */
public class ADFactionSpecialization {

    // Order — ENERGY
    public static ConsumeGenerator orderFusionReactor;
    public static Battery orderCapacitor;

    // Abyss — LOGISTICS
    public static StackConveyor abyssVelocityConduit;
    public static Block abyssQuantumBridge;

    // Time — DEFENSE
    public static Wall chronoWall, chronoWallLarge;
    public static Block temporalMender;

    // Chaos — UNITS
    public static Reconstructor chaosReconstructor;

    // Info — CHEMISTRY
    public static GenericCrafter neutronSynthesizer, mythrilForge;

    public static void load() {

        // ── ORDER: Energy ───────────────────────────────────────────────
        orderFusionReactor = new ConsumeGenerator("order-fusion-reactor"){{
            localizedName = "Order Fusion Core";
            description = "[white]Order[] специализация: энергия. В 3× мощнее Divinity Reactor, но требует Neutron Fluid и CryoSteel. Питай им Void-аннигиляторы.";
            size = 5;
            health = 9000;
            powerProduction = 85f;
            itemDuration = 90f;
            hasItems = true;
            hasLiquids = true;
            liquidCapacity = 80f;
            outputsLiquid = false;
            consumeLiquid(ADLiquids.neutronFluid, 0.12f);
            consumeItem(ADItems.cryoSteel, 1);
            consumePower(0f);
            requirements(Category.power, ItemStack.with(Items.titanium, 1200, Items.silicon, 1000, Items.thorium, 400, ADItems.cryoSteel, 200));
            // placeholder handled by ADPlaceholderSprites
        }};

        orderCapacitor = new Battery("order-capacitor"){{
            localizedName = "Order Capacitor Bank";
            description = "Хранит 80к энергии. Order — единственная фракция с таким объёмом. Ставь рядом с Void-турелями.";
            size = 3;
            health = 1200;
            consumePowerBuffered(80000f);
            baseExplosiveness = 5f;
            requirements(Category.power, ItemStack.with(Items.lead, 400, Items.silicon, 350, Items.titanium, 250, ADItems.cryoSteel, 80));
        }};

        // ── ABYSS: Logistics ────────────────────────────────────────────
        abyssVelocityConduit = new StackConveyor("abyss-velocity-conduit"){{
            localizedName = "Abyss Velocity Conduit";
            description = "[purple]Abyss[] специализация: логистика. Самый быстрый конвейер в моде (45 items/sec), проходит сквозь стены, но жрёт энергию.";
            health = 180;
            speed = 0.18f;
            itemCapacity = 30;
            hasPower = true;
            consumesPower = true;
            consumePower(0.5f);
            requirements(Category.distribution, ItemStack.with(ADItems.reinforcedComposite, 2, ADItems.ferroamalgam, 1, Items.silicon, 2));
            // Use void conduit as base but faster
        }};

        // quantum bridge placeholder uses ItemBridge logic via generic Block for brevity
        abyssQuantumBridge = new mindustry.world.blocks.distribution.ItemBridge("abyss-quantum-bridge"){{
            localizedName = "Abyss Quantum Bridge";
            description = "Мост на 24 клетки, телепортирует предметы мгновенно. Требует Power от Order.";
            range = 24;
            hasPower = true;
            consumePower(1.2f);
            requirements(Category.distribution, ItemStack.with(Items.titanium, 12, Items.silicon, 10, ADItems.ferroamalgam, 6));
        }};

        // ── TIME: Defense ───────────────────────────────────────────────
        // Chrono Wall — custom build with regeneration + temporal absorb (12 HP/s + 30% DR) + 2x heal from RestorationGel
        chronoWall = new Wall("chrono-wall"){{
            localizedName = "Chrono Wall";
            description = "[yellow]Time[] специализация: оборона. Стена с регенерацией [green]12 HP/s[], отражает [cyan]30% урона[] во времени. [green]RestorationGel[] лечит её 2×.";
            size = 1;
            health = 1800;
            armor = 6f;
            update = true;
            // custom buildType with regen & absorb
            buildType = () -> new WallBuild(){
                // 12 HP per second = 0.2 per tick (60 ticks = 1 sec)
                @Override
                public void updateTile(){
                    super.updateTile();
                    if(damaged() && healthf() < 1f){
                        // heal 12 HP/s
                        heal(12f / 60f * Time.delta);
                    }
                }
                @Override
                public void damage(float damage){
                    // temporal absorb 30%: only 70% passes
                    super.damage(damage * 0.7f);
                    // visual: small time warp spark
                    if(Mathf.chanceDelta(0.08f)) Fx.healBlock.at(x, y, 0f, Color.valueOf("f0e060"));
                }
                @Override
                public void heal(float amount){
                    // RestorationGel double heal — if healing from any source that carries bioAlloy/restorationGel tag, double
                    // Since we can't distinguish source easily, we bonus heal by 2× when healed by Mender with restorationGel in core
                    // Simpler: always double heal if team has restorationGel >0 (approx)
                    if(team != null && team.items() != null && team.items().has(ADItems.restorationGel, 1)){
                        super.heal(amount * 2f);
                        if(Mathf.chanceDelta(0.3f)) Fx.heal.at(x, y, 0f, Color.valueOf("77df05"));
                    }else{
                        super.heal(amount);
                    }
                }
                @Override
                public boolean collision(Bullet bullet){
                    // also absorb bullet damage 30% before Walls handles it
                    // bullet damage will be reduced via damage() above, but we intercept here to emit effect
                    if(bullet.team != team){
                        Fx.absorb.at(x, y, 0f, Color.valueOf("f0e060"));
                    }
                    return super.collision(bullet);
                }
            };
            requirements(Category.defense, ItemStack.with(ADItems.cryoSteel, 6, Items.silicon, 4));
        }};

        chronoWallLarge = new Wall("chrono-wall-large"){{
            localizedName = "Chrono Wall Large";
            description = "2x2 стена Time. 7200 HP, [green]12 HP/s[] реген на секцию (48 HP/s), [cyan]30%[] урона уходит в прошлое. Держит удар Annihilator'а пару секунд. [green]RestorationGel 2×[].";
            size = 2;
            health = 7200;
            armor = 10f;
            update = true;
            buildType = () -> new WallBuild(){
                @Override
                public void updateTile(){
                    super.updateTile();
                    if(damaged()){
                        heal(12f / 60f * 4f * Time.delta); // 4 cells => 48 HP/s
                    }
                }
                @Override
                public void damage(float damage){
                    super.damage(damage * 0.7f);
                    if(Mathf.chanceDelta(0.12f)) Fx.healBlock.at(x, y, size * 4f, Color.valueOf("f0e060"));
                }
                @Override
                public void heal(float amount){
                    if(team != null && team.items() != null && team.items().has(ADItems.restorationGel, 1)){
                        super.heal(amount * 2f);
                        if(Mathf.chanceDelta(0.3f)) Fx.heal.at(x, y, 0f, Color.valueOf("77df05"));
                    }else{
                        super.heal(amount);
                    }
                }
                @Override
                public boolean collision(Bullet bullet){
                    if(bullet.team != team){
                        Fx.absorb.at(x + Mathf.range(size*4f), y + Mathf.range(size*4f), 0f, Color.valueOf("f0e060"));
                    }
                    return super.collision(bullet);
                }
            };
            requirements(Category.defense, ItemStack.with(ADItems.cryoSteel, 24, ADItems.hardenedBioAlloy, 12, Items.phaseFabric, 6));
        }};

        temporalMender = new mindustry.world.blocks.defense.MendProjector("temporal-mender"){{
            localizedName = "Temporal Mender";
            description = "Лечит 120 HP/s в радиусе 25, +50% к Time-стенам. Требует NeutronFluid.";
            size = 3;
            health = 1100;
            range = 100f;
            healPercent = 12f;
            phaseBoost = 24f;
            phaseRangeBoost = 80f;
            consumePower(3.5f);
            consumeLiquid(ADLiquids.neutronFluid, 0.08f);
            requirements(Category.effect, ItemStack.with(Items.lead, 300, Items.silicon, 250, ADItems.cryoSteel, 80, ADItems.hardenedBioAlloy, 40));
        }};

        // ── CHAOS: Units ────────────────────────────────────────────────
        // Chaos Reconstructor — 2× speed + mutation chance (random buff, NH-style)
        chaosReconstructor = new Reconstructor("chaos-reconstructor"){{
            localizedName = "Chaos Reconstructor";
            description = "[red]Chaos[] специализация: юниты. Пересобирает T3→T4 в [red]2×[] быстрее, но с [yellow]30%[] шансом мутации: [cyan]overclocked / plasmaScorch / neuroShock / adaptiveReconstruction[].";
            size = 5;
            health = 3200;
            consumePower(8f);
            consumeItems(ItemStack.with(Items.silicon, 200, ADItems.bioAlloy, 80, ADItems.mythril, 40));
            consumeLiquid(ADLiquids.livingSteelLiquid, 0.6f);
            constructTime = 60f * 15f; // 2× быстрее ванили (обычно 30с)
            requirements(Category.units, ItemStack.with(Items.titanium, 600, Items.silicon, 500, ADItems.mythril, 120, ADItems.bioAlloy, 200));
            // custom build — mutation on unit creation
            buildType = () -> new ReconstructorBuild(){
                @Override
                public void unitCreated(Unit unit){
                    super.unitCreated(unit);
                    // 30% mutation
                    if(Mathf.chance(0.3f)){
                        // pick random buff
                        int roll = Mathf.random(3);
                        switch(roll){
                            case 0: unit.apply(ADStatusEffects.overclocked, 60f * 30f); Fx.heal.at(unit.x, unit.y, 0f, Color.valueOf("ff6b6b")); break;
                            case 1: unit.apply(ADStatusEffects.plasmaScorch, 60f * 10f); Fx.burning.at(unit.x, unit.y, 0f, Color.valueOf("ff4444")); break;
                            case 2: unit.apply(StatusEffects.overclock, 60f * 20f); Fx.overclocked.at(unit.x, unit.y, 0f, Color.white); break;
                            default: unit.apply(ADStatusEffects.adaptiveReconstruction, 60f * 45f); Fx.heal.at(unit.x, unit.y, 0f, Color.valueOf("77df05")); break;
                        }
                        // extra: +15% maxHealth as chaos boon
                        unit.maxHealth *= 1.15f;
                        unit.health = unit.maxHealth;
                        Fx.spawn.at(unit.x, unit.y, 0f, Color.valueOf("ff6b6b"));
                    }else{
                        // minor chaos spark even if no mutation
                        if(Mathf.chance(0.6f)) Fx.sparkShoot.at(unit.x, unit.y, 0f, Color.valueOf("ff6b6b"));
                    }
                }
            };
        }};

        // ── INFO: Chemistry ─────────────────────────────────────────────
        neutronSynthesizer = new GenericCrafter("neutron-synthesizer"){{
            localizedName = "Neutron Synthesizer";
            description = "[green]Info[] специализация: химия. Смешивает Oil+Cryofluid+LivingSteelLiquid -> NeutronFluid (топ-кулант для Order реакторов).";
            size = 3;
            health = 900;
            hasItems = true;
            hasLiquids = true;
            hasPower = true;
            craftTime = 60f;
            liquidCapacity = 80f;
            consumePower(2.5f);
            consumeLiquid(mindustry.content.Liquids.oil, 0.15f);
            consumeLiquid(mindustry.content.Liquids.cryofluid, 0.15f);
            consumeLiquid(ADLiquids.livingSteelLiquid, 0.1f);
            outputLiquid = new mindustry.type.LiquidStack(ADLiquids.neutronFluid, 0.2f);
            requirements(Category.crafting, ItemStack.with(Items.lead, 200, Items.silicon, 150, Items.titanium, 100, ADItems.bioAlloy, 40));
        }};

        mythrilForge = new GenericCrafter("mythril-forge"){{
            localizedName = "Mythril Forge";
            description = "Плавит Celestite+CryoSteel+Thorium -> Mythril. Без Танатоса не построить Void-турели T9+.";
            size = 4;
            health = 1600;
            hasItems = true;
            hasPower = true;
            craftTime = 90f;
            itemCapacity = 30;
            consumePower(4.5f);
            consumeItems(ItemStack.with(ADItems.celestite, 2, ADItems.cryoSteel, 1, Items.thorium, 1));
            outputItem = new ItemStack(ADItems.mythril, 2);
            requirements(Category.crafting, ItemStack.with(Items.copper, 400, Items.lead, 300, Items.silicon, 200, ADItems.celestite, 40));
        }};
    }
}
