
// Topic: Stack Data Structure
import java.util.*;

public class stack {

    // Info: Stack using LinkedList
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class StackLL {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node temp = new Node(data);
            if (isEmpty()) {
                head = temp;
                System.out.println("' " + data + " '" + " pushed to the stack!");
                return;
            }
            temp.next = head;
            head = temp;
            System.out.println("' " + data + " '" + " pushed to the stack!");
        }

        public static void pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty! Please add data to the stack to perform the pop operation.");
                return;
            }
            int top = head.data;
            head = head.next;
            System.out.println("' " + top + " '" + " is removed successfully from the stack!");
        }

        public static void peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty! No top element to display.");
                return;
            }
            System.out.println("Top of the stack: " + head.data);
        }
    }

    // Info: Stack using ArrayList
    static class StackAL {
        static ArrayList<Integer> stack2 = new ArrayList<>();

        public static boolean isEmpty() {
            return stack2.size() == 0;
        }

        // Info: PUSH
        public static void push(int val) {
            stack2.add(val);
            System.out.println(val + " pushed onto the stack.");
        }

        // Info: POP
        public static void pop() {
            if (isEmpty()) {
                System.out.println("StackAL is empty. Please insert value to perform pop() operation!");
                return;
            }
            int top = stack2.get(stack2.size() - 1);
            stack2.remove(stack2.size() - 1);
            System.out.println("' " + top + " '" + " is removed successfully from the stack!");
        }

        // Info: PEEK
        public static int peek() {
            return stack2.get(stack2.size() - 1);
        }
    }

    // Solution 1: Push at the bottom of the stack
    public static void pushAtBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);

    }

    // Solution 2: Reverse a string using stack

    public static void reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            result.append(s.pop());
        }
        str = result.toString();
        System.out.println("Reversed String: " + str);
    }

    // Solution 3: Reverse Stack
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

    // Solution 4: Stock span
    public static void stockspan(int[] stocks, int[] span) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for (int i = 1; i < stocks.length; i++) {
            int currprice = stocks[i];
            while (!s.isEmpty() && currprice > stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevhigh = s.peek();
                span[i] = i - prevhigh;
            }
            s.push(i);
        }
    }

    // Solution 5: Next Greater
    public static void nextGreater(int[] arr, int[] nextgreater) {
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextgreater[i] = -1;
            } else {
                nextgreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    // Solution 6: Valid Parentheses
    public static boolean validparentheseshelper(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // Info: Opening bracket
            if (curr == '(' || curr == '{' || curr == '[') {
                s.push(curr);
            }
            // Info: Closing bracket
            else {
                if (s.isEmpty()) {
                    return false;
                }
                // Info: Comparing ASCII values of brackets (My method)
                if ((int) curr == 2 + (int) s.peek() || (int) curr == 1 + (int) s.peek()) {
                    s.pop();
                }
                // Info: Comapring directly the characters (Mam's method)
                if ((s.peek() == '(' && curr == ')') || (s.peek() == '{' && curr == '}')
                        || (s.peek() == '[' && curr == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void validparentheses(String str) {
        if (validparentheseshelper(str)) {
            System.out.println("The given string have valid parentheses");
            return;
        }
        System.out.println("The given string have no valid parentheses");
    }

    // Solution 7: Duplicate Parentheses
    public static boolean duplicateParentheseshelper(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // Info: Closing Condition
            if (curr == ')') {
                int count = 0;
                while (s.pop() != '(') {
                    count++;
                }
                if (count < 1) {
                    return true;
                }
            }
            // Info: Opening Condition
            else {
                s.push(curr);
            }
        }
        return false;
    }

    public static void duplicateParentheses(String str) {
        if (duplicateParentheseshelper(str)) {
            System.out.println("The given string have duplicate parentheses");
        } else {
            System.out.println("The given string do not have duplicate parentheses");
        }
    }

    // Solution 8: Max rectangular area in histogram
    public static int maxareahelper(int[] arr) {
        int maxarea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];
        // Info: Next smallest from Right
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        // Info: Next smallest from Left
        s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = arr.length;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        // Info: Current area
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currarea = height * width;
            maxarea = Math.max(currarea, maxarea);
        }
        return maxarea;
    }

    public static void maxarea(int arr[]) {
        System.out.println("Max area from given histogram: " + maxareahelper(arr));
    }

    // Solution 9: Decode String
    public static String decodeStringhelper(String str) {
        int num = 0;
        Stack<StringBuilder> strstack = new Stack<>();
        Stack<Integer> numstack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                int digit = ch - '0';
                num = num * 10 + digit;
            } else if (ch == '[') {
                strstack.push(sb);
                sb = new StringBuilder();
                numstack.push(num);
                num = 0;
            } else if (ch == ']') {
                StringBuilder temp = sb;
                sb = strstack.pop();
                int count = numstack.pop();
                while (count > 0) {
                    sb.append(temp);
                    count--;
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void decodeString(String str) {
        System.out.println("Decoded string: " + decodeStringhelper(str));
    }

    public static void main(String[] args) {
        // Info: Stack using ArrayList
        StackAL stack2 = new StackAL();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        stack2.push(6);
        while (!stack2.isEmpty()) {
            System.out.println(stack2.peek());
            stack2.pop();
        }
        // Info: Stack using LinkedList
        StackLL stack3 = new StackLL();
        stack3.push(1);
        stack3.push(2);
        stack3.push(3);
        while (!stack3.isEmpty()) {
            stack3.peek();
            stack3.pop();
        }
        // Info: Stack using Java Collection Framework
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        /*
         * while (!stack.isEmpty()) {
         * System.out.println(stack.peek());
         * stack.pop();
         * }
         */
        // Question 1: Push at the bottom of the stack
        // pushAtBottom(stack, 4);
        // printStack(stack);
        // Question 2: Reverse a string using stack
        String input = "Tanishq";
        reverseString(input);
        // Question 3: Reverse a Stack
        reverseStack(stack);
        printStack(stack);
        // Question 4: Stock span problem
        int[] stocks = { 100, 80, 60, 70, 60, 85, 100 };
        int[] span = new int[stocks.length];
        stockspan(stocks, span);
        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i] + " ");
        }
        // Question 5: Next Greater
        int[] arr = { 6, 8, 0, 1, 3 };
        int[] nextgreater = new int[arr.length];
        nextGreater(arr, nextgreater);
        for (int i = 0; i < nextgreater.length; i++) {
            System.out.print(nextgreater[i] + " ");
        }
        System.out.println();
        // Question 6: valid Parentheses
        String str = "({})[]";
        validparentheses(str);
        // Question 7: Duplicate parentheses
        String str1 = "(((a+b) + (c)))";
        String str2 = "((a+b)+(c))";
        duplicateParentheses(str1);
        duplicateParentheses(str2);
        // Question 8: Max rectangular area in histogram
        int height[] = { 2, 1, 5, 6, 2, 3 };
        maxarea(height);
        // Question 9: Decode string
        String input1 = "3[a2[c]]";
        decodeString(input1);
    }
}