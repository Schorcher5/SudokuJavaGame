package sudoku.game;

import java.io.IOException;
/*
template for what game memory should look like
 */
public interface Storage {
    void updateGameData(SudokuGame game) throws IOException;
    SudokuGame getGameData() throws IOException;
}
