package players.types;

import angels.types.Angel;
import players.abilities.Fireblast;
import players.abilities.HeroDamage;
import players.abilities.Ignite;
import players.constants.PyromancerConstants;
import players.factory.HeroTypes;
import players.strategies.PyromancerAttackStrategy;
import players.strategies.PyromancerDefenceStrategy;
import specialcharacters.Observer;

public class Pyromancer extends Hero {
    private PyromancerAttackStrategy attackStrategy;
    private PyromancerDefenceStrategy defenceStrategy;

    // constructor
    public Pyromancer(final Observer observer) {
        super(observer);

        // set hero initial stats
        this.setType(HeroTypes.PYROMANCER);
        this.setStringType("Pyromancer");
        this.setHP(PyromancerConstants.BASE_HP);
        this.setMaxHP(PyromancerConstants.BASE_HP);
        this.setDefaultHP(PyromancerConstants.BASE_HP);
        this.setBonusHPperLevel(PyromancerConstants.BONUS_HP_PER_LEVEL);

        // set abilities
        this.setAbility1(new Fireblast(this));
        this.setAbility2(new Ignite(this));

        // set base strategies
        this.attackStrategy = new PyromancerAttackStrategy(this);
        this.defenceStrategy = new PyromancerDefenceStrategy(this);
    }

    @Override
    public final void changeStrategy() {
        if (Math.round(this.getMaxHP() * PyromancerConstants.MIN_HP_COEF) < this.getHP()
                && this.getHP() < Math.round(this.getMaxHP() * PyromancerConstants.MAX_HP_COEF)) {

            // choose and apply attack strategy
            this.setStrategy(this.attackStrategy);
            this.getStrategy().apply();
        } else if (this.getHP() < Math.round(this.getMaxHP() * PyromancerConstants.MIN_HP_COEF)) {

            // choose and apply defence strategy
            this.setStrategy(this.defenceStrategy);
            this.getStrategy().apply();
        }
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

    @Override
    public final void acceptAngel(final Angel angel) {
        angel.visitHero(this);
    }
}
