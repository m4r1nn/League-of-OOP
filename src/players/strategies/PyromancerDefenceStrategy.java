package players.strategies;

import players.abilities.HeroDamage;
import players.constants.PyromancerConstants;
import players.types.Hero;

public class PyromancerDefenceStrategy extends Strategy {

    // constructor
    public PyromancerDefenceStrategy(final Hero hero) {
        super(hero);
    }

    @Override
    public final void changeHeroHP() {
        // set new hp
        Hero hero = this.getHero();
        hero.setHP((int) (hero.getHP() * PyromancerConstants.DEFENCE_STRATEGY_HP));
    }

    @Override
    public final void changeHeroDamage(final HeroDamage ability) {
        // set new ability modifiers
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
