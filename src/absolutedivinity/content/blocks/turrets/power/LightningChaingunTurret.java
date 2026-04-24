package absolutedivinity.content.blocks.turrets.power;

import absolutedivinity.content.ADItems;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.draw.DrawTurret;

public class LightningChaingunTurret {

    public static PowerTurret lightningChaingun;

    public static void load() {
        lightningChaingun = new PowerTurret("lightning-chaingun") {{
            localizedName = "Lightning Chaingun";
            description = "Gradually escalates in firerate, decimating enemies with a flurry of lasers.";
            health = 5400;
            consumePower(80f);
            consumeCoolant(2f);
            coolantMultiplier = 0.1f;
            size = 6;
            reload = 6f;
            range = 400f;
            minWarmup = 0.75f;
            shootY = 20f;
            shootWarmupSpeed = 0.005f;
            warmupMaintainTime = 60f;
            recoil = 0.5f;
            recoilTime = 40f;
            shake = 2f;
            inaccuracy = 5f;
            recoils = 2;
            //shootSound = Sounds.malignShoot;
            //loopSound = Sounds.spellLoop;
            loopSoundVolume = 1.3f;
            category = Category.turret;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 2400,
                Items.graphite, 1950,
                Items.silicon, 1800,
                ADItems.cryogenicAlloy, 500 // placeholder
            ));
            shoot = new ShootAlternate() {{
                shots = 2;
                spread = 14f;
                shotDelay = 8f;
            }};
            shootType = new BasicBulletType(16f, 120f) {{
                width = 12f;
                height = 72f;
                backColor = Color.valueOf("a9d8ff");
                frontColor = Color.valueOf("ffffff");
                mixColorFrom = Color.valueOf("a9d8ff");
                mixColorTo = Color.valueOf("ffffff");
                lifetime = 25f;
                pierce = true;
                pierceBuilding = true;
                shootEffect = Fx.shootBigColor;
                smokeEffect = Fx.shootSmokeSquareSparse;
                homingPower = 0.078f;
                homingDelay = 60f;
                hitEffect = Fx.none;
                despawnEffect = Fx.none;
            }};
            drawer = new DrawTurret() {{
                parts.add(new RegionPart() {{
                    suffix = "-top";
                    mirror = false;
                    under = false;
                    progress = PartProgress.recoil;
                    heatProgress = PartProgress.recoil;
                    heatColor = Color.valueOf("ffffff4D");
                }});
                parts.add(new RegionPart() {{
                    suffix = "-barrel";
                    progress = PartProgress.recoil;
                    heatProgress = PartProgress.recoil;
                    under = true;
                    mirror = true;
                    moveY = -4f;
                    heatColor = Color.valueOf("ffffff4D");
                }});
                parts.add(new RegionPart() {{
                    suffix = "-wing-1";
                    mirror = true;
                    under = true;
                    progress = PartProgress.warmup;
                    moveRot = 40f;
                    moveX = 9f;
                    moveY = -5f;
                }});
                parts.add(new RegionPart() {{
                    suffix = "-wing-2";
                    mirror = true;
                    under = true;
                    progress = PartProgress.warmup;
                    moveRot = 40f;
                    moveX = 10f;
                }});
            }};
        }};
    }
}
