package main;

import common.Coords;
import common.GameMap;
import players.factory.HeroTypes;
import players.types.Hero;

import java.io.BufferedReader;
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
        } else if (hero1.getHP() <= 0 && hero1.getHP() > 0) {
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
        for (Hero hero : players) {
            char typeChar;
            switch (hero.type) {
                case PYROMANCER:
                    typeChar = 'P';
                    break;
                case KNIGHT:
                    typeChar = 'K';
                    break;
                case WIZARD:
                    typeChar = 'W';
                    break;
                case ROGUE:
                    typeChar = 'R';
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            if (hero.getHP() <= 0) {
                System.out.println(typeChar + " dead");
                continue;
            }
            System.out.println(typeChar + " " + hero.getLevel() + " " + hero.getXP() + " " + hero.getHP() + " "
                    + hero.getCoords().getX() + " " + hero.getCoords().getY());
        }
    }
    public void runRounds() {
        try {
            String line;
            for (int i = 0; i < this.roundsNumber; i++) {
                line = bfr.readLine();
                char[] directions = line.toCharArray();
                this.movePlayers(directions);
                this.applyOvertimeDamage();
                this.letHeroesFight();
            }
            this.displayHeroes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
