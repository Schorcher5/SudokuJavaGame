package sudoku.game;

import sudoku.computationlogic.SudokuUtilities;
import sudoku.gameconstants.GameState;

import java.io.Serializable;
/*
Generates the grid and gamestate(complete,active,new)
 */
public class SudokuGame implements Serializable {

    private final GameState gameState;
    private final int[][] gridState;

    public static final int GRID_DIMENSION = 9;

    public SudokuGame(GameState gameState, int[][] gridState) {
        this.gameState = gameState;
        this.gridState = gridState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int[][] getCopyOfGridState() {
        return SudokuUtilities.copyToNewArray(gridState);
    }
}
