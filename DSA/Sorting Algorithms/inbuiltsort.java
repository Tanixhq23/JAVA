// Topic: INBUILT SORT ALGORTIHM ------------------------------------------------>

import java.util.Arrays;
import java.util.Collections;

public class inbuiltsort {
// Info: PRINT ARRAY ------------------------------------------------>

    public static void printarr(Integer array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Integer arr[] = {5, 4, 3, 2, 1};
        /* Time complexity = O(nlogn) */
 /* Format = Arrays.sort(array_to_be_sorted, starting index, ending index(not included)) */

// Topic: INBUILT ASCENIDNG SORTING ------------------------------------------------>
        Arrays.sort(arr);
        printarr(arr);
        Arrays.sort(arr, 0, 3); // Info: From 0 to 2
        printarr(arr);

// Topic: REVERSE ORDER/DESCENDING INBUILT SORTING ------------------------------------------------>
        Arrays.sort(arr, Collections.reverseOrder());
        printarr(arr);
        Arrays.sort(arr, 0, 4, Collections.reverseOrder());
        printarr(arr);
    }
}
