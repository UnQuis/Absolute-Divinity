package absolutedivinity.content.units.idk;

import arc.graphics.Color;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.LiquidBulletType;
import mindustry.entities.bullet.SapBulletType;
import mindustry.gen.LegsUnit;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class SlagspitterUnit {
    public static UnitType slagspitter;

    public static void load() {
        slagspitter = new UnitType("slagspitter") {{
            constructor = LegsUnit::create;
            localizedName = "Slagspitter";
            description = "A six-legged arachnid that spews corrosive slag and crippling oil, leaving enemies slagged, tarred, and frozen.";
            drag = 0.1f;
            speed = 0.62f;
            hitSize = 23;
            health = 8000;
            armor = 6;
            rotateSpeed = 2.7f;
            legCount = 6;
            legMoveSpace = 1f;
            legPairOffset = 3f;
            legLength = 30f;
            legExtension = -15f;
            legBaseOffset = 10f;
            stepShake = 1f;
            legLengthScl = 0.96f;
            rippleScale = 2f;
            legSpeed = 2f;
            legSplashDamage = 32f;
            legSplashRange = 30f;
            drownTimeMultiplier = 2f;
            hovering = true;
            shadowElevation = 0.65f;
            groundLayer = 75f;

            weapons.add(new Weapon("cerberian-spiroct-weapon") {{
                reload = 9f;
                x = 4f;
                y = 8f;
                rotate = true;
                //shootSound = Sounds.sap;
                bullet = new SapBulletType() {{
                    sapStrength = 0.9f;
                    length = 55f;
                    damage = 40f;
                    //shootEffect = Fx.shootSmall;
                    hitColor = Color.valueOf("bf92f9");
                    //despawnEffect = Fx.none;
                    width = 0.56f;
                    lifetime = 30f;
                    knockback = -1f;
                }};
            }});

            weapons.add(new Weapon("cerberian-spiroct-weapon") {{
                reload = 14f;
                x = 9f;
                y = 6f;
                rotate = true;
                //shootSound = Sounds.sap;
                bullet = new SapBulletType() {{
                    sapStrength = 0.9f;
                    length = 55f;
                    damage = 40f;
                    //shootEffect = Fx.shootSmall;
                    hitColor = Color.valueOf("bf92f9");
                    //despawnEffect = Fx.none;
                    width = 0.56f;
                    lifetime = 30f;
                    knockback = -1f;
                }};
            }});

            weapons.add(new Weapon("cerberian-spiroct-weapon") {{
                reload = 22f;
                x = 14f;
                y = 0f;
                rotate = true;
                //shootSound = Sounds.sap;
                bullet = new SapBulletType() {{
                    sapStrength = 0.9f;
                    length = 55f;
                    damage = 40f;
                    //shootEffect = Fx.shootSmall;
                    hitColor = Color.valueOf("bf92f9");
                    //despawnEffect = Fx.none;
                    width = 0.56f;
                    lifetime = 30f;
                    knockback = -1f;
                }};
            }});

            weapons.add(new Weapon("cerberian-large-green-mount") {{
                y = -7f;
                x = 9f;
                shootY = 7f;
                reload = 45f;
                shake = 3f;
                rotateSpeed = 2f;
                //ejectEffect = Fx.casing1;
                //shootSound = Sounds.laser;
                rotate = true;
                recoil = 3f;
                bullet = new LiquidBulletType(Liquids.slag) {{
                    speed = 2f;
                    damage = 0f;
                    liquid = Liquids.slag;
                    splashDamage = 42f;
                    splashDamageRadius = 70f;
                    orbSize = 4f;
                    fragBullets = 4;
                    lifetime = 70f;
                    status = StatusEffects.melting;
                    fragLifeMin = 0.3f;
                    fragBullet = new LiquidBulletType(Liquids.oil) {{
                        liquid = Liquids.oil;
                        speed = 2f;
                        orbSize = 3f;
                        damage = 0f;
                        splashDamage = 7f;
                        splashDamageRadius = 70f;
                        status = StatusEffects.tarred;
                        fragBullets = 3;
                        lifetime = 55f;
                        fragLifeMin = 0.3f;
                        fragBullet = new LiquidBulletType(Liquids.cryofluid) {{
                            liquid = Liquids.cryofluid;
                            speed = 2f;
                            lifetime = 30f;
                            damage = 0f;
                            splashDamage = 20f;
                            orbSize = 2f;
                            splashDamageRadius = 70f;
                        }};
                    }};
                }};
            }});
        }};
    }
}
