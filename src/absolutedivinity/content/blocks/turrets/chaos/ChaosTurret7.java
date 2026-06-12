package absolutedivinity.content.blocks.turrets.chaos;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret7 {
    public static ItemTurret chaosTurret7;

    public static void load() {{
        chaosTurret7 = new ItemTurret("chaos-7") {{
            localizedName = "Chaos Cannon";
            description = "Heavy fire cannon with knockback.";
            size = 3;
            health = 2200;
            range = 280f;
            reload = 80f;
            rotateSpeed = 3f;
            shootCone = 10f;
            targetAir = false;
            targetGround = true;
            shootEffect = ADTurretEffects.shootBig(ADColor.chaosMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.chaosDark);
            heatColor = ADColor.chaosMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 400,
                Items.lead, 300,
                Items.graphite, 120,
                Items.silicon, 80,
                Items.titanium, 60
            ));
            category = Category.turret;
            ammo(Items.titanium, new BasicBulletType(6f, 100f) {{
                width = 10f;
                height = 12f;
                lifetime = 48f;
                hitEffect = ADTurretEffects.hitBig(ADColor.chaosMain);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.chaosMain, 40f);
                trailEffect = ADTurretEffects.trailEffect(ADColor.chaosMain);
                trailChance = 0.8f;
                frontColor = ADColor.chaosLight;
                backColor = ADColor.chaosMain;
                knockback = 5f;
                hitShake = 6f;
                splashDamageRadius = 30f;
                splashDamage = 40f;
                lightning = 3;
                lightningDamage = 20f;
                lightningLength = 10;
                lightningColor = ADColor.chaosGlow;
            }});
        }};
    }}
}
