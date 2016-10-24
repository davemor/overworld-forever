package generate;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;

public class FrequencyTable {
    ArrayList<Integer> arr = new ArrayList<Integer>();

    void incromentCount(Integer tileIdx) {
        arr.add(tileIdx);
    }
    int sample() {
        int index = (int)(Math.random() * arr.size());
        return arr.get(index);
    }

    public static FrequencyTable countTileFrequencies(map.Layer layer) {
        FrequencyTable table = new FrequencyTable();
        for(int idx=0; idx < layer.size(); ++idx) {
            table.incromentCount( layer.get(idx) );
        }
        return table;
    }

    public static map.Layer makeLayerFromFrequencyTable(FrequencyTable table, int w, int h) {
        map.Layer layer = new map.Layer(w, h);
        for(int idx=0; idx < layer.size(); ++idx) {
            int value = table.sample();
            layer.set(idx, value);
        }
        return layer;
    }

    public static HashMap<String, FrequencyTable> makeFrequencyTablesForNLengthPredecessors(map.Layer map, int n) {
        HashMap<String, FrequencyTable> table = new HashMap<String, FrequencyTable>();
        for (int idx=0; idx < map.size(); ++idx) {
            ArrayList<Integer> predecessors = new ArrayList<Integer>();
            for(int p=0; p < n; ++p) {
                int backIdx = idx - (p + 1);
                predecessors.add(map.get(backIdx));
            }
            int curr = map.get(idx);
            String keyStr = listToString(predecessors);
            if (table.containsKey(keyStr)) {
                table.get(keyStr).incromentCount(curr);
            } else {
                FrequencyTable ft = new FrequencyTable();
                ft.incromentCount(curr);
                table.put(keyStr, ft);
            }
        }
        return table;
    }

    private static String listToString(ArrayList<Integer> list) {
        String str = "";
        for (Integer i : list) {
            str = str + i + " ";
        }
        return str;
    }

    public static map.Layer makeMapFromNLengthPredecessorsTables(HashMap<String, FrequencyTable> tables, int w, int h, int n) {
        map.Layer map = new map.Layer(w, h);
        for (int idx=0; idx < map.size(); ++idx) {
            ArrayList<Integer> predecessors = new ArrayList<Integer>();
            for(int p=0; p < n; ++p) {
                int backIdx = idx - (p + 1);
                predecessors.add(map.get(backIdx));
            }
            String keyStr = listToString(predecessors);
            int next = -1;
            if (tables.containsKey(keyStr)) {
                next = tables.get(keyStr).sample();
            } else {
                // println("Could not match predecessor pattern: " + keyStr);
            }
            map.set(idx, next);
        }
        return map;
    }
}