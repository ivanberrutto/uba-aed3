package aed;

import java.util.*;

public class Entregable8 {
    static ArrayList<Integer>[] grafo;
    static int tiempo;
    static int[] visitado, bajo;
    static int[] padre;
    static int[] componentesGeneradas;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (n == 0 && m == 0) break;
            grafo = new ArrayList[n];

            int u;
            int v;
            while(true) {
                u = scanner.nextInt();
                v = scanner.nextInt();
                if(u == -1 && v == -1){
                    break;
                }
                agregarArista(grafo,u,v);
            }

            List<Pair<Integer, Integer>> puntosArticulacion = encontrarPuntosImportantes(n,m);
            for (Pair<Integer, Integer> punto : puntosArticulacion) {
                System.out.println(punto.getKey() + " " + punto.getValue());
            }
            System.out.println();
            //
        }
    }

    static void agregarArista(ArrayList<Integer>[] grafo, Integer u, Integer v){
        if (grafo[u] == null) {
            grafo[u] = new ArrayList<>();
        }
        grafo[u].add(v);
        if (grafo[v] == null) {
            grafo[v] = new ArrayList<>();
        }
        grafo[v].add(u);
    }

    static List<Pair<Integer, Integer>> encontrarPuntosImportantes(int n, int limite) {
        tiempo = 0;
        visitado = new int[n];
        bajo = new int[n];
        padre = new int[n];
        componentesGeneradas = new int[n];

        Arrays.fill(visitado, -1);
        Arrays.fill(padre, -1);

        for (int i = 0; i < n; i++) {
            if (visitado[i] == -1) {
                dfsVisitar(i);
            }
        }

        List<Pair<Integer, Integer>> puntosImportantes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (componentesGeneradas[i] > 0) {
                puntosImportantes.add(new Pair<>(i, componentesGeneradas[i]));
            }
        }

        puntosImportantes.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        return puntosImportantes.subList(0, Math.min(limite, puntosImportantes.size()));
    }

    static void dfsVisitar(int v) {
        int hijos = 0;
        visitado[v] = bajo[v] = ++tiempo;
        if(grafo[v] != null) {
            for (int u : grafo[v]) {
                if (visitado[u] == -1) {
                    hijos++;
                    padre[u] = v;
                    dfsVisitar(u);
                    bajo[v] = Math.min(bajo[v], bajo[u]);

                    if (padre[v] == -1 && hijos > 1) {
                        componentesGeneradas[v] = hijos;
                    }

                    if (padre[v] != -1 && bajo[u] >= visitado[v]) {
                        componentesGeneradas[v]++;
                    }
                } else if (u != padre[v]) {
                    bajo[v] = Math.min(bajo[v], visitado[u]);
                }
            }
        }

        if (componentesGeneradas[v] > 0) {
            componentesGeneradas[v]++;
        } else if (grafo[v] != null && grafo[v].size() > 0) { // caso que solo divide 1
            componentesGeneradas[v] = 1;
        }
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
    }


}