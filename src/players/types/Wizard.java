package players.types;

import players.Hero;
import players.HeroDamage;

public class Wizard extends Hero {

    @Override
    public void takeDamage(HeroDamage enemy) {
        enemy.launchFirstAttack(this);
        enemy.launchSecondAttack(this);
    }

    private class WizardDamage implements HeroDamage {
        @Override
        public void launchFirstAttack(Pyromancer opponent) {

        }
        @Override
        public void launchSecondAttack(Pyromancer opponent) {

        }
        @Override
        public void launchFirstAttack(Knight opponent) {

        }
        @Override
        public void launchSecondAttack(Knight opponent) {

        }
        @Override
        public void launchFirstAttack(Wizard opponent) {

        }
        @Override
        public void launchSecondAttack(Wizard opponent) {

        }
        @Override
        public void launchFirstAttack(Rogue opponent) {

        }
        @Override
        public void launchSecondAttack(Rogue opponent) {

        }
    }
}
