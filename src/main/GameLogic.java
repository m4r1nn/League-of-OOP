package main;

import common.Coords;
import common.GameMap;
import players.types.Hero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GameLogic {
    private String inputPath;
    private String outputPath;
    private ArrayList<Hero> players;
    private int roundsNumber;
    private GameMap gameMap;
    private BufferedReader bfr;
    public GameLogic(String inputPath, String outputPath, ArrayList<Hero> players, int roundsNumber, BufferedReader bfr) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.players = players;
        this.roundsNumber = roundsNumber;
        this.gameMap = GameMap.getInstance();
        this.bfr = bfr;
    }
    public void movePlayers(char[] directions) {
        int i = 0;
        for (Hero hero : this.players) {
            Coords coords = hero.getCoords();
            int x = coords.getX();
            int y = coords.getY();
            switch (directions[i]) {
                case 'U':
                    y--;
                    break;
                case 'D':
                    y++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                case '_':
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            hero.setCoords(new Coords(x, y));
            i++;
        }
    }
    public void runRounds() {
        try {
            String line;
            for (int i = 0; i < this.roundsNumber; i++) {
                line = bfr.readLine();
                char[] directions = line.toCharArray();
                this.movePlayers(directions);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
