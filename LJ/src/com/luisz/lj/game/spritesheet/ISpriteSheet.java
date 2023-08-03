package com.luisz.lj.game.spritesheet;

import java.awt.image.BufferedImage;

public interface ISpriteSheet {
    BufferedImage getSprite(int index);
    int size();
}