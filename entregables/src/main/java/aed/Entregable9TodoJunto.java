package aed;

import java.util.*;

public class Entregable9TodoJunto {
    static int [][] valores = {{0,1,2,3,4,5,4,3,2,1} , {1,0,1,2,3,4,5,4,3,2} , {2,1,0,1,2,3,4,5,4,3} , {3,2,1,0,1,2,3,4,5,4} , {4,3,2,1,0,1,2,3,4,5} ,
            {5,4,3,2,1,0,1,2,3,4} , {4,5,4,3,2,1,0,1,2,3} , {3,4,5,4,3,2,1,0,1,2} , {2,3,4,5,4,3,2,1,0,1} , {1,2,3,4,5,4,3,2,1,0}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        for(int k = 0; k < c; k++){
            int n = scanner.nextInt();

            Grafo_Pesado2 grafo = new Grafo_Pesado2(n);
            HashMap<Integer, String> numerosDeCadaPos= new HashMap<Integer, String>();

            int rolls =0;

            for(int i = 0 ; i < n ; i++){
                String contra = scanner.next();
                numerosDeCadaPos.put(i,contra);
                for(int j = 0 ; j < i ; j++){
                    int pesoArista = calcularPeso(numerosDeCadaPos.get(j),contra);
                    grafo.addEdge(i,j,pesoArista);
                }
            }
            int nodoInicial = 0;
            int nodoInicialMinimo = Integer.MAX_VALUE;
            for(int i = 0 ; i < n ; i++){
                int pesocalculado =calcularPeso("0000",numerosDeCadaPos.get(i));
                if (pesocalculado<nodoInicialMinimo){
                    nodoInicial = i;
                    nodoInicialMinimo = pesocalculado;
                }
            }
            //grafo.printGraph();
            rolls += nodoInicialMinimo;
            rolls += grafo.primMST(nodoInicial);
            System.out.println(rolls);
        }


    }

    public static int calcularPeso(String numero1 , String numero2) {
        int peso = 0;


        for (int i=0 ; i<4 ; i++) {

            int digito1 = Character.getNumericValue(numero1.charAt(i));
            int digito2 = Character.getNumericValue(numero2.charAt(i));
            peso += valores[digito1][digito2];


        }

        return peso;
    }


}

class Grafo_Pesado2 {
    int v;
    ArrayList<ArrayList<HashMap<Integer, Integer> >> adj;
    Grafo_Pesado2(int v)
    {
        this.v = v;
        this.adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            this.adj.add(new ArrayList<>());
        }
    }
    // Function to add an Edge
    void addEdge(int u, int v, int weight)
    {
        this.adj.get(u).add(new HashMap<>());
        this.adj.get(u)
                .get(this.adj.get(u).size() - 1)
                .put(v, weight);

        this.adj.get(v).add(new HashMap<>());
        this.adj.get(v)
                .get(this.adj.get(v).size() - 1)
                .put(u, weight);
    }
    void printGraph()
    {
        for (int i = 0; i < this.v; i++) {
            System.out.println("\nNode " + i
                    + " makes an edge with ");
            for (HashMap<Integer, Integer> j :
                    this.adj.get(i)) {
                j.entrySet().forEach(
                        e
                                -> System.out.println(
                                "\tNode " + e.getKey()
                                        + " with edge weight "
                                        + e.getValue() + " "));
            }
        }
    }

    int primMST(int startNode) {
        int totalWeight = 0;

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        boolean[] visited = new boolean[v];

        pq.add(new AbstractMap.SimpleEntry<>(startNode, 0));

        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> node = pq.poll();
            int u = node.getKey();

            if (visited[u])
                continue;

            visited[u] = true;

            totalWeight += node.getValue();

            for (HashMap<Integer, Integer> neighbor : this.adj.get(u)) {
                for (Map.Entry<Integer, Integer> edge : neighbor.entrySet()) {
                    int v = edge.getKey();
                    int weight = edge.getValue();
                    if (!visited[v])
                        pq.add(new AbstractMap.SimpleEntry<>(v, weight));
                }
            }
        }

        return totalWeight;
    }


}