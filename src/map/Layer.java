package map;

import java.util.ArrayList;
import java.util.List;

public abstract class Layer {
    public static final int NO_VALUE = -1;

    abstract public int get(int index);
    abstract public int get(int x, int y);
    abstract public void set(int x, int y, int value);

    abstract public int count();

    public Layer makeSparseLayer() {
        return new SparseLayer();
    }
}

class SparseLayer extends Layer {

    private class Cell {
        int x, y, value;
        public Cell(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    private List<Cell> cells = new ArrayList<Cell>();

    @Override
    public int get(int index) {
        int rtn = NO_VALUE;
        if (index < cells.size()) {
            rtn = cells.get(index).value;
        }
        return rtn;
    }

    @Override
    public int get(int x, int y) {
        for (Cell cell : cells) {
            if (cell.x == x && cell.y == y) {
                return cell.value;
            }
        }
        return NO_VALUE;
    }

    @Override
    public void set(int x, int y, int index) {
        List<Cell> toRemove = new ArrayList<Cell>();
        for (Cell cell : cells) {
            if (cell.x == x && cell.y == y) {
                toRemove.add(cell);
            }
        }
        cells.removeAll(toRemove);
        cells.add(new Cell(x, y, index));
    }

    @Override
    public int count() {
        return cells.size();
    }
}