package players.abilities;

import common.Fields;
import players.types.*;

public class Execute extends HeroDamage {
    private int possibleDamage;
    public Execute(Hero hero) {
        super(hero);
    }
    @Override
    public void setDamageWithoutRaceModif(Hero hero) {
        hero.damageToTakeWithoutRaceModif = Math.round(200 + 0.3f * this.getHeroLevel());
        if (this.gameMap.getField(this.hero) == Fields.LAND) {
            hero.damageToTakeWithoutRaceModif = Math.round(hero.damageToTakeWithoutRaceModif * 1.15f);
        }
        if (this.getHeroLevel() <= 40) {
            this.possibleDamage = Math.round(0.2f * hero.maxHP * 0.01f * this.getHeroLevel());
        } else {
            this.possibleDamage = Math.round(0.2f * hero.maxHP * 0.01f * 40);
        }
    }
    @Override
    public void launchAttack(Pyromancer opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 1.1f);
        if (this.possibleDamage >= opponent.getHP()) {
            opponent.damageToTake = this.possibleDamage;
        }
    }
    @Override
    public void launchAttack(Knight opponent) {
        this.setDamageWithoutRaceModif(opponent);
        // modifier = 0
        if (this.possibleDamage >= opponent.getHP()) {
            opponent.damageToTake = this.possibleDamage;
        }
    }
    @Override
    public void launchAttack(Wizard opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 0.8f);
        if (this.possibleDamage >= opponent.getHP()) {
            opponent.damageToTake = this.possibleDamage;
        }
    }
    @Override
    public void launchAttack(Rogue opponent) {
        this.setDamageWithoutRaceModif(opponent);
        opponent.damageToTake = Math.round(opponent.damageToTakeWithoutRaceModif * 1.15f);
        if (this.possibleDamage >= opponent.getHP()) {
            opponent.damageToTake = this.possibleDamage;
        }
    }
}
