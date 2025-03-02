public class Min_Segment_tree {
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static void BuildST(int[] arr, int i, int si, int sj) {
        if (si == sj) {
            tree[i] = arr[si];
            return;
        }
        int mid = si + (sj - si) / 2;
        BuildST(arr, 2 * i + 1, si, mid);
        BuildST(arr, 2 * i + 2, mid + 1, sj);
        tree[i] = Math.min(tree[2 * i + 1], tree[2 * i + 2]);
    }

    public static void printST() {
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    public static int getMin(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMinUtil(0, 0, n - 1, qi, qj);
    }

    public static int getMinUtil(int i, int si, int sj, int qi, int qj) {
        // CASE 1: No Overlap
        if (si > qj || sj < qi) {
            return Integer.MAX_VALUE;
        }
        // CASE 2: Complete Overlap
        else if (si >= qi && sj <= qj) {
            return tree[i];
        }
        // CASE 3: Partial Overlap
        else {
            int mid = (si + sj) / 2;
            int left = getMinUtil(2 * i + 1, si, mid, qi, qj);
            int right = getMinUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return Math.min(left, right);
        }
    }

    // Topic: Update 
    public static void updateST(int arr[], int idx, int newval) {
        arr[idx] = newval;
        int n = arr.length;
        updateSTUtil(0, 0, n - 1, idx, newval);

    }

    public static void updateSTUtil(int i, int si, int sj, int idx, int newval) {
        // CASE 1: Non - Overlap
        if (idx < si || idx > sj) {
            return;
        }
        // CASE 2: Overlap
        if (si == sj) {
            tree[i] = newval;
        }
        if (si != sj) {
            tree[i] = Math.min(tree[i], newval);
            int mid = (si + sj) / 2;
            updateSTUtil(2 * i + 1, si, mid, idx, newval);
            updateSTUtil(2 * i + 2, mid + 1, sj, idx, newval);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = arr.length;
        init(n);
        BuildST(arr, 0, 0, n - 1);
        // printST();
        // Topic: Find Max
        /* int qi = 5, qj = 8;
        System.out.println(getMax(arr, qi, qj)); */
        // Topic: Update ST
        updateST(arr, 2, 20);
        printST();
        System.out.println(getMin(arr, 2, 5));
    }
}
