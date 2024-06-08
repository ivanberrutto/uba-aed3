package aed;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Entregable11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (!scanner.hasNext()) {
                break;
            }
            int m = scanner.nextInt();
            int[][] matriz = new int[m][n];
            char[] constraints = new char[m]; // 0 para < (lt) , 1 para > (gt)
            int[] res = new int[m];
            for (int i = 0; i < m; i++) {
                int si = scanner.nextInt();
                int ni = scanner.nextInt();
                String oi = scanner.next();
                int ki = scanner.nextInt();


                for (int j = si; j < matriz[i].length && j <= si + ni; j++) {
                    matriz[i][j] = 1;
                }
                if (Objects.equals(oi, "lt")) {
                    constraints[i] = '<';
                } else if (Objects.equals(oi, "gt")) {
                    constraints[i] = '>';
                }
                res[i] = ki;
            }
            if (hasSolution(matriz, res, constraints)) {
                System.out.println("lamentable kingdom");
            } else {
                System.out.println("successful conspiracy");
            }


        }
    }

    public static boolean hasSolution(int[][] ab, int[] i, char[] signs) {
        int n = ab.length;
        for (int x1 = 0; x1 <= 1; x1++) {
            for (int x2 = 0; x2 <= 1; x2++) {
                boolean isSolution = true;
                for (int j = 0; j < n; j++) {
                    int a = ab[j][0];
                    int b = ab[j][1];
                    int result = a * x1 + b * x2;
                    if ((signs[j] == '<' && result >= i[j]) || (signs[j] == '>' && result <= i[j])) {
                        isSolution = false;
                        break;
                    }
                }
                if (isSolution) {
                    return true;
                }
            }
        }
        return false;
    }

}