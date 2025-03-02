public class Min_Segment_tree2 {
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static void BuildST(int[] arr, int i, int si, int sj) {
        if (si == sj) {
            tree[i] = arr[si];
        }
        int mid = si + (sj - si) / 2;
        BuildST(arr, 2 * i + 1, si, mid);
        BuildST(arr, 2 * i + 2, mid + 1, sj);
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    public static void main(String[] args) {
        int[] arr ={6,8,-1,2,17,1,3,2,4};
        int n =arr.length;
        init(n);
    }
}
