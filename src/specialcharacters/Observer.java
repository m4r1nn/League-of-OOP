package specialcharacters;

import angels.types.Angel;
import players.types.Hero;

public abstract class Observer {
    private StringBuilder res;

    public Observer() {
        this.res = new StringBuilder();
    }

    public abstract void update(Hero hero1, Hero hero2, Angel angel, String messageType);

    public final StringBuilder getRes() {
        return this.res;
    }
}
