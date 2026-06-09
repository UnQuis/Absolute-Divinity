package absolutedivinity.content.blocks.turrets.time;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret1 {
    public static ItemTurret timeTurret1;

    public static void load() {{
        timeTurret1 = new ItemTurret("time-1") {{
            localizedName = "Time Turret 1";
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
