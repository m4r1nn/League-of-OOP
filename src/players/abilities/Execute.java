package players.abilities;

import common.Fields;
import players.constants.KnightConstants;
import players.types.Hero;
import players.types.Pyromancer;
import players.types.Knight;
import players.types.Wizard;
import players.types.Rogue;

public class Execute extends HeroDamage {
    private int possibleDamage;

    // constructor
    public Execute(final Hero hero) {
        super(hero);
        // set initial race modifiers
        this.setPyromancerModif(KnightConstants.EXECUTE_PYROMANCER_MODIF);
        this.setKnightModif(KnightConstants.EXECUTE_KNIGHT_MODIF);
        this.setWizardModif(KnightConstants.EXECUTE_WIZARD_MODIF);
        this.setRogueModif(KnightConstants.EXECUTE_ROGUE_MODIF);
    }

    @Override
    public final void setDamageWithoutRaceModif(final Hero hero) {
        // set the damage
        hero.setDamageToTakeWithoutRaceModif(KnightConstants.EXECUTE_BASE_DAMAGE
                + KnightConstants.BONUS_EXECUTE_PER_LEVEL * this.getHeroLevel());

        // apply land modifier if possible
        if (this.getGameMap().getField(this.getHero()) == Fields.LAND) {
            hero.setDamageToTakeWithoutRaceModif(hero.getDamageToTakeWithoutRaceModif()
                    * KnightConstants.LAND_MODIF);
        }

        // for deflect ability
        hero.setTotalDamageToTake(Math.round(hero.getDamageToTakeWithoutRaceModif()));

        // calculate the special possible punch for knight
        float percent = KnightConstants.HP_LIMIT_PERCENT;
        if (this.getHeroLevel() <= KnightConstants.MAX_LEVEL_BONUS) {
            percent += KnightConstants.DEFAULT_PERCENT * this.getHeroLevel();
        } else {
            percent += KnightConstants.DEFAULT_PERCENT * KnightConstants.MAX_LEVEL_BONUS;
        }
        this.possibleDamage = Math.round(hero.getMaxHP() * percent);
    }

    // visitor pattern implementation
    @Override
    public final void launchAttack(final Pyromancer opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(Math.round(opponent.getDamageToTakeWithoutRaceModif())
                * this.getPyromancerModif()));

        // check for special punch
        if (this.possibleDamage >= opponent.getHP()) {
            opponent.setDamageToTake(this.possibleDamage);
        }
    }

    @Override
    public final void launchAttack(final Knight opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(Math.round(opponent.getDamageToTakeWithoutRaceModif())
                * this.getKnightModif()));

        // check for special punch
        if (this.possibleDamage >= opponent.getHP()) {
            opponent.setDamageToTake(this.possibleDamage);
        }
    }

    @Override
    public final void launchAttack(final Wizard opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(Math.round(opponent.getDamageToTakeWithoutRaceModif())
                * this.getWizardModif()));

        // check for special punch
        if (this.possibleDamage >= opponent.getHP()) {
            opponent.setDamageToTake(this.possibleDamage);
        }
    }

    @Override
    public final void launchAttack(final Rogue opponent) {
        this.setDamageWithoutRaceModif(opponent);

        // apply race modifier
        opponent.setDamageToTake(Math.round(Math.round(opponent.getDamageToTakeWithoutRaceModif())
                * this.getRogueModif()));

        // check for special punch
        if (this.possibleDamage >= opponent.getHP()) {
            opponent.setDamageToTake(this.possibleDamage);
        }
    }

    @Override
    // used for debugging
    public final String toString() {
        return "Execute";
    }
}
