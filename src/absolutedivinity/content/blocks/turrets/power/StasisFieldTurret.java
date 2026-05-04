package absolutedivinity.content.blocks.turrets.power;

import absolutedivinity.content.ADStatusEffects;
import absolutedivinity.content.ADItems;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.WaveEffect;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class StasisFieldTurret {

    public static PowerTurret stasisField;

    public static void load() {
        stasisField = new PowerTurret("stasis-field") {{
            localizedName = "Stasis Field";
            description = "Generates a vast shockwave that cripples all nearby enemies with debilitating electric shocks.";
            range = 680f;
            canOverdrive = false;
            shootY = 0f;
            reload = 60f;
            consumePower(7.5f);
            rotate = false;
            rotateSpeed = 0f;
            shootCone = 360f;
            recoil = 0f;
            size = 3;
            ammoUseEffect = Fx.none;
            category = Category.turret;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 300,
                Items.lead, 250,
                Items.graphite, 200,
                Items.silicon, 150,
                ADItems.livingSteelHard, 100
            ));
            shootType = new BasicBulletType(0f, 0f) {{
                instantDisappear = true;
                damage = 0f;
                splashDamage = 2f;
                splashDamageRadius = 680f;
                status = ADStatusEffects.shockslowed;
                statusDuration = 70f;
            }};
            shootEffect = new WaveEffect() {{
                sizeFrom = 0f;
                sizeTo = 960f;
                strokeFrom = 1.2f;
                strokeTo = 1.6f;
                colorFrom = Color.valueOf("e5ed2c");
                colorTo = Color.valueOf("cfd712");
                lifetime = 45f;
            }};
        }};
    }
}
