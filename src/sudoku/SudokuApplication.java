package sudoku;


import javafx.application.Application;
import javafx.stage.Stage;
import sudoku.buildconfiguration.SudokuBuildLogic;
import sudoku.ui.IUserInterfaceContract;
import sudoku.ui.UserInterfaceImpl;

import java.io.IOException;
/*
Actual main class for the project.
Runs sudoku game by calling its build configuration
 */


public class SudokuApplication extends Application {
    private IUserInterfaceContract.View userInterfaceImplementation;

    @Override
    public void start(Stage primaryStage) throws IOException{
        userInterfaceImplementation = new UserInterfaceImpl(primaryStage);
        try {
            SudokuBuildLogic.build(userInterfaceImplementation);
        }catch (IOException e){
            e.printStackTrace();
            throw  e;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
