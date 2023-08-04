package com.luisz.lj.game.tilemap.loader.generic;

import com.luisz.lj.game.tilemap.ITilemap;
import com.luisz.lj.game.tilemap.loader.ITilemapLoader;
import com.luisz.lj.game.tilemap.loader.generic.adapter.GenericTilemapLoaderAdapter;
import com.luisz.lj.utils.file.source.SourceManipulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;

public class GenericTilemapLoader extends SourceManipulator implements ITilemapLoader {
    private final GenericTilemapLoaderAdapter adapter;
    private URL url;

    public void setSource(URL url){
        this.url = url;
    }

    public GenericTilemapLoader(GenericTilemapLoaderAdapter adapter){
        this.adapter = adapter;
    }

    @Override
    public ITilemap load() {
        if(url == null){
            return null;
        }
        BufferedReader br = getBufferedReader(this.url);
        if(br != null){
            try{
                int lineIndex = 0;
                String line;
                while ((line = br.readLine()) != null) {
                    this.adapter.readLine(lineIndex, line);
                }
            }catch(IOException e){
                this.adapter.onException(e);
            }
        }
        return this.adapter.getResultAndReset();
    }
}