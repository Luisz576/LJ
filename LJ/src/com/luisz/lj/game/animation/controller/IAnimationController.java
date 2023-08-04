package com.luisz.lj.game.animation.controller;

public interface IAnimationController<T> {
    T getValue();
    boolean isLoop();
    void play();
    void pause();
    boolean isPaused();
}