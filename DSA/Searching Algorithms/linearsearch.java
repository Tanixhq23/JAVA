// // LINEAR SEARCH ALGORITHM ------------------------------------------------>

// import java.util.*;

public class linearsearch {

    public static void main(String args[]) {
        // Scanner sc = new Scanner(System.in);
        /* int array[] = {2, 4, 6, 8, 10, 12, 14, 16};
        System.out.print("Enter the element to search: ");
        int key = sc.nextInt();
        if (linearsearch1(array, key) == -1){
            System.out.println("Element not found!");
        }
        else{
            System.out.println("The element" + " '" + key + "' " + "is found at: " + linearsearch1(array, key));
        } */
    }

    public static int linearsearch1(int array[], int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }

        }
        return -1;
    }
}
