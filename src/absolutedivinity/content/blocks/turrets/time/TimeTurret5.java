package absolutedivinity.content.blocks.turrets.time;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret5 {
    public static ItemTurret timeTurret5;

    public static void load() {{
        timeTurret5 = new ItemTurret("time-5") {{
            localizedName = "Time Turret 5";
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
