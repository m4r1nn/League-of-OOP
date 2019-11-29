package players.abilities;

import players.types.*;

public class Deflect extends HeroDamage {
    public Deflect(Hero hero) {
        super(hero);
    }
    @Override
    public void setBaseDamage() {
        this.baseDamage = 0; // TODO
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
