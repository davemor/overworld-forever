package display;

import processing.core.PApplet;

public abstract class DisplayObject {
    public String name = ""; // empty by default
    public float x, y;
    public float width, height;
    public float scaleX = 1.0f, scaleY = 1.0f;
    public float rotation;

    public abstract void render(PApplet app);
}
