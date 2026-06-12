package absolutedivinity.content.blocks.turrets.info;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret5 {
    public static ItemTurret infoTurret5;

    public static void load() {{
        infoTurret5 = new ItemTurret("info-5") {{
            localizedName = "Info Lance";
            description = "Fires precise piercing bolts.";
            size = 3;
            health = 1550;
            range = 230f;
            reload = 42f;
            rotateSpeed = 6f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootMedium(ADColor.infoMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.infoDark);
            heatColor = ADColor.infoMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 210,
                Items.lead, 170,
                Items.graphite, 65,
                Items.silicon, 45
            ));
            category = Category.turret;
            ammo(Items.silicon, new BasicBulletType(11f, 40f) {{
                width = 6f;
                height = 13f;
                lifetime = 21f;
                hitEffect = ADTurretEffects.hitMedium(ADColor.infoMain);
                despawnEffect = ADTurretEffects.hitBig(ADColor.infoMain);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.infoDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.infoMain);
                trailChance = 0.5f;
                frontColor = ADColor.infoLight;
                backColor = ADColor.infoMain;
                pierce = true;
                pierceCap = 4;
                pierceArmor = true;
                knockback = 2f;
                hitShake = 3f;
            }});
        }};
    }}
}
