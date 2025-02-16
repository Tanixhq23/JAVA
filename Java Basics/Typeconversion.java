// // TYPE CONVERSION ------------------------------------------------>
// import java.util.*;

public class Typeconversion {

    public static void main(String args[]) {
        // Scanner sc = new Scanner(System.in);
// TYPE CONVERSION ------------------------------------------------> 
        /* OCCURS ONLY WHEN:
        1. TYPES COMPATIBLE 
        2. DESTINATION TYPE > SOURCE TYPE
        TYPE CONVERSION OR WIDENING TYPE CONVERSION OR IMPLICIT TYPE CONVERSION */
        /* int a = 34;
        long b = a;
        System.out.println(b); */
// EXPLICIT TYPE CONVERSION FROM DOUBLE TO INT ------------------------------------------------>
        /* byte d = 10;
        float i = (float) d; // i is now 10
        System.out.println(i);

        System.out.println("Type Conversion to Float Only!!!");
        float f = sc.nextInt();
        System.out.println(f);
        int $ = 233;
        System.out.println($);
        float f = 25.46f;
        int z = (int) f;
        System.out.println(z); */
// TYPE PROMOTION IN EXPRESSIONS ------------------------------------------------>
        /* JAVA AUTOMATICALLY PROMOTES EACH BYTE, SHORT CHAR OPERAND INTO INT WHEN EVALUATING AN EXPRESSION.IF AN EXPRESSION CONTAINS LONG, FLOAT DOUBLE THE WHOLE EXPRESSION IS CONVERTED TO LONG, FLOAT DOUBLE RESPECTIVELY.*/
        /* char a = 'a';
        short b = 10;
        byte bt = 43;
        System.out.println(a + b + bt); //Since there is no long, float, double in the expression all data types are converted into int for evaluating the expression.
        char c = 'g';
        int n = 5;
        float f = 56.78f;
        System.out.println(c + n + f); //Autiomatically java promoted all data type into float.
        int i = 1;
        float f = 3.14f;
        byte b = 1;
        char c = 'a';
        short s = 1;
        long l = 3245l;
        double d = 3.165;
        double ans = i + f + c + b + s + l + d; // Java automatically converted all data type into the largest data type present in the expression that is double.
        System.out.println(ans); */
        /* HOW TO CHECK WHETHER THE ANS IS DOUBLE OR NOT
        TO CHECK CHANGE THE TYPE OF D THE JAVA COMPILER WILL GENERATE 'ERROR: INCOMPATIBLE TYPES: POSSIBLE LOSSY CONVERSION FROM DOUBLE TO INT' WHICH MEANS THAT THE CALCULATED VALUE COMES OUT TO BE DOUBLE AND WE ARE STORING IT IN INT TYPE VARIABLE THAT IS AN ERROR OR LOSSY CONVERSION.
        HOWEVER WE CAN EXPLICITLY CONVERT THE TYPE OF ANS TO INT BUT, WE WILL LOSE THE EXTRA INFORMATION AFTER THE DECIMAL. */
        /* int sum = (int) (i + f + b + c + l + d + s);
        System.out.println(sum); */
    }
}
