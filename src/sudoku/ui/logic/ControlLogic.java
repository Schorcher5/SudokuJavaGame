package sudoku.ui.logic;

import sudoku.computationlogic.GameLogic;
import sudoku.gameconstants.GameState;
import sudoku.gameconstants.Messages;
import sudoku.game.Storage;
import sudoku.game.SudokuGame;
import sudoku.ui.IUserInterfaceContract;

import java.io.IOException;
/*
Handles the basic logic of the game
Just generates a new game or an old one from memory, updates memory and checks for completion
 */
public class ControlLogic implements IUserInterfaceContract.EventListener {

    private Storage memory;
    private IUserInterfaceContract.View view;

    public ControlLogic(Storage memory, IUserInterfaceContract.View view) {
        this.memory = memory;
        this.view = view;
    }

    @Override
    public void onSudokuInput(int x, int y, int input) {
        try {
            SudokuGame gameData = memory.getGameData();
            int[][] newGridState = gameData.getCopyOfGridState();
            newGridState[x][y] = input;

            gameData = new SudokuGame(GameLogic.checkForCompletion(newGridState),newGridState);
            memory.updateGameData(gameData);

            view.updateSquare(x,y,input);

            if(gameData.getGameState() == GameState.COMPLETE){
                view.showDialog(Messages.GAME_COMPLETE);
            }
        }catch(IOException e){
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }
    }

    @Override
    public void onDialogClick() {
        try{
            memory.updateGameData(GameLogic.getNewGame());

            view.updateBoard(memory.getGameData());

        }catch(IOException e){
            view.showError(Messages.ERROR);
        }
    }
}
