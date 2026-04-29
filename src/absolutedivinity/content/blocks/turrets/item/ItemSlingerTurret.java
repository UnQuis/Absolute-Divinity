package absolutedivinity.content.blocks.turrets.item;

import absolutedivinity.content.ADItems;
import arc.graphics.Color;
import arc.math.Interp;
import arc.struct.ObjectMap;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ItemSlingerTurret {

    public static ItemTurret itemslinger;

    public static void load() {
        itemslinger = new ItemTurret("itemslinger") {{
            localizedName = "Itemslinger";
            description = "Slingshots pieces of raw material at enemies.";
            health = 320;
            size = 2;
            category = Category.turret;
            range = 176f;
            reload = 60f;
            rotateSpeed = 4f;
            targetAir = true;
            targetGround = true;
            ///shootSound = Sounds.shootBig;
            recoil = 1.2f;
            recoilTime = 60f;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 220,
                Items.lead, 180,
                Items.graphite, 90,
                Items.silicon, 75
            ));

            ammoTypes = ObjectMap.of(
                Items.coal, new BasicBulletType(3f, 20f) {{
                    sprite = "me-coal-bullet";
                    height = 16f;
                    despawnHit = true;
                    lightRadius = 0f;
                    pierce = true;
                    pierceCap = 4;
                    width = 16f;
                    splashDamage = 25f;
                    splashDamageRadius = 16f;
                    frontColor = Color.valueOf("404040");
                    backColor = Color.valueOf("2a2a2a");
                    ammoMultiplier = 1;
                    lifetime = 60f;
                    status = StatusEffects.burning;
                    lightOpacity = 1f;
                    statusDuration = 60f;
                    makeFire = true;
                    hitEffect = new MultiEffect(
                        new ParticleEffect() {{
                            particles = 10;
                            length = 16f;
                            sizeFrom = 10f;
                            sizeTo = 0f;
                            colorFrom = Color.valueOf("404040");
                            colorTo = Color.valueOf("2a2a2a");
                            interp = Interp.pow5Out;
                        }},
                        new WaveEffect() {{
                            sizeFrom = 0f;
                            sizeTo = 18f;
                            colorFrom = Color.valueOf("404040");
                            colorTo = Color.valueOf("2a2a2a");
                        }}
                    );
                    despawnEffect = Fx.none;
                }},
                Items.graphite, new BasicBulletType(3f, 30f) {{
                    sprite = "me-graphite-bullet";
                    height = 16f;
                    pierce = true;
                    pierceCap = 6;
                    despawnHit = true;
                    lightRadius = 0f;
                    width = 16f;
                    splashDamage = 35f;
                    splashDamageRadius = 24f;
                    frontColor = Color.valueOf("899bc0");
                    backColor = Color.valueOf("626f9b");
                    lightOpacity = 1f;
                    ammoMultiplier = 3;
                    lifetime = 60f;
                    hitEffect = new MultiEffect(
                        new ParticleEffect() {{
                            particles = 10;
                            length = 16f;
                            sizeFrom = 10f;
                            sizeTo = 0f;
                            colorFrom = Color.valueOf("95abd9");
                            colorTo = Color.valueOf("626f9b");
                            interp = Interp.pow5Out;
                        }},
                        new WaveEffect() {{
                            sizeFrom = 0f;
                            sizeTo = 18f;
                            colorFrom = Color.valueOf("95abd9");
                            colorTo = Color.valueOf("626f9b");
                        }}
                    );
                    despawnEffect = Fx.none;
                }},
                Items.sand, new BasicBulletType(3f, 10f) {{
                    sprite = "me-sand-bullet";
                    height = 16f;
                    despawnHit = true;
                    pierce = true;
                    pierceCap = 3;
                    width = 16f;
                    lightColor = Color.valueOf("d3ae8d");
                    lightOpacity = 1f;
                    splashDamage = 15f;
                    splashDamageRadius = 8f;
                    frontColor = Color.valueOf("f7cba4");
                    backColor = Color.valueOf("d3ae8d");
                    lifetime = 60f;
                    ammoMultiplier = 1;
                    status = StatusEffects.muddy;
                    statusDuration = 60f;
                    hitEffect = new MultiEffect(
                        new ParticleEffect() {{
                            particles = 10;
                            length = 16f;
                            sizeFrom = 10f;
                            sizeTo = 0f;
                            colorFrom = Color.valueOf("f7cba4");
                            colorTo = Color.valueOf("d3ae8d");
                            interp = Interp.pow5Out;
                        }},
                        new WaveEffect() {{
                            sizeFrom = 0f;
                            sizeTo = 18f;
                            colorFrom = Color.valueOf("f7cba4");
                            colorTo = Color.valueOf("d3ae8d");
                        }}
                    );
                    despawnEffect = Fx.none;
                }},
                Items.thorium, new BasicBulletType(3f, 50f) {{
                    sprite = "me-thorium-bullet";
                    height = 16f;
                    despawnHit = true;
                    lightRadius = 0f;
                    pierce = true;
                    pierceCap = 8;
                    width = 16f;
                    splashDamage = 55f;
                    splashDamageRadius = 32f;
                    frontColor = Color.valueOf("f9a3c7");
                    backColor = Color.valueOf("cb8ebf");
                    ammoMultiplier = 4;
                    lifetime = 60f;
                    lightOpacity = 1f;
                    homingPower = 0.2f;
                    hitEffect = new MultiEffect(
                        new ParticleEffect() {{
                            particles = 10;
                            length = 16f;
                            sizeFrom = 10f;
                            sizeTo = 0f;
                            colorFrom = Color.valueOf("f9a3c7");
                            colorTo = Color.valueOf("cb8ebf");
                            interp = Interp.pow5Out;
                        }},
                        new WaveEffect() {{
                            sizeFrom = 0f;
                            sizeTo = 18f;
                            colorFrom = Color.valueOf("f9a3c7");
                            colorTo = Color.valueOf("cb8ebf");
                        }}
                    );
                    despawnEffect = Fx.none;
                }},
                Items.blastCompound, new BasicBulletType(3f, 35f) {{
                    sprite = "me-blast-bullet";
                    height = 16f;
                    despawnHit = true;
                    lightRadius = 0f;
                    pierce = true;
                    pierceCap = 7;
                    width = 16f;
                    splashDamage = 40f;
                    splashDamageRadius = 24f;
                    frontColor = Color.valueOf("ff795e");
                    backColor = Color.valueOf("c85c51");
                    ammoMultiplier = 1;
                    lifetime = 60f;
                    status = StatusEffects.blasted;
                    lightOpacity = 1f;
                    statusDuration = 60f;
                    makeFire = true;
                    hitEffect = new MultiEffect(
                        new ParticleEffect() {{
                            particles = 10;
                            length = 16f;
                            sizeFrom = 10f;
                            sizeTo = 0f;
                            colorFrom = Color.valueOf("ff795e");
                            colorTo = Color.valueOf("c85c51");
                            interp = Interp.pow5Out;
                        }},
                        new WaveEffect() {{
                            sizeFrom = 0f;
                            sizeTo = 18f;
                            colorFrom = Color.valueOf("ff795e");
                            colorTo = Color.valueOf("c85c51");
                        }}
                    );
                    despawnEffect = Fx.none;
                }},
                Items.pyratite, new BasicBulletType(3f, 30f) {{
                    sprite = "me-blast-bullet";
                    height = 16f;
                    despawnHit = true;
                    lightRadius = 0f;
                    pierce = true;
                    pierceCap = 6;
                    width = 16f;
                    splashDamage = 35f;
                    splashDamageRadius = 24f;
                    frontColor = Color.valueOf("ffaa5f");
                    backColor = Color.valueOf("d37f47");
                    ammoMultiplier = 1;
                    lifetime = 60f;
                    status = StatusEffects.melting;
                    lightOpacity = 1f;
                    statusDuration = 60f;
                    makeFire = true;
                    hitEffect = new MultiEffect(
                        new ParticleEffect() {{
                            particles = 10;
                            length = 16f;
                            sizeFrom = 10f;
                            sizeTo = 0f;
                            colorFrom = Color.valueOf("ffaa5f");
                            colorTo = Color.valueOf("d37f47");
                            interp = Interp.pow5Out;
                        }},
                        new WaveEffect() {{
                            sizeFrom = 0f;
                            sizeTo = 18f;
                            colorFrom = Color.valueOf("ffaa5f");
                            colorTo = Color.valueOf("d37f47");
                        }}
                    );
                    despawnEffect = Fx.none;
                }}
            );
        }};
    }
}
