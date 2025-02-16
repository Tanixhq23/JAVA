//TOPIC:OOPS ------------------------------------------------>
package OOPS;
public class OOPS {

    public static void main(String[] args) {
        //  Pen p1 = new Pen();
//TOPIC:ACCESS MODIFIERS ------------------------------------------------>

        /* BankAccount b1 = new BankAccount();
        System.out.println(b1.username); */
        // System.out.println(b1.password); //BUG:ERROR
        // b1.setPassword("tanishqlokhande23"); //Info:NO ERROR Fucntion is not private
//TOPIC:GETTERS AND SETTERS ------------------------------------------------>
        /* p1.setColor("BLUE");
        System.out.println(p1.getColor());
        p1.setColor("YELLOW");
        System.out.println(p1.getColor()); */
        // System.out.println(p1.color); //BUG:ERROR
        /* p1.setTip(7);
        System.out.println(p1.gettip()); */
//TOPIC:CONSTRUCTORS ------------------------------------------------>
        /* Student s1 = new Student("Tanishq");
        Student s2 = new Student(456);
        Student s3 = new Student();
        System.out.println(s2.getRollno());
        System.out.println(s1.getName()); */
//TOPIC:COPY CONSTRUCTORS ------------------------------------------------>
//TOPIC:SHALLOW CONSTRUCTORS ------------------------------------------------>
        /* Student s1 = new Student();
        s1.name = "Tanishq";
        s1.password = "XYZ";
        s1.rollno = 456;
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;

        Student s2 = new Student(s1);
        s2.password = "PQR";

//Info:AFTER PASSING MARKS[], CHANGING THE VALUE IN S1 ALSO CHANGES MARKS IN S2
        s1.marks[2] = 100;

        for (int i = 0; i < 3; i++) {
            System.out.println(s2.marks[i]);
        } */
//TOPIC:DEEP CONSTRUCTORS ------------------------------------------------>
        /* Student s1 = new Student();
        s1.name = "Tanishq";
        s1.password = "XYZ";
        s1.rollno = 456;
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;

        Student s2 = new Student(s1);
        s2.password = "PQR";
        s1.marks[2] = 100;
//Info:AFTER PASSING MARKS[], CHANGING THE VALUE IN S1 WILL NOT CHANGE MARKS IN S2 BECAUSE WE HAVE DONE DEEP COPY
        for (int i = 0; i < 3; i++) {
            System.out.println(s2.marks[i]);
        } */
//TOPIC:INHERITTANCE ------------------------------------------------>
        /* Fish Shark = new Fish();
        Shark.fins = 5; //Info:CHILD METHODS
        Shark.eat();
        Shark.breathe(); //Info:PARENT FUNCTIONS  */
//TOPIC:MULTILEVEL INHERITANCE ------------------------------------------------>
        /* Dog D1 = new Dog("tommy");
        D1.breed = "Rot Weiler";
        D1.eat();
        D1.breathe(); //Info:ANIMAL CLASS FUCNTIONS
        D1.legs(); //Info:MAMMALS CLASS FUCNTIONS
        D1.breed(); //Info:CHILD CLASS FUCNTIONS 
         */
//TOPIC:HEIRARCHIAL INHERITANCE ------------------------------------------------>
        /* Fish f1 = new Fish();
        f1.swim();
        f1.eat();
        f1.breathe();
        Bird b1 = new Bird();
        b1.Fly();
        b1.breathe();
        b1.eat(); */
// TOPIC:POLYMORPHISM ------------------------------------------------>
        /* Calculator Calc = new Calculator();
        System.out.println(Calc.sum(1, 2));
        System.out.println(Calc.sum(1.5f, 2.5f));
        System.out.println(Calc.sum(1, 2, 4)); */
// TOPIC: ABSTRACTION ------------------------------------------------>
        /* Horse h1 = new Horse();
        h1.eats();
        h1.walks();
        Chicken c1 = new Chicken();
        c1.eats();
        c1.walks();
        Mustang m = new Mustang();
        System.out.println(m.color); */
// TOPIC: INTERFACES ------------------------------------------------>
        /* Queen Q = new Queen();
        Q.moves();
        // Info: Multiple Inheritance
        Beer B = new Beer();
        B.eatsgrass();
        B.eatsmeat(); */
// Topic: STATIC KEYWORD ------------------------------------------------>
        /* Student s1 = new Student();
        s1.schoolName = "Sankalp Public School"; // Info: This name will remain same for every other object created in future once defined!
        s1.setName("Tanishq");
        System.out.println(s1.getName()); */
    }
}
// Topic: STATIC KEYWORD ------------------------------------------------>
/* class Student{
    String name;
    int rollno;
    static String schoolName;

    void setName(String name){
        this.name= name;
    }
    String getName(){
        return name;
    }

} */
// TOPIC: INTERFACES ------------------------------------------------>
/* interface Chessplayer {

    void moves(); // Info: An idea About how the moves will be, not definition the inheriting classes must secify definition 
    // Info: By default the type of funtion in interface are public, abstract and without implementation
}

class Queen implements Chessplayer {

    public void moves() {
        System.out.println("Moves up, down, left, right, diagonal - (in all 4 dirns)");
    }
}

class King implements Chessplayer {

    public void moves() {
        System.out.println("Moves up, down, left, right, diagonal - (by 1 step)");
    }
}

class Rook implements Chessplayer {

    public void moves() {
        System.out.println("Moves up, down, left, right");
    }
} */

