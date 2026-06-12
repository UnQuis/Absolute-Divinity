package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADItems;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret10 {
    public static ItemTurret abyssTurret10;

    public static void load() {{
        abyssTurret10 = new ItemTurret("abyss-10") {{
            localizedName = "Abyss Annihilator";
            description = "The apex of abyssal weaponry. Launches devastating salvos that obliterate everything in their path.";
            size = 6;
            health = 12000;
            armor = 10;
            range = 400f;
            reload = 200f;
            rotateSpeed = 1.5f;
            shootCone = 5f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 2500,
                Items.lead, 2000,
                Items.graphite, 600,
                Items.silicon, 500,
                Items.titanium, 400,
                Items.thorium, 250,
                Items.surgeAlloy, 150
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new BasicBulletType(6f, 500f) {{
                width = 16f;
                height = 20f;
                lifetime = 70f;
                hitEffect = Fx.massiveExplosion;
                despawnEffect = Fx.massiveExplosion;
                smokeEffect = Fx.shootSmokeTitan;
                frontColor = Color.white;
                backColor = Items.surgeAlloy.color;
                knockback = 8f;
                hitShake = 12f;
                splashDamageRadius = 60f;
                splashDamage = 200f;
                pierce = true;
                pierceArmor = true;
                pierceCap = 8;
                lightning = 8;
                lightningDamage = 50f;
                lightningLength = 20;
                lightningColor = Color.valueOf("f3e979");
                status = mindustry.content.StatusEffects.shocked;
                statusDuration = 120f;
            }});
            ammo(ADItems.divinite, new BasicBulletType(8f, 800f) {{
                width = 20f;
                height = 24f;
                lifetime = 55f;
                hitEffect = Fx.massiveExplosion;
                despawnEffect = Fx.massiveExplosion;
                smokeEffect = Fx.shootSmokeTitan;
                frontColor = Color.white;
                backColor = ADItems.divinite.color;
                knockback = 12f;
                hitShake = 16f;
                splashDamageRadius = 80f;
                splashDamage = 400f;
                pierce = true;
                pierceArmor = true;
                pierceCap = -1;
                lightning = 12;
                lightningDamage = 80f;
                lightningLength = 30;
                lightningColor = ADItems.divinite.color;
                status = mindustry.content.StatusEffects.melting;
                statusDuration = 300f;
            }});
        }};
    }}
}
