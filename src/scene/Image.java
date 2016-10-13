package scene;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by davidmorrison on 13/10/2016.
 */
public class Image extends DisplayObject {

    private PImage img;

    public Image(PImage img) {
        this.img = img;
        this.width = img.width;
        this.height = img.height;
    }

    @Override
    public void render(PApplet app) {
        /*
        public float x, y;
        public float width, height;
        public float scaleX, scaleY;
        public float rotation;
        */
        app.pushMatrix();
        // TODO: in order to rotate around the centre of the image
        app.translate(x, y);
        app.rotate(rotation);
        app.scale(scaleX, scaleY);
        app.popMatrix();
    }
}
