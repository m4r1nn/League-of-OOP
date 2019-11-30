package players.abilities;

import common.Fields;
import players.types.*;

public class Fireblast extends HeroDamage {
    public Fireblast(Hero hero) {
        super(hero);
    }
    @Override
    public void setDamageWithoutRaceModif(Hero hero) {
        hero.damageToTakeWithoutRaceModif = 350 + 50 * this.getHeroLevel();
        if (this.gameMap.getField(this.hero) == Fields.VOLCANIC) {
            hero.damageToTakeWithoutRaceModif = hero.damageToTakeWithoutRaceModif * 1.25f;
        }
        hero.totalDamageToTake = Math.round(hero.damageToTakeWithoutRaceModif);
    }
    @Override
    public void launchAttack(Pyromancer opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 0.9f);
    }
    @Override
    public void launchAttack(Knight opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 1.2f);
    }
    @Override
    public void launchAttack(Wizard opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 1.05f);
    }
    @Override
    public void launchAttack(Rogue opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 0.8f);
    }
    @Override
    public String toString() {
        return "Fireblast";
    }
}
