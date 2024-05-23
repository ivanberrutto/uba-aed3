package aed;

import java.util.Scanner;
import java.io.PrintStream;

class Entregable3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int casos = scanner.nextInt();

        while (casos-- > 0) {
            int t = scanner.nextInt();
            int h = scanner.nextInt();
            int f = scanner.nextInt();
            int[][] positions = new int[t][h + 1];

            for (int i = 0; i < t; ++i) {
                int amount = scanner.nextInt();
                for (int j = 0; j < amount; ++j) {
                    int acorn = scanner.nextInt();
                    positions[i][acorn]++;
                }
            }


            System.out.println(bellotas(positions, t, h, f));
        }
    }


    public static int bellotas(int[][] positions, int t, int h, int f) {
        int[][] maximos = new int[t][h + 1];
        int[] maxporaltura = new int[h + 1];

        for (int altura = 1; altura <= h; altura++) {
            for (int i = 0; i < t; i++) {
                int max_altura = 0;

                if (altura - f >= 0) {
                    max_altura = Math.max(max_altura, maxporaltura[altura - f]);
                }

                max_altura = Math.max(maximos[i][altura - 1], max_altura);

                maximos[i][altura] = Math.max(max_altura, positions[i][altura - 1]) + positions[i][altura];
                maxporaltura[altura] = Math.max(maxporaltura[altura], maximos[i][altura]);
            }
        }

        return maxporaltura[h];
    }
    }
