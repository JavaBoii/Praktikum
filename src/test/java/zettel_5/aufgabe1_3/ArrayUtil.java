package zettel_5.aufgabe1_3;

public class ArrayUtil {
    private int[] array;
    public ArrayUtil(int size) {
        array = new int[size];
    }
    public int[] getArray() {
        return array.clone();
    }
}
