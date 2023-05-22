package zettel_5.aufgabe1_3;

public class Main {
    public static void main(String[] args) {
        ArrayUtil example = new ArrayUtil(5);
        int[] array = example.getArray();
        array[0] = 10;
        array[1] = 20;

        System.out.println(array[0]);
        System.out.println(array[1]);
    }
}

