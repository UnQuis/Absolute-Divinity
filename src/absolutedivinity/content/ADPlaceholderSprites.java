package absolutedivinity.content;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.Pixmap;
import arc.graphics.Texture;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import arc.struct.Seq;
import arc.util.Log;
import mindustry.Vars;
import mindustry.ctype.Content;
import mindustry.ctype.MappableContent;
import mindustry.world.Block;

/**
 * Generates programmatic placeholder sprites for every AD block/item that lacks an asset.
 * Ensures the mod boots on 160.1 without requiring external PNGs while looking faction-colored.
 *
 * Faction palette:
 * Void  = silver/white   (#a8b8ff)
 * Order = white          (#ffffff)
 * Abyss = purple         (#9000a4)
 * Chaos = red/black      (#ff6b6b)
 * Time  = gold/yellow    (#f0e060)
 * Info  = green          (#77df00)
 */
public class ADPlaceholderSprites {

    public static void generate() {
        if (Vars.headless) return;

        Seq<Content> all = new Seq<>();
        // collect all AD blocks for placeholder check
        // we do it lazily via Vars.content.blocks()
        for (Block b : Vars.content.blocks()) {
            if (b.minfo.mod != null && b.minfo.mod.name.equals("absolutedivinity")) {
                ensureBlockSprite(b);
            }
        }
        Log.info("[AD] Placeholder sprites checked for @ blocks", Vars.content.blocks().size);
    }

    private static void ensureBlockSprite(Block block) {
        String name = block.name; // e.g. "absolutedivinity-void-1"
        if (Core.atlas.find(name).found()) return;

        // pick faction color by name substring
        Color col = factionColor(name);
        Color dark = col.cpy().mul(0.5f);
        Color light = col.cpy().lerp(Color.white, 0.35f);

        int size = block.size * 32;
        size = Mathf.clamp(size, 32, 256);

        Pixmap pix = new Pixmap(size, size);
        // base
        pix.setColor(dark);
        pix.fill();
        // inner fill
        pix.setColor(col);
        pix.fillRect(4, 4, size - 8, size - 8);
        // faction stripe
        pix.setColor(light);
        pix.fillRect(0, size / 2 - 2, size, 4);
        pix.fillRect(size / 2 - 2, 0, 4, size);
        // border
        pix.setColor(Color.white);
        pix.drawRect(0, 0, size, size);

        // add letter hint
        // we keep it simple — diagonal highlight
        pix.setColor(light.cpy().a(0.4f));
        for (int i = 0; i < size; i += 4) {
            pix.drawLine(i, 0, 0, i);
        }

        Texture tex = new Texture(pix);
        tex.setFilter(Texture.TextureFilter.nearest);
        TextureRegion region = new TextureRegion(tex);
        Core.atlas.addRegion(name, region);
        // also add -team variant fallback
        Core.atlas.addRegion(name + "-team", region);
        pix.dispose();
        Log.info("[AD] Generated placeholder for @ -> @", name, col);
    }

    private static Color factionColor(String name) {
        String n = name.toLowerCase();
        if (n.contains("astralite") || n.contains("astral")) return Color.valueOf("f2f0ff").cpy();
        if (n.contains("singularity")) return Color.valueOf("191c2b").cpy();
        if (n.contains("quantum")) return Color.valueOf("f2f0ff").cpy().lerp(Color.valueOf("191c2b"), 0.3f);
        if (n.contains("void")) return ADColor.voidGlow.cpy();
        if (n.contains("order")) return ADColor.orderMain.cpy();
        if (n.contains("abyss")) return ADColor.abyssMain.cpy();
        if (n.contains("chaos")) return ADColor.chaosMain.cpy();
        if (n.contains("time") || n.contains("chrono") || n.contains("boreas") || n.contains("argon")) return ADColor.timeMain.cpy();
        if (n.contains("info")) return ADColor.infoMain.cpy();
        if (n.contains("reactor") || n.contains("power")) return Color.valueOf("ffd700");
        if (n.contains("conduit") || n.contains("router") || n.contains("bridge") || n.contains("conveyor")) return Color.valueOf("9a7a5a");
        if (n.contains("wall")) return Color.valueOf("6a7a8a");
        if (n.contains("core")) return Color.valueOf("ffaa66");
        return Color.valueOf("888888");
    }

    /** Generate placeholder for item icon similarly */
    public static void generateItem(String itemName) {
        if (Vars.headless) return;
        String full = "absolutedivinity-" + itemName;
        if (Core.atlas.find(full).found()) return;
        Color col = factionColor(itemName);
        Pixmap pix = new Pixmap(32, 32);
        pix.setColor(col.cpy().mul(0.6f));
        pix.fillCircle(16, 16, 14);
        pix.setColor(col);
        pix.fillCircle(16, 16, 10);
        pix.setColor(Color.white);
        pix.fillCircle(16, 16, 3);
        Texture tex = new Texture(pix);
        Core.atlas.addRegion(full, new TextureRegion(tex));
        pix.dispose();
    }
}
