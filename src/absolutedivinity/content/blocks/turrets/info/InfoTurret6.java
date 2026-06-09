package absolutedivinity.content.blocks.turrets.info;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret6 {
    public static ItemTurret infoTurret6;

    public static void load() {{
        infoTurret6 = new ItemTurret("info-6") {{
            localizedName = "Info Turret 6";
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
