package week2.Unu;

//Suma primelor 100 de numere mai mari decat 0

class Unu {

    public static void main(String args[]) {
        short suma = 0, i;
        for (i = 0; i <= 100; i = (short) (i + 1))
            suma = (short) (suma + i);
        System.out.println("Suma este " + suma);

    }
}