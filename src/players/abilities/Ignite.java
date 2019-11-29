package players.abilities;

import common.Fields;
import players.types.*;

public class Ignite extends HeroDamage {
    public Ignite(Hero hero) {
        super(hero);
    }
    @Override
    public void setDamageWithoutRaceModif(Hero hero) {
        hero.damageToTakeWithoutRaceModif = Math.round(150 + 0.2f * this.getHeroLevel());
        if (this.gameMap.getField(this.hero) == Fields.VOLCANIC) {
            hero.damageToTakeWithoutRaceModif = Math.round(hero.damageToTakeWithoutRaceModif * 1.25f);
        }

        hero.damageOverTime = Math.round(50 + 30 * this.getHeroLevel());
        hero.roundsOfDamageOverTime = 2;
    }
    @Override
    public void launchAttack(Pyromancer opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 0.9f);
        opponent.damageOverTime = Math.round(opponent.damageOverTime * 0.9f);
    }
    @Override
    public void launchAttack(Knight opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 1.2f);
        opponent.damageOverTime = Math.round(opponent.damageOverTime * 1.2f);
    }
    @Override
    public void launchAttack(Wizard opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 1.05f);
        opponent.damageOverTime = Math.round(opponent.damageOverTime * 1.05f);
    }
    @Override
    public void launchAttack(Rogue opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 0.8f);
        opponent.damageOverTime = Math.round(opponent.damageOverTime * 0.8f);
    }
}
