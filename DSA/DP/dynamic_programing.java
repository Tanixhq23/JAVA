import java.util.*;

public class dynamic_programing {

    // Topic: Memoization in DP
    public static int MemoizationFib(int n, int f[]) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (f[n] != 0) {
            return f[n];
        }
        f[n] = MemoizationFib(n - 1, f) + MemoizationFib(n - 2, f);
        return f[n];
    }

    // Topic: Tabulation in DP
    public static int tabFib(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Topic: Climbing Stairs
    public static int countWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return countWays(n - 1) + countWays(n - 2);
    }

    // Info: Memoization
    public static int countWays2(int n, int ways[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = countWays2(n - 1, ways) + countWays2(n - 2, ways);
        return ways[n];
    }

    // Info: Tabulation
    public static int countWays3(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1] + 0;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

        }
        return dp[n];
    }

    // Topic: 0-1 Knapsack Problem
    // Info: Recursion
    public static int knapsackRec(int val[], int wt[], int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }
        // Info: Valid
        if (wt[n - 1] <= W) {
            // Info: Include
            int ans1 = val[n - 1] + knapsackRec(val, wt, W - wt[n - 1], n - 1);
            // Info: Exclude
            int ans2 = knapsackRec(val, wt, W, n - 1);
            return Math.max(ans1, ans2);
        } else {
            return knapsackRec(val, wt, W, n - 1);
        }

    }

    // Info: Memoization
    public static int knapsackMem(int val[], int wt[], int W, int n, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n - 1][W] != -1) {
            return dp[n - 1][W];
        }
        // Info: Valid
        if (wt[n - 1] <= W) {
            // Info: Include
            int ans1 = val[n - 1] + knapsackMem(val, wt, W - wt[n - 1], n - 1, dp);
            // Info: Exclude
            int ans2 = knapsackMem(val, wt, W, n - 1, dp);
            dp[n - 1][W] = Math.max(ans1, ans2);
            return dp[n - 1][W];
        } else {
            dp[n - 1][W] = knapsackMem(val, wt, W, n - 1, dp);
            return dp[n - 1][W];
        }
    }

    // Info: Tabulation
    public static void printDP(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int knapsackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        // Info: Initialize 0th column
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        // Info: Initialize 0th row
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                // Info: Valid
                if (w <= j) {
                    // Info: Include
                    int incProfit = v + dp[i - 1][j - w];
                    // Info: Exclude
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } // Info: Invalid
                else {
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        // Info: Print DP array
        printDP(dp);
        return dp[n][W];
    }

    // Topic: Target Sum Subset (Tabulation)
    public static boolean targetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        // NOTE: i - items
        // NOTE: j - target Sum
        // Info: Initialize 0th column
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int V = arr[i - 1];
                // Include
                if (V <= j && dp[i - 1][j - V] == true) {
                    dp[i][j] = true;
                }
                // Exclude
                else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        // Info: Final Answer
        printDP(dp);
        return dp[n][sum];

    }

    public static void printDP(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Topic: Unbounded Knapsack (Tabulation)
    public static int unboundknapTab(int val[], int wt[], int W) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < W + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                // Info: Valid
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                }
                // Info: Invaid 
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        printDP(dp);
        return dp[n][W];
    }

    // Topic: Coin Change (Tabulation)
    public static int coinChange(int[] coins, int sum) {
        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        printDP(dp);
        return dp[n][sum];
    }

    // Topic: Rod Cutting
    public static int rodCutting(int length[], int prices[], int totRod) {
        int n = prices.length;
        int dp[][] = new int[n + 1][totRod + 1];
        // Info: No need for initialization in Java all cells are initialised with 0
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < totRod + 1; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(prices[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][totRod];
    }

    // Topic: Longest Common Subsequence
    // Info: Recursion
    public static int lcs1(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return lcs1(str1, str2, n - 1, m - 1) + 1;
        } else {
            return Math.max(lcs1(str1, str2, n - 1, m), lcs1(str1, str2, n, m - 1));
        }
    }

    // Info: Memoization
    public static int lcs2(String str1, String str2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = lcs2(str1, str2, n - 1, m - 1, dp) + 1;
        } else {
            return dp[n][m] = Math.max(lcs2(str1, str2, n - 1, m, dp), lcs2(str1, str2, n, m - 1, dp));
        }
    }

    // Info: Tabulation
    public static int lcs3(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    // Topic: Longest Common Substring
    public static int lcSubstr(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        printDP(dp);
        return ans;
    }

    // Topic: Longest Increasing Subsequence
    public static int lis(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int arr2[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2);
        return lcs3(arr, arr2);
    }

    public static int lcs3(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    // Topic: Edit Distance
    public static int editdistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Info: Addition
                    int add = dp[i][j - 1] + 1;
                    // Info: Remove
                    int del = dp[i - 1][j] + 1;
                    // Info: Replace
                    int replace = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(add, Math.min(del, replace));
                }
            }
        }
        return dp[n][m];
    }
    // Topic: String Conversion
    public static int stringConversion(String str1, String str2){
        int lcs = lcs3(str1, str2);
        int delOp = str1.length() - lcs;
        int insOp = str2.length() - lcs;
        return delOp + insOp;
    }

    public static void main(String[] args) {
        // int n = 5;
        // Info: Memoization 
        // int f[] = new int[n + 1];
        // System.out.println(MemoizationFib(n, f));
        // Info: Tabulation 
        // System.out.println(tabFib(n));
        // Info: Climbing Stairs
        // System.out.println(countWays(n));
        // Info: Memoization
        /* int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);
        countWays2(n, ways); */
        // Info: Tabulation
        // System.out.println(countWays3(n));
        // Topic: 0-1 Knapsack Problem
        // Info: Recursion
        /* int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        System.out.println(knapsackRec(val, wt, W, val.length)); */
        // Info: Memoization
        /* int dp[][] = new int[val.length][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsackMem(val, wt, W, val.length, dp)); */
        // Info: Tabulation
        // System.out.println(knapsackTab(val, wt, W));
        // Topic: Target Sum Subset (Tabulation)
        /* int arr[] = { 4, 2, 7, 1, 3 };
        int sum = 10;
        System.out.println(targetSum(arr, sum)); */
        // Topic: Unbounded Knapsack (Tabulation)
        /* int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        System.out.println(unboundknapTab(val, wt, W)); */
        // Topic: Coin Change
        /* int[] coins = { 1,2,5 };
        int sum = 11;
        System.out.println(coinChange(coins, sum)); */
        // Topic: Rod cutting
        /* int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int prices[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int totRod = 8;
        System.out.println(rodCutting(length, prices, totRod)); */
        // Topic: Longest Common Subsequence
        // String str1 = "abcdge";
        // String str2 = "abedg";
        // Info: Recursion
        // System.out.println(lcs1(str1, str2, str1.length(), str2.length()));
        // Info: Memoization
        // int n = str1.length();
        // int m = str2.length();
        // int[][] dp = new int[n + 1][m + 1];
        // for (int i = 0; i < n + 1; i++) {
        //     for (int j = 0; j < m + 1; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        // System.out.println(lcs2(str1, str2, n, m, dp));
        // Info: Tabulation
        // System.out.println(lcs3(str1, str2));
        // Topic: Longest Common Substring
        /* String str1 = "ABCDE";
        String str2 = "ABGCE";
        System.out.println(lcSubstr(str1, str2)); */
        // Topic: Longest Increasing Subsequence
        // int[] arr = { 50, 3, 10, 7, 40, 80 };
        // System.out.println(lis(arr));
        // Topic: Edit Distance
        /* String word1 = "intention";
        String word2 = "execution";
        System.out.println(editdistance(word1, word2)); */
        // Topic: String Conversion
        /* String str1 = "heap";
        String str2 = "pea";
        System.out.println(stringConversion(str1, str2)); */
    }
}
