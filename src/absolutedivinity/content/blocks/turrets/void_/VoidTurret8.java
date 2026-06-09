package absolutedivinity.content.blocks.turrets.void_;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class VoidTurret8 {
    public static ItemTurret voidTurret8;

    public static void load() {{
        voidTurret8 = new ItemTurret("void-8") {{
            localizedName = "Void Turret 8";
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
