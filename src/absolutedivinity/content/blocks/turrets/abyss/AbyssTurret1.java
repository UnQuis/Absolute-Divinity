package absolutedivinity.content.blocks.turrets.abyss;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret1 {
    public static ItemTurret abyssTurret1;

    public static void load() {{
        abyssTurret1 = new ItemTurret("abyss-1") {{
            localizedName = "Abyss Turret 1";
            description = "[orange]Abyss faction[] turret. Not yet implemented.";
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
