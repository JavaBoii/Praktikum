package zettel_2;

public class Zettel2Aufgabe1 {

    static int[] arr = {1,2,3,4,2,4};

    public static void main(String[] args) {
        int duplicate = findDuplicate(arr); //methode findDubplicate() wird der array arr[] übergeben
                                            //beim zurückkehren aus der methode wird das return value in der variable "dubplicate" gespeichert.
                                            //Reihenfolge:
                                            // arr[] definiert und initialisiert 
                                            // arr[] wird der methode übergeben
                                            // methode checkt das array ab und gibt als return wert (x || -1)
                                            // methode hat sozusagen den wert x || -1 /  findDuplicate = x || findDuplicate = -1
                                            // variable dublicate mit dem wert von der methode wird im System.out ausgegeben.
                                            
        System.out.println("First Duplicate: " + duplicate);
    }

    public static int findDuplicate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {              //schleife soll so lange ausgeführt werden bis die anzahl/länge des arrays erreicht wird.
            for (int j = i + 1; j < arr.length; j++) {      //hier geschieht das selbe nur mit dem unterschied, dass wir immer ein element weiter im array zählen
                if (arr[i] == arr[j]) {                     //Wert 0 wird mit Wert 1 verglichen, wenn sie gleich sind wird die zahl die verglichen wird ausgegeben, ansonsten wird die schleife verlassen
                                                            //Wert 0 wird mit Wert 2 verglichen, wenn sie gleich sind...
                                                            //[...]
                                                            //Wert 5 wird mit Wert 1 verglichen, wenn sie...
                                                            //Wert 5 wird mit Wert 2 ...
                    return arr[i];
                }
            }
        }
        return -1;                          //sollte es kein duplikat geben wird die methode -1 zurückgeben
    }

}