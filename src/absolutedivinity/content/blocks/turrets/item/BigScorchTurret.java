package absolutedivinity.content.blocks.turrets.item;

import absolutedivinity.content.ADItems;
import arc.graphics.Color;
import arc.math.Interp;
import arc.struct.ObjectMap;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.ParticleEffect;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class BigScorchTurret {

    public static ItemTurret sear;

    public static void load() {
        sear = new ItemTurret("big-scorch") {{
            localizedName = "Big Scorch";
            description = "Singes nearby enemies with intense heat, leaving a trail of fire and devastation.";
            size = 2;
            health = 880;
            range = 120f;
            reload = 6f;
            recoil = 1f;
            targetAir = false;
            //shootSound = Sounds.flame;
            category = Category.turret;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 55,
                Items.graphite, 44
            ));
            ammoTypes = ObjectMap.of(
                Items.coal, new BasicBulletType(6f, 28f) {{
                    pierce = true;
                    pierceBuilding = true;
                    ammoMultiplier = 5;
                    status = StatusEffects.burning;
                    makeFire = true;
                    lifetime = 20f;
                    despawnEffect = Fx.none;
                    width = 0.01f;
                    height = 0.01f;
                    smokeEffect = new ParticleEffect() {{
                        particles = 30;
                        length = 160f;
                        lifetime = 36f;
                        interp = Interp.circleOut;
                        cone = 3f;
                        colorFrom = Color.valueOf("ffdd55");
                        colorTo = Color.valueOf("db401c");
                        sizeFrom = 4f;
                        sizeTo = 0.6f;
                    }};
                }},
                Items.pyratite, new BasicBulletType(6f, 40f) {{
                    pierce = true;
                    pierceBuilding = true;
                    ammoMultiplier = 7;
                    status = StatusEffects.burning;
                    makeFire = true;
                    lifetime = 20f;
                    width = 0.01f;
                    despawnEffect = Fx.none;
                    height = 0.01f;
                    smokeEffect = new ParticleEffect() {{
                        particles = 30;
                        length = 160f;
                        lifetime = 36f;
                        interp = Interp.circleOut;
                        cone = 3f;
                        colorFrom = Color.valueOf("ffdd55");
                        colorTo = Color.valueOf("db401c");
                        sizeFrom = 4f;
                        sizeTo = 0.6f;
                    }};
                }},
                ADItems.livingSteel, new BasicBulletType(6f, 50f) {{
                    pierce = true;
                    pierceBuilding = true;
                    ammoMultiplier = 8;
                    status = StatusEffects.melting;
                    makeFire = true;
                    lifetime = 20f;
                    width = 0.01f;
                    despawnEffect = Fx.none;
                    height = 0.01f;
                    smokeEffect = new ParticleEffect() {{
                        particles = 30;
                        length = 160f;
                        lifetime = 36f;
                        interp = Interp.circleOut;
                        cone = 3f;
                        colorFrom = Color.valueOf("ffdd55");
                        colorTo = Color.valueOf("db401c");
                        sizeFrom = 4f;
                        sizeTo = 0.6f;
                    }};
                }}
            );
        }};
    }
}
