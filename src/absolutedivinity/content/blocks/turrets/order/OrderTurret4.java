package absolutedivinity.content.blocks.turrets.order;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class OrderTurret4 {
    public static ItemTurret orderTurret4;

    public static void load() {{
        orderTurret4 = new ItemTurret("order-4") {{
            localizedName = "Order Turret 4";
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
