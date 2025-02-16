
import java.util.*;

public class Questions {

    // Question 1: Rat in a Maze
    public static void ratMaze(int x, int y, int[][] maze, int n, String curr) {
        if (x < 0 || y < 0 || x == n || y == n || maze[x][y] == 0) {
            return;
        }
        if (x == n - 1 && y == n - 1) {
            System.out.println(curr);
            return;  // Don't forget this return to stop further recursion
        }
        // Mark the current cell as visited
        maze[x][y] = 0;

        // Down
        ratMaze(x + 1, y, maze, n, curr + 'D');
        // Left
        ratMaze(x, y - 1, maze, n, curr + 'L');
        // Right
        ratMaze(x, y + 1, maze, n, curr + 'R');
        // Up
        ratMaze(x - 1, y, maze, n, curr + 'U');

        // Unmark the current cell to backtrack
        maze[x][y] = 1;
    }

    // Questions 2: Keypad Combinations
    final static char[][] L = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
    {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
    {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public static void KeypadComb(String input) {
        int len = input.length();
        if (len == 0) {
            System.out.println(" ");
            return;
        }
        recursionkey(input, len, new StringBuilder(), 0);
    }

    public static void recursionkey(String input, int len, StringBuilder sb, int i) {
        if (i == len) {
            System.out.println(sb.toString());
        } else {
            char[] letters = L[Character.getNumericValue(input.charAt(i))];
            for (int j = 0; j < letters.length; j++) {
                recursionkey(input, len, new StringBuilder(sb.append(letters[j])), i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    // Questions 3: Knight's Tour

    public static boolean isSafe(int x, int y, int sol[][], int N) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    public static boolean KnightsTour(int N) {
        int sol[][] = new int[N][N];
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                sol[i][j] = -1;
            }
        }
        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
        sol[0][0] = 0;
        if (!solveKtUtil(0, 0, 1, sol, xMove, yMove, N)) {
            System.out.println("Solution does not exist!");
            return false;
        } else {
            printSol(sol);
        }
        return true;
    }

    public static boolean solveKtUtil(int x, int y, int movei, int[][] sol, int[] xMove, int[] yMove, int N) {
        int k, next_x, next_y;
        if (movei == N * N) {
            return true;
        }
        for (k = 0; k < N; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol, N)) {
                sol[next_x][next_y] = movei;
                if (solveKtUtil(next_x, next_y, movei + 1, sol, xMove, yMove, N)) {
                    return true;
                } else {
                    sol[next_x][next_y] = -1;
                }
            }
        }
        return false;
    }

    public static void printSol(int[][] board) {
        System.out.println("--------- CHESS BOARD ---------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
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

    // Topic: ArraList
    // Questions 1: Check whether given list is monotonic
    public static boolean monotonic(ArrayList<Integer> list) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                inc = false;
            }
            if (list.get(i) < list.get(i + 1)) {
                dec = false;
            }
        }
        return inc || dec;
    }

    // Questions 2: Check for lonely numbers
    public static void lonelynums(ArrayList<Integer> nums) {
        ArrayList<Integer> list = new ArrayList<>();
        if (nums.isEmpty()) {
            return;
        }
        if (nums.size() == 1) {
            list.add(nums.get(0));
            return;
        }
        if (nums.get(1) != nums.get(0) + 1) {
            list.add(nums.get(0));
        }
        for (int i = 1; i < nums.size() - 1; i++) {
            if (nums.get(i - 1) != nums.get(i) - 1 && nums.get(i + 1) != nums.get(i) + 1) {
                list.add(nums.get(i));
            }
        }
        if (nums.get(nums.size() - 2) != nums.get(nums.size() - 1) - 1) {
            list.add(nums.get(nums.size() - 1));
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // Question 1: Rat in a Maze
        /* int maze[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
        ratMaze(0, 0, maze, 4, ""); */
        // Questions 2: Keypad Combinations
        // KeypadComb("24");
        // Questions 3: Knight's Tour
        // KnightsTour(7);
        // Topic: ArrayList
        // Questions 1: Check whether given list is monotonic
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        System.out.println(monotonic(list));
        // Questions 2: Check for lonely numbers
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(6);
        nums.add(5);
        nums.add(8);
        lonelynums(nums);
    }
}
