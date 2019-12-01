package common;

public class Coords {
    // used for storing the hero position
    private int lin;
    private int col;

    // constructor
    public Coords(final int lin, final int col) {
        this.lin = lin;
        this.col = col;
    }

    // getters
    public final int getLin() {
        return this.lin;
    }
    public final int getCol() {
        return this.col;
    }

    @Override
    // used for debugging
    public final String toString() {
        return "(" + this.lin + ", " + this.col + ")";
    }

    @Override
    // used for check if 2 heroes are in the same cell
    public final boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Coords)) {
            return false;
        }
        Coords temp = (Coords) other;
        return this.lin == temp.lin && this.col == temp.col;
    }

    @Override
    public final int hashCode() {
        return super.hashCode();
    }
}
