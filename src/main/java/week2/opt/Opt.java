package week2.opt;

import java.util.Scanner;

class Opt {

    public static void main(String args[]) {

        Scanner input_keyboard = new Scanner(System.in);
        int n;
        long factorial = 1L;

        System.out.println("Dati numarul n:");
        n = input_keyboard.nextInt();

        for (int i = 1; i <= n; i++)
            factorial = factorial * (long) (i);

        System.out.println("Factorialul lui " + n + " este: " + factorial);

    }

}