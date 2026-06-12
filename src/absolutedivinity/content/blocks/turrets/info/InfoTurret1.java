package absolutedivinity.content.blocks.turrets.info;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret1 {
    public static ItemTurret infoTurret1;

    public static void load() {{
        infoTurret1 = new ItemTurret("info-1") {{
            localizedName = "Info Scanner";
            description = "Fires precision data bolts.";
            size = 1;
            health = 330;
            range = 160f;
            reload = 36f;
            rotateSpeed = 11f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootSmall(ADColor.infoMain);
            smokeEffect = ADTurretEffects.shootSmall(ADColor.infoDark);
            heatColor = ADColor.infoMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 36,
                Items.lead, 22
            ));
            category = Category.turret;
            ammo(Items.lead, new BasicBulletType(5f, 10f) {{
                width = 4f;
                height = 6f;
                lifetime = 33f;
                hitEffect = ADTurretEffects.hitSmall(ADColor.infoMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.infoLight);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.infoDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.infoMain);
                trailChance = 0.3f;
                frontColor = ADColor.infoLight;
                backColor = ADColor.infoMain;
                knockback = 0.2f;
            }});
        }};
    }}
}
