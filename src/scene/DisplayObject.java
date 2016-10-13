package scene;

import processing.core.PApplet;

/**
 * Created by davidmorrison on 13/10/2016.
 */
public abstract class DisplayObject {
    public String name;
    public float x, y;
    public float width, height;
    public float scaleX, scaleY;
    public float rotation;

    public abstract void render(PApplet app);
}
