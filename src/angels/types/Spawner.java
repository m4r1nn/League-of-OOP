package angels.types;

import angels.constants.SpawnerConstants;
import angels.factory.AngelTypes;
import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;

public class Spawner extends Angel {

    //constructor
    public Spawner() {
        this.setType(AngelTypes.SPAWNER);
    }

    // visitor pattern implementation
    @Override
    public final void visitHero(final Knight hero) {
        if (hero.getHP() > 0) {
            return;
        }

        hero.setHP(SpawnerConstants.KNIGHT_HP);
    }

    @Override
    public final void visitHero(final Pyromancer hero) {
        if (hero.getHP() > 0) {
            return;
        }

        hero.setHP(SpawnerConstants.PYROMANCER_HP);
    }

    @Override
    public final void visitHero(final Rogue hero) {
        if (hero.getHP() > 0) {
            return;
        }

        hero.setHP(SpawnerConstants.ROGUE_HP);
    }

    @Override
    public final void visitHero(final Wizard hero) {
        if (hero.getHP() > 0) {
            return;
        }

        hero.setHP(SpawnerConstants.WIZARD_HP);
    }
}
