package absolutedivinity.content.blocks.turrets.void_;

import absolutedivinity.content.ADEffects;
import absolutedivinity.content.entities.bullet.MassiveLaserBulletType;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class VoidAnnihilator {
    public static PowerTurret voidAnnihilator;

    public static void load() {{
        voidAnnihilator = new PowerTurret("void-10") {{
            localizedName = "Void Annihilator";
            description = "The ultimate weapon of the Void faction. Channels reality-tearing energy into a beam of pure annihilation.";
            size = 8;
            health = 24000;
            armor = 15f;
            range = 580f;
            reload = 550f;
            rotateSpeed = 1f;
            shootCone = 1f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADEffects.voidAnnihilateCharge;
            heatColor = Color.white;
            consumePower(100f);
            consumeCoolant(5f);
            shootType = new MassiveLaserBulletType() {{
                damage = 12000f;
                width = 180f;
                length = 2500f;
                colors = new Color[]{
                    Color.valueOf("4040aa").a(0.3f),
                    Color.valueOf("c0d0ff"),
                    Color.white
                };
                status = StatusEffects.melting;
                statusDuration = 300f;
                lifetime = 900f;
                knockback = 60f;
                massiveBlast = ADEffects.voidAnnihilateBlast;
                chargeEffect = ADEffects.voidAnnihilateCharge;
                beamHit = ADEffects.voidLaserHit;
            }};
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
