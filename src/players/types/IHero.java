package players.types;

import players.abilities.HeroDamage;

public interface IHero {
    public abstract void takeDamage(HeroDamage enemy);
}
