package map;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidmorrison on 13/10/2016.
 */
public class TileSet {
    class Tile {
        String name;
        boolean isWalkable;

        public String getName() {
            return name;
        }

        public boolean isWalkable() {
            return isWalkable;
        }
    }

    List<Tile> tiles = new ArrayList<Tile>();

    public String getName(int index) { return tiles.get(index).getName(); }
    public boolean isWalkable(int index) { return tiles.get(index).isWalkable(); }
}
