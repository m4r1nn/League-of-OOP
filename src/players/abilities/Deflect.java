package players.abilities;

import common.Fields;
import players.types.*;

public class Deflect extends HeroDamage {
    public Deflect(Hero hero) {
        super(hero);
    }
    @Override
    public void setDamageWithoutRaceModif(Hero hero) {
        float percent;
        if (this.getHeroLevel() <= 17) {
            percent = 0.35f + 0.02f * this.getHeroLevel();
        } else {
            percent = 0.35f + 0.02f * 17;
        }
        hero.damageToTakeWithoutRaceModif = this.hero.totalDamageToTake * percent;
        if (this.gameMap.getField(this.hero) == Fields.DESERT) {
            hero.damageToTakeWithoutRaceModif = hero.damageToTakeWithoutRaceModif * 1.1f;
        }
        hero.totalDamageToTake += Math.round(hero.damageToTakeWithoutRaceModif);
    }
    @Override
    public void launchAttack(Pyromancer opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 1.3f);
    }
    @Override
    public void launchAttack(Knight opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 1.4f);
    }
    @Override
    public void launchAttack(Wizard opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = 0;
    }
    @Override
    public void launchAttack(Rogue opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 1.2f);
    }
    @Override
    public String toString() {
        return "Deflect";
    }
}
