package com.luisz.lj.game.animation;

public interface IAnimation<T> {
    T getFrame(int index);
    int size();
}