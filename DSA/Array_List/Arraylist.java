
import java.util.*;

public class Arraylist {

    public static void main(String[] args) {
        // Topic: Introduction
        // Info: Syntax
        /* ArrayList<Integer> list = new ArrayList<>(); */
        // Info: Adding elements to the list
        /* list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5); */
 /* System.out.println(list); */
        // Info: Get element in the list
        /* System.out.println(list.get(3)); */
        // Info: Removing elements in the list
        /* list.remove(2);
        System.out.println(list); */
        // Info: Set element at a particular index
        /* list.set(2,10);
        System.out.println(list); */
        // Info: Contains element method
        /* System.out.println(list.contains(1));
        System.out.println(list.contains(11)); */
        // Info: Adding element at a aprticular index
        /* list.add(2,9);
        System.out.println(list); */
        // Topic: Reverse of the list
        /* for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(); */
        // Topic: Maximum in the list
        /* int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
           max = Math.max(list.get(i), max);
        }
        System.out.println("Maximum element in the list: " + max); */
        // Topic: Swap 2 number in list
        /* list.add(2);
        list.add(5);
        list.add(9); 
        list.add(3);
        list.add(6);  */
 /* int index = 1;
        int index2 = 3;
        swap(list, index, index2);
        System.out.println(list); */
        // Topic: Inbuilt sort of Arraylist
        /* Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list); */
        // Topic: Multi- Dimensional ArrayList
        /* ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for(int i = 1; i<=5;i++){
            list1.add(i*1);
            list2.add(i*2);
            list3.add(i*3);
        }
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);
        for(int i = 0; i<mainList.size();i++){
            ArrayList<Integer> templist = mainList.get(i);
            for(int j=0;j<templist.size();j++){
                System.out.print(templist.get(j)+" ");
            }
            System.out.println();
        }
        System.out.println(mainList); */
        // Topic: Container with most water (BruteForce)
        /* ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println("Maximum water stored: " + ContainerwMW(height));
        System.out.println("Maximum water stored: " + ContainerwMW2(height)); */
        // Topic: Pair Sum-1
        // Info: BruteForce
        /* ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<6;i++){
            list.add(i);
        }  */
        /* System.out.println(pairSum1b(list,5)); */
        // Info: Optimized
        /* System.out.println(pairSum1(list,5)); */
        // Topic: Pair Sum-2
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(pairSum2(list, 16));

    }

    // Topic: Pair Sum-2
    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int bp = -1;
        int n = list.size();
        for (int i = 0; i < n; i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }
        int lp = bp + 1;
        int rp = bp;
        while (lp != rp) {
            // Info: Case-1
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }
            if (list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            }
            if (list.get(lp) + list.get(rp) > target) {
                rp = (n + rp - 1) % n;
            }
        }
        return false;
    }

    // Topic: Pair Sum-1 (Optimized O(n))
    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size() - 1;
        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }
            if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    // Topic: Pair Sum-1 (BruteForce O(n^2))
    public static boolean pairSum1b(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // Topic: Container with most water (Optimized)
    public static int ContainerwMW2(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.size() - 1;
        while (lp < rp) {
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    // Topic: Container with most water (BruteForce)
    public static int ContainerwMW(ArrayList<Integer> height) {
        int maxWater = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int width = j - i;
                int currstored = ht * width;
                maxWater = Math.max(maxWater, currstored);
            }
        }
        return maxWater;
    }

    // Topic: Swap 2 number in list
    public static void swap(ArrayList<Integer> list, int index, int index2) {
        System.out.println("Before Swapping: " + list);
        int temp = list.get(index);
        list.set(index, list.get(index2));
        list.set(index2, temp);
        System.out.println("After Swapping" + list);
    }
}
