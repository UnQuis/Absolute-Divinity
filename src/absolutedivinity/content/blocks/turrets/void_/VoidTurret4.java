package absolutedivinity.content.blocks.turrets.void_;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class VoidTurret4 {
    public static ItemTurret voidTurret4;

    public static void load() {{
        voidTurret4 = new ItemTurret("void-4") {{
            localizedName = "Void Turret 4";
            description = "[orange]Void faction[] turret. Not yet implemented.";
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
