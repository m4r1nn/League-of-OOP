package angels.types;

import angels.constants.SpawnerConstants;
import angels.factory.AngelTypes;
import common.Coords;
import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;
import specialcharacters.Observer;

public class Spawner extends Angel {

    //constructor
    public Spawner(final Coords coords, final Observer observer) {
        super(coords);
        this.setType(AngelTypes.SPAWNER);
        this.setStringType("Spawner");
        this.addObserver(observer);
        this.notifyObservers(null, null, this, "AngelSpawn");
    }

    // visitor pattern implementation
    @Override
    public final void visitHero(final Knight hero) {
        if (hero.getHP() > 0) {
            return;
        }

        hero.setHP(SpawnerConstants.KNIGHT_HP);

        this.notifyObservers(hero, null, this, "AngelHelp");
        this.notifyObservers(hero, null, null, "HeroSpawned");
    }

    @Override
    public final void visitHero(final Pyromancer hero) {
        if (hero.getHP() > 0) {
            return;
        }

        hero.setHP(SpawnerConstants.PYROMANCER_HP);

        this.notifyObservers(hero, null, this, "AngelHelp");
        this.notifyObservers(hero, null, null, "HeroSpawned");
    }

    @Override
    public final void visitHero(final Rogue hero) {
        if (hero.getHP() > 0) {
            return;
        }

        hero.setHP(SpawnerConstants.ROGUE_HP);

        this.notifyObservers(hero, null, this, "AngelHelp");
        this.notifyObservers(hero, null, null, "HeroSpawned");
    }

    @Override
    public final void visitHero(final Wizard hero) {
        if (hero.getHP() > 0) {
            return;
        }

        hero.setHP(SpawnerConstants.WIZARD_HP);

        this.notifyObservers(hero, null, this, "AngelHelp");
        this.notifyObservers(hero, null, null, "HeroSpawned");
    }
}