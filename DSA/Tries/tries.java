public class tries {

    static class Node {

        Node[] children = new Node[26];
        boolean EOW = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
    // Info: Only for prefix problem
    // static class Node {

    //     Node[] children = new Node[26];
    //     boolean EOW = false;
    //     int freq;
    //     Node() {
    //         for (int i = 0; i < 26; i++) {
    //             children[i] = null;
    //         }
    //         freq = 1;
    //     }
    // }
    public static Node root = new Node();

    public static void insert(String word) {
            Node curr = root;
            for (int level = 0; level < word.length(); level++) {
                int idx = word.charAt(level) - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
            }
            curr.EOW = true;
    }

    // Topic: Search in Tries
    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.EOW == true;
    }

    // Topic: Word break problem
    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    // Topic: starts with problem
    public static boolean startWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    // Topic: Prefix Problem
    // public static void insert2(String word) {
    //     Node curr = root;
    //     for (int i = 0; i < word.length(); i++) {
    //         int idx = word.charAt(i) - 'a';
    //         if (curr.children[idx] == null) {
    //             curr.children[idx] = new Node();
    //         } else {
    //             curr.children[idx].freq++;
    //         }
    //         curr = curr.children[idx];
    //     }
    //     curr.EOW = true;
    // }
    // public static void findprefix(Node root, String ans) {
    //     if (root == null) {
    //         return;
    //     }
    //     if (root.freq == 1) {
    //         System.out.println(ans);
    //         return;
    //     }
    //     for (int i = 0; i < root.children.length; i++) {
    //         if (root.children[i] != null) {
    //             findprefix(root.children[i], ans + (char) (i + 'a'));
    //         }
    //     }
    // }
    // Topic: Unique Substring
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    // topic: Longest Word with all prefixes
    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].EOW == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);// backtrack
            }
        }
    }

    public static void main(String[] args) {
        // Info: Creation
        // String words[] = {"the", "a", "there", "their", "any", "thee"};
        // for (int i = 0; i < words.length; i++) {
        //     insert(words[i]);
        // }
        // Info: Search
        // System.out.println(search("thee"));
        // System.out.println(search("thor"));
        // System.out.println(search("a"));
        // Topic: Word Break problem 
        // String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        // for (int i = 0; i < words.length; i++) {
        //     insert(words[i]);
        // }
        // String key = "ilikesamsung";
        // System.out.println(wordBreak(key));
        // Topic: Starts with problem 
        // String words[] = {"apple", "app", "mango", "man", "woman"};
        // String prefix1 = "app";
        // String prefix2 = "moon";
        // for (int i = 0; i < words.length; i++) {
        //     insert(words[i]);
        // }
        // System.out.println(startWith(prefix1));
        // System.out.println(startWith(prefix2));
        // Topic: Prefix Problem
        // String words[] = {"zebra", "dog", "duck", "dove"};
        // for (int i = 0; i < words.length; i++) {
        //     insert2(words[i]);
        // }
        // root.freq = -1;
        // findprefix(root, "");
        // Topic: Unique Substring 
        // String str = "ababa";
        // // Suffix
        // for (int i = 0; i < str.length(); i++) {
        //     insert(str.substring(i));
        // }
        // System.out.println(countNodes(root));
        // Topic: Longest Word with all Prefixes
        String words[] = {"a", "banana", "app", "ap", "appl", "apply", "apple"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
