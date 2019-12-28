package angels.types;

import players.types.Knight;
import players.types.Pyromancer;
import players.types.Rogue;
import players.types.Wizard;

public interface IAngel {

    // interface for angel behaviour depending on hero type --- visitor pattern
    void visitHero(Knight hero);
    void visitHero(Pyromancer hero);
    void visitHero(Rogue hero);
    void visitHero(Wizard hero);
}
