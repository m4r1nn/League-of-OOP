package players.types;

import players.abilities.Deflect;
import players.abilities.Drain;
import players.abilities.HeroDamage;
import players.constants.WizardConstants;
import players.factory.HeroTypes;

public class Wizard extends Hero {
    // constructor
    public Wizard() {
        super();

        // set hero initial stats
        this.setType(HeroTypes.WIZARD);
        this.setHP(WizardConstants.BASE_HP);
        this.setMaxHP(WizardConstants.BASE_HP);
        this.setDefaultHP(WizardConstants.BASE_HP);
        this.setBonusHPperLevel(WizardConstants.BONUS_HP_PER_LEVEL);

        // set abilities
        this.setAbility1(new Drain(this));
        this.setAbility2(new Deflect(this));
    }

    @Override
    public final void takeDamage(final HeroDamage enemy1, final HeroDamage enemy2) {

        // opponent applies first ability
        enemy1.launchAttack(this);
        int totalDamage = this.getDamageToTake();

        // opponent applies second abilitiy
        enemy2.launchAttack(this);
        totalDamage += this.getDamageToTake();

        // take damage
        this.setHP(this.getHP() - totalDamage);
    }
}
