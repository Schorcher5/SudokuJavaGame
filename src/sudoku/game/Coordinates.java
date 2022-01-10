package sudoku.game;

import java.util.Objects;
/*
Handles the coordinate/positioning in the game
 */
public class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if(o==null || getClass() !=o.getClass())
            return false;

        Coordinates that = (Coordinates) o;

        return x == this.x && y == that.y;

    }

    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }
}
