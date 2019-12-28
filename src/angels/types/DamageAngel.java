package angels.types;

import angels.constants.DamageAngelConstants;
import angels.factory.AngelTypes;
import common.Coords;
import players.abilities.HeroDamage;
import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;
import specialcharacters.Observer;

public class DamageAngel extends Angel {

    // constructor
    public DamageAngel(final Coords coords, final Observer observer) {
        super(coords);
        this.setType(AngelTypes.DAMAGE_ANGEL);
        this.setStringType("DamageAngel");
        this.addObserver(observer);
        this.notifyObservers(null, null, this, "AngelSpawn");
    }

    // visitor pattern implementation
    @Override
    public final void visitHero(final Knight hero) {
        // interact only if hero is alive
        if (hero.getHP() <= 0) {
            return;
        }

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        // set abilities modifiers
        ability1.setPyromancerModif(ability1.getPyromancerModif()
                + DamageAngelConstants.KNIGHT_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + DamageAngelConstants.KNIGHT_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + DamageAngelConstants.KNIGHT_MODIF);
        ability1.setWizardModif(ability1.getWizardModif()
                + DamageAngelConstants.KNIGHT_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + DamageAngelConstants.KNIGHT_MODIF);
        ability1.setRogueModif(ability1.getRogueModif()
                + DamageAngelConstants.KNIGHT_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + DamageAngelConstants.KNIGHT_MODIF);

        // print specific message
        this.notifyObservers(hero, null, this, "AngelHelp");
    }

    @Override
    public final void visitHero(final Pyromancer hero) {
        // interact only if hero is alive
        if (hero.getHP() <= 0) {
            return;
        }

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        // set abilities modifiers
        ability1.setPyromancerModif(ability1.getPyromancerModif()
                + DamageAngelConstants.PYROMANCER_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + DamageAngelConstants.PYROMANCER_MODIF);
        ability1.setKnightModif(ability1.getKnightModif()
                + DamageAngelConstants.PYROMANCER_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + DamageAngelConstants.PYROMANCER_MODIF);
        ability1.setWizardModif(ability1.getWizardModif()
                + DamageAngelConstants.PYROMANCER_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + DamageAngelConstants.PYROMANCER_MODIF);
        ability1.setRogueModif(ability1.getRogueModif()
                + DamageAngelConstants.PYROMANCER_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + DamageAngelConstants.PYROMANCER_MODIF);

        // print specific message
        this.notifyObservers(hero, null, this, "AngelHelp");
    }

    @Override
    public final void visitHero(final Rogue hero) {
        // interact only if hero is alive
        if (hero.getHP() <= 0) {
            return;
        }

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        // set abilities modifiers
        ability1.setPyromancerModif(ability1.getPyromancerModif()
                + DamageAngelConstants.ROGUE_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + DamageAngelConstants.ROGUE_MODIF);
        ability1.setKnightModif(ability1.getKnightModif()
                + DamageAngelConstants.ROGUE_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + DamageAngelConstants.ROGUE_MODIF);
        ability1.setWizardModif(ability1.getWizardModif()
                + DamageAngelConstants.ROGUE_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + DamageAngelConstants.ROGUE_MODIF);
        ability1.setRogueModif(ability1.getRogueModif()
                + DamageAngelConstants.ROGUE_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + DamageAngelConstants.ROGUE_MODIF);

        // print specific message
        this.notifyObservers(hero, null, this, "AngelHelp");
    }

    @Override
    public final void visitHero(final Wizard hero) {
        // interact only if hero is alive
        if (hero.getHP() <= 0) {
            return;
        }

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        // set abilities modifiers
        ability1.setPyromancerModif(ability1.getPyromancerModif()
                + DamageAngelConstants.WIZARD_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + DamageAngelConstants.WIZARD_MODIF);
        ability1.setKnightModif(ability1.getKnightModif()
                + DamageAngelConstants.WIZARD_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + DamageAngelConstants.WIZARD_MODIF);
        ability1.setWizardModif(ability1.getWizardModif()
                + DamageAngelConstants.WIZARD_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + DamageAngelConstants.WIZARD_MODIF);
        ability1.setRogueModif(ability1.getRogueModif()
                + DamageAngelConstants.WIZARD_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + DamageAngelConstants.WIZARD_MODIF);

        // print specific message
        this.notifyObservers(hero, null, this, "AngelHelp");
    }
}
