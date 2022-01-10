package sudoku.localstorage;

import sudoku.game.Storage;
import sudoku.game.SudokuGame;

import java.io.*;
/*
Sets-up/generates memory for the sudoku game
 */
public class LocalStorageImplementation implements Storage {
    private static File GAME_DATA = new File(System.getProperty("user.dir"), "GameData.txt");

    @Override
    public void updateGameData(SudokuGame game) throws IOException {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(GAME_DATA);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(game);
            objectOutputStream.close();
        }catch (IOException e){
            throw new IOException("Unable to access GameData");
        }
    }

    @Override
    public SudokuGame getGameData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(GAME_DATA);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        try {
            SudokuGame gameState = (SudokuGame) objectInputStream.readObject();
            objectInputStream.close();
            return gameState;
        } catch (ClassNotFoundException e){
            throw new IOException("File Not Found");
        }


    }
}
