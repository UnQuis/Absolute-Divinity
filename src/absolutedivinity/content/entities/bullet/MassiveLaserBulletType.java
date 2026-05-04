package absolutedivinity.content.entities.bullet;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.units.*;
import mindustry.game.*;
import mindustry.game.Teams.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.blocks.defense.turrets.Turret.*;

public class MassiveLaserBulletType extends BulletType{
    public float width = 180f;
    public float length = 2500f;
    public float shake = 1f;

    float end = 340f;
    Interp dwidth = Interp.circleOut;
    public Color[] colors = {Pal.accent.cpy().a(0.4f), Pal.accent, Color.white};
    float[] widths = {1.5f, 1f, 0.8f};
    public boolean useLaserParticles = true;

    TextureRegion hcircle;

    public MassiveLaserBulletType(){
        speed = 0f;
        collides = collidesTiles = false;
        absorbable = false;
        hittable = false;
        keepVelocity = false;

        removeAfterPierce = false;
        pierce = true;
        pierceArmor = true;
        pierceCap = -1;
        impact = true;

        lifetime = 15f * 60f;

        despawnEffect = Fx.none;
        shootEffect = Fx.none;
        hitEffect = Fx.none;

        status = StatusEffects.disarmed;
        statusDuration = 90f;

        damage = 12000f;

        drawSize = length * 2.1f;

        knockback = 60f;

        layer = (Layer.bullet + Layer.effect) / 2;
    }

    @Override
    public void load(){
        hcircle = Core.atlas.find("hcircle");
    }

    float getLaserWidth(float dst){
        return dwidth.apply(Mathf.clamp(dst / end));
    }
    float timeWidth(Bullet b){
        float w1 = 5f;
        return (w1 * Mathf.clamp(b.time / 60f) + (width - w1) * Interp.pow2Out.apply(Mathf.clamp((b.time - 140f) / 5))) * Interp.pow3In.apply(Mathf.clamp((lifetime - b.time) / 80f));
    }

    void handleDamage(Healthc e, Bullet b){
        float mul;
        if(e instanceof Unit){
            Unit u = (Unit) e;
            mul = Math.max(1, u.healthMultiplier);
        }else if(e instanceof Building){
            Building bl = (Building) e;
            mul = damage / Math.min(damage, bl.handleDamage(damage));
        }else{
            mul = 1f;
        }

        float health = e.health();

        if(e instanceof Unit){
            Unit u = (Unit) e;
            float sss = Interp.pow2In.apply(Mathf.clamp(1 - b.dst(u) / length)) * length;
            Tmp.v3.set(u).sub(b).nor().scl((knockback + sss / (2 * (1.3157894f))) * 80f);
            if(impact) Tmp.v3.setAngle(b.rotation() + (knockback < 0 ? 180f : 0f));

            if(b.time < 140f){
                u.apply(StatusEffects.freezing, 8f);
            }else{
                u.impulse(Tmp.v3);
                u.vel.add(Tmp.v3.scl(1 / (80f * 100)));
                u.vel.limit(Mathf.pow(24f, 1 + u.drag));
                if(Float.isNaN(u.health) || Float.isNaN(u.shield)) u.destroy();
            }

            u.clearStatuses();
            u.apply(StatusEffects.disarmed, statusDuration);
            u.apply(StatusEffects.melting, 60f);

            for(WeaponMount m : u.mounts){
                m.reload = m.weapon.reload;
            }
            health = u.health;
        }
        if(e instanceof Building){
            Building bl = (Building) e;
            bl.applyHealSuppression(120f);
            bl.applySlowdown(0.1f, 120f);

            if(bl instanceof TurretBuild){
                TurretBuild tr = (TurretBuild) bl;
                tr.reloadCounter = Math.max(0, tr.reloadCounter - 4f * Time.delta);
            }

            health = bl.health;
            if(bl.team == Team.derelict && b.time >= 140f){
                Sounds.explosion.at(bl.x, bl.y);
                Fx.none.at(bl.x, bl.y, bl.hitSize() / 2f);
                bl.tile.remove();
            }
        }

        if(b.time >= 140f){
            float tscl = Mathf.clamp((lifetime - b.time) / 80f);
            float dam = Math.max(Math.max(b.damage, damage), (e.maxHealth() * mul) / 50f) * tscl;
            e.damagePierce(dam);
        }
    }

