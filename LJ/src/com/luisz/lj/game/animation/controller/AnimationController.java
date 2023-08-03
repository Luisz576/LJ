package com.luisz.lj.game.animation.controller;

import com.luisz.lj.game.component.updater.IUpdater;

public abstract class AnimationController<T> implements IUpdater {
    protected T value;
    public final T getValue(){
        return this.value;
    }
    protected boolean loop = false;
    public final boolean isLoop(){
        return this.loop;
    }

    public AnimationController(){}
    public AnimationController(T initialValue){
        this.value = initialValue;
    }

    @Override
    public abstract void update();
}