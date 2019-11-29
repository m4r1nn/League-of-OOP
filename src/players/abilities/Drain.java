package players.abilities;

import common.Fields;
import players.types.*;

public class Drain extends HeroDamage {
    public Drain(Hero hero) {
        super(hero);
    }
    @Override
    public void setDamageWithoutRaceModif(Hero hero) {
        float percent = 0.2f + 0.05f * this.getHeroLevel();
        float baseHP = Math.min(0.3f * hero.maxHP, (float)hero.getHP());
        hero.damageToTakeWithoutRaceModif = Math.round(percent * baseHP);
        if (this.gameMap.getField(this.hero) == Fields.DESERT) {
            hero.damageToTakeWithoutRaceModif = Math.round(hero.damageToTakeWithoutRaceModif * 1.1f);
        }
        hero.totalDamageToTake = hero.damageToTakeWithoutRaceModif;
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
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 0.05f);
    }
    @Override
    public void launchAttack(Rogue opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 0.8f);
    }
}
