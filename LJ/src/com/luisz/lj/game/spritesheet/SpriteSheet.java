package com.luisz.lj.game.spritesheet;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SpriteSheet implements ISpriteSheet {
    private final BufferedImage[] sprites;
    private final int size;

    public List<BufferedImage> getSprites(){
        return new ArrayList<>(Arrays.asList(this.sprites));
    }

    @Override
    public BufferedImage getSprite(int index) {
        return sprites[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    public SpriteSheet(Collection<BufferedImage> sprites){
        this.size = sprites.size();
        this.sprites = new BufferedImage[this.size];
        int i = 0;
        for(BufferedImage sprite : sprites) {
            this.sprites[i] = sprite;
            i++;
        }
    }
}