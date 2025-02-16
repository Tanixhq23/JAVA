// // BUBBLE SORT ALGORTIHM ------------------------------------------------>

// import java.util.*;
public class insertionsort {
// // PRINT ARRAY ------------------------------------------------>

    public static void printarr(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
// // INSERTION SORT ALGORTIHM ------------------------------------------------>

    public static void insertion_sort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int curr = array[i];
            int prev = i - 1;
            // finding out the correct position to insert
            while (prev >= 0 && array[prev] > curr) {
                array[prev + 1] = array[prev];
                prev--;
            }
            // insertion
            array[prev + 1] = curr;
        }
        printarr(array);
    }
// // REVERSE INSERTION SORT ALGORTIHM ------------------------------------------------>

    public static void reverseinsertionsort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int curr = array[i];
            int prev = i - 1;
            // finding out the correct position to insert
            while (prev >= 0 && array[prev] < curr) {
                array[prev + 1] = array[prev];
                prev--;
            }
            // insertion
            array[prev + 1] = curr;
        }
        printarr(array);
    }

    public static void main(String[] args) {
        int array[] = {5, 4, 1, 3, 2};
        insertion_sort(array);
        reverseinsertionsort(array);
// // SORTING QUESTION ------------------------------------------------>
    int arr[] = {3,6,2,1,8,7,4,5,3,1};
    reverseinsertionsort(arr);
    }
}
