package absolutedivinity.content.blocks.turrets.info;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret4 {
    public static ItemTurret infoTurret4;

    public static void load() {{
        infoTurret4 = new ItemTurret("info-4") {{
            localizedName = "Info Repeater";
            description = "Rapid-fire data stream.";
            size = 2;
            health = 900;
            range = 200f;
            reload = 11f;
            rotateSpeed = 9f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootSmall(ADColor.infoMain);
            smokeEffect = ADTurretEffects.shootSmall(ADColor.infoDark);
            heatColor = ADColor.infoMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 115,
                Items.lead, 95,
                Items.graphite, 38
            ));
            category = Category.turret;
            ammo(Items.graphite, new BasicBulletType(7.5f, 12f) {{
                width = 4f;
                height = 6f;
                lifetime = 27f;
                hitEffect = ADTurretEffects.hitSmall(ADColor.infoMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.infoLight);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.infoDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.infoMain);
                trailChance = 0.3f;
                frontColor = ADColor.infoLight;
                backColor = ADColor.infoMain;
                knockback = 0.3f;
            }});
            ammo(Items.silicon, new BasicBulletType(8f, 18f) {{
                width = 4f;
                height = 6f;
                lifetime = 26f;
                hitEffect = ADTurretEffects.hitSmall(ADColor.infoMain);
                despawnEffect = ADTurretEffects.hitSmall(ADColor.infoLight);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.infoDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.infoMain);
                trailChance = 0.3f;
                frontColor = ADColor.infoLight;
                backColor = ADColor.infoMain;
                knockback = 0.3f;
                homingPower = 0.03f;
                homingRange = 60f;
            }});
        }};
    }}
}
