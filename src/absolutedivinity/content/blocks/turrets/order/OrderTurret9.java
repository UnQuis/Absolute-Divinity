package absolutedivinity.content.blocks.turrets.order;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Mathf;
import arc.util.Time;
import arc.util.Tmp;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.Damage;
import mindustry.entities.Units;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.Bullet;
import mindustry.graphics.Drawf;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class OrderTurret9 {
    public static PowerTurret orderTurret9;

    public static void load() {{
        orderTurret9 = new PowerTurret("order-9") {{
            localizedName = "Order Singularity";
            description = "Generates a collapsing white gravity well that pulls enemies in before imploding.";
            size = 7;
            health = 10000;
            range = 400f;
            reload = 240f;
            rotateSpeed = 1.5f;
            shootCone = 30f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADEffects.orderChargeBig;
            heatColor = Color.white;
            consumePower(40f);
            consumeCoolant(0.6f);
            shootType = new BulletType() {
                {
                    speed = 3f;
                    lifetime = 140f;
                    hitEffect = Fx.none;
                    despawnEffect = Fx.none;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                    hittable = false;
                    absorbable = false;
                    collides = false;
                    keepVelocity = false;
                    drawSize = 400f;
                    damage = 3000f;
                    splashDamage = 2000f;
                    splashDamageRadius = 180f;
                    status = mindustry.content.StatusEffects.unmoving;
                    statusDuration = 60f;
                }

                @Override
                public void update(Bullet b) {
                    float phase = b.fin();
                    if (phase < 0.5f) {
                        float rad = 120f + phase * 80f;
                        float pull = 0.1f + phase * 0.06f;
                        Units.nearby(b.team, b.x, b.y, rad, u -> {
                            if(!u.dead()){
                                float dst = u.dst(b);
                                if(dst < rad && dst > 8f){
                                    u.impulse(Tmp.v1.set(b).sub(u).nor().scl(pull * (1f - dst / rad) * Time.delta * 12f));
                                }
                            }
                        });
                        if(b.timer(0, 8f)){
                            ADEffects.orderBlast.at(b.x, b.y, 0f);
                        }
                        if(b.timer(1, 15f)){
                            Angles.randLenVectors(b.id, 6, 60f * Mathf.clamp(b.time / 30f), (x, y) -> {
                                ADEffects.orderHitSmall.at(b.x + x, b.y + y);
                            });
                        }
                    } else {
                        b.vel.set(0f, 0f);
                        float expPhase = (phase - 0.5f) / 0.5f;
                        if (b.timer(2, 3f) && expPhase < 0.4f) {
                            Units.nearby(b.team, b.x, b.y, 160f * expPhase, u -> {
                                if(!u.dead()) u.damagePierce(50f);
                            });
                            ADEffects.orderBlast.at(b.x, b.y, 0f);
                        }
                        if (expPhase >= 1f) {
                            ADEffects.orderBlast.at(b.x, b.y, 0f);
                            Units.nearby(b.team, b.x, b.y, 180f, u -> {
                                if(!u.dead()){
                                    u.damagePierce(damage);
                                    u.apply(status, statusDuration);
                                }
                            });
                            Damage.damage(b.team, b.x, b.y, splashDamageRadius, splashDamage);
                            Drawf.light(b.x, b.y, 300f, Color.white, 1f);
                            b.remove();
                        }
                    }
                }

                @Override
                public void draw(Bullet b) {
                    float phase = b.fin();
                    float rad;
                    if (phase < 0.5f) {
                        rad = 20f + 40f * (phase / 0.5f);
                    } else {
                        rad = 60f + 100f * ((phase - 0.5f) / 0.5f);
                    }
                    Draw.color(Color.white, Color.valueOf("e0e0e0"), Mathf.absin(6f, 0.3f));
                    Lines.stroke(2f);
                    Lines.circle(b.x, b.y, rad);
                    Draw.color(Color.white, Color.valueOf("e0e0e0"), 0.4f);
                    Lines.stroke(1.5f);
                    Lines.circle(b.x, b.y, rad * 0.6f);
                    Drawf.light(b.x, b.y, 200f, Color.white, 0.8f);
                }
            };
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
