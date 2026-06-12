package absolutedivinity.content.blocks.turrets.time;

import absolutedivinity.content.ADItems;
import arc.graphics.Color;
import mindustry.content.Fx;
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
            description = "The ultimate temporal weapon. Fires a projectile that freezes time itself around the impact zone.";
            size = 6;
            health = 13000;
            armor = 10;
            range = 360f;
            reload = 220f;
            rotateSpeed = 1.2f;
            shootCone = 5f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
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
                hitEffect = Fx.massiveExplosion;
                despawnEffect = Fx.massiveExplosion;
                smokeEffect = Fx.shootSmokeTitan;
                frontColor = Color.white;
                backColor = Color.valueOf("4488aa");
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
                lightningColor = Color.valueOf("88ccff");
                status = StatusEffects.freezing;
                statusDuration = 600f;
            }});
            ammo(ADItems.divinite, new BasicBulletType(9f, 1200f) {{
                width = 22f;
                height = 26f;
                lifetime = 45f;
                hitEffect = Fx.massiveExplosion;
                despawnEffect = Fx.massiveExplosion;
                smokeEffect = Fx.shootSmokeTitan;
                frontColor = Color.white;
                backColor = ADItems.divinite.color;
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
                lightningColor = ADItems.divinite.color;
                status = StatusEffects.freezing;
                statusDuration = 900f;
            }});
        }};
    }}
}
