// 2D ARRAYS ------------------------------------------------>
public class darrays {

    public static void printarr(int array[][], int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

// // LARGEST AND SMALLEST IN 2D ARRAY ------------------------------------------------>
    public static void largestsmallest(int array[][]) {
        int large = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] > large) {
                    large = array[i][j];
                }
                if (array[i][j] < small) {
                    small = array[i][j];
                }
            }
        }
        System.out.println("Largest element in given array: " + large);
        System.out.println("Smallest element in given array: " + small);
    }

// // BOOLEAN SEARCH ------------------------------------------------>
    public static boolean search(int array[][], int n, int m, int key) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == key) {
                    System.out.print("Element found at cell:  " + "(" + i + "," + j + ")");
                    return true;
                }
            }
        }
        System.out.print("Element not found!");
        return false;
    }

// // SPIRAL MATRIX ------------------------------------------------>
    public static void spiralmatrix(int matrix[][]) {
        int startrow = 0;
        int startcol = 0;
        int endrow = matrix.length - 1;
        int endcol = matrix[0].length - 1;

        while (startrow <= endrow && startcol <= endcol) {
            // TOP
            for (int i = startcol; i <= endcol; i++) {
                System.out.print(matrix[startrow][i] + " ");
            }

            // RIGHT
            for (int j = startrow + 1; j <= endrow; j++) {
                System.out.print(matrix[j][endcol] + " ");
            }

            // BOTTOM
            for (int i = endcol - 1; i >= startcol; i--) {
                if (startrow == endrow) {
                    break;
                }
                System.out.print(matrix[endrow][i] + " ");
            }

            // LEFT
            for (int j = endrow - 1; j > startrow; j--) {
                if (startcol == endcol) {
                    break;
                }
                System.out.print(matrix[j][startcol] + " ");
            }

            startrow++;
            startcol++;
            endrow--;
            endcol--;
        }
    }

// // DIAGONAL SUM ------------------------------------------------>
    public static void diagonalsum(int matrix[][]) {
        int sum = 0;

        // Bruteforce Approach, Time complexity(O(n^2)):-
        /* for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // PRIMARY DIAGONAL
                if (i == j) {
                    sum += matrix[i][j];
                } // SECONDARY DIAGONAL
                else if (i + j == matrix.length - 1) {
                    sum += matrix[i][j];
                }
            }
        }
        System.out.println("Diagonal Sum:- " + sum); */
        // Optimized Approach, Time complexity(O(n)):-
        for (int i = 0; i < matrix.length; i++) {
            // Primary Diagonal
            sum += matrix[i][i];

            // Secondary Diagonal
            if (i != matrix.length - 1 - i) {
                sum += matrix[i][matrix.length - 1 - i];
            }
        }
        System.out.println("Diagonal sum:- " + sum);
    }

// // STAIRCASE SEARCH ------------------------------------------------>
    public static boolean staircasesearch(int matrix[][], int key) {
        int rows = 0, col = matrix[0].length - 1;
        while (rows < matrix.length && col >= 0) {
            if (matrix[rows][col] == key) {
                System.out.println("Found key at " + "(" + rows + "," + col + ")");
                return true;
            } else if (key < matrix[rows][col]) {
                col--;
            } else {
                rows++;
            }
        }
        System.out.println("Element not found!");
        return false;
    }

    public static void main(String args[]) {
        // Scanner sc = new Scanner(System.in);
// // INPUT IN 2D array using iterator
        /* int array[][] = new int[3][3];
        int n = array.length;
        int m = array[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = sc.nextInt();
            }
        } */
        // int matrix[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        // printarr(array, n, m);
// // LARGEST AND SMALLEST IN 2D ARRAY ------------------------------------------------>
        // largestsmallest(array);
// // BOOLEAN SEARCH ------------------------------------------------>
        // search(array, n, m,7);
// // SPIRAL MATRIX ------------------------------------------------>
        // spiralmatrix(matrix);
// // DIAGONAL SUM ------------------------------------------------>
        // diagonalsum(matrix);
// // STAIRCASE SEARCH ------------------------------------------------>
        /* int matrix[][] = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
        int key = 33;
        staircasesearch(matrix, key); */
// // HOMEWORK QUESTIONS ------------------------------------------------>
// // NUMBER OF 7'S IN GIVEN MATRIX ------------------------------------------------>
        /* int matrix[][] = {{4, 7, 8}, {8, 8, 7}};
        int number = 7;
        numbercount(matrix, number); */
// // SUM OF ROW IN GIVEN ARRAY ------------------------------------------------>
        /* int nums[][] = {{1, 4, 9}, {11, 4, 3}, {2, 2, 3}};
        sumofrow(nums); */
// // TRANSPOSE OF MATRIX ------------------------------------------------>
        int matrix[][] = {{2,3,7},{5,3,7},{1,2,3},{4,7,8}};
        transposematrix(matrix);
    }

// // NUMBER OF 7'S IN GIVEN MATRIX ------------------------------------------------>
    public static void numbercount(int matrix[][], int number) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == number) {
                    count++;
                }
            }
        }
        System.out.println("Frequency of given number in matrix is :" + count);
    }

// // SUM OF ROW IN GIVEN ARRAY ------------------------------------------------>
    public static void sumofrow(int nums[][]) {
        int sum = 0;
        for (int i = 0; i < nums[0].length; i++) {
            sum += nums[1][i];
        }
        System.out.println(sum);
    }

// // TRANSPOSE OF MATRIX ------------------------------------------------>
    public static void transposematrix(int matrix[][]) {
        int rows = matrix.length;
        int col = matrix[0].length;
        int transpose[][] = new int[col][rows];
        printarr(matrix, rows, col);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        printarr(transpose, col, rows);
    }
}
