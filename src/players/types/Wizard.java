package players.types;

import players.abilities.Deflect;
import players.abilities.Drain;
import players.abilities.HeroDamage;
import players.factory.HeroTypes;

public class Wizard extends Hero {
    public Wizard() {
        super();
        this.type = HeroTypes.WIZARD;
        this.maxHP = this.HP = this.defaultHP = 400;
        this.bonusHPperLevel = 30;
        this.ability1 = new Drain(this);
        this.ability2 = new Deflect(this);
    }
    @Override
    public void takeDamage(HeroDamage enemy1, HeroDamage enemy2) {
        enemy1.launchAttack(this);
        int totalDamage = this.damageToTake;
        enemy2.launchAttack(this);
        totalDamage += this.damageToTake;
        this.setHP(this.getHP() - totalDamage);
    }
}
