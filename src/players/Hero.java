package players;

import common.Fields;

public abstract class Hero implements IHero {
    private int HP;
    private int XP;
    private int level;
    private Fields field;
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
    public Fields getField() {
        return this.field;
    }
    public void setField(Fields field) {
        this.field = field;
    }
    public Hero() {
        this.XP = 0;
        this.level = 0;
    }
}
