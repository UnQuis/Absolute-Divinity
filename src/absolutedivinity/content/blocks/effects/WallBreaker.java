package absolutedivinity.content.blocks.effects;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Geometry;
import arc.math.geom.Rect;
import arc.util.Align;
import arc.util.Time;
import arc.util.Tmp;
import mindustry.Vars;
import mindustry.content.Items;
import mindustry.gen.Building;
import mindustry.gen.Call;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.ui.Fonts;
import mindustry.world.Block;
import mindustry.world.Tile;

public class WallBreaker extends Block {
    public float timerBreak;
    public int maxWallSize;

    public WallBreaker(String name) {
        super(name);
        update = true;
        solid = true;
        destructible = true;
        rebuildable = false;
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid) {
        super.drawPlace(x, y, rotation, valid);
        x *= Vars.tilesize;
        y *= Vars.tilesize;
        x += offset;
        y += offset;
        Rect rect = Tmp.r1;
        rect.setCentered(x, y, maxWallSize * Vars.tilesize);
        int len = Vars.tilesize * maxWallSize;
        rect.x += Geometry.d4x(rotation) * len;
        rect.y += Geometry.d4y(rotation) * len;
        Drawf.dashRect(valid ? Pal.accent : Pal.remove, rect);
    }

    public class WallBreakerBuild extends Building {
        public float timer = 0;

        @Override
        public void updateTile() {
            Tile tile = Vars.world.tile(tileX() + Geometry.d4x(rotation), tileY() + Geometry.d4y(rotation));
            if (tile != null && tile.block() != null && tile.build == null && tile.block().solid && !tile.block().breakable && tile.block().size <= maxWallSize) {
                timer += Time.delta;
                if (timer >= timerBreak) {
                    Call.removeTile(tile);
                    kill();
                }
            }
        }

        @Override
        public void draw() {
            super.draw();
            int s = Mathf.ceil((timerBreak - timer) / 60);
            String text = "|" + s + "|";
            Fonts.def.draw(text, this.x, this.y, Color.red, 0.35f, true, Align.center);
        }
    }
}
