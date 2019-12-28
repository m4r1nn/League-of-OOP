package players.strategies;

import players.abilities.HeroDamage;
import players.types.Hero;

public abstract class Strategy {
    private Hero hero;

    // constructor
    public Strategy(final Hero hero) {
        this.hero = hero;
    }

    // main function for applying current strategy after choosing it
    public final void apply() {
        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        // set new hp and new abilities modifiers
        this.changeHeroHP();
        this.changeHeroDamage(ability1);
        this.changeHeroDamage(ability2);
    }

    public abstract void changeHeroHP();
    public abstract void changeHeroDamage(HeroDamage ability);

    // getter
    public final Hero getHero() {
        return this.hero;
    }
}
