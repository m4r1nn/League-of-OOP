package players.abilities;

import common.Fields;
import players.types.*;

public class Backstab extends HeroDamage {
    private int hits = 0;
    public Backstab(Hero hero) {
        super(hero);
    }
    @Override
    public void setDamageWithoutRaceModif(Hero hero) {
        if (this.hits % 3 == 0 && this.gameMap.getField(this.hero) == Fields.WOODS) {
            hero.damageToTakeWithoutRaceModif = (200 + 20 * this.getHeroLevel()) * 1.5f;
        } else {
            hero.damageToTakeWithoutRaceModif = 200 + 20 * this.getHeroLevel();
        }

        if (this.gameMap.getField(this.hero) == Fields.WOODS) {
            hero.damageToTakeWithoutRaceModif = hero.damageToTakeWithoutRaceModif * 1.15f;
        }
        hero.totalDamageToTake = Math.round(hero.damageToTakeWithoutRaceModif);

        this.hits++;
    }
    @Override
    public void launchAttack(Pyromancer opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 1.25f);
    }
    @Override
    public void launchAttack(Knight opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 0.9f);
    }
    @Override
    public void launchAttack(Wizard opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 1.25f);
    }
    @Override
    public void launchAttack(Rogue opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 1.2f);
    }
    @Override
    public String toString() {
        return "Backstab";
    }
}
