package angels.factory;

import angels.types.Angel;
import angels.types.DamageAngel;
import angels.types.DarkAngel;
import angels.types.Dracula;
import angels.types.GoodBoy;
import angels.types.LevelUpAngel;
import angels.types.LifeGiver;
import angels.types.SmallAngel;
import angels.types.Spawner;
import angels.types.TheDoomer;
import angels.types.XPAngel;

public final class AngelFactory {
    private static AngelFactory instance = null;

    // constructor
    private AngelFactory() { }

    // singleton pattern implementation
    public static AngelFactory getInstance() {
        if (instance == null) {
            instance = new AngelFactory();
        }
        return instance;
    }

    // main purpose of angel factory to create angels
    public Angel createAngel(final String type) {
        switch (type) {
            case "DamageAngel":
                return new DamageAngel();
            case "DarkAngel":
                return new DarkAngel();
            case "Dracula":
                return new Dracula();
            case "GoodBoy":
                return new GoodBoy();
            case "LevelUpAngel":
                return new LevelUpAngel();
            case "LifeGiver":
                return new LifeGiver();
            case "SmallAngel":
                return new SmallAngel();
            case "Spawner":
                return new Spawner();
            case "TheDoomer":
                return new TheDoomer();
            case "XPAngel":
                return new XPAngel();
            default:
                throw new IllegalArgumentException();
        }
    }
}
