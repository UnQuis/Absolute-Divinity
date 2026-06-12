package absolutedivinity.content.blocks.turrets.time;

import absolutedivinity.content.ADItems;
import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class TimeTurret10 {
    public static ItemTurret timeTurret10;

    public static void load() {{
        timeTurret10 = new ItemTurret("time-10") {{
            localizedName = "Chrono Obliterator";
            description = "The ultimate temporal weapon.";
            size = 6;
            health = 13000;
            armor = 10;
            range = 360f;
            reload = 220f;
            rotateSpeed = 1.2f;
            shootCone = 5f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootBig(ADColor.timeMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.timeDark);
            heatColor = ADColor.timeMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 2800,
                Items.lead, 2200,
                Items.graphite, 700,
                Items.silicon, 550,
                Items.titanium, 450,
                Items.thorium, 280,
                Items.surgeAlloy, 170
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new BasicBulletType(7f, 700f) {{
                width = 18f;
                height = 22f;
                lifetime = 55f;
                hitEffect = ADTurretEffects.blastEffect(ADColor.timeMain, 90f);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.timeLight, 90f);
                smokeEffect = ADTurretEffects.shootBig(ADColor.timeDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.timeMain);
                trailChance = 1f;
                frontColor = Color.white;
                backColor = ADColor.timeMain;
                knockback = 12f;
                hitShake = 15f;
                splashDamageRadius = 75f;
                splashDamage = 350f;
                pierce = true;
                pierceArmor = true;
                pierceCap = -1;
                lightning = 8;
                lightningDamage = 40f;
                lightningLength = 20;
                lightningColor = ADColor.timeGlow;
                status = StatusEffects.freezing;
                statusDuration = 600f;
            }});
            ammo(ADItems.divinite, new BasicBulletType(9f, 1200f) {{
                width = 22f;
                height = 26f;
                lifetime = 45f;
                hitEffect = ADTurretEffects.blastEffect(ADColor.timeMain, 110f);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.timeLight, 110f);
                smokeEffect = ADTurretEffects.shootBig(ADColor.timeDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.timeMain);
                trailChance = 1f;
                frontColor = Color.white;
                backColor = ADColor.timeMain;
                knockback = 16f;
                hitShake = 20f;
                splashDamageRadius = 90f;
                splashDamage = 600f;
                pierce = true;
                pierceArmor = true;
                pierceCap = -1;
                lightning = 14;
                lightningDamage = 80f;
                lightningLength = 30;
                lightningColor = ADColor.timeGlow;
                status = StatusEffects.freezing;
                statusDuration = 900f;
            }});
        }};
    }}
}
