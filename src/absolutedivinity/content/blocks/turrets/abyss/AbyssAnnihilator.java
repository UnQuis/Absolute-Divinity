package absolutedivinity.content.blocks.turrets.abyss;

import absolutedivinity.content.ADItems;
import absolutedivinity.content.ADTurretEffects;
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

public class AbyssAnnihilator {
    public static ItemTurret abyssAnnihilator;

    public static void load() {{
        abyssAnnihilator = new ItemTurret("abyss-annihilator") {{
            localizedName = "Abyss Annihilator";
            description = "Opens a gravitational singularity that pulls enemies in before detonating in a purple cataclysm.";
            size = 10;
            health = 80000;
            armor = 18;
            range = 450f;
            reload = 240f;
            rotateSpeed = 0.8f;
            shootCone = 5f;
            targetAir = true;
            targetGround = true;
            minWarmup = 0.88f;
            shootWarmupSpeed = 0.015f;
            shootEffect = new MultiEffect(
                ADTurretEffects.shootBig(ADColor.abyssMain),
                new WaveEffect() {{
                    sizeFrom = 0f;
                    sizeTo = 150f;
                    colorFrom = ADColor.abyssMain;
                    colorTo = ADColor.abyssDark;
                    strokeFrom = 8f;
                    strokeTo = 0f;
                    interp = Interp.pow5Out;
                }}
            );
            smokeEffect = ADTurretEffects.shootBig(ADColor.abyssDark);
            heatColor = ADColor.abyssMain;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 6000,
                Items.silicon, 5000,
                Items.titanium, 3500,
                Items.thorium, 2000,
                Items.surgeAlloy, 1200
            ));
            category = Category.turret;
            ammo(Items.surgeAlloy, new BasicBulletType(4f, 100f) {
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
                    float pullRange = 180f;
                    float pullStr = 0.15f;

                    if(phase < 0.7f) {
                        float expandPhase = phase / 0.7f;
                        Units.nearby(b.team, b.x, b.y, pullRange * expandPhase, u -> {
                            if(u.dead() || u.team == b.team) return;
                            float dst = u.dst(b);
                            if(dst < 5f) return;
                            float str = pullStr * (1f - dst / pullRange) * (1f - expandPhase * 0.5f);
                            u.vel.trns(u.angleTo(b), str * 100f);
                            u.apply(StatusEffects.unmoving, 4f);
                            if(dst < 30f) u.damage(15f);
                        });

                        if(b.timer(0, 8f)) {
                            new Effect(40f, 120f, e -> {
                                Draw.color(ADColor.abyssMain, ADColor.abyssLight, e.fin());
                                Lines.stroke(2f * e.fout());
                                Lines.circle(e.x, e.y, e.fin() * pullRange * 0.8f);
                                for(int i = 0; i < 8; i++) {
                                    float ang = 360f / 8 * i + e.time * 50f;
                                    float dist = pullRange * 0.7f * e.fin();
                                    Fill.circle(e.x + Mathf.cosDeg(ang) * dist, e.y + Mathf.sinDeg(ang) * dist, 3f * e.fout());
                                }
                            }).at(b.x, b.y);
                        }
                    } else {
                        float expPhase = (phase - 0.7f) / 0.3f;
                        if(expPhase < 0.1f && b.timer(1, 2f)) {
                            Units.nearby(b.team, b.x, b.y, 200f, u -> {
                                if(u.dead() || u.team == b.team) return;
                                u.damagePierce(200f);
                                u.apply(StatusEffects.melting, 120f);
                            });
                            new Effect(60f, 250f, e -> {
                                Draw.color(ADColor.abyssMain, Color.white, e.fin());
                                Lines.stroke(4f * e.fout());
                                Lines.circle(e.x, e.y, e.fin() * 200f);
                                Angles.randLenVectors(e.id, 30, 200f * e.fin(), (x, y) -> Fill.circle(e.x + x, e.y + y, 4f * e.fout()));
                            }).at(b.x, b.y);
                        }
                        if(expPhase >= 0.3f) {
                            Fx.massiveExplosion.at(b.x, b.y, 0f, ADColor.abyssMain);
                            b.remove();
                        }
                    }
                }
            });
            ammo(ADItems.divinite, new BasicBulletType(5f, 200f) {
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
                    float pullRange = 250f;
                    float pullStr = 0.2f;

                    if(phase < 0.7f) {
                        float expandPhase = phase / 0.7f;
                        Units.nearby(b.team, b.x, b.y, pullRange * expandPhase, u -> {
                            if(u.dead() || u.team == b.team) return;
                            float dst = u.dst(b);
                            if(dst < 5f) return;
                            float str = pullStr * (1f - dst / pullRange) * (1f - expandPhase * 0.5f);
                            u.vel.trns(u.angleTo(b), str * 120f);
                            u.apply(StatusEffects.unmoving, 6f);
                            if(dst < 40f) u.damage(30f);
                        });

                        if(b.timer(0, 6f)) {
                            new Effect(50f, 160f, e -> {
                                Draw.color(ADColor.abyssMain, ADColor.abyssLight, e.fin());
                                Lines.stroke(3f * e.fout());
                                Lines.circle(e.x, e.y, e.fin() * pullRange * 0.8f);
                                for(int i = 0; i < 12; i++) {
                                    float ang = 360f / 12 * i + e.time * 60f;
                                    float dist = pullRange * 0.7f * e.fin();
                                    Fill.circle(e.x + Mathf.cosDeg(ang) * dist, e.y + Mathf.sinDeg(ang) * dist, 4f * e.fout());
                                }
                            }).at(b.x, b.y);
                        }
                    } else {
                        float expPhase = (phase - 0.7f) / 0.3f;
                        if(expPhase < 0.1f && b.timer(1, 2f)) {
                            Units.nearby(b.team, b.x, b.y, 300f, u -> {
                                if(u.dead() || u.team == b.team) return;
                                u.damagePierce(400f);
                                u.apply(StatusEffects.melting, 240f);
                            });
                            new Effect(80f, 350f, e -> {
                                Draw.color(ADColor.abyssMain, Color.white, e.fin());
                                Lines.stroke(6f * e.fout());
                                Lines.circle(e.x, e.y, e.fin() * 300f);
                                Angles.randLenVectors(e.id, 40, 300f * e.fin(), (x, y) -> Fill.circle(e.x + x, e.y + y, 5f * e.fout()));
                            }).at(b.x, b.y);
                        }
                        if(expPhase >= 0.3f) {
                            Fx.massiveExplosion.at(b.x, b.y, 0f, ADColor.abyssMain);
                            b.remove();
                        }
                    }
                }
            });
        }};
    }}
}
