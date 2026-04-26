package absolutedivinity.content.units.t1;

import arc.math.geom.Rect;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.pattern.ShootPattern;
import mindustry.gen.TankUnit;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class BulwarkUnit {
    public static UnitType bulwark;

    public static void load() {
        bulwark = new UnitType("bulwark") {{
            constructor = TankUnit::create;
            localizedName = "Bulwark";
            description = "Heavy assault tank armed with twin rapid-fire cannons optimized for structural demolition.";
            health = 650;
            armor = 3;
            squareShape = true;
            treadPullOffset = 8;
            treadRects = new Rect[]{
                new Rect(7f, -26f, 14f, 51f)
            };
            singleTarget = true;
            omniMovement = false;
            rotateSpeed = 2;
            faceTarget = false;
            flying = false;
            range = 120;

            weapons.add(new Weapon("sambuca-weapon") {{
                x = 0;
                y = -1;
                reload = 18f;
                mirror = false;
                rotate = true;
                shoot = new ShootPattern() {{
                    shots = 2;
                    shotDelay = 2f;
                }};
                bullet = new BasicBulletType(3f, 12f) {{
                    width = 6f;
                    height = 10f;
                    speed = 3f;
                    lifetime = 40f;
                    damage = 12f;
                    pierce = false;
                    buildingDamageMultiplier = 3.4f;
                }};
            }});
        }};
    }
}
