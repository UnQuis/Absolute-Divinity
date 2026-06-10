package absolutedivinity.content.blocks.turrets.void_;

import absolutedivinity.content.ADEffects;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.Lightning;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.Bullet;
import mindustry.graphics.Drawf;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.PowerTurret;

public class VoidStorm {
    public static PowerTurret voidStorm;

    public static void load() {{
        voidStorm = new PowerTurret("void-7") {{
            localizedName = "Void Storm";
            description = "Generates a roiling storm of void energy that lashes out with silver lightning and explodes on contact.";
            size = 4;
            health = 3200;
            range = 280f;
            reload = 110f;
            rotateSpeed = 5f;
            shootCone = 30f;
            targetAir = true;
            targetGround = true;
            shootEffect = ADEffects.voidShootBig;
            heatColor = Color.white;
            consumePower(12f);
            consumeCoolant(0.6f);
            shootType = new BulletType() {
                {
                    damage = 60f;
                    speed = 3.5f;
                    lifetime = 80f;
                    splashDamage = 140f;
                    splashDamageRadius = 65f;
                    hitEffect = ADEffects.voidBlast;
                    despawnEffect = ADEffects.voidBlast;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                    hittable = false;
                    collides = true;
                    collidesGround = true;
                    collidesAir = true;
                    collidesTiles = true;
                    keepVelocity = false;
                    drawSize = 160f;
                }

                @Override
                public void update(Bullet b) {
                    super.update(b);
                    if (b.timer(0, 5f)) {
                        Lightning.create(b.team, Color.valueOf("e0e8ff"), 15f, b.x, b.y, Mathf.random(360f), 18 + Mathf.random(12));
                        ADEffects.voidStormSpark.at(b.x + Mathf.range(30f), b.y + Mathf.range(30f));
                    }
                }

                @Override
                public void draw(Bullet b) {
                    float rad = 14f + 20f * b.fout();
                    Drawf.light(b.x, b.y, rad * 3f, ADEffects.voidGlow, 0.5f);
                    Draw.color(Color.white, ADEffects.voidSilver, b.fin());
                    Fill.circle(b.x, b.y, rad);
                    Draw.color(ADEffects.voidLight, Color.white, b.fout());
                    Fill.circle(b.x, b.y, rad * 0.5f);
                }
            };
            requirements(Category.turret, ItemStack.with(Items.copper, 1));
            category = Category.turret;
        }};
    }}
}
