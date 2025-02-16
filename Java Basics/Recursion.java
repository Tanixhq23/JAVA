// // Topic: Recursion ------------------------------------------------>
// import java.util.*;

public class Recursion {

    // Topic: Basic Recursion program for printing numbers in Decreasing order ------------------------------------------------>
    public static void printDec(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.println(n + " ");
        printDec(n - 1);
    }

    // Topic: Basic Recursion program for printing numbers in Increasing order ------------------------------------------------>
    public static void printInc(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        printInc(n - 1);
        System.out.println(n + " ");
    }

    // Topic: Factorial of number ------------------------------------------------>
    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        int fact = n * fact(n - 1);
        return fact;
    }

    // TOpic: Print sum of n natural numbers ------------------------------------------------>
    public static int naturalsum(int n) {
        int sum;
        if (n == 1) {
            return 1;
        }
        // int snm = naturalsum(n-1);
        sum = n + naturalsum(n - 1);
        return sum;
    }

    // Topic: Fibonacci series ------------------------------------------------>
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int fnm1 = fib(n - 1);
        int fnm2 = fib(n - 2);
        int fn = fnm1 + fnm2;
        return fn;
    }

    // Topic: Is array Sorted? ------------------------------------------------>
    public static boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    // Topic: First occurence ------------------------------------------------>
    public static int firstocc(int arr[], int num, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == num) {
            return i;
        }
        return firstocc(arr, num, i + 1);
    }

    // Topic: Last occurence ------------------------------------------------>
    // Info: My method to reverse the search!
    public static int lastocc(int arr[], int num, int i) {
        if (i < 0) {
            return -1;
        }
        if (arr[i] == num) {
            return i;
        }
        return lastocc(arr, num, i - 1);
    }

    // Info: Mam's method to first look forward and then compare with self!
    public static int lastoccurence(int arr[], int num, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isfound = lastoccurence(arr, num, i + 1);
        if (isfound == -1 && arr[i] == num) {
            return i;
        }
        return isfound;
    }

    // Topic: Power of x ------------------------------------------------>
    public static long powerOfx(long x, long n) {
        if (n == 0) {
            return 1;
        }
        return x * powerOfx(x, n - 1);
    }

    // Topic: Optimized power of x ------------------------------------------------>
    public static int optimizedpower(int a, int n) {
        if (n == 0) {
            return 1;
        }
        int half = optimizedpower(a, n / 2);
        int halfpowersq = half * half;
        // If power is odd
        if (n % 2 != 0) {
            halfpowersq = a * halfpowersq;
        }
        return halfpowersq;
    }

    // Topic: Tiling problem ------------------------------------------------>
    public static int tilingproblem(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        // Info: Work
        // Info: Vertical Tiles
        int fnm1 = tilingproblem(n - 1);
        // Info: Horizontal Tiles
        int fnm2 = tilingproblem(n - 2);
        int totalways = fnm1 + fnm2;
        return totalways;
    }

    // Topic: Replace Duplicates ------------------------------------------------>
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        //BaseCase
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        //Work
        char currchar = str.charAt(idx);
        if (map[currchar - 'a'] == true) {
            removeDuplicates(str, idx + 1, newStr, map);
        } else {
            map[currchar - 'a'] = true;
            removeDuplicates(str, idx + 1, newStr.append(currchar), map);
        }
    }

    // Topic: Friends Pairing ------------------------------------------------>
    public static int friendPairing(int n) {
        // Base Case
        if (n == 1 || n == 2) {
            return n;
        }

        // Choices
        // Single = friendPairing(n-1)
        // Pairing = (n-1) * friendPairing(n-2)
        return friendPairing(n - 1) + (n - 1) * friendPairing(n - 2);
    }

    // Topic: Print Binary Strings without consecutive ones ------------------------------------------------>
    public static void printBinString(int n, int lastplace, String str) {
        // Base Case
        if (n == 0) {
            System.out.println(str);
            return;
        }
        // Kaam
        printBinString(n - 1, 0, str + "0");
        if (lastplace == 0) {
            printBinString(n - 1, 1, str + "1");
        }
    }

    // Topic: Print Binary Strings without consecutive zeros ------------------------------------------------>
    public static void printbinString2(int n, int lastplace, String str) {
        // Base Case
        if (n == 0) {
            System.out.println(str);
            return;
        }
        // Kaam
        printbinString2(n - 1, 1, str + "1");
        if (lastplace == 1) {
            printbinString2(n - 1, 0, str + "0");
        }
    }

    public static void main(String[] args) {
        // Topic: Basic Recursion program for printing numbers in Decreasing order ------------------------------------------------>
        /* printDec(10); */
        // Topic: Basic Recursion program for printing numbers in Increasing order ------------------------------------------------>
        /* printInc(10); */
        // Topic: Factorial of number ------------------------------------------------>
        /* System.out.println(fact(5)); */
        // Topic: Print sum of n natural numbers ------------------------------------------------>
        /* System.out.println(naturalsum(5)); */
        // Topic: Fibonacci series ------------------------------------------------>
        /* System.out.println("Nth term in fibonacci series: " + fib(24)); */
        // Topic: Is array Sorted? ------------------------------------------------>
        /* int arr[] = {1, 2, 3, 6, 4, 5};
        int i = 0;  
        System.out.println(isSorted(arr, i)); */
        // Topic: First occurence ------------------------------------------------>
        /* int arr[] = {8,3,6,9,5,10,2,5,3};
        System.out.println(firstocc(arr, 5, 0)); */
        // Topic: Last occurence ------------------------------------------------>
        // Info: Method1
        /* int i = arr.length-1;
        System.out.println(lastocc(arr, 5, i)); */
        // Info: Method2
        /* System.out.println(lastoccurence(arr, 5, 0)); */
        // Topic: Power of x ------------------------------------------------>
        // System.out.println(powerOfx(2, 5));
        // Topic: Optimized power of x ------------------------------------------------>
        // System.out.println(optimizedpower(2, 5));
        // Topic: Replace Duplicates ------------------------------------------------>
        // String str = "appnnacollege";
        // removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
        // Topic: Friends Pairing ------------------------------------------------>
        // System.out.println(friendPairing(4));
        // Topic: Print Binary Strings without consecutive ones ------------------------------------------------>
        // printBinString(3, 0, "");
        // Topic: Print Binary Strings without consecutive zeros ------------------------------------------------>
        printbinString2(3, 1, "");
    }
}
