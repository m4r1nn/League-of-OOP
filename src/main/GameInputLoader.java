package main;

import common.Coords;
import common.GameMap;
import players.factory.HeroFactory;
import players.types.Hero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

public class GameInputLoader {
    private String inputPath;
    private GameMap gameMap;
    private ArrayList<Hero> players;
    private HeroFactory factory;
    private int roundsNumber;
    private BufferedReader bfr;
    public GameInputLoader(String inputPath) {
        this.inputPath = inputPath;
        this.gameMap = GameMap.getInstance();
        this.players = new ArrayList<>();
        this.factory = HeroFactory.getInstance();
    }
    public void readData() {
        try {
            FileReader fr = new FileReader(this.inputPath);
            this.bfr = new BufferedReader(fr);
            String line = this.bfr.readLine();
            String[] dimensions = line.split("\\s");
            int lines = Integer.parseInt(dimensions[0]);
            for (int i = 0; i < lines; i++) {
                line = this.bfr.readLine();
                char[] fields = line.toCharArray();
                gameMap.buildLine(fields);
            }
            line = this.bfr.readLine();
            int playersNumber = Integer.parseInt(line);
            for (int i = 0; i < playersNumber; i++) {
                line = this.bfr.readLine();
                String[] playerData = line.split("\\s");
                Hero player = factory.createHero(playerData[0].charAt(0));
                player.setCoords(new Coords(Integer.parseInt(playerData[1]), Integer.parseInt(playerData[2])));
                this.players.add(player);
            }
            line = this.bfr.readLine();
            this.roundsNumber = Integer.parseInt(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int getRoundsNumber() {
        return this.roundsNumber;
    }
    public ArrayList<Hero> getPlayers() {
        return this.players;
    }
    public BufferedReader getBfr() {
        return this.bfr;
    }
}
