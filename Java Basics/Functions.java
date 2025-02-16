// // FUNCTIONS ------------------------------------------------>

// import java.util.*;

public class functions {

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
// FUCNTION TO PRINT HELLO WORLD! ------------------------------------------------>
        // Hello(5);
// BINOMIAL COEFFICIENT ------------------------------------------------>
        /* System.out.println("Enter the value of n(n>r): ");
        int n = sc.nextInt();
        System.out.println("Enter the value of r(n>r): ");
        int r = sc.nextInt();
        System.out.println("The binomial coefficient of given values of n and r is: " + binomialco(n, r)); */
// FACTORIAL ------------------------------------------------>
        /* System.out.println("Enter the value of n: ");
        int n = sc.nextInt();
        factorial(n); */
// SWAP FUNCTION ------------------------------------------------>
        // swap(4,10);
// PRODUCT FUNCTION ------------------------------------------------>
        /* System.out.println("Enter the value of a: ");
        int a = sc.nextInt();
        System.out.println("Enter the value of b: ");
        int b = sc.nextInt();
        int result = product(a, b);
        System.out.println("The product of given values is: " + result); */
// CALULATE SUM ------------------------------------------------>
        /* System.out.println("Enter the value of a: ");
        int a = sc.nextInt();
        System.out.println("Enter the value of b: ");
        int b = sc.nextInt();
        System.out.println(calsum(a, b)); */
// FUNCTION OVERLOADING ------------------------------------------------>
        /* System.out.println("Enter the value of a: ");
        int a = sc.nextInt();
        System.out.println("Enter the value of b: ");
        int b = sc.nextInt();
        System.out.println("Enter the value of c: ");
        int c = sc.nextInt();
        System.out.println("Sum of two numbers a and b is: " + sum(a, b));
        System.out.println("Sum of three numbers a, b and c is: " + sum(a, b, c)); */
// FUNCTION OVERLOADING (using data types) ------------------------------------------------>
        /* System.out.println(sum(4, 5));
        System.out.println(sum(4f, 5.6f)); */
        // primerange(10);
// BINARY TO DECIMAL ------------------------------------------------>
       /*  System.out.println("Enter the binary number: ");
        int n = sc.nextInt();
        int bin = n;
        System.out.println("Decimal representation for " + "'" + bin + "'" + " is " + "'" + bintodec(n) + "'"); */
// DECIMAL TO BINARY ------------------------------------------------>
        /* System.out.println("Enter the decimal number: ");
        int n = sc.nextInt();
        int dec = n;
        System.out.println("Binary representation for " + "'" + dec + "'" + " is " + "'" + dectobin(n) + "'"); */
    }
// DECIMAL TO BINARY ------------------------------------------------>

    public static int dectobin(int n) {
        int pow = 0;
        int bin = 0;
        while (n > 0) {
            int rem = n % 2;
            bin = bin + (rem * (int) Math.pow(10, pow));
            pow++;
            n /= 2;
        }
        return bin;
    }
// BINARY TO DECIMAL ------------------------------------------------>

    public static int bintodec(int n) {
        int pow = 0;
        int dec = 0;
        while (n > 0) {
            int ld = n % 10;
            dec = dec + (ld * (int) Math.pow(2, pow));
            pow++;
            n /= 10;
        }
        return dec;
    }

// PRIME OR NOT? ------------------------------------------------>
    public static boolean isprime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
// PRINT PRIMES IN RANGE ------------------------------------------------>

    public static void primerange(int n) {
        for (int i = 2; i <= n; i++) {
            if (isprime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

// FUNCTION OVERLOADING (using data types------------------------------------------------>

    /* public static int sum(int a, int b) {
        return (a + b);
    }

    public static float sum(float a, float b) {
        return (a + b);
    } */
// FUNCTION OVERLOADING ------------------------------------------------>

    /* public static int sum(int a, int b) {
        return (a + b);
    }

    public static int sum(int a, int b, int c) {
        return (a + b + c);
    } */
// FUCNTION TO PRINT HELLO WORLD! ------------------------------------------------>
    public static void Hello(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.println("Hello World!");
        }
    }
// BINOMIAL COEFFICIENT ------------------------------------------------>

    public static int fact(int n) {
        int f = 1;
        if (n == 0 || n == 1) {
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        return f;
    }

    public static int binomialco(int n, int r) {
        return (fact(n) / (fact(r) * fact(n - r)));
    }
// FACTORIAL ------------------------------------------------>

    public static void factorial(int n) {
        int f = 1;
        if (n == 0 || n == 1) {
            System.out.println("Factorial of " + n + " is " + f + "!");
        }
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        System.out.println("Factorial of " + n + " is " + f + "!");
    }
// SWAP FUNCTION ------------------------------------------------>

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Values are swaped" + " a = " + a + " b = " + b);
    }
// PRODUCT FUNCTION ------------------------------------------------>

    public static int product(int a, int b) {
        int result = a * b;
        return result;
    }
// CALCULATE SUM ------------------------------------------------>

    public static int calsum(int a, int b) {
        int result = a + b;
        return result;
    }

}
