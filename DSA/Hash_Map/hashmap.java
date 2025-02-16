
import java.util.*;

public class hashmap {
    // IMP: HASH IMPLEMENTATION
    // static class HashMap<K, V> {
    //     private class Node {
    //         K key;
    //         V value;

    //         public Node(K key, V value) {
    //             this.key = key;
    //             this.value = value;
    //         }
    //     }
    //     private int N;
    //     private int n;
    //     private LinkedList<Node> buckets[];
    //     @SuppressWarnings("unchecked")
    //     public HashMap() {
    //         this.N = 4;
    //         this.buckets = new LinkedList[4];
    //         for (int i = 0; i < 4; i++) {
    //             this.buckets[i] = new LinkedList<>();
    //         }
    //     }
    //     private int hashFunction(K Key) {
    //         int hc = Key.hashCode();
    //         return Math.abs(hc) % N;
    //     }
    //     private int searchInLL(K key, int bi) {
    //         LinkedList<Node> ll = buckets[bi];
    //         int di = 0;
    //         for (int i = 0; i < ll.size(); i++) {
    //             Node node = ll.get(i);
    //             if (node.key == key) {
    //                 return di;
    //             }
    //             di++;
    //         }
    //         return -1;
    //     }
    //     @SuppressWarnings("unchecked")
    //     private void rehash() {
    //         LinkedList<Node> oldbuck[] = buckets;
    //         buckets = new LinkedList[N * 2];
    //         N = N * 2;
    //         for (int i = 0; i < buckets.length; i++) {
    //             buckets[i] = new LinkedList<>();
    //         }
    //         for (int i = 0; i < oldbuck.length; i++) {
    //             LinkedList<Node> ll = oldbuck[i];
    //             for (int j = 0; j < ll.size(); j++) {
    //                 Node node = ll.get(j);
    //                 put(node.key, node.value);
    //             }
    //         }
    //     }
    //     public void put(K key, V value) {
    //         int bi = hashFunction(key);
    //         int di = searchInLL(key, bi);
    //         if (di != -1) {
    //             Node node = buckets[bi].get(di);
    //             node.value = value;
    //         } else {
    //             buckets[bi].add(new Node(key, value));
    //             n++;
    //         }
    //         double lambda = n / N;
    //         if (lambda > 2.0) {
    //             rehash();
    //         }
    //     }
    //     public boolean containsKey(K key) {
    //         int bi = hashFunction(key);
    //         int di = searchInLL(key, bi);
    //         return di != -1;
    //     }
    //     public V get(K key) {
    //         int bi = hashFunction(key);
    //         int di = searchInLL(key, bi);
    //         if (di != -1) {
    //             Node node = buckets[bi].get(di);
    //             return node.value;
    //         } else {
    //             return null;
    //         }
    //     }
    //     public V remove(K key) {
    //         int bi = hashFunction(key);
    //         int di = searchInLL(key, bi);
    //         if (di != -1) {
    //             Node node = buckets[bi].remove(di);
    //             n--;
    //             return node.value;
    //         } else {
    //             return null;
    //         }
    //     }
    //     public ArrayList<K> KeySet() {
    //         ArrayList<K> keys = new ArrayList<>();
    //         for (int i = 0; i < buckets.length; i++) {
    //             LinkedList<Node> ll = buckets[i];
    //             for (Node node : ll) {
    //                 keys.add(node.key);
    //             }
    //         }
    //         return keys;
    //     }
    //     public boolean isEmpty() {
    //         return n == 0;
    //     }
    // }
    // Topic: Majority Element 
    public static void majorityElement(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // int num = arr[i];
            // if (map.containsKey(num)) {
            //     map.put(num, map.get(num) + 1);
            // } else {
            //     map.put(num, 1);
            // }
            // Info: Shorthand
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        // Set<Integer> keyset = map.keySet();
        // or directly write: for(Integer key: map.keySet())
        for (Integer key : map.keySet()) {
            if (map.get(key) > arr.length / 3) {
                System.out.print("Majority Element: " + key);
            }
        }
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.get(ch) != null) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    // Topic: Itinarary Tickets
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }
        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    // Sol: Bottom view of the tree
    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class Info {

        Node node;
        int hd;

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void bottomViewOfTree(Node root) {
        if (root == null) {
            return;
        }

        TreeMap<Integer, Node> map = new TreeMap<>();
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            map.put(curr.hd, curr.node);  // Update the node at this horizontal distance

            if (curr.node.left != null) {
                q.add(new Info(curr.node.left, curr.hd - 1));
            }
            if (curr.node.right != null) {
                q.add(new Info(curr.node.right, curr.hd + 1));
            }
        }

        // Now print the bottom view from the TreeMap
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
        System.out.println();
    }

    // Sol: Two Sum
    public static void twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            int b = target - a;
            if (map.containsKey(b)) {
                System.out.println("[" + map.get(b) + "," + i + "]");
            }

            map.put(a, i);
        }
    }

    // Sol: Sort by Frequency
    public static void sortStringFreq(String str) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        StringBuilder st = new StringBuilder();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();  // Get the character
            int freq = entry.getValue();  // Get its frequency

            // Append the character 'freq' times to the StringBuilder
            for (int i = 0; i < freq; i++) {
                st.append(ch);
            }
        }
        System.out.println(st);

    }

    public static void main(String[] args) {
        // HashMap<String, Integer> hm = new HashMap<>();
        // Info: Insertion
        // hm.put("China", 150);
        // hm.put("India", 100);
        // hm.put("USA", 90);
        // hm.put("Nepal", 50);
        // hm.put("Russia", 120);
        // System.out.println(hm);
        // Info: Get
        // System.out.println(hm.get("India"));
        // System.out.println(hm.get("Bhutan"));
        // Info: ContinsKey?
        // System.out.println(hm.containsKey("India"));
        // System.out.println(hm.containsKey("Bhutan"));
        // Info: Remove Key
        // hm.remove("Nepal");
        // System.out.println(hm);
        // Info: Size of the hashmap
        // System.out.println(hm.size());
        // Info: to check if hashmap is empty
        // System.out.println(hm.isEmpty());
        // hm.clear();
        // System.out.println(hm.isEmpty());
        // Topic: Iteration in hashmaps
        // Set<String> set = hm.keySet();
        // System.out.println(set);
        // for (String k : set) {
        //     System.out.println("Key -> " + k + ", Value -> " + hm.get(k));
        // }
        // IMP: HASH IMPLEMENTATION
        // HashMap<String, Integer> hm = new HashMap<>();
        // hm.put("India", 100);
        // hm.put("China", 150);
        // hm.put("USA", 90);
        // hm.put("Nepal", 70);

        // System.out.println(hm.containsKey("Nepal")); // true
        // System.out.println(hm.containsKey("Bhutan")); // false
        // ArrayList<String> keys = hm.KeySet();
        // System.out.println(keys);
        // System.out.println(hm.get("India"));
        // System.out.println(hm.remove("Nepal"));
        // System.out.println(hm.isEmpty());
        // Topic: Linked Hash Map - All Same, just insertion ordered
        // LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        // lhm.put("India", 100);
        // lhm.put("China", 150);
        // lhm.put("USA", 90);
        // HashMap<String, Integer> hm = new HashMap<>();
        // hm.put("India", 100);
        // hm.put("China", 150);
        // hm.put("USA", 90);
        // TreeMap<String, Integer> thm = new TreeMap<>();
        // thm.put("India", 100);
        // thm.put("China", 150);
        // thm.put("USA", 90);
        // System.out.println("Hash Map: " + hm);
        // System.out.println("Linked Hash Map: " + lhm);
        // System.out.println("Tree Hash Map: " + thm);
        // Topic: Majority Element
        // int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        // majorityElement(arr);
        // Topic: Check for anagram
        // String s = "race";
        // String t = "care";
        // System.out.println(isAnagram(s, t));
        // Topic: HASHSET
        // HashSet<Integer> set = new HashSet<>();
        // set.add(1);
        // set.add(2);
        // set.add(4);
        // set.add(2);
        // set.add(1);
        // System.out.println(set);
        // Topic: Iteration in HashSets
        // HashSet<String> cities = new HashSet<>();
        // cities.add("Delhi");
        // cities.add("Mumbai");
        // cities.add("Noida");
        // cities.add("Bangalore");
        // System.out.println(cities);
        // IMP : Using Iterator 
        // Iterator it = cities.iterator();
        // while (it.hasNext()) {
        //     System.out.println(it.next());
        // }
        // Info: Using Enhanced Loop
        // for (String city : cities) {
        //     System.out.println(city);
        // }
        // Topic: LinkedHash Set
        // LinkedHashSet<String> lhs = new LinkedHashSet<>();
        // lhs.add("Delhi");
        // lhs.add("Mumbai");
        // lhs.add("Noida");
        // lhs.add("Bangalore");
        // System.out.println(lhs);
        // Topic: Tree Set
        // TreeSet<String> ths = new TreeSet<>();
        // ths.add("Delhi");
        // ths.add("Mumbai");
        // ths.add("Noida");
        // ths.add("Bangalore");
        // System.out.println(ths);
        // Topic: Count distinct element
        // int nums[] = {4,3,2,5,6,7,3,4,2,1};
        // HashSet<Integer> set = new HashSet<>();
        // for(int i = 0; i<nums.length; i++){
        //     set.add(nums[i]);
        // }
        // System.out.println("Ans: " + set.size());
        // Topic: Union and intersection of 2 arrays
        // int arr1[] = { 7, 3, 9 };
        // int arr2[] = { 6, 3, 9, 2, 9, 4 };
        // Info: Union
        // HashSet<Integer> set = new HashSet<>();
        // for (int i = 0; i < arr1.length; i++) {
        //     set.add(arr1[i]);
        // }
        // for (int i = 0; i < arr2.length; i++) {
        //     set.add(arr2[i]);
        // }
        // System.out.println("Union: " + set.size() + " -> " + set);
        // Info: Intersection
        // set.clear();
        // for (int i = 0; i < arr1.length; i++) {
        //     set.add(arr1[i]);
        // }
        // int count = 0;
        // for (int i = 0; i < arr2.length; i++) {
        //     if (set.contains(arr2[i])) {
        //         count++;
        //         System.out.print(arr2[i] + " ");
        //         set.remove(arr2[i]);
        //     }
        // }
        // System.out.println();
        // System.out.println("Intersection: " + count);
        // Topic: Itinarary Tickets
        // HashMap<String, String> tickets = new HashMap<>();
        // tickets.put("Chennai", "Bengaluru");
        // tickets.put("Mumbai", "Delhi");
        // tickets.put("Goa", "Chennai");
        // tickets.put("Delhi", "Goa");
        // String start = getStart(tickets);
        // System.out.print(start);
        // for (String key : tickets.keySet()) {
        //     System.out.print(" -> " + tickets.get(start));
        //     start = tickets.get(start);
        // }
        // System.out.println();
        // Topic: Largest subarray with sum 0 
        // int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        // HashMap<Integer, Integer> map = new HashMap<>();
        // // (Sum, idx)
        // int sum = 0, len = 0;
        // for (int j = 0; j < arr.length; j++) {
        //     sum += arr[j];
        //     if (map.containsKey(sum)) {
        //         len = Math.max(len, (j - map.get(sum)));
        //     } else {
        //         map.put(sum, j);
        //     }
        // }
        // System.out.println("Largest subarray with sum 0 => " + len);
        // Ques: Bottom of view of the tree (In binary tree)
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.right = new Node(14);
        root.left.right.left = new Node(10);
        root.right = new Node(22);
        root.right = new Node(25);
        bottomViewOfTree(root);
        // Ques: Two Sum
        int arr[] = {3, 2, 4};
        twoSum(arr, 6);
        // Ques: Sort by frequency
        String str = "tree";
        sortStringFreq(str);
    }
}
