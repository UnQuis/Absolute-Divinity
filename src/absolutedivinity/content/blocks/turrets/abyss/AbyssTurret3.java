package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADEffects;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssTurret3 {
    public static ItemTurret abyssTurret3;

    public static void load() {{
        abyssTurret3 = new ItemTurret("abyss-3") {{
            localizedName = "Abyss Fang";
            description = "Rapidly spits acidic globs that slow targets on hit.";
            size = 2;
            health = 720;
            range = 190f;
            reload = 18f;
            rotateSpeed = 9f;
            targetAir = false;
            targetGround = true;
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.shootSmallSmoke;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 80,
                Items.lead, 50,
                Items.graphite, 20
            ));
            category = Category.turret;
            ammo(Items.graphite, new BasicBulletType(6f, 18f) {{
                width = 6f;
                height = 8f;
                lifetime = 32f;
                hitEffect = Fx.hitBulletSmall;
                despawnEffect = Fx.titanExplosionSmall;
                smokeEffect = Fx.shootSmallSmoke;
                frontColor = Items.graphite.color;
                backColor = Items.graphite.color;
                knockback = 0.5f;
                status = mindustry.content.StatusEffects.slow;
                statusDuration = 60f;
            }});
            ammo(Items.silicon, new BasicBulletType(7f, 25f) {{
                width = 6f;
                height = 8f;
                lifetime = 30f;
                hitEffect = Fx.hitBulletSmall;
                despawnEffect = Fx.titanExplosionSmall;
                smokeEffect = Fx.shootSmallSmoke;
                frontColor = Items.silicon.color;
                backColor = Items.silicon.color;
                knockback = 0.5f;
                pierce = true;
                pierceCap = 2;
                status = mindustry.content.StatusEffects.slow;
                statusDuration = 60f;
            }});
        }};
    }}
}
