// // BUBBLE SORT ALGORTIHM ------------------------------------------------>

// import java.util.*;
public class selectionsort {
// // PRINT ARRAY ------------------------------------------------>

    public static void printarr(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
// // SELECTION SORT ALGORTIHM ------------------------------------------------>

    public static void selection_sort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            int minpos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minpos] > array[j]) {
                    minpos = j;
                }
            }
            int temp = array[minpos];
            array[minpos] = array[i];
            array[i] = temp;
        }
        printarr(array);
    }
// // REVERSE SELECTION SORT ALGORTIHM ------------------------------------------------>

    public static void reverseselectionsort(int array[]) {
        for (int i = 0; i < array.length - 2; i++) {
            int minpos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minpos] < array[j]) {
                    minpos = j;
                }
            }
            int temp = array[minpos];
            array[minpos] = array[i];
            array[i] = temp;
        }
        printarr(array);
    }

    public static void main(String args[]) {
        // Scanner sc = new Scanner(System.in);
        int array[] = {5, 4, 3, 2, 1};
        selection_sort(array);
        reverseselectionsort(array);
// // SORTING QUESTION ------------------------------------------------>
    int arr[] = {3,6,2,1,8,7,4,5,3,1};
    reverseselectionsort(arr);
    }
}
