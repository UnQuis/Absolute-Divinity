package absolutedivinity.content.blocks.turrets.item;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class UniversalTurret extends ItemTurret {
    public UniversalTurret(String name){
        super(name);

        size = 3;
        health = 1800;
        armor = 5f;
        range = 240f;
        reload = 18f;
        rotateSpeed = 12f;
        shootCone = 25f;
        inaccuracy = 3f;
        targetAir = true;
        targetGround = true;
        requirements(Category.turret, ItemStack.with(
            Items.copper, 200,
            Items.lead, 150,
            Items.silicon, 100,
            Items.titanium, 50
            //too cheap bruh
        ));
    }

    @Override
    public void init(){

    }
}
