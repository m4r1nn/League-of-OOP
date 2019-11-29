package players.types;

import players.abilities.HeroDamage;
import players.factory.HeroTypes;

public class Rogue extends Hero {
    public Rogue() {
        super();
        this.type = HeroTypes.ROGUE;
        this.maxHP = this.HP = this.defaultHP = 600;
        this.bonusHPperLevel = 40;
    }
    @Override
    public void takeDamage(HeroDamage enemy1, HeroDamage enemy2) {
        enemy1.launchAttack(this);
        enemy2.launchAttack(this);
    }
}
