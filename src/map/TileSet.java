package map;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidmorrison on 13/10/2016.
 */
public class TileSet {
    public class Tile {
        public String name;
        public boolean isWalkable;
    }
    public String name;
    public List<Tile> tiles = new ArrayList<>();
}
