package main;

import common.Coords;
import common.GameMap;
import players.factory.HeroTypes;
import players.types.Hero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
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
            if (hero.getHP() <= 0) {
                i++;
                continue;
            }
            if (hero.stunned == true) {
                hero.roundsOfStun--;
                if (hero.roundsOfStun == 0) {
                    hero.stunned = false;
                }
                i++;
                continue;
            }
            Coords coords = hero.getCoords();
            int lin = coords.getLin();
            int col = coords.getCol();
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
            hero.setCoords(new Coords(lin, col));
            i++;
        }
    }
    public void applyOvertimeDamage() {
        for (Hero hero : players) {
            if (hero.roundsOfDamageOverTime > 0) {
                hero.setHP(hero.getHP() - hero.damageOverTime);
                hero.roundsOfDamageOverTime--;
            }
        }
    }
    public void fight(Hero hero1, Hero hero2)  {
        if (hero1.type == HeroTypes.WIZARD && hero2.type != HeroTypes.WIZARD) {
            this.fight(hero2, hero1);
            return;
        }
        hero2.takeDamage(hero1.ability1, hero1.ability2);
        hero1.takeDamage(hero2.ability1, hero2.ability2);
        if (hero1.getHP() > 0 && hero2.getHP() <= 0) {
            hero1.growXP(hero2.getLevel());
        } else if (hero1.getHP() <= 0 && hero2.getHP() > 0) {
            hero2.growXP(hero1.getLevel());
        }
    }
    public void letHeroesFight() {
        for (int i = 0; i < players.size() - 1; i++) {
            Hero hero1 = players.get(i);
            for (int j = i + 1; j < players.size(); j++) {
                Hero hero2 = players.get(j);
                if (hero1.getHP() > 0 && hero2.getHP() > 0 && hero1.getCoords().equals(hero2.getCoords())) {
                    this.fight(hero1, hero2);
                }
            }
        }
    }
    public void displayHeroes() {
        try {
            FileWriter fw = new FileWriter(this.outputPath);
            BufferedWriter bfw = new BufferedWriter(fw);
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
    public void runRounds() {
        try {
            String line;
//            for (Hero hero : players) {
//                System.out.println(hero.toString());
//            }
            for (int i = 0; i < this.roundsNumber; i++) {
//                System.out.println("Round: " + i);
                line = bfr.readLine();
                char[] directions = line.toCharArray();
                this.movePlayers(directions);
                this.applyOvertimeDamage();
                this.letHeroesFight();
//                for (Hero hero : players) {
//                    System.out.println(hero.toString());
//                }
//                System.out.println("-----------END ROUND--------");
            }
            this.displayHeroes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
