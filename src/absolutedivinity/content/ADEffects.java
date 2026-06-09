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
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.graphics.Drawf;

public class ADEffects {

    public static Effect energySpark, voidShootSmall, voidShoot, voidShootBig,
        voidHitSmall, voidHit, voidHitBig, voidDespawn, voidLightningHit,
        voidCharge, voidChargeBig, voidTrail, voidWave, voidBlast,
        voidFragmentExplosion, voidLaserHit, voidSingularityPulse,
        voidStormSpark, voidAnnihilateCharge, voidAnnihilateBlast;

    public static Color voidWhite = Color.valueOf("f0f0ff"),
        voidSilver = Color.valueOf("d0d4e8"),
        voidGlow = Color.valueOf("a8b8ff"),
        voidLight = Color.valueOf("c8d0ff"),
        voidDark = Color.valueOf("18182a");

    public static void load() {
        energySpark = new Effect(20f, e -> {
            Draw.color(voidGlow, Color.white, e.fin());
            Fill.circle(e.x, e.y, 1.2f * e.fout());
            Lines.stroke(1f * e.fout());
            for(int i = 0; i < 3; i++){
                Lines.lineAngle(e.x, e.y, Mathf.random(360f), 4f * e.fin());
            }
        });

        voidShootSmall = new Effect(14f, e -> {
            Draw.color(Color.white, voidSilver, e.fin());
            Angles.randLenVectors(e.id, 4, 8f * e.fout(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 1.2f * e.fout());
            });
            Lines.stroke(0.6f * e.fout());
            Lines.circle(e.x, e.y, 4f * e.fout());
        });

