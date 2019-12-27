package players.abilities;

import common.Fields;
import players.constants.KnightConstants;
import players.types.Hero;
import players.types.Pyromancer;
import players.types.Knight;
import players.types.Wizard;
import players.types.Rogue;

public class Slam extends HeroDamage {
    // constructor
    public Slam(final Hero hero) {
        super(hero);
        this.setPyromancerModif(KnightConstants.SLAM_PYROMANCER_MODIF);
        this.setKnightModif(KnightConstants.SLAM_KNIGHT_MODIF);
        this.setWizardModif(KnightConstants.SLAM_WIZARD_MODIF);
        this.setRogueModif(KnightConstants.SLAM_ROGUE_MODIF);
    }

    @Override
    public final void setDamageWithoutRaceModif(final Hero hero) {
        // set the damage
        hero.setDamageToTakeWithoutRaceModif(KnightConstants.SLAM_BASE_DAMAGE
                + KnightConstants.BONUS_SLAM_PER_LEVEL * this.getHeroLevel());

        // apply land modifier if possible
        if (this.getGameMap().getField(this.getHero()) == Fields.LAND) {
            hero.setDamageToTakeWithoutRaceModif(hero.getDamageToTakeWithoutRaceModif()
                    * KnightConstants.LAND_MODIF);
        }

        // for deflect ability
        hero.setTotalDamageToTake(hero.getTotalDamageToTake()
                + Math.round(hero.getDamageToTakeWithoutRaceModif()));

        // apply stun effect
        hero.setStunned(true);
        // set number of rounds for stun
        hero.setRoundsOfStun(KnightConstants.ROUNDS_OF_STUN);

        // remove other passive effects
        hero.setDamageOverTime(0);
        hero.setRoundsOfDamageOverTime(0);
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
        return "Slam";
    }
}
