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
        voidAnnihilator = new PowerTurret("void-annihilator") {{
            localizedName = "Void Annihilator";
            description = "The ultimate weapon of the Void. Channels reality-tearing energy into a beam of pure annihilation that erases everything from existence.";
            size = 13;
            health = 180000;
            armor = 25;
            range = 700f;
            reload = 600f;
            rotateSpeed = 0.5f;
            shootCone = 1f;
            targetAir = true;
            targetGround = true;
            minWarmup = 0.9f;
            shootWarmupSpeed = 0.01f;
            shootEffect = ADEffects.voidAnnihilateCharge;
            heatColor = Color.valueOf("c0d0ff");
            consumePower(200f);
            consumeCoolant(8f);
            requirements(Category.turret, ItemStack.with(
                Items.copper, 15000,
                Items.silicon, 12000,
                Items.titanium, 8000,
                Items.thorium, 5000,
                Items.surgeAlloy, 3000
            ));
            category = Category.turret;
            shootType = new MassiveLaserBulletType() {{
                damage = 25000f;
                width = 280f;
                length = 3500f;
                colors = new Color[]{
                    Color.valueOf("4040aa").a(0.4f),
                    Color.valueOf("c0d0ff"),
                    Color.white
                };
                status = StatusEffects.melting;
                statusDuration = 600f;
                lifetime = 1200f;
                knockback = 100f;
                massiveBlast = ADEffects.voidAnnihilateBlast;
                chargeEffect = ADEffects.voidAnnihilateCharge;
                beamHit = ADEffects.voidLaserHit;
            }};
        }};
    }}
}
