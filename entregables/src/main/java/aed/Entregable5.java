package aed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
//2
public class Entregable5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int botellas;
        int work;
        int n = scanner.nextInt();
        while (n != 0) {
            botellas = 0;
            work = 0;
            for (int i = 0; i < n; i++) {
                work = work + Math.abs(botellas);
                botellas -= scanner.nextInt();
            }
            pw.println(work);
            n = scanner.nextInt();
        }
        scanner.close();
        pw.flush();
        pw.close();
    }
}
/*
public class Entregable5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int botellas;
        int work;
        int n = Integer.parseInt(reader.readLine());
        while (n > 0) {
             botellas = 0;
             work = 0;
            String[] parts = reader.readLine().split(" ");
            //int[] vector = new int[n];
            for (int i = 0; i < n; i++) {
                botellas += Integer.parseInt(parts[i]);
                work = work + Math.abs(botellas);
            }
            pw.print(work+"\n");
        }
        pw.flush();
        pw.close();
    }
}

 */