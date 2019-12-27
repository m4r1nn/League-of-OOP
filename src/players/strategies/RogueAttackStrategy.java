package players.strategies;

import players.abilities.HeroDamage;
import players.constants.RogueConstants;
import players.types.Hero;

public class RogueAttackStrategy extends Strategy {

    public RogueAttackStrategy(final Hero hero) {
        super(hero);
    }

    @Override
    public final void changeHeroHP() {
        Hero hero = this.getHero();
        hero.setHP(Math.round(hero.getHP() * RogueConstants.ATTACK_STRATEGY_HP));
    }

    @Override
    public final void changeHeroDamage(final HeroDamage ability) {
        ability.setPyromancerModif(ability.getPyromancerModif()
                + RogueConstants.ATTACK_STRATEGY_MODIF);
        ability.setKnightModif(ability.getKnightModif()
                + RogueConstants.ATTACK_STRATEGY_MODIF);
        ability.setWizardModif(ability.getWizardModif()
                + RogueConstants.ATTACK_STRATEGY_MODIF);
        ability.setRogueModif(ability.getRogueModif()
                + RogueConstants.ATTACK_STRATEGY_MODIF);
    }
}
