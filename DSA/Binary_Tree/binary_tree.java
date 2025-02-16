import java.util.*;

public class binary_tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Binarytree {
        static int idx = -1;

        // Topic: Binary Tree using Preorder technique
        public static Node buildtreepre(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildtreepre(nodes);
            newNode.right = buildtreepre(nodes);
            return newNode;
        }

        public static void preorder(Node root) {
            if (root == null) {
                System.out.print(null + " ");
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {
            if (root == null) {
                // System.out.print(null + " ");
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null) {
                System.out.print(null + " ");
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelorder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
    }

    // Topic: Height of the tree

    public static int heightTree(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = heightTree(root.left);
        int rh = heightTree(root.right);
        return Math.max(lh, rh) + 1;
    }

    // Topic: Count the nodes of the tree

    public static int countNode(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = countNode(root.left);
        int rh = countNode(root.right);
        return lh + rh + 1;
    }

    // Topic: Sum of the nodes

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftsum = sumOfNodes(root.left);
        int rightsum = sumOfNodes(root.right);
        return leftsum + rightsum + root.data;
    }

    // Topic: Diameter of the tree

    public static int TreeDiameter1(Node root) { // Info: O(n^2)
        if (root == null) {
            return 0;
        }
        int rdiam = TreeDiameter1(root.right);
        int ldiam = TreeDiameter1(root.left);
        int lh = heightTree(root.left);
        int rh = heightTree(root.right);
        int selfdiam = lh + rh + 1;
        return Math.max(selfdiam, Math.max(ldiam, rdiam));
    }

    /*
     * static class Info {
     * int diam;
     * int ht;
     * 
     * public Info(int diam, int ht) {
     * this.ht = ht;
     * this.diam = diam;
     * }
     * }
     */

    /*
     * public static Info TreeDiameter2(Node root) {
     * if (root == null) {
     * return new Info(0, 0);
     * }
     * Info leftInfo = TreeDiameter2(root.left);
     * Info rightInfo = TreeDiameter2(root.right);
     * int diam = Math.max(leftInfo.ht + rightInfo.ht + 1, Math.max(leftInfo.diam,
     * rightInfo.diam));
     * int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
     * return new Info(diam, ht);
     * 
     * }
     */

    // Topic: Subtree of another tree

    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {

                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }
        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }
        return true;
    }

    // Topic: Top view of the tree
    // static class Info {
    //     Node node;
    //     int hd;

    //     public Info(Node node, int hd) {
    //         this.node = node;
    //         this.hd = hd;
    //     }
    // }

    // public static void topview(Node root) {
    //     // Info: Level order traversal
    //     Queue<Info> q = new LinkedList<>();
    //     HashMap<Integer, Node> map = new HashMap<>();

    //     int min = 0, max = 0;
    //     q.add(new Info(root, 0));
    //     q.add(null);
    //     while (!q.isEmpty()) {
    //         Info curr = q.remove();
    //         if (curr == null) {
    //             if (q.isEmpty()) {
    //                 break;
    //             } else {
    //                 q.add(null);
    //             }
    //         } else {

    //             if (!map.containsKey(curr.hd)) {
    //                 // Info: First time horizontal distance is occuring
    //                 map.put(curr.hd, curr.node);
    //             }
    //             if (curr.node.left != null) {
    //                 q.add(new Info(curr.node.left, curr.hd - 1));
    //                 min = Math.min(min, curr.hd - 1);
    //             }
    //             if (curr.node.right != null) {
    //                 q.add(new Info(curr.node.right, curr.hd + 1));
    //                 max = Math.max(max, curr.hd + 1);
    //             }
    //         }
    //     }

    //     for (int i = min; i <= max; i++) {
    //         System.out.println(map.get(i).data + " ");
    //     }
    //     System.out.println();

    // }

