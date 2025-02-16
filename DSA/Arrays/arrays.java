// // ARRAYS ------------------------------------------------>

// import java.util.*;
public class arrays {

    public static void main(String args[]) {
        // Scanner sc = new Scanner(System.in);
        // int numbers[] = new int[10];
// // INPUT ------------------------------------------------>
        // numbers[0] = sc.nextInt();
// // UPDATING ------------------------------------------------>
        /* numbers[0] = numbers[0] + 4;
        System.out.println(numbers[0]);
        numbers[0] = sc.nextInt(); */
// // OUTPUT ------------------------------------------------>
        // System.out.println(numbers[0]); 

// // USING LOOPS ------------------------------------------------>
        /* for (int i = 0; i < 10; i++) {
            numbers[i] = sc.nextInt();
        }
        for (int k = 0; k <= 10; k++) {
            System.out.println(numbers[k]);
        } */
// // TO GET THE LENGTH OF ARRAY ------------------------------------------------> 
        // System.out.println("The length of array is : " + numbers.length);
// // PASSING ARRAYS AS ARGUMENTS ------------------------------------------------>
        /* int marks[] = {99, 98, 97};
        update(marks);
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Updated marks: " + marks[i]); // Call by reference as the changes made in function in the array reflect in the main function
        } */
// // LARGEST IN ARRAY ------------------------------------------------>
        /* int array[] = {1, 2, 6, 3, 5};
        int largest = Integer.MIN_VALUE;
        System.out.println("The largest element in given array is: " + largest(array, largest)); */
// // SMALLEST IN ARRAY ------------------------------------------------>
        /* int smallest = Integer.MAX_VALUE;
        System.out.println("The smallest element in given array is: " + smallest(array, smallest)); */
// // REVERSE AN ARRAY ------------------------------------------------>
        /* int array[] = {2, 4, 6, 8, 10};
        reversearray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(); */
// // PAIRS IN ARRAY ------------------------------------------------>
        // int array[] = {2, 4, 6, 8, 10};
        // pairs(array);
// // SUBARRAY ------------------------------------------------>
        // subarray(array);
// // MAXIMUM AND MINIMUM SUM OF SUBARRAY ------------------------------------------------>
        // sumsubarray(array);
// // MAX SUBARRAY SUM (BRUTE FORCE) ------------------------------------------------>
        // int numbers[] = {1, -2, 6, -1, 3};
        // bruteforcesum(numbers);
// // MAX SUBARRAY SUM (PREFIX SUM) ------------------------------------------------>
        // prefixsum(numbers);
// // KADANE'S ALGORTIHM MAX SUBARRAY SUM ------------------------------------------------>
        /* int array[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        kadanes(array); */
// // KADANE'S ALGORTIHM ARRAY WITH NEGATIVE SUM ------------------------------------------------>
        /* int array[] = {-1,-8,-4,-6,-7};
        kadanesnegative(array); */
// // TRAPPING RAINWATER ------------------------------------------------>
        /* int height[] = {4, 2, 0, 6, 3, 2, 5};
        int width = 1;
        System.out.println("Trapped water: " + trappingrainwater(height, width)); */
// // STOCK PROFIT TRACKER ------------------------------------------------>
        /* int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum profit from given prices: " + stockprofit(prices)); */
// // DISTINCT VALUE IN ARRAY ------------------------------------------------>
        /* int array[] = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(valuechecker(array)); */
// // TRAPPING RAINWATER QUESTION ------------------------------------------------>
        /* int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int height[] = {4, 2, 0, 3, 2, 5};
        int width = 1;
        System.out.println("Trapped water: " + trappedwater(height, width)); */
// // BUY AND SELL STOCK QUESTION ------------------------------------------------>
        /* int prices[] = {7, 6, 4, 3, 1};
        System.out.println("Maximum profit from given prices: " + profit(prices)); */
    }
// // BUY AND SELL STOCK QUESTION ------------------------------------------------>

    public static int profit(int prices[]) {
        int buyprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (buyprice < prices[i]) {
                int profit = prices[i] - buyprice;
                maxprofit = Math.max(maxprofit, profit);
            } else {
                buyprice = prices[i];
            }
        }
        return maxprofit;

    }
// // TRAPPING RAINWATER QUESTION ------------------------------------------------>

    public static int trappedwater(int height[], int width) {
        int n = height.length;
        int leftmax[] = new int[n];
        leftmax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(height[i], leftmax[i - 1]);
        }
        int rightmax[] = new int[n];
        rightmax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(height[i], rightmax[i + 1]);
        }
        int trappedwater = 0;
        for (int i = 0; i < n; i++) {
            int waterlevel = Math.min(leftmax[i], rightmax[i]);
            trappedwater += (waterlevel - height[i]) * width;
        }
        return trappedwater;
    }
// // DISTINCT VALUE IN ARRAY ------------------------------------------------>

    public static boolean valuechecker(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
// // STOCK PROFIT TRACKER ------------------------------------------------>

    public static int stockprofit(int prices[]) {
        int buyprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (buyprice < prices[i]) {// Profit
                int profit = prices[i] - buyprice; // Today's profit
                maxprofit = Math.max(maxprofit, profit);
            } else {
                buyprice = prices[i];
            }
        }
        return maxprofit;
    }
