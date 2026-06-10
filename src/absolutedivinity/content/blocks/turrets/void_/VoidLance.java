package absolutedivinity.content.blocks.turrets.void_;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.pattern.ShootPattern;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class VoidLance {
    public static PowerTurret voidLance;

    public static void load() {{
        voidLance = new PowerTurret("void-5") {{
            localizedName = "Void Lance";
            description = "Projects a continuous beam of concentrated void energy. Melts through armor over time.";
            size = 3;
            health = 1600;
            range = 270f;
            reload = 70f;
            rotateSpeed = 4f;
            shootCone = 2f;
            targetAir = true;
            targetGround = true;
            shoot = new ShootPattern() {{
                firstShotDelay = 40f;
            }};
            shootEffect = Fx.shootBig;
            heatColor = Color.white;
            consumePower(8f);
            consumeCoolant(0.4f);
            shootType = new LaserBulletType() {{
                damage = 180f;
                length = 280f;
                width = 24f;
                lifetime = 60f;
                pierce = true;
                pierceCap = 5;
                chargeEffect = ADEffects.voidCharge;
                hitEffect = ADEffects.voidLaserHit;
                despawnEffect = ADEffects.voidDespawn;
                shootEffect = Fx.none;
                status = StatusEffects.melting;
                statusDuration = 60f;
                colors = new Color[]{
                    Color.valueOf("8088aa").a(0.3f),
                    Color.valueOf("c8d0ff"),
                    Color.white
                };
                lightColor = Color.white;
                lightOpacity = 0.5f;
                drawSize = 300f;
            }};
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
