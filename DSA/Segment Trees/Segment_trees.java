public class Segment_trees {
    // Topic: Creation of Segment Tree
    static int tree[];

    public static void Init(int n) {
        tree = new int[4 * n];
    }

    // Info: Build
    public static int buildST(int arr[], int sti, int start, int end) {
        if (start == end) {
            tree[sti] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2;
        int left = buildST(arr, 2 * sti + 1, start, mid);
        int right = buildST(arr, 2 * sti + 2, mid + 1, end);
        return tree[sti] = left + right;
    }

    public static void main(String[] args) {
        System.out.println("Segment Trees");
    }
}
