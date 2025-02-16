
public class SudokuSolver {
    // Topic: Sudoku Solver

    public static boolean sudokusolver(int sudoku[][], int row, int col) {
        //Base Case
        if (row == 9) {
            return true;
        }
        //Recursion
        int nextrow = row, nextcol = col + 1; //Obtain next row and column for recursion
        if (col + 1 == 9) { //if Column has reached to the end, increment the row and start from 1st column
            nextrow = row + 1;
            nextcol = 0;
        }
        if (sudoku[row][col] != 0) { //If there is a number already present, no need to replace it, call for next values.
            return sudokusolver(sudoku, nextrow, nextcol);
        } else {
            for (int digit = 1; digit <= 9; digit++) { //If there is no digit present check for correct digit to be placed form 1 to 9
                if (isSafe(sudoku, row, col, digit)) { //check if isSafe() returns true 
                    sudoku[row][col] = digit; //Store the digit
                    if (sudokusolver(sudoku, nextrow, nextcol)) { //Check if solution is available for next row
                        return true;
                    }
                    sudoku[row][col] = 0;
                }
            }
        }
        return false;
    }

    // To check whether placing the digit is safe or not!
    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        // check if same digit is present in column and column
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit || sudoku[row][i] == digit) {
                return false;
            }
        }
        // check if same digit is present in 3x3 grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    // Function to print the solved sudoku
    public static void printsudoku(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Topic: Sudoku Solver
        // Input Sudoku
        int sudoku[][] = {{0, 0, 8, 0, 0, 0, 0, 0, 0}, {4, 9, 0, 1, 5, 7, 0, 0, 2}, {0, 0, 3, 0, 0, 4, 1, 9, 0}, {1, 8, 5, 0, 6, 0, 0, 6, 0}, {0, 0, 0, 0, 2, 0, 0, 6, 0}, {9, 6, 0, 4, 0, 5, 3, 0, 0}, {0, 3, 0, 0, 7, 2, 0, 0, 4}, {0, 4, 9, 0, 3, 0, 0, 5, 7}, {8, 2, 7, 0, 0, 9, 0, 1, 3}};
        if (sudokusolver(sudoku, 0, 0)) {
            System.out.println("Solution exist: ");
            printsudoku(sudoku);
        } else {
            System.out.println("Solution does not exist: ");
        }
    }
}
