package com.luisz.lj.game;

import com.luisz.lj.game.configuration.LGameConfiguration;
import com.luisz.lj.game.drawer.LDrawer;

import javax.swing.*;
import java.awt.*;

public abstract class LGame implements Runnable{
    public final int fps;
    private final double intervalTime;
    private final JFrame window;
    private final Thread gameThread;
    public final JFrame getWindow(){
        return this.window;
    }
    public final void hideWindow(){
        this.window.setVisible(false);
    }
    public final void showWindow(){
        this.window.setVisible(true);
    }
    public final void packWindow(){
        this.window.pack();
    }
    public final void addWindowComponent(Component component){
        this.window.add(component);
    }

    private boolean stopped = false;
    public final boolean isStopped(){
        return this.stopped;
    }
    public final void setStopped(boolean stopped){
        this.stopped = stopped;
    }

    public final LDrawer drawer = new LDrawer();

    public LGame(LGameConfiguration configuration){
        this.fps = configuration.fps;
        this.intervalTime = (double) 1000000000 / this.fps;
        window = new JFrame();
        window.setDefaultCloseOperation(configuration.defaultCloseOperation);
        window.setResizable(configuration.resizable);
        window.setTitle(configuration.title);
        window.setLocationRelativeTo(null);
        gameThread = new Thread(this);
    }

    public final void start(){
        this.gameThread.start();
    }

    protected int deltaTime = 0;
    @Override
    public final void run() {
        long lastTime = System.nanoTime(), currentTime;
        while(!stopped){
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastTime) / intervalTime;
            lastTime = currentTime;
            if(deltaTime >= 1){
                update();
                deltaTime--;
            }
        }
    }

    protected abstract void update();
}