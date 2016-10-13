import processing.core.PApplet;

public class ProcLevels extends PApplet {
    public void settings() {
        size(1024, 768);
    }

    public void setup() {
        background(1.0f, 1.0f, 1.0f);
    }

    public void draw() {
        background(200.0f, 200.0f, 200.0f);
    }

    static public void main(String[] args) {
        PApplet.main(ProcLevels.class.getName());
    }
}
