package absolutedivinity.content.blocks.turrets.time;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret2 {
    public static ItemTurret timeTurret2;

    public static void load() {{
        timeTurret2 = new ItemTurret("time-2") {{
            localizedName = "Time Turret 2";
            description = "[orange]Time faction[] turret. Not yet implemented.";
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
