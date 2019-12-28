package angels.types;

import angels.constants.LifeGiverConstants;
import angels.factory.AngelTypes;
import common.Coords;
import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;
import specialcharacters.Observer;

public class LifeGiver extends Angel {

    // constructor
    public LifeGiver(final Coords coords, final Observer observer) {
        super(coords);
        this.setType(AngelTypes.LIFE_GIVER);
        this.setStringType("LifeGiver");
        this.addObserver(observer);
        this.notifyObservers(null, null, this, "AngelSpawn");
    }
    // visitor pattern implementation
    @Override
    public final void visitHero(final Knight hero) {
        // interact only if hero is alive
        if (hero.getHP() <= 0) {
            return;
        }

        // set new hp and print specific message
        hero.setHP(hero.getHP() + LifeGiverConstants.KNIGHT_HP);
        if (hero.getHP() > hero.getMaxHP()) {
            hero.setHP(hero.getMaxHP());
        }

        this.notifyObservers(hero, null, this, "AngelHelp");
    }

    @Override
    public final void visitHero(final Pyromancer hero) {
        // interact only if hero is alive
        if (hero.getHP() <= 0) {
            return;
        }

        // set new hp and print specific message
        hero.setHP(hero.getHP() + LifeGiverConstants.PYROMANCER_HP);
        if (hero.getHP() > hero.getMaxHP()) {
            hero.setHP(hero.getMaxHP());
        }

        this.notifyObservers(hero, null, this, "AngelHelp");
    }

    @Override
    public final void visitHero(final Rogue hero) {
        // interact only if hero is alive
        if (hero.getHP() <= 0) {
            return;
        }

        // set new hp and print specific message
        hero.setHP(hero.getHP() + LifeGiverConstants.ROGUE_HP);
        if (hero.getHP() > hero.getMaxHP()) {
            hero.setHP(hero.getMaxHP());
        }

        this.notifyObservers(hero, null, this, "AngelHelp");
    }

    @Override
    public final void visitHero(final Wizard hero) {
        // interact only if hero is alive
        if (hero.getHP() <= 0) {
            return;
        }

        // set new hp and print specific message
        hero.setHP(hero.getHP() + LifeGiverConstants.WIZARD_HP);
        if (hero.getHP() > hero.getMaxHP()) {
            hero.setHP(hero.getMaxHP());
        }

        this.notifyObservers(hero, null, this, "AngelHelp");
    }
}
