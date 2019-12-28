package players.types;

import angels.types.Angel;
import players.abilities.Backstab;
import players.abilities.HeroDamage;
import players.abilities.Paralysis;
import players.constants.RogueConstants;
import players.factory.HeroTypes;
import players.strategies.RogueAttackStrategy;
import players.strategies.RogueDefenceStrategy;
import specialcharacters.Observer;

public class Rogue extends Hero {
    private RogueAttackStrategy attackStrategy;
    private RogueDefenceStrategy defenceStrategy;

    // constructor
    public Rogue(final Observer observer) {
        super(observer);

        // set hero initial stats
        this.setType(HeroTypes.ROGUE);
        this.setStringType("Rogue");
        this.setHP(RogueConstants.BASE_HP);
        this.setMaxHP(RogueConstants.BASE_HP);
        this.setDefaultHP(RogueConstants.BASE_HP);
        this.setBonusHPperLevel(RogueConstants.BONUS_HP_PER_LEVEL);

        // set abilities
        this.setAbility1(new Backstab(this));
        this.setAbility2(new Paralysis(this));

        this.attackStrategy = new RogueAttackStrategy(this);
        this.defenceStrategy = new RogueDefenceStrategy(this);
    }

    @Override
    public final void changeStrategy() {
        if (this.getMaxHP() * RogueConstants.MIN_HP_COEF < this.getHP()
                && this.getHP() < this.getMaxHP() * RogueConstants.MAX_HP_COEF) {
            this.setStrategy(this.attackStrategy);
            this.getStrategy().apply();
        } else if (this.getHP() < this.getMaxHP() * RogueConstants.MIN_HP_COEF) {
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

        // opponent applies second abilities
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
