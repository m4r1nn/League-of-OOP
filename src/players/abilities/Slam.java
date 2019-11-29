package players.abilities;

import common.Fields;
import players.types.*;

public class Slam extends HeroDamage {
    public Slam(Hero hero) {
        super(hero);
    }
    @Override
    public void setDamageWithoutRaceModif(Hero hero) {
        hero.damageToTakeWithoutRaceModif = 100 + 40 * this.getHeroLevel();
        if (this.gameMap.getField(this.hero) == Fields.LAND) {
            hero.damageToTakeWithoutRaceModif = Math.round(hero.damageToTakeWithoutRaceModif * 1.15f);
        }
        hero.totalDamageToTake += hero.damageToTakeWithoutRaceModif;

        hero.stunned = true;
        hero.roundsOfStun = 1;
        hero.damageOverTime = 0;
        hero.roundsOfDamageOverTime = 0;
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
}
