package com.luisz.lj.game.tilemap.loader.scn;

import com.luisz.lj.game.tilemap.EditableTilemap;
import com.luisz.lj.game.tilemap.ITilemap;
import com.luisz.lj.game.tilemap.loader.ITilemapLoader;
import com.luisz.lj.game.tilemap.tile.Tile;
import com.luisz.lj.utils.file.source.SourceManipulator;
import com.luisz.lj.utils.math.tuple.Tuple;
import com.luisz.lj.utils.math.vector2d.Vector2D;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SCNTilemapLoader extends SourceManipulator implements ITilemapLoader {
    private URL url;

    public void setSource(URL url){
        this.url = url;
    }

    @Override
    public ITilemap load() {
        if(this.url == null){
            return null;
        }
        BufferedReader br = getBufferedReader(this.url);
        if (br != null) {
            try {
                int amountOfResources = -1;
                HashMap<Integer, Tuple<Integer, String>> resourcesList = new HashMap<>();
                int currentType = -1;
                Vector2D resolution = Vector2D.zero();
                boolean isLoadingResource = true, isLoadingResolution = true, isLoadingMap = true;
                List<String> map = new ArrayList<>();
                int lineIndex = 0;
                int resourceIndex = 0;
                boolean resolutionXLoaded = false;
                String line;
                while ((line = br.readLine()) != null) {
                    if (lineIndex == 0) {
                        amountOfResources = Integer.parseInt(line, 10);
                    } else if (isLoadingResource) {
                        if (currentType >= 0) {
                            resourcesList.put(resourceIndex, new Tuple<>(currentType, line));
                            currentType = -1;
                            resourceIndex++;
                            if (resourcesList.size() >= amountOfResources)
                                isLoadingResource = false;
                        } else {
                            currentType = Integer.parseInt(line, 10);
                        }
                    } else if (isLoadingResolution) {
                        if (!resolutionXLoaded && resolution.x <= 0) {
                            resolution.x = Integer.parseInt(line, 10);
                            resolutionXLoaded = true;
                        } else if (resolutionXLoaded && resolution.x > 0) {
                            resolution.y = Integer.parseInt(line, 10);
                            isLoadingResolution = false;
                        } else {
                            System.out.println("Can't load resolution");
                            return null;
                        }
                    } else if (isLoadingMap) {
                        if (line.contains("*")) {
                            isLoadingMap = false;
                        } else {
                            map.add(line);
                        }
                    }
                    lineIndex++;
                }
                if (amountOfResources > 0 && resourcesList.size() == amountOfResources && resolution.x > 0 && resolution.y > 0 && map.size() > 0) {
                    EditableTilemap tilemap = new EditableTilemap(resolution);
                    Map<Integer, BufferedImage> resourcesImages = new HashMap<>();
                    for (int i = 0; i < resourcesList.size(); i++) {
                        Tuple<Integer, String> resourceToLoad = resourcesList.get(i);
                        switch (resourceToLoad.a) {
                            case 0 -> resourcesImages.put(i, readURLBufferedImage(getResource(resourceToLoad.b)));
                            case 1 -> resourcesImages.put(i, readURLBufferedImage(tryGetURLFromRelativePath(resourceToLoad.b)));
                            case 2 -> resourcesImages.put(i, readURLBufferedImage(tryGetURLFromAbsolutePath(resourceToLoad.b)));
                            default -> {
                                System.out.println("Can't load resource " + i);
                                return null;
                            }
                        }
                    }
                    int mapLineIndex = 0, idCounter = 0;
                    for (String mapLineCompact : map) {
                        String[] mapLine = mapLineCompact.split(" ");
                        int mapTilePositionIndex = 0;
                        for (String tileResourceIdS : mapLine) {
                            int tileResourceId = Integer.parseInt(tileResourceIdS);
                            if (tileResourceId > amountOfResources || tileResourceId < -1) {
                                System.out.println("Can't get tile resource id at line " + mapLineIndex + ", tile position " + mapTilePositionIndex);
                                return null;
                            }
                            if (tileResourceId > -1) {
                                BufferedImage resourceImage = resourcesImages.get(tileResourceId);
                                if (resourceImage == null) {
                                    System.out.println("Couldn't load tile al line " + mapLineIndex + ", tile position " + mapTilePositionIndex);
                                    return null;
                                }
                                Tile tile = new Tile(idCounter, resolution.x * mapTilePositionIndex, resolution.y * mapLineIndex, resolution, resourceImage);
                                tilemap.addTile(tile);
                                idCounter++;
                            }
                            mapTilePositionIndex++;
                        }
                        mapLineIndex++;
                    }
                    return tilemap;
                }
                System.out.println("Incomplete file");
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error trying open file");
            }
        }
        return null;
    }
}