package absolutedivinity.core.map;

import absolutedivinity.content.ADColor;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec2;
import arc.math.geom.Vec3;
import arc.util.Tmp;
import arc.util.noise.Ridged;
import arc.util.noise.Simplex;
import mindustry.content.Blocks;
import mindustry.game.Schematics;
import mindustry.graphics.g3d.PlanetGrid;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.type.Sector;
import mindustry.world.Block;
import mindustry.world.TileGen;

public class ADPlanetGenerator extends PlanetGenerator {
    public float octaves = 4f;
    public float persistence = 0.7f;
    public float scale = 24f;
    public float mag = 1.4f;
    public float thresh = 1.1f;
    public float min = 100f;
    public float max = 100f;
    public float radMin = 300f;
    public float radMax = 700f;
    public float waterOffset = 0.6f;

    Block st = Blocks.stone,
        bs = Blocks.basalt,
        hr = Blocks.hotrock,
        ds = Blocks.darksand,
        cr = Blocks.craters,
        ys = Blocks.yellowStone;

    Block[][] terrains = {
        {st, st, bs, bs, hr},
        {st, bs, bs, hr, hr},
        {bs, bs, ds, hr, cr},
        {bs, ds, ds, cr, cr},
        {ds, ds, cr, cr, ys},
        {ds, cr, ys, ys, ys}
    };

    public float getRawHeight(Vec3 position) {
        float height = Simplex.noise3d(seed, octaves, persistence, scale, position.x, position.y, position.z) * mag;
        float ridges = Ridged.noise3d(seed + 1, position.x, position.y, position.z, 3, 2.5f) * 0.4f;
        return height + ridges;
    }

    public float getRawNoise(Vec3 position){
        return Simplex.noise3d(seed + 2, 8, 0.5f, 2.2f, position.x, position.y, position.z) * 1.5f;
    }

    public float getTerrainNoise(Vec3 position){
        return Simplex.noise3d(seed + 3, 5, 0.8f, 3.1f, position.x, position.y, position.z) * 1.2f;
    }

    public float getColorNoise(Vec3 position){
        return 1f + (Simplex.noise3d(seed + 4, 6, 0.7f, 0.25f, position.x, position.y, position.z) * 0.2f - 0.1f);
    }

    public Block getFloor(Vec3 position) {
        float raw = Math.abs(getRawNoise(position));
        float terr = Math.abs(getTerrainNoise(position));

        int size = terrains.length;
        int x = Mathf.clamp(Mathf.round(raw * size), 0, size - 1);

        int tSize = terrains[x].length;
        int y = Mathf.clamp(Mathf.round(terr * tSize), 0, tSize - 1);

        return terrains[x][y];
    }

    @Override
    public float getHeight(Vec3 position) {
        float height = getRawHeight(position);
        float clamped = Math.max(height, waterOffset);
        return Math.max(radMin, Math.min(radMax, min + clamped));
    }

    @Override
    public void getColor(Vec3 position, Color out) {
        float height = getRawHeight(position);
        if(height < thresh) {
            out.set(ADColor.deepRed).lerp(ADColor.crimsonRed, Mathf.clamp(height / thresh));
        } else {
            out.set(getFloor(position).mapColor).mul(getColorNoise(position));
            if(height > thresh + 0.6f) {
                out.lerp(ADColor.ichor, Mathf.clamp((height - thresh - 0.6f) * 0.8f));
            }
        }
    }

    @Override
    protected void genTile(Vec3 position, TileGen tile) {
        float height = getRawHeight(position);

        if(height < thresh) {
            tile.floor = Blocks.slag;
        } else {
            tile.floor = getFloor(position);
        }

        tile.block = tile.floor.asFloor().wall;

        if(Ridged.noise3d(seed + 5, position.x, position.y, position.z, 3, 12f) > -0.35f) {
            tile.block = Blocks.air;
        }
    }

    @Override
    public boolean allowLanding(Sector sector) {
        return super.allowLanding(sector) && isLandSector(sector);
    }

    public boolean isLandSector(Sector sector) {
        if (sector == null) return true;
        int land = 0;
        if (getRawHeight(sector.tile.v) > thresh) land++;
        for (PlanetGrid.Corner corner: sector.tile.corners){
            if (getRawHeight(corner.v) > thresh) land += 5;
        }
        return land > 5;
    }

    @Override
    protected void generate() {
        distort(8, 12);
        median(4);

        scatter(Blocks.basalt, Blocks.hotrock, 0.35f);
        scatter(Blocks.hotrock, Blocks.stone, 0.4f);
        scatter(Blocks.yellowStone, Blocks.sand, 0.25f);

        decoration(0.025f);

        distort(4, 5);

        Vec2 trns = Tmp.v1.trns(rand.random(360f), width / 2.6f);
        int coreX = (int) (-trns.x + width / 2f);
        int coreY = (int) (-trns.y + height / 2f);
        Schematics.placeLaunchLoadout(coreX, coreY);
    }
}
