package absolutedivinity.content.units.t1;

import arc.graphics.Color;
import mindustry.ai.types.MinerAI;
import mindustry.entities.abilities.RepairFieldAbility;
import mindustry.entities.effect.WaveEffect;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;

public class BuilderSpriteUnit {
    public static UnitType builderSprite;

    public static void load() {
        builderSprite = new UnitType("builder-sprite") {{
            constructor = UnitEntity::create;
            localizedName = "Builder Sprite";
            description = "A versatile support drone capable of mining, repairing, and building on the fly.";
            abilities.add(new RepairFieldAbility(40f, 60f, 2f) {{
                activeEffect = new WaveEffect() {{
                    sizeFrom = 0f;
                    sizeTo = 60f;
                    colorFrom = Color.valueOf("84f491");
                    colorTo = Color.valueOf("62ae7f");
                }};
            }});
            mineSpeed = 2.8f;
            mineTier = 1;
            canAttack = false;
            buildSpeed = 0.3f;
            engineColor = Color.valueOf("84f491");
            engineColorInner = Color.valueOf("62ae7f");
            armor = 0;
            itemCapacity = 30;
            speed = 1.9f;
            canHeal = true;
            drawBuildBeam = true;
            health = 300;
            mineHardnessScaling = true;
            flying = true;
            controller = u -> new MinerAI();
            hitSize = 8;
        }};
    }
}
