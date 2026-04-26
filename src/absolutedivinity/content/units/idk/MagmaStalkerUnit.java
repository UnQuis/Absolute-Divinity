package absolutedivinity.content.units.idk;

import arc.struct.ObjectSet;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.LiquidBulletType;
import mindustry.gen.LegsUnit;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class MagmaStalkerUnit {
    public static UnitType magmaStalker;

    public static void load() {
        magmaStalker = new UnitType("magma-stalker") {{
            constructor = LegsUnit::create;
            localizedName = "Magma Stalker";
            description = "A swift four-legged hunter that hurls slag bullets, leaving fiery destruction and melting armor.";
            speed = 0.6f;
            drag = 0.4f;
            hitSize = 13;
            rotateSpeed = 3f;
            targetAir = false;
            health = 500;
            legCount = 4;
            legLength = 9f;
            legForwardScl = 0.6f;
            legMoveSpace = 1.4f;
            hovering = true;
            armor = 2;
            shadowElevation = 0.2f;
            groundLayer = 74f;
            immunities = ObjectSet.with(StatusEffects.burning, StatusEffects.melting);

            weapons.add(new Weapon("cerberian-atrax-weapon") {{
                top = false;
                shootY = 3f;
                reload = 9f;
                //ejectEffect = Fx.none;
                x = 7f;
                //shootSound = Sounds.flame;
                bullet = new LiquidBulletType(Liquids.slag) {{
                    liquid = Liquids.slag;
                    damage = 30f;
                    drag = 0.009f;
                    speed = 2.5f;
                    //shootEffect = Fx.shootSmall;
                    lifetime = 57f;
                    collidesAir = false;
                    fragBullets = 2;
                    status = StatusEffects.burning;
                    statusDuration = 120f;
                    fragBullet = new LiquidBulletType(Liquids.slag) {{
                        liquid = Liquids.slag;
                        knockback = 1.6f;
                        speed = 1f;
                        damage = 8f;
                        lifetime = 40f;
                        collidesAir = false;
                        status = StatusEffects.melting;
                        statusDuration = 60f;
                    }};
                }};
            }});
        }};
    }
}
