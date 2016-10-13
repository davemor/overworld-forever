package scene;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.List;
import java.util.Map;

/**
 * Created by davidmorrison on 13/10/2016.
 */
public class MapDisplayObject extends DisplayObjectContainer {

    map.Map aMap;
    List<PImage> images;
    int tileWidth;
    int tileHeight;

    public MapDisplayObject(map.Map map, List<PImage> images, int tileWidth, int tileHeight) {
        this.aMap = map;
        this.images = images;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
    }

    @Override
    public void render(PApplet app) {
        for (map.Layer layer : aMap.layers) {
            for (int x = 0; x < layer.getWidth(); ++x) {
                for (int y = 0; y < layer.getHeight(); ++y) {
                    int index = layer.get(x, y);
                    PImage img = images.get(index);
                    app.image(img, x * tileWidth, y * tileHeight);
                }
            }
        }
    }
}