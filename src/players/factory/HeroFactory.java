package players.factory;

import players.types.Hero;
import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;

public final class HeroFactory {
    private static HeroFactory instance = null;

    // constructor
    private HeroFactory() { }

    // singleton pattern implementation
    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }

    // main purpose of hero factory to create heroes
    public Hero createHero(final char type) {
        switch (type) {
            case 'P':
                return new Pyromancer();
            case 'K':
                return new Knight();
            case 'W':
                return new Wizard();
            case 'R':
                return new Rogue();
            default:
                throw new IllegalArgumentException();
        }
    }
}
