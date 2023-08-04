package com.luisz.lj.game.tilemap;

import com.luisz.lj.game.tilemap.tile.Tile;
import com.luisz.lj.utils.math.vector2d.Vector2D;

import java.util.ArrayList;
import java.util.Collection;

public class EditableTilemap extends Tilemap{
    public EditableTilemap(Vector2D resolution){
        super(resolution, new ArrayList<>());
    }
    public EditableTilemap(Vector2D resolution, Collection<Tile> tiles) {
        super(resolution, tiles);
    }

    public final void addTile(Tile tile) {
        this.tiles.add(tile);
    }

    public final void addTiles(Collection<Tile> tiles) {
        this.tiles.addAll(tiles);
    }

    public final boolean removeTile(Integer index) {
        return this.tiles.remove(index.intValue()) != null;
    }
}