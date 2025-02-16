
public class Backtracking {

    public static void printArr(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Topic: Bactracking in arrays
    public static void ChangeArr(int arr[], int i, int val) {
        // Info: Base case
        if (i == arr.length) {
            printArr(arr);
            return;
        }
        arr[i] = val;
        ChangeArr(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;
    }

    // Topic: Subsets
    // public static int count = 0;
    /* public static void findSubsets(String str, StringBuilder ans, int i) {
        // Info: Base Case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
                count++;
            }
            return;
        }
        // Info: Yes Choice
        findSubsets(str, ans.append(str.charAt(i)), i + 1);
        ans.deleteCharAt(ans.length() - 1);
        // Info: No Choice
        findSubsets(str, ans, i + 1);
    } */

    // Topic: Find Permutations
    public static void findPermutations(String str, String ans) {
        // Info: Base Case
        if (str.length() == 0) {
            System.out.println(ans);
        }
        // Info: Recursion
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String Newstr = str.substring(0, i) + str.substring(i + 1);
            findPermutations(Newstr, ans + curr);
        }
    }

    // Topic: N Queens with total number of ways
    /* static int count = 0;

    public static void nQueens(char[][] board, int row) {
        // Info: Base Case
        if (row == board.length) {
            printBoard(board);
            count++;
            return;
        }
        // Info: Column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = 'x';
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col) {
        // Info: Vertically upward check
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Info: Left diagonally upward check
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Info: Right diagonally upward check
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }

        }
        return true;
    } */
    // Topic: N Queens-2
    public static boolean nQueens2(char[][] board, int row) {
        // Info: Base Case
        if (row == board.length) {
            return true;
        }
        // Info: Column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if (nQueens2(board, row + 1)) {
                    return true;
                }
                board[row][j] = 'x';
            }
        }
        return false;
    }

    public static boolean isSafe(char[][] board, int row, int col) {
        // Info: Vertically upward check
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Info: Left diagonally upward check
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Info: Right diagonally upward check
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }

        }
        return true;
    }

    public static void printBoard(char[][] board) {
        System.out.println("--------- CHESS BOARD ---------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Topic: Gridways
    public static int gridways(int i, int j, int n, int m) {
        // info: Base Case
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }
        int w1 = gridways(i + 1, j, n, m);
        int w2 = gridways(i, j + 1, n, m);
        return w1 + w2;
    }

    // Topic: Sudoku Solver
    public static boolean sudokusolver(int sudoku[][], int row, int col) {
        // Info: Base Case
        if (row == 9) {
            return true;
        }
        // Info: Recursion
        int nextrow = row, nextcol = col + 1;
        if (col + 1 == 9) {
            nextrow = row + 1;
            nextcol = 0;
        }
        if (sudoku[row][col] != 0) {
            return sudokusolver(sudoku, nextrow, nextcol);
        }
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokusolver(sudoku, nextrow, nextcol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        // Info: column
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }
        // Info: Row
        for (int j = 0; j <= 8; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }
        // Info: Grid
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
    public static void printsudoku(int [][]sudoku){
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
    /* public static void printBoard(char [][]board){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    } */

    public static void main(String[] args) {
        // Topic: Bactracking in arrays
        /* int arr[] = new int[5];
        ChangeArr(arr, 0, 1);
        printArr(arr); */
        // Topic: Subsets
        /* String str = "abc";
        findSubsets(str,new StringBuilder(), 0);
        System.out.println(count); */
        // Topic: Permutations
        /* findPermutations(str, ""); */
        // Topic: N Queens with total number of ways
        int n = 7;
        char[][] board = new char[n][n];
        /* for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }
        nQueens(board, 0);
        System.out.println("Total ways: " + count); */
        // Topic: N Queens-2
        if(nQueens2(board, 0)){
            System.out.println("Solution is possible");
            printBoard(board);
        }
        else{
            System.out.println("Solution is not possible");
        }
        // Topic: Gridways
        /* int n = 3, m = 3;
        System.out.println(gridways(0, 0, n, m)); */
        // Topic: Sudoku Solver
        /* int sudoku[][] = {{0, 0, 8, 0, 0, 0, 0, 0, 0}, {4, 9, 0, 1, 5, 7, 0, 0, 2}, {0, 0, 3, 0, 0, 4, 1, 9, 0}, {1, 8, 5, 0, 6, 0, 0, 6, 0}, {0, 0, 0, 0, 2, 0, 0, 6, 0}, {9, 6, 0, 4, 0, 5, 3, 0, 0}, {0, 3, 0, 0, 7, 2, 0, 0, 4}, {0, 4, 9, 0, 3, 0, 0, 5, 7}, {8, 2, 7, 0, 0, 9, 0, 1, 3}};
        if (sudokusolver(sudoku, 0, 0)) {
            System.out.println("Solution exist: ");
            printsudoku(sudoku);
        } else {
            System.out.println("Solution does not exist: ");
        } */
    }
}
