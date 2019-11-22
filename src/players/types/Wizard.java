package players.types;

import players.abilities.HeroDamage;
import players.factory.HeroTypes;

public class Wizard extends Hero {
    public Wizard() {
        super();
        this.type = HeroTypes.WIZARD;
        this.HP = this.defaultHP = 400;
        this.bonusHPperLevel = 30;
    }
    @Override
    public void takeDamage(HeroDamage enemy) {
        enemy.launchFirstAttack(this);
        enemy.launchSecondAttack(this);
    }
}
