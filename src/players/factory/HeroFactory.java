package players.factory;

import players.Hero;
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
    public Hero createHero(HeroTypes type) {
        switch (type) {
            case PYROMANCER:
                return new Pyromancer();
            case KNIGHT:
                return new Knight();
            case WIZARD:
                return new Wizard();
            case ROGUE:
                return new Rogue();
            default:
                throw new IllegalArgumentException();
        }
    }
}
