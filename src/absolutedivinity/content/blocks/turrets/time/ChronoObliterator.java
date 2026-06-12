package absolutedivinity.content.blocks.turrets.time;

import absolutedivinity.content.ADItems;
import absolutedivinity.content.ADTurretEffects;
import absolutedivinity.content.ADNHEffects;
import absolutedivinity.content.ADColor;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Interp;
import arc.math.Mathf;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.Effect;
import mindustry.entities.Units;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.gen.Bullet;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ChronoObliterator {
    public static ItemTurret chronoObliterator;

    public static void load() {{
        chronoObliterator = new ItemTurret("chrono-oblivion") {{
            localizedName = "Chrono Obliterator";
            description = "Opens a temporal rift that freezes everything in a massive zone before detonating.";
            size = 9;
            health = 70000;
            armor = 16;
            range = 380f;
            reload = 260f;
            rotateSpeed = 0.9f;
            shootCone = 5f;
            targetAir = true;
            targetGround = true;
            minWarmup = 0.88f;
            shootWarmupSpeed = 0.014f;
            shootEffect = new MultiEffect(
                ADNHEffects.instShoot,
                ADNHEffects.crossBlast
            );
            smokeEffect = ADTurretEffects.shootBig(ADColor.timeDark);
            heatColor = ADColor.timeMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 5000,
                Items.silicon, 4000,
                Items.titanium, 2800,
                Items.thorium, 1800,
                Items.surgeAlloy, 1000
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new BasicBulletType(4f, 80f) {
                {
                    lifetime = 40f;
                    hitEffect = Fx.none;
                    despawnEffect = Fx.none;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                    collides = false;
                    collidesAir = false;
                    collidesGround = false;
                    hittable = false;
                    absorbable = false;
                    keepVelocity = false;
                    drawSize = 400f;
                    damage = 0f;
                }

                @Override
                public void update(Bullet b) {
                    super.update(b);
                    float phase = b.fin();
                    float freezeRange = 200f;

                    if(phase < 0.7f) {
                        float expandPhase = phase / 0.7f;
                        Units.nearby(b.team, b.x, b.y, freezeRange * expandPhase, u -> {
                            if(u.dead() || u.team == b.team) return;
                            u.apply(StatusEffects.freezing, 8f);
                            u.apply(StatusEffects.slow, 8f);
                            u.vel.scl(0.92f);
                        });

                        if(b.timer(0, 6f)) {
                            new Effect(40f, 160f, e -> {
                                Draw.color(ADColor.timeMain, ADColor.timeLight, e.fin());
                                Lines.stroke(2f * e.fout());
                                Lines.circle(e.x, e.y, e.fin() * freezeRange * 0.8f);
                                for(int i = 0; i < 12; i++) {
                                    float ang = 360f / 12 * i;
                                    float dist = freezeRange * 0.6f * e.fin();
                                    Fill.circle(e.x + Mathf.cosDeg(ang) * dist, e.y + Mathf.sinDeg(ang) * dist, 3f * e.fout());
                                }
                            }).at(b.x, b.y);
                        }
                    } else {
                        float expPhase = (phase - 0.7f) / 0.3f;
                        if(expPhase < 0.1f && b.timer(1, 2f)) {
                            Units.nearby(b.team, b.x, b.y, 250f, u -> {
                                if(u.dead() || u.team == b.team) return;
                                u.damagePierce(150f);
                                u.apply(StatusEffects.freezing, 300f);
                                u.apply(StatusEffects.slow, 300f);
                            });
                            new Effect(70f, 300f, e -> {
                                Draw.color(ADColor.timeMain, Color.white, e.fin());
                                Lines.stroke(5f * e.fout());
                                Lines.circle(e.x, e.y, e.fin() * 250f);
                                Angles.randLenVectors(e.id, 35, 250f * e.fin(), (x, y) -> Fill.circle(e.x + x, e.y + y, 4f * e.fout()));
                            }).at(b.x, b.y);
                        }
                        if(expPhase >= 0.3f) {
                            Fx.massiveExplosion.at(b.x, b.y, 0f, ADColor.timeMain);
                            b.remove();
                        }
                    }
                }
            });
            ammo(ADItems.divinite, new BasicBulletType(5f, 150f) {
                {
                    lifetime = 50f;
                    hitEffect = Fx.none;
                    despawnEffect = Fx.none;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                    collides = false;
                    collidesAir = false;
                    collidesGround = false;
                    hittable = false;
                    absorbable = false;
                    keepVelocity = false;
                    drawSize = 500f;
                    damage = 0f;
                }

                @Override
                public void update(Bullet b) {
                    super.update(b);
                    float phase = b.fin();
                    float freezeRange = 300f;

                    if(phase < 0.7f) {
                        float expandPhase = phase / 0.7f;
                        Units.nearby(b.team, b.x, b.y, freezeRange * expandPhase, u -> {
                            if(u.dead() || u.team == b.team) return;
                            u.apply(StatusEffects.freezing, 12f);
                            u.apply(StatusEffects.slow, 12f);
                            u.vel.scl(0.88f);
                        });

                        if(b.timer(0, 5f)) {
                            new Effect(50f, 200f, e -> {
                                Draw.color(ADColor.timeMain, ADColor.timeLight, e.fin());
                                Lines.stroke(3f * e.fout());
                                Lines.circle(e.x, e.y, e.fin() * freezeRange * 0.8f);
                                for(int i = 0; i < 16; i++) {
                                    float ang = 360f / 16 * i;
                                    float dist = freezeRange * 0.7f * e.fin();
                                    Fill.circle(e.x + Mathf.cosDeg(ang) * dist, e.y + Mathf.sinDeg(ang) * dist, 4f * e.fout());
                                }
                            }).at(b.x, b.y);
                        }
                    } else {
                        float expPhase = (phase - 0.7f) / 0.3f;
                        if(expPhase < 0.1f && b.timer(1, 2f)) {
                            Units.nearby(b.team, b.x, b.y, 350f, u -> {
                                if(u.dead() || u.team == b.team) return;
                                u.damagePierce(300f);
                                u.apply(StatusEffects.freezing, 600f);
                                u.apply(StatusEffects.slow, 600f);
                            });
                            new Effect(90f, 400f, e -> {
                                Draw.color(ADColor.timeMain, Color.white, e.fin());
                                Lines.stroke(7f * e.fout());
                                Lines.circle(e.x, e.y, e.fin() * 350f);
                                Angles.randLenVectors(e.id, 45, 350f * e.fin(), (x, y) -> Fill.circle(e.x + x, e.y + y, 5f * e.fout()));
                            }).at(b.x, b.y);
                        }
                        if(expPhase >= 0.3f) {
                            Fx.massiveExplosion.at(b.x, b.y, 0f, ADColor.timeMain);
                            b.remove();
                        }
                    }
                }
            });
        }};
    }}
}
