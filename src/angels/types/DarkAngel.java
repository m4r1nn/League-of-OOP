package angels.types;

import angels.constants.DarkAngelConstants;
import angels.factory.AngelTypes;
import common.Coords;
import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;
import specialcharacters.Observer;

public class DarkAngel extends Angel {

    //constructor
    public DarkAngel(final Coords coords, final Observer observer) {
        super(coords);
        this.setType(AngelTypes.DARK_ANGEL);
        this.setStringType("DarkAngel");
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

        // set new hp and print specific messages
        hero.setHP(hero.getHP() + DarkAngelConstants.KNIGHT_HP);
        this.notifyObservers(hero, null, this, "AngelHit");

        if (hero.getHP() <= 0) {
            this.notifyObservers(hero, null, null, "HeroKilled");
        }
    }

    @Override
    public final void visitHero(final Pyromancer hero) {
        // interact only if hero is alive
        if (hero.getHP() <= 0) {
            return;
        }

        // set new hp and print specific messages
        hero.setHP(hero.getHP() + DarkAngelConstants.PYROMANCER_HP);
        this.notifyObservers(hero, null, this, "AngelHit");

        if (hero.getHP() <= 0) {
            this.notifyObservers(hero, null, null, "HeroKilled");
        }
    }

    @Override
    public final void visitHero(final Rogue hero) {
        // interact only if hero is alive
        if (hero.getHP() <= 0) {
            return;
        }

        // set new hp and print specific messages
        hero.setHP(hero.getHP() + DarkAngelConstants.ROGUE_HP);
        this.notifyObservers(hero, null, this, "AngelHit");

        if (hero.getHP() <= 0) {
            this.notifyObservers(hero, null, null, "HeroKilled");
        }
    }

    @Override
    public final void visitHero(final Wizard hero) {
        // interact only if hero is alive
        if (hero.getHP() <= 0) {
            return;
        }

        // set new hp and print specific messages
        hero.setHP(hero.getHP() + DarkAngelConstants.WIZARD_HP);
        this.notifyObservers(hero, null, this, "AngelHit");

        if (hero.getHP() <= 0) {
            this.notifyObservers(hero, null, null, "HeroKilled");
        }
    }
}
