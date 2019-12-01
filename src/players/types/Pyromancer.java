package players.types;

import players.abilities.Fireblast;
import players.abilities.HeroDamage;
import players.abilities.Ignite;
import players.constants.PyromancerConstants;
import players.factory.HeroTypes;

public class Pyromancer extends Hero {
    // constructor
    public Pyromancer() {
        super();

        // set hero initial stats
        this.setType(HeroTypes.PYROMANCER);
        this.setHP(PyromancerConstants.BASE_HP);
        this.setMaxHP(PyromancerConstants.BASE_HP);
        this.setDefaultHP(PyromancerConstants.BASE_HP);
        this.setBonusHPperLevel(PyromancerConstants.BONUS_HP_PER_LEVEL);

        // set abilities
        this.setAbility1(new Fireblast(this));
        this.setAbility2(new Ignite(this));
    }

    @Override
    // apply visitor
    public final void takeDamage(final HeroDamage enemy1, final HeroDamage enemy2) {

        // opponent applies first ability
        enemy1.launchAttack(this);
        int totalDamage = this.getDamageToTake();

        // opponent applies second ability
        enemy2.launchAttack(this);
        totalDamage += this.getDamageToTake();

        // take the damage
        this.setHP(this.getHP() - totalDamage);
    }
}
