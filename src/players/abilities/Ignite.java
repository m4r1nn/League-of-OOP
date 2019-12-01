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
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * PyromancerConstants.IGNITE_PYROMANCER_MODIF));
        opponent.setDamageOverTime(Math.round(opponent.getDamageOverTime()
                * PyromancerConstants.IGNITE_PYROMANCER_MODIF));
    }

    @Override
    public final void launchAttack(final Knight opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * PyromancerConstants.IGNITE_KNIGHT_MODIF));
        opponent.setDamageOverTime(Math.round(opponent.getDamageOverTime()
                * PyromancerConstants.IGNITE_KNIGHT_MODIF));
    }

    @Override
    public final void launchAttack(final Wizard opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * PyromancerConstants.IGNITE_WIZARD_MODIF));
        opponent.setDamageOverTime(Math.round(opponent.getDamageOverTime()
                * PyromancerConstants.IGNITE_WIZARD_MODIF));
    }

    @Override
    public final void launchAttack(final Rogue opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * PyromancerConstants.IGNITE_ROGUE_MODIF));
        opponent.setDamageOverTime(Math.round(opponent.getDamageOverTime()
                * PyromancerConstants.IGNITE_ROGUE_MODIF));
    }

    @Override
    // used for debugging
    public final String toString() {
        return "Ignite";
    }
}
