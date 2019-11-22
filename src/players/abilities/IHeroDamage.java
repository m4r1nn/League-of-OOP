package players.abilities;

import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;

public interface IHeroDamage {
    public void launchFirstAttack(Pyromancer opponent);
    public void launchSecondAttack(Pyromancer opponent);
    public void launchFirstAttack(Knight opponent);
    public void launchSecondAttack(Knight opponent);
    public void launchFirstAttack(Wizard opponent);
    public void launchSecondAttack(Wizard opponent);
    public void launchFirstAttack(Rogue opponent);
    public void launchSecondAttack(Rogue opponent);
}
