public class Rough {
    // Info: Node of the Rough
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
        Rough ll = new Rough();
        ll.print();
        ll.addlast(8);
        ll.addlast(12);
        ll.addlast(10);
        ll.addlast(5);
        ll.addlast(1);
        ll.addlast(6);
        ll.oddevenll();
        ll.print();
    }
}