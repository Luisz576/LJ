package com.luisz.lj.utils.file;

import java.io.*;
import java.net.URL;
import java.util.function.Function;

public class FileManipulator {
    public final void readFile(URL urlFile, Function<String, Boolean> reader) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(urlFile.openStream()));;
            boolean continueReading = true;
            String line;
            while ((line = br.readLine()) != null) {
                if (continueReading)
                    continueReading = reader.apply(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String getAllContentFile(URL urlFile) {
        StringBuilder fileContent = new StringBuilder();
        boolean[] isFirst = { true };
        readFile(urlFile, line -> {
            if (!isFirst[0]) {
                fileContent.append("\n");
            } else {
                isFirst[0] = false;
            }
            fileContent.append(line);
            return Boolean.TRUE;
        });
        return fileContent.toString();
    }

    public final boolean createFile(String path) {
        try {
            File file = new File(path);
            return file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean createFileIfNotExists(String path) {
        try {
            File file = new File(path);
            if (!file.exists())
                return file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public final boolean writeFile(String path, String value) {
        try {
            File file = new File(path);
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write(value);
            output.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean writeFileIfFileNotExists(String path, String value) {
        try {
            if (createFileIfNotExists(path)) {
                File file = new File(path);
                BufferedWriter output = new BufferedWriter(new FileWriter(file));
                output.write(value);
                output.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean writeFileAndCreateIfNotExists(String path, String value) {
        try {
            File file = new File(path);
            if(!file.exists()){
                if(!file.createNewFile()){
                    return false;
                }
            }
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write(value);
            output.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createDirectory(String path) {
        if (path.endsWith("/"))
            path = path.substring(0, path.length());
        String[] dirs = path.split("/");
        StringBuilder currentDir = new StringBuilder();
        boolean lastWasCreated = false;
        int index = 0;
        for (String dir : dirs) {
            if (index <= 0) {
                currentDir.append(dirs[index]);
            } else {
                currentDir.append("/").append(dirs[index]);
            }
            File directory = new File(currentDir.toString());
            if (!directory.exists())
                lastWasCreated = directory.mkdir();
            index++;
        }
        return lastWasCreated;
    }

    public boolean directoryOrFileExists(String path) {
        File directoryOrFile = new File(path);
        return directoryOrFile.exists();
    }
}