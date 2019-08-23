package week11.unu;

import java.util.stream.Stream;

public class Fibonacci {

    public static void main(String[] args) {


        Integer a[] = Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0] + t[1]})
                .limit(15)
                .map(t -> t[0])
                .toArray(Integer[]::new);

        for (Integer element : a) {
            System.out.println(element);
        }
    }
}
