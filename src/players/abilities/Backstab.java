package players.abilities;

import common.Fields;
import players.constants.RogueConstants;
import players.types.Hero;
import players.types.Pyromancer;
import players.types.Knight;
import players.types.Wizard;
import players.types.Rogue;

public class Backstab extends HeroDamage {
    // hits counter
    private int hits = 0;

    // constructor
    public Backstab(final Hero hero) {
        super(hero);
    }

    @Override
    public final void setDamageWithoutRaceModif(final Hero hero) {
        // set the damage and apply critical hit if possible
        if (this.hits % RogueConstants.ROUNDS_NUMBER_FOR_CRITICAL == 0
                && this.getGameMap().getField(this.getHero()) == Fields.WOODS) {
            hero.setDamageToTakeWithoutRaceModif((RogueConstants.BACKSTAB_BASE_DAMAGE
                    + RogueConstants.BONUS_BACKSTAB_PER_LEVEL * this.getHeroLevel())
                    * RogueConstants.CRITICAL_MODIF);
        } else {
            hero.setDamageToTakeWithoutRaceModif(RogueConstants.BACKSTAB_BASE_DAMAGE
                    + RogueConstants.BONUS_BACKSTAB_PER_LEVEL * this.getHeroLevel());
        }

        // apply land modifier if possible
        if (this.getGameMap().getField(this.getHero()) == Fields.WOODS) {
            hero.setDamageToTakeWithoutRaceModif(hero.getDamageToTakeWithoutRaceModif()
                    * RogueConstants.LAND_MODIF);
        }

        // for deflect ability
        hero.setTotalDamageToTake(Math.round(hero.getDamageToTakeWithoutRaceModif()));

        // count hits for critical effect
        this.hits++;
    }

    // visitor pattern implementation
    @Override
    public final void launchAttack(final Pyromancer opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * RogueConstants.BACKSTAB_PYROMANCER_MODIF));
    }

    @Override
    public final void launchAttack(final Knight opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * RogueConstants.BACKSTAB_KNIGHT_MODIF));
    }

    @Override
    public final void launchAttack(final Wizard opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * RogueConstants.BACKSTAB_WIZARD_MODIF));
    }

    @Override
    public final void launchAttack(final Rogue opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(opponent.getDamageToTakeWithoutRaceModif()
                * RogueConstants.BACKSTAB_ROGUE_MODIF));
    }

    @Override
    // used for debugging
    public final String toString() {
        return "Backstab";
    }
}
