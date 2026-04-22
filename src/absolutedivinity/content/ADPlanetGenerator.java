package absolutedivinity.content;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.util.noise.Simplex;
import mindustry.maps.generators.PlanetGenerator;

public class ADPlanetGenerator extends PlanetGenerator{
    
    public int octaves = 3;
    public float persistence = 0.52f;
    public float scale = 0.8f;
    public float mag = 0.721f;

    public float thresh = 1.152f;
    public float min = 100f;
    public float max = 100f;
    public float radMin = 220f;
    public float radMax = 600f;
    public Color waterColor = Color.valueOf("5992af");
    public Color landColor = Color.valueOf("4b64a9");

    @Override
    public float getHeight(Vec3 position) {
        float height = Simplex.noise3d(seed, octaves, persistence, 1f / scale, position.x, position.y, position.z);
        height *= mag;

        if (Math.abs(height) < thresh) {
            height = Mathf.lerp(height, 0, 0.5f); 
        }

        return Mathf.clamp(height, radMin / 1000f, radMax / 1000f);
    }

    public Color getColor(Vec3 position){
        float height = getHeight(position);

        if(height < 0.3f){
            return waterColor;
        }else{
            return landColor;
        }
    }

    @Override
    protected void generate(){
        //TODO: add some parameters
    }
}
