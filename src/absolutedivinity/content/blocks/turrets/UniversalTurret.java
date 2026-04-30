package absolutedivinity.content.blocks.turrets;

import mindustry.Vars;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import arc.graphics.Color;

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
            } else if (item.radioactivity > 0.1f){
                base = Color.valueOf("7aff42").lerp(Color.valueOf("c8ff80"), item.radioactivity * 0.5f);
            } else {
                base = Color.valueOf("a0b8cc");
            }

            float dmg = 45f
                + item.explosiveness * 180f
                + item.charge * 80f
                + item.radioactivity * 60f
                + item.hardness * 4f;


        });
    }
}
