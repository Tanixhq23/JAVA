// // PATTERNS ------------------------------------------------>

// import java.util.*;

public class patterns {

    public static void main(String args[]) {
        // Scanner sc = new Scanner(System.in);
// INVERTED STAR PATTERN  ------------------------------------------------>
        /* System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.println("Started...");
        for (int lines = 1; lines <= rows; lines++) {
            for (int col = 1; col <= (rows - lines + 1); col++) {
                System.out.print(" * ");
            }
            System.out.println(" ");
        }
        System.out.println("Executed..."); */
// NUMBERS PYRAMID PATTERN ------------------------------------------------>
        /* System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        } */

// SQUARE PATTERN ------------------------------------------------>
        /* System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter the number of column: ");
        int column = sc.nextInt();
        for (int lines = 1; lines<=rows; lines++){
            for (int col = 1; col<=column; col++ ){
                System.out.print(" * ");
            }
            System.out.println(" ");
        } */
// HOLLOW RECTANGLE PATTERN ------------------------------------------------>
// through method
        /* System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns: ");
        int columns = sc.nextInt();
        hollow_rectangle(rows, columns); */
// INVERTED AND ROTATED HALF-PYRAMID PATTERN ------------------------------------------------>
// through method
        /* System.out.println("Enter the number of line: ");
        int rows = sc.nextInt();
        in_ro_pyra(rows); */
// INVERTED HALF PYRAMID WITH NUMBERS PATTERN ------------------------------------------------>
// through method 
        /* System.out.println("Enter the number of columns: ");
        int col = sc.nextInt();
        in_half_no(col); */
// FLOYD'S TRIANGLE PATTERN ------------------------------------------------>
// through method 
        /* System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        floydstriangle(rows); */
// 0-1 TRIANGLE PATTERN ------------------------------------------------>
// through method
        /* System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();
        zero_one_triangle(rows); */
// BUTTERFLY PATTERN ------------------------------------------------>
// through method
        /* System.out.println("Enter the vlaue of n: ");
        int n = sc.nextInt();
        butterfly(n); */
// SOLID RHOMBUS ------------------------------------------------>
// through method
        /* System.out.println("Enter the vlaue of n: ");
        int n = sc.nextInt();
        solidrhombus(n); */
// HOLLOW RHOMBUS PATTERN ------------------------------------------------>
// through method
// It is nothing but tilted hollow rectangle!!!
        /* System.out.println("Enter the vlaue of n: ");
        int n = sc.nextInt();
        hollowrhombus(n); */
// DIAMOND PATTERN ------------------------------------------------>
// through method
        /* System.out.println("Enter the vlaue of n: ");
        int n = sc.nextInt();
        diamond(n); */
    }
// DIAMOND PATTERN ------------------------------------------------>

    public static void diamond(int n) {
        // 1st half 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 2nd half
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

// HOLLOW RHOMBUS PATTERN ------------------------------------------------>
// It is nothing but tilted hollow rectangle!!!
    public static void hollowrhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // Spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // Stars 
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

// SOLID RHOMBUS ------------------------------------------------>
    public static void solidrhombus(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= n; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

// BUTTERFLY PATTERN ------------------------------------------------>
    public static void butterfly(int n) {
        // 1st half
        for (int i = 1; i <= n; i++) {
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 2nd half
        for (int i = n; i >= 1; i--) {
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

// 0-1 TRIANGLE PATTERN ------------------------------------------------>
    public static void zero_one_triangle(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }

// FLOYD'S TRIANGLE PATTERN ------------------------------------------------>
    public static void floydstriangle(int rows) {
        int n = 1;
        // char ch = 'A';
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(n + " ");
                n++;
            }
            System.out.println();
        }
    }
// INVERTED HALF PYRAMID WITH NUMBERS PATTERN ------------------------------------------------>

    public static void in_half_no(int col) {
        for (int i = 1; i <= col; i++) {
            for (int j = 1; j <= col - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
// INVERTED AND ROTATED HALF-PYRAMID PATTERN ------------------------------------------------>

    public static void in_ro_pyra(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

// HOLLOW RECTANGLE PATTERN ------------------------------------------------>
    public static void hollow_rectangle(int rows, int columns) {
        for (int i = 1; i <= rows; i++) {
            // inner-loop = columns
            for (int j = 1; j <= columns; j++) {
                // cells = (i,j)
                if (i == 1 || i == rows || j == 1 || j == columns) {
                    // boundry 
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
