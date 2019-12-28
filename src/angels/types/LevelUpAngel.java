package angels.types;

import angels.constants.LevelUpAngelConstants;
import angels.factory.AngelTypes;
import common.Coords;
import players.abilities.HeroDamage;
import players.constants.HeroConstants;
import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;
import specialcharacters.Observer;

public class LevelUpAngel extends Angel {

    // constructor
    public LevelUpAngel(final Coords coords, final Observer observer) {
        super(coords);
        this.setType(AngelTypes.LEVEL_UP_ANGEL);
        this.setStringType("LevelUpAngel");
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

        // set new xp
        hero.setXP(HeroConstants.XP_LIMIT_TO_GROW + hero.getLevel() * HeroConstants.XP_LIMIT_COEF);
        hero.setLevel(hero.getLevel() + 1);
        hero.restoreHP();

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        // set abilities modifiers
        ability1.setPyromancerModif(ability1.getPyromancerModif()
                + LevelUpAngelConstants.KNIGHT_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + LevelUpAngelConstants.KNIGHT_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + LevelUpAngelConstants.KNIGHT_MODIF);
        ability1.setWizardModif(ability1.getWizardModif()
                + LevelUpAngelConstants.KNIGHT_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + LevelUpAngelConstants.KNIGHT_MODIF);
        ability1.setRogueModif(ability1.getRogueModif()
                + LevelUpAngelConstants.KNIGHT_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + LevelUpAngelConstants.KNIGHT_MODIF);

        // print specific messages
        this.notifyObservers(hero, null, this, "AngelHelp");
        this.notifyObservers(hero, null, null, "HeroLevelUp");
    }

    @Override
    public final void visitHero(final Pyromancer hero) {
        // interact only if hero is alive
        if (hero.getHP() <= 0) {
            return;
        }

        // set new xp
        hero.setXP(HeroConstants.XP_LIMIT_TO_GROW + hero.getLevel() * HeroConstants.XP_LIMIT_COEF);
        hero.setLevel(hero.getLevel() + 1);
        hero.restoreHP();

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        // set abilities modifiers
        ability1.setPyromancerModif(ability1.getPyromancerModif()
                + LevelUpAngelConstants.PYROMANCER_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + LevelUpAngelConstants.PYROMANCER_MODIF);
        ability1.setKnightModif(ability1.getKnightModif()
                + LevelUpAngelConstants.PYROMANCER_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + LevelUpAngelConstants.PYROMANCER_MODIF);
        ability1.setWizardModif(ability1.getWizardModif()
                + LevelUpAngelConstants.PYROMANCER_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + LevelUpAngelConstants.PYROMANCER_MODIF);
        ability1.setRogueModif(ability1.getRogueModif()
                + LevelUpAngelConstants.PYROMANCER_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + LevelUpAngelConstants.PYROMANCER_MODIF);

        // print specific messages
        this.notifyObservers(hero, null, this, "AngelHelp");
        this.notifyObservers(hero, null, null, "HeroLevelUp");
    }

    @Override
    public final void visitHero(final Rogue hero) {
        // interact only if hero is alive
        if (hero.getHP() <= 0) {
            return;
        }

        // set new xp
        hero.setXP(HeroConstants.XP_LIMIT_TO_GROW + hero.getLevel() * HeroConstants.XP_LIMIT_COEF);
        hero.setLevel(hero.getLevel() + 1);
        hero.restoreHP();

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        // set abilities modifiers
        ability1.setPyromancerModif(ability1.getPyromancerModif()
                + LevelUpAngelConstants.ROGUE_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + LevelUpAngelConstants.ROGUE_MODIF);
        ability1.setKnightModif(ability1.getKnightModif()
                + LevelUpAngelConstants.ROGUE_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + LevelUpAngelConstants.ROGUE_MODIF);
        ability1.setWizardModif(ability1.getWizardModif()
                + LevelUpAngelConstants.ROGUE_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + LevelUpAngelConstants.ROGUE_MODIF);
        ability1.setRogueModif(ability1.getRogueModif()
                + LevelUpAngelConstants.ROGUE_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + LevelUpAngelConstants.ROGUE_MODIF);

        // print specific messages
        this.notifyObservers(hero, null, this, "AngelHelp");
        this.notifyObservers(hero, null, null, "HeroLevelUp");
    }

    @Override
    public final void visitHero(final Wizard hero) {
        // interact only if hero is alive
        if (hero.getHP() <= 0) {
            return;
        }

        // set new xp
        hero.setXP(HeroConstants.XP_LIMIT_TO_GROW + hero.getLevel() * HeroConstants.XP_LIMIT_COEF);
        hero.setLevel(hero.getLevel() + 1);
        hero.restoreHP();

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        // set abilities modifiers
        ability1.setPyromancerModif(ability1.getPyromancerModif()
                + LevelUpAngelConstants.WIZARD_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + LevelUpAngelConstants.WIZARD_MODIF);
        ability1.setKnightModif(ability1.getKnightModif()
                + LevelUpAngelConstants.WIZARD_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + LevelUpAngelConstants.WIZARD_MODIF);
        ability1.setWizardModif(ability1.getWizardModif()
                + LevelUpAngelConstants.WIZARD_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + LevelUpAngelConstants.WIZARD_MODIF);
        ability1.setRogueModif(ability1.getRogueModif()
                + LevelUpAngelConstants.WIZARD_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + LevelUpAngelConstants.WIZARD_MODIF);

        // print specific messages
        this.notifyObservers(hero, null, this, "AngelHelp");
        this.notifyObservers(hero, null, null, "HeroLevelUp");
    }
}
