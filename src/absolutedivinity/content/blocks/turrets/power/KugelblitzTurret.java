package absolutedivinity.content.blocks.turrets.power;

import arc.graphics.Color;
import arc.math.Interp;
import arc.struct.ObjectMap;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.pattern.ShootPattern;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class KugelblitzTurret {

    public static ItemTurret kugelblitz;

    public static void load() {
        kugelblitz = new ItemTurret("kugelblitz") {{
            localizedName = "Kugelblitz";
            description = "Launches powerful lightning orbs via supercharging of metal.";
            size = 3;
            scaledHealth = 125;
            hasPower = true;
            moveWhileCharging = false;
            targetAir = false;
            reload = 600f;
            accurateDelay = false;
            shoot = new ShootPattern() {{
                firstShotDelay = 120f;
            }};
            range = 208f;
            //shootSound = Sounds.cannon;
            //chargeSound = Sounds.energyCharge;
            consumeCoolant(0.3f);
            consumePower(7f);
            category = Category.turret;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 210,
                Items.lead, 180,
                Items.graphite, 110,
                Items.metaglass, 90,
                Items.silicon, 80,
                Items.titanium, 65
            ));
            ammoTypes = ObjectMap.of(
                Items.titanium, new BasicBulletType(0.5f, 14f) {{
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
                            lifetime = 110f;
                            colorFrom = Color.valueOf("a4b8fa");
                            colorTo = Color.valueOf("7575c8");
                        }},
                        new WaveEffect() {{
                            lifetime = 140f;
                            sizeFrom = 50f;
                            sizeTo = 0f;
                            interp = Interp.pow5Out;
                            strokeFrom = 0f;
                            strokeTo = 4f;
                            colorFrom = Color.valueOf("a4b8fa");
                            colorTo = Color.valueOf("7575c8");
                        }},
                        new WaveEffect() {{
                            lifetime = 150f;
                            sizeFrom = 60f;
                            sizeTo = 0f;
                            interp = Interp.pow10Out;
                            strokeFrom = 0f;
                            strokeTo = 4f;
                            colorFrom = Color.valueOf("a4b8fa");
                            colorTo = Color.valueOf("7575c8");
                        }}
                    );
                    smokeEffect = Fx.shootSmokeTitan;
                    hitColor = Color.valueOf("7575c8");
                    sprite = "large-orb";
                    trailEffect = Fx.missileTrail;
                    trailInterval = 3f;
                    trailParam = 4f;
                    damage = 14f;
                    pierce = true;
                    pierceBuilding = true;
                    buildingDamageMultiplier = 0.4f;
                    pierceCap = 30;
                    lifetime = 420f;
                    width = 36f;
                    height = 36f;
                    backColor = Color.valueOf("7575c8");
                    frontColor = Color.valueOf("a4b8fa");
                    shrinkX = 0f;
                    shrinkY = 0f;
                    trailColor = Color.valueOf("7575c8");
                    trailLength = 12;
                    trailWidth = 2.2f;
                    despawnEffect = new ExplosionEffect() {{
                        waveColor = Color.valueOf("7575c8");
                        smokeColor = Color.valueOf("7575c8");
                        sparkColor = Color.valueOf("a4b8fa");
                        waveStroke = 3f;
                        waveRad = 30f;
                    }};
                    hitEffect = new ExplosionEffect() {{
                        waveColor = Color.valueOf("7575c8");
                        smokeColor = Color.valueOf("7575c8");
                        sparkColor = Color.valueOf("a4b8fa");
                        waveStroke = 4f;
                        waveRad = 40f;
                    }};
                    //despawnSound = Sounds.spark;
                    //hitSound = Sounds.spark;
                    intervalBullet = new LightningBulletType() {{
                        damage = 2f;
                        lightningLength = 14;
                        //hitSound = Sounds.spark;
                        //despawnSound = Sounds.spark;
                        lightningColor = Color.valueOf("7575c8");
                    }};
                    bulletInterval = 2f;
                    intervalRandomSpread = 360f;
                    intervalBullets = 4;
                    intervalAngle = 360f;
                    intervalSpread = 300f;
                }},
                Items.plastanium, new BasicBulletType(0.5f, 14f) {{
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
                            lifetime = 110f;
                            colorFrom = Color.valueOf("edf3a9");
                            colorTo = Color.valueOf("9cb664");
                        }},
                        new WaveEffect() {{
                            lifetime = 140f;
                            sizeFrom = 50f;
                            sizeTo = 0f;
                            interp = Interp.pow5Out;
                            strokeFrom = 0f;
                            strokeTo = 4f;
                            colorFrom = Color.valueOf("edf3a9");
                            colorTo = Color.valueOf("9cb664");
                        }},
                        new WaveEffect() {{
                            lifetime = 150f;
                            sizeFrom = 60f;
                            sizeTo = 0f;
                            interp = Interp.pow10Out;
                            strokeFrom = 0f;
                            strokeTo = 4f;
                            colorFrom = Color.valueOf("edf3a9");
                            colorTo = Color.valueOf("9cb664");
                        }}
                    );
                    smokeEffect = Fx.shootSmokeTitan;
                    hitColor = Color.valueOf("9cb664");
                    sprite = "large-orb";
                    trailEffect = Fx.missileTrail;
                    trailInterval = 3f;
                    trailParam = 4f;
                    pierce = true;
                    pierceBuilding = true;
                    buildingDamageMultiplier = 0.4f;
                    pierceCap = 30;
                    lifetime = 420f;
                    width = 36f;
                    height = 36f;
                    backColor = Color.valueOf("9cb664");
                    frontColor = Color.valueOf("edf3a9");
                    shrinkX = 0f;
                    shrinkY = 0f;
                    trailColor = Color.valueOf("9cb664");
                    trailLength = 12;
                    trailWidth = 2.2f;
                    despawnEffect = new ExplosionEffect() {{
                        waveColor = Color.valueOf("9cb664");
                        smokeColor = Color.valueOf("9cb664");
                        sparkColor = Color.valueOf("edf3a9");
                        waveStroke = 3f;
                        waveRad = 30f;
                    }};
                    hitEffect = new ExplosionEffect() {{
                        waveColor = Color.valueOf("9cb664");
                        smokeColor = Color.valueOf("9cb664");
                        sparkColor = Color.valueOf("edf3a9");
                        waveStroke = 4f;
                        waveRad = 40f;
                    }};
                    //despawnSound = Sounds.spark;
                    //hitSound = Sounds.spark;
                    intervalBullet = new LightningBulletType() {{
                        damage = 10f;
                        lightningLength = 14;
                        //hitSound = Sounds.spark;
                        //despawnSound = Sounds.spark;
                        lightningColor = Color.valueOf("9cb664");
                    }};
                    bulletInterval = 3f;
                    intervalRandomSpread = 360f;
                    intervalBullets = 3;
                    intervalAngle = 360f;
                    intervalSpread = 300f;
                }},
                Items.surgeAlloy, new BasicBulletType(0.5f, 17f) {{
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
                            lifetime = 110f;
                            colorFrom = Color.valueOf("f3e979");
                            colorTo = Color.valueOf("ffffff");
                        }},
                        new WaveEffect() {{
                            lifetime = 140f;
                            sizeFrom = 50f;
                            sizeTo = 0f;
                            interp = Interp.pow5Out;
                            strokeFrom = 0f;
                            strokeTo = 4f;
                            colorFrom = Color.valueOf("f3e979");
                            colorTo = Color.valueOf("ffffff");
                        }},
                        new WaveEffect() {{
                            lifetime = 150f;
                            sizeFrom = 60f;
                            sizeTo = 0f;
                            interp = Interp.pow10Out;
                            strokeFrom = 0f;
                            strokeTo = 4f;
                            colorFrom = Color.valueOf("f3e979");
                            colorTo = Color.valueOf("ffffff");
                        }}
                    );
                    smokeEffect = Fx.shootSmokeTitan;
                    hitColor = Color.valueOf("f3e979");
                    sprite = "large-orb";
                    trailEffect = Fx.missileTrail;
                    trailInterval = 3f;
                    trailParam = 4f;
                    damage = 17f;
                    pierce = true;
                    pierceBuilding = true;
                    buildingDamageMultiplier = 0.4f;
                    pierceCap = 40;
                    lifetime = 420f;
                    width = 36f;
                    height = 36f;
                    backColor = Color.valueOf("f3e979");
                    frontColor = Color.valueOf("ffffff");
                    shrinkX = 0f;
                    shrinkY = 0f;
                    trailColor = Color.valueOf("f3e979");
                    trailLength = 12;
                    trailWidth = 2.2f;
                    despawnEffect = new ExplosionEffect() {{
                        waveColor = Color.valueOf("f3e979");
                        smokeColor = Color.valueOf("f3e979");
                        sparkColor = Color.valueOf("ffffff");
                        waveStroke = 3f;
                        waveRad = 30f;
                    }};
                    hitEffect = new ExplosionEffect() {{
                        waveColor = Color.valueOf("f3e979");
                        smokeColor = Color.valueOf("f3e979");
                        sparkColor = Color.valueOf("ffffff");
                        waveStroke = 4f;
                        waveRad = 40f;
                    }};
                    //despawnSound = Sounds.spark;
                    //hitSound = Sounds.spark;
                    intervalBullet = new LightningBulletType() {{
                        damage = 3f;
                        lightningLength = 14;
                        //hitSound = Sounds.spark;
                        //despawnSound = Sounds.spark;
                        lightningColor = Color.valueOf("f3e979");
                    }};
                    bulletInterval = 2f;
                    intervalRandomSpread = 360f;
                    intervalBullets = 8;
                    intervalAngle = 360f;
                    intervalSpread = 300f;
                }}
            );
        }};
    }
}
