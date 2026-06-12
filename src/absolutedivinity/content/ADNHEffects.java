package absolutedivinity.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Interp;
import arc.math.Mathf;
import arc.math.Rand;
import mindustry.entities.Effect;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;

import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.randLenVectors;

public class ADNHEffects {
    private static final Rand rand = new Rand();
    public static final float EFFECT_MASK = Layer.effect + 0.0001f;

    public static Effect
    hitSparkSmall = new Effect(45, e -> {
        Draw.color(e.color, Color.white, e.fout() * 0.3f);
        Lines.stroke(e.fout() * 1.6f);
        rand.setSeed(e.id);
        randLenVectors(e.id, 8, e.finpow() * 20f, (x, y) -> {
            float ang = Mathf.angle(x, y);
            Lines.lineAngle(e.x + x, e.y + y, ang, e.fout() * rand.random(2f, 4f) + 1f);
        });
    }),

    hitSparkLarge = new Effect(50, e -> {
        Draw.color(e.color, Color.white, e.fout() * 0.3f);
        Lines.stroke(e.fout() * 2f);
        rand.setSeed(e.id);
        randLenVectors(e.id, 18, e.finpow() * 35f, (x, y) -> {
            float ang = Mathf.angle(x, y);
            Lines.lineAngle(e.x + x, e.y + y, ang, e.fout() * rand.random(4f, 8f) + 2f);
        });
    }),

    hitSparkHuge = new Effect(70, e -> {
        Draw.color(e.color, Color.white, e.fout() * 0.3f);
        Lines.stroke(e.fout() * 2.5f);
        rand.setSeed(e.id);
        randLenVectors(e.id, 26, e.finpow() * 65f, (x, y) -> {
            float ang = Mathf.angle(x, y);
            Lines.lineAngle(e.x + x, e.y + y, ang, e.fout() * rand.random(6f, 9f) + 3f);
        });
    }),

    crossBlast = new Effect(35, 140, e -> {
        Draw.color(e.color, Color.white, e.fout() * 0.55f);
        Drawf.light(e.x, e.y, e.fout() * 70, e.color, 0.7f);
        e.scaled(10f, i -> {
            Lines.stroke(1.35f * i.fout());
            Lines.circle(e.x, e.y, 49 * i.finpow());
        });
        rand.setSeed(e.id);
        float sizeDiv = 35;
        float randL = rand.random(sizeDiv);
        for(int i = 0; i < 4; i++){
            float rot = i * 90;
            float len = (sizeDiv + randL) * Mathf.curve(e.fin(), 0, 0.05f) * e.fout(Interp.pow3);
            float w = 3.5f * (e.fout() * 3f + 1) / 4 * (e.fout(Interp.pow3In) + 0.5f) / 1.5f;
            Drawf.tri(e.x, e.y, w, len, rot);
        }
    }),

    crossBlast45 = new Effect(35, 140, e -> {
        Draw.color(e.color, Color.white, e.fout() * 0.55f);
        Drawf.light(e.x, e.y, e.fout() * 70, e.color, 0.7f);
        e.scaled(10f, i -> {
            Lines.stroke(1.35f * i.fout());
            Lines.circle(e.x, e.y, 55 * i.finpow());
        });
        rand.setSeed(e.id);
        float sizeDiv = 60;
        float randL = rand.random(sizeDiv);
        for(int i = 0; i < 4; i++){
            float rot = i * 90 + 45;
            float len = (sizeDiv + randL) * Mathf.curve(e.fin(), 0, 0.05f) * e.fout(Interp.pow3);
            float w = 5.85f * (e.fout() * 3f + 1) / 4 * (e.fout(Interp.pow3In) + 0.5f) / 1.5f;
            Drawf.tri(e.x, e.y, w, len, rot);
        }
    }),

    shootCircle = new Effect(30f, 120f, e -> {
        Draw.color(e.color, Color.white, e.fout() * 0.6f);
        Lines.stroke(2f * e.fout());
        Lines.circle(e.x, e.y, e.rotation * e.fin(Interp.pow3Out));
        randLenVectors(e.id, 6, e.rotation * e.fin(), (x, y) -> Fill.circle(e.x + x, e.y + y, e.fout() * 3f));
        Drawf.light(e.x, e.y, e.fout() * e.rotation, e.color, 0.6f);
    }),

