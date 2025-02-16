import java.util.*;

public class heap {

    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;

        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    // Info: Important!!!!!!!!!!!!!!!!!!!!!!!!!

    public static void printheap(PriorityQueue<Integer> pq) {
        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }
        System.out.println();
    }

    public static void printheapclass(PriorityQueue<Student> pq) {

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + "->" + pq.remove().rank);
        }
    }

    // Info: Insert in heap
    static class MinHeap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            // Info: Add at last idx
            arr.add(data);
            int x = arr.size() - 1; //x is child idx
            int par = (x - 1) / 2; // par is parent idx

            while (arr.get(x) < arr.get(par)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minidx = i;
            if (left < arr.size() && arr.get(minidx) > arr.get(left)) {
                minidx = left;
            }
            if (right < arr.size() && arr.get(minidx) > arr.get(right)) {
                minidx = right;
            }

            if (minidx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minidx));
                arr.set(minidx, temp);

                heapify(minidx);
            }
        }

        public int remove() {
            int data = arr.get(0);
            // step1: swap last and first
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // step2: delete last
            arr.remove(arr.size() - 1);

            // step3: fix heap -> heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    static class MaxHeap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            // Step1 : Add in arr
            arr.add(data);
            int x = arr.size() - 1; //x is child idx
            int par = (x - 1) / 2; // par is parent idx

            while (arr.get(x) > arr.get(par)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minidx = i;
            if (left < arr.size() && arr.get(minidx) < arr.get(left)) {
                minidx = left;
            }
            if (right < arr.size() && arr.get(minidx) < arr.get(right)) {
                minidx = right;
            }

            if (minidx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minidx));
                arr.set(minidx, temp);

                heapify(minidx);
            }
        }

        public int remove() {
            int data = arr.get(0);
            // step1: swap last and first
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // step2: delete last
            arr.remove(arr.size() - 1);

            // step3: fix heap -> heapify
            heapify(0);
            return data;
        }
    }

    // Info: HEAP SORT
    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;
        if (left < size && arr[left] < arr[maxIdx]) {
            maxIdx = left;
        }
        if (right < size && arr[right] < arr[maxIdx]) {
            maxIdx = right;
        }
        if (maxIdx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapify(arr, maxIdx, size);
        }
    }

    public static void heapSort(int arr[]) {
        // Build maxheap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }
        // Puch largest at end
        for (int i = n - 1; i > 0; i--) {
            // swap (largest-first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }

    }

    // Topic: Nearby Cars
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distsq;
        int idx;

        public Point(int x, int y, int distsq, int idx) {
            this.x = x;
            this.y = y;
            this.distsq = distsq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distsq - p2.distsq; //ascending order
        }
    }

    // Topic: Weakest Soldier
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.idx = idx;
            this.soldiers = soldiers;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soldiers - r2.soldiers == 0) {
                return this.idx - r2.idx;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
    }

    // Topic: Sliding window maximum
    static class pair implements Comparable<pair> {
        int val;
        int idx;

        public pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(pair p2) {
            // ascending
            // return this.val - p2.val;
            // descending
            return p2.val - this.val;
        }

    }

    // Sol: getallkthlargest
    static PriorityQueue<Integer> min;
    static int k;

    public static List<Integer> getAllKthNumber(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int val : arr) {
            if (min.size() < k) {
                min.add(val);
            } else {
                if (val > min.peek()) {
                    min.remove();
                    min.add(val);
                }
            }
            if (min.size() >= k) {
                list.add(min.peek());
            }
            // else {
            //     list.add(-1);
            // }
        }
        return list;
    }

    // Sol: Minimum Operations to Halve Array Sum
    public static int minOpshavlearraySum(ArrayList<Integer> nums) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            pq.add(nums.get(i));
        }
        int target = sum / 2;
        int cnt = 0;
        while (sum > target) {
            int highest = pq.remove();
            sum -= highest;
            highest /= 2;
            sum += highest;
            pq.add(highest);
            cnt++;
        }
        return cnt;
    }

    // Sol: Merge K Sorted Linked List
    static class Node implements Comparable<Node> {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }

        @Override
        public int compareTo(Node n1) {
            return this.data - n1.data;
        }
    }

    public static Node mergeKList(Node[] arr, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node head = new Node(0);
        Node tail = head;
        for (int i = 0; i < k; i++) {
            if (arr[i] != null) {
                pq.add(arr[i]);
            }
        }
        // If linkedlist is empty
        if (pq.isEmpty()) {
            return null;
        }
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            tail.next = curr;
            tail = tail.next;
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return head.next;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        // Topic: PRIORITY QUEUE
        // Info: Implementation of priority queue using JCF
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // pq.add(3);
        // pq.add(4);
        // pq.add(1);
        // pq.add(7);
        // printheap(pq);
        // NOTE: How to sort or compare objects of classes
        // PriorityQueue<Student> pq1 = new PriorityQueue<>();
        // pq1.add(new Student("Tansihq", 75000));
        // pq1.add(new Student("Ashwin", 750000));
        // pq1.add(new Student("", 750900));
        // printheapclass(pq1);
        // Topic: HEAP
        // Info: insertion in Heap
        // MinHeap h = new MinHeap();
        // h.add(3);
        // h.add(4);
        // h.add(1);
        // h.add(5);
        // Info: Get min heap
        // h.peek();
        // Info: Delete in min heap 
        // while (!h.isEmpty()) {
        //     System.out.println(h.peek());
        //     h.remove();
        // }
        // MaxHeap h2 = new MaxHeap();
        // h2.add(3);
        // h2.add(4);
        // h2.add(1);
        // h2.add(5);
        // Info: Get min heap
        // h.peek();
        // Info: Delete in min heap 
        // while (!h2.isEmpty()) {
        //     System.out.println(h2.peek());
        //     h2.remove();
        // }
        // Info: Heap Sort
        // int arr[] = { 1, 2, 4, 5, 3 };
        // heapSort(arr);
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }

        // System.out.println();

        // Topic: Nearby Cars
        // int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        // int k = 2;
        // PriorityQueue<Point> pq = new PriorityQueue<>();
        // for (int i = 0; i < pts.length; i++) {
        //     pq.add(new Point(pts[i][0], pts[i][1], (pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1]), i));
        // }

        // // nearest k cars
        // for (int i = 0; i < k; i++) {
        //     System.out.print("C" + pq.remove().idx);
        // }
        // Topic: Connect N ropes with minimum cost
        // int ropes[] = { 2, 3, 3, 4, 6 };
        // PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        // for (int i = 0; i < ropes.length; i++) {
        //     pq2.add(ropes[i]);
        // }
        // int cost = 0;
        // while (pq2.size() > 1) {
        //     int min = pq2.remove();
        //     int min2 = pq2.remove();
        //     cost += min + min2;
        //     pq2.add(min + min2);
        // }
        // System.out.println("Minium cost: " + cost);
        // Topic: Weakest Soldier
        // int army[][] = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
        // int k = 2;
        // PriorityQueue<Row> pq3 = new PriorityQueue<>();
        // for (int i = 0; i < army.length; i++) {
        //     int count = 0;
        //     for (int j = 0; j < army[0].length; j++) {
        //         count += army[i][j] == 1 ? 1 : 0;
        //     }
        //     pq3.add(new Row(count, i));
        // }
        // for(int i = 0 ; i<k;i++){
        //     System.out.println("R" + pq3.remove().idx);
        // }
        // Topic: Sliding window maximum O(nlogk)
        // int arr2[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        // int k = 3;
        // int res[] = new int[arr2.length - k + 1];
        // PriorityQueue<pair> pq4 = new PriorityQueue<>();
        // // Info: 1st window
        // for (int i = 0; i < k; i++) {
        //     pq4.add(new pair(arr2[i], i));
        // }
        // res[0] = pq4.peek().val;
        // for (int i = k; i < arr2.length; i++) {
        //     while (pq4.size() > 0 && pq4.peek().idx <= (i - k)) {
        //         pq4.remove();
        //     }
        //     pq4.add(new pair(arr2[i], i));
        //     res[i - k + 1] = pq4.peek().val;
        // }
        // for (int i = 0; i < res.length; i++) {
        //     System.out.print(res[i] + " ");
        // }
        // Topic: Kth Largest Element
        // min = new PriorityQueue<>();
        // k = 4;
        // int arr[] = { 1, 2, 3, 4, 5, 6 };
        // List<Integer> res = getAllKthNumber(arr);
        // for (int x : res) {
        //     System.out.print(x + " ");
        // }
        // Ques: Minimum Operation to halve array sum
        ArrayList<Integer> nums = new ArrayList<>();
        // nums.add(4);
        // nums.add(6);
        // nums.add(3);
        // nums.add(9);
        // nums.add(10);
        // nums.add(2);
        nums.add(10);
        // nums.add(20);
        // nums.add(7);
        int count = minOpshavlearraySum(nums);
        System.out.println(count);
        // Ques: Merge K Sorted linkedlist
        int N = 3;
        Node[] a = new Node[N];
        Node head1 = new Node(1);
        a[0] = head1;
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);
        Node head2 = new Node(2);
        a[1] = head2;
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);
        Node head3 = new Node(0);
        a[2] = head3;
        head3.next = new Node(9);
        head3.next.next = new Node(10);
        head3.next.next.next = new Node(11);
        Node res = mergeKList(a, N);
        if (res != null) {
            printList(res);
        }
        System.out.println();
    }
}