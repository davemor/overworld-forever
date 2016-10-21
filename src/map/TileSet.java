package map;

import java.util.ArrayList;
import java.util.List;

// A Tileset maps an index in a map layer to a some metadata.
// The metadata describes if the tile is walkable and a name
// that can be used to get the graphic to render it.
public class TileSet {
    public class Tile {
        public boolean isWalkable;
    }
    public String name;
    public List<Tile> tiles = new ArrayList<>();
}
