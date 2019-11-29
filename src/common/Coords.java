package common;

public class Coords {
    private int x;
    private int y;
    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return this.y;
    }
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
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
        if (this.x == temp.x && this.y == temp.y) {
            return true;
        }
        return false;
    }
}
