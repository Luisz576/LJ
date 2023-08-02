package com.luisz.lj.utils.image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;

public class ImageManipulator {
    public ImageIcon createImageIcon(URL imageUrl) {
        return new ImageIcon(imageUrl);
    }

    public ImageIcon createImageIcon(Image image) {
        return new ImageIcon(image);
    }

    public BufferedImage readBufferedImage(URL imageUrl) {
        try {
            return ImageIO.read(imageUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public BufferedImage readBufferedImage(File imageFile) {
        try {
            return ImageIO.read(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public BufferedImage readBufferedImage(InputStream imageInputStream) {
        try {
            return ImageIO.read(imageInputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public BufferedImage readBufferedImage(ImageInputStream imageInputStream) {
        try {
            return ImageIO.read(imageInputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean writeImage(String absoluteFilePath, BufferedImage image, String format) {
        return writeImage(new File(absoluteFilePath), image, format);
    }

    public boolean writeImage(URI fileUrl, BufferedImage image, String format) {
        return writeImage(new File(fileUrl), image, format);
    }

    public boolean writeImage(File file, BufferedImage image, String format) {
        try {
            ImageIO.write(image, format, file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}