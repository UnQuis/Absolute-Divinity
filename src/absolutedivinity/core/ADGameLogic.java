package absolutedivinity.core;

import arc.Events;
import mindustry.entities.Units;
import mindustry.game.EventType;
import mindustry.game.Team;
import mindustry.game.Teams;
import mindustry.gen.Unit;

public class ADGameLogic {
    public static void init(){
        Events.on(EventType.UnitSpawnEvent.class, e -> {
            Unit u = e.unit;

            if(u.team == Team.crux) {
                float mult = ADSettings.enemyHpMult();

                u.maxHealth *= mult;
                u.health = u.maxHealth;
            }
        });
    }
}
