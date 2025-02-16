

public class DoubleLL {
    public static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Info: Addition of nodes
    public void addfirst(int data) {
        Node temp = new Node(data);
        size++;
        if (head == null) {
            head = tail = temp;
            return;
        }
        temp.next = head;
        head.prev = temp;
        head = temp;
    }

    public void addlast(int data){
        Node temp = new Node(data);
        size++;
        if(head==null){
            head=tail=temp;
            tail.next=null;
            return;
        }
        tail.next=temp;
        temp.prev=tail;
        tail=temp;
    }

    public void add(int idx , int data){
        if(idx==0){
            addfirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        size++;
        int i = 0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        Node temp2 = temp.next;
        newNode.next = temp2;
        temp2.prev = newNode;
        newNode.prev = temp; 
        temp.next = newNode;
    }

    // Info: Removal of Nodes
    public int removefirst(){
        if(head == null){
            System.out.println("DLL is empty!");
            return Integer.MIN_VALUE;
        }
        if(size== 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        System.out.println("Node: " + head.data + " is removed successfully!");
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public int removelast(){
        Node temp = head;
        if(head == null){
            System.out.println("DLL is empty!");
            return Integer.MIN_VALUE;
        }
        if(size== 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        while(temp.next.next!=null){
            temp = temp.next;
        }
        int val = tail.data;
        System.out.println("Node: " + val + " is removed successfully!");
        tail.prev = null;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    public int remove(int idx){
        if(head == null){
            System.out.println("DLL is empty!");
            return Integer.MIN_VALUE;
        }
        if(idx==0){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int i = 0;
        Node temp= head;
        size--;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        Node temp2 = temp.next.next;
        Node delNode = temp.next;
        int val = delNode.data; 
        System.out.println("Node: " + delNode.data + " is removed successfully!");
        temp.next = temp2;
        temp2.prev = temp;
        return val;      
    }

    // Info: print linkedlist
    public void print() {
        Node temp = head;
        while (temp != null) {

            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    // Info: Reverse DLL
    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        // Info: Addition of Nodes in DLL
        dll.addfirst(2);
        dll.addfirst(1);
        dll.print();
        dll.addlast(4);
        dll.addlast(5);
        dll.addlast(6);
        dll.print();
        dll.add(2,3);
        dll.print();
        System.out.println(dll.size);
        // Info: Removal of Nodes in DLL
        /* dll.removefirst();
        dll.print();
        dll.removelast();
        dll.print();
        System.out.println(dll.size);
        dll.remove(3);
        dll.print(); */
        // Info: Reverse DLL
        dll.reverse();
        dll.print();
        dll.reverse();
    }
}