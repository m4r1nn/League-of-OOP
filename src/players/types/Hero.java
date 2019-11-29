package players.types;

import common.Coords;
import players.factory.HeroTypes;

public abstract class Hero implements IHero {
    protected int HP;
    protected int XP;
    protected int level;
    protected Coords coords;
    protected HeroTypes type;
    protected int defaultHP;
    public int maxHP;
    protected int bonusHPperLevel;
    public int damageToTake;
    public int damageToTakeWithoutRaceModif;
    public int totalDamageToTake;
    public int damageOverTime = 0;
    public int roundsOfDamageOverTime = 0;
    public boolean stunned = false;
    public int roundsOfStun = 0;
    public int getHP() {
        return this.HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public int getXP() {
        return this.XP;
    }
    public void setXP(int XP) {
        this.XP = XP;
    }
    public int getLevel() {
        return this.level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public Coords getCoords() {
        return this.coords;
    }
    public void setCoords(Coords coords) {
        this.coords = coords;
    }
    public Hero() {
        this.XP = 0;
        this.level = 0;
    }
    public void restoreHP() {
        this.maxHP = this.HP = this.defaultHP + this.bonusHPperLevel * this.level;
    }
    public void growXP(int opponentLevel) {
        boolean hasGrown = false;
        this.XP += Math.max(0, 200 - (this.level - opponentLevel) * 40);
        int XPLevelUp = 250 + this.level * 50;
        while (this.XP > XPLevelUp) {
            this.level++;
            XPLevelUp += 50;
            hasGrown = true;
        }
        if (hasGrown) {
            this.restoreHP();
        }
    }
    @Override
    public void move() {

    }
    @Override
    public String toString() {
        return this.type.toString() + " " + this.coords.toString();
    }
}
