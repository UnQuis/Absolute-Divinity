package absolutedivinity.content.blocks.turrets.void_;

import absolutedivinity.content.ADEffects;
import absolutedivinity.content.entities.bullet.ChainBulletType;
import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class VoidReaper {
    public static PowerTurret voidReaper;

    public static void load() {{
        voidReaper = new PowerTurret("void-3") {{
            localizedName = "Void Reaper";
            description = "Fires a helix-shaped bolt of void energy that chains between enemies.";
            size = 2;
            health = 850;
            range = 210f;
            reload = 35f;
            rotateSpeed = 8f;
            shootCone = 8f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADEffects.voidShoot;
            heatColor = Color.white;
            consumePower(4f);
            consumeCoolant(0.2f);
            shootType = new ChainBulletType(85f, 0.7f, Color.valueOf("c0d0ff")) {{
                bulletColor = Color.valueOf("e0e8ff");
                maxChain = 4;
                chainRange = 120f;
                chainDamage = 50f;
                helixWidth = 2.5f;
                helixRadius = 8f;
            }};
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
