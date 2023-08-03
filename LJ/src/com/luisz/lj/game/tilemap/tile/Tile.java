package com.luisz.lj.game.tilemap.tile;

import java.awt.image.BufferedImage;

public class Tile {
    public final int tileId, x, y, width, height;
    public final BufferedImage image;

    public Tile(int tileId, int x, int y, int width, int height, BufferedImage image){
        this.tileId = tileId;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }
}