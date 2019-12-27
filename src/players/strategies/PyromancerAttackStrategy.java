package players.strategies;

import players.abilities.HeroDamage;
import players.constants.PyromancerConstants;
import players.types.Hero;

public class PyromancerAttackStrategy extends Strategy {

    public PyromancerAttackStrategy(final Hero hero) {
        super(hero);
    }

    @Override
    public final void changeHeroHP() {
        Hero hero = this.getHero();
        hero.setHP(Math.round(hero.getHP() * PyromancerConstants.ATTACK_STRATEGY_HP));
    }

    @Override
    public final void changeHeroDamage(final HeroDamage ability) {
        ability.setPyromancerModif(ability.getPyromancerModif()
                + PyromancerConstants.ATTACK_STRATEGY_MODIF);
        ability.setKnightModif(ability.getKnightModif()
                + PyromancerConstants.ATTACK_STRATEGY_MODIF);
        ability.setWizardModif(ability.getWizardModif()
                + PyromancerConstants.ATTACK_STRATEGY_MODIF);
        ability.setRogueModif(ability.getRogueModif()
                + PyromancerConstants.ATTACK_STRATEGY_MODIF);
    }
}
