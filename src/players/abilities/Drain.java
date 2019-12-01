package players.abilities;

import common.Fields;
import players.constants.WizardConstants;
import players.types.Hero;
import players.types.Pyromancer;
import players.types.Knight;
import players.types.Wizard;
import players.types.Rogue;

public class Drain extends HeroDamage {
    // constructor
    public Drain(final Hero hero) {
        super(hero);
    }

    @Override
    public final void setDamageWithoutRaceModif(final Hero hero) {
        // calculate drain percent and base HP to damage
        float percent = WizardConstants.DRAIN_PERCENT + WizardConstants.BONUS_DRAIN_PER_LEVEL
                * this.getHeroLevel();
        float baseHP = Math.min(WizardConstants.MIN_HP_PERCENT * hero.getMaxHP(),
                (float) hero.getHP());

        // set the damage
        hero.setDamageToTakeWithoutRaceModif(percent * baseHP);

        // apply land modifier if possible
        if (this.getGameMap().getField(this.getHero()) == Fields.DESERT) {
            hero.setDamageToTakeWithoutRaceModif(hero.getDamageToTakeWithoutRaceModif()
                    * WizardConstants.LAND_MODIF);
        }

        // for deflect ability
        hero.setTotalDamageToTake(Math.round(hero.getDamageToTakeWithoutRaceModif()));
    }

    // visitor pattern implementation
    @Override
    public final void launchAttack(final Pyromancer opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * WizardConstants.DRAIN_PYROMANCER_MODIF));
    }

    @Override
    public final void launchAttack(final Knight opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * WizardConstants.DRAIN_KNIGHT_MODIF));
    }

    @Override
    public final void launchAttack(final Wizard opponent) {

        // apply race modifier
        this.setDamageWithoutRaceModif(opponent);
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * WizardConstants.DRAIN_WIZARD_MODIF));
    }

    @Override
    public final void launchAttack(final Rogue opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * WizardConstants.DRAIN_ROGUE_MODIF));
    }

    @Override
    // used for debugging
    public final String toString() {
        return "Drain";
    }
}
