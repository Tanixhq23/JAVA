// // STRINGS ------------------------------------------------>

import java.util.*;

public class Strings{

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
// // DECLARATION ------------------------------------------------>
        /* String str = new String("Tanishq");
        String str2 = "Tanishq"; */
// // CONCATENATION ------------------------------------------------>
        /* String Fristname = "Tanishq ";
        String Lastname = "Lokhande";
        String Fullname = Fristname + Lastname;
        System.out.println("Concatenation: " + Fullname); */
// // STRING LENGTH ------------------------------------------------>
        // System.out.println(Fullname.length());
// // charAt METHOD ------------------------------------------------>
        // System.out.println(Fullname.charAt(0));
// // ELEMENTS IN A STRING ------------------------------------------------>
        /* String str = "Tanishq";
        elementsstring(str);
        elementsstring(Fullname); */
// // CHECK FOR PALINDROME ------------------------------------------------>
        /* String str = sc.next();
        palindrome(str); */
// // SHORTEST PATH ------------------------------------------------>
        /* System.out.println("Enter the route (for ex. WNEENNSS): ");
        String path = sc.next();
        System.out.println("Displacement: "+getshortestpath(path)); */
// // COMPARE THE VALUE OF STRINGS ------------------------------------------------>
        /* String s1 = "Tony";
        // String s2 = "Tony";
        String s3 = new String("Tony");
        if (s1.equals(s3)){
            System.out.println("Strings are equal!");
        }
        else{
            System.out.println("Strings are not equal!");
        } */
// // SUBSTRING ------------------------------------------------>
        /* String str = sc.nextLine();
        System.out.print("Enter the starting index of the substring: ");
        int si = sc.nextInt();
        System.out.print("Enter the ending index of the substring: ");
        int ei = sc.nextInt();
        System.out.print(substring(str,si,ei)); */
// // INBUILT SUBSTRING ------------------------------------------------>
        /* System.out.println(str.substring(0,5)); */
// // LARGEST STRING ------------------------------------------------>
        /* String fruits[] = {"Apple", "Mango", "Banana"};
        String largest = fruits[0];
        for (int i = 1; i < fruits.length; i++) {
            if (largest.compareToIgnoreCase(fruits[i]) < 0) {
                largest = fruits[i];
            }
        }
        System.out.print(largest); */
// // STRING BUILDER ------------------------------------------------>
        /* StringBuilder sb = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        System.out.println(sb); */
// // CONVERT TO UPERCASE ------------------------------------------------>
        /* System.out.println("Enter the string:");
        String str = sc.nextLine();
        System.out.println(touppercase(str)); */
// // STRING COMPRESSION ------------------------------------------------>
        /* System.out.print("Enter String to compress --> ");
        String str = sc.next();
        System.out.println("Compressed String -->"+Stringcompression(str)); */
// // COUNT NUMBER OF LOWERCASE IN STRING ------------------------------------------------>
        /* System.out.print("Enter a string --> ");
        String str = sc.nextLine();
        System.out.println(lowercasecount(str)); */
// // ANAGRAMS ------------------------------------------------>
        /* System.out.print("Enter string 1 --> ");
        String str = sc.nextLine();
        System.out.print("Enter string 2 --> ");
        String str2 = sc.nextLine();
        anagrams(str, str2); */
    }
// // ANAGRAMS ------------------------------------------------>

    public static void anagrams(String str, String str2) {
        str = str.toLowerCase();
        str2 = str2.toLowerCase();
        if (str.length() == str2.length()) {
            char[] strchararray = str.toCharArray();
            char[] str2chararray = str2.toCharArray();
            Arrays.sort(strchararray);
            Arrays.sort(str2chararray);
            boolean result = Arrays.equals(strchararray, str2chararray);
            if (result) {
                System.out.println("Given Strings --> " + "'" + str + "'" + " and " + "'" + str2 + "'" + " are anagrams of each other");
            } else {
                System.out.println("Given Strings --> " + "'" + str + "'" + " and " + "'" + str2 + "'" + " are not anagrams of each other");
            }
        } else {
            System.out.println("Given Strings --> " + str + " and " + str2 + " are not anagrams!");
        }
    }
// // COUNT NUMBER OF LOWERCASE IN STRING ------------------------------------------------>

    public static int lowercasecount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }
// // STRING COMPRESSION ------------------------------------------------>

    public static String Stringcompression(String str) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }
// // CONVERT TO UPERCASE ------------------------------------------------>

    public static String touppercase(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
// // SUBSTRING ------------------------------------------------>

    public static String substring(String str, int si, int ei) {
        String substr = "";
        for (int i = si; i < ei; i++) {
            substr += str.charAt(i);
        }
        return substr;
    }
// // SHORTEST PATH ------------------------------------------------>

    public static float getshortestpath(String path) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);
            // SOUTH
            switch (dir) {
                case 'S' -> y--;
                case 'N' -> y++;
                case 'W' -> x--;
                default -> x++;
            }
            // NORTH
            // WEST
            // EAST
                    }
        int X2 = x * x;
        int Y2 = y * y;
        return (float) Math.sqrt(X2 + Y2);
    }
// // ELEMENTS IN A STRING ------------------------------------------------>

    public static void elementsstring(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }
// // CHECK FOR PALINDROME ------------------------------------------------>

    public static boolean ispalindrome(String string) {
            int n = string.length();
            for (int i = 0; i <= n / 2; i++) {
                if (string.charAt(i) != string.charAt(n - i - 1)) {
                    return false;
                }
            }
            return true;
    }

    public static void palindrome(String string) {
        if (ispalindrome(string) == true) {
            System.out.println("Given string is palindrome");
        } else {
            System.out.println("Given string is not palindrome");
        }
    }
}
