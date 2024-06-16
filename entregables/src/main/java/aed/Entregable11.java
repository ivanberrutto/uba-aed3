package aed;

import java.util.*;

public class Entregable11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (n == 0){
                break;
            }
            //ahora funcionas
            /*
            if (!scanner.hasNext()) {
                break;
            }
             */
            int m = scanner.nextInt();
            //ArrayList<ArrayList<Pair>> grafo = new ArrayList<ArrayList<Pair>>(n + 1);
            Map<Integer, ArrayList<Pair>> grafo = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int si = scanner.nextInt();
                int ni = scanner.nextInt();
                String oi = scanner.next();
                int ki = scanner.nextInt();
                if (Objects.equals(oi, "lt")) {
                    grafo.putIfAbsent(si - 1, new ArrayList<>());
                    grafo.get(si - 1).add(new Pair((si + ni) - i, -ki - 1));
                    //grafo.get(si-1).add(new Pair(((si+ni)-i), -ki-1));
                    //grafo.addEdge(si-1,  ((si+ni)-i), -ki-1);
                } else  {
                    grafo.putIfAbsent(si + ni, new ArrayList<>());
                    grafo.get(si + ni).add(new Pair(si - 1, -ki - 1));
                    //grafo.get(si+ni).add(new Pair(si-1, -ki-1));
                    //grafo.addEdge(si+ni, si-1, -ki-1);
                }
            }
            if (!bellmanFordDetectarCiclosNegativos(n,grafo)) {
                System.out.println("lamentable kingdom");
            } else {
                System.out.println("successful conspiracy");
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
    /*
    static class Grafo_Pesado4 {
        int v;
        public ArrayList<ArrayList<Pair>> adj;
        Grafo_Pesado4(int v) {
            this.v = v;
            this.adj = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                this.adj.add(new ArrayList<>());
            }
        }
        ArrayList<ArrayList<Pair>> vector(){
            return adj;
        }

        void addEdge(int u, int v, int weight) {
            this.adj.get(u).add(new Pair(v, weight));
            //this.adj.get(v).add(new Pair(u, weight));
        }

    }

     */

    /*
    static boolean bellmanFordDetectarCiclosNegativos(int n, int m, ArrayList<ArrayList<Pair>> arraylistgrafo) {
        int[] caminominimo = new int[n + 1];
        int[] pred = new int[n + 1];
        Arrays.fill(caminominimo, Integer.MAX_VALUE);
        Arrays.fill(pred, -1);

        caminominimo[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arraylistgrafo.size(); j++) {
                for (int k = 0; k < arraylistgrafo.get(j).size(); k++) {
                    Pair edge = arraylistgrafo.get(j).get(k);
                    if (caminominimo[j] + edge.second < caminominimo[edge.first]) {
                        caminominimo[edge.first] = caminominimo[j] + edge.second;
                        pred[edge.first] = j;
                    }
                }
            }
        }

        boolean existeciclonegativo = false;
        for (int j = 0; j < arraylistgrafo.size(); j++) {
            for (int k = 0; k < arraylistgrafo.get(j).size(); k++) {
                Pair edge = arraylistgrafo.get(j).get(k);
                if (caminominimo[j] + edge.second < caminominimo[edge.first]) {
                    existeciclonegativo = true;
                    break;
                }
            }
            if (existeciclonegativo) {
                break;
            }
        }

        return existeciclonegativo;
    }

     */

    /*
    static boolean bellmanFordDetectarCiclosNegativos(int n, int m, Map<Integer, ArrayList<Pair>> grafo) {
        int[] caminominimo = new int[n + 1];
        int[] pred = new int[n + 1];
        Arrays.fill(caminominimo, Integer.MAX_VALUE);
        Arrays.fill(pred, -1);

        caminominimo[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                if (grafo.containsKey(j)) {
                    for (Pair edge : grafo.get(j)) {
                        if (caminominimo[j] + edge.second < caminominimo[edge.first]) {
                            caminominimo[edge.first] = caminominimo[j] + edge.second;
                            pred[edge.first] = j;
                        }
                    }
                }
            }
        }

        boolean existeciclonegativo = false;
        for (int j = 0; j <= n; j++) {
            if (grafo.containsKey(j)) {
                for (Pair edge : grafo.get(j)) {
                    if (caminominimo[j] + edge.second < caminominimo[edge.first]) {
                        existeciclonegativo = true;
                        break;
                    }
                }
            }
            if (existeciclonegativo) {
                break;
            }
        }

        return existeciclonegativo;
    }

     */
    /*
    static boolean bellmanFordDetectarCiclosNegativos(int n, int m, Map<Integer, ArrayList<Pair>> grafo) {
        int[] caminominimo = new int[n + 1];
        Arrays.fill(caminominimo, Integer.MAX_VALUE);
        caminominimo[0] = 0;

        boolean updated;

        for (int i = 0; i < n; i++) {
            updated = false;
            for (int j = 0; j <= n; j++) {
                if (grafo.containsKey(j)) {
                    for (Pair edge : grafo.get(j)) {
                        if (caminominimo[j] != Integer.MAX_VALUE && caminominimo[j] + edge.second < caminominimo[edge.first]) {
                            caminominimo[edge.first] = caminominimo[j] + edge.second;
                            updated = true;
                        }
                    }
                }
            }
            // Si no se actualizó ningún valor, podemos terminar antes
            if (!updated) {
                break;
            }
        }

        // Verificar la existencia de ciclos negativos
        for (int j = 0; j <= n; j++) {
            if (grafo.containsKey(j)) {
                for (Pair edge : grafo.get(j)) {
                    if (caminominimo[j] != Integer.MAX_VALUE && caminominimo[j] + edge.second < caminominimo[edge.first]) {
                        return true;  // Se detectó un ciclo negativo
                    }
                }
            }
        }

        return false;  // No se detectó ningún ciclo negativo
    }

     */
    static boolean bellmanFordDetectarCiclosNegativos(int n, Map<Integer, ArrayList<Pair>> grafo) {
        int[] caminominimo = new int[n + 1];
        Arrays.fill(caminominimo, Integer.MAX_VALUE);
        caminominimo[0] = 0;

        boolean updated;

        // Relajar los bordes n-1 veces
        for (int i = 0; i < n; i++) {
            updated = false;
            for (int j = 0; j <= n; j++) {
                if (grafo.containsKey(j) && caminominimo[j] != Integer.MAX_VALUE) {
                    for (Pair edge : grafo.get(j)) {
                        if (caminominimo[j] + edge.second < caminominimo[edge.first]) {
                            caminominimo[edge.first] = caminominimo[j] + edge.second;
                            updated = true;
                        }
                    }
                }
            }
            // Si no se actualizó ningún valor, podemos terminar antes
            if (!updated) {
                break;
            }
        }

        // Verificar la existencia de ciclos negativos
        for (int j = 0; j <= n; j++) {
            if (grafo.containsKey(j) && caminominimo[j] != Integer.MAX_VALUE) {
                for (Pair edge : grafo.get(j)) {
                    if (caminominimo[j] + edge.second < caminominimo[edge.first]) {
                        return true;  // Se detectó un ciclo negativo
                    }
                }
            }
        }

        return false;  // No se detectó ningún ciclo negativo
    }
}