// // TRAPPING RAINWATER ------------------------------------------------>

    public static int trappingrainwater(int height[], int width) {
        int n = height.length;
        // Calculate left max boundaries
        int leftmax[] = new int[n];
        leftmax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(height[i], leftmax[i - 1]);

        }
        // Calculate right max boundaries 
        int rightmax[] = new int[n];
        rightmax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(height[i], rightmax[i + 1]);
        }
        int trappedwater = 0;
        // Loop - Water level = minimum of(left max boundary and right max boundary)
        // trapped water = (water level - bar height)*1
        for (int i = 0; i < n; i++) {
            int waterlevel = Math.min(leftmax[i], rightmax[i]);
            trappedwater += (waterlevel - height[i]) * 1;
        }
        return trappedwater;
    }
// // KADANE'S ALGORTIHM ARRAY WITH NEGATIVE SUM ------------------------------------------------>

    public static void kadanesnegative(int array[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for (int i = 0; i < array.length; i++) {
            cs += array[i];
            if (cs < 0) {
                cs = -1;
            }
            ms = cs;
        }
        System.out.println("Maximum sum: " + ms);
    }
// // KADANE'S ALGORTIHM MAX SUBARRAY SUM ------------------------------------------------>

    public static void kadanes(int array[]) {
        int maxsum = Integer.MIN_VALUE;
        int cursum = 0;
        for (int i = 0; i < array.length; i++) {
            cursum += array[i];
            if (cursum < 0) {
                cursum = 0;
            }
            maxsum = Math.max(cursum, maxsum);
        }
        System.out.println("Maximum sum: " + maxsum);
    }
// // MAX SUBARRAY SUM (PREFIX SUM) ------------------------------------------------>

    /* public static void prefixsum(int array[]) {
        int maxsum = Integer.MIN_VALUE;
        int prefix[] = new int[array.length];
        int cursum = 0;

        prefix[0] = array[0];
        // CALCULATE PREFIX ARRAY 
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + array[i];
        }
        // FIND MAXIMUM SUBARRAY SUM
        for (int i = 0; i < array.length; i++) {
            int start = i;
            for (int j = i; j < array.length; j++) {
                int end = j;
                cursum = i == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                // System.out.println("Current sum from index " + i + " to " + j + " is: " + cursum);
                if (maxsum < cursum) {
                    maxsum = cursum;
                }
            }
        }
        System.out.println("Maximum sum: " + maxsum);
    } */
// // MAX SUBARRAY SUM (BRUTE FORCE) ------------------------------------------------>
    public static void bruteforcesum(int array[]) {
        int maxsum = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int cursum = 0;
                for (int k = i; k <= j; k++) {
                    cursum += array[k];
                }
                System.out.println("Current sum from index " + i + " to " + j + " is: " + cursum);
                if (maxsum < cursum) {
                    maxsum = cursum;
                }
            }
        }
        System.out.println("Maximum sum: " + maxsum);
    }

// // MAXIMUM AND MINIMUM SUM OF SUBARRAY ------------------------------------------------>
    public static void sumsubarray(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // Iterate over all possible starting points of subarrays
        for (int i = 0; i < array.length; i++) {
            int sum = 0; // Initialize sum for the new subarray
            // Iterate over all possible ending points of subarrays
            for (int j = i; j < array.length; j++) {
                sum += array[j]; // Add the current element to the sum
                System.out.println("Sum of subarray [" + array[i] + ", " + array[j] + "]: " + sum);
                // Update max and min with the current subarray sum
                if (sum > max) {
                    max = sum;
                }
                if (sum < min) {
                    min = sum;
                }
            }
        }
        System.out.println("Maximum sum of subarray is: " + max);
        System.out.println("Minimum sum of subarray is: " + min);
    }

// // SUBARRAY ------------------------------------------------>
    public static void subarray(int array[]) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            // int start = i;
            for (int j = i; j < array.length; j++) {
                // int end = j;
                for (int k = i; k <= j; k++) {
                    System.out.print(array[k]);
                }
                total++;
                System.out.println("");
            }
            System.out.println("");
        }
        System.out.println("Total subarrays: " + total);
    }
// // PAIRS IN ARRAY ------------------------------------------------>

    public static void pairs(int array[]) {
        int tp = 0;
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            for (int j = i + 1; j < array.length; j++) {
                System.out.print("(" + current + "," + array[j] + ")");
                tp++;
            }
            System.out.println("");
        }
        System.out.println("Total number of pairs: " + tp);
    }

// // REVERSE AN ARRAY ------------------------------------------------>
    public static void reversearray(int array[]) {
        int f = 0;
        int l = array.length - 1;
        while (f < l) {
            int temp = array[l];
            array[l] = array[f];
            array[f] = temp;
            f++;
            l--;
        }
    }

// // SMALLEST IN ARRAY ------------------------------------------------>
    public static int smallest(int array[], int smallest) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }

// // LARGEST IN ARRAY ------------------------------------------------>
    public static int largest(int array[], int largest) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        return largest;
    }

// // Passing arrays as arguments
    public static void update(int marks[]) {
        for (int i = 0; i < marks.length; i++) {
            marks[i] += 1;
        }
    }
}
