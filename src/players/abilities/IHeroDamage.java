package players.abilities;

import players.types.Pyromancer;
import players.types.Knight;
import players.types.Wizard;
import players.types.Rogue;

public interface IHeroDamage {
    // interface for heroes abilities --- visitor pattern
    void launchAttack(Pyromancer opponent);
    void launchAttack(Knight opponent);
    void launchAttack(Wizard opponent);
    void launchAttack(Rogue opponent);
}
