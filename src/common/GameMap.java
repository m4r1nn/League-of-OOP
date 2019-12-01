package common;

import players.types.Hero;

import java.util.ArrayList;

public final class GameMap {
    // matrix of fields
    private ArrayList<ArrayList<Fields>> table;
    private static GameMap instance = null;

    private GameMap() {
        this.table = new ArrayList<>();
    }

    // singleton pattern for GameMap, there's no need of more instances
    public static GameMap getInstance() {
        if (instance == null) {
            instance = new GameMap();
        }
        return instance;
    }

    // fills a line in matrix with fields based on a char input
    public void buildLine(final char[] fields) {
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

        // put the line in table
        this.table.add(line);
    }

    // returns hero's land type
    public Fields getField(final Hero hero) {
        Coords coords = hero.getCoords();
        return this.table.get(coords.getLin()).get(coords.getCol());
    }

    @Override
    // used for debugging
    public String toString() {
        StringBuilder res = new StringBuilder();

        for (ArrayList<Fields> line : this.table) {
            res.append(line.toString()).append('\n');
        }
        return res.toString();
    }
}
