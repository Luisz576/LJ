package net.teste;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16,
        scale = 3,
    tileSize = originalTileSize * scale,
    maxScreenCol = 16,
    maxScreenRow = 12,
    screenWidth = tileSize * maxScreenCol,
    screenHeight = tileSize * maxScreenRow,
    FPS = 60;

    Thread gameThread;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(new KeyHandler());
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

//    @Override
//    public void run() {
//        double drawInterval = 1000000000 / FPS;
//        double nextDrawTime = System.nanoTime() + drawInterval;
//
//        while(gameThread != null){
//            update();
//            repaint();
//
//            try{
//                double remainingTime = (nextDrawTime - System.nanoTime()) / 1000000;
//                if(remainingTime < 0){
//                    remainingTime = 0;
//                }
//                Thread.sleep((long) remainingTime);
//                nextDrawTime += drawInterval;
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//    }
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS,
                delta = 0;
        long lastTime = System.nanoTime(),
                currentTime;

        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update(){

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(100, 100, tileSize, tileSize);
        g2.dispose();
    }
}