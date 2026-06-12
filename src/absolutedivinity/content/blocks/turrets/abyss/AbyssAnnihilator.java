package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADItems;
import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADColor;
import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class AbyssAnnihilator {
    public static ItemTurret abyssAnnihilator;

    public static void load() {{
        abyssAnnihilator = new ItemTurret("abyss-annihilator") {{
            localizedName = "Abyss Annihilator";
            description = "The apex of abyssal weaponry. Fires devastating purple energy salvos that obliterate everything.";
            size = 10;
            health = 80000;
            armor = 18;
            range = 450f;
            reload = 240f;
            rotateSpeed = 0.8f;
            shootCone = 5f;
            targetAir = true;
            targetGround = true;
            minWarmup = 0.88f;
            shootWarmupSpeed = 0.015f;
            shootEffect = new MultiEffect(
                ADTurretEffects.shootBig(ADColor.abyssMain),
                new WaveEffect() {{
                    sizeFrom = 0f;
                    sizeTo = 150f;
                    colorFrom = ADColor.abyssMain;
                    colorTo = ADColor.abyssDark;
                    strokeFrom = 8f;
                    strokeTo = 0f;
                    interp = Interp.pow5Out;
                }}
            );
            smokeEffect = ADTurretEffects.shootBig(ADColor.abyssDark);
            heatColor = ADColor.abyssMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 6000,
                Items.silicon, 5000,
                Items.titanium, 3500,
                Items.thorium, 2000,
                Items.surgeAlloy, 1200
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new BasicBulletType(7f, 800f) {{
                width = 22f;
                height = 26f;
                lifetime = 65f;
                hitEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.abyssMain, 120f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 200f;
                        colorFrom = ADColor.abyssMain;
                        colorTo = ADColor.abyssLight;
                        strokeFrom = 10f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }},
                    new ParticleEffect() {{
                        sizeFrom = 10f;
                        sizeTo = 2f;
                        colorFrom = ADColor.abyssMain;
                        colorTo = ADColor.abyssLight;
                        length = 0f;
                        baseLength = 0f;
                        lifetime = 70f;
                        particles = 50;
                        interp = Interp.exp5;
                        sizeInterp = Interp.pow5Out;
                    }}
                );
                despawnEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.abyssMain, 140f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 280f;
                        colorFrom = ADColor.abyssMain;
                        colorTo = ADColor.abyssLight;
                        strokeFrom = 14f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }},
                    new ParticleEffect() {{
                        sizeFrom = 14f;
                        sizeTo = 3f;
                        colorFrom = ADColor.abyssMain;
                        colorTo = ADColor.abyssLight;
                        length = 0f;
                        baseLength = 0f;
                        lifetime = 90f;
                        particles = 80;
                        interp = Interp.exp5;
                        sizeInterp = Interp.pow5Out;
                    }}
                );
                smokeEffect = ADTurretEffects.shootBig(ADColor.abyssDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.abyssMain);
                trailChance = 0.8f;
                frontColor = Color.white;
                backColor = ADColor.abyssMain;
                knockback = 10f;
                hitShake = 16f;
                splashDamageRadius = 80f;
                splashDamage = 350f;
                pierce = true;
                pierceArmor = true;
                pierceCap = 8;
                lightning = 10;
                lightningDamage = 60f;
                lightningLength = 25;
                lightningColor = ADColor.abyssGlow;
                status = StatusEffects.shocked;
                statusDuration = 180f;
            }});
            ammo(ADItems.divinite, new BasicBulletType(9f, 1400f) {{
                width = 28f;
                height = 32f;
                lifetime = 55f;
                hitEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.abyssMain, 160f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 350f;
                        colorFrom = ADColor.abyssMain;
                        colorTo = ADColor.abyssLight;
                        strokeFrom = 18f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }},
                    new ParticleEffect() {{
                        sizeFrom = 18f;
                        sizeTo = 4f;
                        colorFrom = ADColor.abyssMain;
                        colorTo = ADColor.abyssLight;
                        length = 0f;
                        baseLength = 0f;
                        lifetime = 100f;
                        particles = 100;
                        interp = Interp.exp5;
                        sizeInterp = Interp.pow5Out;
                    }}
                );
                despawnEffect = new MultiEffect(
                    ADTurretEffects.blastEffect(ADColor.abyssMain, 180f),
                    new WaveEffect() {{
                        sizeFrom = 0f;
                        sizeTo = 400f;
                        colorFrom = ADColor.abyssMain;
                        colorTo = ADColor.abyssLight;
                        strokeFrom = 20f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                    }}
                );
                smokeEffect = ADTurretEffects.shootBig(ADColor.abyssDark);
                trailEffect = ADTurretEffects.trailEffect(ADColor.abyssMain);
                trailChance = 1f;
                frontColor = Color.white;
                backColor = ADColor.abyssMain;
                knockback = 14f;
                hitShake = 20f;
                splashDamageRadius = 100f;
                splashDamage = 600f;
                pierce = true;
                pierceArmor = true;
                pierceCap = -1;
                lightning = 16;
                lightningDamage = 100f;
                lightningLength = 35;
                lightningColor = ADColor.abyssGlow;
                status = StatusEffects.melting;
                statusDuration = 400f;
            }});
        }};
    }}
}
