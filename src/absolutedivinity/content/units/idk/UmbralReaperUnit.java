package absolutedivinity.content.units.idk;

import arc.graphics.Color;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.pattern.ShootPattern;
import mindustry.gen.PayloadUnit;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.world.meta.BlockFlag;

public class UmbralReaperUnit {
    public static UnitType umbralReaper;

    public static void load() {
        umbralReaper = new UnitType("umbral-reaper") {{
            constructor = PayloadUnit::create;
            localizedName = "Umbral Reaper";
            description = "A low-altitude gunship equipped with missile pods and a devastating laser cannon, prioritizing enemy structures.";
            speed = 0.93333f;
            accel = 0.04f;
            drag = 0.04f;
            rotateSpeed = 1.9f;
            flying = true;
            lowAltitude = true;
            payloadCapacity = 3;
            health = 10000;
            armor = 10;
            engineOffset = 21f;
            engineSize = 5.3f;
            hitSize = 46;
            targetFlags = new BlockFlag[]{BlockFlag.generator, BlockFlag.core};

            weapons.add(new Weapon("cerberian-missile-mount") {{
                y = 8f;
                x = 17f;
                reload = 20f;
                //ejectEffect = Fx.casing1;
                rotateSpeed = 8f;
                //shootSound = Sounds.missile;
                shoot = new ShootPattern() {{
                    shots = 2;
                    shotDelay = 7f;
                }};
                rotate = true;
                bullet = new MissileBulletType(2.7f, 26f) {{
                    width = 8f;
                    height = 8f;
                    shrinkY = 0f;
                    drag = -0.01f;
                    splashDamageRadius = 20f;
                    splashDamage = 30f;
                    lifetime = 50f;
                    //hitEffect = Fx.blastExplosion;
                    //despawnEffect = Fx.blastExplosion;
                    trailColor = Color.valueOf("5461c5");
                    frontColor = Color.valueOf("6d7dff");
                    backColor = Color.valueOf("5461c5");
                    status = StatusEffects.blasted;
                    statusDuration = 60f;
                }};
            }});

            weapons.add(new Weapon("cerberian-missile-mount") {{
                y = -8f;
                x = 17f;
                reload = 35f;
                //ejectEffect = Fx.casing1;
                rotateSpeed = 8f;
                //shootSound = Sounds.missile;
                shoot = new ShootPattern() {{
                    shots = 2;
                    shotDelay = 7f;
                }};
                rotate = true;
                bullet = new MissileBulletType(2.7f, 26f) {{
                    width = 8f;
                    height = 8f;
                    shrinkY = 0f;
                    drag = -0.01f;
                    splashDamageRadius = 20f;
                    splashDamage = 30f;
                    lifetime = 50f;
                    //hitEffect = Fx.blastExplosion;
                    //despawnEffect = Fx.blastExplosion;
                    trailColor = Color.valueOf("5461c5");
                    frontColor = Color.valueOf("6d7dff");
                    backColor = Color.valueOf("5461c5");
                    status = StatusEffects.blasted;
                    statusDuration = 60f;
                }};
            }});

            weapons.add(new Weapon("cerberian-large-bullet-mount") {{
                x = 10f;
                y = 2f;
                shootY = 10f;
                reload = 48f;
                shake = 1f;
                rotateSpeed = 2f;
                //ejectEffect = Fx.none;
                //shootSound = Sounds.laser;
                rotate = true;
                bullet = new LaserBulletType() {{
                    pierce = false;
                    damage = 300f;
                    width = 12f;
                    lifetime = 25f;
                    colors = new Color[]{
                        Color.valueOf("5461c5"),
                        Color.valueOf("99a4ff"),
                        Color.valueOf("ffffff")
                    };
                    pierceCap = 1;
                    pierceBuilding = false;
                }};
            }});
        }};
    }
}
