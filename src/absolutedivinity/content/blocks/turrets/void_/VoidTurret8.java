package absolutedivinity.content.blocks.turrets.void_;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.pattern.ShootSpread;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class VoidTurret8 {
    public static PowerTurret voidTurret8;

    public static void load() {{
        voidTurret8 = new PowerTurret("void-8") {{
            localizedName = "Void Lance Battery";
            description = "Fires three searing silver lances simultaneously. Overwhelms heavy targets with concentrated void energy.";
            size = 5;
            health = 5500;
            range = 400f;
            reload = 140f;
            rotateSpeed = 3f;
            shootCone = 3f;
            shoot = new ShootSpread() {{
                shots = 3;
                spread = 8f;
            }};
            targetAir = true;
            targetGround = true;
            shootEffect = ADEffects.voidChargeBig;
            heatColor = Color.white;
            consumePower(20f);
            consumeCoolant(1f);
            shootType = new LaserBulletType() {{
                damage = 450f;
                length = 420f;
                width = 40f;
                lifetime = 50f;
                pierce = true;
                pierceCap = 8;
                hitEffect = ADEffects.voidLaserHit;
                despawnEffect = ADEffects.voidDespawn;
                shootEffect = Fx.none;
                status = StatusEffects.melting;
                statusDuration = 120f;
                colors = new Color[]{
                    Color.valueOf("6068aa").a(0.3f),
                    Color.valueOf("b8c8ff"),
                    Color.white
                };
                lightColor = Color.white;
                lightOpacity = 0.7f;
                drawSize = 450f;
            }};
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
