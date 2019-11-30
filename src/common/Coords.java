package common;

public class Coords {
    private int lin;
    private int col;
    public Coords(int lin, int col) {
        this.lin = lin;
        this.col = col;
    }
    public int getLin() {
        return this.lin;
    }
    public void setLin(int lin) {
        this.lin = lin;
    }
    public int getCol() {
        return this.col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    @Override
    public String toString() {
        return "(" + this.lin + ", " + this.col + ")";
    }
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Coords)) {
            return false;
        }
        Coords temp = (Coords)other;
        if (this.lin == temp.lin && this.col == temp.col) {
            return true;
        }
        return false;
    }
}
