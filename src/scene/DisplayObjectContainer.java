package scene;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidmorrison on 13/10/2016.
 */
public abstract class DisplayObjectContainer extends DisplayObject{

    private List<DisplayObject> children = new ArrayList<DisplayObject>();

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
