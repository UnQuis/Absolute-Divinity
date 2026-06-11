package absolutedivinity.content.blocks.effects;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Geometry;
import arc.math.geom.Rect;
import arc.util.Align;
import arc.util.Time;
import arc.util.Tmp;
import mindustry.Vars;
import mindustry.gen.Building;
import mindustry.gen.Call;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.ui.Fonts;
import mindustry.world.Block;
import mindustry.world.Tile;

public class Disruptor extends Block {
    public float timerBreak;
    public int maxWallSize;

    public Disruptor(String name) {
        super(name);
        update = true;
        solid = true;
        destructible = true;
        rebuildable = false;
        rotate = true;
        drawArrow = false;
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid) {
        super.drawPlace(x, y, rotation, valid);
        x *= Vars.tilesize;
        y *= Vars.tilesize;
        x += offset;
        y += offset;
        float len = Vars.tilesize * maxWallSize;
        Rect rect = Tmp.r1;
        rect.setCentered(x, y, maxWallSize * Vars.tilesize);
        rect.x += Geometry.d4x(rotation) * len;
        rect.y += Geometry.d4y(rotation) * len;
        Drawf.dashRect(valid ? Pal.accent : Pal.remove, rect);
    }

    public class DisruptorBuild extends Building {
        public float timer = 0;
        public boolean scanning = false;

        @Override
        public void updateTile() {
            float len = Vars.tilesize * maxWallSize;
            float scanCX = x + Geometry.d4x(rotation) * len;
            float scanCY = y + Geometry.d4y(rotation) * len;
            float half = maxWallSize * Vars.tilesize / 2f;

            int minTx = Mathf.round((scanCX - half) / Vars.tilesize);
            int maxTx = Mathf.round((scanCX + half) / Vars.tilesize);
            int minTy = Mathf.round((scanCY - half) / Vars.tilesize);
            int maxTy = Mathf.round((scanCY + half) / Vars.tilesize);

            boolean found = false;
            for (int tx = minTx; tx <= maxTx && !found; tx++) {
                for (int ty = minTy; ty <= maxTy && !found; ty++) {
                    Tile tile = Vars.world.tile(tx, ty);
                    if (tile != null && tile.block() != null && tile.build == null
                        && tile.block().solid && !tile.block().breakable
                        && tile.block().size <= maxWallSize) {
                        found = true;
                    }
                }
            }

            if (found) {
                timer += Time.delta;
            } else {
                timer = 0;
            }

            if (timer >= timerBreak) {
                for (int tx = minTx; tx <= maxTx; tx++) {
                    for (int ty = minTy; ty <= maxTy; ty++) {
                        Tile tile = Vars.world.tile(tx, ty);
                        if (tile != null && tile.block() != null && tile.build == null
                            && tile.block().solid && !tile.block().breakable
                            && tile.block().size <= maxWallSize) {
                            Call.removeTile(tile);
                        }
                    }
                }
                kill();
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
