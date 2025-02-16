// BINARY SEARCH 
import java.util.Scanner;

public class binarysearch {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int array[] = {2, 4, 6, 8, 10, 12, 14};
        System.out.println("Enter the key element: ");
        int key = sc.nextInt();
        // input(array);
        if (binarysearch1(array, key) == -1) {
            System.out.println("Element not found!");
        } else {
            System.out.println("Index for key is: " + binarysearch1(array, key));
        }
    }

    public static int binarysearch1(int array[], int key) {
        int start = array[0];
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key == array[mid]) {
                return mid;
            }
            if (key > array[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    /* public static void input(int array[]){
        Scanner sc = new Scanner (System.in);
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
    } */
}
