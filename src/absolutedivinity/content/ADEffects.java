package absolutedivinity.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import mindustry.entities.Effect;

public class ADEffects {

    public static Effect energySpark;

    public static void load() {
        energySpark = new Effect(20f, e -> {
            Draw.color(Color.valueOf("7fd4ff"), Color.white, e.fin());
            Fill.circle(e.x, e.y, 1.2f * e.fout());

            Lines.stroke(1f * e.fout());
            for(int i = 0; i < 3; i++){
                float angle = Mathf.random(360f);
                Lines.lineAngle(e.x, e.y, angle, 4f * e.fin());
            }
        });
    }
}
