package com.luisz.lj.game.spritesheet;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EditableSpriteSheet implements ISpriteSheet{
    private final List<BufferedImage> sprites = new ArrayList<>();

    public List<BufferedImage> getSprites() {
        return Collections.unmodifiableList(sprites);
    }

    public void addSprite(BufferedImage sprite) {
        this.sprites.add(sprite);
    }

    public void addSprites(List<BufferedImage> sprites) {
        this.sprites.addAll(sprites);
    }

    public BufferedImage removeSprite(int index) {
        return this.sprites.remove(index);
    }

    public boolean removeSprite(BufferedImage sprite) {
        return this.sprites.remove(sprite);
    }

    public void removeAllSprites() {
        this.sprites.clear();
    }

    @Override
    public BufferedImage getSprite(int index) {
        return this.sprites.get(index);
    }

    @Override
    public int size() {
        return this.sprites.size();
    }

    public EditableSpriteSheet() {}
    public EditableSpriteSheet(List<BufferedImage> sprites) {
        this.sprites.addAll(sprites);
    }
}