package angels.types;

import angels.factory.AngelTypes;
import common.Coords;
import specialcharacters.Subject;

public abstract class Angel extends Subject implements IAngel {
    private AngelTypes type;
    private String stringType;
    private Coords coords;

    public Angel(final Coords coords) {
        this.coords = coords;
    }

    public final Coords getCoords() {
        return this.coords;
    }

    public final void setType(final AngelTypes type) {
        this.type = type;
    }

    public final AngelTypes getType() {
        return this.type;
    }

    public final void setStringType(final String stringType) {
        this.stringType = stringType;
    }

    public final String getStringType() {
        return this.stringType;
    }
}
