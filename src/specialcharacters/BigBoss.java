package specialcharacters;

import angels.types.Angel;
import players.types.Hero;

public class BigBoss implements Observer {
    private Hero hero1;
    private Hero hero2;
    private Angel angel;

    @Override
    public final void update(final Hero heroo1, final Hero heroo2, final Angel angell,
                             final String messageType) {
        this.hero1 = heroo1;
        this.hero2 = heroo2;
        this.angel = angell;

        switch (messageType) {
            case "HeroesFight":
                this.displayHeroesFight();
                break;
            case "AngelSpawn":
                this.displayAngelSpawn();
                break;
            case "AngelHelp":
                this.displayAngelHelp();
                break;
            case "AngelHit":
                this.displayAngelHit();
                break;
            case "HeroKilled":
                this.displayHeroKilled();
                break;
            case "HeroSpawned":
                this.displayHeroSpawned();
                break;
            case "HeroLevelUp":
                this.displayHeroLevelUp();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final void displayHeroesFight() {
        System.out.println("Player " + hero1.getStringType() + " " + hero1.getId()
                + " was killed by " + hero2.getStringType() + " " + hero2.getId());
    }

    public final void displayAngelSpawn() {
        System.out.println("Angel " + angel.getStringType() + " was spawned at "
                + angel.getCoords().getLin() + " " + angel.getCoords().getCol());
    }

    public final void displayAngelHelp() {
        System.out.println(angel.getStringType() + " helped " + hero1.getStringType()
                + " " + hero1.getId());
    }

    public final void displayAngelHit() {
        System.out.println(angel.getStringType() + " hit " + hero1.getStringType()
                + " " + hero1.getId());
    }

    public final void displayHeroKilled() {
        System.out.println("Player " + hero1.getStringType() + " " + hero1.getId()
                + " was killed by an angel");
    }

    public final void displayHeroSpawned() {
        System.out.println("Player " + hero1.getStringType() + " " + hero1.getId()
                + " was brought to life by an angel");
    }

    public final void displayHeroLevelUp() {
        System.out.println(hero1.getStringType() + " " + hero1.getId()
                + " reached level " + hero1.getLevel());
    }
}
