package players.abilities;

import players.types.*;

public class Paralysis extends HeroDamage {
    public Paralysis(Hero hero) {
        super(hero);
    }
    @Override
    public void setBaseDamage() {
        this.baseDamage = Math.round(40 + 0.1f * this.getHeroLevel());
    }
    @Override
    public void launchAttack(Pyromancer opponent) {

    }
    @Override
    public void launchAttack(Knight opponent) {

    }
    @Override
    public void launchAttack(Wizard opponent) {

    }
    @Override
    public void launchAttack(Rogue opponent) {

    }
}
