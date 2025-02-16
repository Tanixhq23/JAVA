import java.util.*;

public class bst {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data > data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Topic: Search in BST
    public static boolean searchhelper(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return searchhelper(root.left, key);
        } else {
            return searchhelper(root.right, key);
        }
    }

    public static void search(Node root, int key) {
        if (searchhelper(root, key) == true) {
            System.out.println("The given key" + " '" + key + "' " + " is present in the tree");
        } else {
            System.out.println("The given key" + " '" + key + "' " + "is not present in the tree!");
        }
    }

    // Topic: Delete node in BST

    public static Node delete(Node root, int data) {
        if (root.data < data) {
            root.right = delete(root.right, data);
        } else if (root.data > data) {
            root.left = delete(root.left, data);
        } else {//Voila
                // Case 1: Leaf Node 
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: Single Child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Both Children
            // Info: Inorder Successor: Leftmost Node in Right subtree
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Topic: Print in range
    public static void printinRangehelper(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printinRangehelper(root.left, k1, k2);
            System.out.print(root.data + " ");
            printinRangehelper(root.right, k1, k2);
        } else if (root.data > k2) {
            printinRangehelper(root.right, k1, k2);
        } else {
            printinRangehelper(root.right, k1, k2);
        }
    }

    // Topic: Root to leaf path
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }

    // Topic: Validate BST
    public static boolean isValidBSThelper(Node root, Node max, Node min) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }
        return isValidBSThelper(root.left, root, min) && isValidBSThelper(root.right, max, root);
    }

    public static void isValidBST(Node root, Node min, Node max) {
        if (isValidBSThelper(root, max, min)) {
            System.out.println("The given tree is valid");
        } else {
            System.out.println("The given tree is not valid");
        }
    }

    // Topic: Mirror BST
    public static Node mirrorBST(Node root) {
        if (root == null) {
            return null;
        }
        Node LeftMirror = mirrorBST(root.left);
        Node RightMirror = mirrorBST(root.right);
        root.left = RightMirror;
        root.right = LeftMirror;
        return root;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Sol 1:
    public static int rangesumBST(Node root, int k1, int k2) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        if (root.data >= k1 && root.data <= k2) {
            sum += root.data;
            sum += rangesumBST(root.left, k1, k2);
            sum += rangesumBST(root.right, k1, k2);
        } else if (root.data > k2) {
            sum += rangesumBST(root.left, k1, k2);
        } else {
            sum += rangesumBST(root.right, k1, k2);
        }
        return sum;
    }

    // Topic: Create a Balanced BST

    public static Node createBST(int[] arr, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid - 1);
        root.right = createBST(arr, mid + 1, end);
        return root;
    }

    // Topic: Convert into balanced BST
    public static void getInorder(Node root, ArrayList<Integer> IS) {
        if (root == null) {
            return;
        }
        getInorder(root.left, IS);
        IS.add(root.data);
        getInorder(root.right, IS);
    }

    // public static Node createBST(ArrayList<Integer> inorder, int st, int end) {
    //     if (st > end) {
    //         return null;
    //     }
    //     int mid = (st + end) / 2;
    //     Node root = new Node(inorder.get(mid));
    //     root.left = createBST(inorder, st, mid - 1);
    //     root.right = createBST(inorder, mid + 1, end);
    //     return root;
    // }

    // public static Node balancedBST(Node root) {
    //     // Inorder Sequence
    //     ArrayList<Integer> IS = new ArrayList<>();
    //     getInorder(root, IS);
    //     // Sorted arraylist -> Balanced BST
    //     root = createBST(IS, 0, IS.size() - 1);
    //     return root;
    // }

    // Topic: Size of the largest BST in given BT
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    public static int maxBST = 0;
    public static Node maxBSTNode = null;

    public static Info largestsBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        // LS ans RS Info
        Info leftinfo = largestsBST(root.left);
        Info rightinfo = largestsBST(root.right);

        int size = leftinfo.size + rightinfo.size + 1;
        int min = Math.min(root.data, Math.min(leftinfo.min, rightinfo.min));
        int max = Math.max(root.data, Math.max(leftinfo.max, rightinfo.max));

        // isBST
        if (root.data <= leftinfo.max || root.data >= rightinfo.min) {
            return new Info(false, size, min, max);
        }
        if (leftinfo.isBST && rightinfo.isBST) {
            maxBST = Math.max(maxBST, size);
            maxBSTNode = root;
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);

    }

    // Topic: Merge 2 BSTs
    public static Node mergeBSTs(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);
        // Merge
        int i = 0;
        int j = 0;
        ArrayList<Integer> finalarr = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalarr.add(arr1.get(i));
                i++;
            } else {
                finalarr.add(arr2.get(j));
                j++;
            }
        }
        while (i < arr1.size()) {
            finalarr.add(arr1.get(i));
            i++;
        }
        while (j < arr2.size()) {
            finalarr.add(arr2.get(j));
            j++;
        }
        // Create BST
        return createBST(finalarr, 0, finalarr.size() - 1);
    }

    public static Node createBST(ArrayList<Integer> inorder, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid - 1);
        root.right = createBST(inorder, mid + 1, end);
        return root;
    }

    // Sol : Closest element in the tree
    public static Node closest(Node root, int k) {
        if (root == null) {
            return null;
        }
        int mindiff = Integer.MAX_VALUE;
        Node closestel = null;
        while (root != null) {
            int currdiff = Math.abs(root.data - k);
            if (currdiff < mindiff) {
                mindiff = currdiff;
                closestel = root;
            }

            if (k > root.data) {
                root = root.right;
            } else if (k < root.data) {
                root = root.left;
            } else {
                break;
            }
        }
        return closestel;
    }

    // Sol : Kth largest element of the BST
    public static void kthlargestBST(Node root, int k) {
        ArrayList<Integer> is = new ArrayList<>();
        getInorder(root, is);
        System.out.println(is.get(is.size() - k));
    }

    // Sol : Max Sum BST in BT
    static int result;

    public static int helper(Node curr) {

        if (curr == null) {
            return 0;
        }

        int left = helper(curr.left);
        int right = helper(curr.right);

        if (isValidBSThelper(curr, null, null)) {
            int currSum = left + curr.data + right;
            result = Math.max(currSum, result); // Update the result if the current sum is greater.
            return currSum; // Return the sum of this BST subtree.
        }
        return 0;
    }

    public static int maxSumBST(Node root) {
        result = Integer.MIN_VALUE;

        if (root == null) {
            return 0;
        } else {
            helper(root);
            return result < 0 ? 0 : result;
        }
    }

    public static void main(String[] args) {
        // int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        int values[] = { 8, 5, 3, 6, 10, 11, 14 };
        // int values2[] = { 10, 9, 4, 5, 7, 3, 6, 2, 1, 8 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        // inorder(root);
        // insert(root, values2);
        // Info: Search in BST
        // search(root, 5);
        // Info: Delete Node in BST
        // root = delete(root, 5);
        // inorder(root);
        // Info: Print in range
        // printinRangehelper(root, 5, 12);
        // Info: Root to Leaf path
        // ArrayList<Integer> path = new ArrayList<>();
        // printRoot2Leaf(root, path);
        // Info: Validate BST
        // isValidBST(root, null, null);
        // Info: Mirror BST
        // Node rootNode = new Node(8);
        // rootNode.left = new Node(5);
        // rootNode.right = new Node(10);
        // rootNode.left.left = new Node(3);
        // rootNode.left.right = new Node(6);
        // rootNode.right.right = new Node(11);
        // rootNode = mirrorBST(rootNode);
        // preorder(rootNode);
        // Ques 1: Range sum of BST
        // int values2[] = { 3, 5, 7, 10, 15, 18 };
        // Node root2 = null;
        // for (int i = 0; i < values2.length; i++) {
        //     root2 = insert(root2, values2[i]);
        // }
        // System.out.println();
        // System.out.println(rangesumBST(root, 7, 15));
        // Info: Create a balanced BST
        // int arr[] = {3,5,6,8,10,11,12};
        // Node root3 = createBST(arr, 0, arr.length-1);
        // preorder(root3);
        // Info: Convert into balanced BST
        // Node root2 = new Node(8);
        // root2.left = new Node(6);
        // root2.left.left = new Node(5);
        // root2.left.left.left = new Node(3);

        // root2.right = new Node(10);
        // root2.right.right = new Node(11);
        // root2.right.right.right = new Node(12);
        // root2 = balancedBST(root2);
        // preorder(root2);
        // Info: Size of the largest BST in given BT
        // Node root2 = new Node(50);
        // root2.left = new Node(30);
        // root2.left.left = new Node(5);
        // root2.left.right = new Node(20);

        // root2.right = new Node(60);
        // root2.right.left = new Node(45);
        // root2.right.right = new Node(70);
        // root2.right.right.left = new Node(65);
        // root2.right.right.right = new Node(80);

        // Info info = largestsBST(root2);
        // System.out.println("Largest BST size: " + maxBST + " Node: " + maxBSTNode.data);
        // Info: Merge 2 BSTs
        // Node inputroot1 = new Node(2);
        // inputroot1.left = new Node(1);
        // inputroot1.right = new Node(4);

        // Node inputroot2 = new Node(9);
        // inputroot2.left = new Node(3);
        // inputroot2.right = new Node(12);

        // Node outputroot = mergeBSTs(inputroot1, inputroot2);
        // preorder(outputroot);
        // Ques : Closest element in the tree
        // Node input = new Node(8);
        // input.left = new Node(5);
        // input.right = new Node(11);
        // input.left.left = new Node(3);
        // input.left.right = new Node(6);
        // input.right.right = new Node(20);
        // System.out.println(closest(input, 11).data);
        // Ques : Kth largest element
        // kthlargestBST(input, 5);
        // Ques : Maximum Sum BST in Binary tree
        Node input = new Node(5);
        input.left = new Node(9);
        input.left.left = new Node(6);
        input.left.left.left = new Node(8);
        input.left.left.right = new Node(7);

        input.right = new Node(2);
        input.right.right = new Node(3);
        
        Node input2 = new Node(1);
        input2.left = new Node(4);
        input2.left.right = new Node(4);
        input2.left.left = new Node(2);

        input.right = new Node(3);
        input.right.left = new Node(2);
        input.right.right = new Node(5);
        input.right.right.left = new Node(4);
        input.right.right.right = new Node(4);
        System.out.println(maxSumBST(input2));
    }
}