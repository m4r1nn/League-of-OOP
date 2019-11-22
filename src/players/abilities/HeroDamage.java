package players.abilities;

import players.types.Hero;

public abstract class HeroDamage implements IHeroDamage {
    protected int heroLevel;
    public abstract int calculateFirstBaseDamage();
    public abstract int calculateSecondBaseDamage();
    public void getHeroLevel(Hero hero) {
        this.heroLevel = hero.getLevel();
    }
}
