package com.luisz.lj.utils.font;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Fonts {
    public static Font Arial(FontWeight weight, int size) {
        return new Font("Arial", weight.value, size);
    }

    public static Font Dialog(FontWeight weight, int size) {
        return new Font("Dialog", weight.value, size);
    }

    public static Font DialogInput(FontWeight weight, int size) {
        return new Font("DialogInput", weight.value, size);
    }

    public static Font Monospaced(FontWeight weight, int size) {
        return new Font("Monospaced", weight.value, size);
    }

    public static Font Serif(FontWeight weight, int size) {
        return new Font("Serif", weight.value, size);
    }

    public static Font SansSerif(FontWeight weight, int size) {
        return new Font("SansSerif", weight.value, size);
    }

    private static final Map<String, Font> fonts = new HashMap<>();

    public static boolean registerCustomFont(String fontName, InputStream is) throws IOException, FontFormatException {
        if (hasCustomFont(fontName))
            return false;
        Font font = Font.createFont(0, is);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        fonts.put(fontName, font);
        return true;
    }

    public static Font getFont(String fontName, float size) {
        Font font = fonts.get(fontName);
        return font.deriveFont(size);
    }

    public static boolean hasCustomFont(String fontName) {
        return fonts.containsKey(fontName);
    }
}