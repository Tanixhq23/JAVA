import java.util.*;

public class QueueDS {

    // Topic: Queue using Arrays
    static class queue {
        static int arr[];
        static int size;
        static int rear;

        queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;

        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        // Info: Add Operation
        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full! Add operation cannot be performed!");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        // Info: Remove Operation
        public static void remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty! Pls add relevant data to perform remove operation!");
            }
            int front = arr[0];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            System.out.println("' " + front + " ' " + "is removed succesfully!");
        }

        // Info: Peek Operation
        public static void peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.println("Peek of the Queue: " + arr[0]);
        }

        // Info: Print Queue
        public static void print() {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }

    // Topic: Circular Queue using Arrays

    static class cirqueue {
        static int arr[];
        static int size;
        static int front;
        static int rear;

        cirqueue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;

        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // Info: Add operation
        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full! Add operation cannot be performed!");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // Info: Remove operation
        public static void remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty! Pls add relevant data to perform remove operation!");
            }
            int result = arr[front];

            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            System.out.println("' " + result + " ' " + "is removed succesfully!");
        }

        // Info: Peek operation
        public static void peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.println("Peek of the Queue: " + arr[front]);
        }

        // Info: Print
        public static void print() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            int i = front;
            while (true) {
                System.out.print(arr[i] + " ");
                if (i == rear)
                    break;
                i = (i + 1) % size;
            }
            System.out.println();
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Topic: Queue using linkedlist
    static class queuell {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // Info: Add Operation
        public static void add(int data) {
            Node temp = new Node(data);
            if (head == null) {
                head = tail = temp;
                return;
            }
            tail.next = temp;
            tail = temp;
            System.out.println("'" + data + "' " + "is enqueued");
        }

        // Info: Remove Operation
        public static void remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty! unable to perform dequeue operation");
            }
            int front = head.data;
            if (head == tail) {
                head = tail = null;
                System.out.println("'" + front + "' " + "is dequeued");
                return;
            } else {
                head = head.next;
                return;
            }
        }

        // Info: Peek operation
        public static void peek() {
            System.out.println("Peek: " + "'" + head.data + "'");
        }

        // Info: Print
        public static void print() {
            Node temp = head;
            while (temp.next != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    static class queue_stack1 {
        static Stack<Integer> s1 = new Stack();
        static Stack<Integer> s2 = new Stack();

        // Info: is empty
        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // Info: Add operation
        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // Info: Remove operation
        public static void remove() {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty!");
                return;
            }
            int data = s1.pop();
            System.out.println(data + " removed successfully");
        }

        // Info: Peek operation
        public static int peek() {
            return s1.peek();
        }
    }

    static class queue_stack2 {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        // Info: is empty
        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // Info: Add
        public static void add(int data) {
            s1.push(data);
        }

        // Info: Remove
        public static void remove() {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty!");
                return;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int data = s2.pop();
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            System.out.println(data + " removed successfully");
        }

        // Info: Peek
        public static int peek() {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int peek = s2.peek();
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return peek;
        }

    }

    // Topic: Stack using 2 queue
    static class stack_queue1 {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // Info: Add operation
        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        // Info: Remove operation
        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }

            int top = -1;

            // Info: Elements in q1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        // Info: Peek operation
        public static int peek() {
            if (!isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            int top = -1;
            // Info: Elements in q1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    // Solution 1: First Non repeating Character
    public static void firstnonrepeating(String str) {
        Queue<Character> q = new LinkedList<>();
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek());
            }
            System.out.println();
        }
    }

    // Solution 2: Interlink of two halves of the queue
    public static void interLeave(Queue<Integer> input) {
        int size = input.size();
        Queue<Integer> q1 = new LinkedList<>();
        // Info: Divide the input queue into two halves
        for (int i = 0; i < size / 2; i++) {
            q1.add(input.remove());
        }
        // Info: Interlink the two queues back into input
        while (!q1.isEmpty()) {
            input.add(q1.remove());
            input.add(input.remove());
        }
    }

    // Solution 3: Queue Reversal
    public static void queuereverse(Queue<Integer> input) {
        Stack<Integer> s = new Stack<>();
        while (!input.isEmpty()) {
            s.push(input.remove());
        }
        while (!s.isEmpty()) {
            input.add(s.pop());
        }
    }

    // Topic: Stack using deque
    static class stack_deque {
        static Deque<Integer> d = new LinkedList<>();

        public static void push(int data) {
            System.out.println(data + " is added to the stack");
            d.addLast(data);
        }

        public static void pop() {
            if (d.isEmpty()) {
                System.out.println("Stack is empty");
            }
            System.out.println(d.removeLast() + " Removed from the stack");
        }

        public static void peek() {
            if (d.isEmpty()) {
                System.out.println("Stack is empty");
            }
            System.out.println("Peek of the stack: " + d.getLast());
        }
    }

    // Topic: Queue using dequeue
    static class queue_deque {
        static Deque<Integer> d = new LinkedList<>();

        public static void add(int data) {
            System.out.println(data + " is added to the Queue");
            d.addLast(data);
        }

        public static void remove() {
            if (d.isEmpty()) {
                System.out.println("Queue is empty!");
            }
            System.out.println(d.removeFirst() + " Removed from the stack");
        }

        public static void peek() {
            if (d.isEmpty()) {
                System.out.println("Queue is empty!");
            }
            System.out.println("Peek of the Queue: " + d.getFirst());
        }

    }

    // Solution 4: Generate binary numbers
    public static String generatebinaryno(int n) {
        Queue<String> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add("1");
        while (n != 0) {
            String s1 = q.remove();
            sb.append(s1 + " ");
            q.add(s1 + "0");
            q.add(s1 + "1");
            n--;
        }
        return sb.toString();
    }

    // Solution 5: minimum costs of connecting n ropes
    public static void mincostofnropes(int[] arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
        }
        int res = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            res += first + second;
            pq.add(first + second);
        }
        System.out.println("Minimum cost of connect " + "'" + n + "' " + "ropes is: " + res);
    }

    // Solution 6: Reverse the first k elements of queue
    public static void rversekel(int k, Queue<Integer> q) {
        if (k > q.size() || k <= 0) {
            System.out.println("Invalid operation");
            return;
        }
        Stack<Integer> s = new Stack<>();
        int count = q.size() - k;
        while (k != 0) {
            s.push(q.remove());
            k--;
        }
        // Queue<Integer> temp = new LinkedList<>();
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        while (count != 0) {
            q.add(q.remove());
            count--;
        }
    }

    // Solution 7: Sliding Window problem
    public static void slidingwindow(int[] arr, int k ){
        Deque<Integer> dq = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            if(!dq.isEmpty() && dq.peek()==i-k){
                dq.remove();
            }
            while(!dq.isEmpty() && arr[dq.getLast()]<arr[i]){
                dq.removeLast();
            }
            dq.add(i);
            if(i>=k-1){
                res.add(arr[dq.peek()]);
            }
        }
        System.out.println("Maximum of all subarrays of size " + "'" + k + "'" + " are: " + res);
    } 

    public static void main(String[] args) {
        // Topic: Queue using arrays
        queue q = new queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.print();
        // Topic: Circular Queue using arrays
        cirqueue q1 = new cirqueue(3);
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.print();
        q1.remove();
        q1.print();
        q1.add(4);
        q1.print();
        q1.remove();
        q1.print();
        q1.add(5);
        q1.print();
        // Topic: Queue Using linkedlist
        queuell q2 = new queuell();
        q2.add(0);
        q2.add(1);
        q2.add(2);
        q2.add(3);
        q2.add(4);
        q2.print();
        // Topic: Queue Using 2 Stack
        queue_stack1 q3 = new queue_stack1();
        q3.add(1);
        q3.add(2);
        q3.add(3);
        q3.add(4);
        while (!q3.isEmpty()) {
            System.out.println(q3.peek());
            q3.remove();
        }
        queue_stack2 q4 = new queue_stack2();
        q4.add(1);
        q4.add(2);
        q4.add(3);
        q4.add(4);
        while (!q4.isEmpty()) {
            System.out.println(q4.peek());
            q4.remove();
        }
        // Topic: Stack Using 2 Queue
        stack_queue1 s = new stack_queue1();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
        // Question 1: First Non repeating letter
        String str = "aabccxb";
        firstnonrepeating(str);
        // Question 2: Interlink of two halves of the queue
        Queue<Integer> input = new LinkedList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        input.add(6);
        input.add(7);
        input.add(8);
        input.add(9);
        input.add(10);
        interLeave(input);
        while (!input.isEmpty()) {
            System.out.print(input.remove());
        }
        System.out.println();
        // Question 3: Queue reverse
        Queue<Integer> input2 = new LinkedList<>();
        input2.add(1);
        input2.add(2);
        input2.add(3);
        input2.add(4);
        input2.add(5);
        queuereverse(input2);
        while (!input2.isEmpty()) {
            System.out.print(input2.remove() + " ");
        }
        System.out.println();
        // Topic: Stack using Deque
        stack_deque sdeque = new stack_deque();
        sdeque.push(1);
        sdeque.push(2);
        sdeque.push(3);
        sdeque.push(4);
        sdeque.push(5);
        sdeque.peek();
        sdeque.pop();
        sdeque.peek();
        // Topic: Queue using Deque
        queue_deque qdeque = new queue_deque();
        qdeque.add(1);
        qdeque.add(2);
        qdeque.add(3);
        qdeque.add(4);
        qdeque.add(5);
        qdeque.peek();
        qdeque.remove();
        qdeque.peek();
        // Question 4: Generate Binary Number
        System.out.println(generatebinaryno(12));
        // Question 5: Minimum costs of connecting n ropes
        int[] arr = { 4, 3, 2, 6 };
        mincostofnropes(arr, 4);
        // Question 6: Reverse the first k elements of queue
        Queue<Integer> rkel = new LinkedList<>();
        rkel.add(10);
        rkel.add(20);
        rkel.add(30);
        rkel.add(40);
        rkel.add(50);
        rkel.add(60);
        rkel.add(70);
        rkel.add(80);
        rkel.add(90);
        rkel.add(100);
        rversekel(5, rkel);
        while (!rkel.isEmpty()) {
            System.out.println(rkel.peek());
            rkel.remove();
        }
        // Question 7: Sliding window problem
        int[] nums = {1,2,3,1,4,5,2,3,6};
        slidingwindow(nums, 3);
    }
}
