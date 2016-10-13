package map;

public class Layer {
    public static final int NO_VALUE = -1;

    int[][] cells = null;
    int width = 0;
    int height = 0;

    public Layer(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new int[width][height];
    }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int get(int x, int y) { return cells[x][y]; }
    public void set(int x, int y, int value) { cells[x][y] = value; }
}