package main;

import players.types.Hero;
import specialcharacters.BigBoss;
import specialcharacters.Observer;

import java.util.ArrayList;

public final class Main {
    private Main() { }
    public static void main(final String[] args) {
        // main observer in this game
        Observer bigBoss = new BigBoss();

        // read and parse input
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], bigBoss);
        gameInputLoader.readData();

        ArrayList<Hero> players = gameInputLoader.getPlayers();
        int roundsNumber = gameInputLoader.getRoundsNumber();
        ArrayList<String> commandLines = gameInputLoader.getCommandsLines();
        ArrayList<String> angelsLines = gameInputLoader.getAngelsLines();

        // play the game
        GameLogic gameLogic = new GameLogic(args[1], players, roundsNumber, commandLines,
                angelsLines, bigBoss);
        gameLogic.runRounds();
    }
}
