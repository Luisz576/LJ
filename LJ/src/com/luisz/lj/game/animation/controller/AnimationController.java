package com.luisz.lj.game.animation.controller;

public abstract class AnimationController<T> implements IAnimationController<T> {
    protected T value;
    @Override
    public final T getValue(){
        return this.value;
    }
    protected boolean loop = false;
    @Override
    public final boolean isLoop(){
        return this.loop;
    }

    public AnimationController(){}
    public AnimationController(T initialValue){
        this.value = initialValue;
    }
}