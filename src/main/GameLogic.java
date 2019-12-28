package main;

import angels.factory.AngelFactory;
import angels.types.Angel;
import common.Coords;
import players.factory.HeroTypes;
import players.types.Hero;
import specialcharacters.Observer;
import specialcharacters.Subject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

class GameLogic extends Subject {
    // contains main implementation of the game
    private String outputPath;
    private ArrayList<Hero> players;
    private int roundsNumber;
    private ArrayList<String> commandLines;
    private ArrayList<String> angelsLines;
    private AngelFactory angelFactory;
    private Observer observer;

    // constructor
    GameLogic(final String outputPath, final ArrayList<Hero> players, final int roundsNumber,
              final ArrayList<String> commandLines, final ArrayList<String> angelsLines,
              final Observer observer) {
        this.outputPath = outputPath;
        this.players = players;
        this.roundsNumber = roundsNumber;
        this.commandLines = commandLines;
        this.angelsLines = angelsLines;
        this.angelFactory = AngelFactory.getInstance();
        this.observer = observer;
        this.addObserver(this.observer);
    }

    // takes char array as parameter and moves all players
    private void movePlayers(final char[] directions) {
        int i = 0;

        // iterate through heroes list
        for (Hero hero : this.players) {

            // check if hero is alive
            if (hero.getHP() <= 0) {
                i++;
                continue;
            }

            // check if hero can move (it's not stunned)
            if (hero.isStunned()) {
                // decrease remaining rounds of stun
                hero.setRoundsOfStun(hero.getRoundsOfStun() - 1);
                if (hero.getRoundsOfStun() == 0) {
                    hero.setStunned(false);
                }
                i++;
                continue;
            }

            // get old hero coords to modify
            Coords coords = hero.getCoords();
            int lin = coords.getLin();
            int col = coords.getCol();

            // move hero 0 or 1 cell in a specified direction
            switch (directions[i]) {
                case 'U':
                    lin--;
                    break;
                case 'D':
                    lin++;
                    break;
                case 'L':
                    col--;
                    break;
                case 'R':
                    col++;
                    break;
                case '_':
                    break;
                default:
                    throw new IllegalArgumentException();
            }

            // replace old coords with the new ones
            hero.setCoords(new Coords(lin, col));
            i++;
        }
    }

    // apply passive effects on affected heroes
    private void applyOvertimeDamage() {
        for (Hero hero : this.players) {
            if (hero.getRoundsOfDamageOverTime() > 0) {
                hero.setHP(hero.getHP() - hero.getDamageOverTime());

                // decrease remaining rounds of overtime damage
                hero.setRoundsOfDamageOverTime(hero.getRoundsOfDamageOverTime() - 1);
            }
        }
    }

    private void changePlayersStrategies() {
        for (Hero hero : this.players) {
            if (!hero.isStunned()) {
                hero.changeStrategy();
            }
        }
    }

    // takes 2 heroes as parameters and let them fight
    private void fight(final Hero hero1, final Hero hero2)  {

        // wizard must attack always second because of deflect ability
        if (hero1.getType() == HeroTypes.WIZARD && hero2.getType() != HeroTypes.WIZARD) {
            this.fight(hero2, hero1);
            return;
        }

        // calculate and apply the damage for both heroes using visitor pattern
        hero2.takeDamage(hero1.getAbility1(), hero1.getAbility2());
        hero1.takeDamage(hero2.getAbility1(), hero2.getAbility2());

        // check if a hero has won the battle (he is alive and the other isn't)
        if (hero1.getHP() > 0 && hero2.getHP() <= 0) {
            this.notifyObservers(hero2, hero1, null, "HeroesFight");
            hero1.growXP(hero2.getLevel());
        } else if (hero1.getHP() <= 0 && hero2.getHP() > 0) {
            hero2.growXP(hero1.getLevel());
        }
    }

    // realise the fight part of the round
    private void letHeroesFight() {
        for (int i = 0; i < players.size() - 1; i++) {

            // iterate through heroes list
            Hero hero1 = players.get(i);
            for (int j = i + 1; j < players.size(); j++) {
                Hero hero2 = players.get(j);

                // check if 2 alive heroes are in the same cell to fight
                if (hero1.getHP() > 0 && hero2.getHP() > 0
                        && hero1.getCoords().equals(hero2.getCoords())) {
                    this.fight(hero1, hero2);
                }
            }
        }
    }

    private void letAngelsCome(final int round) {
        String[] args = angelsLines.get(round).split("\\s");
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            String[] items = args[i + 1].split(",");
            int lin = Integer.parseInt(items[1]);
            int col = Integer.parseInt(items[2]);
            Angel angel = angelFactory.createAngel(items[0], new Coords(lin, col), observer);
            for (Hero hero : this.players) {
                if (hero.getCoords().equals(angel.getCoords())) {
                    hero.acceptAngel(angel);
                }
            }
        }
    }

    // display the leader board
    private void displayHeroes() {
        try {
            // use buffered writer to parse output
            FileWriter fw = new FileWriter(this.outputPath);
            BufferedWriter bfw = new BufferedWriter(fw);

            System.out.println("~~ Results ~~");

            // iterate and print heroes final stats
            for (Hero hero : players) {
                System.out.println(hero.toString());
                bfw.write(hero.toString() + "\n");
            }

            bfw.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // main function of game logic
    final void runRounds() {
        String line;
        String res;

        // go through rounds and do the interactions between heroes
        for (int i = 0; i < this.roundsNumber; i++) {
            System.out.println("~~ Round " + (i + 1) + " ~~");
            line = commandLines.get(i);
            char[] directions = line.toCharArray();
            this.applyOvertimeDamage();
            this.changePlayersStrategies();
            this.movePlayers(directions);
            this.letHeroesFight();
            this.letAngelsCome(i);
            System.out.println();
        }

        // print heroes
        this.displayHeroes();
    }
}
