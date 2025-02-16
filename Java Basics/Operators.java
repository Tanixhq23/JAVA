// Topic: OPERATORS ------------------------------------------------>
// import java.util.*;

public class operators {

    public static void main(String args[]) {
// ARITHMATIC OPERATORS ------------------------------------------------>
        /* System.out.println("Add: " + (A + B));
        System.out.println("Substraction: " + (A - B));
        System.out.println("Multiply: " + (A * B));
        System.out.println("Divide: " + (A / B));
        System.out.println("Remainder: " + (A % B)); */
// INCREMENT OPERATORS ------------------------------------------------>
        /* int a = 10;
        // int b = ++a;
        int b = a++;
        System.out.println(a);
        System.out.println(b); */
// DECREMENT OPERATOR ------------------------------------------------> 
        /* int c = 10;
        // int d = --c;
        int d = c--;
        System.out.println(c);
        System.out.println(d); */
// RELATIONAL OPERATORS ------------------------------------------------>
        /* int A = 10;
        int B = 5;
        System.out.println("Equal operator: " + (A == B));
        System.out.println("Not Equal operator: " + (A != B));
        System.out.println("Greater than operator: " + (A > B));
        System.out.println("Less than operator: " + (A < B));
        System.out.println("Greater than or Equal operator: " + (A >= B));
        System.out.println("Less than or Equal operator: " + (A <= B)); */
// LOGICAL OPERATORS ------------------------------------------------>
        /* System.out.println("AND operator: " + ((3 > 2) && (5 > 0)));
        System.out.println("AND operator: " + ((3 > 2) && (5 == 0)));
        System.out.println("OR operator: " + ((3 > 2) || (9 == 0)));
        System.out.println("OR operator: " + ((3 < 2) || (5 < 0)));
        System.out.println("NOT operator: " + (!(3 > 2))); */
// ASSIGNMENT OPERATORS ------------------------------------------------>
        /* int A;
        System.out.println("A = 10: " + (A = 70));
        System.out.println("A = A + 10: " + (A += 10));
        System.out.println("A = A - 10: " + (A -= 10));
        System.out.println("A = A * 10: " + (A *= 10)); */
// TERNARY OPERATOR ------------------------------------------------>
        /* int A = sc.nextInt();
        int B = sc.nextInt();
        int largest = (A > B) ? A : B;
        System.out.println("Largest number is: " + largest); */
        // EVEN-ODD ------------------------------------------------> 
        /* int number = sc.nextInt();
        String type = ((number % 2) == 0) ? "Even" : "Odd";
        System.out.println(type); */
        // PASS OR FAIL ------------------------------------------------>
        /* int marks = sc.nextInt();
        String result = (marks > 33) ? "PASS" : "FAIL";
        System.out.println(result); */
    }
}
