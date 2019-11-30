package players.types;

import players.abilities.*;
import players.factory.HeroTypes;

public class Knight extends Hero {
    public Knight() {
        super();
        this.type = HeroTypes.KNIGHT;
        this.maxHP = this.HP = this.defaultHP = 900;
        this.bonusHPperLevel = 80;
        this.ability1 = new Execute(this);
        this.ability2 = new Slam(this);
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
