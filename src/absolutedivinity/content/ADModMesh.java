package absolutedivinity.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.graphics.g3d.HexMesh;
import mindustry.type.Planet;

public class ADModMesh extends HexMesh {

    public Object owner;

    public int segments;
    public float radius;

    public Color[] colors;

    float noise;
    float scale;
    float height;
    float detail;
    float strength;

    public static Color shade(Color base, float t){
        return base.cpy().lerp(t > 0 ? Color.white : Color.black, Math.abs(t));
    }

    public ADModMesh(Planet owner, int segments, float radius, Color... colors){
        super(owner, segments);
        this.owner = owner;
        this.segments = segments;
        this.radius = radius;
        this.colors = colors;

        this.noise = 0.3f;
        this.scale = 1.7f;
        this.height = 1.2f;
        this.detail = 1.4f;
        this.strength = 1.1f;

    }

    public void render(float x, float y, int level){
        for(int i = 0; i < segments; i++){
            float angle = (360f / segments) * i;
            float noise = Mathf.absin(Time.time + i, 2f, 1f);
            float r = radius + noise;
            float px = x + Angles.trnsx(angle, r);
            float py = y + Angles.trnsy(angle, r);

            Draw.color(colors [i % colors.length]);
            Fill.circle(px, py, 1.5f);
        }
        Draw.reset();
    }
}
