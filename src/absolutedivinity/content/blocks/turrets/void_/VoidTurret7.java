package absolutedivinity.content.blocks.turrets.void_;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class VoidTurret7 {
    public static ItemTurret voidTurret7;

    public static void load() {{
        voidTurret7 = new ItemTurret("void-7") {{
            localizedName = "Void Turret 7";
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
