

public class avltree {
    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root; // Note: No duplicate nodes allowed
        }
        // Info: Update root height
        root.height = 1 + Math.max(height(root.left), height(root.right));
        // Info: Get root's balance factor
        int bf = getBalancefactor(root);
        // Left Left Case
        if (bf > 1 && key < root.left.data) {
            return rightrotate(root);
        }
        // Right Right Case
        if (bf < -1 && key > root.right.data) {
            return leftrotate(root);
        }
        // Left Right Case
        if (bf > 1 && key > root.left.data) {
            root.left = leftrotate(root.left);
            return rightrotate(root);
        }
        // Right Left Case
        if (bf < -1 && key < root.right.data) {
            root.right = rightrotate(root.right);
            return leftrotate(root);
        }
        return root;
    }

    // Left Rotate
    public static Node leftrotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }

    // Right Rotate
    public static Node rightrotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return x;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Balance Factor of root node
    public static int getBalancefactor(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);
        preorder(root);
    }
}
