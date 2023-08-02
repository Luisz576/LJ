package com.luisz.lj.drawer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LDrawer {
    public void fillRect(Graphics g, int x, int y, int width, int height, Color color){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    public void fillRect(Graphics2D g, int x, int y, int width, int height, Color color, double angleX, double angleY, double rotation){
        g.rotate(Math.toRadians(rotation), angleX, angleY);
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.rotate(Math.toRadians(-rotation), angleX, angleY);
    }

    public void fillRoundRect(Graphics g, int x, int y, int width, int height, Color color, int arcWidth, int arcHeight) {
        g.setColor(color);
        g.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
    }
    public void fillRoundRect(Graphics2D g, int x, int y, int width, int height, Color color, int arcWidth, int arcHeight, double angleX, double angleY, double rotation) {
        g.rotate(Math.toRadians(rotation), angleX, angleY);
        g.setColor(color);
        g.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
        g.rotate(Math.toRadians(-rotation), angleX, angleY);
    }

    public void fillArc(Graphics g, int x, int y, int width, int height, int start, int end, Color color) {
        g.setColor(color);
        g.fillArc(x, y, width, height, start, end);
    }

    public void fillOval(Graphics g, int x, int y, int width, int height, Color color) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }

    public void fillPolygon(Graphics g, int[] xs, int[] ys, int numberOfPoints, Color color) {
        g.setColor(color);
        g.fillPolygon(xs, ys, numberOfPoints);
    }
    public void fillPolygon(Graphics2D g, int[] xs, int[] ys, int numberOfPoints, Color color, double angleX, double angleY, double rotation) {
        g.rotate(Math.toRadians(rotation), angleX, angleY);
        g.setColor(color);
        g.fillPolygon(xs, ys, numberOfPoints);
        g.rotate(Math.toRadians(-rotation), angleX, angleY);
    }
    public void fillPolygon(Graphics g, Polygon polygon, Color color) {
        g.setColor(color);
        g.fillPolygon(polygon);
    }
    public void fillPolygon(Graphics2D g, Polygon polygon, Color color, double angleX, double angleY, double rotation) {
        g.rotate(Math.toRadians(rotation), angleX, angleY);
        g.setColor(color);
        g.fillPolygon(polygon);
        g.rotate(Math.toRadians(-rotation), angleX, angleY);
    }

    public void drawLine(Graphics g, int startX, int startY, int endX, int endY, Color color) {
        g.setColor(color);
        g.drawLine(startX, startY, endX, endY);
    }

    public void drawRect(Graphics g, int x, int y, int width, int height, Color color) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }
    public void drawRect(Graphics2D g, int x, int y, int width, int height, Color color, double angleX, double angleY, double rotation) {
        g.rotate(Math.toRadians(rotation), angleX, angleY);
        g.setColor(color);
        g.drawRect(x, y, width, height);
        g.rotate(Math.toRadians(-rotation), angleX, angleY);
    }

    public void drawRoundRect(Graphics g, int x, int y, int width, int height, Color color, int arcWidth, int arcHeight) {
        g.setColor(color);
        g.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
    }
    public void drawRoundRect(Graphics2D g, int x, int y, int width, int height, Color color, int arcWidth, int arcHeight, double angleX, double angleY, double rotation) {
        g.rotate(Math.toRadians(rotation), angleX, angleY);
        g.setColor(color);
        g.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
        g.rotate(Math.toRadians(-rotation), angleX, angleY);
    }

    public void drawOval(Graphics g, int x, int y, int width, int height, Color color) {
        g.setColor(color);
        g.drawOval(x, y, width, height);
    }

    public void drawArc(Graphics g, int x, int y, int width, int height, int start, int end, Color color) {
        g.setColor(color);
        g.drawArc(x, y, width, height, start, end);
    }

    public void drawPolygon(Graphics g, int[] xs, int[] ys, int numberOfPoints, Color color) {
        g.setColor(color);
        g.drawPolygon(xs, ys, numberOfPoints);
    }
    public void drawPolygon(Graphics2D g, int[] xs, int[] ys, int numberOfPoints, Color color, double angleX, double angleY, double rotation) {
        g.rotate(Math.toRadians(rotation), angleX, angleY);
        g.setColor(color);
        g.drawPolygon(xs, ys, numberOfPoints);
        g.rotate(Math.toRadians(-rotation), angleX, angleY);
    }
    public void drawPolygon(Graphics g, Polygon polygon, Color color) {
        g.setColor(color);
        g.drawPolygon(polygon);
    }
    public void drawPolygon(Graphics2D g, Polygon polygon, Color color, double angleX, double angleY, double rotation) {
        g.rotate(Math.toRadians(rotation), angleX, angleY);
        g.setColor(color);
        g.drawPolygon(polygon);
        g.rotate(Math.toRadians(-rotation), angleX, angleY);
    }

    public void drawString(Graphics g, Font font, String string, int x, int y, Color color) {
        g.setColor(color);
        g.setFont(font);
        try {
            g.drawString(string, x, y);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawImage(Graphics g, BufferedImage bufferedImage, int x, int y) {
        g.drawImage(bufferedImage, x, y, getImageObserver());
    }
    public void drawImage(Graphics g, BufferedImage bufferedImage, int x, int y, int width, int height) {
        g.drawImage(bufferedImage, x, y, width, height, getImageObserver());
    }
    public void drawImage(Graphics g, BufferedImage bufferedImage, int x, int y, Color color) {
        g.drawImage(bufferedImage, x, y, color, getImageObserver());
    }
    public void drawImage(Graphics g, BufferedImage bufferedImage, int x, int y, int width, int height, Color color) {
        g.drawImage(bufferedImage, x, y, width, height, color, getImageObserver());
    }
}