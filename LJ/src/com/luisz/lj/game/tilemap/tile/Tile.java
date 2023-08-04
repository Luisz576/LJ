package com.luisz.lj.game.tilemap.tile;

import com.luisz.lj.utils.math.vector2d.Vector2D;

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
    public Tile(int tileId, int x, int y, Vector2D resolution, BufferedImage image){
        this.tileId = tileId;
        this.x = x;
        this.y = y;
        this.width = resolution.x;
        this.height = resolution.y;
        this.image = image;
    }
}