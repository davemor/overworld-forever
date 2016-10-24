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
    public int get(int x, int y) {
        if (inBounds(x, y)) {
            return cells[x][y];
        } else {
            return NO_VALUE;
        }
    }
    public void set(int x, int y, int value) { if (inBounds(x, y)) cells[x][y] = value; }

    public int size() { return width * height; }
    public int get(int idx) {
        int x = idx % width;
        int y = idx / width;
        return get(x, y);
    }
    public void set(int idx, int value) {
        int x = idx % width;
        int y = idx / width;
        set(x, y, value);
    }

    private boolean inBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}