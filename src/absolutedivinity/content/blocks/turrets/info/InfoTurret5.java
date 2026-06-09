package absolutedivinity.content.blocks.turrets.info;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret5 {
    public static ItemTurret infoTurret5;

    public static void load() {{
        infoTurret5 = new ItemTurret("info-5") {{
            localizedName = "Info Turret 5";
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
