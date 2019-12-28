package main;

import common.Coords;
import common.GameMap;
import players.factory.HeroFactory;
import players.types.Hero;
import specialcharacters.Observer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GameInputLoader {
    // used to parse input to the main program
    private String inputPath;

    private GameMap gameMap;
    private ArrayList<Hero> players;
    private HeroFactory heroFactory;

    private int roundsNumber;
    private ArrayList<String> commandsLines;
    private ArrayList<String> angelsLines;

    private Observer observer;

    // constructor
    GameInputLoader(final String inputPath, final Observer observer) {
        this.inputPath = inputPath;
        this.gameMap = GameMap.getInstance();
        this.players = new ArrayList<>();
        this.heroFactory = HeroFactory.getInstance();
        this.commandsLines = new ArrayList<>();
        this.angelsLines = new ArrayList<>();

        this.observer = observer;
    }

    final void readData() {
        try {
            // read input using a buffered reader
            FileReader fr = new FileReader(this.inputPath);
            BufferedReader bfr = new BufferedReader(fr);

            // read dimensions of game map
            String line = bfr.readLine();
            String[] dimensions = line.split("\\s");
            int lines = Integer.parseInt(dimensions[0]);

            // read the matrix lines and build game map
            for (int i = 0; i < lines; i++) {
                line = bfr.readLine();
                char[] fields = line.toCharArray();
                gameMap.buildLine(fields);
            }

            // read heroes number
            line = bfr.readLine();
            int playersNumber = Integer.parseInt(line);

            // read every player stats (type and initial position
            for (int i = 0; i < playersNumber; i++) {
                line = bfr.readLine();
                String[] playerData = line.split("\\s");

                // use hero factory to create a player
                Hero player = heroFactory.createHero(playerData[0].charAt(0), this.observer);
                player.setCoords(new Coords(Integer.parseInt(playerData[1]),
                        Integer.parseInt(playerData[2])));
                player.setId(i);

                this.players.add(player);
            }

            // read number of rounds to play
            line = bfr.readLine();
            this.roundsNumber = Integer.parseInt(line);
            for (int i = 0; i < roundsNumber; i++) {
                line = bfr.readLine();
                commandsLines.add(line);
            }
            for (int i = 0; i < roundsNumber; i++) {
                line = bfr.readLine();
                angelsLines.add(line);
            }

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

    final ArrayList<String> getCommandsLines() {
        return this.commandsLines;
    }

    final ArrayList<String> getAngelsLines() {
        return this.angelsLines;
    }
}
