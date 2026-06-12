package absolutedivinity.content.blocks.turrets.info;

import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import mindustry.content.Items;
import mindustry.entities.bullet.ContinuousFlameBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoTurret9 {
    public static ItemTurret infoTurret9;

    public static void load() {{
        infoTurret9 = new ItemTurret("info-9") {{
            localizedName = "Info Beam";
            description = "Continuous precision beam.";
            size = 4;
            health = 5000;
            range = 270f;
            reload = 5f;
            rotateSpeed = 4.5f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADTurretEffects.shootBig(ADColor.infoMain);
            smokeEffect = ADTurretEffects.shootBig(ADColor.infoDark);
            heatColor = ADColor.infoMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 1100,
                Items.lead, 850,
                Items.graphite, 300,
                Items.silicon, 220,
                Items.titanium, 180,
                Items.thorium, 120,
                Items.surgeAlloy, 70
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new ContinuousFlameBulletType() {{
                damage = 42f;
                length = 250f;
                hitEffect = ADTurretEffects.hitMedium(ADColor.infoMain);
                smokeEffect = ADTurretEffects.trailEffect(ADColor.infoDark);
                shootEffect = ADTurretEffects.trailEffect(ADColor.infoMain);
                pierce = true;
                pierceCap = -1;
                hittable = false;
                collides = false;
                keepVelocity = false;
            }});
        }};
    }}
}
