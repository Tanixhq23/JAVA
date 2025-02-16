// Topic: Count Sort
public class countsort {

    public static void printarr(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void countingsort(int array[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            largest = Math.max(largest, array[i]);
        }

        // Info: FREQUENCY
        int count[] = new int[largest + 1];
        for(int i = 0; i<array.length; i++){
            count[array[i]]++;
        }

        // Info: SORTING
        int j = 0;
        for(int i = 0; i<count.length; i++){
            while(count[i]>0){
                array[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String args[]) {
        int array[] = {1,4,1,3,2,4,3,7};
        countingsort(array);
        printarr(array);
    }
}
