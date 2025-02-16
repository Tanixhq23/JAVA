
// import java.util.*;
// import java.time.LocalDateTime;

public class JavaRough {

    public static void main(String args[]) {
        /* LocalDateTime now = LocalDateTime.now();
        System.out.println(now); */

// DATA TYPES ------------------------------------------------>
        /* int i = 1;
        System.out.println(i);
        float price = 10.5f;
        System.out.println(price);
        byte y = 127;
        System.out.println(y);
        double d = 0;
        System.out.println(d);
        long l = 12L;
        System.out.println(l);
        boolean bo = true;
        System.out.println(bo);
        short o = 23;
        System.out.println(o);
        char ch = 'a';
        System.out.println(ch); */
 /* Sum of a&b
        int a = 10;
        int b = 5;
        int sum;
        sum = a + b; */
        // System.out.println(sum);
// INPUT IN JAVA ------------------------------------------------>
        /* System.out.println("INPUT IN JAVA");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(input); */
 /* SINCE THE NEXT() FUNCTION ONLY CAPTURES THE VALUES TILL THE SPACES, IT IGNORES ALL THE VALUES AFTER THE SPACE.
        NEXTLINE() FUNCTION IS USED TO ELIMINATE THE PROBLEM. */
        // String name = sc.nextLine();
        // System.out.println(name);
        /* TO INPUT A INTEGER WE USE .NEXTINT() */
 /* int n = sc.nextInt();
        System.out.println(n);
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = a + b;
        System.out.println(sum);
        int product = a * b;
        System.out.println(product); */
/* //Ques: WAP for hybrid inheritance 
        Tuna t1 = new Tuna("t1");
        t1.eats();
        t1.breathes();
        t1.Swims();
        t1.fins = 5;
        t1.fins();
        t1.name();
        Shark s1 = new Shark("s1");
        s1.eats();
        s1.breathes();
        s1.fins = 6;
        s1.fins();
        s1.Swims();
        peacock p1 = new peacock("p1");
        p1.eats();
        p1.breathes();
        p1.wings = 2;
        p1.wings();
        Dog d1 = new Dog("Husky");
        d1.eats();
        d1.breathes();
        d1.warmblooded();
        Cat c1 = new Cat("Tom");
        c1.eats();
        c1.breathes();
        c1.warmblooded();
        Human Tanishq = new Human("Tanishq");
        Tanishq.eats();
        Tanishq.breathes();
        Tanishq.warmblooded(); */
    }
}
/* //Ques: WAP for hybrid inheritance
// Info: main class

class Animal {

    void eats() {
        System.out.println("Eats!");
    }

    void breathes() {
        System.out.println("Breathes!");
    }
}
// Info:Fish Class

class Fish extends Animal {

    int fins;

    void Swims() {
        System.out.println("Swims!");
    }

    void fins() {
        System.out.println(fins);
    }
}

class Tuna extends Fish {

    String name;

    Tuna(String name) {
        this.name = name;
    }

    void name() {
        System.err.println(name);
    }
}

class Shark extends Fish {

    String name;

    Shark(String name) {
        this.name = name;
        System.err.println(name);
    }
}
// Info:Birds Class

class Bird extends Animal {

    int wings;

    void flies() {
        System.out.println("Yes");
    }

    void wings() {
        System.out.println(wings);
    }
}

class peacock extends Bird {

    String name;

    peacock(String name) {
        this.name = name;
        System.out.println(name);
    }
}
// Info: Mammals Class

class Mammals extends Animal {

    boolean warmblooded = true;

    void walks() {
        System.out.println("Walks!");
    }

    void warmblooded() {
        System.out.println(warmblooded);
    }
}

class Dog extends Mammals {

    String breed;

    Dog(String breed) {
        this.breed = breed;
        System.out.println(breed);
    }
}

class Cat extends Mammals {

    String name;

    Cat(String name) {
        this.name = name;
        System.out.println(name);
    }
}

class Human extends Mammals {

    String name;

    Human(String name) {
        this.name = name;
        System.out.println(name);
    }
} */
