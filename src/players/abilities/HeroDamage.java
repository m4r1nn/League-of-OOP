package players.abilities;

import common.GameMap;
import players.types.Hero;

public abstract class HeroDamage implements IHeroDamage {
    protected Hero hero;
    protected GameMap gameMap;
    public HeroDamage(Hero hero) {
        this.hero = hero;
        this.gameMap = GameMap.getInstance();
    }
    public abstract void setDamageWithoutRaceModif(Hero hero);
    public int getHeroLevel() {
        return this.hero.getLevel();
    }
}
