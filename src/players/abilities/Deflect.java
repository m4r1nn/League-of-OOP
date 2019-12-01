package players.abilities;

import common.Fields;
import players.constants.WizardConstants;
import players.types.Hero;
import players.types.Pyromancer;
import players.types.Knight;
import players.types.Wizard;
import players.types.Rogue;

public class Deflect extends HeroDamage {
    // constructor
    public Deflect(final Hero hero) {
        super(hero);
    }

    @Override
    public final void setDamageWithoutRaceModif(final Hero hero) {
        // calculate deflect percent
        float percent = WizardConstants.DEFLECT_PERCENT;
        if (this.getHeroLevel() <= WizardConstants.MAX_BONUS_DEFLECT) {
            percent += WizardConstants.BONUS_DEFLECT_PER_LEVEL * this.getHeroLevel();
        } else {
            percent += WizardConstants.BONUS_DEFLECT_PER_LEVEL * WizardConstants.MAX_BONUS_DEFLECT;
        }

        // set the damage
        hero.setDamageToTakeWithoutRaceModif(this.getHero().getTotalDamageToTake() * percent);

        // apply race modifier if possible
        if (this.getGameMap().getField(this.getHero()) == Fields.DESERT) {
            hero.setDamageToTakeWithoutRaceModif(hero.getDamageToTakeWithoutRaceModif()
                    * WizardConstants.LAND_MODIF);
        }

        // for deflect ability
        hero.setTotalDamageToTake(hero.getTotalDamageToTake()
                + Math.round(hero.getDamageToTakeWithoutRaceModif()));
    }

    // visitor pattern implementation
    @Override
    public final void launchAttack(final Pyromancer opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * WizardConstants.DEFLECT_PYROMANCER_MODIF));
    }

    @Override
    public final void launchAttack(final Knight opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * WizardConstants.DEFLECT_KNIGHT_MODIF));
    }

    @Override
    public final void launchAttack(final Wizard opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * WizardConstants.DEFLECT_WIZARD_MODIF));
    }

    @Override
    public final void launchAttack(final Rogue opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * WizardConstants.DEFLECT_ROGUE_DAMAGE));
    }

    @Override
    // used for debugging
    public final String toString() {
        return "Deflect";
    }
}
