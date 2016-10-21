package display;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

public class Character extends DisplayObject {

    PImage [] up = new PImage[2];
    PImage [] down = new PImage[2];
    PImage [] left = new PImage[2];
    PImage [] right = new PImage[2];

    PImage [] facing;
    float frame = 0.0f;
    boolean isAnimating = false;

    public Character(PImage [] up, PImage [] down, PImage [] left, PImage [] right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.facing = up;
    }

    float SPEED = 0.4f;

    public void moveUp() {
        this.y -= SPEED;
        this.facing = up;
        isAnimating = true;
    }

    public void moveDown() {
        this.y += SPEED;
        this.facing = down;
        isAnimating = true;
    }

    public void moveLeft() {
        this.x -= SPEED;
        this.facing = left;
        isAnimating = true;
    }

    public void moveRight() {
        this.x += SPEED;
        this.facing = right;
        isAnimating = true;
    }

    public void stop() {
        this.isAnimating = false;
    }

    @Override
    public void render(PApplet app) {
        if (isAnimating) {
            frame += 0.06;
            frame %= 2;
        }

        app.pushMatrix();
        app.translate(x, y);
        app.rotate(rotation);
        app.scale(scaleX, scaleY);

        int f = (int) frame;
        app.image(facing[f], 0.0f, 0.0f);

        app.popMatrix();
    }
}
