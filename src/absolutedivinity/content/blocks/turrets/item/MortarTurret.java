package absolutedivinity.content.blocks.turrets.item;

import arc.graphics.Color;
import arc.math.Interp;
import arc.struct.ObjectMap;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.pattern.ShootPattern;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class MortarTurret {

    public static ItemTurret mortar;

    public static void load() {
        mortar = new ItemTurret("mortar") {{
            localizedName = "Mortar";
            description = "Flings incendiary cannon shells at nearby enemies. Has a blind spot.";
            size = 3;
            category = Category.turret;
            reload = 360f;
            range = 320f;
            hasItems = true;
            itemCapacity = 20;
            minRange = 64f;
            accurateDelay = false;
            targetAir = false;
            targetGround = true;
            health = 110 * 3 * 3;
            ammoUseEffect = Fx.casing2;
            velocityRnd = 0.2f;
            recoil = 6f;
            heatColor = Color.valueOf("ff0000");
            //shootSound = Sounds.largeCannon;
            //chargeSound = Sounds.lasercharge2;
            inaccuracy = 4f;
            consumePower(4.2f);
            consumeCoolant(0.3f);
            requirements(Category.turret, ItemStack.with(
                Items.copper, 120,
                Items.lead, 100,
                Items.graphite, 50,
                Items.metaglass, 65,
                Items.titanium, 50
            ));
            shoot = new ShootPattern(){{
                firstShotDelay = 60f;
            }};

            ammoTypes = ObjectMap.of(
                Items.sporePod, new ArtilleryBulletType() {{
                    smokeEffect = Fx.shootSmokeMissile;
                    width = 30f;
                    height = 42f;
                    speed = 1.6f;
                    lifetime = 130f;
                    splashDamage = 160f;
                    sprite = "me-mortar-shell";
                    splashDamageRadius = 64f;
                    status = StatusEffects.burning;
                    statusDuration = 780f;
                    incendChance = 1f;
                    incendSpread = 4.1f;
                    incendAmount = 12;
                    makeFire = true;
                    frontColor = Color.valueOf("9e78dc");
                    backColor = Color.valueOf("5541b1");
                    hitColor = Color.valueOf("9e78dc");
                    hitEffect = new MultiEffect(
                        new ParticleEffect() {{
                            particles = 24;
                            length = -40f;
                            baseLength = 40f;
                            sizeFrom = 8f;
                            sizeTo = 2f;
                            lifetime = 68f;
                            colorFrom = Color.valueOf("9e78dc");
                            colorTo = Color.valueOf("5541b1");
                        }},
                        new WaveEffect() {{
                            sizeFrom = 2f;
                            sizeTo = 50f;
                            strokeFrom = 0f;
                            strokeTo = 3f;
                            colorFrom = Color.valueOf("9e78dc");
                            colorTo = Color.valueOf("5541b1");
                            lifetime = 34f;
                        }}
                    );
                    knockback = 0.6f;
                    //hitSound = Sounds.largeCannon;
                    chargeEffect = new MultiEffect(
                        new ParticleEffect() {{
                            particles = 20;
                            offset = 100f;
                            sizeFrom = 1f;
                            sizeTo = 6f;
                            length = 40f;
                            baseLength = -40f;
                            interp = Interp.pow3In;
                            sizeInterp = Interp.pow5Out;
                            lifetime = 45f;
                            colorFrom = Color.valueOf("9e78dc");
                            colorTo = Color.valueOf("5541b1");
                        }},
                        new WaveEffect() {{
                            lifetime = 60f;
                            sizeFrom = 50f;
                            sizeTo = 0f;
                            interp = Interp.pow5Out;
                            strokeFrom = 0f;
                            strokeTo = 4f;
                            colorFrom = Color.valueOf("9e78dc");
                            colorTo = Color.valueOf("5541b1");
                        }},
                        new WaveEffect() {{
                            lifetime = 70f;
                            sizeFrom = 60f;
                            sizeTo = 0f;
                            interp = Interp.pow10Out;
                            strokeFrom = 0f;
                            strokeTo = 4f;
                            colorFrom = Color.valueOf("9e78dc");
                            colorTo = Color.valueOf("5541b1");
                        }}
                    );
                }}
            );
        }};
    }
}
