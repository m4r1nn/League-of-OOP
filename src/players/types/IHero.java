package players.types;

import players.abilities.HeroDamage;

public interface IHero {

    // main function for interaction between heroes
    void takeDamage(HeroDamage enemy1, HeroDamage enemy2);
}
