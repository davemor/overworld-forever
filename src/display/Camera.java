package display;

import processing.core.PApplet;

public class Camera {

    public static final float SCALE = 3.0f;

    static final int ROOM_WIDTH_IN_TILES = 16;
    static final int ROOM_HEIGHT_IN_TILES = 12;
    static final int TILE_WIDTH = 16;
    static final int TILE_HEIGHT = 16;

    public float x, y;
    PApplet app;

    public Camera(PApplet app) {
        this.app = app;
    }

    public void begin() {
        app.scale(SCALE);
        app.pushMatrix();
        app.translate(-x, -y);
    }

    public void end() {
        app.popMatrix();
    }

    public void setRoom(int x, int y) {
        this.x = x * ROOM_WIDTH_IN_TILES * TILE_WIDTH;
        this.y = y * ROOM_HEIGHT_IN_TILES * TILE_HEIGHT;
    }
}
