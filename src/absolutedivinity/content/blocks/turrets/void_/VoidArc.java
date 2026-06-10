package absolutedivinity.content.blocks.turrets.void_;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class VoidArc {
    public static PowerTurret voidArc;

    public static void load() {{
        voidArc = new PowerTurret("void-2") {{
            localizedName = "Void Arc";
            description = "Emits arcing bolts of silver lightning at airborne targets.";
            size = 1;
            health = 400;
            range = 130f;
            reload = 20f;
            rotateSpeed = 12f;
            shootCone = 15f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADEffects.voidLightningHit;
            heatColor = Color.white;
            consumePower(2.5f);
            consumeCoolant(0.1f);
            shootType = new LightningBulletType() {{
                damage = 18f;
                lightningLength = 12;
                lightningColor = Color.white;
                hitEffect = ADEffects.voidLightningHit;
                shootEffect = ADEffects.voidLightningHit;
                smokeEffect = Fx.none;
                ammoMultiplier = 1f;
                collidesAir = true;
                collidesGround = true;
                lightColor = Color.white;
                lightOpacity = 0.6f;
            }};
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
