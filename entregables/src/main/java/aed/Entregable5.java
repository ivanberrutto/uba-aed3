package aed;

import java.util.Scanner;
//2
public class Entregable5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n != 0) {
            int[] traders = new int[n];
            for (int i = 0; i < n; i++) {
                traders[i] = scanner.nextInt();
            }
            System.out.println(winetrading(traders));
            n = scanner.nextInt();
        }
    }
    public static int winetrading(int[] traders) {
        int botellas = 0;
        int work = 0;

        for (int i = 0; i < traders.length; i++) {
            work = work + Math.abs(botellas);
            botellas -=  traders[i];

    }
        return work;

    }
}