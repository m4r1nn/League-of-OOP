package players.abilities;

import common.Fields;
import players.constants.PyromancerConstants;
import players.types.Hero;
import players.types.Pyromancer;
import players.types.Knight;
import players.types.Wizard;
import players.types.Rogue;

public class Ignite extends HeroDamage {
    // constructor
    public Ignite(final Hero hero) {
        super(hero);
        this.setPyromancerModif(PyromancerConstants.IGNITE_PYROMANCER_MODIF);
        this.setKnightModif(PyromancerConstants.IGNITE_KNIGHT_MODIF);
        this.setWizardModif(PyromancerConstants.IGNITE_WIZARD_MODIF);
        this.setRogueModif(PyromancerConstants.IGNITE_ROGUE_MODIF);
    }

    @Override
    public final void setDamageWithoutRaceModif(final Hero hero) {
        // set the damage
        hero.setDamageToTakeWithoutRaceModif(PyromancerConstants.IGNITE_BASE_DAMAGE
                + PyromancerConstants.BONUS_IGNITE_PER_LEVEL * this.getHeroLevel());

        // set the overtime damage
        hero.setDamageOverTime(PyromancerConstants.IGNITE_PASSIVE
                + PyromancerConstants.BONUS_IGNITE_PASSIVE_PER_LEVEL * this.getHeroLevel());

        // set number of rounds for overtime damage
        hero.setRoundsOfDamageOverTime(PyromancerConstants.ROUNDS_IGNITE_PASSIVE);

        // remove other passive effects
        hero.setStunned(false);
        hero.setRoundsOfStun(0);

        // apply land modifier if possible
        if (this.getGameMap().getField(this.getHero()) == Fields.VOLCANIC) {
            hero.setDamageToTakeWithoutRaceModif(hero.getDamageToTakeWithoutRaceModif()
                    * PyromancerConstants.LAND_MODIF);
            hero.setDamageOverTime(Math.round(hero.getDamageOverTime()
                    * PyromancerConstants.LAND_MODIF));
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
        opponent.setDamageToTake(Math.round(Math.round(opponent.getDamageToTakeWithoutRaceModif())
                * this.getPyromancerModif()));
        opponent.setDamageOverTime(Math.round(opponent.getDamageOverTime()
                * this.getPyromancerModif()));
    }

    @Override
    public final void launchAttack(final Knight opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(Math.round(opponent.getDamageToTakeWithoutRaceModif())
                * this.getKnightModif()));
        opponent.setDamageOverTime(Math.round(opponent.getDamageOverTime()
                * this.getKnightModif()));
    }

    @Override
    public final void launchAttack(final Wizard opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(Math.round(opponent.getDamageToTakeWithoutRaceModif())
                * this.getWizardModif()));
        opponent.setDamageOverTime(Math.round(opponent.getDamageOverTime()
                * this.getWizardModif()));
    }

    @Override
    public final void launchAttack(final Rogue opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(Math.round(opponent.getDamageToTakeWithoutRaceModif())
                * this.getRogueModif()));
        opponent.setDamageOverTime(Math.round(opponent.getDamageOverTime()
                * this.getRogueModif()));
    }

    @Override
    // used for debugging
    public final String toString() {
        return "Ignite";
    }
}
