package players.types;

import angels.types.Angel;
import players.abilities.HeroDamage;
import players.abilities.Slam;
import players.abilities.Execute;
import players.constants.KnightConstants;
import players.factory.HeroTypes;
import players.strategies.KnightAttackStrategy;
import players.strategies.KnightDefenceStrategy;

public class Knight extends Hero {
    private KnightAttackStrategy attackStrategy;
    private KnightDefenceStrategy defenceStrategy;

    // constructor
    public Knight() {
        super();

        // set hero initial stats
        this.setType(HeroTypes.KNIGHT);
        this.setHP(KnightConstants.BASE_HP);
        this.setMaxHP(KnightConstants.BASE_HP);
        this.setDefaultHP(KnightConstants.BASE_HP);
        this.setBonusHPperLevel(KnightConstants.BONUS_HP_PER_LEVEL);

        // set abilities
        this.setAbility1(new Execute(this));
        this.setAbility2(new Slam(this));

        this.attackStrategy = new KnightAttackStrategy(this);
        this.defenceStrategy = new KnightDefenceStrategy(this);
    }

    @Override
    public final void changeStrategy() {
        if (this.getMaxHP() * KnightConstants.MIN_HP_COEF < this.getHP()
                && this.getHP() < this.getMaxHP() * KnightConstants.MAX_HP_COEF) {
            this.setStrategy(this.attackStrategy);
            this.getStrategy().apply();
        } else if (this.getHP() < this.getMaxHP() * KnightConstants.MIN_HP_COEF) {
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
