package players.abilities;

import common.Fields;
import players.constants.RogueConstants;
import players.types.Hero;
import players.types.Pyromancer;
import players.types.Knight;
import players.types.Wizard;
import players.types.Rogue;

public class Paralysis extends HeroDamage {
    // constructor
    public Paralysis(final Hero hero) {
        super(hero);
    }

    @Override
    public final void setDamageWithoutRaceModif(final Hero hero) {
        // set damage
        hero.setDamageToTakeWithoutRaceModif(RogueConstants.PARALYSIS_BASIC_DAMAGE
                + RogueConstants.BONUS_PARALYSIS_PER_LEVEL * this.getHeroLevel());

        // set overtime damage
        hero.setDamageOverTime(RogueConstants.PARALYSIS_BASIC_DAMAGE
                + RogueConstants.BONUS_PARALYSIS_PER_LEVEL * this.getHeroLevel());

        // stun the opponent
        hero.setStunned(true);

        // set number of rounds for overtime damage and stun
        hero.setRoundsOfDamageOverTime(RogueConstants.ROUNDS_NUMBER_OF_PARALYSE);
        hero.setRoundsOfStun(RogueConstants.ROUNDS_NUMBER_OF_PARALYSE);

        // apply land modifier if possible
        if (this.getGameMap().getField(this.getHero()) == Fields.WOODS) {
            hero.setDamageToTakeWithoutRaceModif(hero.getDamageToTakeWithoutRaceModif()
                    * RogueConstants.LAND_MODIF);
            hero.setDamageOverTime(Math.round(hero.getDamageToTakeWithoutRaceModif()
                    * RogueConstants.LAND_MODIF));
            hero.setRoundsOfDamageOverTime(hero.getRoundsOfDamageOverTime()
                    + RogueConstants.ROUNDS_NUMBER_OF_PARALYSE);
            hero.setRoundsOfStun(hero.getRoundsOfStun()
                    + RogueConstants.ROUNDS_NUMBER_OF_PARALYSE);
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
                * RogueConstants.PARALYSIS_PYROMANCER_MODIF));
        opponent.setDamageOverTime(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * RogueConstants.PARALYSIS_PYROMANCER_MODIF));
    }

    @Override
    public final void launchAttack(final Knight opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * RogueConstants.PARALYSIS_KNIGHT_MODIF));
        opponent.setDamageOverTime(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * RogueConstants.PARALYSIS_KNIGHT_MODIF));
    }

    @Override
    public final void launchAttack(final Wizard opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * RogueConstants.PARALYSIS_WIZARD_MODIF));
        opponent.setDamageOverTime(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * RogueConstants.PARALYSIS_WIZARD_MODIF));
    }

    @Override
    public final void launchAttack(final Rogue opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * RogueConstants.PARALYSIS_ROGUE_MODIF));
        opponent.setDamageOverTime(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * RogueConstants.PARALYSIS_ROGUE_MODIF));
    }

    @Override
    // used for debuggings
    public final String toString() {
        return "Paralysis";
    }
}
