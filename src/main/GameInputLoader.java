package main;

import common.Coords;
import common.GameMap;
import players.factory.HeroFactory;
import players.types.Hero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GameInputLoader {
    // used to parse input to the main program
    private String inputPath;

    private GameMap gameMap;
    private ArrayList<Hero> players;
    private HeroFactory factory;

    private int roundsNumber;
    private BufferedReader bfr;

    // constructor
    GameInputLoader(final String inputPath) {
        this.inputPath = inputPath;
        this.gameMap = GameMap.getInstance();
        this.players = new ArrayList<>();
        this.factory = HeroFactory.getInstance();
    }

    final void readData() {
        try {
            // read input using a buffered reader
            FileReader fr = new FileReader(this.inputPath);
            this.bfr = new BufferedReader(fr);

            // read dimensions of game map
            String line = this.bfr.readLine();
            String[] dimensions = line.split("\\s");
            int lines = Integer.parseInt(dimensions[0]);

            // read the matrix lines and build game map
            for (int i = 0; i < lines; i++) {
                line = this.bfr.readLine();
                char[] fields = line.toCharArray();
                gameMap.buildLine(fields);
            }

            // read heroes number
            line = this.bfr.readLine();
            int playersNumber = Integer.parseInt(line);

            // read every player stats (type and initial position
            for (int i = 0; i < playersNumber; i++) {
                line = this.bfr.readLine();
                String[] playerData = line.split("\\s");

                // use hero factory to create a player
                Hero player = factory.createHero(playerData[0].charAt(0));
                player.setCoords(new Coords(Integer.parseInt(playerData[1]),
                        Integer.parseInt(playerData[2])));

                this.players.add(player);
            }

            // read number of rounds to play
            line = this.bfr.readLine();
            this.roundsNumber = Integer.parseInt(line);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // getters
    final int getRoundsNumber() {
        return this.roundsNumber;
    }

    public final ArrayList<Hero> getPlayers() {
        return this.players;
    }

    final BufferedReader getBfr() {
        return this.bfr;
    }
}
