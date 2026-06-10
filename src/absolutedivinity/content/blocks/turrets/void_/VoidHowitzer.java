package absolutedivinity.content.blocks.turrets.void_;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class VoidHowitzer {
    public static PowerTurret voidHowitzer;

    public static void load() {{
        voidHowitzer = new PowerTurret("void-6") {{
            localizedName = "Void Howitzer";
            description = "Lobs silver explosive shells over terrain. Devastating area damage.";
            size = 3;
            health = 1400;
            range = 380f;
            reload = 85f;
            rotateSpeed = 3f;
            shootCone = 10f;
            targetAir = false;
            targetGround = true;
            shootEffect = ADEffects.voidShootBig;
            heatColor = Color.white;
            consumePower(7f);
            consumeCoolant(0.3f);
            shootType = new ArtilleryBulletType(4f, 280f) {{
                width = 12f;
                height = 16f;
                lifetime = 100f;
                splashDamage = 200f;
                splashDamageRadius = 55f;
                knockback = 5f;
                pierce = false;
                collidesAir = false;
                collidesGround = true;
                hitEffect = ADEffects.voidBlast;
                despawnEffect = ADEffects.voidBlast;
                shootEffect = Fx.none;
                smokeEffect = Fx.shootBigSmoke2;
                trailEffect = ADEffects.voidTrail;
                trailChance = 1f;
                trailLength = 20;
                trailWidth = 3f;
                shrinkX = 0f;
                shrinkY = 0f;
                backColor = Color.valueOf("c8d0e8");
                frontColor = Color.white;
                mixColorFrom = Color.valueOf("8898cc");
                mixColorTo = Color.white;
            }};
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