    shootCircleSmall = new Effect(20f, 60f, e -> {
        Draw.color(e.color, Color.white, e.fout() * 0.6f);
        Lines.stroke(1.5f * e.fout());
        Lines.circle(e.x, e.y, e.rotation * e.fin(Interp.pow3Out));
        Drawf.light(e.x, e.y, e.fout() * e.rotation, e.color, 0.5f);
    }),

    instShoot = new Effect(26f, 120f, e -> {
        Draw.color(Color.white, e.color, e.fin() * 0.75f);
        randLenVectors(e.id, 9, 70f, e.rotation, 0f, (x, y) -> {
            Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), e.fout() * 5f + 2f);
            Drawf.light(e.x + x, e.y + y, e.fout() * 8f, e.color, 0.7f);
        });
    }),

    instHit = new Effect(45f, 200f, e -> {
        Draw.color(e.color, Color.white, e.fout() * 0.3f);
        Lines.stroke(3f * e.fout());
        Lines.circle(e.x, e.y, e.fin() * 80f);
        randLenVectors(e.id, 20, e.finpow() * 60f, (x, y) -> {
            float ang = Mathf.angle(x, y);
            Lines.lineAngle(e.x + x, e.y + y, ang, e.fout() * rand.random(4f, 8f) + 2f);
        });
        Drawf.light(e.x, e.y, e.fout() * 100f, e.color, 0.7f);
    }),

    instBomb = new Effect(80f, 500f, e -> {
        Draw.color(e.color, Color.white, e.fin() + 0.2f);
        Lines.stroke(6f * e.fout());
        Lines.circle(e.x, e.y, e.fin() * 200f);
        randLenVectors(e.id, 30, e.finpow() * 180f, (x, y) -> {
            Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), e.fout() * 12f + 4f);
        });
        Drawf.light(e.x, e.y, e.fout() * 300f, e.color, 0.8f);
    }),

    circleOut = new Effect(60f, 500f, e -> {
        Lines.stroke(2.5f * e.fout(), e.color);
        Lines.circle(e.x, e.y, e.rotation * e.fin(Interp.pow3Out));
    }),

    chargeEffect = new Effect(90f, 200f, e -> {
        Draw.color(e.color, Color.white, e.fin() * 0.6f);
        Lines.stroke(2f * e.fin());
        Lines.circle(e.x, e.y, 80 * e.fout(Interp.pow5Out));
        randLenVectors(e.id, 12, 60 * e.fout(Interp.pow4Out), (x, y) -> {
            Fill.square(e.x + x, e.y + y, 5f * e.fin(), 45);
            Drawf.light(e.x + x, e.y + y, e.fin() * 9f, e.color, 0.7f);
        });
    }),

    missileTrail = new Effect(50f, e -> {
        Draw.color(e.color);
        Draw.alpha(e.fout(0.85f) * 0.85f);
        Angles.randLenVectors(e.id, 6, 2f + e.rotation * 5f * e.finpow(), (x, y) -> {
            Fill.circle(e.x + x / 2f, e.y + y / 2f, e.fout(Interp.pow3Out) * e.rotation);
        });
    }),

    polyTrail = new Effect(25f, e -> {
        Draw.color(e.color, mindustry.graphics.Pal.gray, e.fin());
        randLenVectors(e.id, 4, 46f * e.fin(), (x, y) -> {
            Fill.poly(e.x + x, e.y + y, 6, e.rotation * e.fslope() * e.fout());
            Drawf.light(e.x + x, e.y + y, e.fout() * e.rotation * 1.15f, e.color, 0.7f);
        });
    }),

    hugeSmoke = new Effect(40f, e -> {
        Draw.color(e.color);
        Angles.randLenVectors(e.id, 6, 2f + 19f * e.finpow(), (x, y) -> Fill.circle(e.x + x / 2f, e.y + y / 2f, e.fout() * 2f));
        e.scaled(25f, i -> Angles.randLenVectors(e.id, 6, 2f + 19f * i.finpow(), (x, y) -> Fill.circle(e.x + x, e.y + y, i.fout() * 4f)));
    }),

    hugeTrail = new Effect(40f, e -> {
        Draw.color(e.color);
        Draw.alpha(e.fout(0.85f) * 0.85f);
        Angles.randLenVectors(e.id, 6, 2f + e.rotation * 5f * e.finpow(), (x, y) -> {
            Fill.circle(e.x + x / 2f, e.y + y / 2f, e.fout(Interp.pow3Out) * e.rotation);
        });
    });
}
