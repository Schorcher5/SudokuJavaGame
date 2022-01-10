package sudoku.computationlogic;

import sudoku.game.Coordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static sudoku.game.SudokuGame.GRID_DIMENSION;
/*
Sees if game is solvable, if true, then returns solvable puzzle
Also clears arrays and creates new arrays to check for solvability
 */
public class GameGenerator {
    public static int[][] getNewGrid() {
        return unsolvableGame(getSolvedGame());
    }

    private static int[][] unsolvableGame(int[][] solvedGame) {
        Random random = new Random(System.currentTimeMillis());

        boolean solvable = false;
        int[][] solvableArray = new int[GRID_DIMENSION][GRID_DIMENSION];

        while(!solvable){
            SudokuUtilities.copySudokuArrayValues(solvedGame,solvableArray);

            int index = 0;

            while(index < 40){
                int xCoordinate = random.nextInt(GRID_DIMENSION);
                int yCoordinate = random.nextInt(GRID_DIMENSION);

                if(solvableArray[xCoordinate][yCoordinate] != 0){
                    solvableArray[xCoordinate][yCoordinate] = 0;
                    index++;
                }
            }

            int[][] toBeSolves = new int[GRID_DIMENSION][GRID_DIMENSION];
            SudokuUtilities.copySudokuArrayValues(solvableArray, toBeSolves);

            solvable = SudokuSolver.puzzleIsSolvable(toBeSolves);
        }
        return solvableArray;
    }

    private static int[][] getSolvedGame() {
        Random random = new Random(System.currentTimeMillis());
        int [][] newGrid = new int[GRID_DIMENSION][GRID_DIMENSION];

        for(int value = 1; value <= GRID_DIMENSION; value++){
            int allocations = 0;
            int interrupt = 0;

            List<Coordinates> allocTracker = new ArrayList<>();

            int attempts = 0;

            while(allocations < GRID_DIMENSION){
                if (interrupt > 200){
                    allocTracker.forEach(coord ->{
                        newGrid[coord.getX()][coord.getY()] = 0;
                    });

                    interrupt = 0;
                    allocations =0;
                    allocTracker.clear();
                    attempts++;

                    if(attempts > 500) {
                        clearArray(newGrid);
                        attempts =0;
                        value =1;
                    }
                }

                int xCoordinate = random.nextInt(GRID_DIMENSION);
                int yCoordinate = random.nextInt(GRID_DIMENSION);

                if( newGrid[xCoordinate][yCoordinate] == 0){
                    newGrid[xCoordinate][yCoordinate] = value;

                    if (GameLogic.sudokuIsInvalid(newGrid)){
                        newGrid[xCoordinate][yCoordinate] = 0;
                        interrupt++;
                    }else {
                        allocTracker.add(new Coordinates(xCoordinate, yCoordinate));
                        allocations++;
                    }
                }
            }
        } return newGrid;
    }

    private static void clearArray(int[][] newGrid) {
        for(int xIndex = 0; xIndex < GRID_DIMENSION; xIndex++){
            for(int yIndex = 0; yIndex < GRID_DIMENSION; yIndex++){
                newGrid[xIndex][yIndex] = 0;
            }
        }
    }
}
