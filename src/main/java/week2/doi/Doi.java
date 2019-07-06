package week2.doi;

// cel mai mic numar dintr-un vector (for si foreach)

import java.util.Scanner;

class Doi {

    public static void main(String args[]) {

        int n;
        // float b;
        // String s;

        Scanner input_keyboard = new Scanner(System.in);


		/*
		// Citeste un string
		System.out.println("Enter a string");
	        s = input_keyboard.nextLine();
        	System.out.println("You entered string " + s);  */

        // Citeste un intreg
        System.out.println("Dati numarul de elemente al vectorului");
        n = input_keyboard.nextInt();
        System.out.println("You entered integer " + n);

		/*
		// Citeste un o fractie
	        System.out.println("Enter a float");
        	b = input_keyboard.nextFloat();
	        System.out.println("You entered float " + b);	*/

        // Declarare si initializare vector
        int a[] = new int[n];
        for (int i = 0; i <= n - 1; i = i + 1) {
            System.out.println("Dati elementul " + i + " : ");
            a[i] = input_keyboard.nextInt();
        }
        // determinare minin cu for
        int min = a[0];
        for (int i = 1; i <= n - 1; i = i + 1)
            if (min > a[i])
                min = a[i];

        System.out.println("Elementul minim este " + min);

        // determinare maxim cu foreach
        int max = a[0];
        for (int x : a)
            if (max < x)
                max = x;

        System.out.println("Elementul maxim este " + max);


    }

}