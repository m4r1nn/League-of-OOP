package players.types;

import angels.types.Angel;
import players.abilities.HeroDamage;

public interface IHero {

    // main function for interaction between heroes
    void takeDamage(HeroDamage enemy1, HeroDamage enemy2);

    // main function for interaction between hero and angel
    void acceptAngel(Angel angel);
}
