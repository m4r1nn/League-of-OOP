package common;

import java.util.ArrayList;

public class Map {
    private int lines;
    private int columns;
    private ArrayList<ArrayList<Fields>> table;
    public Map(int lines, int columns) {
        this.lines = lines;
        this.columns = columns;
        table = new ArrayList<>(lines);
        for (ArrayList<Fields> col : table) {
            col = new ArrayList<>(columns);
        }
    }
}
