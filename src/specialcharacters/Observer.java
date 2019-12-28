package specialcharacters;

import angels.types.Angel;
import players.types.Hero;

public interface Observer {
    void update(Hero hero1, Hero hero2, Angel angel, String messageType);
}
