package display;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class DisplayObjectContainer extends DisplayObject{

    private List<DisplayObject> children = new ArrayList<>();

    public void add(DisplayObject child) {
        children.add(child);
    }

    public void remove(DisplayObject child) {
        children.remove(child);
    }

    @Override
    public void render(PApplet app) {
        app.pushMatrix();
        app.translate(x, y);
        app.rotate(rotation);
        app.scale(scaleX, scaleY);
        for (DisplayObject child : children) {
            child.render(app);
        }
        app.popMatrix();
    }
}
