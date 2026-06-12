package absolutedivinity.content.blocks.power;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.Effect;
import mindustry.gen.Sounds;
import mindustry.graphics.Drawf;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.power.ConsumeGenerator;

public class ADReactors {
    public static ConsumeGenerator
        basicReactor,
        advancedReactor,
        powerReactor,
        voidReactor,
        divinityReactor;

    public static void load() {{
        basicReactor = new ConsumeGenerator("basic-reactor") {{
            localizedName = "Basic Reactor";
            description = "A simple reactor that generates moderate power. Explodes when destroyed.";
            size = 2;
            health = 800;
            powerProduction = 2f;
            itemDuration = 120f;
            hasItems = true;
            hasLiquids = true;
            liquidCapacity = 30f;
            explodeEffect = new Effect(30f, e -> {
                Draw.color(Color.orange, Color.red, e.fin());
                Lines.stroke(3f * e.fout());
                Lines.circle(e.x, e.y, e.fin() * 40f);
                Angles.randLenVectors(e.id, 8, 30f * e.fin(), (x, y) -> Fill.circle(e.x + x, e.y + y, 3f * e.fout()));
            });
            explodeSound = Sounds.explosion;
            requirements(Category.power, ItemStack.with(
                Items.copper, 100,
                Items.lead, 80,
                Items.graphite, 30
            ));
            consumeItems(new mindustry.type.ItemStack(Items.coal, 1));
        }};

        advancedReactor = new ConsumeGenerator("advanced-reactor") {{
            localizedName = "Advanced Reactor";
            description = "An advanced reactor with higher output. Explodes violently when destroyed.";
            size = 3;
            health = 2000;
            powerProduction = 6f;
            itemDuration = 100f;
            hasItems = true;
            hasLiquids = true;
            liquidCapacity = 60f;
            explodeEffect = new Effect(50f, e -> {
                Draw.color(Color.yellow, Color.red, e.fin());
                Lines.stroke(5f * e.fout());
                Lines.circle(e.x, e.y, e.fin() * 80f);
                Angles.randLenVectors(e.id, 16, 60f * e.fin(), (x, y) -> Fill.circle(e.x + x, e.y + y, 5f * e.fout()));
                Drawf.light(e.x, e.y, e.fout() * 120f, Color.orange, 0.8f);
            });
            explodeSound = Sounds.explosion;
            requirements(Category.power, ItemStack.with(
                Items.copper, 300,
                Items.lead, 200,
                Items.graphite, 80,
                Items.silicon, 50
            ));
            consumeItems(new mindustry.type.ItemStack(Items.coal, 1));
        }};

        powerReactor = new ConsumeGenerator("power-reactor") {{
            localizedName = "Power Reactor";
            description = "A powerful reactor that generates massive energy. Explodes in a devastating blast.";
            size = 4;
            health = 5000;
            powerProduction = 15f;
            itemDuration = 80f;
            hasItems = true;
            hasLiquids = true;
            liquidCapacity = 120f;
            explodeEffect = new Effect(80f, 200f, e -> {
                Draw.color(Color.yellow, Color.white, e.fin());
                Lines.stroke(8f * e.fout());
                Lines.circle(e.x, e.y, e.fin() * 150f);
                Angles.randLenVectors(e.id, 24, 120f * e.fin(), (x, y) -> Fill.circle(e.x + x, e.y + y, 7f * e.fout()));
                for(int i = 0; i < 6; i++){
                    float ang = 360f / 6 * i;
                    float len = e.fin() * 120f;
                    Lines.lineAngle(e.x, e.y, ang, len);
                }
                Drawf.light(e.x, e.y, e.fout() * 250f, Color.yellow, 0.9f);
            });
            explodeSound = Sounds.explosion;
            requirements(Category.power, ItemStack.with(
                Items.copper, 800,
                Items.lead, 600,
                Items.graphite, 200,
                Items.silicon, 150,
                Items.titanium, 100
            ));
            consumeItems(new mindustry.type.ItemStack(Items.coal, 1));
        }};

        voidReactor = new ConsumeGenerator("void-reactor") {{
            localizedName = "Void Reactor";
            description = "A reactor that channels void energy. Creates a gravitational singularity when destroyed.";
            size = 5;
            health = 12000;
            powerProduction = 40f;
            itemDuration = 60f;
            hasItems = true;
            hasLiquids = true;
            liquidCapacity = 200f;
            explodeEffect = new Effect(120f, 400f, e -> {
                Draw.color(Color.valueOf("a8b8ff"), Color.white, e.fin());
                Lines.stroke(12f * e.fout());
                Lines.circle(e.x, e.y, e.fin() * 250f);
                Angles.randLenVectors(e.id, 40, 200f * e.fin(), (x, y) -> Fill.circle(e.x + x, e.y + y, 10f * e.fout()));
                for(int i = 0; i < 8; i++){
                    float ang = 360f / 8 * i + e.time * 30f;
                    float len = e.fin() * 200f;
                    Lines.lineAngle(e.x, e.y, ang, len);
                }
                Drawf.light(e.x, e.y, e.fout() * 400f, Color.valueOf("a8b8ff"), 1f);
            });
            explodeSound = Sounds.explosion;
            requirements(Category.power, ItemStack.with(
                Items.copper, 2000,
                Items.lead, 1500,
                Items.graphite, 500,
                Items.silicon, 400,
                Items.titanium, 300,
                Items.thorium, 200
            ));
            consumeItems(new mindustry.type.ItemStack(Items.coal, 1));
        }};

        divinityReactor = new ConsumeGenerator("divinity-reactor") {{
            localizedName = "Divinity Reactor";
            description = "The ultimate power source. Channels divine energy. Creates a cataclysmic explosion when destroyed.";
            size = 6;
            health = 25000;
            powerProduction = 100f;
            itemDuration = 40f;
            hasItems = true;
            hasLiquids = true;
            liquidCapacity = 400f;
            explodeEffect = new Effect(180f, 800f, e -> {
                Draw.color(Color.valueOf("ffd700"), Color.white, e.fin());
                Lines.stroke(18f * e.fout());
                Lines.circle(e.x, e.y, e.fin() * 400f);
                Angles.randLenVectors(e.id, 60, 350f * e.fin(), (x, y) -> Fill.circle(e.x + x, e.y + y, 14f * e.fout()));
                for(int i = 0; i < 12; i++){
                    float ang = 360f / 12 * i + e.time * 20f;
                    float len = e.fin() * 350f;
                    Lines.lineAngle(e.x, e.y, ang, len);
                }
                Drawf.light(e.x, e.y, e.fout() * 600f, Color.valueOf("ffd700"), 1f);
            });
            explodeSound = Sounds.explosion;
            requirements(Category.power, ItemStack.with(
                Items.copper, 5000,
                Items.lead, 4000,
                Items.graphite, 1200,
                Items.silicon, 1000,
                Items.titanium, 800,
                Items.thorium, 500,
                Items.surgeAlloy, 300
            ));
            consumeItems(new mindustry.type.ItemStack(Items.coal, 1));
        }};
    }}
}
