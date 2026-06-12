package absolutedivinity.content.blocks.turrets.info;

import absolutedivinity.content.ADItems;
import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret10 {
    public static ItemTurret infoTurret10;

    public static void load() {{
        infoTurret10 = new ItemTurret("info-10") {{
            localizedName = "Info Annihilator";
            description = "The pinnacle of informational warfare.";
            size = 6;
            health = 13500;
            armor = 11;
            range = 380f;
            reload = 190f;
            rotateSpeed = 1.3f;
            shootCone = 5f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootBig(ADColor.infoMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.infoDark);
            heatColor = ADColor.infoMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 2900,
                Items.lead, 2300,
                Items.graphite, 750,
                Items.silicon, 580,
                Items.titanium, 480,
                Items.thorium, 300,
                Items.surgeAlloy, 180
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new BasicBulletType(7.5f, 650f) {{
                width = 16f;
                height = 20f;
                lifetime = 52f;
                hitEffect = ADTurretEffects.blastEffect(ADColor.infoMain, 80f);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.infoLight, 80f);
                smokeEffect = ADTurretEffects.shootBig(ADColor.infoDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.infoMain);
                trailChance = 1f;
                frontColor = Color.white;
                backColor = ADColor.infoMain;
                knockback = 10f;
                hitShake = 13f;
                splashDamageRadius = 65f;
                splashDamage = 280f;
                pierce = true;
                pierceArmor = true;
                pierceCap = 8;
                lightning = 8;
                lightningDamage = 45f;
                lightningLength = 18;
                lightningColor = ADColor.infoGlow;
            }});
            ammo(ADItems.divinite, new BasicBulletType(10f, 1100f) {{
                width = 20f;
                height = 24f;
                lifetime = 42f;
                hitEffect = ADTurretEffects.blastEffect(ADColor.infoMain, 100f);
                despawnEffect = ADTurretEffects.blastEffect(ADColor.infoLight, 100f);
                smokeEffect = ADTurretEffects.shootBig(ADColor.infoDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.infoMain);
                trailChance = 1f;
                frontColor = Color.white;
                backColor = ADColor.infoMain;
                knockback = 14f;
                hitShake = 17f;
                splashDamageRadius = 85f;
                splashDamage = 550f;
                pierce = true;
                pierceArmor = true;
                pierceCap = -1;
                lightning = 14;
                lightningDamage = 80f;
                lightningLength = 28;
                lightningColor = ADColor.infoGlow;
            }});
        }};
    }}
}
