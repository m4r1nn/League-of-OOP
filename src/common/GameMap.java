package common;

import main.GameLogic;
import players.types.Hero;

import java.io.File;
import java.util.ArrayList;

public class GameMap {
    private ArrayList<ArrayList<Fields>> table;
    private int currentLine;
    private static GameMap instance = null;
    private GameMap() {
        this.table = new ArrayList<>();
    }
    public static GameMap getInstance() {
        if (instance == null) {
            instance = new GameMap();
        }
        return instance;
    }
    public void buildLine(char[] fields) {
        ArrayList<Fields> line = new ArrayList<>();
        for (char c : fields) {
            switch (c) {
                case 'L':
                    line.add(Fields.LAND);
                    break;
                case 'V':
                    line.add(Fields.VOLCANIC);
                    break;
                case 'D':
                    line.add(Fields.DESERT);
                    break;
                case 'W':
                    line.add(Fields.WOODS);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        this.table.add(line);
    }
    public Fields getField(Hero hero) {
        Coords coords = hero.getCoords();
        return this.table.get(coords.getX()).get(coords.getY());
    }
    @Override
    public String toString() {
        String res = "";
        for (ArrayList<Fields> line : this.table) {
            res += line.toString() + '\n';
        }
        return res;
    }
}
