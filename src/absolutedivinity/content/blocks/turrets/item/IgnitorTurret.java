package fadingrevelations.content.blocks.turrets.item;

import arc.graphics.Color;
import arc.struct.ObjectMap;
import fadingrevelations.content.FRItems;
import mindustry.content.Items;
import mindustry.entities.bullet.ShrapnelBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.draw.DrawTurret;


public class IgnitorTurret {
    
    public static ItemTurret ignitor;

    public static void load(){
        ignitor = new ItemTurret("ignitor"){{
            localizedName = "Ignitor";
            description = "Fires many close-range piercing bolts at nearby enemies, akin to the fuse.";
            size = 5;
            health = 2000;
            reload = 45f;
            shake = 5f;
            range = 120f;
            recoil = 5f;
            inaccuracy = 9f;
            shootCone = 45f;
            coolantMultiplier = 0.6f;
            //shootSound =
            category = Category.turret;
            consumeCoolant(0.5f);
            requirements(Category.turret, ItemStack.with(
                Items.copper, 550,
                Items.graphite, 400,
                Items.thorium, 220,
                FRItems.cryogenicAlloy, 80
            ));
            ammoTypes = ObjectMap.of(
                Items.titanium, new ShrapnelBulletType(){{
                    length = 130f;
                    damage = 70f;
                    ammoMultiplier = 5f;
                    width = 12f;
                    reloadMultiplier = 1.3f;
                }},

                Items.thorium, new ShrapnelBulletType(){{
                    length = 130f;
                    damage = 100f;
                    ammoMultiplier = 6f;
                    toColor = Color.valueOf("f9a3c7");
                }},

                FRItems.cryogenicAlloy, new ShrapnelBulletType(){{
                    length = 130f;
                    damage = 180f;
                    ammoMultiplier = 7f;
                    toColor = Color.valueOf("8ce8f1");
                }}
            );

            drawer = new DrawTurret(){{
                parts.add(new RegionPart("-barrel"){{
                    mirror = false;
                    under = true;
                    heatProgress = PartProgress.recoil;
                    progress = PartProgress.recoil;
                    moveY = -4f;
                }});

                parts.add(new RegionPart("-top"){{
                    mirror = false;
                    under = false;
                    heatProgress = PartProgress.recoil;
                    progress = PartProgress.recoil;
                }});
            }};
        }};
    }
}
