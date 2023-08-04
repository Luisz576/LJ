package com.luisz.lj.utils.file.source;

import com.luisz.lj.utils.file.path.Pathable;
import com.luisz.lj.utils.image.ImageManipulator;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

public class SourceManipulator extends Pathable {
    private final ImageManipulator imageManipulator = new ImageManipulator();

    public final InputStream getInputStream(URL url) {
        try {
            return url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final BufferedReader getBufferedReader(URL url) {
        try {
            return new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final FileReader getFileReader(URL url) {
        try {
            return new FileReader(new File(url.toURI()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final Image getImageFromAbsolutePath(String path) {
        return this.toolkit.getImage(path);
    }

    public final InputStream getInputStreamFromAbsolutePath(String path) {
        try {
            return getURLFromAbsolutePath(path).openStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final BufferedReader getBufferedReaderFromAbsolutePath(String path) {
        try {
            return new BufferedReader(new FileReader(path));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final FileReader getFileReaderFromAbsolutePath(String path) {
        try {
            File file = new File(getURLFromAbsolutePath(path).toURI());
            return new FileReader(file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final Image getImageFromRelativePath(String path) {
        return this.toolkit.getImage(getJarFilePath() + path);
    }

    public final InputStream getInputStreamFromRelativePath(String path) {
        try {
            return getURLFromRelativePath(path).openStream();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final BufferedReader getBufferedReaderFromRelativePath(String path) {
        try {
            return new BufferedReader(new FileReader(new File(getURLFromRelativePath(path).toURI())));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final FileReader getFileReaderFromRelativePath(String path) {
        try {
            return new FileReader(new File(getURLFromRelativePath(path).toURI()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final BufferedReader getResourceBufferedReader(String path) {
        return getBufferedReader(getResource(path));
    }

    public final ImageIcon createImageIcon(URL url) {
        return imageManipulator.createImageIcon(url);
    }

    public final ImageIcon createResourceImageIcon(String path) {
        return imageManipulator.createImageIcon(getResource(path));
    }

    public final BufferedImage readURLBufferedImage(URL url) {
        return imageManipulator.readBufferedImage(url);
    }

    public final BufferedImage readResourceBufferedImage(String path) {
        return readURLBufferedImage(getResource(path));
    }

    public final BufferedImage readBufferedImageFromAbsolutePath(String path) {
        try {
            return imageManipulator.readBufferedImage(getURLFromAbsolutePath(path));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final BufferedImage readBufferedImageFromRelativePath(String path) {
        try {
            return imageManipulator.readBufferedImage(getURLFromRelativePath(path));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}