// // BIT MANIPULATION ------------------------------------------------>

import java.util.*;

public class Bitmanipulation {

    public static void main(String[] args) {
        System.out.println("Hello World");
        Scanner sc = new Scanner(System.in);
// // BINARY AND "&" :- returns 1 if 1 & 1 ------------------------------------------------>
        System.out.println("Binary AND: " + (5 & 6));
// // BINARY OR "|" :- returns 0 if 0 | 0 ------------------------------------------------>
        System.out.println("Binary OR: " + (5 | 6));
// // BINARY XOR "^" :- returns 1 if 0 ^ 1 and 1 ^ 0 ------------------------------------------------>
        System.out.println("Binary XOR: " + (5 ^ 6));
// // BINARY ONE'S COMPLEMENT / NOT "~" ------------------------------------------------>
        System.out.println("Binary 1's complement: " + (~5));
// // BINARY LEFT SHIFT "<<" :- a << b :- Left shifts a by b places ------------------------------------------------>
// // FORMULA:- a << b = a * 2^b
        System.out.println("Binary Left shift: " + (5 << 2));
// // BINARY RIGHT SHIFT ">>" :- a >> b :- Right shifts a by b places ------------------------------------------------>
// // FORMULA:- a >> b = a / 2^b
        System.out.println("Binary Right shift: " + (6 >> 1));
// // ODD-EVEN ------------------------------------------------>
        /* System.out.print("Enter a number --> ");
        int num = sc.nextInt();
        oddoreven(num); */
// // GET iTH BIT ------------------------------------------------>
        /* System.out.print("Enter the number --> ");
        int num = sc.nextInt();
        System.out.print("Enter the value of i --> ");
        int i = sc.nextInt();
        System.out.println("The bit at " + "'" + i + "'" + " place is --> " + getithbit(num, i)); */
// // SET iTH BIT ------------------------------------------------>
        /* System.out.print("Enter the number --> ");
        int num = sc.nextInt();
        System.out.print("Enter the value of i --> ");
        int i = sc.nextInt();
        setithbit(num,i); */
// // CLEAR iTH BIT ------------------------------------------------>
        /* System.out.print("Enter the number --> ");
        int num = sc.nextInt();
        System.out.print("Enter the value of i --> ");
        int i = sc.nextInt();
        clearithbit(num, i); */
// // UPDATE iTH BIT ------------------------------------------------>
        /* System.out.print("Enter the number --> ");
        int num = sc.nextInt();
        System.out.print("Enter the value of i --> ");
        int i = sc.nextInt();
        System.out.print("Enter the new bit to update --> ");
        int newbit = sc.nextInt();
        updateithbit(num, i, newbit);
        // 2nd approach
        System.out.println("The new number after updating the given number " + " '" + num + " '" + " is --> " + updateithbit2(num, i, newbit)); */
// // CLEAR i BITS ------------------------------------------------>
        /* System.out.print("Enter the number --> ");
        int num = sc.nextInt();
        System.out.print("Enter the value of i --> ");
        int i = sc.nextInt();
        System.out.print("The new number after clearing i = " + " '" + i + " '" + " bits is --> " + clearibits(num, i)); */
// // CLEAR RANGE OF BITS ------------------------------------------------>
        /* System.out.print("Enter the number --> ");
        int num = sc.nextInt();
        System.out.print("Enter the value of i --> ");
        int i = sc.nextInt();
        System.out.print("Enter the value of j --> ");
        int j = sc.nextInt();
        System.out.print("The new number after clearing " + " '" + i + "," + j + " '" + " bits is --> " + clearbitsrange(num, i, j)); */
// // POWER OF 2 OR NOT ------------------------------------------------>
        System.out.print("Enter a number --> ");
        int n = sc.nextInt();
        System.out.print(isPowerOfTwo(n));
// // NUMBER OF SET BITS ------------------------------------------------>
        /* System.out.print("Enter a number --> ");
        int n = sc.nextInt();
        System.out.print("Number of set bits in given number is: " + countSetBits(n)); */
// // FAST EXPONENTIATION ------------------------------------------------>
        /* System.out.print("Enter base number --> ");
        int a = sc.nextInt();
        System.out.print("Enter power --> ");
        int n = sc.nextInt();
        System.out.print("Result of Fast exponentiation for given base " + n + "^" + a + " is : " + fastexpo(a, n)); */
// // SWAP TWO NUMBERS USING ONLY TWO VARIABLES ------------------------------------------------>
        /* System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        SwapTwoNo(a, b); */
    }
// // SWAP TWO NUMBERS USING ONLY TWO VARIABLES ------------------------------------------------>

    public static void SwapTwoNo(int a, int b) {
        System.out.println("Before swapping " + "a : " + a + " b : " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.print("After swapping " + "a : " + a + " b : " + b);
    }
// // FAST EXPONENTIATION ------------------------------------------------>

    public static int fastexpo(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }
// // NUMBER OF SET BITS ------------------------------------------------>

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
// // POWER OF 2 OR NOT ------------------------------------------------>

    public static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }
// // CLEAR RANGE OF BITS ------------------------------------------------>

    public static int clearbitsrange(int num, int i, int j) {
        int a = ((~0) << (j + 1));
        int b = (1 << i) - 1;
        int bitmask = a | b;
        return num & bitmask;
    }
// // CLEAR i BITS ------------------------------------------------>

    public static int clearibits(int num, int i) {
        int bitmask = (~0) << i;
        return num & bitmask;
    }
// // UPDATE iTH BIT ------------------------------------------------>

    public static void updateithbit(int num, int i, int newbit) {
        if (newbit == 0) {
            System.out.println("The new number after updating the given number " + " '" + num + " '" + " is --> " + clearithbit(num, i));
        } else {
            System.out.println("The new number after updating the given number " + " '" + num + " '" + " is --> " + setithbit(num, i));
        }
    }

    //2nd APPROACH
    public static int updateithbit2(int num, int i, int newbit) {
        num = clearithbit(num, i);
        int bitmask = newbit << i;
        return bitmask | num;
    }
// // CLEAR iTH BIT ------------------------------------------------>

    public static int clearithbit(int num, int i) {
        int bitmask = ~(1 << i);
        return num & bitmask;
    }
// // SET iTH BIT ------------------------------------------------>

    public static int setithbit(int num, int i) {
        int bitmask = 1 << i;
        return bitmask | num;
    }
// // GET iTH BIT ------------------------------------------------>

    public static int getithbit(int num, int i) {
        int bitmask = 1 << i;
        if ((num & bitmask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
// // ODD-EVEN ------------------------------------------------>

    public static void oddoreven(int num) {
        int bitmask = 1;
        if ((num & bitmask) == 0) {
            System.out.println("Given number: " + "'" + num + "'" + " is even");
        } else {
            System.out.println("Given number: " + "'" + num + "'" + " is odd");
        }
    }
}
