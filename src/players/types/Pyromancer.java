package players.types;

import players.abilities.Fireblast;
import players.abilities.HeroDamage;
import players.abilities.Ignite;
import players.factory.HeroTypes;

public class Pyromancer extends Hero {
    public Pyromancer() {
        super();
        this.type = HeroTypes.PYROMANCER;
        this.maxHP = this.HP = this.defaultHP = 500;
        this.bonusHPperLevel = 50;
        this.ability1 = new Fireblast(this);
        this.ability2 = new Ignite(this);
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
