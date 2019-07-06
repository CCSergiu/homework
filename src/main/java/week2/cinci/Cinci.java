package week2.cinci;

// toate numerele prime mai mici decat n

import java.util.Scanner;

class Prim {

    boolean verificare_prim(int a) {

        boolean verificare = true;

        for (int i = 2; i <= a / 2; i++)
            if (a % i == 0) {
                verificare = false;
                break;
            }
        if (a == 0) verificare = false;
        return verificare;
    }
}

class Cinci {

    public static void main(String args[]) {


        int n;
        Scanner input_keyboard = new Scanner(System.in);
        System.out.println("Dati numarul n:");
        n = input_keyboard.nextInt();

        Prim check = new Prim();
        for (int i = 0; i < n; i++)
            if (check.verificare_prim(i))
                System.out.println(i + " este prim");

    }

}
