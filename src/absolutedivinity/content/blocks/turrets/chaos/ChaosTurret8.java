package absolutedivinity.content.blocks.turrets.chaos;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret8 {
    public static ItemTurret chaosTurret8;

    public static void load() {{
        chaosTurret8 = new ItemTurret("chaos-8") {{
            localizedName = "Chaos Turret 8";
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
