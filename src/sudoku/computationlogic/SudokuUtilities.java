package sudoku.computationlogic;

import static sudoku.game.SudokuGame.GRID_DIMENSION;
/*
Defines a couple of methods to help copy and existing 2D array
 */
public class SudokuUtilities {
    public static void copySudokuArrayValues(int[][] oldArray, int[][] newArray){

        for(int xIndex = 0; xIndex < GRID_DIMENSION; xIndex++){
            for(int yIndex = 0; yIndex < GRID_DIMENSION; yIndex++){
                newArray[xIndex][yIndex] = oldArray[xIndex][yIndex];
            }
        }
    }

    public static int[][] copyToNewArray(int[][] oldArray){
        int[][] newArray = new int[GRID_DIMENSION][GRID_DIMENSION];

        for(int xIndex = 0; xIndex < GRID_DIMENSION; xIndex++){
            for(int yIndex = 0; yIndex < GRID_DIMENSION; yIndex++){
                newArray[xIndex][yIndex] = oldArray[xIndex][yIndex];
            }
        } return newArray;
    }
}
