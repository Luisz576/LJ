package com.luisz.lj.game.component;

import com.luisz.lj.game.LGame;
import com.luisz.lj.game.component.renderer.IRender;
import com.luisz.lj.game.component.updater.IUpdater;

import java.awt.*;

public abstract class LComponent implements IUpdater, IRender {
    protected final LGame game;
    public LComponent(LGame game){
        this.game = game;
    }

    @Override
    public void update(){}
    @Override
    public void render(Graphics g){}
}