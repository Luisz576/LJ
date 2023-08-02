package com.luisz.lj.game.configuration;

public class LPanelConfiguration {
    public int screenWidth, screenHeight;
    public boolean doubleBuffered, focusable;

    public LPanelConfiguration(int screenWidth, int screenHeight, boolean doubleBuffered, boolean focusable){
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.doubleBuffered = doubleBuffered;
        this.focusable = focusable;
    }
}