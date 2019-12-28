package angels.types;

import angels.constants.SmallAngelConstants;
import angels.factory.AngelTypes;
import common.Coords;
import players.abilities.HeroDamage;
import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;
import specialcharacters.Observer;

public class SmallAngel extends Angel {

    // constructor
    public SmallAngel(final Coords coords, final Observer observer) {
        super(coords);
        this.setType(AngelTypes.SMALL_ANGEL);
        this.setStringType("SmallAngel");
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
                + SmallAngelConstants.KNIGHT_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + SmallAngelConstants.KNIGHT_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + SmallAngelConstants.KNIGHT_MODIF);
        ability1.setWizardModif(ability1.getWizardModif()
                + SmallAngelConstants.KNIGHT_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + SmallAngelConstants.KNIGHT_MODIF);
        ability1.setRogueModif(ability1.getRogueModif()
                + SmallAngelConstants.KNIGHT_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + SmallAngelConstants.KNIGHT_MODIF);

        // set new hp and print specific messages
        hero.setHP(hero.getHP() + SmallAngelConstants.KNIGHT_HP);
        if (hero.getHP() > hero.getMaxHP()) {
            hero.setHP(hero.getMaxHP());
        }

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
                + SmallAngelConstants.PYROMANCER_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + SmallAngelConstants.PYROMANCER_MODIF);
        ability1.setKnightModif(ability1.getKnightModif()
                + SmallAngelConstants.PYROMANCER_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + SmallAngelConstants.PYROMANCER_MODIF);
        ability1.setWizardModif(ability1.getWizardModif()
                + SmallAngelConstants.PYROMANCER_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + SmallAngelConstants.PYROMANCER_MODIF);
        ability1.setRogueModif(ability1.getRogueModif()
                + SmallAngelConstants.PYROMANCER_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + SmallAngelConstants.PYROMANCER_MODIF);

        // set new hp and print specific messages
        hero.setHP(hero.getHP() + SmallAngelConstants.PYROMANCER_HP);
        if (hero.getHP() > hero.getMaxHP()) {
            hero.setHP(hero.getMaxHP());
        }

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
                + SmallAngelConstants.ROGUE_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + SmallAngelConstants.ROGUE_MODIF);
        ability1.setKnightModif(ability1.getKnightModif()
                + SmallAngelConstants.ROGUE_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + SmallAngelConstants.ROGUE_MODIF);
        ability1.setWizardModif(ability1.getWizardModif()
                + SmallAngelConstants.ROGUE_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + SmallAngelConstants.ROGUE_MODIF);
        ability1.setRogueModif(ability1.getRogueModif()
                + SmallAngelConstants.ROGUE_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + SmallAngelConstants.ROGUE_MODIF);

        // set new hp and print specific messages
        hero.setHP(hero.getHP() + SmallAngelConstants.ROGUE_HP);
        if (hero.getHP() > hero.getMaxHP()) {
            hero.setHP(hero.getMaxHP());
        }

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
                + SmallAngelConstants.WIZARD_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + SmallAngelConstants.WIZARD_MODIF);
        ability1.setKnightModif(ability1.getKnightModif()
                + SmallAngelConstants.WIZARD_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + SmallAngelConstants.WIZARD_MODIF);
        ability1.setWizardModif(ability1.getWizardModif()
                + SmallAngelConstants.WIZARD_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + SmallAngelConstants.WIZARD_MODIF);
        ability1.setRogueModif(ability1.getRogueModif()
                + SmallAngelConstants.WIZARD_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + SmallAngelConstants.WIZARD_MODIF);

        // set new hp and print specific messages
        hero.setHP(hero.getHP() + SmallAngelConstants.WIZARD_HP);
        if (hero.getHP() > hero.getMaxHP()) {
            hero.setHP(hero.getMaxHP());
        }

        this.notifyObservers(hero, null, this, "AngelHelp");
    }
}
