package com.luisz.lj.game.configuration;

public class LGameConfiguration {
    public String title;
    public int defaultCloseOperation, fps;
    public boolean resizable;

    public LGameConfiguration(String title, int defaultCloseOperation, boolean resizable, int fps){
        this.title = title;
        this.defaultCloseOperation = defaultCloseOperation;
        this.resizable = resizable;
        this.fps = fps;
    }
}