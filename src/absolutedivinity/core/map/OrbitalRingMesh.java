package absolutedivinity.core.map;

import arc.graphics.Color;
import arc.graphics.Gl;
import arc.math.Mathf;
import arc.math.Rand;
import arc.math.geom.Mat3D;
import arc.math.geom.Vec3;
import arc.util.Time;
import mindustry.graphics.Shaders;
import mindustry.graphics.g3d.PlanetMesh;
import mindustry.graphics.g3d.PlanetParams;
import mindustry.type.Planet;

/**
 * Orbital / planetary ring mesh — thin, bright, inclined.
 * Inspired by New Horizon's rings (Saturn-like). Used for:
 * - Elysium: artificial Dyson debris rings (metallic, ancient civilization)
 * - Boreas IV: natural icy rings beyond frost line (like Saturn)
 *
 * Astrophysics note: rings only form within Roche limit or beyond frost line,
 * so we only attach this mesh to those two worlds.
 */
public class OrbitalRingMesh extends PlanetMesh {
    static Mat3D mat = new Mat3D();
    static Rand rand = new Rand();

    public Vec3 pole = new Vec3();
    public float poleAngle = 0f;
    public float spin = 0.6f;

    public OrbitalRingMesh(Planet planet, float radius, float width, int seed, Color inner, Color outer) {
        super(planet, CylinderMeshBuilder.build(radius, width, 140, inner, outer), Shaders.clouds);
        rand.setSeed(seed);
        poleAngle = rand.random(-18f, 18f);
        pole.setToRandomDirection(rand);
        // normalize to near-equatorial for ring stability
        pole.y *= 0.15f;
        pole.nor();
        spin = rand.random(0.3f, 0.9f);
    }

    public float rotation() {
        return Time.globalTime * spin / 45f;
    }

    @Override
    public void render(PlanetParams params, Mat3D projection, Mat3D transform) {
        if (params.planet == planet && Mathf.zero(1f - params.uiAlpha, 0.01f)) return;
        preRender(params);
        shader.bind();
        shader.setUniformMatrix4("u_proj", projection.val);
        shader.setUniformMatrix4("u_trans", mat
            .setToTranslation(planet.position)
            .rotate(pole, poleAngle)
            .rotate(Vec3.Y, planet.getRotation() + rotation()).val);
        shader.apply();
        mesh.render(shader, Gl.triangles);
    }

    @Override
    public void preRender(PlanetParams params) {
        Shaders.clouds.planet = planet;
        Shaders.clouds.lightDir.set(planet.solarSystem.position).sub(planet.position)
            .rotate(pole, poleAngle)
            .rotate(Vec3.Y, planet.getRotation() + rotation())
            .nor();
        Shaders.clouds.ambientColor.set(planet.solarSystem.lightColor);
        Shaders.clouds.alpha = params.planet == planet ? 1f - params.uiAlpha : 1f;
    }
}
