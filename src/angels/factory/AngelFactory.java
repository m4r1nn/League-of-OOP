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
import common.Coords;
import specialcharacters.Observer;

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
    public Angel createAngel(final String type, final Coords coords, final Observer observer) {
        switch (type) {
            case "DamageAngel":
                return new DamageAngel(coords, observer);
            case "DarkAngel":
                return new DarkAngel(coords, observer);
            case "Dracula":
                return new Dracula(coords, observer);
            case "GoodBoy":
                return new GoodBoy(coords, observer);
            case "LevelUpAngel":
                return new LevelUpAngel(coords, observer);
            case "LifeGiver":
                return new LifeGiver(coords, observer);
            case "SmallAngel":
                return new SmallAngel(coords, observer);
            case "Spawner":
                return new Spawner(coords, observer);
            case "TheDoomer":
                return new TheDoomer(coords, observer);
            case "XPAngel":
                return new XPAngel(coords, observer);
            default:
                throw new IllegalArgumentException();
        }
    }
}
