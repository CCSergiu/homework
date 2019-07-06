package Week3_June1.Doi;

import java.util.Scanner;

public class Main {

    private Scanner input_keyboard = new Scanner(System.in);

    public static void main(String[] args)
            throws java.io.IOException {

        Main ex = new Main();

        char choice, ignore;
        boolean flag = true;
        int x;

        for (; ; ) {
            do {

                System.out.println("Choose one of the following options:");
                System.out.println("1. The sum for the first 100 numbers greater than 0.  ");
                System.out.println("2. The min(for) and max(foreach) of an array of size n (n > 0). ");
                System.out.println("3. Display the max digit of number n. ");
                System.out.println("4. Check if number n is palindrom (12321, 101, 1). ");
                System.out.println("5. Display all the prime numbers lower than n. ");
                System.out.println("6. Exercise is missing. ");
                System.out.println("7. Exercise is missing. ");
                System.out.println("8. Display the factorial of number n. ");
                System.out.println("q. Quit");

                choice = (char) System.in.read();

                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');


            } while (choice < '1' | choice > '8' & choice != 'q');

            if (choice == 'q') {
                break;
            }

            System.out.println("\n");

            switch (choice) {
                case '1':
                    ex.unu();
                    break;

                case '2':

                    x = ex.read_number();
                    int[] y = ex.read_array(x);

                    ex.doi(x, y);
                    break;

                case '3':

                    x = ex.read_number();
                    ex.trei(x);
                    break;

                case '4':

                    x = ex.read_number();
                    ex.patru(x);
                    break;

                case '5':

                    x = ex.read_number();
                    ex.cinci(x);
                    break;

                case '6':

                    System.out.println("-- Ex.6 is missing");
                    System.out.println();
                    break;

                case '7':

                    System.out.println("-- Ex.7 is missing");
                    System.out.println();
                    break;

                case '8':

                    x = ex.read_number();
                    ex.opt(x);
                    break;
            }
        }
    }

    int read_number() {
        System.out.println("Type number n:");
        return input_keyboard.nextInt();
    }

    int[] read_array(int n) {

        int a[] = new int[n];
        for (int i = 0; i <= n - 1; i = i + 1) {
            System.out.println("Type the element " + i + " : ");
            a[i] = input_keyboard.nextInt();
        }
        return a;
    }

    void unu() {

        System.out.println("Answer for 1. is: ");

        short suma = 0, i;

        for (i = 0; i <= 100; i = (short) (i + 1))
            suma = (short) (suma + i);

        System.out.println("-- The sum for the first 100 numbers greater than 0 is " + suma);
        System.out.println();
    }

    void doi(int n, int[] a) {

        System.out.println("Answer for 2. is : ");
        // determinare minin cu for
        int min = a[0];
        for (int i = 1; i <= n - 1; i = i + 1)
            if (min > a[i])
                min = a[i];

        System.out.println("-- Min is equal with " + min);

        // determinare maxim cu foreach
        int max = a[0];
        for (int x : a)
            if (max < x)
                max = x;

        System.out.println("-- Max is equal with " + max);
        System.out.println();
    }

    void trei(int n) {

        System.out.println("Answer for 3. is: ");

        int y = n;
        byte max;

        if (n < 0) {
            n = 0 - n;
        }

        max = (byte) (n % 10);
        n = n / 10;

        while (n > 0) {
            if (n % 10 > max) max = (byte) (n % 10);
            n = n / 10;
        }

        System.out.println("-- Max digit of number " + y + " is " + max);
        System.out.println();
    }

    void patru(int n) {

        System.out.println("Answer for 4. is: ");

        int x = n;

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
        if (palindrom) System.out.println("-- Number " + x + " is palindrom");
        else System.out.println("-- Number " + x + " is not palindrom");

        System.out.println();
    }

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

    // void sase(){}

    // void sapte(){}

    void cinci(int n) {

        System.out.println("Answer for 5. is: ");

        Main check = new Main();

        for (int i = 0; i < n; i++) {
            if (check.verificare_prim(i)) {
                System.out.println("-- " + i + " is prime");
            }
        }

        System.out.println();
    }

    void opt(int n) {

        System.out.println("Answer for 8. is: ");

        long factorial = 1L;

        for (int i = 1; i <= n; i++)
            factorial = factorial * (long) (i);

        System.out.println("-- The factorial of " + n + " is equal with " + factorial);
        System.out.println();

    }

}
