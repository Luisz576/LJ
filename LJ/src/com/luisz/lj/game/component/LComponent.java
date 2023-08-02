package com.luisz.lj.game.component;

import com.luisz.lj.game.LGame;

public abstract class LComponent {
    protected final LGame game;
    public LComponent(LGame game){
        this.game = game;
    }

    public void update(){}
    public void render(){}
}