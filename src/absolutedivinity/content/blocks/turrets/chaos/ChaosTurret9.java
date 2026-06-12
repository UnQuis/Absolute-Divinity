package absolutedivinity.content.blocks.turrets.chaos;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChaosTurret9 {
    public static ItemTurret chaosTurret9;

    public static void load() {{
        chaosTurret9 = new ItemTurret("chaos-9") {{
            localizedName = "Chaos Lance";
            description = "Fires a devastating beam of chaotic energy.";
            size = 4;
            health = 4500;
            range = 280f;
            reload = 60f;
            rotateSpeed = 3f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootBig(ADColor.chaosMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.chaosDark);
            heatColor = ADColor.chaosMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 900,
                Items.lead, 700,
                Items.graphite, 250,
                Items.silicon, 180,
                Items.titanium, 150,
                Items.thorium, 100,
                Items.surgeAlloy, 50
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new BasicBulletType(16f, 150f) {{
                width = 8f;
                height = 18f;
                lifetime = 18f;
                hitEffect = ADTurretEffects.hitBig(ADColor.chaosMain);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.chaosMain, 50f);
                smokeEffect = ADTurretEffects.shootBig(ADColor.chaosDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.chaosMain);
                trailChance = 0.8f;
                frontColor = Color.white;
                backColor = ADColor.chaosMain;
                pierce = true;
                pierceCap = -1;
                pierceArmor = true;
                knockback = 4f;
                hitShake = 6f;
            }});
        }};
    }}
}
