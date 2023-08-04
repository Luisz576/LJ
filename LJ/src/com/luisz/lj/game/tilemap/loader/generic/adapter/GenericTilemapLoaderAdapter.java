package com.luisz.lj.game.tilemap.loader.generic.adapter;

import com.luisz.lj.game.tilemap.ITilemap;

public abstract class GenericTilemapLoaderAdapter {
    public abstract void readLine(int lineIndex, String line);
    public abstract ITilemap getResultAndReset();
    public abstract void onException(Exception e);
}