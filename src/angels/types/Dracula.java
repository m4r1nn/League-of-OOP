package angels.types;

import angels.constants.DraculaConstants;
import angels.factory.AngelTypes;
import common.Coords;
import players.abilities.HeroDamage;
import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;
import specialcharacters.Observer;

public class Dracula extends Angel {

    // constructor
    public Dracula(final Coords coords, final Observer observer) {
        super(coords);
        this.setType(AngelTypes.DRACULA);
        this.setStringType("Dracula");
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
                + DraculaConstants.KNIGHT_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + DraculaConstants.KNIGHT_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + DraculaConstants.KNIGHT_MODIF);
        ability1.setWizardModif(ability1.getWizardModif()
                + DraculaConstants.KNIGHT_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + DraculaConstants.KNIGHT_MODIF);
        ability1.setRogueModif(ability1.getRogueModif()
                + DraculaConstants.KNIGHT_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + DraculaConstants.KNIGHT_MODIF);

        // set new hp and print specific messages
        hero.setHP(hero.getHP() + DraculaConstants.KNIGHT_HP);
        this.notifyObservers(hero, null, this, "AngelHit");

        if (hero.getHP() <= 0) {
            this.notifyObservers(hero, null, null, "HeroKilled");
        }
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
                + DraculaConstants.PYROMANCER_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + DraculaConstants.PYROMANCER_MODIF);
        ability1.setKnightModif(ability1.getKnightModif()
                + DraculaConstants.PYROMANCER_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + DraculaConstants.PYROMANCER_MODIF);
        ability1.setWizardModif(ability1.getWizardModif()
                + DraculaConstants.PYROMANCER_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + DraculaConstants.PYROMANCER_MODIF);
        ability1.setRogueModif(ability1.getRogueModif()
                + DraculaConstants.PYROMANCER_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + DraculaConstants.PYROMANCER_MODIF);

        // set new hp and print specific messages
        hero.setHP(hero.getHP() + DraculaConstants.PYROMANCER_HP);
        this.notifyObservers(hero, null, this, "AngelHit");

        if (hero.getHP() <= 0) {
            this.notifyObservers(hero, null, null, "HeroKilled");
        }
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
                + DraculaConstants.ROGUE_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + DraculaConstants.ROGUE_MODIF);
        ability1.setKnightModif(ability1.getKnightModif()
                + DraculaConstants.ROGUE_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + DraculaConstants.ROGUE_MODIF);
        ability1.setWizardModif(ability1.getWizardModif()
                + DraculaConstants.ROGUE_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + DraculaConstants.ROGUE_MODIF);
        ability1.setRogueModif(ability1.getRogueModif()
                + DraculaConstants.ROGUE_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + DraculaConstants.ROGUE_MODIF);

        // set new hp and print specific messages
        hero.setHP(hero.getHP() + DraculaConstants.ROGUE_HP);
        this.notifyObservers(hero, null, this, "AngelHit");

        if (hero.getHP() <= 0) {
            this.notifyObservers(hero, null, null, "HeroKilled");
        }
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
                + DraculaConstants.WIZARD_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + DraculaConstants.WIZARD_MODIF);
        ability1.setKnightModif(ability1.getKnightModif()
                + DraculaConstants.WIZARD_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + DraculaConstants.WIZARD_MODIF);
        ability1.setWizardModif(ability1.getWizardModif()
                + DraculaConstants.WIZARD_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + DraculaConstants.WIZARD_MODIF);
        ability1.setRogueModif(ability1.getRogueModif()
                + DraculaConstants.WIZARD_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + DraculaConstants.WIZARD_MODIF);

        // set new hp and print specific messages
        hero.setHP(hero.getHP() + DraculaConstants.WIZARD_HP);
        this.notifyObservers(hero, null, this, "AngelHit");

        if (hero.getHP() <= 0) {
            this.notifyObservers(hero, null, null, "HeroKilled");
        }
    }
}
