package com.luisz.lj.utils.font;

public enum FontWeight {
    PLAIN(0),
    BOLD(1),
    ITALIC(2);

    public final int value;

    FontWeight(int value) {
        this.value = value;
    }
}