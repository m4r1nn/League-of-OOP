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
        // set initial race modifiers
        this.setPyromancerModif(WizardConstants.DRAIN_PYROMANCER_MODIF);
        this.setKnightModif(WizardConstants.DRAIN_KNIGHT_MODIF);
        this.setWizardModif(WizardConstants.DRAIN_WIZARD_MODIF);
        this.setRogueModif(WizardConstants.DRAIN_ROGUE_MODIF);
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
                * this.getPyromancerModif()));
    }

    @Override
    public final void launchAttack(final Knight opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * this.getKnightModif()));
    }

    @Override
    public final void launchAttack(final Wizard opponent) {

        // apply race modifier
        this.setDamageWithoutRaceModif(opponent);
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * this.getWizardModif()));
    }

    @Override
    public final void launchAttack(final Rogue opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * this.getRogueModif()));
    }

    @Override
    // used for debugging
    public final String toString() {
        return "Drain";
    }
}
