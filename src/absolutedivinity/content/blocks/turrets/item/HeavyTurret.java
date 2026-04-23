package absolutedivinity.content.blocks.turrets.item;

import absolutedivinity.content.ADItems;
import arc.struct.ObjectMap;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class HeavyTurret {
    
    public static ItemTurret HEAVY;

    public static void load(){
        HEAVY = new ItemTurret("heavy"){{
            localizedName = "HEAVY";
            description = "It costs four hundred thousand dollars to fire this weapon… for twelve seconds.";
            size = 4;
            health = 900;
            liquidCapacity = 20f;
            maxAmmo = 600;
            reload = 2f;
            range = 320f;
            ammoPerShot = 1;
            inaccuracy = 10f;
            rotateSpeed = 8f;
            buildCostMultiplier = 0.2f;
            recoil = 0.6f;
            hasLiquids = true;
            targetAir = false;
            targetGround = true;
            //shootSound =
            requirements(Category.turret, ItemStack.with(
                Items.copper, 500,
                Items.lead, 300,
                Items.titanium, 200,
                Items.plastanium, 85
            ));

            ammoTypes = ObjectMap.of(
                ADItems.ammoLevel1, new BasicBulletType(12f, 12f){{
                    splashDamageRadius = 5f;
                    splashDamage = 5f;
                    lifetime = 25f;
                    height = 10f;
                    inaccuracy = 14f;
                    width = 5f;
                    ammoMultiplier = 10f;
                }},

                ADItems.ammoLevel2, new BasicBulletType(12f, 18f){{
                    splashDamageRadius = 10f;
                    splashDamage = 12f;
                    lifetime = 25f;
                    height = 10f;
                    width = 5f;
                    inaccuracy = 12f;
                    ammoMultiplier = 15f;
                    pierce = true;
                }},

                ADItems.ammoLevel3, new BasicBulletType(12f, 22f){{
                    splashDamageRadius = 12f;
                    splashDamage = 25f;
                    lifetime = 25f;
                    height = 10f;
                    inaccuracy = 8f;
                    width = 6f;
                    ammoMultiplier = 15f;
                    pierce = true;
                }},

                ADItems.homingAmmo, new BasicBulletType(12f, 32f){{
                    splashDamageRadius = 14f;
                    splashDamage = 18f;
                    lifetime = 25f;
                    height = 12f;
                    inaccuracy = 5f;
                    width = 6f;
                    ammoMultiplier = 15f;
                    homingPower = 0.2f;
                    statusDuration = 22f;
                    status = StatusEffects.burning;
                    pierce = true;
                }},

                ADItems.nanoAmmo, new BasicBulletType(12f, 5f){{
                    splashDamageRadius = 1f;
                    splashDamage = 1f;
                    lifetime = 25f;
                    ammoMultiplier = 15f;
                    statusDuration = 8000000f;
                    status = StatusEffects.burning;
                }},

                ADItems.livingSteel, new BasicBulletType(12f, 30f){{
                    splashDamageRadius = 6f;
                    splashDamage = 10f;
                    lifetime = 25f;
                    height = 12f;
                    inaccuracy = 4f;
                    width = 6f;
                    ammoMultiplier = 15f;
                    statusDuration = 3f;
                    status = StatusEffects.slow;
                }},

                ADItems.steelAmalgam, new BasicBulletType(12f, 9f){{
                    splashDamageRadius = 9f;
                    splashDamage = 16f;
                    lifetime = 25f;
                    lightning = 2;
                    lightningLength = 5;
                    lightningDamage = 11f;
                    ammoMultiplier = 15f;
                    collidesGround = true;
                    //shootEffect = null;
                }}
            );
        }};
    }
}
