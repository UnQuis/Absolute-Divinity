package absolutedivinity.content.blocks.turrets.chaos;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret7 {
    public static ItemTurret chaosTurret7;

    public static void load() {{
        chaosTurret7 = new ItemTurret("chaos-7") {{
            localizedName = "Chaos Howitzer";
            description = "Massive cannon with extreme knockback.";
            size = 3;
            health = 2200;
            range = 320f;
            reload = 100f;
            rotateSpeed = 2.5f;
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
            ammo(Items.titanium, new BasicBulletType(5f, 120f) {{
                width = 12f;
                height = 14f;
                lifetime = 65f;
                hitEffect = ADTurretEffects.hitBig(ADColor.chaosMain);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.chaosMain, 60f);
                smokeEffect = ADTurretEffects.shootBig(ADColor.chaosDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.chaosMain);
                trailChance = 0.8f;
                frontColor = ADColor.chaosLight;
                backColor = ADColor.chaosMain;
                knockback = 6f;
                hitShake = 8f;
                splashDamageRadius = 50f;
                splashDamage = 80f;
                lightning = 4;
                lightningDamage = 25f;
                lightningLength = 12;
                lightningColor = ADColor.chaosGlow;
            }});
        }};
    }}
}
