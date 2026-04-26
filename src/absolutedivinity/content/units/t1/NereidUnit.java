package absolutedivinity.content.units.t1;

import arc.graphics.Color;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.gen.UnitWaterMove;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class NereidUnit {
    public static UnitType nereid;

    public static void load() {
        nereid = new UnitType("nereid") {{
            constructor = UnitWaterMove::create;
            localizedName = "Nereid";
            description = "A swift surface vessel equipped with a regeneration beam to support allied units.";
            health = 360;
            armor = 3;
            speed = 1.5f;
            drag = 0.14f;
            hitSize = 9;
            accel = 0.6f;
            rotateSpeed = 5.5f;
            trailLength = 16;
            waveTrailX = 4;
            trailScl = 1.2f;
            naval = true;
            faceTarget = false;
            range = 120;

            weapons.add(new Weapon() {{
                x = 0;
                y = -8;
                reload = 30f;
                mirror = false;
                rotate = true;
                //shootSound = Sounds.spark;
                bullet = new LightningBulletType() {{
                    damage = 1;
                    buildingDamageMultiplier = 0;
                    collidesTeam = true;
                    healAmount = 14;
                    lightningLength = 15;
                    lightningColor = Color.valueOf("98ffa9");
                }};
            }});
        }};
    }
}
