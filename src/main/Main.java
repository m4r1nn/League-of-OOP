package main;

import players.types.Hero;

import java.io.BufferedReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0]);
        gameInputLoader.readData();
        ArrayList<Hero> players = gameInputLoader.getPlayers();
        int roundsNumber = gameInputLoader.getRoundsNumber();
        BufferedReader bfr = gameInputLoader.getBfr();
        GameLogic gameLogic = new GameLogic(args[0], args[1], players, roundsNumber, bfr);
        gameLogic.runRounds();
    }
}
