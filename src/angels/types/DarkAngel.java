package angels.types;

import angels.constants.DarkAngelConstants;
import angels.factory.AngelTypes;
import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;

public class DarkAngel extends Angel {

    //constructor
    public DarkAngel() {
        this.setType(AngelTypes.DARK_ANGEL);
    }

    // visitor pattern implementation
    @Override
    public final void visitHero(final Knight hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        hero.setHP(hero.getHP() + DarkAngelConstants.KNIGHT_HP);
    }

    @Override
    public final void visitHero(final Pyromancer hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        hero.setHP(hero.getHP() + DarkAngelConstants.PYROMANCER_HP);
    }

    @Override
    public final void visitHero(final Rogue hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        hero.setHP(hero.getHP() + DarkAngelConstants.ROGUE_HP);
    }

    @Override
    public final void visitHero(final Wizard hero) {
        if (hero.getHP() <= 0) {
            return;
        }

        hero.setHP(hero.getHP() + DarkAngelConstants.WIZARD_HP);
    }
}
