package absolutedivinity;

import absolutedivinity.content.ADStatusEffects;
import absolutedivinity.content.ADEffects;
import absolutedivinity.content.ADEnvironment;
import absolutedivinity.content.ADItems;
import absolutedivinity.content.ADLiquids;
import absolutedivinity.content.ADPlanets;
import absolutedivinity.content.ADTechTree;
import absolutedivinity.content.blocks.distribution.ADDistribution;
import absolutedivinity.content.blocks.effects.ADEffectBlocks;
import absolutedivinity.content.turrets.ADVoidTurrets;
import absolutedivinity.content.turrets.ADAbyssTurrets;
import absolutedivinity.content.turrets.ADChaosTurrets;
import absolutedivinity.content.turrets.ADTimeTurrets;
import absolutedivinity.content.turrets.ADInfoTurrets;
import absolutedivinity.content.turrets.ADOrderTurrets;
import absolutedivinity.content.ADUnits;
import absolutedivinity.content.ADWeapons;
import absolutedivinity.content.ADWeathers;
import absolutedivinity.content.ADSectorPresets;
import absolutedivinity.content.ADPlaceholderSprites;
import absolutedivinity.content.blocks.ADCores;
import absolutedivinity.content.blocks.ADFactionSpecialization;
import absolutedivinity.content.blocks.power.ADReactors;
import absolutedivinity.core.ADGameLogic;
import absolutedivinity.core.ADSettings;
import arc.Events;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.mod.Mod;

public class ADMod extends Mod {
    public void loadContent(){
        ADItems.load();
        ADEffects.load();
        ADStatusEffects.load();
        ADLiquids.load();
        ADWeapons.load();
        // 6 faction turret lines — каждая теперь с уникальной механикой (см. ADFactionSpecialization javadoc)
        ADVoidTurrets.load();   // Void — турели (макс. DPS)
        ADAbyssTurrets.load();  // Abyss — логистика + грави-аномалии
        ADChaosTurrets.load();  // Chaos — юниты + хаотичный спред
        ADTimeTurrets.load();   // Time — контроль времени + замедление
        ADInfoTurrets.load();   // Info — разведка + хилинг
        ADOrderTurrets.load();  // Order — энергопушки
        ADDistribution.load();
        ADEffectBlocks.load();
        ADUnits.load();
        ADCores.load();
        ADReactors.load();
        ADFactionSpecialization.load(); // ← новая межфракционная специализация (Order/Abyss/Time/Chaos/Info/Void)
        ADEnvironment.load();
        ADWeathers.load();
        ADPlanets.load(); // 8 worlds — см. ADPlanets javadoc
        ADSectorPresets.load(); // crazy wave tunings per planet
        ADTechTree.load();
    }

    @Override
    public void init(){
        ADGameLogic.init();

        if(!Vars.headless){
            Events.on(EventType.ClientLoadEvent.class, e -> {
                ADSettings.load();
                // программные плейсхолдер-спрайты для блоков без PNG (160.1)
                try{
                    ADPlaceholderSprites.generate();
                }catch(Throwable t){
                    arc.util.Log.err("AD placeholder gen failed", t);
                }
            });
        }
    }
}
