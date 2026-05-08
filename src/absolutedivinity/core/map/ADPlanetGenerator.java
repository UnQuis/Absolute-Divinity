package absolutedivinity.core.map;

import arc.graphics.Color;
import arc.math.geom.Vec3;
import arc.util.noise.Simplex;
import mindustry.content.Blocks;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.world.TileGen;

public class ADPlanetGenerator extends PlanetGenerator {
    public float octaves = 3f;
    public float persistence = 0.8f;
    public float scale = 22f;
    public float mag = 1.2f;
    public float thresh = 1.5f;
    public float min = 100f;
    public float max = 100f;
    public float radMin = 300f;
    public float radMax = 700f;

    public Color waterColor = Color.valueOf("5992af");
    public Color landColor = Color.valueOf("4b64a9");

    public float rawHeight(Vec3 position) {
        return Simplex.noise3d(seed, octaves, persistence, scale, position.x, position.y, position.z) * mag;
    }

    @Override
    public float getHeight(Vec3 position) {
        float height = rawHeight(position);
        return Math.max(radMin, Math.min(radMax, min + height));
    }

    @Override
    public void getColor(Vec3 position, Color out) {
        float height = rawHeight(position);
        if(height < thresh) {
            out.set(waterColor);
        } else {
            out.set(landColor);
        }
    }

    @Override
    protected void genTile(Vec3 position, TileGen tile) {
        float height = rawHeight(position);

        if(height < thresh) {
            tile.floor = Blocks.water;
        } else {
            tile.floor = Blocks.stone;
        }

        tile.block = Blocks.air;
    }
}
