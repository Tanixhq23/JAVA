// Topic: QUESTION ------------------------------------------------>

import java.util.*;

public class questions {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
// Topic: FUNCTIONS ------------------------------------------------>
// Ques 1 Average of three numbers  ------------------------------------------------>
// Solution ------------------------------------------------>
        /* System.out.println("Enter first number: ");
        double a = sc.nextDouble();
        System.out.println("Enter second number: ");
        double b = sc.nextDouble();
        System.out.println("Enter third number: ");
        double c = sc.nextDouble();
        System.out.println("The average of numbers is: " + avg3(a, b, c)); */
// Ques 2 Test whether the given argument is even ------------------------------------------------>
// Solution ------------------------------------------------>
        /* System.out.println("Enter an argument of type int: ");
    int a = sc.nextInt();
    testeven(a); */
// Ques 3 Palindrome ------------------------------------------------>
// Solution ------------------------------------------------>
        /* System.out.println("Enter a number:");
        int n = sc.nextInt();
        checkpalin(n); */
// Ques 4 Sum of all numbers in a number ------------------------------------------------>
// Solution ------------------------------------------------>
        /* System.out.println("Enter a number:");
        int n = sc.nextInt();
        System.out.println("The sum of all digits of given number " + n + " is: " + sumno(n)); */
// Ques 5 WAP to print the sum, diff & product of two complex numbers also the real and imaginary part of complex number is entered by the user ------------------------------------------------> 
// Solution ------------------------------------------------> 
        /* Complex c = new Complex(4, 5);
        Complex d = new Complex(9, 4);
        Complex e = Complex.add(c, d);
        Complex f = Complex.diff(c, d);
        Complex g = Complex.product(c, d);
        e.printcomplex();
        f.printcomplex();
        g.printcomplex(); */
        sc.close();
// Topic: Recursion ------------------------------------------------>
// Ques 1 For a given integer array of size N. You have to find all the occurences (indices) of a given element (key) and print them. Use a recursive function to solve this problem
        /* int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        int key = 2;
        int i = 0;
        occurences(arr, key, i); */
// Ques 2 You are given a number (eg - 2019), convert it into a String of english like “two zero one nine”. Use a recursive function to solve this problem.
        // printdigits(2019);
// Ques 3 Print the length of the String
        /* String str = "Tanishq";
        LengthStr(str, 0); */
// Ques 4 Find the count of all the contigous substrings starting and ending with same character
        /* String str = "abac";
        System.out.println(countcontigousString(str, 0, str.length() - 1, str.length())); */
// Ques 5 Tower of Hanoi problem
        /* TowerOfHanoi('A', 'C','B', 3); */

    }
// Topic: Recursion ------------------------------------------------>
// Solution 1 ------------------------------------------------>

    public static int occurences(int[] arr, int key, int i) {
        if (i > arr.length - 1) {
            return -1;
        }
        if (arr[i] == key) {
            System.out.println(i);
        }
        return occurences(arr, key, i + 1);
    }
// Solution 2 ------------------------------------------------>

    public static void printdigits(int num) {
        String digits[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        if (num == 0) {
            return;
        }
        int ld = num % 10;
        printdigits(num / 10);
        System.out.println(digits[ld]);
    }
// Solution 3 ------------------------------------------------>

    public static int LengthStr(String str, int i) {
        return 7;
    }
// Solution 4 ------------------------------------------------> 

    public static int countcontigousString(String str, int i, int j, int n) {
        if (n == 1) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
        int res = countcontigousString(str, i + 1, j, n - 1) + countcontigousString(str, i, j - 1, n - 1) - countcontigousString(str, i + 1, j - 1, n - 2);
        if (str.charAt(i) == str.charAt(j)) {
            res++;
        }
        return res;
    }
// Solution 5 ------------------------------------------------>

    public static void TowerOfHanoi(char src, char dest, char aux, int n) {
        // Info: Base Case
        if(n==0){
            return; 
        }
        // Info: int total = n "If numbering is done in such a way that largest disc is named 1st and smallest disc is named 3rd";
        // Info: 1st Faith recursive call (smaller disc from src to aux)
        TowerOfHanoi(src, aux, dest, n - 1);
        // Info: Print or Work
        System.out.println(n + " disc move from " + src + " to " + dest + " tower ");
        // Info: 2nd Faith recursive call (larger disc fro src to dest)
        TowerOfHanoi(aux, dest, src, n - 1);
    }
// Topic: Functions ------------------------------------------------>
// Solution 1 ------------------------------------------------>
    /* public static double avg3(double a, double b, double c) {
        return ((a + b + c) / 3);
    } */
// Solution 2 ------------------------------------------------>
    /* public static boolean iseven(int a) {
        if (a % 2 == 0) 
            return true;
        else 
            return false;
        
    } */

 /* public static void testeven(int a) {
        if (iseven(a)) {
            System.out.println("The given argument is even!");
        } else {
            System.out.println("The given argument is odd!");
        }
    } */
// Solution 3 ------------------------------------------------>
    /* public static void checkpalin(int n) {
        if (palindrome(n)) {
            System.out.println("The Given number " + n + " is palindorme!");
        } else {
            System.out.println("The Given number " + n + " is not palindorme!");
        }
    }

    public static boolean palindrome(int n) {
        int original = n;
        int reverse = 0;
        while (n > 0) {
            int ld = (n %= 10);
            reverse = reverse * 10 + ld;
            n /= 10;
        }
        return reverse == original;
    } */
// Solution 4 ------------------------------------------------>
    /* public static int sumno(int n) {
        int sum = 0;
        while (n > 0) {
            int ld = n % 10;
            sum += ld;
            n /= 10;
        }
        return sum;
    } */
}
// Solution 5 ------------------------------------------------> 

/* class Complex {

    int real;
    int imag;

    public Complex(int r, int i) {
        this.real = r;
        this.imag = i;
    }

    public static Complex add(Complex a, Complex b) {
        return new Complex((a.real + b.real), (a.imag + b.imag));
    }

    public static Complex diff(Complex a, Complex b) {
        return new Complex((a.real - b.real), (a.imag - b.imag));
    }

    public static Complex product(Complex a, Complex b) {
        return new Complex(((a.real * b.real) - (a.imag * b.imag)), ((a.real * b.real) + (a.imag * b.imag)));
    }

    void printcomplex() {
        if (real == 0 && imag != 0) {
            System.out.println(imag + "i");
        } else if (real != 0 && imag == 0) {
            System.out.println(real);
        } else {
            System.out.println(real + "+" + imag + "i");
        }
    }
} */
