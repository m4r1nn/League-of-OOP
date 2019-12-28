package players.strategies;

import players.abilities.HeroDamage;
import players.constants.WizardConstants;
import players.types.Hero;

public class WizardAttackStrategy extends Strategy {

    // constructor
    public WizardAttackStrategy(final Hero hero) {
        super(hero);
    }

    @Override
    public final void changeHeroHP() {
        // set new hp
        Hero hero = this.getHero();
        hero.setHP((int) (hero.getHP() * WizardConstants.ATTACK_STRATEGY_HP));
    }

    @Override
    public final void changeHeroDamage(final HeroDamage ability) {
        // set new ability modifiers
        ability.setPyromancerModif(ability.getPyromancerModif()
                + WizardConstants.ATTACK_STRATEGY_MODIF);
        ability.setKnightModif(ability.getKnightModif()
                + WizardConstants.ATTACK_STRATEGY_MODIF);
        ability.setWizardModif(ability.getWizardModif()
                + WizardConstants.ATTACK_STRATEGY_MODIF);
        ability.setRogueModif(ability.getRogueModif()
                + WizardConstants.ATTACK_STRATEGY_MODIF);
    }
}
