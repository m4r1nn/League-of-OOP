package players.abilities;

import common.Fields;
import players.constants.PyromancerConstants;
import players.types.Hero;
import players.types.Pyromancer;
import players.types.Knight;
import players.types.Wizard;
import players.types.Rogue;

public class Fireblast extends HeroDamage {
    // constructor
    public Fireblast(final Hero hero) {
        super(hero);
        this.setPyromancerModif(PyromancerConstants.FIREBLAST_PYROMANCER_MODIF);
        this.setKnightModif(PyromancerConstants.FIREBLAST_KNIGHT_MODIF);
        this.setWizardModif(PyromancerConstants.FIREBLAST_WIZARD_MODIF);
        this.setRogueModif(PyromancerConstants.FIREBLAST_ROGUE_MODIF);
    }

    @Override
    public final void setDamageWithoutRaceModif(final Hero hero) {
        // set the damage
        hero.setDamageToTakeWithoutRaceModif(PyromancerConstants.FIREBLAST_BASE_DAMAGE
                + PyromancerConstants.BONUS_FIREBLAST_PERLEVEL * this.getHeroLevel());

        // apply land modifier if possible
        if (this.getGameMap().getField(this.getHero()) == Fields.VOLCANIC) {
            hero.setDamageToTakeWithoutRaceModif(hero.getDamageToTakeWithoutRaceModif()
                    * PyromancerConstants.LAND_MODIF);
        }

        // for deflect ability
        hero.setTotalDamageToTake(Math.round(hero.getDamageToTakeWithoutRaceModif()));
    }

    // visitor pattern implementation
    @Override
    public final void launchAttack(final Pyromancer opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(Math.round(opponent.getDamageToTakeWithoutRaceModif())
                * this.getPyromancerModif()));
    }

    @Override
    public final void launchAttack(final Knight opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(Math.round(opponent.getDamageToTakeWithoutRaceModif())
                * this.getKnightModif()));
    }

    @Override
    public final void launchAttack(final Wizard opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(Math.round(opponent.getDamageToTakeWithoutRaceModif())
                * this.getWizardModif()));
    }

    @Override
    public final void launchAttack(final Rogue opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(Math.round(opponent.getDamageToTakeWithoutRaceModif())
                * this.getRogueModif()));
    }

    @Override
    // used for debugging
    public final String toString() {
        return "Fireblast";
    }
}
