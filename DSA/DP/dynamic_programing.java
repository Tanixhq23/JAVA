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
        for (boolean[] dp1 : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp1[j] + " ");
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
    public static int stringConversion(String str1, String str2) {
        int lcs = lcs3(str1, str2);
        int delOp = str1.length() - lcs;
        int insOp = str2.length() - lcs;
        return delOp + insOp;
    }

    // Topic: Wildcard Matching 
    public static boolean WildcardMatching(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        // Info: Initialize
        dp[0][0] = true;
        // Info: Pattern empty
        // p = " "
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }
        // s = " "
        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        // Info: Fill Bottom up manner
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // CASE 1: ith character == jth character || jth character == ?
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // CASE 2: jth character == * 
                else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                // CASE 3: ith character != jth character
                else {
                    dp[i][j] = false;
                }
            }
        }
        // Info: String -> n, pattern -> m
        return dp[n][m];
    }

    // Topic: Catalan's Number
    // Info: Recursion
    public static int catalansnumber1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += catalansnumber1(i) * catalansnumber1(n - i - 1);
        }
        return ans;
    }

    // Info: Memoization
    public static int catalansnumber2(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalansnumber2(i, dp) * catalansnumber2(n - i - 1, dp);
        }
        return dp[n] = ans;
    }

    // Info: Tabulation
    public static int catalansnumber3(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    // Topic: Count BST
    public static int countBST(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            // Info: Ci -> BST (i Nodes) -> dp[i]
            for (int j = 0; j < i; j++) {
                // Info: Ci = Cj * Ci-Cj-1
                int left = dp[j];
                int right = dp[i - j - 1];
                dp[i] += left * right;
            }
        }
        return dp[n];
    }

    // Topic: Mountain Ranges
    public static int mountainRanges(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            // Info: Ci -> BST (i Nodes) -> dp[i]
            for (int j = 0; j < i; j++) {
                // Info: Ci = Cj * Ci-Cj-1
                int inside = dp[j];
                int outside = dp[i - j - 1];
                dp[i] += inside * outside;
            }
        }
        return dp[n];
    }

    // Topic: Matrix Chain Multiplication
    // Info: Recursion
    public static int MCM1(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = MCM1(arr, i, k); // Info: Ai...Ak => arr[i-1] x arr[k]
            int cost2 = MCM1(arr, k + 1, j); // Info: Ak+1...Aj => arr[k+1] x arr[j]
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalcost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalcost);
        }
        return ans;
    }

    // Info: Memoization
    public static int MCM2(int[] arr, int i, int j, int[][] dp) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = MCM2(arr, i, k, dp);
            int cost2 = MCM2(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalcost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalcost);
        }
        return dp[i][j] = ans;
    }

    // Info: Tabulation
    public static int MCM3(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        // Info: Initalization
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        // Info: Bottom UP
        for (int len = 2; len <= n - 1; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
                }
            }
        }
        printDP(dp);
        return dp[1][n - 1];
    }

    // Topic: Minimum Partition
    public static int minPart(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int W = sum / 2;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                // Info: Valid
                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
                } // Info: Invalid
                else {

                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }

    // Topic: Minimum Array Jumps
    public static int minArrJumps(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int steps = arr[i];
            int ans = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + steps && j < n; j++) {
                if (dp[j] != -1) {
                    ans = Math.min(ans, dp[j] + 1);
                }
            }
            if (ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }
        }
        printDP(dp);
        return dp[0];
    }

    public static void printDP(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    // SOl1: 
    public static int tribonacci(int n) {
        int dp[] = new int[n + 1];
        dp[2] = dp[1] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    // Topic: Minimum path sum
    // Info: Recursive
    public static int minpathsum1(int[][] grid, int m, int n) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }

        if (m >= grid.length || n >= grid[0].length) { // Added boundary check
            return Integer.MAX_VALUE;
        }
        if (m == 0 && n == 0) {
            return grid[0][0];
        }

        return grid[m][n] + Math.min(minpathsum1(grid, m - 1, n), minpathsum1(grid, m, n - 1));
    }

    // Info: Memoization
    public static int minpathsum2(int grid[][], int m, int n, int dp[][]) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (m >= grid.length || n >= grid[0].length) { // Added boundary check
            return Integer.MAX_VALUE;
        }
        if (m == 0 && n == 0) {
            return grid[0][0];
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        return dp[m][n] = grid[m][n] + Math.min(minpathsum2(grid, m - 1, n, dp), minpathsum2(grid, m, n - 1, dp));
    }

    // Info: Tabulation
    public static int minpathsum3(int grid[][]) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    // Topic: Houes Robber
    // Info: Recursion
    public static int houseRobber(int nums[], int idx) {
        if (idx == 0) {
            return nums[idx];
        }
        if (idx == 1) {
            return Integer.max(nums[0], nums[1]);
        }
        int rob_curr = nums[idx] + houseRobber(nums, idx - 2);
        int skip_curr = houseRobber(nums, idx - 1);
        return Math.max(rob_curr, skip_curr);
    }

    // Info: Memoization
    public static int houseRobber2(int nums[], int idx, int[] dp) {
        if (idx == 0) {
            return nums[idx];
        }
        if (idx == 1) {
            return Integer.max(nums[0], nums[1]);
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int rob_curr = nums[idx] + houseRobber2(nums, idx - 2, dp);
        int skip_curr = houseRobber2(nums, idx - 1, dp);
        return dp[idx] = Math.max(rob_curr, skip_curr);
    }

    // Info: Tabulation
    public static int houseRobber3(int arr[]) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Integer.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            // CASE1: If we rob the current house
            int rob_curr = arr[i] + dp[i - 2];
            // CASE2: If skip the curr house
            int skip_curr = dp[i - 1];
            dp[i] = Math.max(rob_curr, skip_curr);
        }
        return dp[arr.length - 1];
    }

    // SOL: Print all combination of balanced parentheses
    // Info: Recursion
    public static void generateParentheses1(char str[], int pos, int n, int open, int close) {
        if (close == n) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i]);
            }
            System.out.println();
        } else {
            if (open > close) {
                if (pos < str.length) {
                    str[pos] = '}';
                    generateParentheses1(str, pos + 1, n, open, close + 1);
                }
            }
            if (open < n) {
                if (pos < str.length) {
                    str[pos] = '{';
                    generateParentheses1(str, pos + 1, n, open + 1, close);
                }
            }
        }
    }

    // Topic: House Robber - III
    /* public static int HouseRobber3_1(TreeNode curr, HashMap<TreeNode, Integer> dp) {
        if (curr == null) {
            return 0;
        }
        if (dp.containsKey(curr) == true) {
            return dp.get(curr);
        }
        int not_steal = HouseRobber3_1(curr.left, dp) + HouseRobber3_1(curr.right, dp);
        int steal = curr.val;
        if (curr.left != null) {
            steal += HouseRobber3_1(curr.left.left, dp) + HouseRobber3_1(curr.left.right, dp);
        }
        if (curr.right != null) {
            steal += HouseRobber3_1(curr.right.left, dp) + HouseRobber3_1(curr.right.right, dp);
        }
        int val = Math.max(steal, not_steal);
        dp.put(curr, val);
        return val;
    } */

    // SOL4:
    public static int LIP(int matrix[][]) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int[] row : dp) {
            Arrays.fill(row, 1);
        }

        int maxPath = 1;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r > 0 && matrix[r][c] > matrix[r - 1][c]) {
                    dp[r][c] = Math.max(dp[r][c], dp[r - 1][c] + 1);
                }
                if (r < rows - 1 && matrix[r][c] > matrix[r + 1][c]) {
                    dp[r][c] = Math.max(dp[r][c], dp[r + 1][c] + 1);
                }
                if (c > 0 && matrix[r][c] > matrix[r][c - 1]) {
                    dp[r][c] = Math.max(dp[r][c], dp[r][c - 1] + 1);
                }
                if (c < cols - 1 && matrix[r][c] > matrix[r][c + 1]) {
                    dp[r][c] = Math.max(dp[r][c], dp[r][c + 1] + 1);
                }

                maxPath = Math.max(maxPath, dp[r][c]);
            }
        }

        return maxPath;
    }

    // SOL5:
    public static int countValidParenthesis(int n) {
        int[] dp = new int[n + 1];

        // Base case
        dp[0] = 1;

        // Fill dp array using the tabulation method
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        // int n = 5;
        // Info: Memoization 
        /* int f[] = new int[n + 1];
        System.out.println(MemoizationFib(n, f)); */
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
        /* String str1 = "abcdge";
        String str2 = "abedg"; */
        // Info: Recursion
        // System.out.println(lcs1(str1, str2, str1.length(), str2.length()));
        // Info: Memoization
        /* int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(lcs2(str1, str2, n, m, dp)); */
        // Info: Tabulation
        // System.out.println(lcs3(str1, str2));
        // Topic: Longest Common Substring
        /* String str1 = "ABCDE";
        String str2 = "ABGCE";
        System.out.println(lcSubstr(str1, str2)); */
        // Topic: Longest Increasing Subsequence
        /* int[] arr = { 50, 3, 10, 7, 40, 80 };
        System.out.println(lis(arr)); */
        // Topic: Edit Distance
        /* String word1 = "intention";
        String word2 = "execution";
        System.out.println(editdistance(word1, word2)); */
        // Topic: String Conversion
        /* String str1 = "heap";
        String str2 = "pea";
        System.out.println(stringConversion(str1, str2)); */
        // Topic: Wildcard Matching
        /* String s = "abc";
        String p = "**d";
        System.out.println(WildcardMatching(s, p)); */
        // Topic: Catalan's Number
        // Info: Recursion
        /* int n = 4;
        System.out.println(catalansnumber1(n)); */
        // Info: Memoization
        /* int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(catalansnumber2(n, dp)); */
        // Info: Tabulation
        // System.out.println(catalansnumber3(n));
        // Topic: Count BST
        // System.out.println(countBST(5));
        // Topic: Mountain Ranges
        /* int pair = 4;
        System.out.println(mountainRanges(pair)); */
        // Topic: Matrix Chain Multiplication
        // Info: Recursion
        /* int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length; */
        // System.out.println(MCM1(arr, 1, n - 1));
        // Info: Memoization
        /* int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            }
            System.out.println(MCM2(arr, 1, n - 1, dp)); */
        // Info: Tabulation
        // System.out.println(MCM3(arr));
        // Topic: Minimum partitioning
        /* int arr[] = { 1, 5, 11, 5 };
        System.out.println(minPart(arr)); */
        // Topic: Minimum jumps
        /* int arr[] = { 2, 3, 1, 1, 4 };
        System.out.println(minArrJumps(arr)); */
        // QUES 1:Tribonacci Series
        // System.out.println(tribonacci(10));
        // Topic: Minimum path sum
        // Info: Recursive
        /* int grid[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(minpathsum1(grid, grid.length-1, grid[0].length-1)); */
        // Info: Memoization
        /* int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], -1);
            }
            System.out.println(minpathsum2(grid, grid.length - 1, grid[0].length - 1, dp)); */
        // Info: Tabulation
        // System.out.println(minpathsum3(grid));
        // Topic: House Robber
        // Info: Recursion
        /* int nums[] = { 1, 2, 3, 1 };
        System.out.println(houseRobber(nums, nums.length-1)); */
        // Info: Memoization
        /* int[] dp = new int [nums.length+1];
        Arrays.fill(dp, -1);
        System.out.println(houseRobber2(nums, nums.length-1, dp)); */
        // Info: Tabulation
        // System.out.println(houseRobber3(nums));
        // QUES 2: Print all combination of balanced parantheses
        // Info: Recurison
        /* int n = 3;
        char ch[] = new char[2 * n];
        generateParentheses1(ch, 0, n, 0, 0); */
        // Topic: House Robber - III
        // NOTE: This code requires tree data structures - Make sure to implement the structure first!
        /* HashMap<TreeNode, Integer> dp = new HashMap<>();
        System.out.println(HouseRobber3_1(curr, dp)); */
        // QUES 4: Longest Increasing path in Matrix
        /* int[][] arr = { { 1, 2, 3, 4 },
                { 2, 2, 3, 4 },
                { 3, 2, 3, 4 },
                { 4, 5, 6, 7 } };
        System.out.println(LIP(arr)); */
        // QUES 5: Number of Parenthesis Combinations
        // System.out.println(countValidParenthesis(4));
    }
}