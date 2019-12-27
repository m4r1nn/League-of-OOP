package players.abilities;

import common.GameMap;
import players.types.Hero;

public abstract class HeroDamage implements IHeroDamage {
    private Hero hero;
    private GameMap gameMap;

    // race modifiers
    private float pyromancerModif;
    private float knightModif;
    private float wizardModif;
    private float rogueModif;

    // constructor
    public HeroDamage(final Hero hero) {
        this.hero = hero;
        this.gameMap = GameMap.getInstance();
    }

    // getters and setters
    public final float getPyromancerModif() {
        return pyromancerModif;
    }

    public final void setPyromancerModif(final float pyromancerModif) {
        this.pyromancerModif = pyromancerModif;
    }

    public final float getKnightModif() {
        return knightModif;
    }

    public final void setKnightModif(final float knightModif) {
        this.knightModif = knightModif;
    }

    public final float getWizardModif() {
        return wizardModif;
    }

    public final void setWizardModif(final float wizardModif) {
        this.wizardModif = wizardModif;
    }

    public final float getRogueModif() {
        return rogueModif;
    }

    public final void setRogueModif(final float rogueModif) {
        this.rogueModif = rogueModif;
    }

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
