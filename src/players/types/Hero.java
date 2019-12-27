package players.types;

import common.Coords;
import players.abilities.HeroDamage;
import players.constants.HeroConstants;
import players.factory.HeroTypes;
import players.strategies.Strategy;

public abstract class Hero implements IHero {
    private int hP;
    private int xP;
    private int level;

    private Coords coords;
    private HeroTypes type;

    private int defaultHP;
    private int maxHP;
    private int bonusHPperLevel;

    private int damageToTake;
    private float damageToTakeWithoutRaceModif;
    private int totalDamageToTake;

    private int damageOverTime = 0;
    private int roundsOfDamageOverTime = 0;
    private boolean stunned = false;
    private int roundsOfStun = 0;

    private HeroDamage ability1;
    private HeroDamage ability2;
    private Strategy strategy;

    // constructor
    public Hero() {
        this.xP = 0;
        this.level = 0;
    }

    // replace old hp with new hp after hero's level grow
    public final void restoreHP() {
        this.maxHP = this.defaultHP + this.bonusHPperLevel * this.level;
        this.hP = this.defaultHP + this.bonusHPperLevel * this.level;
    }

    // add victory xp and calculate the new level
    public final void growXP(final int opponentLevel) {
        boolean hasGrown = false;

        // calculate xp
        this.xP += Math.max(0, HeroConstants.MAX_XP_TO_GET
                - (this.level - opponentLevel) * HeroConstants.XP_TO_GET_COEF);
        int xPLevelUp = HeroConstants.XP_LIMIT_TO_GROW + this.level * HeroConstants.XP_LIMIT_COEF;

        // let the level grow until xp limit
        while (this.xP >= xPLevelUp) {
            this.level++;
            xPLevelUp += HeroConstants.XP_LIMIT_COEF;
            hasGrown = true;
        }

        // restore hero max hp if it's level has grown
        if (hasGrown) {
            this.restoreHP();
        }
    }

    public abstract void changeStrategy();

    @Override
    // used for display function
    public final String toString() {
        char typeChar;

        switch (this.type) {
            case PYROMANCER:
                typeChar = 'P';
                break;
            case KNIGHT:
                typeChar = 'K';
                break;
            case WIZARD:
                typeChar = 'W';
                break;
            case ROGUE:
                typeChar = 'R';
                break;
            default:
                throw new IllegalArgumentException();
        }

        // print hero stats in requested format
        if (this.getHP() <= 0) {
            return "" + typeChar + " dead";
        }
        return "" + typeChar + " " + this.getLevel() + " " + this.xP + " " + this.getHP() + " "
                + this.getCoords().getLin() + " " + this.getCoords().getCol();
    }

    // getters and setters
    public final HeroDamage getAbility1() {
        return ability1;
    }

    final void setAbility1(final HeroDamage ability1) {
        this.ability1 = ability1;
    }

    public final HeroDamage getAbility2() {
        return ability2;
    }

    final void setAbility2(final HeroDamage ability2) {
        this.ability2 = ability2;
    }

    public final int getRoundsOfStun() {
        return roundsOfStun;
    }

    public final void setRoundsOfStun(final int roundsOfStun) {
        this.roundsOfStun = roundsOfStun;
    }

    public final boolean isStunned() {
        return stunned;
    }

    public final void setStunned(final boolean stunned) {
        this.stunned = stunned;
    }

    public final int getRoundsOfDamageOverTime() {
        return roundsOfDamageOverTime;
    }

    public final void setRoundsOfDamageOverTime(final int roundsOfDamageOverTime) {
        this.roundsOfDamageOverTime = roundsOfDamageOverTime;
    }

    public final int getDamageOverTime() {
        return damageOverTime;
    }

    public final void setDamageOverTime(final int damageOverTime) {
        this.damageOverTime = damageOverTime;
    }

    public final int getTotalDamageToTake() {
        return totalDamageToTake;
    }

    public final void setTotalDamageToTake(final int totalDamageToTake) {
        this.totalDamageToTake = totalDamageToTake;
    }

    public final float getDamageToTakeWithoutRaceModif() {
        return damageToTakeWithoutRaceModif;
    }

    public final void setDamageToTakeWithoutRaceModif(final float damageToTakeWithoutRaceModif) {
        this.damageToTakeWithoutRaceModif = damageToTakeWithoutRaceModif;
    }

    final int getDamageToTake() {
        return damageToTake;
    }

    public final void setDamageToTake(final int damageToTake) {
        this.damageToTake = damageToTake;
    }

    final void setBonusHPperLevel(final int bonusHPperLevel) {
        this.bonusHPperLevel = bonusHPperLevel;
    }

    public final int getMaxHP() {
        return maxHP;
    }

    final void setMaxHP(final int maxHP) {
        this.maxHP = maxHP;
    }

    final void setDefaultHP(final int defaultHP) {
        this.defaultHP = defaultHP;
    }

    public final void setXP(final int xxP) {
        this.xP = xxP;
    }

    public final int getXP() {
        return this.xP;
    }

    public final HeroTypes getType() {
        return type;
    }

    final void setType(final HeroTypes type) {
        this.type = type;
    }

    public final int getHP() {
        return this.hP;
    }

    public final void setHP(final int hhP) {
        this.hP = hhP;
    }

    public final void setLevel(final int level) {
        this.level = level;
    }

    public final int getLevel() {
        return this.level;
    }

    public final Coords getCoords() {
        return this.coords;
    }

    public final void setCoords(final Coords coords) {
        this.coords = coords;
    }

    public final Strategy getStrategy() {
        return this.strategy;
    }

    public final void setStrategy(final Strategy strategy) {
        this.strategy = strategy;
    }
}
