package absolutedivinity.content.blocks.turrets.item;

import mindustry.Vars;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import arc.graphics.Color;

import java.awt.*;

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
        super.init();

        Vars.content.items().each(item -> {
            Color base;
            if (item.flammability > item.charge && item.flammability > item.radioactivity){
                base = Color.valueOf("ff8c42");
            } else if (item.charge > item.radioactivity && item.charge > 0.05f){
                base = Color.valueOf("42c5ff").lerp(Color.valueOf("bf92f9"), item.charge * 0.6f);
            }
        });
    }
}
