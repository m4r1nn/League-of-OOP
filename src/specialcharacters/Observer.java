package specialcharacters;

import angels.types.Angel;
import players.types.Hero;

public abstract class Observer {
    private StringBuilder res;

    // constructor
    public Observer() {
        this.res = new StringBuilder();
    }

    // method for update and print main stats in game
    public abstract void update(Hero hero1, Hero hero2, Angel angel, String messageType);

    // getter
    public final StringBuilder getRes() {
        return this.res;
    }
}
