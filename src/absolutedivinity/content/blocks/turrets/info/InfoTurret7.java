package absolutedivinity.content.blocks.turrets.info;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret7 {
    public static ItemTurret infoTurret7;

    public static void load() {{
        infoTurret7 = new ItemTurret("info-7") {{
            localizedName = "Info Turret 7";
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
