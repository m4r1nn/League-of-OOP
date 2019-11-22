package players.factory;

import players.types.Hero;
import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;

public class HeroFactory {
    private static HeroFactory instance = null;
    private HeroFactory() { }
    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }
    public Hero createHero(char type) {
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
