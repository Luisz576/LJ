package com.luisz.lj.utils.math.vector2d;

public class UnmodifiableVector2D extends Vector2D {
    public final int x, y;

    public UnmodifiableVector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
}