// Topic: Multiple inheritance through interfaces
/* interface Herbivore {

    void eatsgrass();
}

interface Carnivore {

    void eatsmeat();
}

class Beer implements Herbivore, Carnivore {

    public void eatsgrass() {
        System.out.println("Eats Grass!");
    }

    public void eatsmeat() {
        System.out.println("Eats Meat!");
    }
} */
// TOPIC: ABSTRACTION ------------------------------------------------>

/* abstract class Animal {

    String color;

    Animal() {
        System.out.println("Animal constructor is called!");
    }

    void eats() {
        System.out.println("Eats!");
    }

    abstract void walks();
}

class Horse extends Animal {

    Horse() {
        System.out.println("Horse constructor is called!");
    }

    void changecolor() {
        color = "dark brown";
    }

    void walks() {
        System.out.println("Walks");
    }
}

class Mustang extends Horse {

    Mustang() {
        System.out.println("Mustang constructor called!");
    }
}

class Chicken extends Animal {

    Chicken() {
        System.out.println("Horse constructor is called!");
    }

    void walks() {
        System.out.println("Has 2 legs to walk");
    }
} */
// TOPIC:POLYMORPHISM ------------------------------------------------>

/* class Calculator {

    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
} */
// TOPIC:INHERITTANCE ------------------------------------------------>

/* class Animal { //INFO:PARENT

    String colors;

    void eat() {
        System.out.println("Eats");
    }

    void breathe() {
        System.out.println("Breathes");
    }
} */

 /* class Fish extends Animal { //Info:CHILD

    int fins;

    void fins() {
        System.out.println(fins);
    }

    void swim() {
        System.out.println("Swims");
    }
} */
//TOPIC:MULTILEVEL INHERITANCE ------------------------------------------------>
/* class Mammals extends Animal {

    void legs() {
        System.out.println("True");
    }
}

class Dog extends Mammals {

    String name;
    String breed;

    Dog(String name) {
        this.name = name;
    }

    void breed() {
        System.out.println(breed);
    }
} */
//TOPIC:HEIRARCHIAL INHERITANCE ------------------------------------------------>
/* class Fish extends Animal {

    void swim() {
        System.out.println("Swims");
    }
}

class Bird extends Animal {

    void Fly() {
        System.out.println("Fly");
    }
} */
//TOPIC:CONSTRUCTORS ------------------------------------------------>
/* class Student {

    String name;
    int rollno;
    String password;
    int marks[];

//TOPIC:DEEP COPY CONSTRUCTORS ------------------------------------------------>
    Student(Student s1) {
        marks = new int[3];
        this.name = s1.name;
        this.rollno = s1.rollno;
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = s1.marks[i];
        }
    }

//TOPIC:SHALLOW COPY CONSTRUCTORS ------------------------------------------------>
    Student(Student s1) {
        marks = new int[3];
        this.name = s1.name;
        this.rollno = s1.rollno;
        this.marks = s1.marks;
    }

    String getName() {
        return this.name;
    }

    int getRollno() {
        marks = new int[3];
        return this.rollno;
    }
//TOPIC:COPY CONSTRUCTOR ------------------------------------------------>
    Student(String name) {
        marks = new int[3];
        this.name = name;
    }

    Student(int rollno) {
        marks = new int[3];
        this.rollno = rollno;
    }

    Student() {
        marks = new int[3];
    }

} */
//TOPIC:ACCESS MODIFIERS ------------------------------------------------>
/* class BankAccount {

    public String username = "tanishq23";
    private String password = "abcdefghij";

    public void setPassword(String pwd) {
        password = pwd;
    }
} */