    @Override
    public void init(Bullet b){
        Tmp.v1.trns(b.rotation(), 40f).add(b.x, b.y);
        Fx.none.at(Tmp.v1.x, Tmp.v1.y, 120f, b.rotation());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void update(Bullet b){
        if(b.timer(0, 5f)){
            Vec2 v = Tmp.v2.trns(b.rotation(), length).add(b.x, b.y);
            float vx = v.x;
            float vy = v.y;
            float dw = timeWidth(b);

            float minX = Math.min(b.x, vx) - dw;
            float maxX = Math.max(b.x, vx) + dw;
            float minY = Math.min(b.y, vy) - dw;
            float maxY = Math.max(b.y, vy) + dw;
            Rect lineRect = Tmp.r1.set(minX, minY, maxX - minX, maxY - minY);

            Fx.trailFade.at(b.x, b.y, b.rotation(), dw * 2f);

            for(TeamData data : Vars.state.teams.present){
                if(data.team != b.team){

                    if(data.unitTree != null){
                        data.unitTree.intersect(lineRect, (Unit u) -> {
                            Vec2 nearest = Intersector.nearestSegmentPoint(b.x, b.y, vx, vy, u.x, u.y, Tmp.v3);
                            float dst = b.dst(nearest);
                            float lw = getLaserWidth(dst) * dw * 0.5f;

                            if(u.dst(nearest) <= lw + u.hitSize / 2f){
                                Fx.none.at(nearest.x, nearest.y, b.angleTo(nearest), u);
                                Fx.none.at(nearest.x, nearest.y, b.rotation(), u.team.color);
                                if(b.time > 140f){
                                    Fx.none.at(nearest.x, nearest.y, b.rotation(), u);
                                    Fx.none.at(nearest.x, nearest.y, b.rotation(), u);
                                }
                                handleDamage(u, b);
                            }
                        });
                    }

                    if(data.buildingTree != null){
                        data.buildingTree.intersect(lineRect, (Building bl) -> {
                            Vec2 nearest = Intersector.nearestSegmentPoint(b.x, b.y, vx, vy, bl.x, bl.y, Tmp.v3);
                            float dst = b.dst(nearest);
                            float lw = getLaserWidth(dst) * dw * 0.5f;

                            if(bl.dst(nearest) <= lw + bl.hitSize() / 2f){
                                Fx.none.at(nearest.x, nearest.y, b.angleTo(nearest), bl);
                                Fx.none.at(nearest.x, nearest.y, b.rotation(), bl.team.color);
                                if(b.time > 140f){
                                    Fx.none.at(nearest.x, nearest.y, b.rotation(), bl.hitSize());
                                    Fx.none.at(nearest.x, nearest.y, b.rotation(), bl.hitSize());
                                }
                                handleDamage(bl, b);
                            }
                        });
                    }
                }
            }

            ((QuadTree<Bullet>)Groups.bullet.tree()).intersect(lineRect, (Bullet bl) -> {
                if(bl.team == b.team) return;

                Vec2 nearest = Intersector.nearestSegmentPoint(b.x, b.y, vx, vy, bl.x, bl.y, Tmp.v3);
                float dst = b.dst(nearest);
                float lw = getLaserWidth(dst) * dw * 0.5f;

                if(bl.dst(nearest) <= lw + bl.hitSize / 2f){
                    if(bl.type.speed > 0.001 || Angles.within(bl.angleTo(b), bl.rotation(), 2)){
                        Fx.none.at(nearest.x, nearest.y, b.angleTo(nearest), bl);
                        Fx.none.at(nearest.x, nearest.y, bl.rotation(), bl.type.hitColor);
                        bl.hit = false;
                        bl.remove();
                        bl.type.despawnEffect.at(bl.x, bl.y, bl.rotation(), bl.type.hitColor);
                    }
                }
            });

            Fx.none.at(b.x, b.y, b.rotation(), dw);

            if(b.owner instanceof Healthc && ((Healthc)b.owner).dead() && b.time < lifetime - 80f){
                b.fdata = 2;
                if(b.time > 140f){
                    b.time = lifetime - 80f;
                }else{
                    Fx.trailFade.at(b.x, b.y, b.rotation());
                    b.remove();
                    return;
                }
            }

            if(b.fdata < 1 && b.time > 140f){
                b.fdata = 2;

                Tmp.v1.trns(b.rotation(), 70f).add(b.x, b.y);
                Fx.none.at(Tmp.v1.x, Tmp.v1.y, 220f, b.rotation());

                Tmp.v1.trns(b.rotation(), 180f).add(b.x, b.y);
                Fx.none.at(Tmp.v1.x, Tmp.v1.y, 380f, b.rotation());

                Fx.none.at(b.x, b.y, b.rotation());

                Vars.renderer.shake(90f, 110f);
            }
        }
    }

    void drawDiamond(float x, float y, float dw, float dh, float rotation){
        float halfW = dw / 2f;
        float halfH = dh / 2f;
        float cos = Mathf.cosDeg(rotation);
        float sin = Mathf.sinDeg(rotation);

        float x1 = x - halfW * cos - halfH * sin;
        float y1 = y - halfW * sin + halfH * cos;
        float x2 = x - halfW * cos + halfH * sin;
        float y2 = y - halfW * sin - halfH * cos;
        float x3 = x + halfW * cos + halfH * sin;
        float y3 = y + halfW * sin - halfH * cos;
        float x4 = x + halfW * cos - halfH * sin;
        float y4 = y + halfW * sin + halfH * cos;

        Fill.quad(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    void drawEnergyShard(float x, float y, float dw, float dh, float rotation){
        float len = dh;
        float w = dw;

        Tmp.v1.trns(rotation, len);
        Tmp.v2.trns(rotation + 180f, len * 0.3f);

        float x1 = x + Tmp.v1.x;
        float y1 = y + Tmp.v1.y;

        float x2 = x - Tmp.v1.x * 0.3f + Tmp.v2.x;
        float y2 = y - Tmp.v1.y * 0.3f + Tmp.v2.y;

        Lines.stroke(w);
        Lines.line(x1, y1, x2, y2);
    }

    @Override
    public void draw(Bullet b){
        Vec2 v = Tmp.v1.trns(b.rotation(), end).add(b.x, b.y);
        Vec2 v2 = Tmp.v2.trns(b.rotation(), length - end).add(v.x, v.y);
        float w = timeWidth(b);

        float pulse = Mathf.absin(6f, 0.12f) + Mathf.randomSeed(b.id, 0.03f);

        for(int i = 0; i < 3; i++){
            float dw = w * widths[i] * (1f + pulse);

            Draw.color(colors[i], 1f - i * 0.25f);
            Lines.stroke(dw);

            Draw.rect(hcircle, v.x, v.y, end * 2f + dw * 0.2f, Lines.getStroke(), b.rotation() + 180f);
            Lines.lineAngle(v.x, v.y, b.rotation(), length - end, false);

            Drawf.tri(v2.x, v2.y, Lines.getStroke(), width * 2f + dw * (1f - i * 0.2f), b.rotation());
        }

        if(useLaserParticles && b.time > 140f){
            float scl = Interp.pow2Out.apply(Mathf.clamp((b.time - 140f) / 5f)) *
                Interp.pow3In.apply(Mathf.clamp((lifetime - b.time) / 80f));

            Rand r = new Rand();
            Rand r2 = new Rand();
            r.setSeed(b.id + 1236);

            for(int i = 0; i < 75; i++){
                float d = r.random(18f, 42f);
                float time = (Time.time + r.random(d));
                float dtime = (time % d) / d;

                float envelope = Interp.pow2Out.apply(
                    Mathf.curve(dtime, 0f, 0.06f) * Mathf.curve(1f - dtime, 0f, 0.06f)
                );

                int seed = (int)(time / d) + r.nextInt();
                r2.setSeed(seed);

                float dh = r2.random(110f, 240f);
                float dw = dh * r2.random(0.04f, 0.12f) * scl * envelope;

                float offset = r2.range(w) * 0.5f;

                float xOff = offset * getLaserWidth(dtime * (length - dh) + dh);
                float yOff = dtime * ((length - (end + this.width / 2f)) + w * 4.8f) + dh;

                boolean flash = r2.chance(0.08f + (w - Math.abs(offset)) / w * 0.6f);

                Color rc = flash ? Color.white : colors[i % colors.length];

                Draw.color(rc, 0.9f);

                v.trns(b.rotation(), (yOff + end / 1.5f) - w * 1.2f, xOff).add(b.x, b.y);

                drawEnergyShard(v.x, v.y, dw, dh, b.rotation() + Mathf.sin(Time.time * 0.05f + seed) * 1.5f);
            }
        }

        float lightPulse = w * 2f + 20f + Mathf.absin(10f, 6f);
        Drawf.light(b.x, b.y, v2.x, v2.y, lightPulse, colors[0], 0.85f);
    }

    @Override
    public void drawLight(Bullet b){
        }
    }

