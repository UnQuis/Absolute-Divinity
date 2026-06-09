package absolutedivinity.content.blocks.turrets.void_;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class VoidTurret1 {
    public static PowerTurret voidTurret1;

    public static void load() {{
        voidTurret1 = new PowerTurret("void-1") {{
            localizedName = "Void Dart";
            description = "Rapid-fires small silver energy darts. Excels at picking off weak targets.";
            size = 1;
            health = 350;
            range = 155f;
            reload = 5f;
            rotateSpeed = 15f;
            shootCone = 5f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADEffects.voidShootSmall;
            heatColor = Color.white;
            consumePower(1.5f);
            coolantMultiplier = 0.5f;
            shootType = new BasicBulletType(8f, 12f) {{
                width = 3f;
                height = 5f;
                lifetime = 20f;
                despawnEffect = Fx.none;
                hitEffect = ADEffects.voidHitSmall;
                shootEffect = ADEffects.voidShootSmall;
                smokeEffect = Fx.none;
                trailEffect = ADEffects.voidTrail;
                trailChance = 0.3f;
                trailLength = 5;
                trailWidth = 1.2f;
                pierce = false;
                knockback = 0.5f;
                backColor = Color.valueOf("e0e4f0");
                frontColor = Color.white;
                mixColorFrom = Color.valueOf("c8d0ff");
                mixColorTo = Color.white;
            }};
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
