// // CONDITIONAL STATEMENTS ------------------------------------------------>
// import java.util.*;

public class conditionals {

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        /* int age = sc.nextInt();
        if (age >= 18) {
            System.out.println("Adult");
        } else if (age > 13 && age < 18) {
            System.out.println("Teenager");
        } else {
            System.out.println("Not Adult");
        } */
// LARGEST VALUE ------------------------------------------------>
        /* System.out.println("Enter the value of A: ");
        int A = sc.nextInt();
        System.out.println("Enter the value of B: ");
        int B = sc.nextInt(); */
 /* IF WE ARE WRITING SINGLE LINE STATEMENT IN IF,ELSE,ELSE-IF STATEMENTS THEN THERE IS NO NEED FOR CURLY BRACES!!
        WE CAN ALSO WRITE THE BELOW STATEMENT IN SINGLE LINE AS JAVA ONLY SEARCHES FOR THE LINE TERMINATERS... */
 /* if (A > B){ System.out.println("A is Greater than B"); } else if (A == B){ System.out.println("A is Equal to B"); } else { System.out.println("B is Greater than A"); }
        if (A > B) {
            System.out.println("A is Greater than B");
        } else if (A == B) {
            System.out.println("A is Equal to B");
        } else {
            System.out.println("B is Greater than A");
        } */
// ODD-EVEN ------------------------------------------------>
        /* int n = sc.nextInt();
        if (n % 2 == 0) {
            System.out.println("The given number n = " + n + " is even."); 
        }else {
            System.out.println("The given number n = " + n + " is odd.");
        } */
// SWITCH STATEMENT ------------------------------------------------> 
        /* int number = sc.nextInt();
        switch (number) {
            case 1:
                System.out.println("You have choosen 1");
                break;
            case 2:
                System.out.println("You have choosen 2");
                break;
            case 3:
                System.out.println("You have choosen 3");
                break;
            default:
                System.out.println("INVALID");
        } */
// WHILE LOOP ------------------------------------------------>
        /* int x = 1;
        System.out.println("Enter the value of n: ");
        int range = sc.nextInt();
        while (x <= range) {
            System.out.print(x + " ");
            x++;
        }
        System.out.println(); */
// FOR LOOP ------------------------------------------------>
        /* for (int i = 0; i <= 10; i++) {
            System.out.println("Hello World! x " + i);
        } */
// REVERSE OF A NUMBER ------------------------------------------------>
        /* System.out.println("Enter the number: ");
        int n = sc.nextInt();
        while(n>0){
            int lastdigit = n%10;
            System.out.print(lastdigit);
            n = n/10;
        }
        System.out.println(); */
// REVERSE A NUMBER ------------------------------------------------>
        /* System.out.println("Enter the number: ");
        int n = sc.nextInt();
        int reverse = 0;
        while(n>0){
            int lastdigit = n%10;
            reverse = (reverse * 10) + lastdigit;
            n = n/10;
        }
        System.out.println(reverse); */
// DO WHILE LOOP ------------------------------------------------>
        /* int x = 1;
        do {
            System.out.println("Hello World");
            x++;
        } while (x <= 10); */
// BREAK STATEMENT ------------------------------------------------>
        /* for (int i = 0; i <= 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println(i);
        } */
// APPLICATION OF DO WHILE LOOP, CONTROL AND BREAK STATEMENT ------------------------------------------------>
        /* System.out.println("Start to input the numbers...");
        do {
            int n = sc.nextInt();
            if (n%10==0){
                System.out.println("ERROR! Further input of number is terminated...Since the number entered by the user is multiple of 10...");
                break;
            }
        } while(true);
        do { 
            System.out.print("Enter the numbers: ");
            int i = sc.nextInt();
            if (i%10==0){
                System.out.println("ERROR! Input of multiple of 10 is skipped!!!...");
                continue;
            }
            System.out.println(i);
        } while (true); */
    }
}

