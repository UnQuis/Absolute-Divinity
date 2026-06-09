package absolutedivinity.content.blocks.turrets.info;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret4 {
    public static ItemTurret infoTurret4;

    public static void load() {{
        infoTurret4 = new ItemTurret("info-4") {{
            localizedName = "Info Turret 4";
            description = "[orange]Info faction[] turret. Not yet implemented.";
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
