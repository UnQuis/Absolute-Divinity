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
import mindustry.entities.pattern.ShootPattern;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class InfernoTurret {

    public static ItemTurret sunflare;

    public static void load() {
        sunflare = new ItemTurret("inferno") {{
            localizedName = "Inferno";
            description = "Engulfs a wide area in relentless flames, incinerating anything that dares approach.";
            size = 4;
            health = 1900;
            range = 260f;
            reload = 5.5f;
            shoot = new ShootPattern() {{
                shots = 14;
            }};
            //shootSound = Sounds.flame;
            ammoTypes = ObjectMap.of(
                Items.coal, new BasicBulletType(6f, 4f) {{
                    pierce = true;
                    pierceBuilding = true;
                    pierceCap = 2;
                    ammoMultiplier = 12;
                    status = StatusEffects.burning;
                    makeFire = true;
                    lifetime = 48f;
                    despawnEffect = Fx.none;
                    width = 0.01f;
                    height = 0.01f;
                    smokeEffect = new ParticleEffect() {{
                        particles = 30;
                        length = 320f;
                        lifetime = 36f;
                        interp = Interp.circleOut;
                        cone = 9f;
                        colorFrom = Color.valueOf("ffdd55");
                        colorTo = Color.valueOf("db401c");
                        sizeFrom = 4f;
                        sizeTo = 0.6f;
                    }};
                    hitEffect = Fx.hitFlameSmall;
                    despawnEffect = Fx.none;
                    hittable = false;
                    reflectable = false;
                }},
                Items.pyratite, new BasicBulletType(6f, 8f) {{
                    pierce = true;
                    pierceBuilding = true;
                    pierceCap = 2;
                    ammoMultiplier = 17;
                    status = StatusEffects.burning;
                    makeFire = true;
                    lifetime = 48f;
                    width = 0.01f;
                    despawnEffect = Fx.none;
                    height = 0.01f;
                    smokeEffect = new ParticleEffect() {{
                        particles = 30;
                        length = 320f;
                        lifetime = 36f;
                        interp = Interp.circleOut;
                        cone = 9f;
                        colorFrom = Color.valueOf("ffdd55");
                        colorTo = Color.valueOf("db401c");
                        sizeFrom = 4f;
                        sizeTo = 0.6f;
                    }};
                    hitEffect = Fx.hitFlameSmall;
                    despawnEffect = Fx.none;
                    hittable = false;
                    reflectable = false;
                }},
                Items.blastCompound, new BasicBulletType(6f, 10f) {{
                    pierce = true;
                    pierceBuilding = true;
                    ammoMultiplier = 18;
                    pierceCap = 2;
                    status = StatusEffects.blasted;
                    makeFire = true;
                    lifetime = 48f;
                    width = 0.01f;
                    despawnEffect = Fx.none;
                    height = 0.01f;
                    smokeEffect = new ParticleEffect() {{
                        particles = 30;
                        length = 320f;
                        lifetime = 36f;
                        interp = Interp.circleOut;
                        cone = 9f;
                        colorFrom = Color.valueOf("ffdd55");
                        colorTo = Color.valueOf("db401c");
                        sizeFrom = 4f;
                        sizeTo = 0.6f;
                    }};
                    hitEffect = Fx.hitFlameSmall;
                    despawnEffect = Fx.none;
                    hittable = false;
                    reflectable = false;
                }},
                ADItems.livingSteel, new BasicBulletType(6f, 12f) {{
                    pierce = true;
                    pierceBuilding = true;
                    pierceCap = 2;
                    ammoMultiplier = 20;
                    status = StatusEffects.melting;
                    makeFire = true;
                    lifetime = 48f;
                    width = 0.01f;
                    despawnEffect = Fx.none;
                    height = 0.01f;
                    smokeEffect = new ParticleEffect() {{
                        particles = 30;
                        length = 320f;
                        lifetime = 36f;
                        interp = Interp.circleOut;
                        cone = 9f;
                        colorFrom = Color.valueOf("ffdd55");
                        colorTo = Color.valueOf("db401c");
                        sizeFrom = 4f;
                        sizeTo = 0.6f;
                    }};
                    hitEffect = Fx.hitFlameSmall;
                    despawnEffect = Fx.none;
                    hittable = false;
                    reflectable = false;
                }},
                ADItems.steelAmalgam, new BasicBulletType(6f, 16f) {{
                    pierce = true;
                    pierceBuilding = true;
                    pierceCap = 2;
                    ammoMultiplier = 28;
                    status = StatusEffects.melting;
                    makeFire = true;
                    lifetime = 48f;
                    width = 0.01f;
                    despawnEffect = Fx.none;
                    despawnHit = false;
                    lightning = 2;
                    lightningLength = 2;
                    lightningDamage = 8f;
                    height = 0.01f;
                    smokeEffect = new ParticleEffect() {{
                        particles = 30;
                        length = 320f;
                        lifetime = 36f;
                        interp = Interp.circleOut;
                        cone = 9f;
                        colorFrom = Color.valueOf("ffdd55");
                        colorTo = Color.valueOf("db401c");
                        sizeFrom = 4f;
                        sizeTo = 0.6f;
                    }};
                    hitEffect = Fx.hitFlameSmall;
                    despawnEffect = Fx.none;
                    hittable = false;
                    reflectable = false;
                }}
            );
            category = Category.turret;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 2200,
                Items.lead, 3200,
                Items.graphite, 2200,
                Items.titanium, 1600,
                Items.plastanium, 700,
                ADItems.steelAmalgam, 450
            ));
        }};
    }
}
