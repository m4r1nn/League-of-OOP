package players.types;

import players.abilities.HeroDamage;
import players.factory.HeroTypes;

public class Wizard extends Hero {
    public Wizard() {
        super();
        this.type = HeroTypes.WIZARD;
        this.maxHP = this.HP = this.defaultHP = 400;
        this.bonusHPperLevel = 30;
    }
    @Override
    public void takeDamage(HeroDamage enemy1, HeroDamage enemy2) {
        enemy1.launchAttack(this);
        enemy2.launchAttack(this);
    }
}
