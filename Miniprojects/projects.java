// Topic: MINI PROJECTS ------------------------------------------------>
// import java.time.LocalDateTime;

import java.util.ArrayList;

public class projects {

    public static void main(String args[]) {
        // Scanner sc = new Scanner(System.in);
        // Topic: AREA OF CIRCLE ------------------------------------------------>
        /*
         * float r = sc.nextFloat();
         * // float pi = 3.14f;
         * float area = 3.14f * r * r;
         * System.out.println(area);
         */
        // Topic: AVERAGE OF 3 NUMBERS ------------------------------------------------>
        /*
         * int A = sc.nextInt();
         * int B = sc.nextInt();
         * int C = sc.nextInt();
         * int n = 3;
         * int AVG = (A + B + C) / n;
         * System.out.println(AVG);
         */
        // Topic: AREA OF SQUARE ------------------------------------------------>
        /*
         * int s = sc.nextInt();
         * int Area = s * s;
         * System.out.println(Area);
         */
        // Topic: CREATING A BILL FOR A PENCIL, A PEN , AN ERASER ------------------------------------------------>
        /*
         * System.out.println("Enter the price of Pen:");
         * float Pen = sc.nextFloat();
         * System.out.println("Enter the price of Pencil:");
         * float Pencil = sc.nextFloat();
         * System.out.println("Enter the price of Eraser:");
         * float Eraser = sc.nextFloat();
         * float Price = Pen + Pencil + Eraser;
         * System.out.println("Total price: " + Price);
         * float gst = Price * 0.18f;
         * float finalPrice = Price + gst;
         * System.out.println("Final price with 18% GST: " + finalPrice);
         */
        // Topic: INCOME TAX CALCULATOR ------------------------------------------------>
        /*
         * System.out.println("Please Enter your income: ");
         * int income = sc.nextInt();
         * int tax;
         * if (income < 500000) {
         * tax = 0;
         * } else if (income >= 500000 && income < 1000000) {
         * tax = (int) (0.2 * income);
         * } else {
         * tax = (int) (0.3 * income);
         * }
         * System.out.println("Your income with tax is: " + tax);
         */
        // Topic: LARGEST OF THREE NUMBERS ------------------------------------------------>
        /*
         * int A = sc.nextInt();
         * int B = sc.nextInt();
         * int C = sc.nextInt();
         * if (A > B && A > C) {
         * System.out.println("A is largest");
         * }else if (B > C) {
         * System.out.println("B is largest");
         * }else {
         * System.out.println("C is largest");
         * }
         */
        // Topic: CALCULATOR ------------------------------------------------>
        /*
         * System.out.println("Enter the value of A: ");
         * int a = sc.nextInt();
         * System.out.println("Enter the value of B: ");
         * int b = sc.nextInt();
         * System.out.println("Enter the operator: ");
         * char operator = sc.next().charAt(0);
         * switch (operator) {
         * case '+':
         * System.out.println("ADDITION : " + (a + b));
         * break;
         * case '-':
         * System.out.println("SUBSTRACTION : " + (a - b));
         * break;
         * case '*':
         * System.out.println("MULTIPLICATION : " + (a * b));
         * break;
         * case '/':
         * System.out.println("DIVITION : " + (a / b));
         * break;
         * case '%':
         * System.out.println("MODULO/REMAINDER : " + (a % b));
         * break;
         * default:
         * System.out.println("Invalid operator type used!!");
         * }
         * System.out.println("Enter the week number");
         */
        // Topic: LEAP YEAR PROBLEM ------------------------------------------------>
        /*
         * System.out.println("Enter a year");
         * int year = sc.nextInt();
         * boolean isDivisibleBy4 = year % 4 == 0;
         * boolean isDivisibleBy100 = year % 100 == 0;
         * boolean isDivisibleBy400 = year % 400 == 0;
         * if (isDivisibleBy4 && (!isDivisibleBy100 || isDivisibleBy400)) {
         * System.out.println("Leap year");
         * } else {
         * System.out.println("Not a Leap Year");
         * }
         */
        // Topic: PRIME OR NOT ------------------------------------------------>
        /*
         * System.out.println("Enter a number: ");
         * int n = sc.nextInt();
         * if (n == 2) {
         * System.out.println("Given number " + "'" + n + "'" +
         * " is composite or non prime number.");
         * }
         * else {
         * for (int i = 2; i <= Math.sqrt(n); i++) {
         * if (n%i==0){
         * System.out.println("Given number " + "'" + n + "'" +
         * " is composite or non prime number.");
         * break;
         * }
         * else {
         * System.out.println("Given number " + "'" + n + "'" + " is a prime number.");
         * }
         * }
         * }
         */
        // Topic: PRIME OR NOT 2 (OPTIMIZED) ------------------------------------------------>
        /*
         * numbers repeat their factors!
         * max factors n = (n)^1/2 * (n)^1/2
         * when both the factors of n is almost similar then the factors will repeat!
         */
        /*
         * System.out.println("Enter a number");
         * int n = sc.nextInt();
         * boolean isprime = true;
         * if (n == 2) {
         * System.out.println(isprime);
         * }
         * for (int i = 2; i <= Math.sqrt(n);) {
         * if (n % i == 0) {
         * isprime = false;
         * System.out.println(isprime);
         * break;
         * } else {
         * System.out.println(isprime);
         * break;
         * }
         * }
         */
        // Topic: BINARY TO DECIMAL ------------------------------------------------>
        /*
         * System.out.println("Enter the binary number: ");
         * int n = sc.nextInt();
         * int bin = n;
         * int pow = 0;
         * int dec = 0;
         * while (n > 0) {
         * int ld = n % 10;
         * dec = dec + (ld * (int) Math.pow(2, pow));
         * pow++;
         * n /= 10;
         * }
         * System.out.println("Decimal representation for " + "'" + bin + "'" + " is " +
         * "'" + dec + "'");
         */
        // Topic: DECIMAL TO BINARY ------------------------------------------------>
        /*
         * System.out.println("Enter the decimal number: ");
         * int n = sc.nextInt();
         * int dec = n;
         * int pow = 0;
         * int bin = 0;
         * while (n > 0) {
         * int rem = n % 2;
         * bin = bin + (rem * (int) Math.pow(10, pow));
         * pow++;
         * n /= 2;
         * }
         * System.out.println("Binary representation for " + "'" + dec + "'" + " is " +
         * "'" + bin + "'");
         */
        // Topic: TO PRINT CURRENT DATE AND TIME USING INBUILT JAVA API ------------------------------------------------>
        /*
         * LocalDateTime now = LocalDateTime.now();
         * System.out.println(now);
         */
        // Topic: TOWER OF HANOI PROBLEM ------------------------------------------------>
        // TowerOfHanoi('A', 'C', 'B', 3);
        // Topic: SUDOKU SOLVER ------------------------------------------------>
        int sudoku[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 }, { 4, 9, 0, 1, 5, 7, 0, 0, 2 }, { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 6, 0 }, { 0, 0, 0, 0, 2, 0, 0, 6, 0 }, { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 }, { 0, 4, 9, 0, 3, 0, 0, 5, 7 }, { 8, 2, 7, 0, 0, 9, 0, 1, 3 } };
        if (sudokusolver(sudoku, 0, 0)) {
            System.out.println("Solution exist: ");
            printsudoku(sudoku);
        } else {
            System.out.println("Solution does not exist: ");
        }
        // Topic: Container with most water (BruteForce)
        /*
         * ArrayList<Integer> height = new ArrayList<>();
         * height.add(1);
         * height.add(8);
         * height.add(6);
         * height.add(2);
         * height.add(5);
         * height.add(4);
         * height.add(8);
         * height.add(3);
         * height.add(7);
         * System.out.println("Maximum water stored: " + ContainerwMW(height));
         * System.out.println("Maximum water stored: " + ContainerwMW2(height));
         */
        // Topic: Pair Sum-1
        // Info: BruteForce
        /*
         * ArrayList<Integer> list = new ArrayList<>();
         * for(int i = 0; i<6;i++){
         * list.add(i);
         * }
         */
        /* System.out.println(pairSum1b(list,5)); */
        // Info: Optimized
        /* System.out.println(pairSum1(list,5)); */
        // Topic: Pair Sum-2
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(pariSum2(list, 16));
    }

    // Topic: Pair Sum-2
    public static boolean pariSum2(ArrayList<Integer> list, int target) {
        int bp = -1;
        int n = list.size();
        for (int i = 0; i < n; i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }
        int lp = bp + 1;
        int rp = bp;
        while (lp != rp) {
            // Info: Case-1
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }
            if (list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            }
            if (list.get(lp) + list.get(rp) > target) {
                rp = (n + rp - 1) % n;
            }
        }
        return false;
    }

    // Topic: Pair Sum-1 (Optimized O(n))
    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size() - 1;
        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }
            if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    // Topic: Pair Sum-1 (BruteForce O(n^2))
    public static boolean pairSum1b(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // Topic: Container with most water (Optimized)
    public static int ContainerwMW2(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.size() - 1;
        while (lp < rp) {
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    // Topic: Container with most water (BruteForce)
    public static int ContainerwMW(ArrayList<Integer> height) {
        int maxWater = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int width = j - i;
                int currstored = ht * width;
                maxWater = Math.max(maxWater, currstored);
            }
        }
        return maxWater;
    }
    // Topic: TOWER OF HANOI PROBLEM ------------------------------------------------>

    public static void TowerOfHanoi(char src, char dest, char aux, int n) {
        // Info: Base Case
        if (n == 0) {
            return;
        }
        // Info: int total = n "If numbering is done in such a way that largest disc is
        // named 1st and smallest disc is named 3rd";
        // Info: 1st Faith recursive call (smaller disc from src to aux)
        TowerOfHanoi(src, aux, dest, n - 1);
        // Info: Print or Work
        System.out.println(n + " disc move from " + src + " to " + dest + " tower ");
        // Info: 2nd Faith recursive call (larger disc fro src to dest)
        TowerOfHanoi(aux, dest, src, n - 1);
    }
    // Topic: SUDOKU SOLVER ------------------------------------------------>

    public static boolean sudokusolver(int sudoku[][], int row, int col) {
        // Base Case
        if (row == 9) {
            return true;
        }
        // Recursion
        int nextrow = row, nextcol = col + 1; // Obtain next row and column for recursion
        if (col + 1 == 9) { // if Column has reached to the end, increment the row and start from 1st column
            nextrow = row + 1;
            nextcol = 0;
        }
        if (sudoku[row][col] != 0) { // If there is a number already present, no need to replace it, call for next
                                     // values.
            return sudokusolver(sudoku, nextrow, nextcol);
        } else {
            for (int digit = 1; digit <= 9; digit++) { // If there is no digit present check for correct digit to be
                                                       // placed form 1 to 9
                if (isSafe(sudoku, row, col, digit)) { // check if isSafe() returns true
                    sudoku[row][col] = digit; // Store the digit
                    if (sudokusolver(sudoku, nextrow, nextcol)) { // Check if solution is available for next row
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

}
