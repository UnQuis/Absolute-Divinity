package absolutedivinity.content.blocks.turrets.void_;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class VoidFrag {
    public static PowerTurret voidFrag;

    public static void load() {{
        voidFrag = new PowerTurret("void-4") {{
            localizedName = "Void Frag";
            description = "Launches explosive silver shells that shatter into deadly fragments.";
            size = 2;
            health = 950;
            range = 230f;
            reload = 45f;
            rotateSpeed = 6f;
            shootCone = 6f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADEffects.voidShoot;
            heatColor = Color.white;
            consumePower(5f);
            consumeCoolant(0.2f);
            shootType = new BasicBulletType(6f, 65f) {{
                width = 9f;
                height = 12f;
                lifetime = 40f;
                pierce = false;
                knockback = 3f;
                splashDamage = 40f;
                splashDamageRadius = 30f;
                despawnEffect = ADEffects.voidFragmentExplosion;
                hitEffect = ADEffects.voidFragmentExplosion;
                shootEffect = Fx.none;
                smokeEffect = Fx.shootBigSmoke2;
                trailEffect = ADEffects.voidTrail;
                trailChance = 0.5f;
                trailLength = 10;
                trailWidth = 2f;
                fragBullets = 8;
                fragBullet = new BasicBulletType(4f, 20f) {{
                    width = 3f;
                    height = 5f;
                    lifetime = 25f;
                    pierce = false;
                    knockback = 1f;
                    despawnEffect = Fx.none;
                    hitEffect = ADEffects.voidHitSmall;
                    trailEffect = ADEffects.voidTrail;
                    trailChance = 0.2f;
                    trailLength = 4;
                    trailWidth = 1f;
                    backColor = Color.valueOf("d8dcf0");
                    frontColor = Color.white;
                    mixColorFrom = Color.valueOf("a8b8ff");
                    mixColorTo = Color.white;
                }};
                backColor = Color.valueOf("d0d8f0");
                frontColor = Color.white;
                mixColorFrom = Color.valueOf("a0b4ff");
                mixColorTo = Color.white;
            }};
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
