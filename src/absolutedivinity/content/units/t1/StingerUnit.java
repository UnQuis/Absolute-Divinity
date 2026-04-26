package absolutedivinity.content.units.t1;

import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.entities.bullet.PointBulletType;
import mindustry.entities.effect.ParticleEffect;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class StingerUnit {
    public static UnitType stinger;

    public static void load() {
        stinger = new UnitType("stinger") {{
            constructor = UnitEntity::create;
            localizedName = "Stinger";
            description = "A high-speed interceptor that delivers pinpoint energy bursts, devastating ground targets.";
            health = 210;
            armor = 0;
            hitSize = 8;
            flying = true;
            itemCapacity = 20;
            outlineColor = Color.valueOf("191919");
            speed = 1.6f;

            weapons.add(new Weapon("nothing") {{
                x = 0;
                y = 2;
                reload = 180f;
                mirror = false;
                top = false;
                rotate = false;
                shootCone = 30f;
                //shootSound = Sounds.railgun;
                bullet = new PointBulletType() {{
                    maxRange = 160f;
                    trailEffect = new ParticleEffect() {{
                        particles = 6;
                        rotWithParent = true;
                        length = 10f;
                        line = true;
                        colorFrom = Color.valueOf("c85c51");
                        colorTo = Color.valueOf("ff795e");
                        sizeFrom = 5f;
                        sizeTo = 5f;
                        sizeInterp = Interp.pow2Out;
                    }};
                    speed = 8f;
                    lifetime = 20f;
                    hitEffect = Fx.none;
                    despawnEffect = Fx.none;
                    damage = 0;
                    splashDamage = 210f;
                    splashDamageRadius = 32f;
                    hitEffect = Fx.instHit;
                    despawnHit = true;
                    pierce = true;
                    buildingDamageMultiplier = 0.4f;
                }};
            }});
        }};
    }
}