package main;

import players.types.Hero;

import java.util.ArrayList;

public final class Main {
    private Main() { }
    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0]);
        gameInputLoader.readData();
        ArrayList<Hero> players = gameInputLoader.getPlayers();
        int roundsNumber = gameInputLoader.getRoundsNumber();
        ArrayList<String> commandLines = gameInputLoader.getCommandsLines();
        ArrayList<String> angelsLines = gameInputLoader.getAngelsLines();
        GameLogic gameLogic = new GameLogic(args[1], players, roundsNumber, commandLines,
                angelsLines);
        gameLogic.runRounds();
    }
}
