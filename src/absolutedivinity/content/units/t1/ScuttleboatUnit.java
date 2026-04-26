package absolutedivinity.content.units.t1;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.gen.UnitWaterMove;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class ScuttleboatUnit {
    public static UnitType scuttleboat;

    public static void load() {
        scuttleboat = new UnitType("scuttleboat") {{
            constructor = UnitWaterMove::create;
            localizedName = "Scuttleboat";
            description = "Rapid-firing cannon coupled with a rear-facing mine dispenser for area denial.";
            health = 370;
            naval = true;
            armor = 2;
            hitSize = 14;
            speed = 1.5f;
            canBoost = false;
            faceTarget = false;
            drag = 0.13f;
            accel = 0.55f;
            rotateSpeed = 3.8f;
            range = 160;

            weapons.add(new Weapon("missiles-mount") {{
                x = 0;
                y = 2;
                reload = 10f;
                rotate = true;
                mirror = false;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(2f, 18f) {{
                    speed = 2f;
                    damage = 18f;
                    pierce = true;
                    pierceCap = 3;
                    width = 9f;
                    height = 11f;
                    lifetime = 80f;
                    ammoMultiplier = 6f;
                }};
            }});

            weapons.add(new Weapon() {{
                x = -3;
                shootY = 0;
                shootCone = 90;
                ejectEffect = Fx.none;
                reload = 160f;
                rotate = false;
                baseRotation = 180f;
                alwaysShooting = true;
                minShootVelocity = 0.9f;
                bullet = new BasicBulletType(0f, 0f) {{
                    instantDisappear = true;
                    fragBullets = 1;
                    fragVelocityMin = 0f;
                    fragVelocityMax = 0f;
                    fragRandomSpread = 0f;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                    hitEffect = Fx.none;
                    despawnHit = false;
                    fragBullet = new BasicBulletType(0f, 7f) {{
                        shootEffect = Fx.none;
                        smokeEffect = Fx.none;
                        hitEffect = Fx.none;
                        despawnHit = false;
                        height = 12f;
                        width = 12f;
                        collidesAir = false;
                        hitSize = 12f;
                        damage = 7f;
                        sprite = "me-lml-mine";
                        frontColor = Color.valueOf("d99f6b");
                        shrinkX = 0f;
                        shrinkY = 0f;
                        despawnEffect = Fx.none;
                        backColor = Color.valueOf("f3e979");
                        splashDamage = 35f;
                        splashDamageRadius = 32f;
                        speed = 0f;
                        hittable = false;
                        collides = true;
                        pierce = false;
                        lifetime = 720f;
                    }};
                }};
            }});
        }};
    }
}
