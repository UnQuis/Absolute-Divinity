package absolutedivinity.content.blocks.turrets.item;

import absolutedivinity.content.ADItems;
import arc.graphics.Color;
import arc.struct.ObjectMap;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class HurricaneTurret {
    
    public static ItemTurret hurricane;

    public static void load() {
        hurricane = new ItemTurret("hurricane"){{
            localizedName = "Hurricane";
            description = "Fires many clumps of explosive flak at enemies, akin to the cyclone.";
            size = 3;
            health = 1905;
            reload = 9f;
            range = 224f;
            squareSprite = false;
            targetAir = true;
            targetGround = true;
            inaccuracy = 7f;
            xRand = 4f;
            recoil = 2f;
            //shootSound =
            buildCostMultiplier = 0.2f;
            category = Category.turret;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 500,
                Items.titanium, 300,
                Items.plastanium, 150
            )); 

            ammoTypes = ObjectMap.of(
                Items.metaglass, new FlakBulletType(4f, 12f){{
                    lifetime = 55f;
                    ammoMultiplier = 3f;
                    //shootEffect = null;
                    reloadMultiplier = 0.8f;
                    width = 6f;
                    height = 6f;
                    //hitEffect = null;
                    splashDamage = 42f;
                    splashDamageRadius = 25f;
                    fragBullets = 4;
                    collidesGround = true;
                    fragBullet = new BasicBulletType(){{
                        width = 5f;
                        height = 12f;
                        shrinkY = 1;
                        lifetime = 20f;
                        backColor = Color.valueOf("484848");
                        frontColor = Color.valueOf("ffffff");
                        despawnEffect = Fx.none;
                    }};
                }},

                Items.blastCompound, new FlakBulletType(4f, 14f){{
                    lifetime = 55f;
                    ammoMultiplier = 5f;
                    //shootEffect = null;
                    //hitEffect = null;
                    splashDamage = 46f;
                    splashDamageRadius = 60f;
                    status = StatusEffects.blasted;
                    statusDuration = 60f;
                    collidesGround = true;
                }},

                Items.plastanium, new FlakBulletType(4f, 28f){{
                    lifetime = 55f;
                    //shootEffect = null;
                    //hitEffect = null;
                    splashDamage = 68f;
                    splashDamageRadius = 40f;
                    fragBullets = 6;
                    collidesGround = true;
                    fragBullet = new BasicBulletType(){{
                        width = 10f;
                        height = 12f;
                        shrinkY = 1;
                        lifetime = 15f;
                        despawnEffect = Fx.none;
                    }};
                }},

                Items.surgeAlloy, new FlakBulletType(4f, 18f){{
                    lifetime = 55f;
                    ammoMultiplier = 5f;
                    //shootEffect = null;
                    lightning = 2;
                    lightningLength = 7;
                    lightningDamage = 15f;
                    splashDamage = 82f;
                    splashDamageRadius = 38f;
                    collidesGround = true;
                }},

                ADItems.steelAmalgam, new FlakBulletType(4f, 25f){{
                    lifetime = 55f;
                    ammoMultiplier = 5f;
                    //shootEffect = null;
                    splashDamage = 91f;
                    splashDamageRadius = 38f;
                    collidesGround = true;
                    lightning = 3;
                    lightningLength = 9;
                    lightningDamage = 19f;
                }}
            );
        }};
    }
}
