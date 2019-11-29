package players.abilities;

import players.types.*;

public interface IHeroDamage {
    public void launchAttack(Pyromancer opponent);
    public void launchAttack(Knight opponent);
    public void launchAttack(Wizard opponent);
    public void launchAttack(Rogue opponent);
}
