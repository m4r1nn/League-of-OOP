package players.factory;

import players.types.Hero;
import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;
import specialcharacters.Observer;

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
    public Hero createHero(final char type, final Observer observer) {
        switch (type) {
            case 'P':
                return new Pyromancer(observer);
            case 'K':
                return new Knight(observer);
            case 'W':
                return new Wizard(observer);
            case 'R':
                return new Rogue(observer);
            default:
                throw new IllegalArgumentException();
        }
    }
}
