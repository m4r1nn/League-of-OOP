package players.types;

import players.abilities.HeroDamage;
import players.factory.HeroTypes;

public class Pyromancer extends Hero {
    public Pyromancer() {
        super();
        this.type = HeroTypes.PYROMANCER;
        this.maxHP = this.HP = this.defaultHP = 500;
        this.bonusHPperLevel = 50;
    }
    @Override
    public void takeDamage(HeroDamage enemy1, HeroDamage enemy2) {
        enemy1.launchAttack(this);
        enemy2.launchAttack(this);
    }
}
