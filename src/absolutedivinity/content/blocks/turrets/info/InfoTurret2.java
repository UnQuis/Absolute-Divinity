package absolutedivinity.content.blocks.turrets.info;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret2 {
    public static ItemTurret infoTurret2;

    public static void load() {{
        infoTurret2 = new ItemTurret("info-2") {{
            localizedName = "Info Tracker";
            description = "Fires homing data darts with strong tracking.";
            size = 1;
            health = 400;
            range = 175f;
            reload = 30f;
            rotateSpeed = 10f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootSmall(ADColor.infoMain);
            smokeEffect = ADTurretEffects.shootSmall(ADColor.infoDark);
            heatColor = ADColor.infoMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 46,
                Items.lead, 32
            ));
            category = Category.turret;
            ammo(Items.graphite, new BasicBulletType(5f, 14f) {{
                width = 5f;
                height = 7f;
                lifetime = 36f;
                hitEffect = ADTurretEffects.hitSmall(ADColor.infoMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.infoLight);
                trailEffect = ADTurretEffects.trailEffect(ADColor.infoMain);
                trailChance = 0.3f;
                frontColor = ADColor.infoLight;
                backColor = ADColor.infoMain;
                knockback = 0.3f;
                homingPower = 0.08f;
                homingRange = 100f;
                homingDelay = 5f;
            }});
        }};
    }}
}
