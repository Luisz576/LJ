package com.luisz.lj.utils.math.vector2d;

public class Vector2D {
    public int x, y;

    public Vector2D(){}
    public Vector2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    public final Vector2D createNew(){
        return new Vector2D(this.x, this.y);
    }
}