package players.abilities;

import common.GameMap;
import players.types.Hero;

public abstract class HeroDamage implements IHeroDamage {
    private Hero hero;
    private GameMap gameMap;

    // constructor
    public HeroDamage(final Hero hero) {
        this.hero = hero;
        this.gameMap = GameMap.getInstance();
    }

    // getters and setters
    public final Hero getHero() {
        return hero;
    }

    public final void setHero(final Hero hero) {
        this.hero = hero;
    }

    public final GameMap getGameMap() {
        return gameMap;
    }

    // method used for wizard's deflect ability
    public abstract void setDamageWithoutRaceModif(Hero heRo);

    public final int getHeroLevel() {
        return this.hero.getLevel();
    }
}
