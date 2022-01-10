package sudoku.buildconfiguration;

import sudoku.computationlogic.GameLogic;
import sudoku.localstorage.LocalStorageImplementation;
import sudoku.game.Storage;
import sudoku.game.SudokuGame;
import sudoku.ui.IUserInterfaceContract;
import sudoku.ui.logic.ControlLogic;

import java.io.IOException;

/*
How the game is built, not much to say here
 */

public class SudokuBuildLogic {

    public static void build(IUserInterfaceContract.View userInterface) throws IOException{
        SudokuGame initialState;
        Storage storage = new LocalStorageImplementation();

        try {
            initialState = storage.getGameData();

        }catch (IOException e){
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);

        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
