package com.luisz.lj.game.animation;

import java.util.*;

public class Animation<T> implements IAnimation<T> {
    public final String name;

    private final List<T> frames;
    public final List<T> getFrames(){
        return Collections.unmodifiableList(frames);
    }
    @Override
    public final T getFrame(int index){
        return this.frames.get(index);
    }

    public final int size;
    @Override
    public int size(){
        return this.size;
    }

    public Animation(String name, Collection<T> frames){
        this.name = name;
        this.size = frames.size();
        this.frames = new ArrayList<>();
        Iterator<T> it = frames.iterator();
        int i = 0;
        while(it.hasNext()){
            this.frames.add(it.next());
            i++;
        }
    }
}