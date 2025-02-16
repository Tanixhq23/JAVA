// Topic: BUBBLE SORT ALGORTIHM ------------------------------------------------>

// import java.util.*;
public class bubblesort {
// Topic: PRINT ARRAY ------------------------------------------------>

    public static void printarr(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
// Topic: BUBBLE SORT ALGORTIHM ------------------------------------------------>

    public static void bubble_sort(int array[]) {
        int n = array.length;
        for (int turn = 0; turn < n - 1; turn++) {
            int swap = 0;
            for (int j = 0; j < n - 1 - turn; j++) {
                if (array[j] > array[j + 1]) {
                    // Info: SWAP
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap++;
                }
            }
            if (swap == 0) {
                break;
            }
        }
        printarr(array);
    }
// Topic: REVERSE BUBBLE SORT ALGORTIHM ------------------------------------------------>

    public static void reversebubble_sort(int array[]) {
        int n = array.length;
        for (int turn = 0; turn < n - 1; turn++) {
            for (int j = 1; j < n - turn; j++) {
                if (array[j - 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        printarr(array);
    }

    public static void main(String args[]) {
        // Scanner sc = new Scanner(System.in);
        int array[] = {5, 4, 3, 2, 1};
        bubble_sort(array);
        reversebubble_sort(array);
// Topic: SORTING QUESTION ------------------------------------------------>
        int arr[] = {3,6,2,1,8,7,4,5,3,1};
        reversebubble_sort(arr);
    }
}
