import display.DisplayObjectContainer;
import map.Layer;
import map.Map;
import processing.core.PApplet;
import processing.core.PImage;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcLevels extends PApplet {

    display.DisplayObjectContainer scene = new DisplayObjectContainer();

    public void settings() {
        size(1024, 768);
    }

    public void setup() {
        background(1.0f, 1.0f, 1.0f);

        // load an image
        // display.Image linkDown1 = new display.Image(loadImage("link_down1.png"));
        // scene.add(linkDown1);

        map.Map zeldaMap = loadZeldaMap();
        List<PImage> zeldaTiles = loadZeldaTiles();
        display.MapDisplayObject mapObj = new display.MapDisplayObject(zeldaMap, zeldaTiles, 16, 16);
        scene.add(mapObj);
    }

    public void draw() {
        background(200.0f, 200.0f, 200.0f);
        scene.render(this);
    }

    static public void main(String[] args) {
        PApplet.main(ProcLevels.class.getName());
    }

    private map.Map loadZeldaMap() {
        // load in the world layer
        map.Layer layer = new Layer(256, 88);
        BufferedReader reader = createReader("nes_zelda_overworld_tile_map.txt");
        try {
            int y = 0;
            String strLine;
            while ( (strLine = reader.readLine ())!= null) {
                String [] tiles = strLine.split(" ");
                for (int x=0; x < tiles.length; ++x) {
                    int index = Integer.decode("0x" + tiles[x]);
                    layer.set(x, y, index);
                }
                ++y;
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }

        // make a map and return it
        map.Map rtn = new Map();
        rtn.layers.add(layer);
        return rtn;
    }

    private List<PImage> loadZeldaTiles() {
        final int TILE_HEIGHT = 16;
        final int TILE_WIDTH = 16;
        final int TILE_BORDER = 1;
        PImage tilesImg = loadImage("overworldtiles.png");
        int widthInTiles = 20; // padded
        int heightInTiles = tilesImg.height / TILE_HEIGHT;
        PImage [] tiles = new PImage[widthInTiles * heightInTiles];
        for (int x = 0; x < widthInTiles; ++x) {
            for (int y = 0; y < heightInTiles; ++ y) {
                tiles[y * widthInTiles + x] = tilesImg.get(
                        x * (TILE_WIDTH + TILE_BORDER) + TILE_BORDER,
                        y * (TILE_HEIGHT + TILE_BORDER) + TILE_BORDER,
                        TILE_WIDTH, TILE_HEIGHT);
            }
        }
        println("Tiles count: " + tiles.length);
        return Arrays.asList(tiles);
    }
}
