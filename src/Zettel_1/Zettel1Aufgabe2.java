package Zettel_1;

import java.util.Scanner;

public class Zettel1Aufgabe2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Anzahl der Zeilen für Matrix A: ");
        int zeilenA = scanner.nextInt();
        System.out.print("Anzahl der Spalten für Matrix A: ");
        int spaltenA = scanner.nextInt();
        System.out.print("Anzahl der Zeilen für Matrix B: ");
        int zeilenB = scanner.nextInt();
        System.out.print("Anzahl der Spalten für Matrix B: ");
        int spaltenB = scanner.nextInt();

        if (spaltenA != zeilenB) {
            System.out.println("Matrizenmultiplikation nicht möglich. \nDie Anzahl der Spalten von Matrix A muss der Anzahl der Zeilen von Matrix B entsprechen.");
            scanner.close();
            return;
        }

        int[][] matrixA = new int[zeilenA][spaltenA];
        int[][] matrixB = new int[zeilenB][spaltenB];
        int[][] matrixC = new int[zeilenA][spaltenB];

        System.out.println("Bitte die Elemente für Matrix A eingeben:");
        for (int i = 0; i < zeilenA; i++) {
            for (int j = 0; j < spaltenA; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrixA[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Bitte die Elemente für Matrix B eingeben:");
        for (int i = 0; i < zeilenB; i++) {
            for (int j = 0; j < spaltenB; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrixB[i][j] = scanner.nextInt();
            }
        }

        // Matrixmultiplikation
        for (int i = 0; i < zeilenA; i++) {
            for (int j = 0; j < spaltenB; j++) {
                matrixC[i][j] = 0;
                for (int k = 0; k < spaltenA; k++) {
                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        // Ergebnis formatiert ausgeben (Matrix C)
        System.out.println("Ergebnismatrix C:");
        for (int i = 0; i < zeilenA; i++) {
            for (int j = 0; j < spaltenB; j++) {
                System.out.printf("%5d ", matrixC[i][j]); //printf ist für die formatierung in konsolen notwendig. Darum das %5d
            }
            System.out.println();
        }

        scanner.close();
    }
}
