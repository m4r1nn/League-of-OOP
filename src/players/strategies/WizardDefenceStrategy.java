package players.strategies;

import players.abilities.HeroDamage;
import players.constants.WizardConstants;
import players.types.Hero;

public class WizardDefenceStrategy extends Strategy {

    // constructor
    public WizardDefenceStrategy(final Hero hero) {
        super(hero);
    }

    @Override
    public final void changeHeroHP() {
        // set new hp
        Hero hero = this.getHero();
        hero.setHP((int) (hero.getHP() * WizardConstants.DEFENCE_STRATEGY_HP));
    }

    @Override
    public final void changeHeroDamage(final HeroDamage ability) {
        // set new ability modifiers
        ability.setPyromancerModif(ability.getPyromancerModif()
                + WizardConstants.DEFENCE_STRATEGY_MODIF);
        ability.setKnightModif(ability.getKnightModif()
                + WizardConstants.DEFENCE_STRATEGY_MODIF);
        ability.setWizardModif(ability.getWizardModif()
                + WizardConstants.DEFENCE_STRATEGY_MODIF);
        ability.setRogueModif(ability.getRogueModif()
                + WizardConstants.DEFENCE_STRATEGY_MODIF);
    }
}
