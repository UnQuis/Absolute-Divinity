package fadingrevelations.content.blocks.turrets.item;

import arc.struct.ObjectMap;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class MineLauncherTurret {

    public static ItemTurret mineLauncher;

    public static void load(){
        mineLauncher = new ItemTurret("mine-launcher"){{
            localizedName = "Landmine Launcher";
            description = "Deploys landmines that stick to the ground for a short while. Mines explode on contact.";
            size = 3;
            health = 800;
            reload = 300f;
            range = 200f;
            minWarmup = 3f;
            shootWarmupSpeed = 0.08f;
            rotateSpeed = 5f;
            recoil = 1f;
            targetAir = false;
            targetGround = true;
            //shootSound = 
            category = Category.turret;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 180,
                Items.lead, 150,
                Items.graphite, 120,
                Items.silicon, 100
            ));

            ammoTypes = ObjectMap.of(
                Items.blastCompound, new BasicBulletType(){{
                    
                }}
            );
        }};
    }
}
