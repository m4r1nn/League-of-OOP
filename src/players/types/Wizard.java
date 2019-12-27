package players.types;

import angels.types.Angel;
import players.abilities.Deflect;
import players.abilities.Drain;
import players.abilities.HeroDamage;
import players.constants.WizardConstants;
import players.factory.HeroTypes;
import players.strategies.WizardAttackStrategy;
import players.strategies.WizardDefenceStrategy;

public class Wizard extends Hero {
    private WizardAttackStrategy attackStrategy;
    private WizardDefenceStrategy defenceStrategy;

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

        this.attackStrategy = new WizardAttackStrategy(this);
        this.defenceStrategy = new WizardDefenceStrategy(this);
    }

    @Override
    public final void changeStrategy() {
        if (this.getMaxHP() * WizardConstants.MIN_HP_COEF < this.getHP()
                && this.getHP() < this.getMaxHP() * WizardConstants.MAX_HP_COEF) {
            this.setStrategy(this.attackStrategy);
            this.getStrategy().apply();
        } else if (this.getHP() < this.getMaxHP() * WizardConstants.MIN_HP_COEF) {
            this.setStrategy(this.defenceStrategy);
            this.getStrategy().apply();
        }
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

    @Override
    public final void acceptAngel(final Angel angel) {
        angel.visitHero(this);
    }
}
