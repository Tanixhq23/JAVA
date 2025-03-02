public class Segment_trees {
    // Topic: Creation of Segment Tree
    static int tree[];

    public static void Init(int n) {
        tree = new int[4 * n];
    }

    // Info: Build
    public static int buildST(int arr[], int i, int start, int end) {
        if (start == end) {
            tree[i] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2;
        buildST(arr, 2 * i + 1, start, mid);
        buildST(arr, 2 * i + 2, mid + 1, end);
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
        return tree[i];
    }

    public static void printST() {
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    // Topic: Query In ST
    public static int getSum(int arr[], int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        if (qj <= si || qi >= sj) {
            return 0;
        } else if (si >= qi && sj <= qj) {
            return tree[i];
        } else {
            int mid = (si + sj) / 2;
            int left = getSumUtil(2 * i + 1, si, mid, qi, qj);
            int right = getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return left + right;
        }
    }

    // Topic: Update int ST
    public static void updateST(int arr[], int idx, int newval) {
        int diff = newval - arr[idx];
        arr[idx] = newval;
        updateSTUtil(0, 0, arr.length - 1, idx, diff);
    }

    public static void updateSTUtil(int i, int si, int sj, int idx, int diff) {
        // CASE 1: Not in the range
        if (idx > sj || idx < si) {
            return;
        }
        // CASE 2: In Range
        tree[i] += diff;
        if (si != sj) {
            int mid = (si + sj) / 2;
            updateSTUtil(2 * i + 1, si, mid, idx, diff);
            updateSTUtil(2 * i + 2, mid + 1, sj, idx, diff);
        }

    }

    public static void main(String[] args) {
        // Topic: Creation of Segment Tree
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;
        Init(n);
        buildST(arr, 0, 0, n - 1);
        printST();
        // Topic: Query in ST
        int qi = 2;
        int qj = 5;
        System.out.println(getSum(arr, qi, qj));
        // Topic: Update in ST
        updateST(arr, 2, 2);
        printST();
        System.out.println(getSum(arr, 2, 5));
    }
}
