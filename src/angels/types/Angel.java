package angels.types;

import angels.factory.AngelTypes;

public abstract class Angel implements IAngel {
    private AngelTypes type;

    public final void setType(final AngelTypes type) {
        this.type = type;
    }

    public final AngelTypes getType() {
        return this.type;
    }
}