    // Topic: Kth level of the tree
    public static void kthlevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }
        kthlevel(root.left, level + 1, k);
        kthlevel(root.right, level + 1, k);
    }

    // Topic: Lowest Common Ancestor
    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root, n1, path1);
        getPath(root, n2, path2);
        // Lowest common ancestor
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // Last equal NODE->i-1th
        return path1.get(i - 1);
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n) {
            return true;
        }
        boolean foundleft = getPath(root.left, n, path);
        boolean foundright = getPath(root.right, n, path);
        if (foundleft || foundright) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    // Approach 2 - cheaper in space

    public static Node lca2(Node root, int n1, int n2) {

        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftlca = lca2(root.left, n1, n2);
        Node rightlca = lca2(root.right, n1, n2);

        // leftlca = va; rightlca = null
        if (rightlca == null) {
            return leftlca;
        }
        if (leftlca == null) {
            return rightlca;
        }

        return root;
    }

    // Topic: Minimum distance between 2 Nodes
    public static int minDistance(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcadistance(lca, n1);
        int dist2 = lcadistance(lca, n2);
        return dist1 + dist2;
    }

    public static int lcadistance(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftdist = lcadistance(root.left, n);
        int rightdist = lcadistance(root.right, n);

        if (leftdist == -1 && rightdist == -1) {
            return -1;
        } else if (leftdist == -1) {
            return rightdist + 1;
        } else {
            return leftdist + 1;
        }
    }

    // Topic: Kth Ancestor
    public static int KAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftdist = KAncestor(root.left, n, k);
        int rightdist = KAncestor(root.right, n, k);

        if (leftdist == -1 && rightdist == -1) {
            return -1;
        }
        int max = Math.max(leftdist, rightdist);
        if (max + 1 == k) {
            System.out.println(root.data);
        }
        return max + 1;
    }

    // Topic: Transform to sum tree
    /* public static int transformSumtree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftchild = transformSumtree(root.left);
        int rightchild = transformSumtree(root.right);
        int data = root.data;
        int newleft = root.left == null ? 0 : root.left.data;
        int newright = root.right == null ? 0 : root.right.data;
        root.data = newleft + leftchild + newright + rightchild;
        return data;
    }
    
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    } */

    // Topic: Check if tree is univalued
    public static boolean univalued(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.data != root.data) {
            return false;
        }
        if (root.right != null && root.right.data != root.data) {
            return false;
        }
        return univalued(root.left) && univalued(root.right);
    }

    // Topic: Delete Leaf node with value as x
    public static Node deleteleafnodeX(Node root, int x) {
        if (root == null) {
            return null;
        }
        root.left = deleteleafnodeX(root.left, x);
        root.right = deleteleafnodeX(root.right, x);
        if (root.data == x && root.left == null && root.right == null) {
            return null;
        }
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

    // Topic: Maximum path sum

    static int diameter = Integer.MIN_VALUE;

    public static int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = dfs(root.left);
        int rh = dfs(root.right);
        if (lh < 0)
            return 0;
        if (rh < 0)
            return 0;
        diameter = Math.max(diameter, lh + rh + root.data);
        return Math.max(lh, rh) + root.data;
    }

    public static void maxPathSum(Node root) {
        int height = dfs(root);
        System.out.println("Answer: " + diameter);
    }

    // Topic: Find all Duplicates
    public static String Dfs(Node root, HashMap<String, Integer> mp, List<Node> ans) {
        if (root == null) {
            return "#";
        }
        String left = Dfs(root.left, mp, ans);
        String right = Dfs(root.right, mp, ans);

        String st = left + ", " + right + ", " + String.valueOf(root.data);
        if (mp.containsKey(st) == true) {
            if (mp.get(st) == 1) {
                ans.add(root);
            }
            mp.put(st, mp.get(st) + 1);
        } else {
            mp.put(st, 1);
        }
        return st;
    }

    public static List<Node> FindDuplicates(Node root) {
        List<Node> ans = new ArrayList<>();
        HashMap<String, Integer> mp = new HashMap<>();
        Dfs(root, mp, ans);
        return ans;
    }

    // Topic: Check if two trees are mirror of each other
    public static Node mirror(Node root) {
        if (root == null) {
            return root;
        }
        Node left = mirror(root.left);
        Node right = mirror(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String args[]) {
        // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // Binarytree tree = new Binarytree();
        // Node root = tree.buildtreepre(nodes);
        // Info: Preorder traversal
        // tree.preorder(root);
        // System.out.println();
        // Info: Inorder traversal
        // tree.inorder(root);
        // System.out.println();
        // Info: Postorder Traversal
        // tree.postorder(root);
        // System.out.println();
        // Info: Levelorder Traversal
        // tree.levelorder(root);
        // Info: Height of a tree

        /* Node rootNode = new Node(1);
        rootNode.left = new Node(2);
        rootNode.right = new Node(3);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(5);
        rootNode.right.left = new Node(6);
        rootNode.right.right = new Node(7); */

        // System.out.println(heightTree(rootNode));
        // Info: Count Nodes in a tree
        // System.out.println(countNode(rootNode));
        // Info: Sum of Nodes
        // System.out.println(sumOfNodes(rootNode));
        // Info: Diameter of the tree
        // System.out.println(TreeDiameter1(rootNode));
        // Info: Diameter of the tree (Optimized)
        // System.out.println(TreeDiameter2(rootNode).diam);
        // Info: Subtree of another tree
        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.left = new Node(5);
        // System.out.println(isSubtree(rootNode, subRoot));
        // Info: Top view of the tree
        // topview(rootNode);
        // Info: Kth level if a tree
        // kthlevel(rootNode, 1, 3);
        // Info: Lowest Common Ancestor
        // System.out.println(lca(rootNode, 4, 5).data);
        // System.out.println(lca2(root, 2, 3).data);
        // Info: Minimum distance between 2 nodes
        // System.out.println(minDistance(rootNode, 4, 6));
        // Info: Kth Ancestor
        // KAncestor(rootNode, 5, 2);
        // Info: Transform to sum tree
        // transformSumtree(rootNode);
        // preorder(rootNode);
        // Info: Check if tree is univalued
        // Node rootNode = new Node(1);
        // rootNode.left = new Node(2);
        // rootNode.right = new Node(3);
        // rootNode.left.left = new Node(2);
        // rootNode.right.left = new Node(2);
        // rootNode.right.right = new Node(4);
        // rootNode.right.left.left = new Node(4);
        // System.out.print(univalued(rootNode));
        // Info: Delete Leaf node with value as x
        // deleteleafnodeX(rootNode, 3);
        // preorder(rootNode);
        // Info: Maximum path sum
        // maxPathSum(rootNode);
        // Info: Find all duplicates
        // System.out.println(FindDuplicates(rootNode));
        // Info: Check if two trees are mirror of each other
        // Node rootNode2 = new Node(1);
        // rootNode2.left = new Node(2);
        // rootNode2.right = new Node(3);
        // rootNode2.left.left = new Node(4);
        // rootNode2.left.right = new Node(5);
        // preorder(rootNode2);
        // mirror(rootNode2);
        // preorder(rootNode2);
        // Ques: Bottom view of the tree (Using Maps)
        bottomViewOfTree(rootNode);
    }
}