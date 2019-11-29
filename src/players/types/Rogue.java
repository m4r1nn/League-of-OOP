package players.types;

import players.abilities.Backstab;
import players.abilities.HeroDamage;
import players.abilities.Paralysis;
import players.factory.HeroTypes;

public class Rogue extends Hero {
    public Rogue() {
        super();
        this.type = HeroTypes.ROGUE;
        this.maxHP = this.HP = this.defaultHP = 600;
        this.bonusHPperLevel = 40;
        this.ability1 = new Backstab(this);
        this.ability2 = new Paralysis(this);
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
