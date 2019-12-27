package players.strategies;

import players.abilities.HeroDamage;
import players.constants.KnightConstants;
import players.types.Hero;

public class KnightDefenceStrategy extends Strategy {

    public KnightDefenceStrategy(final Hero hero) {
        super(hero);
    }

    @Override
    public final void changeHeroHP() {
        Hero hero = this.getHero();
        hero.setHP(Math.round(hero.getHP() * KnightConstants.DEFENCE_STRATEGY_HP));
    }

    @Override
    public final void changeHeroDamage(final HeroDamage ability) {
        ability.setPyromancerModif(ability.getPyromancerModif()
                + KnightConstants.DEFENCE_STRATEGY_MODIF);
        ability.setKnightModif(ability.getKnightModif()
                + KnightConstants.DEFENCE_STRATEGY_MODIF);
        ability.setWizardModif(ability.getWizardModif()
                + KnightConstants.DEFENCE_STRATEGY_MODIF);
        ability.setRogueModif(ability.getRogueModif()
                + KnightConstants.DEFENCE_STRATEGY_MODIF);
    }
}
