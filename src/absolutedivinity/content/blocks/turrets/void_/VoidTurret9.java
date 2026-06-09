package absolutedivinity.content.blocks.turrets.void_;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import arc.math.geom.Vec2;
import arc.util.Time;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.Units;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.Bullet;
import mindustry.graphics.Drawf;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class VoidTurret9 {
    public static PowerTurret voidTurret9;

    public static void load() {{
        voidTurret9 = new PowerTurret("void-9") {{
            localizedName = "Void Singularity";
            description = "Creates a miniature singularity that pulls enemies inward before detonating in a cataclysmic silver blast.";
            size = 6;
            health = 11000;
            range = 340f;
            reload = 280f;
            rotateSpeed = 2f;
            shootCone = 5f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADEffects.voidChargeBig;
            heatColor = Color.white;
            consumePower(40f);
            consumeCoolant(2f);
            shootType = new BulletType() {
                {
                    damage = 0f;
                    speed = 0f;
                    lifetime = 160f;
                    hitEffect = Fx.none;
                    despawnEffect = Fx.none;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                    hittable = false;
                    collides = false;
                    keepVelocity = false;
                    drawSize = 300f;
                }

                @Override
                public void update(Bullet b) {
                    super.update(b);
                    float phase = b.fin();
                    if (phase < 0.7f) {
                        float pullRange = 80f + phase * 120f;
                        float pullStr = 0.06f + phase * 0.08f;
                        Units.nearby(b.team, b.x, b.y, pullRange, u -> {
                            if (u.dead() || u.team == b.team) return;
                            float dst = u.dst(b);
                            if (dst < 2f) return;
                            Vec2 vec = new Vec2(b.x - u.x, b.y - u.y).setLength(pullStr * (1f - dst / pullRange));
                            u.vel.add(vec);
                            u.apply(StatusEffects.unmoving, 8f);
                            if (dst < 30f) {
                                u.damagePierce(3f);
                            }
                        });
                        if (b.timer(0, 15f)) {
                            ADEffects.voidSingularityPulse.at(b.x, b.y);
                        }
                    } else {
                        float expPhase = (phase - 0.7f) / 0.3f;
                        if (b.timer(1, 3f) && expPhase < 0.5f) {
                            Units.nearby(b.team, b.x, b.y, 200f * expPhase, u -> {
                                if (u.dead() || u.team == b.team) return;
                                u.damagePierce(30f);
                                u.apply(StatusEffects.shocked, 60f);
                            });
                            ADEffects.voidBlast.at(b.x, b.y, 200f * expPhase);
                        }
                        if (expPhase >= 1f) {
                            ADEffects.voidSingularityPulse.at(b.x, b.y);
                            Units.nearby(b.team, b.x, b.y, 250f, u -> {
                                if (u.dead() || u.team == b.team) return;
                                u.damagePierce(800f);
                                u.apply(StatusEffects.melting, 300f);
                                u.apply(StatusEffects.slow, 300f);
                            });
                            Fx.massiveExplosion.at(b.x, b.y, 0f, Color.white);
                            b.remove();
                        }
                    }
                }

                @Override
                public void draw(Bullet b) {
                    float phase = b.fin();
                    float rad, innerRad;
                    Color c1, c2;
                    if (phase < 0.7f) {
                        float p = phase / 0.7f;
                        rad = 14f + p * 40f;
                        innerRad = rad * 0.3f;
                        c1 = ADEffects.voidGlow;
                        c2 = ADEffects.voidSilver;
                    } else {
                        float p = (phase - 0.7f) / 0.3f;
                        rad = 54f + p * 200f;
                        innerRad = rad * 0.4f;
                        c1 = Color.white;
                        c2 = ADEffects.voidGlow;
                    }
                    Draw.color(c1, c2, Mathf.absin(Time.time, 4f, 0.3f));
                    Drawf.light(b.x, b.y, rad * 3f, Color.white, 0.7f);
                    Fill.circle(b.x, b.y, rad);
                    Draw.color(Color.white, ADEffects.voidLight, 0.5f);
                    Fill.circle(b.x, b.y, innerRad);
                    Draw.color(Color.valueOf("18182a"));
                    Fill.circle(b.x, b.y, innerRad * 0.3f);
                    Lines.stroke(2f * (1f - phase));
                    Draw.color(Color.white, 0.5f);
                    Lines.circle(b.x, b.y, rad * 1.2f);
                }
            };
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
