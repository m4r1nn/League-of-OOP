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
        if (hero.getHP() <= 0) {
            return;
        }

        hero.setXP(HeroConstants.XP_LIMIT_TO_GROW + hero.getLevel() * HeroConstants.XP_LIMIT_COEF);
        hero.setLevel(hero.getLevel() + 1);

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        ability1.setKnightModif(ability1.getKnightModif()
                + LevelUpAngelConstants.KNIGHT_MODIF);
        ability2.setKnightModif(ability2.getKnightModif()
                + LevelUpAngelConstants.KNIGHT_MODIF);

        this.notifyObservers(hero, null, this, "AngelHelp");
        this.notifyObservers(hero, null, null, "HeroLevelUp");
    }

    @Override
    public final void visitHero(final Pyromancer hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        hero.setXP(HeroConstants.XP_LIMIT_TO_GROW + hero.getLevel() * HeroConstants.XP_LIMIT_COEF);
        hero.setLevel(hero.getLevel() + 1);

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        ability1.setPyromancerModif(ability1.getPyromancerModif()
                + LevelUpAngelConstants.PYROMANCER_MODIF);
        ability2.setPyromancerModif(ability2.getPyromancerModif()
                + LevelUpAngelConstants.PYROMANCER_MODIF);

        this.notifyObservers(hero, null, this, "AngelHelp");
        this.notifyObservers(hero, null, null, "HeroLevelUp");
    }

    @Override
    public final void visitHero(final Rogue hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        hero.setXP(HeroConstants.XP_LIMIT_TO_GROW + hero.getLevel() * HeroConstants.XP_LIMIT_COEF);
        hero.setLevel(hero.getLevel() + 1);

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        ability1.setRogueModif(ability1.getRogueModif()
                + LevelUpAngelConstants.ROGUE_MODIF);
        ability2.setRogueModif(ability2.getRogueModif()
                + LevelUpAngelConstants.ROGUE_MODIF);

        this.notifyObservers(hero, null, this, "AngelHelp");
        this.notifyObservers(hero, null, null, "HeroLevelUp");
    }

    @Override
    public final void visitHero(final Wizard hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        hero.setXP(HeroConstants.XP_LIMIT_TO_GROW + hero.getLevel() * HeroConstants.XP_LIMIT_COEF);
        hero.setLevel(hero.getLevel() + 1);

        HeroDamage ability1 = hero.getAbility1();
        HeroDamage ability2 = hero.getAbility2();

        ability1.setWizardModif(ability1.getWizardModif()
                + LevelUpAngelConstants.WIZARD_MODIF);
        ability2.setWizardModif(ability2.getWizardModif()
                + LevelUpAngelConstants.WIZARD_MODIF);

        this.notifyObservers(hero, null, this, "AngelHelp");
        this.notifyObservers(hero, null, null, "HeroLevelUp");
    }
}
