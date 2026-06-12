package absolutedivinity.content.blocks.turrets.chaos;

import absolutedivinity.content.ADItems;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret10 {
    public static ItemTurret chaosTurret10;

    public static void load() {{
        chaosTurret10 = new ItemTurret("chaos-10") {{
            localizedName = "Chaos Obliterator";
            description = "The ultimate expression of chaos. Fires a world-ending projectile that tears reality apart.";
            size = 6;
            health = 14000;
            armor = 12;
            range = 380f;
            reload = 240f;
            rotateSpeed = 1f;
            shootCone = 5f;
            targetAir = true;
            targetGround = true;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 3000,
                Items.lead, 2500,
                Items.graphite, 800,
                Items.silicon, 600,
                Items.titanium, 500,
                Items.thorium, 300,
                Items.surgeAlloy, 200
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new BasicBulletType(7f, 600f) {{
                width = 18f;
                height = 22f;
                lifetime = 55f;
                hitEffect = Fx.massiveExplosion;
                despawnEffect = Fx.massiveExplosion;
                smokeEffect = Fx.shootSmokeTitan;
                frontColor = Color.white;
                backColor = Color.valueOf("ff6b6b");
                knockback = 10f;
                hitShake = 14f;
                splashDamageRadius = 70f;
                splashDamage = 300f;
                pierce = true;
                pierceArmor = true;
                pierceCap = -1;
                lightning = 10;
                lightningDamage = 60f;
                lightningLength = 25;
                lightningColor = Color.valueOf("ff6b6b");
                status = mindustry.content.StatusEffects.burning;
                statusDuration = 300f;
            }});
            ammo(ADItems.divinite, new BasicBulletType(9f, 1000f) {{
                width = 22f;
                height = 26f;
                lifetime = 48f;
                hitEffect = Fx.massiveExplosion;
                despawnEffect = Fx.massiveExplosion;
                smokeEffect = Fx.shootSmokeTitan;
                frontColor = Color.white;
                backColor = ADItems.divinite.color;
                knockback = 14f;
                hitShake = 18f;
                splashDamageRadius = 90f;
                splashDamage = 500f;
                pierce = true;
                pierceArmor = true;
                pierceCap = -1;
                lightning = 16;
                lightningDamage = 100f;
                lightningLength = 35;
                lightningColor = ADItems.divinite.color;
                status = mindustry.content.StatusEffects.melting;
                statusDuration = 600f;
            }});
        }};
    }}
}
