package absolutedivinity.content.units.t1;

import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.entities.bullet.LiquidBulletType;
import mindustry.entities.pattern.ShootPattern;
import mindustry.gen.MechUnit;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class PyroclasmUnit {
    public static UnitType pyroclasm;

    public static void load() {
        pyroclasm = new UnitType("pyroclasm") {{
            constructor = MechUnit::create;
            localizedName = "Pyroclasm";
            description = "Twin slag guns unleash a barrage of molten metal, melting enemy structures.";
            speed = 1.1f;
            hitSize = 8;
            health = 340;
            mechSideSway = 0.25f;

            weapons.add(new Weapon("atrax-weapon") {{
                x = 6f;
                y = -1f;
                reload = 180f;
                //shootSound = Sounds.flame;
                rotate = false;
                mirror = true;
                shoot = new ShootPattern() {{
                    firstShotDelay = 60f;
                    shots = 14;
                    shotDelay = 3f;
                }};
                //chargeSound = Sounds.lasercharge2;
                alternate = false;
                bullet = new LiquidBulletType(Liquids.slag) {{
                    liquid = Liquids.slag;
                    speed = 4f;
                    lifetime = 40f;
                    damage = 4.2f;
                    pierce = true;
                    pierceCap = 2;
                    buildingDamageMultiplier = 0.9f;
                    chargeEffect = Fx.lightningCharge;
                    shootEffect = Fx.shootSmall;
                }};
            }});
        }};
    }
}
