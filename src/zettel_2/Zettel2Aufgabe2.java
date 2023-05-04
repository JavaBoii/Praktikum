package zettel_2;

import java.lang.Math;

public class Zettel2Aufgabe2 {
    // Teil A
    /*
    Erklärung von überladenen methoden:
    In Java sind überladene Methoden, Methoden mit demselben Namen,
    aber unterschiedlichen Parametern in einer Klasse.
    Sie erlauben es, eine Aktion auf verschiedene Arten auszuführen.
    Java wählt die passende Methode basierend auf den übergebenen Parametern aus.
     */
    public static double getVolumeCone(double r, double h) {        //methode enthält 2 parameter (double, double)
                                                                    //Note: wichtig ist es den richtigen rückgabe Datentypen anzugeben
                                                                    //e.g [public/private/protected] [static/ ] [void/int/double...]
                                                                    //Wenn ihr den rückgabe typen "void" nehmt, bekommt ihr keinen rückgabewert!
        return (1.0 / 3.0) * Math.PI * Math.pow(r, 2) * h;      //Math.PI ist eine funktion der Math Klasse. Genauso wie Math.pow aka hoch2. Um die zu benutzen, importiert bitte "java.lang.math.*"
    }

    public static double getVolumeCone(int r, int h) {              //methode enthält 2 parameter (int, int)
        return (1.0 / 3.0) * Math.PI * Math.pow((double) r,2) * (double) h;
    }

    public static double getVolumeCone(String r, String h) {        //methode enthält 2 parameter (String, String)
        return (1.0 / 3.0) * Math.PI * Math.pow(Double.parseDouble(r),2) * Double.parseDouble(h);
    }

    public static double getVolumeCone(double r) {                  //methode enthält 1!! parameter (double)
        return (1.0 / 3.0) * Math.PI * Math.pow(r,2) * 4;
    }
                                                                    //Java schaut nun beim Aufrufen der methode ob oder welche parameter übergeben wurde.
                                                                    //Es schaut nach der exakten reihenfolge und menge der Parameter!
                                                                    //Wenn Ihr keine parameter übergebt, sucht Java nach passenden parameterlosen methoden. Sollte keine vorhanden sein, gibt java eine exception.

    // Teil B dasselbe wie im Teil A, nur eine andere Formel die als ergebnis aus der methode returned wird.
    public static double getSurfaceArea(double r, double s) {
        return Math.pow(r, 2) * Math.PI + r * Math.PI * s;
    }

    public static double getSurfaceArea(int r, int s) {
        return Math.pow( r, 2) * Math.PI + (double)r * Math.PI * (double) s;
    }

    public static double getSurfaceArea(String r, String s) {
        return Math.pow(Double.parseDouble(r), 2) * Math.PI + Double.parseDouble(r) * Math.PI * Double.parseDouble(s);
    }

    public static double getSurfaceArea(double r) {
        return Math.pow(r, 2) * Math.PI + r * Math.PI * 5;
    }

    // Teil C
    public static void main(String[] args) {

        System.out.println("Volumen des Kegels (double): " + getVolumeCone(3.0, 5.0)); //Hier ruft ihr die methode auf und je nach parameter,
                                                                                             //wird automatisch die passende methode ausgeführt. 
                                                                                             //Mit + werden variablen, als auch Strings aka " " verbunden
                                                                                             //Note: System.out.print = Druckt solange eine ausgabe in einer Zeile bis es explizit einen Umbruch erhält "\n"
                                                                                             //Note: System.out.println = Macht nach jeder erfolgreichen Ausgabe einen Umbruch in die nächste Zeile.
                                                                                             //Note: System.out.printf = Druckt wie print so lange bis es explizit Umgebrochen wird, 
                                                                                             //jedoch hat es formatierungsvorlagen die wie in C funktionieren. Bsp: System.out.printf("%5d",ausgabe)
                                                                                             

        System.out.println("Volumen des Kegels (int): " + getVolumeCone(3, 5));
        System.out.println("Volumen des Kegels (String): " + getVolumeCone("3", "5"));
        System.out.println("Volumen des Kegels (Höhe = 4): " + getVolumeCone(3.0));


        System.out.println("Oberfläche des Kegels (double): " + getSurfaceArea(3.0, 5.0));
        System.out.println("Oberfläche des Kegels (int): " + getSurfaceArea(3, 5));
        System.out.println("Oberfläche des Kegels (String): " + getSurfaceArea("3", "5"));
        System.out.println("Oberfläche des Kegels (Mantellinie = 5): " + getSurfaceArea(3.0));
    }
}
