package absolutedivinity.content.units.t1;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class BeamWaspUnit {
    public static UnitType beamWasp;

    public static void load() {
        beamWasp = new UnitType("beam-wasp") {{
            constructor = UnitEntity::create;
            localizedName = "Beam Wasp";
            description = "A fragile but deadly drone that fires twin piercing laser beams, effective in swarms.";
            speed = 3.3f;
            flying = true;
            health = 170;
            armor = 1;
            engineOffset = 5.5f;
            hitSize = 6;

            weapons.add(new Weapon("chrome-blaster") {{
                reload = 90f;
                //shootSound = Sounds.laser;
                alternate = true;
                bullet = new LaserBulletType() {{
                    damage = 40f;
                    width = 15f;
                    length = 190f;
                    shootEffect = Fx.shockwave;
                    colors = new Color[]{
                        Color.valueOf("ec7458aa"),
                        Color.valueOf("ff9c5a"),
                        Color.valueOf("ffffff")
                    };
                }};
            }});
        }};
    }
}
