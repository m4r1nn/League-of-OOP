package angels.types;

import angels.constants.GoodBoyConstants;
import angels.factory.AngelTypes;
import players.abilities.HeroDamage;
import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;

public class GoodBoy extends Angel {

    // constructor
    public GoodBoy() {
        this.setType(AngelTypes.GOOD_BOY);
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
                + GoodBoyConstants.KNIGHT_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + GoodBoyConstants.KNIGHT_MODIF);
        hero.setHP(hero.getHP() + GoodBoyConstants.KNIGHT_HP);
        if (hero.getHP() > hero.getMaxHP()) {
            hero.setHP(hero.getMaxHP());
        }
    }

    @Override
    public final void visitHero(final Pyromancer hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        ability1.setPyromancerModif(ability1.getPyromancerModif()
                + GoodBoyConstants.PYROMANCER_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + GoodBoyConstants.PYROMANCER_MODIF);
        hero.setHP(hero.getHP() + GoodBoyConstants.PYROMANCER_HP);
        if (hero.getHP() > hero.getMaxHP()) {
            hero.setHP(hero.getMaxHP());
        }
    }

    @Override
    public final void visitHero(final Rogue hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        ability1.setRogueModif(ability1.getRogueModif()
                + GoodBoyConstants.ROGUE_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + GoodBoyConstants.ROGUE_MODIF);
        hero.setHP(hero.getHP() + GoodBoyConstants.ROGUE_HP);
        if (hero.getHP() > hero.getMaxHP()) {
            hero.setHP(hero.getMaxHP());
        }
    }

    @Override
    public final void visitHero(final Wizard hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        ability1.setWizardModif(ability1.getWizardModif()
                + GoodBoyConstants.WIZARD_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + GoodBoyConstants.WIZARD_MODIF);
        hero.setHP(hero.getHP() + GoodBoyConstants.WIZARD_HP);
        if (hero.getHP() > hero.getMaxHP()) {
            hero.setHP(hero.getMaxHP());
        }
    }
}
