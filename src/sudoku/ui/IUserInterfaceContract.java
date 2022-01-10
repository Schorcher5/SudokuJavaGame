package sudoku.ui;

import sudoku.game.SudokuGame;
/*
Outlines the methods to be implemented in the interface,
The interface will consist of the actual sudoku game
 */
public interface IUserInterfaceContract {
    interface EventListener{
        void onSudokuInput(int x, int y, int input);
        void onDialogClick();
    }

    interface View{
        void setListener(IUserInterfaceContract.EventListener listener);
        void updateSquare(int x, int y, int input);
        void updateBoard(SudokuGame game);
        void showDialog(String message);
        void showError(String message);
    }
}
