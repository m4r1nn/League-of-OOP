package players.types;

import players.abilities.HeroDamage;

public interface IHero {
    public void move();
    public void takeDamage(HeroDamage enemy1, HeroDamage enemy2);
}
