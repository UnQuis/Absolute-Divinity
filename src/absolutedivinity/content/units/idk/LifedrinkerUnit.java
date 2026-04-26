package absolutedivinity.content.units.idk;

import arc.graphics.Color;
import mindustry.entities.bullet.SapBulletType;
import mindustry.gen.LegsUnit;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class LifedrinkerUnit {
    public static UnitType lifedrinker;

    public static void load() {
        lifedrinker = new UnitType("lifedrinker") {{
            constructor = LegsUnit::create;
            localizedName = "Lifedrinker";
            description = "An agile six-legged leech that drains the life of enemies using powerful sapping lasers.";
            speed = 0.54f;
            drag = 0.4f;
            hitSize = 15;
            rotateSpeed = 3f;
            health = 1000;
            legCount = 6;
            legForwardScl = 0.8f;
            legMoveSpace = 1.4f;
            legBaseOffset = 2f;
            hovering = true;
            armor = 5;
            shadowElevation = 0.3f;
            groundLayer = 75f;

            weapons.add(new Weapon("cerberian-spiroct-weapon") {{
                shootY = 4f;
                reload = 14f;
                //ejectEffect = Fx.none;
                recoil = 2f;
                rotate = true;
                //shootSound = Sounds.sap;
                x = 8.5f;
                y = -1.5f;
                bullet = new SapBulletType() {{
                    sapStrength = 0.59f;
                    length = 80f;
                    damage = 24f;
                    //shootEffect = Fx.shootSmall;
                    hitColor = Color.valueOf("bf92f9");
                    //despawnEffect = Fx.none;
                    width = 0.55f;
                    lifetime = 35f;
                    knockback = -1.24f;
                }};
            }});

            weapons.add(new Weapon("cerberian-mount-green-weapon") {{
                reload = 18f;
                rotate = true;
                x = 4f;
                y = 3f;
                //shootSound = Sounds.sap;
                bullet = new SapBulletType() {{
                    sapStrength = 0.86f;
                    length = 40f;
                    damage = 18f;
                    //shootEffect = Fx.shootSmall;
                    hitColor = Color.valueOf("bf92f9");
                    //despawnEffect = Fx.none;
                    width = 0.4f;
                    lifetime = 25f;
                    knockback = -0.65f;
                }};
            }});
        }};
    }
}
