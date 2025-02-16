import java.util.*;

// Topic: Greedy Algorithm
public class greedyalgo {

    // Topic: Activity Selection
    public static void activityselection(int[] start, int[] end) {
        // Info: End Time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        // Info: 1st activity
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                // Info: Activity select
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("Maximum Activities: " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }

    // Info: If arrays of start and end tine are not sorted
    public static void activityselection2(int[] start, int[] end) {
        // Info: End Time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        // Info: Sorting
        int[][] activities = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2])); // Info: Lambda Function

        maxAct = 1;
        ans.add(activities[0][0]);
        int LastEnd = activities[0][2];
        for (int i = activities[1][0]; i < activities.length; i++) {
            if (activities[i][1] >= LastEnd) {
                maxAct++;
                ans.add(activities[i][0]);
                LastEnd = activities[i][2];
            }
        }

        System.out.println("Maximum Activities: " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }

    // Topic: Fractional Knapcask
    public static void fracknapsack(int[] val, int[] weight, int W) {
        double[][] ratio = new double[val.length][2];
        int capacity = W;
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int finalval = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                finalval += val[idx];
                capacity -= weight[idx];
            } else {
                finalval += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("Maximum profit: " + finalval);
    }

    // Topic: Minimum absolute difference pair
    public static void minabsdif(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);

        int minDiff = 0;
        for (int i = 0; i < a.length; i++) {
            minDiff += Math.abs(a[i] - b[i]);
        }
        System.out.println("Minimum sum absolute difference: " + minDiff);
    }

    // Topic: Maximum length chain of pairs
    public static void maxlengthchain(int[][] pair) {
        Arrays.sort(pair, Comparator.comparingDouble(o -> o[1]));
        int chainlen = 1;
        int chainEnd = pair[0][1];
        for (int i = 0; i < pair.length; i++) {
            if (pair[i][0] > chainEnd) {
                chainlen++;
                chainEnd = pair[i][1];
            }
        }
        System.out.println("Maximum length of chain: " + chainlen);
    }

    // Topic: Indian Coins
    public static void indiancoins(Integer[] coins, int amount) {
        Arrays.sort(coins, Comparator.reverseOrder());
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    count++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }
        System.out.println("Total minimum number of coins: " + count);
        System.out.print("Denominations: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + ", ");
        }
        System.out.println();
    }

    // Topic: Jobs Sequencing
    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            deadline = d;
            id = i;
            profit = p;
        }
    }

    public static void jobsequencing(int[][] jobInfo) {
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);
        ArrayList<Integer> sequence = new ArrayList<>();
        int time = 0;
        int profit = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                sequence.add(curr.id);
                profit += curr.profit;
                time++;
            }
        }
        System.out.println("Maximum jobs: " + sequence.size());
        System.out.println("Maximum profit: " + profit);
        for (int i = 0; i < sequence.size(); i++) {
            System.out.print(sequence.get(i) + " ");
        }
        System.out.println();
    }

    // Solution 1
    public static void balancedpartition(String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println("Invalid String format");
        }
        int r = 0, l = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'R') {
                r++;
            } else if (str.charAt(i) == 'L') {
                l++;
            }
            if (r == l) {
                ans++;
                l++;
                r++;
            }
        }
        System.out.println("Maximum no. of balanced string: " + ans);
    }

    // Solution 2
    public static void kthlargestoddnumber(int l, int r, int k) {
        int totalnumber = r - l + 1;
        int oddcnt;

        if (l % 2 != 0 && r % 2 != 0) {
            oddcnt = (totalnumber / 2) + 1;
        } else {
            oddcnt = totalnumber / 2;
        }

        if (k > oddcnt) {
            System.out.println("Not enough odd numbers present in given range");
            return;
        }

        int largestvalue = 0;
        if (r % 2 != 0) {
            largestvalue = r;
        } else {
            largestvalue = r - 1;
        }
        int ans = largestvalue - (2 * (k - 1));
        System.out.println( "Largest ODD number in given range, L: " + l + ", R: " + r + ", is: " + ans);

    }

    public static void main(String[] args) {
        // Topic: Activity Selection
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        activityselection2(start, end);
        // Topic: Fractional Knapsack
        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int W = 50;
        fracknapsack(val, weight, W);
        // Topic: Minimum sum absolute difference pair
        int a[] = { 1, 2, 3 };
        int b[] = { 2, 1, 3 };
        minabsdif(a, b);
        // Topic: Maximum length of pairs
        int pair[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        maxlengthchain(pair);
        // Topic: Indian Coins
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int amount = 590;
        indiancoins(coins, amount);
        // Topic: Job Sequencing
        int[][] jobInfo = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        jobsequencing(jobInfo);
        // Question 1: Maximum Balanced String partition
        String str = "LRRRRLLRLLRL";
        balancedpartition(str);
        // Question 2: Largest Odd number in the given range
        kthlargestoddnumber(-3, 3, 5);
    }
}