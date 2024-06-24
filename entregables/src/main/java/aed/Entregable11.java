package aed;

import java.util.*;

public class Entregable11 {
    static Map<Integer, ArrayList<Pair>> grafo;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            int m = scanner.nextInt();
            grafo = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int si = scanner.nextInt();
                int ni = si + scanner.nextInt();
                String oi = scanner.next();
                int ki = scanner.nextInt();
                if (Objects.equals(oi, "lt")) {
                    grafo.putIfAbsent(si-1, new ArrayList<>());
                    grafo.get(si-1).add(new Pair(ni, ki - 1));

                } else {
                    grafo.putIfAbsent(ni, new ArrayList<>());
                    grafo.get(ni).add(new Pair(si-1, -ki - 1));

                }
            }
            if (detectarCiclosNegativos(grafo,n+1)) {
                System.out.println("successful conspiracy");
            } else {
                System.out.println("lamentable kingdom");
            }
        }
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static boolean detectarCiclosNegativos(Map<Integer, ArrayList<Pair>> grafo, Integer n){

        int[] dist = new int[n + 1];
        int cont;
        for (int i = 0; i <= n; i++) {
            cont = 0;
            for (Map.Entry<Integer, ArrayList<Pair>> entry : grafo.entrySet()) {
                Integer u = entry.getKey();
                ArrayList<Pair> value = entry.getValue();

                for (Pair pair : value) {
                    int v = pair.first;
                    int c = pair.second;
                    if (dist[v] + c < dist[u]) {
                        cont++;
                        dist[u] = dist[v] + c;
                    }
                }
            }
            if (cont == 0) return false;
        }
        return true;
    }
}