
public class Linkedlist {

    // Info: Node of the Linkedlist
    public static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addfirst(int data) {
        // Info: create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // Info: next=head
        newNode.next = head;
        // Info: head=newNode
        head = newNode;
    }

    public void addlast(int data) {
        // Info: create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            tail.next = null;
            return;
        }
        // Info: tail's next= new node
        tail.next = newNode;
        // Info: tail = newnode
        tail = newNode;
    }

    public void print() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        // Info: create a curr node
        Node curr = head;
        while (curr != null) {
            // Info: Print the data
            System.out.print(curr.data + "->");
            // Info: Step to the next node
            curr = curr.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addfirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node curr = head;
        int i = 0;
        while (i < idx - 1) {
            curr = curr.next;
            i++;
        }
        // Info: i == idx-1, curr(prev)
        newNode.next = curr.next;
        curr.next = newNode;
    }

    public int removefirst() {
        if (size == 0) {
            System.out.println("List is empty ");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removelast() {
        if (size == 0) {
            System.out.println("List is empty ");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // Info: i=size-2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public static int remove(int idx) {
        Node curr = head;
        if (head == null) {
            System.out.println("DLL is empty!");
            return Integer.MIN_VALUE;
        }
        if (idx == 0) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        size--;
        int i = 0;
        while (i < idx - 1) {
            curr = curr.next;
            i++;
        }
        Node del = curr.next;
        int val = del.data;
        System.out.println("Node: " + del.data + " is removed successfully!");
        curr.next = curr.next.next;
        return val;
    }

    public int itrsearch(int key) {
        Node curr = head;
        int i = 0;
        while (curr != null) {
            if (curr.data == key) {
                return i;
            }
            curr = curr.next;
            i++;
        }
        return -1;
    }

    public static int helperrcsearch(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helperrcsearch(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public static int recsearch(int key) {
        return helperrcsearch(head, key);
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deletenthfromend(int n) {
        int sz = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            sz++;
        }

        if (n == sz) {
            head = head.next;
            return;
        }
        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
    }

    public Node midNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean ispalindromehelper() {
        if (head == null || head.next == null) {
            return true;
        }
        // Step-1: Calculate mid node
        Node midNode = midNode(head);
        // Step-2: reverse Linkedlist
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // Step-3: Is left LL = right LL
        Node right = prev;
        Node left = head;
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    public void isPalindrome() {
        if (ispalindromehelper()) {
            System.out.println("Given Linkedlist is palindrome!");
        } else {
            System.out.println("Given Linkedlist is not a palindrome!");
        }
    }

    public static boolean isCyclehelper() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void isCycle() {
        if (isCyclehelper()) {
            System.out.println("Cycle is present!");
        } else {
            System.out.println("Cycle is not present! ");
        }
    }

    public static void removecycle() {
        // Info: Detect Cycle
        Node slow = head, fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }
        // Info: Find meeting Point
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // Info: Remove Cycle
        prev.next = null;
        System.out.println("Cycle has been successfully removed!");

    }

    private static Node getMid(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node merge(Node head1, Node head2) {
        Node mergedll = new Node(-1);
        Node curr = mergedll;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                curr.next = head1;
                head1 = head1.next;
                curr = curr.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
                curr = curr.next;
            }
        }

        while (head1 != null) {
            curr.next = head1;
            head1 = head1.next;
            curr = curr.next;
        }
        while (head2 != null) {
            curr.next = head2;
            head2 = head2.next;
            curr = curr.next;
        }
        return mergedll.next;
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle node
        Node mid = getMid(head);

        // Split into two halves
        Node rightHead = mid.next;
        mid.next = null;

        // Sort each half recursively
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Merge the sorted halves
        return merge(newLeft, newRight);
    }

    public static void zigzag() {
        // Info: Find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        // Info: reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Info: alternate merge/zigzag merge
        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }

    }

    // Solution: Delete N nodes after M nodes
    public static void deleteNafterM(int n, int m) {
        Node curr = head, t;
        while (curr != null) {
            for (int count = 1; count < m && curr != null; count++) {
                curr = curr.next;
            }
            t = curr.next;
            for (int count = 1; count <= n && t != null; count++) {
                Node temp = t;
                t = t.next;
            }
            curr.next = t;
            curr = t;
        }
    }

    // Solution: Swapping two nodes
    public static void swapnodes(int x, int y) {
        if (x == y) {
            return;
        }
        Node prevX = null, prevY = null;
        Node currX = head, currY = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }
        if (currX == null || currY == null) {
            return;
        }
        if (prevX != null)
            prevX.next = currY;
        else
            head = currY;
        if (prevY != null)
            prevY.next = currX;
        else
            head = currX;
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp; 
    }

    public static Node oddevenll(){
        Node evenTemp = head;
        Node oddTemp = head;
        Node resll = new Node(-1);
        Node temp = resll;
        while(evenTemp.next!=null && oddTemp.next!=null){
            if(evenTemp.data%2 == 0){
                temp.next = evenTemp;
                temp= temp.next;
                evenTemp = evenTemp.next;
            }
            else{
                temp.next = oddTemp;
                temp= temp.next;
                evenTemp = evenTemp.next;
            }
        }   
        return resll.next;
    }

    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        ll.print();
        // Info: Add first
        ll.addfirst(2);
        ll.addfirst(1);
        // Info: Add last
        ll.addlast(4);
        ll.addlast(5);
        // Info: print ll
        ll.print();
        // Info: Add in middle of ll
        ll.add(2, 3);
        ll.print();
        // Info: Size of ll
        System.out.println("Size of Linked List is: " + size);
        // Info: Remove First
        ll.addfirst(23);
        System.out.println(ll.removefirst() + " Removed from the list");
        ll.print();
        // Info: Remove Last
        ll.addlast(69);
        System.out.println(ll.removelast() + " Removed from the list");
        ll.print();
        System.out.println("Size of Linked List is: " + size);
        // Info: Search(iterative)
        System.out.println("Element found at index: " + ll.itrsearch(3));
        System.out.println("Element found at index: " + ll.itrsearch(10));
        // Info: Search(recursive)
        System.out.println("Element found at index: " + recsearch(4));
        // Info: Reverse Linkedlist
        ll.reverse();
        ll.print();
        ll.reverse();
        // Info: Find and remove Nth Node from end
        ll.deletenthfromend(3);
        ll.print();
        // Info: Is palindrome?
        ll.print();
        ll.reverse();
        ll.removefirst();
        ll.removefirst();
        ll.addfirst(2);
        ll.addfirst(1);
        ll.print();
        ll.isPalindrome(); // Info: Check palindrome
        ll.removefirst();
        ll.removefirst();
        ll.addfirst(3);
        ll.addfirst(4);
        ll.addfirst(5);
        ll.reverse();
        ll.addfirst(1);
        // Info: Check if there cycle/loop present in Linkedlist
        /*
         * head = new Node(1);
         * head.next = new Node(2);
         * Node curr = new Node(3);
         * head.next.next = curr;
         * head.next.next.next = new Node(4);
         * head.next.next.next.next= curr;
         * isCycle();
         */
        // Info: Remove Cycle
        removecycle();
        // Info: Inuilt LinkedList from Java Collections Framework
        // Info: Creation
        /* LinkedList<Integer> ll1 = new LinkedList<>(); */
        // Info: Operations on linkedlist
        // Addition
        /*
         * ll1.addLast(1);
         * ll1.addLast(2);
         * ll1.addfirst(0);
         */
        // Print List
        /* System.out.println(ll1); */
        // Remove
        /*
         * ll1.removeLast();
         * ll1.removeFirst();
         * System.out.println(ll1);
         */
        // Info: Merge Sort
        ll.reverse();
        ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.print();
        // Info: Zig-Zag Linkedlist
        ll.reverse();
        ll.addfirst(6);
        ll.reverse();
        ll.zigzag();
        ll.print();
        ll.remove(3);
        ll.remove(1);
        ll.print();
        ll.add(4, 5);
        ll.add(5, 6);
        ll.print();
        // Question 1: Delete N nodes after M nodes
        ll.add(6, 7);
        ll.add(7, 8);
        ll.print();
        ll.deleteNafterM(2, 3);
        ll.print();
        // Question 2: Swap two nodes in linkedlist
        ll.swapnodes(7, 3);
        ll.print();
        ll.swapnodes(7, 3);
        // Question 3: Odd even linkedlist
        ll.oddevenll();
        ll.print();
    }
}