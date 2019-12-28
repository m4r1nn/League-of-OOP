package angels.types;

import angels.factory.AngelTypes;
import common.Coords;
import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;
import specialcharacters.Observer;

public class TheDoomer extends Angel {

    // constructor
    public TheDoomer(final Coords coords, final Observer observer) {
        super(coords);
        this.setType(AngelTypes.THE_DOOMER);
        this.setStringType("TheDoomer");
        this.addObserver(observer);
        this.notifyObservers(null, null, this, "AngelSpawn");
    }

    // visitor pattern implementation
    @Override
    public final void visitHero(final Knight hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        hero.setHP(0);

        this.notifyObservers(hero, null, this, "AngelHit");
        this.notifyObservers(hero, null, null, "HeroKilled");
    }

    @Override
    public final void visitHero(final Pyromancer hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        hero.setHP(0);

        this.notifyObservers(hero, null, this, "AngelHit");
        this.notifyObservers(hero, null, null, "HeroKilled");
    }

    @Override
    public final void visitHero(final Rogue hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        hero.setHP(0);

        this.notifyObservers(hero, null, this, "AngelHit");
        this.notifyObservers(hero, null, null, "HeroKilled");
    }

    @Override
    public final void visitHero(final Wizard hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        hero.setHP(0);

        this.notifyObservers(hero, null, this, "AngelHit");
        this.notifyObservers(hero, null, null, "HeroKilled");
    }
}
