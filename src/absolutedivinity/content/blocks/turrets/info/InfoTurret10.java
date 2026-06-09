package absolutedivinity.content.blocks.turrets.info;

import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret10 {
    public static ItemTurret infoTurret10;

    public static void load() {{
        infoTurret10 = new ItemTurret("info-10") {{
            localizedName = "Info Turret 10";
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
