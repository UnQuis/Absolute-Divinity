package absolutedivinity.content.blocks.turrets.chaos;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret9 {
    public static ItemTurret chaosTurret9;

    public static void load() {{
        chaosTurret9 = new ItemTurret("chaos-9") {{
            localizedName = "Chaos Turret 9";
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
