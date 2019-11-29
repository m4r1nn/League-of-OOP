package players.abilities;

import common.Fields;
import players.types.*;

public class Paralysis extends HeroDamage {
    public Paralysis(Hero hero) {
        super(hero);
    }
    @Override
    public void setDamageWithoutRaceModif(Hero hero) {
        hero.damageToTakeWithoutRaceModif = hero.damageOverTime = 40 + 10 * this.getHeroLevel();
        hero.roundsOfDamageOverTime = hero.roundsOfStun = 3;
        hero.stunned = true;
        if (this.gameMap.getField(this.hero) == Fields.WOODS) {
            hero.damageToTakeWithoutRaceModif = hero.damageOverTime = Math.round(hero.damageToTakeWithoutRaceModif * 1.15f);
            hero.roundsOfDamageOverTime += 3;
            hero.roundsOfStun += 3;
        }

        hero.totalDamageToTake += hero.damageToTakeWithoutRaceModif;
    }
    @Override
    public void launchAttack(Pyromancer opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 1.2f);
    }
    @Override
    public void launchAttack(Knight opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 0.8f);
    }
    @Override
    public void launchAttack(Wizard opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 1.25f);
    }
    @Override
    public void launchAttack(Rogue opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 0.9f);
    }
}
