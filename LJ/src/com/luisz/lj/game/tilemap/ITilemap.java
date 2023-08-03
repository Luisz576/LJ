package com.luisz.lj.game.tilemap;

import com.luisz.lj.game.tilemap.tile.Tile;

public interface ITilemap {
    Tile getTile(int index);
    int size();
}