package angels.types;

import angels.constants.XPAngelConstants;
import angels.factory.AngelTypes;
import common.Coords;
import players.constants.HeroConstants;
import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;
import specialcharacters.Observer;

public class XPAngel extends Angel {

    // constructor
    public XPAngel(final Coords coords, final Observer observer) {
        super(coords);
        this.setType(AngelTypes.XP_ANGEL);
        this.setStringType("XPAngel");
        this.addObserver(observer);
        this.notifyObservers(null, null, this, "AngelSpawn");
    }

    // visitor pattern implementation
    @Override
    public final  void visitHero(final Knight hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        hero.setXP(hero.getXP() + XPAngelConstants.KNIGHT_XP);
        int xPLevelUp = HeroConstants.XP_LIMIT_TO_GROW + hero.getLevel()
                * HeroConstants.XP_LIMIT_COEF;

        this.notifyObservers(hero, null, this, "AngelHelp");

        boolean hasGrown = false;
        while (hero.getXP() >= xPLevelUp) {
            hero.setLevel(hero.getLevel() + 1);
            xPLevelUp += HeroConstants.XP_LIMIT_COEF;
            hasGrown = true;
            this.notifyObservers(hero, null, null, "HeroLevelUp");
        }

        if (hasGrown) {
            hero.restoreHP();
        }
    }

    @Override
    public final void visitHero(final Pyromancer hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        hero.setXP(hero.getXP() + XPAngelConstants.PYROMANCER_XP);
        int xPLevelUp = HeroConstants.XP_LIMIT_TO_GROW + hero.getLevel()
                * HeroConstants.XP_LIMIT_COEF;

        this.notifyObservers(hero, null, this, "AngelHelp");

        boolean hasGrown = false;
        while (hero.getXP() >= xPLevelUp) {
            hero.setLevel(hero.getLevel() + 1);
            xPLevelUp += HeroConstants.XP_LIMIT_COEF;
            hasGrown = true;
            this.notifyObservers(hero, null, null, "HeroLevelUp");
        }

        if (hasGrown) {
            hero.restoreHP();
        }
    }

    @Override
    public final void visitHero(final Rogue hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        hero.setXP(hero.getXP() + XPAngelConstants.ROGUE_XP);
        int xPLevelUp = HeroConstants.XP_LIMIT_TO_GROW + hero.getLevel()
                * HeroConstants.XP_LIMIT_COEF;

        this.notifyObservers(hero, null, this, "AngelHelp");

        boolean hasGrown = false;
        while (hero.getXP() >= xPLevelUp) {
            hero.setLevel(hero.getLevel() + 1);
            xPLevelUp += HeroConstants.XP_LIMIT_COEF;
            hasGrown = true;
            this.notifyObservers(hero, null, null, "HeroLevelUp");
        }

        if (hasGrown) {
            hero.restoreHP();
        }
    }

    @Override
    public final void visitHero(final Wizard hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        hero.setXP(hero.getXP() + XPAngelConstants.WIZARD_XP);
        int xPLevelUp = HeroConstants.XP_LIMIT_TO_GROW + hero.getLevel()
                * HeroConstants.XP_LIMIT_COEF;

        this.notifyObservers(hero, null, this, "AngelHelp");

        boolean hasGrown = false;
        while (hero.getXP() >= xPLevelUp) {
            hero.setLevel(hero.getLevel() + 1);
            xPLevelUp += HeroConstants.XP_LIMIT_COEF;
            hasGrown = true;
            this.notifyObservers(hero, null, null, "HeroLevelUp");
        }

        if (hasGrown) {
            hero.restoreHP();
        }
    }
}
