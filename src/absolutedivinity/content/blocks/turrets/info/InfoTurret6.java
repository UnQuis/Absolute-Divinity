package absolutedivinity.content.blocks.turrets.info;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret6 {
    public static ItemTurret infoTurret6;

    public static void load() {{
        infoTurret6 = new ItemTurret("info-6") {{
            localizedName = "Info Missile";
            description = "Launches precision homing missiles.";
            size = 3;
            health = 1750;
            range = 260f;
            reload = 55f;
            rotateSpeed = 5f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootMedium(ADColor.infoMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.infoDark);
            heatColor = ADColor.infoMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 260,
                Items.lead, 210,
                Items.graphite, 75,
                Items.silicon, 55,
                Items.titanium, 35
            ));
            category = Category.turret;
            ammo(Items.titanium, new MissileBulletType(4.5f, 30f) {{
                width = 8f;
                height = 8f;
                lifetime = 58f;
                hitEffect = ADTurretEffects.hitMedium(ADColor.infoMain);
                despawnEffect = ADTurretEffects.hitBig(ADColor.infoMain);
                trailEffect = ADTurretEffects.trailEffect(ADColor.infoMain);
                trailChance = 0.5f;
                frontColor = ADColor.infoLight;
                backColor = ADColor.infoMain;
                homingPower = 0.1f;
                homingRange = 140f;
                knockback = 1.2f;
                splashDamageRadius = 18f;
                splashDamage = 12f;
            }});
        }};
    }}
}
