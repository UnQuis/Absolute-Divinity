package absolutedivinity.content.blocks.turrets.power;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.TractorBeamTurret;

public class DeracinationTurret {

    public static TractorBeamTurret deracination;

    public static void load() {
        deracination = new TractorBeamTurret("big-parallax") {{
            localizedName = "Deracination";
            description = "Beams out an intense tractor beam that pulls in air targets, dealing heavy damage in the process.";
            size = 3;
            force = 20f;
            targetAir = true;
            targetGround = false;
            scaledForce = 10f;
            health = 780;
            range = 256f;
            damage = 0.6f;
            rotateSpeed = 15f;
            hasPower = true;
            consumePower(4f);
            requirements(Category.turret, ItemStack.with(
                Items.graphite, 90,
                Items.silicon, 210,
                Items.titanium, 270
            ));
            category = Category.turret;
        }};
    }
}
