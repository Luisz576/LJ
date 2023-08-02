package com.luisz.lj.utils.path;

import java.awt.*;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public abstract class Pathable {
    protected final Toolkit toolkit = Toolkit.getDefaultToolkit();

    public final Toolkit getToolkit() {
        return this.toolkit;
    }

    public final String getPathFromUrl(URL url) throws UnsupportedEncodingException {
        return getPathFromUrl(url, StandardCharsets.UTF_8);
    }
    public final String getPathFromUrl(URL url, Charset standardCharsets) throws UnsupportedEncodingException {
        return URLDecoder.decode(url.getPath(), StandardCharsets.UTF_8.name());
    }

    public final String getJarFilePath() {
        try {
            return URLDecoder.decode((new File(getClass().getProtectionDomain().getCodeSource().getLocation().getFile())).getParent(), StandardCharsets.UTF_8.name()) + "/";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final URL tryGetURLFromAbsolutePath(String path) {
        try {
            return getURLFromAbsolutePath(path);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final URL getURLFromAbsolutePath(String path) throws MalformedURLException {
        return (new File(path)).toURI().toURL();
    }

    public final String tryGetPathFromAbsolutePath(String path) {
        try {
            return getPathFromAbsolutePath(path);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String getPathFromAbsolutePath(String path) throws MalformedURLException, UnsupportedEncodingException {
        return getPathFromUrl(getURLFromAbsolutePath(path));
    }

    public final URL tryGetURLFromRelativePath(String path) {
        try {
            return getURLFromRelativePath(path);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final URL getURLFromRelativePath(String path) throws MalformedURLException {
        return (new File(getJarFilePath() + path)).toURI().toURL();
    }

    public final String tryGetPathFromRelativePath(String path) {
        try {
            return getPathFromRelativePath(path);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String getPathFromRelativePath(String path) {
        try {
            return getPathFromUrl(getURLFromRelativePath(path));
        }catch(MalformedURLException | UnsupportedEncodingException e){
            e.printStackTrace();
            return null;
        }
    }

    public final InputStream getResourceAsStream(String path) {
        return getClass().getClassLoader().getResourceAsStream(path);
    }

    public final URL getResource(String path) {
        return getClass().getClassLoader().getResource(path);
    }
}