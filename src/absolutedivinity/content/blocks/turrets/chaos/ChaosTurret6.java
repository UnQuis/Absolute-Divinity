package absolutedivinity.content.blocks.turrets.chaos;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret6 {
    public static ItemTurret chaosTurret6;

    public static void load() {{
        chaosTurret6 = new ItemTurret("chaos-6") {{
            localizedName = "Chaos Turret 6";
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
