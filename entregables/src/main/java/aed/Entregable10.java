package aed;

import java.util.*;

public class Entregable10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {

            int cases = scanner.nextInt();
            int llegada = scanner.nextInt();
            scanner.nextLine();
            String[] lineaEntrada;
            lineaEntrada = scanner.nextLine().split(" ");
            int[] elevSpeed = new int[lineaEntrada.length];
            for (int i = 0; i < lineaEntrada.length; i++) {
                elevSpeed[i] = Integer.parseInt(lineaEntrada[i]);
            }
            int[][] elevPisos = new int[elevSpeed.length][];
            int largoTotal = 0;
            Boolean tienePisoCero = false;
            for (int i = 0; i < elevSpeed.length; i++) {
                lineaEntrada = scanner.nextLine().split(" ");
                largoTotal += lineaEntrada.length;
                elevPisos[i] = new int[lineaEntrada.length];

                for (int j = 0; j < lineaEntrada.length; j++) {
                    elevPisos[i][j] = Integer.parseInt(lineaEntrada[j]);
                }
                if (elevPisos[i][0] == 0) {
                    tienePisoCero = true;
                }
            }
            if (!tienePisoCero) {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            // hay q fijarse si hay un 0 para deolver imposible

            Grafo_Pesado3 grafo = new Grafo_Pesado3(largoTotal + 1);


            // Diccionario que que segun pos de grafo me diga numero de piso
            // Diccionario que segun numero de piso me diga pos de grafo
            // Diccionario que segun pos de grafo me diga de que ascensor es
            HashMap<Integer, Integer> posAPiso = new HashMap<Integer, Integer>();
            //ArrayList<HashMap<Integer, Integer>> pisoAPos = null;
            HashMap<Integer, ArrayList<Integer>> pisoAPos = new HashMap<Integer, ArrayList<Integer>>();

            HashMap<Integer, Integer> posAElev = new HashMap<Integer, Integer>();
            int l = 0;
            for (int k = 0; k < elevSpeed.length; k++) {
                for (int i = 0; i < elevPisos[k].length; i++) {
                    posAPiso.put(i + l, elevPisos[k][i]);
                    posAElev.put(i + l, k);


                    if (pisoAPos.containsKey(elevPisos[k][i])) {
                        for (Integer elemento : pisoAPos.get(elevPisos[k][i])) {
                            grafo.addEdge(elemento, i + l, 60);
                        }
                        pisoAPos.get(elevPisos[k][i]).add(i+l);
                    } else {
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        arrayList.add(i + l);
                        pisoAPos.put(elevPisos[k][i], arrayList);
                    }

                    for (int j = 0; j < i; j++) {
                        grafo.addEdge(i + l, j + l, elevSpeed[k] * (posAPiso.get(i+l)-posAPiso.get(j+l)));
                    }
                }
                l += elevPisos[k].length;
            }
            if(!pisoAPos.containsKey(llegada)){
                System.out.println("IMPOSSIBLE");
                continue;
            }
            // quiero que pueda elegir de donde arrancar de los ascensores que pasan por 0
            for (Integer elemento : pisoAPos.get(0)) {
                grafo.addEdge(grafo.v - 1, elemento, 0);
            }
            int[] resolucion = grafo.dijkstra(grafo.v - 1);
            int pisodedijastra = -1;
            int pisoquetengoqueirminimo = Integer.MAX_VALUE;
            for (Integer elemento : pisoAPos.get(llegada)) {
                if(pisoquetengoqueirminimo >= resolucion[elemento]){
                    pisoquetengoqueirminimo = resolucion[elemento];
                    pisodedijastra = elemento;
                }
            }
            if(pisoquetengoqueirminimo == Integer.MAX_VALUE){
                System.out.println("IMPOSSIBLE");
                continue;
            }
            if(resolucion[pisodedijastra]==Integer.MAX_VALUE){
                System.out.println("IMPOSSIBLE");
                continue;
            }
            System.out.println(resolucion[pisodedijastra]);

        }while(scanner.hasNext());
    }
    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    static class Grafo_Pesado3 {
        int v;
        public ArrayList<ArrayList<Pair>> adj;
        Grafo_Pesado3(int v) {
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
            this.adj.get(v).add(new Pair(u, weight));
        }

        int[] dijkstra(int src) {
            int[] dist = new int[v];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);
            pq.offer(new Pair(src, 0));

            while (!pq.isEmpty()) {
                int u = pq.poll().first;
                for (Pair edge : adj.get(u)) {
                    int v = edge.first;
                    int weight = edge.second;
                    if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + weight) {
                        dist[v] = dist[u] + weight;
                        pq.offer(new Pair(v, dist[v]));
                    }
                }
            }
            return dist;
        }
    }
    /*
    static class Grafo_Pesado3 {
        int v;
        public ArrayList<ArrayList<Pair >> adj; // contiene en la posicion del vertice v un map de a quien esta conectado y el peso
        Grafo_Pesado3(int v)
        {
            this.v = v;
            this.adj = new ArrayList<>();

            for (int i = 0; i < v; i++) {
                this.adj.add(new ArrayList<>());
            }
        }
        ArrayList<ArrayList<Pair>> vector(){
            return adj;
        }

        // Function to add an Edge
        void addEdge(int u, int v, int weight)
        {
            this.adj.get(u).add(new Pair(v, weight));

            this.adj.get(v).add(new Pair(u, weight));
        }

        }
    int[] dijkstra(int src) {
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().first;
            for (Pair edge : adj.get(u)) {
                int v = edge.first;
                int weight = edge.second;
                if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }
        return dist;
    }

        static class Pair {
            int vertex;
            int weight;

            Pair(int v, int w) {
                vertex = v;
                weight = w;
            }
        }

     */
}
