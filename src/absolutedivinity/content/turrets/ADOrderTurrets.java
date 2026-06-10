package absolutedivinity.content.turrets;

import absolutedivinity.content.blocks.turrets.order.OrderAnnihilator;
import absolutedivinity.content.blocks.turrets.order.OrderBeam;
import absolutedivinity.content.blocks.turrets.order.OrderCannon;
import absolutedivinity.content.blocks.turrets.order.OrderCataclysm;
import absolutedivinity.content.blocks.turrets.order.OrderFlak;
import absolutedivinity.content.blocks.turrets.order.OrderLance;
import absolutedivinity.content.blocks.turrets.order.OrderMortar;
import absolutedivinity.content.blocks.turrets.order.OrderSingularity;
import absolutedivinity.content.blocks.turrets.order.OrderSpark;
import absolutedivinity.content.blocks.turrets.order.OrderStorm;

public class ADOrderTurrets {
    public static void load(){
        OrderSpark.load();
        OrderFlak.load();
        OrderLance.load();
        OrderMortar.load();
        OrderStorm.load();
        OrderCannon.load();
        OrderBeam.load();
        OrderCataclysm.load();
        OrderSingularity.load();
        OrderAnnihilator.load();
    }
}
