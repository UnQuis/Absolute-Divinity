package absolutedivinity.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Interp;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.entities.Effect;
import mindustry.graphics.Drawf;

public class ADTurretEffects {

    public static Effect shootSmall(Color color) {
        return new Effect(14f, e -> {
            Draw.color(Color.white, color, e.fin());
            Angles.randLenVectors(e.id, 4, 8f * e.fout(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 1.2f * e.fout());
            });
            Lines.stroke(0.6f * e.fout());
            Lines.circle(e.x, e.y, 4f * e.fout());
        });
    }

    public static Effect shootMedium(Color color) {
        return new Effect(20f, e -> {
            Draw.color(Color.white, color, e.fin());
            Angles.randLenVectors(e.id, 8, 14f * e.fout(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 2f * e.fout());
            });
            Lines.stroke(1.2f * e.fout());
            Lines.circle(e.x, e.y, 6f * e.fout());
            Drawf.light(e.x, e.y, 30f, color, 0.5f);
        });
    }

    public static Effect shootBig(Color color) {
        return new Effect(28f, e -> {
            Draw.color(Color.white, color, e.fin());
            Angles.randLenVectors(e.id, 16, 24f * e.fout(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 3.5f * e.fout());
            });
            Lines.stroke(2f * e.fout());
            Lines.circle(e.x, e.y, 10f * e.fout());
            for (int i = 0; i < 4; i++) {
                Drawf.tri(e.x, e.y, 4f * e.fout(), 20f * e.fout(), e.rotation + 90f * i);
            }
            Drawf.light(e.x, e.y, 50f, color, 0.7f);
        });
    }

    public static Effect hitSmall(Color color) {
        return new Effect(16f, e -> {
            Draw.color(Color.white, color, e.fin());
            Angles.randLenVectors(e.id, 6, 10f * e.fout(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 1.4f * e.fout());
            });
            Lines.stroke(0.8f * e.fout());
            Lines.circle(e.x, e.y, 5f * e.fout());
        });
    }

    public static Effect hitMedium(Color color) {
        return new Effect(22f, e -> {
            Draw.color(Color.white, color, e.fin());
            Angles.randLenVectors(e.id, 12, 18f * e.fout(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 2.5f * e.fout());
            });
            Lines.stroke(1.5f * e.fout());
            Lines.circle(e.x, e.y, 8f * e.fout());
            Drawf.light(e.x, e.y, 35f, color, 0.6f);
        });
    }

    public static Effect hitBig(Color color) {
        return new Effect(35f, e -> {
            Draw.color(Color.white, color, e.fin());
            Angles.randLenVectors(e.id, 24, 35f * e.fout(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 4f * e.fout());
            });
            Lines.stroke(2.5f * e.fout());
            Lines.circle(e.x, e.y, 15f * e.fout());
            for (int i = 0; i < 6; i++) {
                Drawf.tri(e.x, e.y, 6f * e.fout(), 30f * e.fout(), e.rotation + 60f * i + e.fin() * 30f);
            }
            Drawf.light(e.x, e.y, 70f, color, 0.8f);
        });
    }

    public static Effect chargeSmall(Color color) {
        return new Effect(40f, e -> {
            Draw.color(color, Color.white, e.fin());
            Lines.stroke(e.fin() * 3f);
            Lines.circle(e.x, e.y, 4f + e.fout() * 20f);
            Angles.randLenVectors(e.id, 8, e.fout() * 24f, (x, y) -> {
                Fill.circle(e.x + x, e.y + y, e.fin() * 2f);
            });
        });
    }

    public static Effect chargeBig(Color color) {
        return new Effect(70f, e -> {
            Draw.color(color, Color.white, e.fin());
            Lines.stroke(e.fin() * 5f);
            Lines.circle(e.x, e.y, 8f + e.fout() * 50f);
            Angles.randLenVectors(e.id, 16, e.fout() * 55f, (x, y) -> {
                Fill.circle(e.x + x, e.y + y, e.fin() * 3.5f);
            });
            for (int i = 0; i < 4; i++) {
                Drawf.tri(e.x, e.y, 3f * e.fin(), 25f * e.fout(), e.rotation + 90f * i + e.fin() * 30f);
            }
            Drawf.light(e.x, e.y, 60f, color, 0.5f + 0.4f * e.fin());
        });
    }

    public static Effect trailEffect(Color color) {
        return new Effect(12f, e -> {
            Draw.color(Color.white, color, e.fin());
            Fill.circle(e.x, e.y, 1.5f * e.fout());
            Drawf.light(e.x, e.y, 15f, color, 0.3f * e.fout());
        });
    }

    public static Effect blastEffect(Color color, float size) {
        return new Effect(50f, size * 2f, e -> {
            Draw.color(Color.white, color, e.fin());
            Lines.stroke(3f * e.fout());
            Lines.circle(e.x, e.y, 10f + size * 0.5f * e.fin());
            Angles.randLenVectors(e.id, 30, size * e.fin(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 3f * e.fout());
            });
            for (int i = 0; i < 6; i++) {
                Drawf.tri(e.x, e.y, 8f * e.fout(), size * 0.5f * e.fin(), e.rotation + 60f * i);
            }
            Drawf.light(e.x, e.y, size, Color.white, 0.8f);
        });
    }

    public static Effect crossBlast(Color color, float size) {
        return new Effect(30f, size * 1.5f, e -> {
            Draw.color(color, Color.white, e.fin());
            for (int i = 0; i < 4; i++) {
                float rot = e.rotation + 90f * i + e.fin() * 30f;
                Drawf.tri(e.x, e.y, size * 0.15f * e.fout(), size * 0.4f * e.fin(), rot);
            }
            Lines.stroke(2f * e.fout());
            Lines.circle(e.x, e.y, size * 0.3f * e.fin());
            Drawf.light(e.x, e.y, size * 0.8f, color, 0.6f * e.fout());
        });
    }

    public static Effect expandingRing(Color color) {
        return new Effect(24f, e -> {
            Draw.color(color, Color.white, e.fin());
            Lines.stroke(1.5f * e.fout());
            Lines.circle(e.x, e.y, 6f + 18f * e.fin());
        });
    }

    public static Effect sparkEffect(Color color) {
        return new Effect(20f, e -> {
            Draw.color(Color.white, color, e.fin());
            Lines.stroke(1.2f * e.fout());
            float a = Mathf.random(360f);
            Lines.lineAngle(e.x, e.y, a, 6f + 14f * e.fout());
            Lines.lineAngle(e.x + Mathf.cosDeg(a) * 10f, e.y + Mathf.sinDeg(a) * 10f,
                a + Mathf.random(-40f, 40f), 6f + 10f * e.fout());
            Fill.circle(e.x, e.y, 2f * e.fout());
        });
    }
}
