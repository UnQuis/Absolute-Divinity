/* package absolutedivinity.core;

import arc.Events;
import mindustry.game.EventType.PlayerChatEvent;
import mindustry.gen.Call;

public class ADChatHandler {

    public static void init() {
        Events.on(PlayerChatEvent.class, e -> {

            String msg = e.message;

            if(msg.equalsIgnoreCase("/adtest")) {
                Call.sendMessage("[accent]Absolute Divinity работает.");
            }

            if(msg.startsWith("/power ")) {
                String value = msg.substring(7);

                Call.sendMessage("Ты ввёл: " + value);
            }
        });
    }
} */
