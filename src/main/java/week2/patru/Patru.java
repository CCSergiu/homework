package week2.patru;

// numar palindrom

import java.util.Scanner;

class Patru {

    public static void main(String args[]) {

        int n, x;

        Scanner input_keyboard = new Scanner(System.in);

        System.out.println("Dati numarul n");
        n = input_keyboard.nextInt();
        x = n;
        byte numar_cifre = 0;
        while (n > 0) {
            n = n / 10;
            numar_cifre++;
        }

        boolean palindrom = true;
        n = x;
        while (numar_cifre > 1 && palindrom) {

            // System.out.println("aici1: " + n / (int)(Math.pow(10,numar_cifre - 1)));
            if (n / (int) (Math.pow(10, numar_cifre - 1)) != n % 10) palindrom = false;
            n = (int) (n % Math.pow(10, numar_cifre - 1));
            n = n / 10;
            // System.out.println("aici2: " + n);
            numar_cifre = (byte) (numar_cifre - 2);

        }
        if (palindrom) System.out.println(x + " true");
        else System.out.println(x + " false");

    }

}