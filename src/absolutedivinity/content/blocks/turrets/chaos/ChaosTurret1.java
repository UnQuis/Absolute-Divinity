package absolutedivinity.content.blocks.turrets.chaos;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret1 {
    public static ItemTurret chaosTurret1;

    public static void load() {{
        chaosTurret1 = new ItemTurret("chaos-1") {{
            localizedName = "Chaos Turret 1";
            description = "[orange]Chaos faction[] turret. Not yet implemented.";
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
