package players.strategies;

import players.abilities.HeroDamage;
import players.constants.KnightConstants;
import players.types.Hero;

public class KnightAttackStrategy extends Strategy {

    // constructor
    public KnightAttackStrategy(final Hero hero) {
        super(hero);
    }

    @Override
    public final void changeHeroHP() {
        // set new hp
        Hero hero = this.getHero();
        hero.setHP((int) (hero.getHP() * KnightConstants.ATTACK_STRATEGY_HP));
    }

    @Override
    public final void changeHeroDamage(final HeroDamage ability) {
        // set new ability modifiers
        ability.setPyromancerModif(ability.getPyromancerModif()
                + KnightConstants.ATTACK_STRATEGY_MODIF);
        ability.setKnightModif(ability.getKnightModif()
                + KnightConstants.ATTACK_STRATEGY_MODIF);
        ability.setWizardModif(ability.getWizardModif()
                + KnightConstants.ATTACK_STRATEGY_MODIF);
        ability.setRogueModif(ability.getRogueModif()
                + KnightConstants.ATTACK_STRATEGY_MODIF);
    }
}
