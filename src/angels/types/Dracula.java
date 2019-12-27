package angels.types;

import angels.constants.DraculaConstants;
import angels.factory.AngelTypes;
import players.abilities.HeroDamage;
import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;

public class Dracula extends Angel {

    // constructor
    public Dracula() {
        this.setType(AngelTypes.DRACULA);
    }

    // visitor pattern implementation
    @Override
    public final void visitHero(final Knight hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        ability1.setKnightModif(ability1.getKnightModif()
                + DraculaConstants.KNIGHT_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + DraculaConstants.KNIGHT_MODIF);
        hero.setHP(hero.getHP() + DraculaConstants.KNIGHT_HP);
    }

    @Override
    public final void visitHero(final Pyromancer hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        ability1.setPyromancerModif(ability1.getPyromancerModif()
                + DraculaConstants.PYROMANCER_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + DraculaConstants.PYROMANCER_MODIF);
        hero.setHP(hero.getHP() + DraculaConstants.PYROMANCER_HP);
    }

    @Override
    public final void visitHero(final Rogue hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        ability1.setRogueModif(ability1.getRogueModif()
                + DraculaConstants.ROGUE_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + DraculaConstants.ROGUE_MODIF);
        hero.setHP(hero.getHP() + DraculaConstants.ROGUE_HP);
    }

    @Override
    public final void visitHero(final Wizard hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        ability1.setWizardModif(ability1.getWizardModif()
                + DraculaConstants.WIZARD_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + DraculaConstants.WIZARD_MODIF);
        hero.setHP(hero.getHP() + DraculaConstants.WIZARD_HP);
    }
}
