package players.types;

import players.abilities.HeroDamage;
import players.factory.HeroTypes;

public class Rogue extends Hero {
    public Rogue() {
        super();
        this.type = HeroTypes.ROGUE;
        this.HP = this.defaultHP = 600;
        this.bonusHPperLevel = 40;
    }
    @Override
    public void takeDamage(HeroDamage enemy) {
        enemy.launchFirstAttack(this);
        enemy.launchSecondAttack(this);
    }
}
