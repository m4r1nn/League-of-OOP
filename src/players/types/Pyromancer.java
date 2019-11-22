package players.types;

import players.abilities.HeroDamage;
import players.factory.HeroTypes;

public class Pyromancer extends Hero {
    public Pyromancer() {
        super();
        this.type = HeroTypes.PYROMANCER;
        this.HP = this.defaultHP = 500;
        this.bonusHPperLevel = 50;
    }
    @Override
    public void takeDamage(HeroDamage enemy) {
        enemy.launchFirstAttack(this);
        enemy.launchSecondAttack(this);
    }
}
