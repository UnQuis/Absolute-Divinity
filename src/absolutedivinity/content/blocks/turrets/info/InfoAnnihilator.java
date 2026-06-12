package absolutedivinity.content.blocks.turrets.info;

import absolutedivinity.content.ADItems;
import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfoAnnihilator {
    public static ItemTurret infoAnnihilator;

    public static void load() {{
        infoAnnihilator = new ItemTurret("info-annihilator") {{
            localizedName = "Info Annihilator";
            description = "The pinnacle of informational warfare. Fires devastating precision strikes that leave nothing standing.";
            size = 10;
            health = 85000;
            armor = 19;
            range = 400f;
            reload = 220f;
            rotateSpeed = 0.85f;
            shootCone = 5f;
            targetAir = true;
            targetGround = true;
            minWarmup = 0.9f;
            shootWarmupSpeed = 0.012f;
            shootEffect = new MultiEffect(
                ADTurretEffects.shootBig(ADColor.infoMain),
                new WaveEffect() {{
                    sizeFrom = 0f;
                    sizeTo = 150f;
                    colorFrom = ADColor.infoMain;
                    colorTo = ADColor.infoDark;
                    strokeFrom = 8f;
                    strokeTo = 0f;
                    interp = Interp.pow5Out;
                }}
            );
            smokeEffect = ADTurretEffects.shootBig(ADColor.infoDark);
            heatColor = ADColor.infoMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 6500,
                Items.silicon, 5200,
                Items.titanium, 3600,
                Items.thorium, 2200,
                Items.surgeAlloy, 1300
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new BasicBulletType(8f, 900f) {{
                width = 20f;
                height = 24f;
                lifetime = 56f;
                hitEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.infoMain, 130f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 230f;
                        colorFrom = ADColor.infoMain;
                        colorTo = ADColor.infoLight;
                        strokeFrom = 10f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }},
                    new ParticleEffect() {{
                        sizeFrom = 10f;
                        sizeTo = 2f;
                        colorFrom = ADColor.infoMain;
                        colorTo = ADColor.infoLight;
                        length = 0f;
                        baseLength = 0f;
                        lifetime = 75f;
                        particles = 65;
                        interp = Interp.exp5;
                        sizeInterp = Interp.pow5Out;
                    }}
                );
                despawnEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.infoMain, 150f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 310f;
                        colorFrom = ADColor.infoMain;
                        colorTo = ADColor.infoLight;
                        strokeFrom = 14f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }},
                    new ParticleEffect() {{
                        sizeFrom = 14f;
                        sizeTo = 3f;
                        colorFrom = ADColor.infoMain;
                        colorTo = ADColor.infoLight;
                        length = 0f;
                        baseLength = 0f;
                        lifetime = 85f;
                        particles = 85;
                        interp = Interp.exp5;
                        sizeInterp = Interp.pow5Out;
                    }}
                );
                smokeEffect = ADTurretEffects.shootBig(ADColor.infoDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.infoMain);
                trailChance = 0.9f;
                frontColor = Color.white;
                backColor = ADColor.infoMain;
                knockback = 10f;
                hitShake = 16f;
                splashDamageRadius = 85f;
                splashDamage = 400f;
                pierce = true;
                pierceArmor = true;
                pierceCap = 8;
                lightning = 10;
                lightningDamage = 55f;
                lightningLength = 22;
                lightningColor = ADColor.infoGlow;
            }});
            ammo(ADItems.divinite, new BasicBulletType(10f, 1600f) {{
                width = 26f;
                height = 30f;
                lifetime = 48f;
                hitEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.infoMain, 170f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 380f;
                        colorFrom = ADColor.infoMain;
                        colorTo = ADColor.infoLight;
                        strokeFrom = 18f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }},
                    new ParticleEffect() {{
                        sizeFrom = 14f;
                        sizeTo = 3f;
                        colorFrom = ADColor.infoMain;
                        colorTo = ADColor.infoLight;
                        length = 0f;
                        baseLength = 0f;
                        lifetime = 95f;
                        particles = 95;
                        interp = Interp.exp5;
                        sizeInterp = Interp.pow5Out;
                    }}
                );
                despawnEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.infoMain, 190f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 440f;
                        colorFrom = ADColor.infoMain;
                        colorTo = ADColor.infoLight;
                        strokeFrom = 20f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }}
                );
                smokeEffect = ADTurretEffects.shootBig(ADColor.infoDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.infoMain);
                trailChance = 1f;
                frontColor = Color.white;
                backColor = ADColor.infoMain;
                knockback = 14f;
                hitShake = 20f;
                splashDamageRadius = 110f;
                splashDamage = 700f;
                pierce = true;
                pierceArmor = true;
                pierceCap = -1;
                lightning = 16;
                lightningDamage = 85f;
                lightningLength = 30;
                lightningColor = ADColor.infoGlow;
            }});
        }};
    }}
}
