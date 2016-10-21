package display;

import processing.core.PApplet;
import processing.core.PImage;

public class Image extends DisplayObject {

    private PImage img;

    public Image(PImage img) {
        this.img = img;
        this.width = img.width;
        this.height = img.height;

        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
    }

    @Override
    public void render(PApplet app) {
        app.pushMatrix();
        // TODO: in order to rotate around the centre of the image
        app.translate(x, y);
        app.rotate(rotation);
        app.scale(scaleX, scaleY);
        app.image(img, 0.0f, 0.0f);
        app.popMatrix();
    }
}
