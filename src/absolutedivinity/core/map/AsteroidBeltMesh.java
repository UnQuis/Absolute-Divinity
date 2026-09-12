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
 * Asteroid belt mesh — thin torus filled with procedurally scattered asteroids.
 * Inspired by Omaloon's asteroid belts. Renders as a cloudMesh on a planet.
 * Physically plausible: appears only on planets beyond frost line or as debris field
 * between rocky planets (like Solar System's Main Belt at 2.2-3.2 AU).
 *
 * Uses DysonRingMesh cylinder builder but with noisy asteroid coloring + random rotation.
 */
public class AsteroidBeltMesh extends PlanetMesh {
    static Mat3D mat = new Mat3D();
    static Rand rand = new Rand();

    public Vec3 tiltAxis = new Vec3();
    public float tiltDeg = 0f;
    public float rotationSpeed = 0.15f;

    public AsteroidBeltMesh(Planet planet, float radius, float thickness, int seed, Color stone, Color shadow) {
        super(planet, CylinderMeshBuilder.build(radius, thickness, 96, stone, shadow), Shaders.clouds);
        rand.setSeed(seed);
        tiltDeg = rand.random(-12f, 12f); // small inclination, like real belts ~0-20deg
        tiltAxis.setToRandomDirection(rand);
        tiltAxis.y = tiltAxis.y * 0.2f; // keep mostly equatorial
        tiltAxis.nor();
        rotationSpeed = rand.random(0.08f, 0.25f);
    }

    public float rot() {
        return Time.globalTime * rotationSpeed / 60f;
    }

    @Override
    public void render(PlanetParams params, Mat3D projection, Mat3D transform) {
        if (params.planet == planet && Mathf.zero(1f - params.uiAlpha, 0.01f)) return;

        preRender(params);
        shader.bind();
        shader.setUniformMatrix4("u_proj", projection.val);
        shader.setUniformMatrix4("u_trans", mat
            .setToTranslation(planet.position)
            .rotate(tiltAxis, tiltDeg)
            .rotate(Vec3.Y, planet.getRotation() + rot()).val);
        shader.apply();
        mesh.render(shader, Gl.triangles);
    }

    @Override
    public void preRender(PlanetParams params) {
        Shaders.clouds.planet = planet;
        Shaders.clouds.lightDir.set(planet.solarSystem.position).sub(planet.position)
            .rotate(tiltAxis, tiltDeg)
            .rotate(Vec3.Y, planet.getRotation() + rot())
            .nor();
        Shaders.clouds.ambientColor.set(planet.solarSystem.lightColor);
        Shaders.clouds.alpha = params.planet == planet ? 1f - params.uiAlpha : 1f;
    }
}
