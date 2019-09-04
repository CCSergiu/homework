package week12;

import week12.exercises.Tool;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        Tool ex = new Tool();

        System.out.println("1. ");
        ex.one("/Users/apple/Desktop/homework/src/main/java/week12");

        System.out.println("2. ");
        ex.two("/Users/apple/Desktop/homework/src/main/java/week12", ".Java");

        System.out.println("3. ");
        ex.three("/Users/apple/Desktop/homework/src/main/java/week12/Main.java");

        System.out.println("4. ");
        ex.four("/Users/apple/Desktop/homework/src/main/java/week12/Main.java");

        System.out.println("5. ");
        ex.five("/Users/apple/Desktop/homework/src/main/java/week12");

        System.out.println("6. ");
        ex.six("/Users/apple/Desktop/homework/src/main/java/week12", "/Users/apple/Desktop/homework/src/main/java/week12/Main.java");

        System.out.println("7. ");
        ex.seven("/Users/apple/Desktop/homework/src/main/java/week12/Main.java");

        System.out.println("8. ");
        ex.eight();

        System.out.println("9. ");
        ex.nine("/Users/apple/Desktop/homework/src/main/java/week12/Main.java");

        System.out.println("10. ");
        ex.ten("/Users/apple/Desktop/homework/src/main/resources/in.txt");
    }

}
