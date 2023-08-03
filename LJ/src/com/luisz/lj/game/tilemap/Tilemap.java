package com.luisz.lj.game.tilemap;

import com.luisz.lj.game.tilemap.tile.Tile;
import com.luisz.lj.utils.math.vector2d.Vector2D;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Tilemap implements ITilemap {
    protected final List<Tile> tiles = new ArrayList<>();
    public final Vector2D resolution;

    public Tilemap(Vector2D resolution, Collection<Tile> tiles) {
        this.resolution = resolution;
        this.tiles.addAll(tiles);
    }

    @Override
    public int size() {
        return this.tiles.size();
    }

    @Override
    public Tile getTile(int index) {
        if (index < this.tiles.size())
            return this.tiles.get(index);
        return null;
    }

    public List<Tile> getTiles() {
        return this.tiles;
    }
}