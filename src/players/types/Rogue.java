package players.types;

import players.abilities.Backstab;
import players.abilities.HeroDamage;
import players.abilities.Paralysis;
import players.constants.RogueConstants;
import players.factory.HeroTypes;

public class Rogue extends Hero {
    // constructor
    public Rogue() {
        super();

        // set hero initial stats
        this.setType(HeroTypes.ROGUE);
        this.setHP(RogueConstants.BASE_HP);
        this.setMaxHP(RogueConstants.BASE_HP);
        this.setDefaultHP(RogueConstants.BASE_HP);
        this.setBonusHPperLevel(RogueConstants.BONUS_HP_PER_LEVEL);

        // set abilities
        this.setAbility1(new Backstab(this));
        this.setAbility2(new Paralysis(this));
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
}
