package players.types;

import players.abilities.HeroDamage;
import players.factory.HeroTypes;

public class Knight extends Hero {
    public Knight() {
        super();
        this.type = HeroTypes.KNIGHT;
        this.HP = this.defaultHP = 900;
        this.bonusHPperLevel = 80;
    }
    @Override
    public void takeDamage(HeroDamage enemy) {
        enemy.launchFirstAttack(this);
        enemy.launchSecondAttack(this);
    }
}
