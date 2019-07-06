package week2.trei;

// cea mai mare cifra dintr-un numar

import java.util.Scanner;

class Trei {

    public static void main(String args[]) {

        int n;

        Scanner input_keyboard = new Scanner(System.in);

        System.out.println("Dati numarul n");
        n = input_keyboard.nextInt();

        byte max;
        max = (byte) (n % 10);
        n = n / 10;

        while (n > 0) {
            if (n % 10 > max) max = (byte) (n % 10);
            n = n / 10;
        }

        System.out.println("Cea mai mare cifra este: " + max);
    }

}
