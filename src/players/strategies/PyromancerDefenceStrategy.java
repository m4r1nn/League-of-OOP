package players.strategies;

import players.abilities.HeroDamage;
import players.constants.PyromancerConstants;
import players.types.Hero;

public class PyromancerDefenceStrategy extends Strategy {

    public PyromancerDefenceStrategy(final Hero hero) {
        super(hero);
    }

    @Override
    public final void changeHeroHP() {
        Hero hero = this.getHero();
        hero.setHP(Math.round(hero.getHP() * PyromancerConstants.DEFENCE_STRATEGY_HP));
    }

    @Override
    public final void changeHeroDamage(final HeroDamage ability) {
        ability.setPyromancerModif(ability.getPyromancerModif()
                + PyromancerConstants.DEFENCE_STRATEGY_MODIF);
        ability.setKnightModif(ability.getKnightModif()
                + PyromancerConstants.DEFENCE_STRATEGY_MODIF);
        ability.setWizardModif(ability.getWizardModif()
                + PyromancerConstants.DEFENCE_STRATEGY_MODIF);
        ability.setRogueModif(ability.getRogueModif()
                + PyromancerConstants.DEFENCE_STRATEGY_MODIF);
    }
}
