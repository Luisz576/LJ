package com.luisz.lj.game.tilemap.loader.generic;

import com.luisz.lj.game.tilemap.ITilemap;
import com.luisz.lj.game.tilemap.loader.ITilemapLoader;
import com.luisz.lj.game.tilemap.loader.generic.adapter.GenericTilemapLoaderAdapter;

public class GenericTilemapLoader implements ITilemapLoader {
    private final GenericTilemapLoaderAdapter adapter;

    public GenericTilemapLoader(GenericTilemapLoaderAdapter adapter){
        this.adapter = adapter;
    }

    @Override
    public ITilemap load() {
        // TODO
        return null;
    }
}