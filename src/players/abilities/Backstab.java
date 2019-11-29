package players.abilities;

import players.types.*;

public class Backstab extends HeroDamage {
    public Backstab(Hero hero) {
        super(hero);
    }
    @Override
    public void setBaseDamage() {
        this.baseDamage = Math.round(200 + 0.2f * this.getHeroLevel());
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