        voidShoot = new Effect(20f, e -> {
            Draw.color(Color.white, voidLight, e.fin());
            Angles.randLenVectors(e.id, 8, 14f * e.fout(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 2f * e.fout());
            });
            Lines.stroke(1.2f * e.fout());
            Lines.circle(e.x, e.y, 6f * e.fout());
            Drawf.light(e.x, e.y, 30f, voidGlow, 0.5f);
        });

        voidShootBig = new Effect(28f, e -> {
            Draw.color(Color.white, voidGlow, e.fin());
            Angles.randLenVectors(e.id, 16, 24f * e.fout(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 3.5f * e.fout());
            });
            Lines.stroke(2f * e.fout());
            Lines.circle(e.x, e.y, 10f * e.fout());
            for(int i = 0; i < 4; i++){
                Drawf.tri(e.x, e.y, 4f * e.fout(), 20f * e.fout(), e.rotation + 90f * i);
            }
            Drawf.light(e.x, e.y, 50f, voidGlow, 0.7f);
        });

        voidHitSmall = new Effect(16f, e -> {
            Draw.color(Color.white, voidSilver, e.fin());
            Angles.randLenVectors(e.id, 6, 10f * e.fout(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 1.4f * e.fout());
            });
            Lines.stroke(0.8f * e.fout());
            Lines.circle(e.x, e.y, 5f * e.fout());
        });

        voidHit = new Effect(22f, e -> {
            Draw.color(Color.white, voidLight, e.fin());
            Angles.randLenVectors(e.id, 12, 18f * e.fout(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 2.5f * e.fout());
            });
            Lines.stroke(1.5f * e.fout());
            Lines.circle(e.x, e.y, 8f * e.fout());
            Drawf.light(e.x, e.y, 35f, voidGlow, 0.6f);
        });

        voidHitBig = new Effect(35f, e -> {
            Draw.color(Color.white, voidGlow, e.fin());
            Angles.randLenVectors(e.id, 24, 35f * e.fout(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 4f * e.fout());
            });
            Lines.stroke(2.5f * e.fout());
            Lines.circle(e.x, e.y, 15f * e.fout());
            for(int i = 0; i < 6; i++){
                Drawf.tri(e.x, e.y, 6f * e.fout(), 30f * e.fout(), e.rotation + 60f * i + e.fin() * 30f);
            }
            Drawf.light(e.x, e.y, 70f, voidGlow, 0.8f);
        });

        voidDespawn = new Effect(18f, e -> {
            Draw.color(Color.white, voidSilver, 1f - e.fin());
            float s = 3f + 6f * e.fout();
            Fill.circle(e.x, e.y, s);
            Lines.stroke(1f * e.fout());
            for(int i = 0; i < 3; i++){
                float a = e.fin() * 360f + i * 120f;
                Lines.lineAngle(e.x + Mathf.cosDeg(a) * s, e.y + Mathf.sinDeg(a) * s, a, 8f * e.fout());
            }
        });

        voidLightningHit = new Effect(25f, e -> {
            Draw.color(Color.white, voidGlow, e.fin());
            Angles.randLenVectors(e.id, 20, 25f * e.fout(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 1.8f * e.fout());
            });
            Lines.stroke(1.8f * e.fout());
            Lines.circle(e.x, e.y, 10f * e.fout());
            for(int i = 0; i < 8; i++){
                float a = Mathf.random(360f);
                Lines.lineAngle(e.x, e.y, a, Mathf.random(6f, 20f) * e.fout());
            }
            Drawf.light(e.x, e.y, 40f, Color.white, 0.7f);
        });

        voidCharge = new Effect(40f, e -> {
            Draw.color(voidLight, Color.white, e.fin());
            Lines.stroke(e.fin() * 3f);
            Lines.circle(e.x, e.y, 4f + e.fout() * 20f);
            Angles.randLenVectors(e.id, 8, e.fout() * 24f, (x, y) -> {
                Fill.circle(e.x + x, e.y + y, e.fin() * 2f);
            });
        });

        voidChargeBig = new Effect(70f, e -> {
            Draw.color(voidGlow, Color.white, e.fin());
            Lines.stroke(e.fin() * 5f);
            Lines.circle(e.x, e.y, 8f + e.fout() * 50f);
            Angles.randLenVectors(e.id, 16, e.fout() * 55f, (x, y) -> {
                Fill.circle(e.x + x, e.y + y, e.fin() * 3.5f);
            });
            for(int i = 0; i < 4; i++){
                Drawf.tri(e.x, e.y, 3f * e.fin(), 25f * e.fout(), e.rotation + 90f * i + e.fin() * 30f);
            }
            Drawf.light(e.x, e.y, 60f, voidGlow, 0.5f + 0.4f * e.fin());
        });

        voidTrail = new Effect(12f, e -> {
            Draw.color(Color.white, voidSilver, e.fin());
            Fill.circle(e.x, e.y, 1.5f * e.fout());
            Drawf.light(e.x, e.y, 15f, voidGlow, 0.3f * e.fout());
        });

        voidWave = new Effect(24f, e -> {
            Draw.color(voidLight, Color.white, e.fin());
            Lines.stroke(1.5f * e.fout());
            Lines.circle(e.x, e.y, 6f + 18f * e.fin());
        });

        voidBlast = new Effect(50f, e -> {
            Draw.color(Color.white, voidGlow, e.fin());
            Lines.stroke(3f * e.fout());
            Lines.circle(e.x, e.y, 10f + 40f * e.fin());
            Angles.randLenVectors(e.id, 30, 50f * e.fin(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 3f * e.fout());
            });
            for(int i = 0; i < 6; i++){
                Drawf.tri(e.x, e.y, 8f * e.fout(), 50f * e.fin(), e.rotation + 60f * i);
            }
            Drawf.light(e.x, e.y, 80f, Color.white, 0.8f);
        });

        voidFragmentExplosion = new Effect(30f, e -> {
            Draw.color(Color.white, voidLight, e.fin());
            Angles.randLenVectors(e.id, 15, 30f * e.fin(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 1.5f + 3f * e.fout());
            });
            Lines.stroke(2f * e.fout());
            Lines.circle(e.x, e.y, 5f + 15f * e.fin());
        });

        voidLaserHit = new Effect(18f, e -> {
            Draw.color(Color.white, voidGlow, e.fin());
            Fill.circle(e.x, e.y, 3f * e.fout());
            Lines.stroke(1.5f * e.fout());
            Angles.randLenVectors(e.id, 8, e.fin() * 25f, e.rotation, 50f, (x, y) -> {
                Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 8f * e.fout());
            });
        });

        voidSingularityPulse = new Effect(60f, 200f, e -> {
            Draw.color(voidGlow, Color.white, e.fin());
            Lines.stroke(e.fout() * 4f);
            Lines.circle(e.x, e.y, e.fin() * 120f);
            Angles.randLenVectors(e.id, 40, e.fin() * 120f, (x, y) -> {
                Fill.circle(e.x + x, e.y + y, e.fout() * 3f);
            });
            for(int i = 0; i < 8; i++){
                Drawf.tri(e.x, e.y, 4f * e.fout(), 60f * e.fin(), e.rotation + 45f * i + e.fin() * 20f);
            }
            Drawf.light(e.x, e.y, 150f, Color.white, 0.6f);
        });

        voidStormSpark = new Effect(20f, e -> {
            Draw.color(Color.white, voidSilver, e.fin());
            Lines.stroke(1.2f * e.fout());
            float a = Mathf.random(360f);
            Lines.lineAngle(e.x, e.y, a, 6f + 14f * e.fout());
            Lines.lineAngle(e.x + Mathf.cosDeg(a) * 10f, e.y + Mathf.sinDeg(a) * 10f, a + Mathf.random(-40f, 40f), 6f + 10f * e.fout());
            Fill.circle(e.x, e.y, 2f * e.fout());
        });

        voidAnnihilateCharge = new Effect(120f, 500f, e -> {
            Draw.color(voidGlow, Color.white, e.fin());
            Lines.stroke(e.fin() * 8f);
            Lines.circle(e.x, e.y, e.fout() * 200f);
            Angles.randLenVectors(e.id, 50, e.fout() * 200f, (x, y) -> {
                Fill.circle(e.x + x, e.y + y, e.fin() * 6f);
            });
            for(int i = 0; i < 8; i++){
                Drawf.tri(e.x, e.y, 8f * e.fin(), 100f * e.fout(), e.rotation + 45f * i);
            }
            Drawf.light(e.x, e.y, 300f, Color.white, e.fin());
        });

        voidAnnihilateBlast = new Effect(80f, 600f, e -> {
            Draw.color(Color.white, voidGlow, e.fin());
            Lines.stroke(e.fout() * 12f);
            Lines.circle(e.x, e.y, e.fin() * 400f);
            Angles.randLenVectors(e.id, 80, 100f + e.fin() * 500f, (x, y) -> {
                Fill.circle(e.x + x, e.y + y, e.fout() * 8f);
            });
            for(int i = 0; i < 12; i++){
                Drawf.tri(e.x, e.y, 12f * e.fout(), 200f * e.fin(), e.rotation + 30f * i);
            }
            Drawf.light(e.x, e.y, 500f, Color.white, 1f);
        });
    }
}
