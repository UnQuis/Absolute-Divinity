package absolutedivinity.content.blocks.turrets.order;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class OrderTurret1 {
    public static ItemTurret orderTurret1;

    public static void load() {{
        orderTurret1 = new ItemTurret("order-1") {{
            localizedName = "Order Turret 1";
            description = "[orange]Order faction[] turret. Not yet implemented.";
            size = 2;
            health = 500;
            reload = 30f;
            range = 200f;
            rotateSpeed = 5f;
            targetAir = true;
            targetGround = true;
            category = Category.turret;
        }};
    }}
}
