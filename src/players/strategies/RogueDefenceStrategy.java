package players.strategies;

import players.abilities.HeroDamage;
import players.constants.RogueConstants;
import players.types.Hero;

public class RogueDefenceStrategy extends Strategy {

    // constructor
    public RogueDefenceStrategy(final Hero hero) {
        super(hero);
    }

    @Override
    public final void changeHeroHP() {
        // set new hp
        Hero hero = this.getHero();
        hero.setHP((int) (hero.getHP() * RogueConstants.DEFENCE_STRATEGY_HP));
    }

    @Override
    public final void changeHeroDamage(final HeroDamage ability) {
        // set new ability modifiers
        ability.setPyromancerModif(ability.getPyromancerModif()
                + RogueConstants.DEFENCE_STRATEGY_MODIF);
        ability.setKnightModif(ability.getKnightModif()
                + RogueConstants.DEFENCE_STRATEGY_MODIF);
        ability.setWizardModif(ability.getWizardModif()
                + RogueConstants.DEFENCE_STRATEGY_MODIF);
        ability.setRogueModif(ability.getRogueModif()
                + RogueConstants.DEFENCE_STRATEGY_MODIF);
    }
}
